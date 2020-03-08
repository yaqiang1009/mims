package com.wnxy.hospital.mims.entity.ph.page;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * 将分页数据封装到PhPageBean，加上泛型，方便前台分页
 * @author HL
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PhPageBean<T> {
	//分页数据
	private List<T> beanlist;
	//页面索引
	private int pageIndex;
	//页大小
	private int pageSize=5;
	//分页展示数量
	private int indexSize=5;
	//总页数
	//private int totalPage;
	//总条数
	private int totalCount;
	//开始页
	private int beginPage;
	//结束页
	private int endPage;
	//分页链接点击后带查询项参数查询
	//private String url;
	//总页数=总数量/页大小
	public int getTotalPage() {
		//totalCount取模pageSize，整除则取值，有余则+1
		return (totalCount%pageSize==0)?(totalCount/pageSize):((totalCount/pageSize)+1);
	}
	//判断开始页和结束页
	public void setBeginPageAndEndPage() {
		//总页数小于分页显示数量
		if(getTotalPage()<indexSize) {
			beginPage = 1;
			endPage = getTotalPage();
		} else {
			//只显示指定的indexSize条分页链接，开始页和结束页都是变量
			beginPage = pageIndex - indexSize/2;
			endPage = pageIndex + (indexSize-1)/2;
			//处理开始页越界，不能小于第一页
			if (beginPage < 1) {
				beginPage = 1;
				endPage = indexSize;
			}
			//处理结束页越界，不能大于总页数
			if (endPage > getTotalPage()) {
				endPage = getTotalPage();
				beginPage = getTotalPage() - (indexSize-1);
			}
		}
	}
}

