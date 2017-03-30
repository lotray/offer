package com.offer.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.offer.model.Guwen;
import com.offer.model.OfferEmail;
import com.offer.model.OfferFirm;
import com.offer.model.OfferFirmChoose;
import com.offer.model.OfferFirmInformation;
import com.offer.model.OfferInvite;
import com.offer.model.OfferInviteChat;
import com.offer.model.OfferJob;
import com.offer.model.OfferPhoto;
import com.offer.model.OfferUser;
import com.offer.service.BaseService;
import com.offer.service.OfferCollectService;
import com.offer.service.OfferFirmInformationService;
import com.offer.service.OfferFirmService;
import com.offer.service.OfferInviteChatService;
import com.offer.service.OfferInviteService;
import com.offer.service.OfferJobService;
import com.offer.service.OfferPhotoService;
import com.offer.service.OfferUserInformationService;
import com.offer.service.OfferUserService;
import com.offer.util.ChinaInitial;
import com.offer.util.Code;
import com.offer.util.Encryption;
import com.offer.util.FileUtils;
import com.offer.util.GeneratePDF;
import com.offer.util.Msgtest;
import com.offer.util.SendEmail;

@Controller
public class OfferFirmController extends BaseController {
	
	private void allMethods() {
		String aString = null;
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		MultipartFile[] files = null;
		interviewPage1(request, aString);//用户面试邀请页面1初始化
		interviewPage2(request, aString);//用户面试邀请页面2初始化
		interviewPage3(request, aString);//用户面试邀请页面3初始化
		saveinterview3(request, aString);//用户面试邀请页面3保存
		finduserPage1(request, aString);//筛选候选人筛选条件初始化
		savefinduser1(request, aString);//筛选候选人筛选条件保存
		findusersum1(request, aString);//按条件筛选候选人
		selectfindusersum1(request, aString);//感兴趣、收藏
		findUserInformation(request, aString);//查看候选人信息
		createOfferInvite(request, aString);//发送面试邀请
		inputFirmResumeAddPage(request);//企业信息填报初始化
		firmMember(request, aString);//选择自己公司
		saveFirmResumeAddPage(request, aString);//企业信息填报保存
		uploadFile(request, files, files);//企业信息图片保存
		userviewPage1(request, aString);//企业面试邀请页面1初始化
		userviewPage2(request, aString);//企业面试邀请页面2初始化
		userviewPage3(request, aString);//企业面试邀请页面3初始化
		saveuserview3(request, aString);//企业面试邀请页面3保存面试信息
		changeUserStatus(request, aString);//后台企业账号设置页面修改状态
		changefirmStatus(request, aString);//后台企业改变状态
//		firmzhaopin1(request, aString);//后台企业账号设置页面修改状态
		examinefirmPage1(request, aString);//企业审核失败重新提交页面
	}

