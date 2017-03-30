package com.offer.util;

import java.io.File;


public interface Code {

	public static String systemPath = Code.class.getClassLoader().getResource("").getPath().replace("WEB-INF/classes/", "");
	
	public static String fangwenPath = "http://localhost:8080/hibernateMvc/" ;
	
	public static String[] welfares = new String[]{ "股票期权","绩效奖金","弹性工作","年底双薪","带薪年假","定期体检","年终分红","员工分享","午餐补贴","专项奖金" };
	
	public static String[] status = new String[]{ "停用", "未提交", "待审批", "审批不通过", "审批通过", "已下线" };
}