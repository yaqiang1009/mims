package com.wnxy.hospital.mims.service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.DoubleStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.wnxy.hospital.mims.entity.PhMedicineClass;
import com.wnxy.hospital.mims.entity.PhMedicineClassExample;
import com.wnxy.hospital.mims.entity.PhMedicines;
import com.wnxy.hospital.mims.mapper.PhMedicineClassMapper;
import com.wnxy.hospital.mims.mapper.PhMedicinesMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class PhServiceTest {

	@Autowired
	ApplicationContext ac;
	PhMedicineClassMapper phMedicineClassMapper;
	PhMedicinesMapper phMedicinesMapper;

	@Before
	public void before() {
		phMedicineClassMapper = (PhMedicineClassMapper) ac.getBean("phMedicineClassMapper");
		phMedicinesMapper = (PhMedicinesMapper) ac.getBean("phMedicinesMapper");
	}

	@Test
	public void randomtest() {
		Random r = new Random();
		DecimalFormat df = new DecimalFormat("0.00");
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fm = sdf.format(now);
		try {
			Date date = sdf.parse(fm);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=1;i<=20;i++) {
			double bb = r.nextDouble()*100;
			Double a = Double.parseDouble(df.format(bb));
			//System.out.println(a);
		}
	}
	// 药品类别初始化
	@Test
	public void medicineClassInit() {
		String[] mclasses = { "抗生素类药品", "心脑血管用药", "消化系统用药", "呼吸系统用药", "泌尿系统用药", "血液系统用药", "五官科用药", "抗风湿类药品", "注射剂类药品",
				"糖尿病用药", "激素类药品", "皮肤科用药", "妇科用药", "抗肿瘤用药", "抗精神病药品", "清热解毒药品", "受体激动阻断药和抗过敏药", "滋补类药品", "维生素、矿物质药品" };

		for (int i = 0; i < mclasses.length; i++) {
			PhMedicineClass pmc = new PhMedicineClass(UUID.randomUUID().toString(), mclasses[i]);
			phMedicineClassMapper.insert(pmc);
		}
	}
	@Test
	// 药品信息初始化
	public void phMedicineInit() {
		String[] medicines = { "先锋5(头孢唑林)", "先锋6(头孢拉定)", "先锋必(头孢哌酮)", "痢特灵(呋喃唑酮)", "百炎净(复方新诺明)", "速尿片(呋塞米)",
				"阿司匹林(乙酰水杨酸)", "氟肽酸(诺氟沙星)", "胃复安(甲氧氯普胺)", "胃舒平(氢氧化铝)", "吗丁啉(多潘立酮)", "舒喘灵(硫酸沙丁胺醇)", "咳必清(喷托维林)",
				"克罗米芬(枸橼酸氯米芬)", "三苯氧胺(枸橼酸他莫昔芬)", "安宫黄体酮(醋酸甲羟孕酮)", "卵巢素(乙烯雌酚)", "催产素(缩宫素)", "扑尔敏(马来酸氯苯那敏)", "止血芳酸(氨甲苯酸)",
				"止血散(酸磺乙胺)", "强的松(醋酸泼尼松)", "扶他林(双氯芬酸二乙胺乳胶剂)", "利宁格(格列齐特缓释片)", "莱美清(加替沙星注射液)", "同息通-A(曲安萘德注射液)",
				"凯思宁(血塞通注射液)", "益替欣(注射用头孢替唑钠)", "替他欣(注射用盐酸头孢替安)", "非那根(复方愈创木酚磺酸钾口服溶液)", "食母生(干酵母)", "得蒲生(克林霉素)",
				"胺律酮(盐酸胺碘酮)", "阿拉明(重酒石酸河羟腔)", "倍他乐克(酒石酸美托洛尔)", "贺谱丁(拉米夫定)", "文迪雅(罗格列酮)", "释糖平(阿卡波糖)　潘生丁(双密达莫)",
				"特普宁(头孢克肟颗粒)", "西乐葆(塞来昔布胶囊)", "敏使朗(甲磺酸倍他可汀片)", "黛力新(氟哌噻吨美利曲辛片)", "凯莱克林(盐酸克林霉素棕榈酸酯分散片)", "波依定(非洛地平缓释片)",
				"奥必欣(坎地沙坦酯分散片)", "络活喜(苯磺酸氨氯地平片)", "欣络平(甲磺酸氨氯地平片)", "科苏(厄贝沙坦片)", "耐信(埃索美拉唑镁肠溶片)", "洛赛克(奥美拉唑镁肠溶片)",
				"兰悉多(兰索拉唑片)", "雷宁(氯雷他定分散片)", "洛丁新(盐酸贝那普利片)", "洛普欣(果糖二磷酸钠片)", "万艾可(枸橼酸西地那非片)", "诺和龙(瑞格列奈片)",
				"都可喜(阿米三嗪萝巴新片)", "美多芭(多巴丝肼片)", "洁维乐(磷酸铝凝胶)", "肯特令(蒙脱石散)", "立力定(盐酸非索非那定胶囊)", "仁苏(罗红霉素胶囊)", "西乐欣(阿奇霉素片)",
				"凯莱止(盐酸依匹斯汀胶囊)", "伏乐新(头孢呋辛酯片)", "竹林胺(盐酸酚苄明片)", "里素劳(酮康唑片)", "斯皮仁诺(伊曲康唑胶囊)" };
		//查询出所有药品类别id
		PhMedicineClassExample pmce = new PhMedicineClassExample();
		List<PhMedicineClass> phClass = phMedicineClassMapper.selectByExample(pmce);
		//药品包装
		String[] mtype = {"盒","瓶","片","包"};
		DecimalFormat df = new DecimalFormat("0.00");
		
		for(int i=0;i<medicines.length;i++) {
			Random r = new Random();
			int j = r.nextInt(4);
			r.nextDouble();
			PhMedicines pm = new PhMedicines();
			pm.setMedicineId(UUID.randomUUID().toString());
			pm.setMedicineName(medicines[i]);
			pm.setMedicineType(mtype[j]);
			//默认供应商id为54321
			pm.setSupplierId("54321");
			pm.setPrice(Double.parseDouble(df.format(r.nextDouble()*100)));
			pm.setBatchNo(UUID.randomUUID().toString());
			pm.setProduceDate(new Date());
			pm.setUsefulDate("3年");
			pm.setContain("成分暂定");
			pm.setClassId(phClass.get(r.nextInt(phClass.size())).getClassId());
			phMedicinesMapper.insertSelective(pm);
		}
		
	}
}
