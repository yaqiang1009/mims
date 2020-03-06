package com.wnxy.hospital.mims.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.sqlsource.PageStaticSqlSource;
import com.wnxy.hospital.mims.entity.StIn;
import com.wnxy.hospital.mims.entity.StItem;
import com.wnxy.hospital.mims.entity.StMedicines;
import com.wnxy.hospital.mims.entity.StOut;
import com.wnxy.hospital.mims.entity.Stock;
import com.wnxy.hospital.mims.entity.Supplier;
import com.wnxy.hospital.mims.exception.StException;
import com.wnxy.hospital.mims.service.stock.StInService;
import com.wnxy.hospital.mims.service.stock.StItemService;
import com.wnxy.hospital.mims.service.stock.StMedicinesService;
import com.wnxy.hospital.mims.service.stock.StOutService;
import com.wnxy.hospital.mims.service.stock.StockService;
import com.wnxy.hospital.mims.service.stock.SupplierService;

import lombok.extern.slf4j.Slf4j;

//处理器
@Slf4j
@Controller
public class StockController {
	@Autowired
	StockService stockService;
	@Autowired
	StMedicinesService stMedicinesService;
	@Autowired
	StOutService stOutService;
	@Autowired
	StInService stInService;
	@Autowired
	StItemService stItemService;
	@Autowired
	SupplierService supplierService;

	/**
	 * 
	 * @param pageindex 页码
	 * @param pagesize  页大小 分页查找
	 */
	@RequestMapping("/st_stock/{pageindex}/{pagesize}")
	public String st_selectStockAll(Model model, @PathVariable("pageindex") int pageindex,
			@PathVariable("pagesize") int pagesize) {
		try {
			PageInfo<Stock> pageinfo = stockService.selectPageStock(pageindex, pagesize);
			List<Stock> stocks = pageinfo.getList();
			StMedicines foundMedicine = null;
			for (Stock s : stocks) {
				foundMedicine = stMedicinesService.selectById(s.getMedicineId());
				s.setMedicines(foundMedicine);
			}

			model.addAttribute("pageinfo", pageinfo);
			return "st_stock";
		} catch (StException e) {
			model.addAttribute("msg", e.getMessage());
			return "st_msg";
		}
	}

	/**
	 * 
	 * @param model
	 * @param id    stock_id，仓库编号 通过库存编号查询对应药品并进行装配，并返回给页面
	 */

	@RequestMapping("/st_out/{id}")
	public String st_out(Model model, @PathVariable("id") String id) {
		try {
			Stock stock = stockService.selectById(id);
			StMedicines medicine = stMedicinesService.selectById(stock.getMedicineId());

			stock.setMedicines(medicine);
			model.addAttribute("stock", stock);

			return "st_out";
		} catch (StException e) {
			model.addAttribute("msg", e.getMessage());
			return "st_msg";
		}
	}

	@RequestMapping("/st_in/{id}")
	public String st_in(Model model, @PathVariable("id") String id) {
		try {
			Stock stock = stockService.selectById(id);
			StMedicines medicine = stMedicinesService.selectById(stock.getMedicineId());

			stock.setMedicines(medicine);
			model.addAttribute("stock", stock);

			return "st_in";
		} catch (StException e) {
			model.addAttribute("msg", e.getMessage());
			return "st_msg";
		}
	}

	/**
	 * 根据搜索框输入名字查询
	 */
	@RequestMapping("/st_out")
	public String st_outByName(Model model, HttpServletRequest request) {
		try {
			Stock foundStock = null;
			// 参数
			String mname = request.getParameter("mname");
			// 先通过药名查询药id
			List<StMedicines> stMedicines = stMedicinesService.selectByName(mname);
			List<Stock> stocks = new ArrayList<Stock>();
			// 通过药id，查询对应的仓库信息
			for (StMedicines s : stMedicines) {
				foundStock = stockService.selectByMid(s.getMedicineId());
				foundStock.setMedicines(s);
				stocks.add(foundStock);
			}
			model.addAttribute("stocks", stocks);
			model.addAttribute("mname",mname);
			return "st_stock2";
		} catch (StException e) {
			model.addAttribute("msg", e.getMessage());
			return "st_msg";
		}
	}