   @ResponseBody
   @RequestMapping(value = "/register/firm", produces = "application/json")
   public Map<String, Object> registerFirm(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         form.get("name");
         if (!isEmpty(request)) { return toJson(null); }
         offerFirmService.saveOfferFirm(request);
         

         return toJson(SUCCESS);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/register/firmByEmail")
   public Map<String, Object> findFirmByEmail(HttpServletRequest request) {
      try {
         if (!isEmpty(request)) { return toJson(null); }
         String email = request.getParameter("email");
         return toJson(offerFirmService.findByEmail(email));
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/login/firm")
   public Map<String, Object> login(HttpServletRequest request) {
      try {
         List<OfferFirm> offerFirms = offerFirmService.findAllOfferFirms();
         return toJson(offerFirms);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/test/getAll")
   public Map<String, Object> alllogin(HttpServletRequest request) {
      try {
         List<OfferFirm> offerFirms = offerFirmService.findAllOfferFirms();
         return toJson(offerFirms);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/test/getByName")
   public Map<String, Object> seachName(HttpServletRequest request) {
      try {
         String name = request.getParameter("name");
         request.getSession();
         httpSession.getAttribute("name");
         httpSession.setAttribute("name", name);
         //			List<OfferFirm> offerFirms = offerFirmService.findByName(name);
         //			return toJson(offerFirms);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   @ResponseBody
   @RequestMapping(value = "/test/pdf")
   public Map<String, Object> testpdf(HttpServletResponse response, HttpServletRequest request) {
      try {
         Map<String, List<Map<String, String>>> map = new HashMap<String, List<Map<String,String>>>();
         List<Map<String, String>> list = new ArrayList<Map<String,String>>();
         List<Map<String, String>> list1 = new ArrayList<Map<String,String>>();
         List<Map<String, String>> list2 = new ArrayList<Map<String,String>>();
         List<Map<String, String>> list3 = new ArrayList<Map<String,String>>();
         List<Map<String, String>> list4 = new ArrayList<Map<String,String>>();
         List<Map<String, String>> list5 = new ArrayList<Map<String,String>>();
         List<Map<String, String>> list6 = new ArrayList<Map<String,String>>();
         List<Map<String, String>> list7 = new ArrayList<Map<String,String>>();
         List<Map<String, String>> list8 = new ArrayList<Map<String,String>>();
         Map<String, String> map1 = new HashMap<String, String>();
         map1.put("content", "吴广德");
         list.add(map1);
         Map<String, String> phone = new HashMap<String, String>();
         phone.put("content", "1234567890");
         list1.add(phone);
         Map<String, String> emil = new HashMap<String, String>();
         emil.put("content", "1234567890@qq.com");
         list2.add(emil);
         Map<String, String> info = new HashMap<String, String>();
         info.put("content", "女 24岁");
         Map<String, String> info1 = new HashMap<String, String>();
         info1.put("content", "通讯工程专业");
         list3.add(info);
         list3.add(info1);
         
         Map<String, String> skill = new HashMap<String, String>();
         skill.put("content", "技能一");
         Map<String, String> skill1 = new HashMap<String, String>();
         skill1.put("content", "技能二");
         list4.add(skill);
         list4.add(skill1);
         
         Map<String, String> ex = new HashMap<String, String>();
         ex.put("companyName", "广州乐闻教育科技中心");
         ex.put("workTime", "2015年7月-现在");
         ex.put("jobName", "java工程师");
         ex.put("jobDesc", "负责数据库设计，程序设计，需求分析");
         list5.add(ex);
         
         Map<String, String> pj = new HashMap<String, String>();
         pj.put("pjName", "信息管理系统项目");
         pj.put("pjTime", "2015年7月-现在");
         pj.put("pjjob", "java工程师");
         pj.put("pjdesc", "负责数据库设计，程序设计，需求分析");
         list6.add(pj);
         
         Map<String, String> stex = new HashMap<String, String>();
         stex.put("content", "教育经历");
         list7.add(stex);
         
         Map<String, String> personDesc = new HashMap<String, String>();
         personDesc.put("content", "个人描述");
         list8.add(personDesc);
         
         map.put("name", list);
         map.put("phone", list1);
         map.put("emil", list2);
         map.put("info", list3);
         map.put("skillContent", list4);
         map.put("exContent", list5);
         map.put("pjContent", list6);
         map.put("stexContent", list7);
         map.put("personDesc", list8);
         
         generatePDF.downloadPDF(response, map);
         return null;
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/getFirmInformation")
   public Map<String, Object> getFirmInformation(HttpSession session) {
      try {
         String id = session.getAttribute("id").toString();
         List<Map<String, String>> list = offerFirmService.getFirmInformation(id);
         if (list.size() > 0) { return toJson(list); }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/updateOfferFirmInformation")
   public Map<String, Object> updateOfferFirmInformation(HttpSession session, HttpServletRequest request) {
      try {
         String id = session.getAttribute("id").toString();
         offerFirmInformationService.updateOfferFirmInformation(id, request);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/editOfferFirmInformation")
   public Map<String, Object> editOfferFirmInformation(HttpSession session) {
      try {
         String id = session.getAttribute("id").toString();
         List<Map<String, String>> list = offerFirmInformationService.editOfferFirmInformation(Integer.valueOf(id));
         if (list.size() > 0) { return toJson(list); }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/viewOfferFirmInformation")
   public Map<String, Object> viewOfferFirmInformation(HttpSession session) {
      try {
         String id = session.getAttribute("id").toString();
         List<Map<String, String>> list = offerFirmInformationService.editOfferFirmInformation(Integer.valueOf(id));
         if (list.size() > 0) { return toJson(list); }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/editOfferUserJobId", produces = "application/json")
   public Map<String, Object> editOfferUserJobId(@RequestBody String data) {//需求问卷
      try {
         putToForm(data);
//         List<Map<String, Object>> list = offerFirmInformationService.editOfferFirmJobId(Integer.valueOf(form.get("id")));
         List<OfferJob> offerJobs = offerUserService.editOfferUserJobId(Integer.valueOf(form.get("id")));
         if (offerJobs.size() > 0) { return toJson(offerJobs); }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   @ResponseBody
   @RequestMapping(value = "/firm/updateOfferFirmJobId", produces = "application/json")
   public Map<String, Object> updateOfferFirmJobId(@RequestBody String data) {//需求问卷(需要修改)
      try {
         putToForm(data);
//         OfferUser offerUser = offerUserService.getOfferUser(form.get("id"));
//         offerUser.setOfferJobId(Integer.valueOf(form.get("firmJobId")));
//         offerUserService.updateOfferUser(offerUser);
         OfferFirmInformation offerFirmInformation = offerFirmInformationService.getOfferFirmInformation(form.get("id")).get(0);
         offerFirmInformation.setFirmJobId(Integer.valueOf(form.get("firmJobId")));
         offerFirmInformationService.updateOfferFirmInformation(offerFirmInformation);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/getOfferUser", produces = "application/json")
   public Map<String, Object> getOfferUser(@RequestBody String data) {//获取当前用户信息
      try {
         putToForm(data);
         OfferUser offerUser = offerUserService.getOfferUser(form.get("id"));
         return toJson(offerUser);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/updateOfferUserName", produces = "application/json")
   public Map<String, Object> updateOfferUserName(@RequestBody String data) {//修改姓名
      try {
         putToForm(data);
         OfferUser offerUser = offerUserService.getOfferUser(form.get("id"));
         offerUser.setOfferUserName(form.get("offerUserName"));
         offerUserService.updateOfferUser(offerUser);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/updateOfferUserJobId", produces = "application/json")
   public Map<String, Object> updateOfferUserJobId(@RequestBody String data) {//修改用户的职位
      try {
         putToForm(data);
         OfferUser offerUser = offerUserService.getOfferUser(form.get("id"));
         offerUser.setOfferJobId(Integer.valueOf(form.get("offerUserJobId")));
         offerUserService.updateOfferUser(offerUser);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/updateOfferUserPassword", produces = "application/json")
   public Map<String, Object> updateOfferUserPassword(@RequestBody String data) {//修改密码
      try {
         putToForm(data);
         OfferUser offerUser = offerUserService.getOfferUser(form.get("id"));
         if (offerUser.getOfferUserPassword().equals(form.get("oldPassword"))) {
            offerUser.setOfferUserPassword(encryption.encryption(form.get("newPassword")));
            offerUserService.updateOfferUser(offerUser);
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/getOfferFirmTeam", produces = "application/json")
   public Map<String, Object> getOfferFirmTeam(@RequestBody String data) {//团队成员
      try {
         putToForm(data);
         List<OfferUser> offerUsers = offerUserService.getOfferFirmTeam(form);
         return toJson(offerUsers);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/getCandidate", produces = "application/json")
   public Map<String, Object> getCandidate(@RequestBody String data) {//所有候选人信息
      try {
         putToForm(data);
         List<Map<String, String>> list = offerUserService.getCandidate(form);
         return toJson(list);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/saveOfferCollect", produces = "application/json")
   public Map<String, Object> saveOfferCollect(@RequestBody String data) {//企业选择不感兴趣或收藏的候选人
      try {
         putToForm(data);
         offerCollectService.saveOfferCollect(form);
         return toJson(SUCCESS);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

//   @ResponseBody
//   @RequestMapping(value = "/firm/getOfferCollects", produces = "application/json")
//   public Map<String, Object> getOfferCollects(@RequestBody String data) {//获取收藏的候选人
//      try {
//         putToForm(data);
//         List<Map<String, String>> list = offerCollectService.getOfferCollectss(form);
//         return toJson(list);
//      }
//      catch (Exception e) {
//         e.printStackTrace();
//      }
//      return null;
//   }

   @ResponseBody
   @RequestMapping(value = "/firm/saveOfferInviteWithChat", produces = "application/json")
   public Map<String, Object> saveOfferInviteWithChat(@RequestBody String data) {//保存邀请的候选人和邀请信的信息
      try {
         putToForm(data);
         offerInviteService.saveOfferInviteWithChat(form);

      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }

   @ResponseBody
   @RequestMapping(value = "/firm/getOfferInvites", produces = "application/json")
   public Map<String, Object> getOfferInvites(@RequestBody String data) {//获取当前企业邀请的候选人
      try {
         putToForm(data);
         List<Map<String, String>> list = offerInviteService.getOfferInvites(form);
         return toJson(list);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/getOfferInvite", produces = "application/json")
   public Map<String, Object> getOfferInvite(@RequestBody String data) {//获取当前候选人的邀请信息
      try {
         putToForm(data);
         List<OfferInvite> offerInvite = offerInviteService.getOfferInvites(form.get("id"));
         return toJson(offerInvite);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/getOfferInviteChats", produces = "application/json")
   public Map<String, Object> getOfferInviteChats(@RequestBody String data) {//获取当前该inviteId的所有聊天数据
      try {
         putToForm(data);
         List<OfferInviteChat> offerInviteChats = offerInviteChatService.getOfferInviteChats(form);
         return toJson(offerInviteChats);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @ResponseBody
   @RequestMapping(value = "/firm/saveOfferInviteChatOrWithUpdateInvite", produces = "application/json")
   public Map<String, Object> saveOfferInviteChatOrWithUpdateInvite(@RequestBody String data) {//保存当前该企业的聊天数据,如果有企业撤销邀请,反馈面试结果
      try {
         putToForm(data);
         offerInviteChatService.saveOfferInviteChat(form);//保存聊天数据先,再去判断状态后是否保存到邀请表
         return toJson(SUCCESS);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   @ResponseBody
   @RequestMapping(value = "/test/Msg")
   public Map<String, Object> testMsg(HttpServletResponse response, HttpServletRequest request) {
      try {
         Msgtest.sendMsg();
         return null;
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }
   
   @ResponseBody
   @RequestMapping(value = "/firm/firmMember")
   public Map<String, Object> firmMember(HttpServletRequest request, @RequestBody String data) {
	   try {
		   OfferUser user = offerUserService.getOfferUser(Integer.valueOf(request.getSession().getAttribute("id").toString()));
		   user.setFirmId(Integer.valueOf(data));
		   baseService.saveObject(user);
		   return toJson(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return toJson(null);
   }
   
   //公司简历页面
   @ResponseBody
   @RequestMapping(value = "/firm/inputFirmResumeAddPage", produces = "application/json")
   public Map<String, Object> inputFirmResumeAddPage(HttpServletRequest request) {
	   try {
		   Map<String, Object> map = new HashMap<String, Object>();
		   
		   String offerUserId = request.getSession().getAttribute("id") + "";
         
         //判断公司邮箱
         OfferUser offerUser = offerUserService.getOfferUser(Integer.valueOf(offerUserId));
         if(offerUser == null){
        	 return toJson("login");
         }
         int status = Integer.valueOf(offerUser.getStatus());
         if (status != 4) {
            List<Map<String, String>> offerFirms = offerFirmService.findByEmail(offerUser.getOfferUserEmail());
            if(offerFirms != null && offerFirms.size() > 0){
               map.put("firmList", offerFirms);
            }
         }
         
         List<Map<String, String>> list = offerFirmService.getFirmInformation(offerUserId);

         putUserName(map, request);
         map.put("status", offerUser.getStatus());
		   
		   String firmAllName = list.get(0).get("firmAllName");
		   map.put("firmAllName", firmAllName);
		   String firmSimpleName = list.get(0).get("firmSimpleName");
		   map.put("firmSimpleName", firmSimpleName);
		   String firmWebLink = list.get(0).get("firmWebLink");
		   map.put("firmWebLink", firmWebLink);
		   String firmCity = list.get(0).get("firmCity");
		   map.put("firmCity", firmCity);
		   String firmAddress = list.get(0).get("firmAddress");
		   map.put("firmAddress", firmAddress);
		   String firmSeo = list.get(0).get("firmSeo");
		   map.put("firmSeo", firmSeo);
		   String produceDescript = list.get(0).get("produceDescript");
		   map.put("produceDescript", produceDescript);
		   String reportLink = list.get(0).get("reportLink");
		   map.put("inputCode", reportLink);
		   String firmDescript = list.get(0).get("firmDescript");
		   map.put("firmDescript", firmDescript);
		   String firmOneDescript = list.get(0).get("firmOneDescript");
		   map.put("firmOneDescript", firmOneDescript);
         String welfareId = list.get(0).get("welfareId");
         map.put("firmWelfare", welfareId);
		   
         String offerFirmId = String.valueOf(list.get(0).get("offerFirmId"));
         request.getSession().setAttribute("offerFirmId", offerFirmId);
         String offerFirmInformationId = String.valueOf(list.get(0).get("offerFirmInformationId"));
         request.getSession().setAttribute("offerFirmInformationId", offerFirmInformationId);
         String offerFirmTechologyId = String.valueOf(list.get(0).get("offerFirmTechologyId"));
         request.getSession().setAttribute("offerFirmTechologyId", offerFirmTechologyId);
         String offerFirmProduceId = String.valueOf(list.get(0).get("offerFirmProduceId"));
         request.getSession().setAttribute("offerFirmProduceId", offerFirmProduceId);
         String offerFirmReportId = String.valueOf(list.get(0).get("offerFirmReportId"));
         request.getSession().setAttribute("offerFirmReportId", offerFirmReportId);
         String offerFirmIntroduceId = String.valueOf(list.get(0).get("offerFirmIntroduceId"));
         request.getSession().setAttribute("offerFirmIntroduceId", offerFirmIntroduceId);
         String offerFirmWelfareId = String.valueOf(list.get(0).get("offerFirmWelfareId"));
         request.getSession().setAttribute("offerFirmWelfareId", offerFirmWelfareId);
		   
		   List<Map<String, String>> list1 = baseService.getOfferFirmSizeType();
		   List<Map<String, String>> firmsizeList = new ArrayList<Map<String, String>>();
		   for (Map<String, String> map2 : list1) {
			   Map<String, String> firmStageMap = new HashMap<String, String>();
				firmStageMap.put("id", String.valueOf(map2.get("id")));
				firmStageMap.put("value", map2.get("offerFirmSizeType"));
				firmsizeList.add(firmStageMap);
		   }
		   map.put("firmsizeList", firmsizeList);
		   
		   List<Map<String, String>> firmTeamSizeList = new ArrayList<Map<String, String>>();
		   for (Map<String, String> map2 : list1) {
			   Map<String, String> firmStageMap = new HashMap<String, String>();
			   firmStageMap.put("id", String.valueOf(map2.get("id")));
			   firmStageMap.put("value", map2.get("offerFirmSizeType"));
			   firmTeamSizeList.add(firmStageMap);
		   }
		   map.put("firmTeamSizeList", firmTeamSizeList);
		   
		   List<Map<String, String>> firmStageList = new ArrayList<Map<String, String>>();
		   List<Map<String, String>> list2 = baseService.getOfferStage();
			for (Map<String, String> map2 : list2) {
				Map<String, String> firmStageMap = new HashMap<String, String>();
				firmStageMap.put("id", String.valueOf(map2.get("id")));
				firmStageMap.put("value", map2.get("offerStage"));
				firmStageList.add(firmStageMap);
			}
         map.put("firmStageList", firmStageList);
			
		   List<Map<String, String>> list3 = baseService.getOfferAreaType();
		   List<Map<String, String>> firmAreaList = new ArrayList<Map<String, String>>();
		   for (Map<String, String> map2 : list3) {
			   Map<String, String> firmareaMap = new HashMap<String, String>();
				firmareaMap.put("id", String.valueOf(map2.get("id")));
				firmareaMap.put("value", map2.get("offerAreaType"));
				firmAreaList.add(firmareaMap);
			}
			map.put("firmAreaList", firmAreaList);
			
			List<Map<String, String>> firmCreateYearList = new ArrayList<Map<String, String>>();
			Calendar a=Calendar.getInstance();
			int year = a.get(Calendar.YEAR);
			for(int i = year - 50; i < year; i++){
				Map<String, String> firmCreateYearMap = new HashMap<String, String>();
				firmCreateYearMap.put("id", String.valueOf(i));
				firmCreateYearMap.put("value", String.valueOf(i) + "年");
				firmCreateYearList.add(firmCreateYearMap);
			}
			map.put("firmCreateYearList", firmCreateYearList);
		   
         map.put("firmAreaValue", list.get(0).get("areaId"));
         map.put("firmCreateYearValue", list.get(0).get("firmCreateYear"));
         map.put("firmTeamSizeValue", list.get(0).get("firmTeamSize"));
         map.put("firmSizeValue", list.get(0).get("firmSize"));
         map.put("firmStageValue", list.get(0).get("firmStage"));
         
         if(offerFirmId != null && !"".equals(offerFirmId) && !"null".equals(offerFirmId)){
        	 List<Map<String, String>> photoList = new ArrayList<Map<String, String>>();
        	 List<OfferPhoto> pList = new ArrayList<OfferPhoto>();
        	 pList = offerPhotoService.findByFirmdId(offerFirmId);
        	 List<OfferPhoto> iPhotos = offerPhotoService.findByFirmIId(offerFirmId);
        	 if(iPhotos.size() == 1){
        	    map.put("logoId", iPhotos.get(0).getId().toString());
        		 map.put("logo", "../upload/photo/"+iPhotos.get(0).getPhotoSavename());
        	 }
        	 for(OfferPhoto photo : pList){
        		 Map<String, String> photoMap = new HashMap<String, String>();
        		 photoMap.put("id", photo.getId().toString());
        		 photoMap.put("photo", "../upload/photo/"+photo.getPhotoSavename());
        		 photoList.add(photoMap);
        	 }
        	 map.put("huanjing", photoList);
         }
		   return toJson(map);
	  }
	  catch (Exception e) {
	     e.printStackTrace();
	  }
	  return toJson(SUCCESS);
   }
   
   @ResponseBody
   @RequestMapping(value = "/firm/saveFirmResumeAddPage", produces = "application/json")
   public Map<String, Object> saveFirmResumeAddPage(HttpServletRequest request, @RequestBody String data) {
	   try {
		   putToForm(data);
		   String offerUserId = request.getSession().getAttribute("id") + "";
		   String offerFirmId = request.getSession().getAttribute("offerFirmId") + "";
		   String offerFirmInformationId = request.getSession().getAttribute("offerFirmInformationId") + "";
		   String offerFirmIntroduceId = request.getSession().getAttribute("offerFirmIntroduceId") + "";
		   String offerFirmTechologyId = request.getSession().getAttribute("offerFirmTechologyId") + "";
		   String offerFirmProduceId = request.getSession().getAttribute("offerFirmProduceId") + "";
		   String offerFirmReportId = request.getSession().getAttribute("offerFirmReportId") + "";
		   String offerFirmWelfareId = request.getSession().getAttribute("offerFirmWelfareId") + "";
		   form.put("offerUserId", offerUserId);
		   form.put("offerFirmId", offerFirmId);
		   form.put("offerFirmInformationId", offerFirmInformationId);
		   form.put("offerFirmIntroduceId", offerFirmIntroduceId);
		   form.put("offerFirmTechologyId", offerFirmTechologyId);
		   form.put("offerFirmProduceId", offerFirmProduceId);
		   form.put("offerFirmReportId", offerFirmReportId);
		   form.put("offerFirmWelfareId", offerFirmWelfareId);
		   offerFirmService.saveOfferFirm(form);
		   OfferUser offerUser = offerUserService.getOfferUser(offerUserId);
		   String status = offerUser.getStatus();
		   request.getSession().setAttribute("firmId", offerFirmId);
		   if(form.get("photoIds") == null){
			   return toJson(SUCCESS);
		   }
		   String[] ids = form.get("photoIds").split(",");
		   Map<String, String> delIds = new HashMap<String, String>();
		   for(int i = 0; i < ids.length; i++){
			   if(!"".equals(ids[i])){
				   delIds.put(ids[i], "");
			   }
		   }
		   //List<OfferPhoto> offerPhotos = offerPhotoService.findByFirmIId(offerFirmInformationId);
		   List<OfferPhoto> offerPhotos = offerPhotoService.findByFirmdId(offerFirmId);
		   for(OfferPhoto p : offerPhotos){
			   if(delIds.get(p.getId().toString()) == null){
				   offerPhotoService.deletePhoto(p);
			   }
		   }
		   request.getSession().setAttribute("offerFirmId", offerFirmId);
		   if (status.equals("2")) {
            return toJson("success2");
         }
		   else if (status.equals("4")) {
		      return toJson("success4");     
		   }
         else if (status.equals("3")) {
            return toJson("success3");     
         }
         else if (status.equals("1")) {
            return toJson("success1");     
         }
		   
//	    	Map<String, String> emailMap = new HashMap<String, String>();
//	    	OfferEmail offerEmail = baseService.getEmailContent('4').get(0);
//	    	OfferUser offerUser = offerUserService.getOfferUser(offerUserId);
//	        emailMap.put("toMail", offerUser.getOfferUserEmail());
//	        emailMap.put("mailtitle", offerEmail.getEmailTitle());
//	        emailMap.put("mailContent", offerEmail.getEmailContext().toString().replace("[0]", "<a>"+Code.systemPath+"/user/jihuoyouxiang.do?userIdString="+offerUserId+"&userStatus="+4+"</a>"));
//	        sendEmail.sendEmail(emailMap);
	   }
	   catch (Exception e) {
	     e.printStackTrace();
	  }
	  return toJson(SUCCESS);
   }
   
   //筛选用户
   @ResponseBody
   @RequestMapping(value = "/firm/finduserPage1", produces = "application/json")
   public Map<String, Object> finduserPage1(HttpServletRequest request, @RequestBody String data) {
      try {
         Map<String, Object> map = new HashMap<String, Object>();
         
         List<Map<String, String>> city = new ArrayList<Map<String, String>>();
         List<Map<String, String>> allCity = baseService.getDiShiCity("getAll");//所有的地市,getAll
         for (Map<String, String> map2 : allCity) {
            Map<String, String> m = new HashMap<String, String>();
            m.put("id", String.valueOf(map2.get("id")));
            m.put("value", map2.get("cityName"));
            city.add(m);
         }
         map.put("city", city);
         
         List<Map<String, String>> job = new ArrayList<Map<String, String>>();
         List<OfferJob> allOfferJobs = offerJobService.getAllJob("");//parentId=空的,给出所有的职位
         for (int i = 0; i < allOfferJobs.size(); i++) {
            Map<String, String> nowJobMap = new HashMap<String, String>();
            nowJobMap.put("id", String.valueOf(allOfferJobs.get(i).getId()));
            nowJobMap.put("value", allOfferJobs.get(i).getJobName());
            job.add(nowJobMap);
         }
         map.put("job", job);
         
         List<Map<String, String>> worked = new ArrayList<Map<String, String>>();
         String[] strings = new String[]{ "1年", "一至三年", "三至五年", "五年以上" };
         int j = 1;
         for (String string : strings) {
            Map<String, String> savedMap = new HashMap<String, String>();
            savedMap.put("id", String.valueOf(j));
            savedMap.put("value", string);
            worked.add(savedMap);
         }
         map.put("worked", worked);
         
         String offerUserId = request.getSession().getAttribute("id") + "";
         OfferUser offerUsers = offerUserService.getOfferUser(offerUserId);
         //map.put("userName", offerUsers.getOfferUserName());
         putUserName(map, request);
         request.getSession().setAttribute("offerFirmId", offerUsers.getFirmId());
         List<OfferFirmChoose> offerFirmChooses = baseService.getOfferFirmChooses(offerUsers.getId(), offerUsers.getFirmId());
         List<Map<String, String>> citybutton = new ArrayList<Map<String, String>>();
         List<Map<String, String>> jobbutton = new ArrayList<Map<String, String>>();
         List<Map<String, String>> workbutton = new ArrayList<Map<String, String>>();
         List<Map<String, String>> saved = new ArrayList<Map<String, String>>();
         boolean flag = false;
         int i = 1;
         map.put("firmsavedValue", "");
         map.put("firmsaved", "");

         String firstIn = request.getParameter("firstIn");
         for (OfferFirmChoose offerFirmChoose : offerFirmChooses) {
            if (offerFirmChooses.size() == i) {
               flag = true;
            }
            i++;
            String nowName = "";
            String firmChooseCity = offerFirmChoose.getOfferFirmChooseCity();
            if (firmChooseCity != null) {
               String cityName = baseService.getOfferCities(firmChooseCity).get(0).getCityName();
               String id = baseService.getOfferCities(firmChooseCity).get(0).getId() + "";
               nowName += cityName + ";";
               if (!firstIn.equals("1")) {
                  if (flag) {
                     Map<String, String> nowMap = new HashMap<String, String>();
                     nowMap.put("id", id);
                     nowMap.put("value", cityName);
                     citybutton.add(nowMap);
                     map.put("citybutton", citybutton);
                  }
               }
            }
            String firmChooseJob = offerFirmChoose.getOfferFirmChooseJob();
            if (firmChooseJob != null) {
               nowName += offerJobService.getOfferJob(Integer.valueOf(firmChooseJob)).get(0).getJobName() + ";";
               if (!firstIn.equals("1")) {
                  if (flag) {
                     Map<String, String> nowMap = new HashMap<String, String>();
                     nowMap.put("id", offerJobService.getOfferJob(Integer.valueOf(firmChooseJob)).get(0).getId() + "");
                     nowMap.put("value", offerJobService.getOfferJob(Integer.valueOf(firmChooseJob)).get(0).getJobName());
                     jobbutton.add(nowMap);
                     map.put("jobbutton", jobbutton);
                  }
               }
            }
            String firmChooseWorkTime = offerFirmChoose.getOfferFirmChooseWorkTime();
            if (firmChooseWorkTime != null) {
               nowName += firmChooseWorkTime + ";";
               if (!firstIn.equals("1")) {
                  if (flag) {
                     Map<String, String> nowMap = new HashMap<String, String>();
                     nowMap.put("id", "1");
                     nowMap.put("value", firmChooseWorkTime);
                     workbutton.add(nowMap);
                     map.put("workbutton", workbutton);
                  }
               }
            }
            String firmChooseLastChoose = offerFirmChoose.getOfferLastChoose();
            if (firmChooseLastChoose != null) {
               nowName += firmChooseLastChoose;
               if (flag) {
                  Map<String, String> nowMap = new HashMap<String, String>();
                  nowMap.put("id", "1");
                  nowMap.put("value", firmChooseLastChoose);
                  workbutton.add(nowMap);
               }
            }
            Map<String, String> savedMap = new HashMap<String, String>();
            savedMap.put("id", String.valueOf(offerFirmChoose.getId()));
            savedMap.put("value", nowName.endsWith(";") ? nowName.substring(0, nowName.lastIndexOf(";")) : nowName);
            saved.add(savedMap);
            if (flag) {
               map.put("firmsavedValue", nowName.endsWith(";") ? nowName.substring(0, nowName.lastIndexOf(";")) : nowName);
               map.put("firmsaved", offerFirmChoose.getId());
            }
         }
         map.put("saved", saved);
         map.put("u1", "");
         if (firstIn.equals("1")) {
            map.put("firmsavedValue", "");
            map.put("firmsaved", "");
         }
         
         return toJson(map);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   
   //筛选用户保存
   @ResponseBody
   @RequestMapping(value = "/firm/savefinduser1", produces = "application/json")
   public Map<String, Object> savefinduser1(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         String offerUserId = request.getSession().getAttribute("id") + "";
         String offerFirmId = request.getSession().getAttribute("offerFirmId") + "";
         
         form.put("offerUserId", offerUserId);
         form.put("offerFirmId", offerFirmId);
         offerFirmService.saveOfferFirmChoose(form);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   
   //筛选用户列表页面
   @ResponseBody
   @RequestMapping(value = "/firm/findusersum1", produces = "application/json")
   public Map<String, Object> findusersum1(HttpServletRequest request, @RequestBody String data) {
      try {
         String offerUserId = request.getSession().getAttribute("id") + "";
         String allorpair = request.getParameter("allorpair");
         String removeWho = request.getParameter("removeWho") == null ? "" : request.getParameter("removeWho");
         String city = request.getParameter("city") == null ? "" : request.getParameter("city");
         String job = request.getParameter("job") == null ? "" : request.getParameter("job");
         String workTime = request.getParameter("workTime") == null ? "" : request.getParameter("workTime");
         String firmsaved = request.getParameter("firmsaved") == null ? "" : request.getParameter("firmsaved");
         Map<String, Object> map = new HashMap<String, Object>();
         List<Map<String, String>> userresume = new ArrayList<Map<String, String>>();
         Map<String, String> nowMap = new HashMap<String, String>();
         if (!"".equals(firmsaved)) {
            nowMap.put("id", firmsaved);
            List<OfferFirmChoose> offerFirmChooses = baseService.getOfferFirmChooses(nowMap);
            city = offerFirmChooses.get(0).getOfferFirmChooseCity() == null ? "" : offerFirmChooses.get(0).getOfferFirmChooseCity();
            job = offerFirmChooses.get(0).getOfferFirmChooseJob() == null ? "" : offerFirmChooses.get(0).getOfferFirmChooseJob();
            workTime = offerFirmChooses.get(0).getOfferFirmChooseWorkTime() == null ? "" : offerFirmChooses.get(0).getOfferFirmChooseWorkTime();
         }
         boolean cflag, jflag, wflag;
         cflag = jflag = wflag = false;
         if (!"".equals(removeWho)) {
            for (String remove : removeWho.split(";")) {
               String s = remove.split("_")[0];
               if ("c".equals(s)) cflag = true;
               else if ("j".equals(s)) jflag = true;
               else wflag = true;
            }
         }
         if (!"".equals(city)) {
            if (!cflag) {
               nowMap.put("offerUserCity", city);
               List<Map<String, String>> citybutton = new ArrayList<Map<String, String>>();
               Map<String, String> thisMap = new HashMap<String, String>();
               thisMap.put("id", city);
               thisMap.put("value", baseService.getOfferCities(city).get(0).getCityName());
               citybutton.add(thisMap);
               map.put("citybutton", citybutton);
            }
         }
         if (!"".equals(job)) {
            if (!jflag) {
               nowMap.put("jobId", job);
               List<Map<String, String>> jobbutton = new ArrayList<Map<String, String>>();
               Map<String, String> thisMap = new HashMap<String, String>();
               thisMap.put("id", job);
               thisMap.put("value", offerJobService.getOfferJob(Integer.valueOf(job)).get(0).getJobName());
               jobbutton.add(thisMap);
               map.put("jobbutton", jobbutton);
            }
         }
         if (!"".equals(workTime)) {
            if (!wflag) {
               nowMap.put("workTime", workTime);
               List<Map<String, String>> workbutton = new ArrayList<Map<String, String>>();
               Map<String, String> thisMap = new HashMap<String, String>();
               thisMap.put("id", "1");
               thisMap.put("value", workTime);
               workbutton.add(thisMap);
               map.put("workbutton", workbutton);
            }
         }
         String limit = request.getParameter("pageId") == null ? "" : request.getParameter("pageId");
         nowMap.put("limit", limit);
         nowMap.put("uStatus", "4");
         if ("".equals(limit)) {
            limit = "1";
         }
         List<Map<String, String>> list;
         if (allorpair.equals("quanbu")) {
            nowMap.put("all", "true");
            nowMap.put("status", "");
            nowMap.put("offerUserId", offerUserId);
            list = offerUserService.getOfferUserInformationWithEducations(nowMap);
            map.put("allnum", list.size());
            map.put("pageNum", list.size() == 0 ? 1 : Math.ceil(list.size() / 20.0));
            nowMap.put("all", "false");
            nowMap.put("status", "1");
            List<Map<String, String>> list1 = offerUserService.getOfferUserInformationWithEducations(nowMap);
            map.put("pairnum", list1.size());
         }
         else {
            nowMap.put("all", "false");
            nowMap.put("status", "1");
            nowMap.put("offerUserId", offerUserId);
            list = offerUserService.getOfferUserInformationWithEducations(nowMap);
            map.put("pairnum", list.size());
            nowMap.put("all", "true");
            nowMap.put("status", "");
            map.put("pageNum", list.size() == 0 ? 1 : Math.ceil(list.size() / 20.0));
            List<Map<String, String>> list1 = offerUserService.getOfferUserInformationWithEducations(nowMap);
            map.put("allnum", list1.size());
         }
         map.put("dataNum", list.size());
         int pageId = Integer.valueOf(limit);
         String nowyearwages, offerUserSex, offerUserAge, offerUserAddress, offerUserPlanYearWages, offerUserJob1;
         List<OfferJob> allOfferJobs = offerJobService.getAllJob("");//parentId=空的,给出所有的职位
         int size = list.size();
         boolean flag = (pageId * 20) < size;
         for (int i = (pageId - 1) * 20; flag ? i < (pageId * 20) : i < size; i++) {
            offerUserSex = list.get(i).get("offerUserSex") == null ? "" : "1".equals(list.get(i).get("offerUserSex")) ? "男" : "女";
            offerUserAge = list.get(i).get("offerUserAge") == null ? "" : list.get(i).get("offerUserAge");
            offerUserAddress = list.get(i).get("offerUserAddress") == null ? "" : "现居住" + baseService.getOfferCities(list.get(i).get("offerUserAddress")).get(0).getCityName();
            offerUserPlanYearWages = list.get(i).get("offerUserPlanYearWages") == null ? "" : "|期望年薪" + String.valueOf(list.get(i).get("offerUserPlanYearWages")) + "万";
            nowyearwages = offerUserSex + "&nbsp;&nbsp;&nbsp;" + offerUserAge + "&nbsp;&nbsp;&nbsp;" + offerUserAddress + "&nbsp;&nbsp;&nbsp;" + offerUserPlanYearWages;
            offerUserJob1 = list.get(i).get("offerUserJob1") == null ? "" : String.valueOf(list.get(i).get("offerUserJob1"));

            for (int j = 0; j < allOfferJobs.size(); j++) {
               if (!"".equals(allOfferJobs) && allOfferJobs.get(j).getId().toString().equals(offerUserJob1)) {
                  offerUserJob1 = allOfferJobs.get(j).getJobName();
                  break;
               }
            }
            Map<String, String> savedMap = new HashMap<String, String>();
            String nameString = ChinaInitial.getPYIndexStr(returnString(list.get(i).get("offerUserName")), true);
            savedMap.put("id", String.valueOf(list.get(i).get("id")));
            savedMap.put("username", ("".equals(nameString) ? "" : nameString.toCharArray()[0]) + ("".equals(offerUserSex) ? "" : "男".equals(offerUserSex) ? "先生" : "女士"));
            savedMap.put("school", list.get(i).get("schoolName") == null ? "" : list.get(i).get("schoolName"));
            savedMap.put("resume", offerUserJob1);
            savedMap.put("nowyearwages", nowyearwages);
            savedMap.put("photopath", FileUtils.getphotoPath(String.valueOf(list.get(i).get("id")), returnString(list.get(i).get("offerUserName"))));//暂时没有
            userresume.add(savedMap);
         }
         
         
//         boolean flag = (pageId * 20) < 1001;
//         for (int i = (pageId - 1) * 20; flag ? i < (pageId * 20) : i < 1001; i++) {
//            Map<String, String> savedMap = new HashMap<String, String>();
//            savedMap.put("id", String.valueOf(i));
//            savedMap.put("username", "yoyo" + (i + 1));
//            savedMap.put("school", "圣殿");
//            savedMap.put("resume", "哈哈哈");
//            savedMap.put("nowyearwages", "10WK");
//            savedMap.put("photopath", "../img/changjinglu.jpg");//暂时没有
//            userresume.add(savedMap);
//         }
//         map.put("dataNum", 1001);
//         map.put("pageNum", Math.ceil(1001 / 20.0));
         
         
         map.put("userresume", userresume);
         map.put("status", "");
         map.put("thisId", "");
         
         return toJson(map);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   
   @ResponseBody
   @RequestMapping(value = "/firm/findUserInformation", produces = "application/json")
   public Map<String, Object> findUserInformation(HttpServletRequest request, @RequestBody String data) {
      try {
         String offerCandidateId = request.getParameter("offerCandidateId");
         request.getSession().setAttribute("offerCandidateId", offerCandidateId);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   
   //筛选用户修改用户状态
   @ResponseBody
   @RequestMapping(value = "/firm/selectfindusersum1", produces = "application/json")
   public Map<String, Object> selectfindusersum1(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         String offerUserId = request.getSession().getAttribute("id") + "";
         String offerFirmId = request.getSession().getAttribute("offerFirmId") + "";
         String status = request.getParameter("status");
         String offerCandidateId = request.getParameter("offerCandidateId");
         form.put("offerUserId", offerUserId);
         form.put("offerFirmId", offerFirmId);
         form.put("status", status);
         form.put("offerCandidateId", offerCandidateId);
         offerFirmService.selectfindusersum1(form);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   
   @ResponseBody
   @RequestMapping(value = "/firm/saveOfferInvite", produces = "application/json")//保存企业发送的邀请
   public Map<String, Object> createOfferInvite(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         String offerUserId = request.getSession().getAttribute("id") + "";
         String offerFirmId = request.getSession().getAttribute("offerFirmId") + "";
         String offerCandidateId = request.getSession().getAttribute("userId") + "";
         String isoffer = request.getSession().getAttribute("isoffer") + "";
         form.put("userId", offerUserId);
         form.put("firmId", offerFirmId);
         form.put("offerCandidateId", offerCandidateId);
         form.put("isoffer", isoffer);
//         offerFirmService.saveOfferInvite(form);
         
         Map<String, String> emailMap = new HashMap<String, String>();
         OfferEmail offerEmail = baseService.getEmailContent('2').get(0);
         OfferFirm offerFirm =  offerFirmService.getOfferFirms(offerFirmId).get(0);
         OfferUser offerUser = offerUserService.getOfferUser(offerCandidateId);
//         emailMap.put("formMail", offerFirm.getOfferEmail());
         emailMap.put("toMail", offerUser.getOfferUserEmail());
         emailMap.put("mailtitle", offerEmail.getEmailTitle());
         emailMap.put("mailContent", offerEmail.getEmailContext().toString().replace("[0]", offerUser.getOfferUserName()).replace("[1]", offerFirm.getOfferName()));
         sendEmail.sendEmail(emailMap);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   
   //筛选候选人页面1
   @ResponseBody
   @RequestMapping(value = "/firm/userviewPage1", produces = "application/json")
   public Map<String, Object> userviewPage1(HttpServletRequest request, @RequestBody String data) {
      try {
         Map<String, Object> map = new HashMap<String, Object>();
         String offerUserId = request.getSession().getAttribute("id") + "";
         OfferUser offerUsers = offerUserService.getOfferUser(offerUserId);
         putUserName(map, request);
         //map.put("userName", offerUsers.getOfferUserName());
         request.getSession().setAttribute("offerFirmId", offerUsers.getFirmId());
         Map<String, String> nowMap = new HashMap<String, String>();
         nowMap.put("offerUserId", offerUserId);
         nowMap.put("offerFirmId", offerUsers.getFirmId() + "");
         
         nowMap.put("status", "'0','1'");//企业邀请
         List<Map<String, String>> list1 = baseService.getOfferInvite(nowMap);
         map.put("interview1", list1.size());
         
         nowMap.put("status", "2");//待安排面试
         List<Map<String, String>> list2 = baseService.getOfferInvite(nowMap);
         map.put("interview2", list2.size());
         
         nowMap.put("status", "3");//待反馈结果
         List<Map<String, String>> list3 = baseService.getOfferInvite(nowMap);
         map.put("interview3", list3.size());

         nowMap.put("status", "4");//面试通过
         List<Map<String, String>> list4 = baseService.getOfferInvite(nowMap);
         map.put("interview4", list4.size());

         nowMap.put("status", "'4','5','6'");//归档
         List<Map<String, String>> list5 = baseService.getOfferInvite(nowMap);
         map.put("interview5", list5.size());

         return toJson(map);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   //筛选候选人页面2
   @ResponseBody
   @RequestMapping(value = "/firm/userviewPage2", produces = "application/json")
   public Map<String, Object> userviewPage2(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         String status = form.get("usertype");
         String offerUserId = request.getSession().getAttribute("id") + "";
         OfferUser offerUsers = offerUserService.getOfferUser(offerUserId);
         request.getSession().setAttribute("offerFirmId", offerUsers.getFirmId());
         Map<String, String> nowMap = new HashMap<String, String>();
         nowMap.put("offerUserId", offerUserId);
         nowMap.put("offerFirmId", offerUsers.getFirmId() + "");
         nowMap.put("status", status);
         List<Map<String, String>> list = baseService.getOfferInviteCandidate(nowMap);
         List<Map<String, String>> userList = new ArrayList<Map<String, String>>();
         Map<String, Object> map = new HashMap<String, Object>();
         boolean flag = true;
         for (Map<String, String> map2 : list) {
            Map<String, String> userMap = new HashMap<String, String>();
            char nameString = ChinaInitial.getPYIndexStr(map2.get("offerUserName"), true).toCharArray()[0];
            String sex = map2.get("offerUserSex") == null ? "" : map2.get("offerUserSex").equals("1") ? "先生" : "女士";
            userMap.put("id", String.valueOf(map2.get("id")));
            userMap.put("imgpath", FileUtils.getphotoPath(String.valueOf(map2.get("candidateId")), map2.get("offerUserName")));//"../img/陈裕嘉.jpg"
            userMap.put("name", nameString + sex);
            userMap.put("job", map2.get("jobName"));
            userMap.put("money", String.valueOf(map2.get("jobMonthWagesFirst")) + "K  ~  " + String.valueOf(map2.get("jobMonthWagesSecond")) + "K*" + String.valueOf(map2.get("jobMonth")) + "个月");
            userMap.put("time", "发送邀请时间：" + formatter.format(map2.get("createTime")));
            userList.add(userMap);
            if (flag) {
               map.put("inviteId", String.valueOf(map2.get("id")));
               flag = false;
            }
         }
         if (list.size() == 0) {
            map.put("inviteId", "");
         }
         map.put("userList", userList);
         return toJson(map);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   //筛选候选人页面3
   @ResponseBody
   @RequestMapping(value = "/firm/userviewPage3", produces = "application/json")
   public Map<String, Object> userviewPage3(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         String inviteId = form.get("inviteId");
         String offerUserId = request.getSession().getAttribute("id") + "";
         OfferUser offerUsers = offerUserService.getOfferUser(offerUserId);
         request.getSession().setAttribute("offerFirmId", offerUsers.getFirmId());
         Map<String, String> nowMap = new HashMap<String, String>();
         nowMap.put("inviteId", inviteId);
         List<Map<String, String>> list = baseService.getOfferInvite(nowMap);
         Map<String, Object> map = new HashMap<String, Object>();
         if (list.size() > 0) {
            Map<String, String> findMap = new HashMap<String, String>();
            findMap.put("offerUserId", String.valueOf(list.get(0).get("candidateId")));
            List<Map<String, String>> listMap = offerUserInformationService.getOfferUserInformations(findMap);
            if (listMap.size() > 0) {
               String sex = listMap.get(0).get("offerUserSex") == null ? "" : listMap.get(0).get("offerUserSex").equals("1") ? "先生" : "女士";
               Map<String, String> headMap = new HashMap<String, String>();
               headMap.put("workplace", String.valueOf(list.get(0).get("jobPlace")));
               headMap.put("job", String.valueOf(list.get(0).get("jobName")));
               headMap.put("money", String.valueOf(list.get(0).get("jobMonthWagesFirst")) + "K  ~  " + String.valueOf(list.get(0).get("jobMonthWagesSecond")) + "K  *  " + String.valueOf(list.get(0).get("jobMonth")) + "个月");
               headMap.put("name", sex);
               map.put("head", headMap);
               List<Map<String, String>> listChat = baseService.getOfferInviteChat(nowMap);
               List<Map<String, String>> commitList = new ArrayList<Map<String, String>>();
               OfferUser offerCandidate = offerUserService.getOfferUser(Integer.valueOf(String.valueOf(list.get(0).get("candidateId"))));
               OfferUser offerFirmUser = offerUserService.getOfferUser(Integer.valueOf(String.valueOf(list.get(0).get("userId"))));
               if (listChat.size() > 0) {
                  for (Map<String, String> item : listChat) {
                     Map<String, String> commitMap = new HashMap<String, String>();
                     boolean cStatus = String.valueOf(item.get("cStatus")).equals("4");
                     String isoffer = String.valueOf(item.get("isoffer"));
                     if (isoffer.equals("1")) {
                        commitMap.put("image", FileUtils.getphotoPath(String.valueOf(offerCandidate.getId()), offerCandidate.getOfferUserName()));//候选人
                        commitMap.put("name", offerCandidate.getOfferUserName());
                        commitMap.put("cStatus", "false");
                        commitMap.put("time", formatter.format(item.get("chatCreateTime")));
                        commitMap.put("content", item.get("chatMessage"));
                     }
                     else {
                        commitMap.put("image", FileUtils.getphotoPath(String.valueOf(offerFirmUser.getId()), offerFirmUser.getOfferUserName()));//企业的
                        commitMap.put("name", offerFirmUser.getOfferUserName());
                        if (cStatus) {
                           commitMap.put("cStatus", "true");
                        }
                        else {
                           commitMap.put("cStatus", "false");
                        }
                        commitMap.put("time", formatter.format(item.get("chatCreateTime")));
                        commitMap.put("content", item.get("chatMessage"));
                     }
                     commitList.add(commitMap);
                  }
                  map.put("status", listChat.get(listChat.size() - 1).get("cStatus"));
               }
               map.put("commit", commitList);
               map.put("candidateId", String.valueOf(list.get(0).get("candidateId")));
            }
         }
         return toJson(map);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   
   //筛选候选人页面3保存
   @ResponseBody
   @RequestMapping(value = "/firm/saveuserview3", produces = "application/json")
   public Map<String, Object> saveuserview3(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         String offerUserId = request.getSession().getAttribute("id") + "";
         String offerFirmId = request.getSession().getAttribute("offerFirmId") + "";
         String offerCandidateId = request.getSession().getAttribute("userId") + "";
         String isoffer = request.getSession().getAttribute("isoffer") + "";
         form.put("userId", offerUserId);
         form.put("firmId", offerFirmId);
         form.put("isoffer", isoffer);
         form.put("offerCandidateId", offerCandidateId);
         offerInviteChatService.saveOfferInviteChat(form);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   
   @ResponseBody
   @RequestMapping(value = "/firm/userviewanpaiPage3", produces = "application/json")
   public Map<String, Object> userviewanpaiPage3(HttpServletRequest request, @RequestBody String data) {
      try {
         String offerUserId = request.getSession().getAttribute("id") + "";
         List<Map<String, String>> list = offerFirmService.getFirmInformation(offerUserId);
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("interviewworkspace", list.get(0).get("firmAddress"));
         map.put("interviewWay", list.get(0).get("offerUserName"));
         map.put("interviewman", list.get(0).get("offerUserPhone"));
         List<Map<String, String>> timeList = new ArrayList<Map<String,String>>();
         for (int i = 1; i < 8; i++) {
            Map<String, String> putMap = new HashMap<String, String>();
            putMap.put("id", String.valueOf(i));
            putMap.put("value", i + "天后");
            timeList.add(putMap);
         }
         map.put("interviewtimeList1", timeList);
         List<Map<String, String>> timeList2 = new ArrayList<Map<String,String>>();
         for (int i = 9; i <= 18; i++) {
            Map<String, String> putMap = new HashMap<String, String>();
            putMap.put("id", String.valueOf(i));
            putMap.put("value", i + "点");
            timeList2.add(putMap);
         }
         map.put("interviewtimeList2", timeList2);
         return toJson(map);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   
   //面试页面1
   @ResponseBody
   @RequestMapping(value = "/firm/interviewPage1", produces = "application/json")
   public Map<String, Object> interviewPage1(HttpServletRequest request, @RequestBody String data) {
      try {
         String offerUserId = request.getSession().getAttribute("id") + "";
         Map<String, Object> map = new HashMap<String, Object>();
         Map<String, String> nowMap = new HashMap<String, String>();
         nowMap.put("offerCandidateId", offerUserId);
         
         nowMap.put("status", "'0','1'");//新的面试邀请
         List<Map<String, String>> list1 = baseService.getOfferInvite(nowMap);
         map.put("interview1", list1.size());
         
         nowMap.put("status", "1");//待沟通
         List<Map<String, String>> list2 = baseService.getOfferInvite(nowMap);
         map.put("interview2", list2.size());
         
         nowMap.put("status", "2");//待安排面试
         List<Map<String, String>> list3 = baseService.getOfferInvite(nowMap);
         map.put("interview3", list3.size());

         nowMap.put("status", "3");//已安排面试
         List<Map<String, String>> list4 = baseService.getOfferInvite(nowMap);
         map.put("interview4", list4.size());

         nowMap.put("status", "'4','5'");//面试结果
         List<Map<String, String>> list5 = baseService.getOfferInvite(nowMap);
         map.put("interview5", list5.size());

         nowMap.put("status", "6");//已拒绝面试邀请
         List<Map<String, String>> list6 = baseService.getOfferInvite(nowMap);
         map.put("interview6", list6.size());

         return toJson(map);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   //面试页面2
   @ResponseBody
   @RequestMapping(value = "/firm/interviewPage2", produces = "application/json")
   public Map<String, Object> interviewPage2(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         String status = form.get("interviewtype");
         String offerUserId = request.getSession().getAttribute("id") + "";
         OfferUser offerUsers = offerUserService.getOfferUser(offerUserId);
         request.getSession().setAttribute("offerFirmId", offerUsers.getFirmId());
         Map<String, String> nowMap = new HashMap<String, String>();
         nowMap.put("offerCandidateId", offerUserId);
         nowMap.put("status", status);
         List<Map<String, String>> list = baseService.getOfferInviteFirm(nowMap);
         List<Map<String, String>> firmList = new ArrayList<Map<String, String>>();
         Map<String, Object> map = new HashMap<String, Object>();
         boolean flag = true;
         for (Map<String, String> map2 : list) {
            List<OfferPhoto> offerPhotos = offerPhotoService.findByFirmIId(returnString(map2.get("firmId")));
            Map<String, String> firmMap = new HashMap<String, String>();
            firmMap.put("id", String.valueOf(map2.get("id")));
            if (offerPhotos.size() > 0) {
               firmMap.put("imgpath", "../upload/photo/" + offerPhotos.get(0).getPhotoSavename());
            }
            else {
               firmMap.put("imgpath", FileUtils.getphotoPath(String.valueOf(map2.get("firmId")), map2.get("offerName")));
            }
//            firmMap.put("imgpath", "../img/changjinglu.jpg");
            firmMap.put("address", map2.get("jobPlace"));
            firmMap.put("job", map2.get("jobName"));
            firmMap.put("money", String.valueOf(map2.get("jobMonthWagesFirst")) + "K~" + String.valueOf(map2.get("jobMonthWagesSecond")) + "K*" + String.valueOf(map2.get("jobMonth")) + "个月");
            firmMap.put("time", "发送邀请时间：" + formatter.format(map2.get("createTime")));
            firmList.add(firmMap);
            if (flag) {
               map.put("inviteId", String.valueOf(map2.get("id")));
               flag = false;
            }
         }
         if (list.size() == 0) {
            map.put("inviteId", "");
         }
         map.put("firmList", firmList);
         return toJson(map);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   //面试页面3
   @ResponseBody
   @RequestMapping(value = "/firm/interviewPage3", produces = "application/json")
   public Map<String, Object> interviewPage3(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         String inviteId = form.get("inviteId");
         String offerUserId = request.getSession().getAttribute("id") + "";
         OfferUser offerUsers = offerUserService.getOfferUser(offerUserId);
         request.getSession().setAttribute("offerFirmId", offerUsers.getFirmId());
         Map<String, String> nowMap = new HashMap<String, String>();
         nowMap.put("inviteId", inviteId);
         List<Map<String, String>> list = baseService.getOfferInvite(nowMap);
         Map<String, Object> map = new HashMap<String, Object>();
         if (list.size() > 0) {
            List<Map<String, String>> listMap = offerFirmService.getFirmInformation(String.valueOf(list.get(0).get("userId")));
            if (listMap.size() > 0) {
               map.put("firmName", listMap.get(0).get("firmAllName"));
               List<OfferPhoto> offerPhotos = offerPhotoService.findByFirmIId(returnString(listMap.get(0).get("offerFirmId")));
               if (offerPhotos.size() > 0) {
                  map.put("firmLogo", "../upload/photo/" + offerPhotos.get(0).getPhotoSavename());
               }
               else {
                  map.put("firmLogo", FileUtils.getphotoPath(String.valueOf(listMap.get(0).get("offerFirmId")), listMap.get(0).get("firmAllName")));
               }
               map.put("firmAddress", listMap.get(0).get("firmAddress"));
               map.put("firmJob", list.get(0).get("jobName"));
               map.put("firmMoney", String.valueOf(list.get(0).get("jobMonthWagesFirst")) + "K~" + String.valueOf(list.get(0).get("jobMonthWagesSecond")) + "K*" + String.valueOf(list.get(0).get("jobMonth")) + "个月");
               map.put("firmQiQuan", String.valueOf(list.get(0).get("isstock")).equals("0") ? "无" : "有");
               map.put("firmResume", listMap.get(0).get("firmDescript"));
               List<Map<String, String>> listChat = baseService.getOfferInviteChat(nowMap);
               List<Map<String, String>> commitList = new ArrayList<Map<String, String>>();
               OfferUser offerCandidate = offerUserService.getOfferUser(Integer.valueOf(String.valueOf(list.get(0).get("candidateId"))));
               OfferUser offerFirmUser = offerUserService.getOfferUser(Integer.valueOf(String.valueOf(list.get(0).get("userId"))));
               if (listChat.size() > 0) {
                  for (Map<String, String> item : listChat) {
                     Map<String, String> commitMap = new HashMap<String, String>();
                     String isoffer = String.valueOf(item.get("isoffer"));
                     boolean cStatus = String.valueOf(item.get("cStatus")).equals("4");
                     if (isoffer.equals("1")) {
                        commitMap.put("image", FileUtils.getphotoPath(String.valueOf(offerCandidate.getId()), offerCandidate.getOfferUserName()));//候选人
                        commitMap.put("name", offerCandidate.getOfferUserName());
                        commitMap.put("cStatus", "false");
                        commitMap.put("time", formatter.format(item.get("chatCreateTime")));
                        commitMap.put("content", item.get("chatMessage"));
                     }
                     else {
                        commitMap.put("image", FileUtils.getphotoPath(String.valueOf(offerFirmUser.getId()), offerFirmUser.getOfferUserName()));//企业的
                        commitMap.put("name", offerFirmUser.getOfferUserName());
                        if (cStatus) {
                           commitMap.put("cStatus", "true");//就是在页面显示面试成功
                        }
                        else {
                           commitMap.put("cStatus", "false");
                        }
                        commitMap.put("time", formatter.format(item.get("chatCreateTime")));
                        commitMap.put("content", item.get("chatMessage"));
                     }
                     commitList.add(commitMap);
                  }
                  map.put("status", list.get(0).get("iStatus"));
               }
               map.put("commit", commitList);
            }
         }
         return toJson(map);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   //面试页面3保存
   @ResponseBody
   @RequestMapping(value = "/firm/saveinterview3", produces = "application/json")
   public Map<String, Object> saveinterview3(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         String offerCandidateId = request.getSession().getAttribute("id") + "";
         String isoffer = request.getSession().getAttribute("isoffer") + "";
         String inviteId = form.get("inviteId");
         List<OfferInvite> offerInvite = offerInviteService.getOfferInvites(inviteId);
         if (offerInvite.size() > 0) {
            form.put("userId", offerInvite.get(0).getUserId() + "");
            form.put("firmId", offerInvite.get(0).getFirmId() + "");
         }
         form.put("isoffer", isoffer);
         form.put("offerCandidateId", offerCandidateId);
         offerInviteChatService.saveOfferInviteChat(form);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return toJson(SUCCESS);
   }
   
    @ResponseBody
	@RequestMapping(value = "/firm/firmphoto")
	public Map<String, Object> uploadFile(HttpServletRequest request, @RequestParam("fileLogo") MultipartFile[] fileLogo, @RequestParam("fileEnvironment") MultipartFile[] fileEnvironment) {
    	try {
			if (fileLogo != null && fileLogo.length > 0) {
				// 循环获取file数组中得文件
				for (int i = 0; i < fileLogo.length; i++) {
					MultipartFile file = fileLogo[i];
					if(file.getOriginalFilename() == null || "".equals(file.getOriginalFilename())){
						continue;
					}else{
						List<OfferPhoto> offerPhotos = offerPhotoService.findByFirmIId(request.getSession().getAttribute("offerFirmId").toString());
						if (offerPhotos.size()>0) {
						   String path = Code.systemPath + "/upload/photo/" + offerPhotos.get(0).getPhotoSavename();
						   File photoFile = new File(path);
						   if(photoFile.exists() && photoFile.isFile()){
						      photoFile.delete();
						   }
						   offerPhotoService.deletePhoto(offerPhotos.get(0));
                  }
					}
					String cName = String.valueOf(System.currentTimeMillis());
					String endless = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
					String filePath = Code.systemPath + "upload" + File.separator + "photo"
							+ File.separator + cName+endless;
					// 保存文件
					FileUtils.saveFile(file, filePath);
					OfferPhoto photo = new OfferPhoto();
					photo.setPhotoSavename(cName+endless);
					photo.setTableName("offer_firm_information");
					photo.setStatus("1");
					photo.setTableId(Integer.valueOf(request.getSession().getAttribute("offerFirmId").toString()));
					offerPhotoService.saveOfferPhoto(photo);
				}
			}
			
			if (fileEnvironment != null && fileEnvironment.length > 0) {
				// 循环获取file数组中得文件
				for (int i = 0; i < fileEnvironment.length; i++) {
					MultipartFile file = fileEnvironment[i];
					String cName = String.valueOf(System.currentTimeMillis());
					String endless = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
					String filePath = Code.systemPath + "upload" + File.separator + "photo"
							+ File.separator + cName+endless;
					// 保存文件
					FileUtils.saveFile(file, filePath);
					OfferPhoto photo = new OfferPhoto();
					photo.setPhotoSavename(cName+endless);
					photo.setTableName("offer_firm_introduce");
					photo.setStatus("1");
					photo.setTableId(Integer.valueOf(request.getSession().getAttribute("offerFirmId").toString()));
					offerPhotoService.saveOfferPhoto(photo);
				}
			} 
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
    	return toJson(SUCCESS);
   }
    
    @ResponseBody
    @RequestMapping(value = "/firm/changeUserStatus")
    public Map<String, Object> changeUserStatus(HttpServletRequest request, @RequestBody String data) {
       try {
          putToForm(data);
          String offerCandidateId = request.getSession().getAttribute("userId") + "";
          String status = request.getParameter("firmguwen");
          String beizhu = request.getParameter("beizhu");
          form.put("status", status);
          form.put("beizhu", beizhu);
          form.put("offerCandidateId", offerCandidateId);
          offerUserService.changeUserStatus(form);
          
          OfferUser offerUser = offerUserService.getOfferUser(offerCandidateId);
          if ("4".equals(status)) {
             Map<String, String> emailMap = new HashMap<String, String>();
             OfferEmail offerEmail = baseService.getEmailContent('5').get(0);
             emailMap.put("toMail", offerUser.getOfferUserEmail());
             emailMap.put("mailtitle", offerEmail.getEmailTitle());
             emailMap.put("mailContent", offerEmail.getEmailContext().toString());
             sendEmail.sendEmail(emailMap);
          }else {
             Map<String, String> emailMap = new HashMap<String, String>();
             OfferEmail offerEmail = baseService.getEmailContent('6').get(0);
             emailMap.put("toMail", offerUser.getOfferUserEmail());
             emailMap.put("mailtitle", offerEmail.getEmailTitle());
             emailMap.put("mailContent", offerEmail.getEmailContext().toString());
             sendEmail.sendEmail(emailMap);
          }

       }
       catch (Exception e) {
          e.printStackTrace();
       }
       return toJson(SUCCESS);
    }
   
    
    @ResponseBody
    @RequestMapping(value = "/firm/changefirmStatus")
    public Map<String, Object> changefirmStatus(HttpServletRequest request, @RequestBody String data) {
       try {
          putToForm(data);
          String offerFirmId = request.getSession().getAttribute("firmId") + "";
          String status = request.getParameter("firmguwen");
          String beizhu = request.getParameter("beizhu");
//          String status = form.get("firmguwen");
          form.put("status", status);
          form.put("beizhu", beizhu);
          form.put("offerFirmId", offerFirmId);
          offerFirmService.changefirmStatus(form);
          
          OfferFirm offerFirm = offerFirmService.getOfferFirms(offerFirmId).get(0);
          if ("4".equals(status)) {
       	      Map<String, String> emailMap = new HashMap<String, String>();
       	      OfferEmail offerEmail = baseService.getEmailContent('5').get(0);
              emailMap.put("toMail", offerFirm.getOfferEmail());
              emailMap.put("mailtitle", offerEmail.getEmailTitle());
              emailMap.put("mailContent", offerEmail.getEmailContext().toString());
              sendEmail.sendEmail(emailMap);
          }else {
       	      Map<String, String> emailMap = new HashMap<String, String>();
       	      OfferEmail offerEmail = baseService.getEmailContent('6').get(0);
              emailMap.put("toMail", offerFirm.getOfferEmail());
              emailMap.put("mailtitle", offerEmail.getEmailTitle());
              emailMap.put("mailContent", offerEmail.getEmailContext().toString());
              sendEmail.sendEmail(emailMap);
          }
       }
       catch (Exception e) {
          e.printStackTrace();
       }
       return toJson(SUCCESS);
    }
    
    //企业审核失败重新提交页面
    @ResponseBody
    @RequestMapping(value = "/firm/examinefirmPage1", produces = "application/json")
    public Map<String, Object> examinefirmPage1(HttpServletRequest request, @RequestBody String data) {
       try {
          Map<String, Object> map = new HashMap<String, Object>();
          List<Map<String, String>> firmStageList = new ArrayList<Map<String, String>>();
          List<Map<String, String>> list1 = baseService.getOfferStage();
          for (Map<String, String> map1 : list1) {
             Map<String, String> firmStageMap = new HashMap<String, String>();
             firmStageMap.put("id", String.valueOf(map1.get("id")));
             firmStageMap.put("value", map1.get("offerStage"));
             firmStageList.add(firmStageMap);
          }
          map.put("firmStageList", firmStageList);
          
          List<Map<String, String>> cityList = new ArrayList<Map<String, String>>();
          List<Map<String, String>> allCity = baseService.getDiShiCity("getAll");
          for (Map<String, String> map2 : allCity) {
             Map<String, String> m = new HashMap<String, String>();
             m.put("id", String.valueOf(map2.get("id")));
             m.put("value", map2.get("cityName"));
             cityList.add(m);
          }
          map.put("cityList", cityList);
          
          List<Map<String, String>> xuqiuList = new ArrayList<Map<String, String>>();
          for(int i = 0; i < 10; i++){
             Map<String, String> firmStageMap = new HashMap<String, String>();
             firmStageMap.put("id", String.valueOf(i));
             firmStageMap.put("value", "需求" + String.valueOf(i));
             xuqiuList.add(firmStageMap);
          }
          map.put("xuqiuList", xuqiuList);
          return toJson(map);
       } catch (Exception e) {
          e.printStackTrace();
       }
       return toJson(SUCCESS);
    }
    //企业审核失败重新提交保存
    @ResponseBody
    @RequestMapping(value = "/firm/saveexaminefirm1", produces = "application/json")
    public Map<String, Object> saveexaminefirm1(HttpServletRequest request, @RequestBody String data) {
       try {
          putToForm(data);
          String offerUserId = request.getSession().getAttribute("id") + "";
          String offerFirmId = request.getSession().getAttribute("firmId") + "";
          form.put("offerUserId", offerUserId);
          form.put("offerFirmId", offerFirmId);
          offerFirmService.saveexaminefirm1(form);
       } catch (Exception e) {
          e.printStackTrace();
       }
       return toJson(SUCCESS);
    }
    
    @ResponseBody 
    @RequestMapping(value="/firm/changeTeamPeopleStatus", produces = "application/json")
    public Map<String, Object> changeguwenStatus(HttpServletRequest request, @RequestBody String data){
       try {
          putToForm(data);
          String teamPeopleId = form.get("teamPeopleId");
          String teamPeopleStatus = form.get("teamPeopleStatus");
          OfferUser offerUser = offerUserService.getOfferUser(Integer.valueOf(teamPeopleId));
          offerUser.setTeamPeopleStatus(Integer.valueOf(teamPeopleStatus));
          offerUserService.updateOfferUser(offerUser);
          return toJson(SUCCESS);
       } catch (Exception e) {
          e.printStackTrace();
          return toJson(ERROR);
       }
    }
    
    @ResponseBody 
    @RequestMapping(value="/firm/changeTeamAdmin", produces = "application/json")
    public Map<String, Object> changeTeamAdmin(HttpServletRequest request, @RequestBody String data){
       try {
          putToForm(data);
          
          String teamPeopleId = form.get("teamPeopleId");
          OfferUser offerUser = offerUserService.getOfferUser(Integer.valueOf(teamPeopleId));
          String status = offerUser.getStatus();
          if (!status.equals("4")) {
             return toJson("该用户没有审批通过，无法转移管理员！");
          }
          offerUser.setIsAdmin(1);
          offerUser.setTeamPeopleStatus(1);
          offerUserService.updateOfferUser(offerUser);

          String offerUserId = request.getSession().getAttribute("id") + "";
          OfferUser offerUserAdmin = offerUserService.getOfferUser(Integer.valueOf(offerUserId));
          offerUserAdmin.setIsAdmin(0);
          offerUserService.updateOfferUser(offerUserAdmin);
          return toJson(SUCCESS);
       } catch (Exception e) {
          e.printStackTrace();
          return toJson(ERROR);
       }
    }
    
   @Autowired
   private GeneratePDF                 generatePDF;
   
   @Autowired
   private Encryption                  encryption;
   
   @Autowired
   private BaseService                 baseService;
   
   @Autowired
   private OfferUserService            offerUserService;

   @Autowired
   private OfferFirmService            offerFirmService;

   @Autowired
   private OfferFirmInformationService offerFirmInformationService;

   @Autowired
   private OfferCollectService         offerCollectService;

   @Autowired
   private OfferInviteService          offerInviteService;

   @Autowired
   private OfferInviteChatService      offerInviteChatService;
   
   @Autowired
   private OfferJobService             offerJobService;
   
   @Autowired
   private OfferPhotoService             offerPhotoService;
   
   @Autowired
   private SendEmail             sendEmail;
   
   @Autowired
   private OfferUserInformationService offerUserInformationService;
   
   private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
   
   private File fileLogo;
   
   private List<File> fileEnvironment;

   public File getFileLogo() {
      return fileLogo;
   }

   public void setFileLogo(File fileLogo) {
      this.fileLogo = fileLogo;
   }

   public List<File> getFileEnvironment() {
      return fileEnvironment;
   }

   public void setFileEnvironment(List<File> fileEnvironment) {
      this.fileEnvironment = fileEnvironment;
   }
}