	/**
	 * 
	 * @param mid 药品的id 进行出库操作，主要修改数据库数量 出库时，要生产出库订单
	 */
	@Transactional
	@RequestMapping("/st_doOut/{mid}")
	public String st_doOut(Model model, @PathVariable("mid") String mid, HttpServletRequest request) {
		try {

			Integer num = Integer.parseInt(request.getParameter("num"));

			Stock lessStock = stockService.selectByMid(mid);
			StItem stItem = new StItem(UUID.randomUUID().toString(), lessStock.getStockId(), null,
					lessStock.getMedicineId(), null, num);
			stItemService.insertStItem(stItem);
			StOut stOut = new StOut(UUID.randomUUID().toString(), stItem.getItemId(), stItem, new Date());
			stOutService.insertStOut(stOut);
			lessStock.setMedicineNum(num);
			stockService.lessStock(lessStock);
			if (stockService.selectByMid(mid).getMedicineNum() < 10) {
				model.addAttribute("msg", "出库成功，库存数量已小于最低标准，请及时添加");
				return "st_msg";
			}
			model.addAttribute("msg", "出库成功，点击返回主页");
			return "st_msg";
		} catch (StException e) {
			model.addAttribute("msg", "出库异常");
			return "st_msg";
		}
	}

	/**
	 * 入库方法，
	 */
	@Transactional
	@RequestMapping("/st_doIn/{mid}")
	public String st_doIn(Model model, @PathVariable("mid") String mid, HttpServletRequest request) {
		try {

			Integer num = Integer.parseInt(request.getParameter("num"));

			Stock addStock = stockService.selectByMid(mid);
			StItem stItem = new StItem(UUID.randomUUID().toString(), addStock.getStockId(), null,
					addStock.getMedicineId(), null, num);
			// 把条目信息添加到库中
			stItemService.insertStItem(stItem);
			// 把入库单信息存到库中
			StIn stIn = new StIn(UUID.randomUUID().toString(), "1", null, stItem.getItemId(), stItem, new Date());
			stInService.insertStIn(stIn);
			// 修改库存数量
			addStock.setMedicineNum(num);
			stockService.addStock(addStock);
			// 回到页面
			model.addAttribute("msg", "入库成功，点击返回主页");
			return "st_msg";
		} catch (StException e) {
			model.addAttribute("msg", "入库异常");
			return "st_msg";
		}
	}

	@ResponseBody
	@RequestMapping("/st_selin/{pageindex}/{pagesize}/{mname}")
	public PageInfo<StIn> st_selin(@PathVariable("pageindex") int pageindex, @PathVariable("pagesize") int pagesize,
			@PathVariable("mname") String mname) {
		try {
			System.out.println(pageindex+"---"+pagesize+"---"+mname);
			List<StMedicines> stMedicines = new ArrayList<StMedicines>();
			if (!"aaa".equals(mname)) {
				stMedicines = stMedicinesService.selectByName(mname);
			} else {
				stMedicines = stMedicinesService.selectAll();
			}
			if(stMedicines==null) {
				return null;
			}
			
			
			//通过药品名得到主键
			//通过药品主键查询条目
			List<StItem> stItems=new ArrayList<StItem>();
			
			List<StItem> list=new ArrayList<StItem>();
			for(StMedicines s:stMedicines) {
				list=stItemService.selectByMid(s.getMedicineId());
				
				for(StItem st:list) {
					stItems.add(st);
				}
			}
			//装配stItems集合
			//System.out.println("control:"+stItems);
			Supplier supplier;
			StItem stItem;
			StMedicines stMedicine;
			
			PageHelper.startPage(pageindex, pagesize);
			List<StIn> stIns = stInService.selectByItems(stItems);
			PageInfo<StIn> pageinfo=new PageInfo<StIn>(stIns);
			
			stIns=pageinfo.getList();
			System.out.println(stIns);
			for (StIn s : stIns) {
				// 装配供应商
				supplier = supplierService.selectBySid(s.getSupplierId());
				s.setSupplier(supplier);
				// 条目
				stItem = stItemService.selectBySid(s.getItemId());
				stMedicine = stMedicinesService.selectById(stItem.getMedicineId());
				// 条目中的药
				stItem.setMedicines(stMedicine);
				s.setItem(stItem);

			}
			
			return pageinfo;
		} catch (StException e) {
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 同步请求模板
	 * 
	 * @RequestMapping("/mycont1") public String mycont1(Model
	 * model,HttpServletRequest request) {
	 * 
	 * return "aaa"; }
	 */

	/*
	 * 异步请求模板
	 * 
	 * @ResponseBody
	 * 
	 * @RequestMapping("/mycont1") public String mycont1(HttpServletRequest request)
	 * {
	 * 
	 * return "aaa"; }
	 */

}
