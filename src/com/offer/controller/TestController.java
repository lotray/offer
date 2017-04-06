package com.offer.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.print.attribute.standard.JobName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.offer.model.OfferFirmInformation;
import com.offer.model.OfferFirmProduce;
import com.offer.model.OfferFirmReport;
import com.offer.model.OfferFirmSelect;
import com.offer.model.OfferFirmTechnology;
import com.offer.model.OfferFirmWelfare;
import com.offer.model.OfferInvite;
import com.offer.model.OfferInviteChat;
import com.offer.model.OfferJob;
import com.offer.model.OfferPhoto;
import com.offer.model.OfferUser;
import com.offer.model.OfferUserEducation;
import com.offer.model.OfferUserEmail;
import com.offer.model.OfferUserWorks;
import com.offer.model.TJ;
import com.offer.model.jlzssz;
import com.offer.service.BaseService;
import com.offer.service.OfferFirmInformationService;
import com.offer.service.OfferFirmProduceService;
import com.offer.service.OfferFirmReportService;
import com.offer.service.OfferFirmSelectService;
import com.offer.service.OfferFirmService;
import com.offer.service.OfferFirmTechnologyService;
import com.offer.service.OfferInviteChatService;
import com.offer.service.OfferInviteService;
import com.offer.service.OfferJobService;
import com.offer.service.OfferPhotoService;
import com.offer.service.OfferUserInformationService;
import com.offer.service.OfferUserService;
import com.offer.util.ChinaInitial;
import com.offer.util.Code;
import com.offer.util.ConUtil;
import com.offer.util.Encryption;
import com.offer.util.FileUtils;
import com.offer.util.GeneratePDF;
import com.offer.util.SendEmail;
import com.sun.org.apache.xpath.internal.operations.And;
import com.sun.tools.internal.ws.processor.model.Service;

@Controller
public class TestController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
   
	private void allMethods() {
		String aString = null;
		HttpServletRequest request = null;
		jobList1(request);//注册初始化
		register1(request, aString);//注册保存
		getmsg1(request, aString);//注册验证码
		login(request, aString);//登陆
		checkLogin(request);//检查各个页面的session
		checkNowLogin(request);//检查各个页面的session
		resumeAddInformationPage1(request);//用户信息填报初始化（基本信息）
		saveResumeAddInformation1(request, aString);//用户信息填报保存（基本信息）
		resumeAddPlanjobPage1(request, aString);//用户信息填报初始化（期望工作）
		saveresumeAddPlanjob1(request, aString);//用户信息填报保存（期望工作）
		resumeAddQuestionnairePage1(request, aString);//用户信息填报初始化（调查问卷）
		saveresumeAddQuestionnaire1(request, aString);//用户信息填报保存（调查问卷）
		resumeAddWorkexperiencePage1(request, aString);//用户信息填报初始化（个人经历）
		saveresumeAddWorkexperience1(request, aString);//用户信息填报保存（个人经历）--工作经历
		saveresumeAddWorkexperience2(request, aString);//用户信息填报保存（个人经历）--教育经历
		stafflog1(request, aString);//后台登陆
		userinformation1(request, aString);//后台候选人列表
		firmaccount1(request, aString);//后台企业账号设置页面初始化
		useraccount1(request, aString);//后台候选人账号设置页面初始化
		firmzhaopin1(request, aString);//后台企业招聘进度
		firmzhaopin2(request, aString);//后台企业招聘进度
		firmzhaopin3(request, aString);//后台企业招聘进度
		userqiuzhi1(request, aString);//后台用户求职进度左边
		userqiuzhi2(request, aString);//后台用户求职进度中间
		userqiuzhi3(request, aString);//后台用户求职进度右边
		saveresumeAddPlanjob1(request, aString);//用户信息填报保存（期望工作）
	}
   
   
	//登陆
	@ResponseBody
	@RequestMapping(value = "/login/user1", produces = "application/json")
	public Map<String, Object> login(HttpServletRequest request, @RequestBody String data) {
		try {
			putToForm(data);
//			form.get("type");//1、用户,2、企业
			Map<String, Object> map = new HashMap<String, Object>();
			OfferUser offerUser = offerUserService.islogin(form);
         if (offerUser != null) {
//            if("0".equals(offerUser.getStatus())){
//           	 return toJson(offerUser.getStatus());
//            }
            request.getSession().setAttribute("id", offerUser.getId());
            request.getSession().setAttribute("name", offerUser.getOfferUserName());
            request.getSession().setAttribute("password", offerUser.getOfferUserPassword());
            request.getSession().setAttribute("isoffer", offerUser.getIsoffer());
            if (offerUser.getIsoffer().equals("2")) {
               request.getSession().setAttribute("firmId", offerUser.getFirmId());
               List<OfferFirmSelect> offerFirmSelect = offerFirmSelectService.getOfferSelect(offerUser.getId() + "");
               if (offerFirmSelect.size() > 0) {
                  map.put("qytgdy", "true");//qytgdy=企业通过调研
               }
               else {
                  map.put("qytgdy", "false");//qytgdy=企业通过调研
               }
            }
            request.getSession().setAttribute("type", offerUser.getStatus());
            map.put("type", offerUser.getIsoffer());
            map.put("status", offerUser.getStatus());
            return toJson(map);
         }else {
        	    return toJson("loginError");
         }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		return toJson("loginError");//返回密码错误
		//用户
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("status", "1");如果用户没有填写过信息，跳1、如果企业没有填写过信息，跳1
//		map.put("status", "2");如果用户有填写过信息，跳2、如果企业有填写过信息，跳2
//		return toJson(map);
	}
	
	@ResponseBody
   @RequestMapping(value = "/login/checkLogin")
   public boolean checkLogin(HttpServletRequest request) {
	   boolean flag = false;
      try {
         flag = isResetLogin(request);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return flag;
   }
   
   @ResponseBody
   @RequestMapping(value = "/login/checkNowLogin")
   public Map<String, Object> checkNowLogin(HttpServletRequest request) {
      try {
         String userId = request.getSession().getAttribute("id") == null ? "" : request.getSession().getAttribute("id") + "";
         if ("".equals(userId)) {
            return toJson("caoshi");
         }
         Map<String, Object> map = new HashMap<String, Object>();
         OfferUser offerUser = offerUserService.getOfferUser(Integer.valueOf(userId));
         request.getSession().setAttribute("status", offerUser.getStatus());
         map.put("status", offerUser.getStatus());
         return toJson(map);
      } catch (Exception e) {
         e.printStackTrace();
         return toJson(ERROR);
      }
   }
	
	//注册
	//职位
	@ResponseBody
	@RequestMapping(value = "/register/jobList1", produces = "application/json")
	public Map<String, Object> jobList1(HttpServletRequest request) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, String>> nowJobList = new ArrayList<Map<String, String>>();
			List<Map<String, String>> jobFList = new ArrayList<Map<String, String>>();
			List<Map<String, String>> cityList = new ArrayList<Map<String, String>>();
			List<OfferJob> offerJobsOne = offerJobService.getAllJob("1");//parentId=1的,例如"Java工程师"
         for (int i = 0; i < offerJobsOne.size(); i++) {
            Map<String, String> m = new HashMap<String, String>();
            m.put("id", String.valueOf(offerJobsOne.get(i).getId()));
            m.put("value", offerJobsOne.get(i).getJobName());
            jobFList.add(m);
         }
			List<OfferJob> offerJobsTwo = offerJobService.getAllJob("2");//parentId=2的,例如"经理"
         for (int i = 0; i < offerJobsTwo.size(); i++) {
            Map<String, String> m = new HashMap<String, String>();
            m.put("id", String.valueOf(offerJobsTwo.get(i).getId()));
            m.put("value", offerJobsTwo.get(i).getJobName());
            nowJobList.add(m);
         }
         List<Map<String, String>> city = baseService.getDiShiCity("getAll");//所有的地市,getAll
         for (Map<String, String> map2 : city) {
            Map<String, String> m = new HashMap<String, String>();
            m.put("id", String.valueOf(map2.get("id")));
            m.put("value", map2.get("cityName"));
            cityList.add(m);
         }
			map.put("nowJob", nowJobList);
			map.put("jobF", jobFList);
			map.put("city", cityList);
			return toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toJson(null);
		//用户
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("status", "1");如果用户没有填写过信息，跳1、如果企业没有填写过信息，跳1
//		map.put("status", "2");如果用户有填写过信息，跳2、如果企业有填写过信息，跳2
//		return toJson(map);
	}
	//获取验证码
	@ResponseBody
	@RequestMapping(value = "/register/getmsg1", produces = "application/json")
	public Map<String, Object> getmsg1(HttpServletRequest request, @RequestBody String data) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return toJson(SUCCESS);
	}
	//注册
	@ResponseBody
	@RequestMapping(value = "/register/register1", produces = "application/json")
	public Map<String, Object> register1(HttpServletRequest request, @RequestBody String data) {
		try {
			putToForm(data);

         Map<String, String> newMap = new HashMap<String, String>();
         OfferUser offerUser = new OfferUser();
         String type = form.get("type");
         String email = "";
         boolean flag;
         if (type.equals("1")) {//用户
   			String jobFkey = form.get("jobFkey");//求职方向
   			String citykey = form.get("citykey");//所在城市
   			String offerUserPassword = form.get("offer_user_password");//密码
            email = form.get("email");//邮箱
//            flag = email.lastIndexOf("@") == -1;
//            if (flag) {
//               return toJson("邮箱格式不对，请重新输入邮箱！");
//            }
            offerUser.setOfferJobId(Integer.parseInt(jobFkey));
            offerUser.setOfferUserEmail(email);
            offerUser.setOfferUserCity(citykey);
            offerUser.setStatus("0");
            offerUser.setOfferUserPassword(offerUserPassword);
            offerUser.setIsoffer(type);
         }
         else {//企业
   			String offerUserCompany = form.get("offer_user_company");//公司
   			String offerUserName = form.get("offer_user_name");//姓名
   			String nowjobkey = form.get("nowjobkey");//目前职位
   			String offerUserPhone = form.get("offer_user_phone");//手机
   			String offerUserPassword = form.get("password");//密码
            email = form.get("offer_user_email");//邮箱

            
            offerUser.setOfferUserCompany(offerUserCompany);
            offerUser.setOfferUserName(offerUserName);
            offerUser.setOfferJobId(Integer.parseInt(nowjobkey));
            offerUser.setOfferUserEmail(email);
            offerUser.setOfferUserPhone(offerUserPhone);
            offerUser.setOfferUserPassword(offerUserPassword);
            offerUser.setStatus("0");
            offerUser.setIsoffer(type);
           
//   			newMap.put("endless", email.substring(email.lastIndexOf("@"), email.length()));

         }
         flag = offerUserService.haveEmail(email);
         if (!flag) {
            offerUserService.saveOfferUser4oj(offerUser);
            
            try {
                OfferUserEmail offerUserEmail = new OfferUserEmail();
                offerUserEmail.setImviteEmail("4");
                offerUserEmail.setSendTime(new Date());
                offerUserEmail.setShouUserId(offerUser.getId());
                offerUserEmail.setStatus("1");
                baseService.saveOfferUserEmail(offerUserEmail);
            	
               Map<String, String> emailMap = new HashMap<String, String>();
               OfferEmail offerEmail = baseService.getEmailContent('4').get(0);
               emailMap.put("toMail", email);
               emailMap.put("mailtitle", offerEmail.getEmailTitle());
               emailMap
                     .put("mailContent",
                           offerEmail
                                 .getEmailContext()
                                 .toString()
                                 .replace("[0]",
                                       "<a href='"+Code.fangwenPath + "/user/jihuoyouxiang.do?offerUserEmailId="+offerUserEmail.getId()+"&userIdString=" + offerUser.getId() + "&userStatus=" + 1+"'>" + Code.fangwenPath + "/user/jihuoyouxiang.do?offerUserEmailId="+offerUserEmail.getId()+"&userIdString=" + offerUser.getId() + "&userStatus=" + 1 + "</a>"));
               sendEmail.sendEmail(emailMap);

            }
            catch (Exception e) {
               e.printStackTrace();
            }
         }
         else {
            return toJson(ERROR);//有该账号的
         }
			return toJson(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
	      return toJson("系统错误！");
		}
	}
	//用户-基本信息页面
	@ResponseBody
	@RequestMapping(value = "/user/resumeAddInformationPage1", produces = "application/json")
	public Map<String, Object> resumeAddInformationPage1(HttpServletRequest request) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			String offerUserId = request.getSession().getAttribute("id") + "";
			Map<String, String> findMap = new HashMap<String, String>();
			findMap.put("offerUserId", offerUserId);
         String offerUserJob1Name, offerUserJob2Name, offerUserJob1, offerUserJob2;
         offerUserJob1Name = offerUserJob2Name = "";
			List<Map<String, String>> list = offerUserInformationService.getOfferUserInformationByOfferUserId(findMap);
			map.put("dataName", list.get(0).get("status").equals("4") ? "1" : "0");//.equals("1") ? "1" : "0"
			List<Map<String, String>> nowJobList = new ArrayList<Map<String, String>>();
			List<OfferJob> allOfferJobs = offerJobService.getAllJob("");//parentId=空的,给出所有的职位
			for (int i = 0; i < allOfferJobs.size(); i++) {
			   Map<String, String> nowJobMap = new HashMap<String, String>();
			   nowJobMap.put("id", String.valueOf(allOfferJobs.get(i).getId()));
			   nowJobMap.put("value", allOfferJobs.get(i).getJobName());
			   nowJobList.add(nowJobMap);
			}
			map.put("nowJobList", nowJobList);
		   offerUserJob1 = list.get(0).get("offerUserJob1") == null ? "" : String.valueOf(list.get(0).get("offerUserJob1"));
		   offerUserJob2 = list.get(0).get("offerUserJob2") == null ? "" : String.valueOf(list.get(0).get("offerUserJob2"));
		   if (list.get(0).get("offerUserInformationId") != null) {
		      request.getSession().setAttribute("offerUserInformationId", list.get(0).get("offerUserInformationId"));
		   }
         map.put("offerUserName", list.get(0).get("offerUserName"));
         map.put("offerUserSex", list.get(0).get("offerUserSex"));
         map.put("offerUserWorktime", list.get(0).get("offerUserWorktime"));
         map.put("offerUserZhihu", list.get(0).get("offerUserZhihu"));
         map.put("offerUserGithub", list.get(0).get("offerUserGithub"));
         map.put("offerUserBlog", list.get(0).get("offerUserBlog"));
         map.put("offerUserPersonWeb", list.get(0).get("offerUserPersonWeb"));
         if (!"".equals(offerUserJob1) && !"".equals(offerUserJob2)) {
            map.put("jobId1", offerUserJob1);
            map.put("jobId2", offerUserJob2);
            for (int i = 0; i < allOfferJobs.size(); i++) {
               if (allOfferJobs.get(i).getId().toString().equals(offerUserJob1)) {
                  offerUserJob1Name = allOfferJobs.get(i).getJobName();
               }
               if (allOfferJobs.get(i).getId().toString().equals(offerUserJob2)) {
                  offerUserJob2Name = allOfferJobs.get(i).getJobName();
               }
               if (!"".equals(offerUserJob1Name) && !"".equals(offerUserJob2Name)) {
                  break;
               }
            }
            map.put("jobId1", offerUserJob1);
            map.put("jobvalue1", offerUserJob1Name);
            map.put("jobId2", offerUserJob2);
            map.put("jobvalue2", offerUserJob2Name);
            map.put("jobs", offerUserJob1 + "," + offerUserJob2);
         }
         else if(!"".equals(offerUserJob1)) {
            for (int i = 0; i < allOfferJobs.size(); i++) {
               if (allOfferJobs.get(i).getId().toString().equals(offerUserJob1)) {
                  offerUserJob1Name = allOfferJobs.get(i).getJobName();
               }
               if (!"".equals(offerUserJob1Name)) {
                  break;
               }
            }
            map.put("jobId1", offerUserJob1);
            map.put("jobvalue1", offerUserJob1Name);
            map.put("jobs", offerUserJob1);
         }
         map.put("jobyear1", list.get(0).get("offerHaveExperience1"));//第一个岗位岗位上有多长时间的工作经验
         map.put("jobyear2", list.get(0).get("offerHaveExperience2"));//第二个岗位岗位上有多长时间的工作经验
         map.put("offerUserDescription", list.get(0).get("offerUserDescription"));
			//查询出来
//			map.put("jobId1", "1");
//			map.put("jobId2", "2");
//			map.put("jobvalue1", "经理1");
//			map.put("jobvalue2", "经理2");
//			map.put("jobs", "1,2");//选择职位的id
			return toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
			return toJson(ERROR);
		}
//		return toJson(SUCCESS);//(session保存用户id)
	}
	//用户-基本信息保存
	@ResponseBody
	@RequestMapping(value = "/user/saveResumeAddInformation1", produces = "application/json")
	public Map<String, Object> saveResumeAddInformation1(HttpServletRequest request, @RequestBody String data) {
		try {
			putToForm(data);
         String offerUserId = request.getSession().getAttribute("id") + "";
         String offerUserInformationId = request.getSession().getAttribute("offerUserInformationId") + "";
         form.put("offerUserId", offerUserId);
         form.put("offerUserInformationId", offerUserInformationId);
			offerUserInformationService.saveResumeAddInformation1(form);
		} catch (Exception e) {
			e.printStackTrace();
			return toJson(ERROR);
		}
		return toJson(SUCCESS);
	}
	//用户-期望工作页面
	@ResponseBody
	@RequestMapping(value = "/user/resumeAddPlanjobPage1", produces = "application/json")
	public Map<String, Object> resumeAddPlanjobPage1(HttpServletRequest request, @RequestBody String data) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<Map<String, String>> worksplaceList = new ArrayList<Map<String, String>>();
			List<Map<String, String>> cityList = new ArrayList<Map<String, String>>();
			List<Map<String, String>> firmList = new ArrayList<Map<String, String>>();
			List<Map<String, String>> citys = baseService.getDiShiCity("getAll");//所有的地市,getAll
			for (Map<String, String> map2 : citys) {
            Map<String, String> m = new HashMap<String, String>();
            m.put("id", String.valueOf(map2.get("id")));
            m.put("value", map2.get("cityName"));
            cityList.add(m);
         }
			for (Map<String, String> map2 : citys) {
            Map<String, String> m = new HashMap<String, String>();
            m.put("id", String.valueOf(map2.get("id")));
            m.put("value", map2.get("cityName"));
            worksplaceList.add(m);
         }
			List<Map<String, String>> offerStages = baseService.getOfferStage();
			for (Map<String, String> map2 : offerStages) {
			   Map<String, String> m = new HashMap<String, String>();
            m.put("id", String.valueOf(map2.get("id")));
            m.put("value", map2.get("offerStage"));
            firmList.add(m);
         }
         String offerUserId = request.getSession().getAttribute("id") + "";
         Map<String, String> findMap = new HashMap<String, String>();
         findMap.put("offerUserId", offerUserId);
         List<Map<String, String>> list = offerUserInformationService.getOfferUserInformationByOfferUserId(findMap);
         request.getSession().setAttribute("offerUserInformationId", list.get(0).get("offerUserInformationId"));
         map.put("dataName", list.get(0).get("status").equals("4") ? "1" : "0");//.equals("1") ? "1" : "0"
         String workplace = list.get(0).get("offerUserWorkPlace");
         String cityIds = list.get(0).get("offerCityId");
         String firmIds = list.get(0).get("offerUserLikeFirmStage");
         map.put("cityIdList", cityIds);
         map.put("firmIdList", firmIds);
         request.getSession().setAttribute("offerUserPlanWorkPlaceId", list.get(0).get("offerUserPlanWorkPlaceId"));
         map.put("workplace", workplace);
         map.put("workplaces", worksplaceList);
         map.put("citys", cityList);
         map.put("firms", firmList);
         
//			for(int i = 1; i < 8; i++){
//				Map<String, String> worksplaceMap = new HashMap<String, String>();
//				Map<String, String> cityMap = new HashMap<String, String>();
//				Map<String, String> firmMap = new HashMap<String, String>();
//				worksplaceMap.put("id", String.valueOf(i));
//				worksplaceMap.put("value", "工作"+String.valueOf(i));
//				cityMap.put("id", String.valueOf(i));
//				cityMap.put("value", "城市"+String.valueOf(i));
//				firmMap.put("id", String.valueOf(i));
//				firmMap.put("value", "公司"+String.valueOf(i));
//				worksplaceList.add(worksplaceMap);
//				cityList.add(cityMap);
//				firmList.add(firmMap);
//			}
//			firmIds.add("1");
//			firmIds.add("5");
//			map.put("firmIdList",firmIds);
//			修改
//			List<String> cityIds = new ArrayList<String>();
//			cityIds.add("1");
//			cityIds.add("2");
//			List<String> firmIds = new ArrayList<String>();
//			firmIds.add("1");
//			firmIds.add("5");
//			map.put("cityIdList",cityIds);
//			map.put("firmIdList",firmIds);
//			map.put("workplace", "workplace");
			return toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
	      return toJson(ERROR);
		}
//		return toJson(SUCCESS);
	}
	//用户-期望工作保存
	@ResponseBody
	@RequestMapping(value = "/user/saveresumeAddPlanjob1", produces = "application/json")
	public Map<String, Object> saveresumeAddPlanjob1(HttpServletRequest request, @RequestBody String data) {
		try {
			putToForm(data);
			String offerUserId = request.getSession().getAttribute("id") + "";
         String offerUserInformationId = request.getSession().getAttribute("offerUserInformationId") + "";
         String offerUserPlanWorkPlaceId = request.getSession().getAttribute("offerUserPlanWorkPlaceId") + "";
         form.put("offerUserId", offerUserId);
         form.put("offerUserInformationId", offerUserInformationId);
         form.put("offerUserPlanWorkPlaceId", offerUserPlanWorkPlaceId);
         offerUserInformationService.saveResumeAddPlanjob1(form);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toJson(SUCCESS);
	}
	//用户-工作经历页面
	@ResponseBody
	@RequestMapping(value = "/user/resumeAddWorkexperiencePage1", produces = "application/json")
	public Map<String, Object> resumeAddWorkexperiencePage1(HttpServletRequest request, @RequestBody String data) {
		try {
		   Map<String, Object> map = new HashMap<String, Object>();
		   String offerUserId = request.getSession().getAttribute("id") + "";
         Map<String, String> findMap = new HashMap<String, String>();
         findMap.put("offerUserId", offerUserId);
         List<Map<String, String>> list = offerUserInformationService.getOfferUserInformationByOfferUserId(findMap);
         map.put("dataName", list.get(0).get("status").equals("4") ? "1" : "0");//.equals("1") ? "1" : "0"
         List<OfferUserWorks> offerUserWorks = baseService.getOfferUserWorks(offerUserId);
         List<Map<String, String>> listWorks = new ArrayList<Map<String,String>>();
         if (offerUserWorks.size() > 0) {
            OfferUserWorks offerUserWork = offerUserWorks.get(offerUserWorks.size() - 1);
            map.put("firmName", offerUserWork.getOldFirmName());
            map.put("jobName", offerUserWork.getJobName());
            map.put("jobstart", offerUserWork.getStartTime());
            map.put("jobend", offerUserWork.getEndTime());
            map.put("workcontent", offerUserWork.getJobDescript());
            map.put("offerUserWorksId", offerUserWork.getId());
            if (offerUserWorks.size() > 1) {
               for (int i = 0; i < offerUserWorks.size() - 1; i++) {
                  Map<String, String> newMap = new HashMap<String, String>();
                  newMap.put("firmName", returnString(offerUserWorks.get(i).getOldFirmName()));
                  newMap.put("jobName", returnString(offerUserWorks.get(i).getJobName()));
                  newMap.put("jobstart", returnString(offerUserWorks.get(i).getStartTime()));
                  newMap.put("jobend", returnString(offerUserWorks.get(i).getEndTime()));
                  newMap.put("workcontent", returnString(offerUserWorks.get(i).getJobDescript()));
                  newMap.put("thisId", returnString(offerUserWorks.get(i).getId()));
                  listWorks.add(newMap);
               }
            }
         }
         map.put("otherWorks", listWorks);
         List<OfferUserEducation> offerUserEducations = baseService.getOfferUserEducations(offerUserId);
         List<Map<String, String>> listEducation = new ArrayList<Map<String,String>>();
         if (offerUserEducations.size() > 0) {
            OfferUserEducation offerUserEducation = offerUserEducations.get(offerUserEducations.size() - 1);
            map.put("schoolName", offerUserEducation.getSchoolName());
            map.put("xueli", offerUserEducation.getOfferUserXueli());
            map.put("studstart", offerUserEducation.getStarTime());
            map.put("studend", offerUserEducation.getEndTime());
            map.put("zhuanye", offerUserEducation.getUserMajor());
            map.put("offerUserEducationId", offerUserEducation.getId());
            if (offerUserEducations.size() > 1) {
               for (int i = 0; i < offerUserEducations.size() - 1; i++) {
                  Map<String, String> newMap = new HashMap<String, String>();
                  newMap.put("schoolName", returnString(offerUserEducations.get(i).getSchoolName()));
                  newMap.put("xueli", returnString(offerUserEducations.get(i).getOfferUserXueli()));
                  newMap.put("zhuanye", returnString(offerUserEducations.get(i).getUserMajor()));
                  newMap.put("studstart", returnString(offerUserEducations.get(i).getStarTime()));
                  newMap.put("studend", returnString(offerUserEducations.get(i).getEndTime()));
                  newMap.put("thisId", returnString(offerUserEducations.get(i).getId()));
                  listEducation.add(newMap);
               }
            }
         }
         map.put("otherEducate", listEducation);
         return toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
			return toJson(ERROR);
		}
	}
	@ResponseBody
   @RequestMapping(value = "/user/saveWork", produces = "application/json")
   public Map<String, Object> saveWork(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         String offerUserId = request.getSession().getAttribute("id") + "";
         form.put("offerUserId", offerUserId);
         offerUserInformationService.saveResumeAddWorkexperience1(form);
         return toJson(SUCCESS);
      }
      catch (Exception e) {
         e.printStackTrace();
         return toJson(ERROR);
      }
	}
   @ResponseBody
   @RequestMapping(value = "/user/saveEdu", produces = "application/json")
   public Map<String, Object> saveEdu(HttpServletRequest request, @RequestBody String data) {
      try {
         putToForm(data);
         String offerUserId = request.getSession().getAttribute("id") + "";
         form.put("offerUserId", offerUserId);
         offerUserInformationService.saveresumeAddWorkexperience2(form);
         return toJson(SUCCESS);
      }
      catch (Exception e) {
         e.printStackTrace();
         return toJson(ERROR);
      }
   }
	//用户-工作经历(工作经历)保存
	@ResponseBody
	@RequestMapping(value = "/user/saveresumeAddWorkexperience1", produces = "application/json")
	public Map<String, Object> saveresumeAddWorkexperience1(HttpServletRequest request, @RequestBody String data) {
		try {
			putToForm(data);
			String offerUserId = request.getSession().getAttribute("id") + "";
         form.put("offerUserId", offerUserId);
         offerUserInformationService.saveResumeAddWorkexperience1(form);
         Map<String, Object> map = new HashMap<String, Object>();
         List<OfferUserWorks> offerUserWorks = baseService.getOfferUserWorks(offerUserId);
         List<Map<String, String>> listWorks = new ArrayList<Map<String,String>>();
         for (int i = 0; i < offerUserWorks.size(); i++) {
            Map<String, String> newMap = new HashMap<String, String>();
            newMap.put("firmName", returnString(offerUserWorks.get(i).getOldFirmName()));
            newMap.put("jobName", returnString(offerUserWorks.get(i).getJobName()));
            newMap.put("jobstart", returnString(offerUserWorks.get(i).getStartTime()));
            newMap.put("jobend", returnString(offerUserWorks.get(i).getEndTime()));
            newMap.put("workcontent", returnString(offerUserWorks.get(i).getJobDescript()));
            newMap.put("thisId", returnString(offerUserWorks.get(i).getId()));
            listWorks.add(newMap);
         }
         map.put("otherWorks", listWorks);
         return toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
			return toJson(ERROR);
		}
	}
	
	//用户-工作经历(教育经历)保存
	@ResponseBody
	@RequestMapping(value = "/user/saveresumeAddWorkexperience2", produces = "application/json")
	public Map<String, Object> saveresumeAddWorkexperience2(HttpServletRequest request, @RequestBody String data) {
		try {
			putToForm(data);
			String offerUserId = request.getSession().getAttribute("id") + "";
         form.put("offerUserId", offerUserId);
			offerUserInformationService.saveresumeAddWorkexperience2(form);
			Map<String, Object> map = new HashMap<String, Object>();
			List<OfferUserEducation> offerUserEducations = baseService.getOfferUserEducations(offerUserId);
         List<Map<String, String>> listEducation = new ArrayList<Map<String,String>>();
			for (int i = 0; i < offerUserEducations.size(); i++) {
            Map<String, String> newMap = new HashMap<String, String>();
            newMap.put("schoolName", returnString(offerUserEducations.get(i).getSchoolName()));
            newMap.put("xueli", returnString(offerUserEducations.get(i).getOfferUserXueli()));
            newMap.put("zhuanye", returnString(offerUserEducations.get(i).getUserMajor()));
            newMap.put("studstart", returnString(offerUserEducations.get(i).getStarTime()));
            newMap.put("studend", returnString(offerUserEducations.get(i).getEndTime()));
            newMap.put("thisId", returnString(offerUserEducations.get(i).getId()));
            listEducation.add(newMap);
         }
         map.put("otherEducate", listEducation);
			return toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
			return toJson(ERROR);
		}
	}
	//用户-调查问卷页面
	@ResponseBody
	@RequestMapping(value = "/user/resumeAddQuestionnairePage1", produces = "application/json")
	public Map<String, Object> resumeAddQuestionnairePage1(HttpServletRequest request, @RequestBody String data) {
		try {
		   String offerUserId = request.getSession().getAttribute("id") + "";
		   Map<String, String> findMap = new HashMap<String, String>();
         findMap.put("offerUserId", offerUserId);
         List<Map<String, String>> list = offerUserInformationService.getOfferUserInformationByOfferUserId(findMap);
         String planYearWages = list.get(0).get("offerUserPlanYearWages") == null ? "" : String.valueOf(list.get(0).get("offerUserPlanYearWages"));
         String getHowMonthWages = list.get(0).get("offerGetHowMonthWages") == null ? "" : String.valueOf(list.get(0).get("offerGetHowMonthWages")); 
         String getHowWagesEveryMonth = list.get(0).get("offerEveryMonthWages") == null ? "" : String.valueOf(list.get(0).get("offerEveryMonthWages")); 
         String offerNowGetMoneyType = list.get(0).get("offerNowGetMoneyType") == null ? "" : String.valueOf(list.get(0).get("offerNowGetMoneyType")); 
         String offerPlanGetMoneyType = list.get(0).get("offerPlanGetMoneyType") == null ? "" : String.valueOf(list.get(0).get("offerPlanGetMoneyType")); 
         String jobstatus = list.get(0).get("offerJobStatus");
         String intime = list.get(0).get("offerUserWhenWork");
         String offerRequestNextJob = list.get(0).get("offerRequestNextJob");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("dataName", list.get(0).get("status").equals("4") ? "1" : "0");//.equals("1") ? "1" : "0"
			List<Map<String, String>> moneytypeList = new ArrayList<Map<String,String>>();
			List<Map<String, String>> listOfmoneyType = baseService.getOfferMoneyType();
			for(Map<String, String> map2 : listOfmoneyType){
				Map<String, String> moneytypeMap = new HashMap<String, String>();
				moneytypeMap.put("id", String.valueOf(map2.get("id")));
				moneytypeMap.put("value", map2.get("offerMoneyType"));
				moneytypeList.add(moneytypeMap);
			}
			if (!"null".equals(jobstatus)) {
	         if ("不着急找工作，先看看机会".equals(jobstatus)) {
	            map.put("jobstatus", "j1");
	         }
	         else if ("已经有offer了，想看更好的".equals(jobstatus)) {
               map.put("jobstatus", "j2");
	         }
	         else if ("正在找工作，还没有offer".equals(jobstatus)) {
               map.put("jobstatus", "j3");
	         }
	         else if ("暂时不考虑换工作".equals(jobstatus)) {
               map.put("jobstatus", "j4");
	         }
	      }
			if (!"null".equals(intime)) {
            if ("目前是离职状态，随时可以入职".equals(intime)) {
               map.put("intime", "i1");
            }
            else if ("一周".equals(intime)) {
               map.put("intime", "i2");
            }
            else if ("一个月".equals(intime)) {
               map.put("intime", "i3");
            }
            else if ("不确定".equals(intime)) {
               map.put("intime", "i4");
            }
         }
			map.put("monthmoney", getHowMonthWages);
			map.put("month", getHowWagesEveryMonth);
			map.put("moneytypeList", moneytypeList);
			map.put("nowmoneytype", offerNowGetMoneyType);
			map.put("planmoneytype", offerPlanGetMoneyType);
			map.put("offerRequestNextJob", offerRequestNextJob);
			map.put("planmoney", planYearWages);
			return toJson(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toJson(SUCCESS);
	}
	//用户-调查问卷保存
	@ResponseBody
	@RequestMapping(value = "/user/saveresumeAddQuestionnaire1", produces = "application/json")
	public Map<String, Object> saveresumeAddQuestionnaire1(HttpServletRequest request, @RequestBody String data) {
		try {
			putToForm(data);
			String offerUserId = request.getSession().getAttribute("id") + "";
			String offerUserInformationId = request.getSession().getAttribute("offerUserInformationId") + "";
			form.put("offerUserId", offerUserId);
			form.put("offerUserInformationId", offerUserInformationId);
			offerUserInformationService.saveresumeAddQuestionnaire1(form);
			
			
//	    	Map<String, String> emailMap = new HashMap<String, String>();
//	    	OfferEmail offerEmail = baseService.getEmailContent('4').get(0);
//	    	OfferUser offerUser = offerUserService.getOfferUser(offerUserId);
//	        emailMap.put("toMail", offerUser.getOfferUserEmail());
//	        emailMap.put("mailtitle", offerEmail.getEmailTitle());
//	        emailMap.put("mailContent", offerEmail.getEmailContext().toString().replace("[0]", "<a>"+Code.fangwenPath+"/user/jihuoyouxiang.do?userIdString="+offerUserId+"&userStatus="+4+"</a>"));
//	        sendEmail.sendEmail(emailMap);
		} catch (Exception e) {
			e.printStackTrace();
			return toJson(ERROR);
		}
		return toJson(SUCCESS);
	}
	//个人设置页面                                      ----------------------  （下面开始未完成）（以上暂时不要修改吧）
//	@ResponseBody
//	@RequestMapping(value = "/user/personalsettingsPage1", produces = "application/json")
//	public Map<String, Object> personalsettingsPage1(HttpServletRequest request, @RequestBody String data) {
//		try {
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("account", "945319791@qq.com");
//			map.put("phone", "1333245345");
//			map.put("isAccountPhone", "1");
//			map.put("emailmsg", "0");
//			return toJson(map);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return toJson(SUCCESS);
//	}
	//个人设置保存
//	@ResponseBody
//	@RequestMapping(value = "/user/savepersonalsettings1", produces = "application/json")
//	public Map<String, Object> savepersonalsettings1(HttpServletRequest request, @RequestBody String data) {
//		try {
//			putToForm(data);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return toJson(SUCCESS);
//	}
//	// 我的简历
//	@ResponseBody
//	@RequestMapping(value = "/user/resumeeditPage1", produces = "application/json")
//	public Map<String, Object> resumeeditPage1(HttpServletRequest request, @RequestBody String data) {
//		try {
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("integrity", "70%");
//			map.put("information", "1");
//			map.put("skill", "1");
//			map.put("work", "1");
//			map.put("education", "1");
//			map.put("project", "1");
//			map.put("description", "1");
//			map.put("works", "0");
//			map.put("protect", "0");
//			
//			Map<String, String> informationMap1 = new HashMap<String, String>();
//			informationMap1.put("userPhoto", "../img/changjinglu.jpg");
//			informationMap1.put("userName", "YY");
//			informationMap1.put("simpleResume", "男25");
//			informationMap1.put("email", "945319791@qq.com");
//			informationMap1.put("phone", "12347899");
//			map.put("informationTd1", informationMap1);
//			
//			Map<String, Object> informationMap2 = new HashMap<String, Object>();
//			informationMap2.put("userName", "YY");
//			List<Map<String, String>> informationList2 = new ArrayList<Map<String, String>>();
//			for(int i = 0; i < 10; i++){
//				Map<String, String> informationListMap2 = new HashMap<String, String>();
//				informationListMap2.put("str", "目前"+String.valueOf(i));
//				informationList2.add(informationListMap2);
//			}
//			informationMap2.put("informationList2", informationList2);
//			map.put("informationTd2", informationMap2);
//			
//			Map<String, Object> skillMap = new HashMap<String, Object>();
//			List<Map<String, String>> skillList1 = new ArrayList<Map<String, String>>();
//			for(int i = 0; i < 5; i++){
//				Map<String, String> skillMap1 = new HashMap<String, String>();
//				skillMap1.put("str", "技能"+String.valueOf(i));
//				skillList1.add(skillMap1);
//			}
//			List<Map<String, String>> skillList2 = new ArrayList<Map<String, String>>();
//			for(int i = 0; i < 5; i++){
//				Map<String, String> skillMap2 = new HashMap<String, String>();
//				skillMap2.put("str", "javascript"+String.valueOf(i));
//				skillList2.add(skillMap2);
//			}
//			skillMap.put("skillList1", skillList1);
//			skillMap.put("skillList2", skillList2);
//			map.put("skillTd", skillMap);
//			
//			Map<String, Object> workMap = new HashMap<String, Object>();
//			workMap.put("str", "aidfiausbdifubasdiu");
//			map.put("workTd", workMap);
//			
//			Map<String, Object> educationMap = new HashMap<String, Object>();
//			List<Map<String, String>> educationList = new ArrayList<Map<String, String>>();
//			for(int i = 0; i < 5; i++){
//				Map<String, String> educationMap2 = new HashMap<String, String>();
//				educationMap2.put("str", "我"+String.valueOf(i));
//				educationList.add(educationMap2);
//			}
//			educationMap.put("educationList", educationList);
//			map.put("educationTd", educationMap);
//			
//			Map<String, Object> descriptionMap = new HashMap<String, Object>();
//			descriptionMap.put("str", "aidfiausbdifubasdiu");
//			map.put("descriptionTd", descriptionMap);
//			
//			Map<String, Object> worksMap = new HashMap<String, Object>();
//			worksMap.put("str", "aidfiausbdifubasdiu");
//			map.put("worksTd", worksMap);
//			
//			Map<String, Object> protectMap = new HashMap<String, Object>();
//			protectMap.put("str", "aidfiausbdifubasdiu");
//			map.put("protectTd", protectMap);
//			return toJson(map);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return toJson(SUCCESS);
//	}
	
	// pdf
 
//   //个人简历-编辑
// 	@ResponseBody
// 	@RequestMapping(value = "/user/editcontentPage1", produces = "application/json")
// 	public Map<String, Object> editcontentPage1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			Map<String, String> map = new HashMap<String, String>();
// 			if("description".equals(data)){
// 				String editcontent = "aniufiuabfiuabs123";
// 				map.put("editcontent", editcontent);
// 			}
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//个人简历保存
// 	@ResponseBody
// 	@RequestMapping(value = "/user/saveeditcontent1", produces = "application/json")
// 	public Map<String, Object> saveeditcontent1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			putToForm(data);
// 			form.get("edittype");
// 			form.get("editcontent");
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
 	
// 	//公司简历页面                                                              -----------------（正在做）
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/firmresumeaddPage1", produces = "application/json")
// 	public Map<String, Object> firmresumeaddPage1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			List<String> firmList = new ArrayList<String>();
// 			for(int i = 0; i < 10; i++){
// 				String firmName = "公司" + String.valueOf(i);
// 				firmList.add(firmName);
// 			}
// 			map.put("firmList", firmList);
// 			
// 			List<Map<String, String>> firmareaList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> firmareaMap = new HashMap<String, String>();
// 				firmareaMap.put("id", String.valueOf(i));
// 				firmareaMap.put("value", "领域" + String.valueOf(i));
// 				firmareaList.add(firmareaMap);
// 			}
// 			map.put("firmareaList", firmareaList);
// 			
// 			List<Map<String, String>> firmCreateYearList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> firmCreateYearMap = new HashMap<String, String>();
// 				firmCreateYearMap.put("id", String.valueOf(i));
// 				firmCreateYearMap.put("value", "成立时间" + String.valueOf(i));
// 				firmCreateYearList.add(firmCreateYearMap);
// 			}
// 			map.put("firmCreateYearList", firmCreateYearList);
// 			
// 			List<Map<String, String>> firmsizeList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> firmsizeMap = new HashMap<String, String>();
// 				firmsizeMap.put("id", String.valueOf(i));
// 				firmsizeMap.put("value", "公司规模" + String.valueOf(i));
// 				firmsizeList.add(firmsizeMap);
// 			}
// 			map.put("firmsizeList", firmsizeList);
// 			
// 			List<Map<String, String>> firmTeamSizeList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> firmTeamSizeMap = new HashMap<String, String>();
// 				firmTeamSizeMap.put("id", String.valueOf(i));
// 				firmTeamSizeMap.put("value", "团队规模" + String.valueOf(i));
// 				firmTeamSizeList.add(firmTeamSizeMap);
// 			}
// 			map.put("firmTeamSizeList", firmTeamSizeList);
// 			
// 			List<Map<String, String>> firmStageList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> firmStageMap = new HashMap<String, String>();
// 				firmStageMap.put("id", String.valueOf(i));
// 				firmStageMap.put("value", "融资" + String.valueOf(i));
// 				firmStageList.add(firmStageMap);
// 			}
// 			map.put("firmStageList", firmStageList);
// 			map.put("type", "edit");
// 			//修改
// 			map.put("firmArea","firmArea");
// 			map.put("firmAreaValue","firmAreaValue");
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//公司简历保存                                -----------------（正在做）
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/savefirmresumeadd1", produces = "application/json")
// 	public Map<String, Object> savefirmresumeadd1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			List<String> firmList = new ArrayList<String>();
// 			for(int i = 0; i < 10; i++){
// 				String firmName = "公司" + String.valueOf(i);
// 				firmList.add(firmName);
// 			}
// 			map.put("firms", firmList);
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//企业审核失败重新提交页面
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/examinefirmPage1", produces = "application/json")
// 	public Map<String, Object> examinefirmPage1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			List<Map<String, String>> firmStageList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> firmStageMap = new HashMap<String, String>();
// 				firmStageMap.put("id", String.valueOf(i));
// 				firmStageMap.put("value", "融资" + String.valueOf(i));
// 				firmStageList.add(firmStageMap);
// 			}
// 			map.put("firmStageList", firmStageList);
// 			
// 			List<Map<String, String>> cityList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> firmStageMap = new HashMap<String, String>();
// 				firmStageMap.put("id", String.valueOf(i));
// 				firmStageMap.put("value", "城市" + String.valueOf(i));
// 				cityList.add(firmStageMap);
// 			}
// 			map.put("cityList", cityList);
// 			
// 			List<Map<String, String>> xuqiuList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> firmStageMap = new HashMap<String, String>();
// 				firmStageMap.put("id", String.valueOf(i));
// 				firmStageMap.put("value", "需求" + String.valueOf(i));
// 				xuqiuList.add(firmStageMap);
// 			}
// 			map.put("xuqiuList", xuqiuList);
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//企业审核失败重新提交保存
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/saveexaminefirm1", produces = "application/json")
// 	public Map<String, Object> saveexaminefirm1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			List<String> firmList = new ArrayList<String>();
// 			for(int i = 0; i < 10; i++){
// 				String firmName = "公司" + String.valueOf(i);
// 				firmList.add(firmName);
// 			}
// 			map.put("firms", firmList);
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//筛选候选人页面1
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/userviewPage1", produces = "application/json")
// 	public Map<String, Object> userviewPage1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			map.put("interview1", "1");
// 			map.put("interview2", "2");
// 			map.put("interview3", "3");
// 			map.put("interview4", "4");
// 			map.put("interview5", "5");
// 			map.put("interview6", "6");
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//筛选候选人页面2
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/userviewPage2", produces = "application/json")
// 	public Map<String, Object> userviewPage2(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			putToForm(data);
// 			form.get("usertype");
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			map.put("userId", "1");//第一个用户id
// 			List<Map<String, String>> userList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> userMap = new HashMap<String, String>();
// 				userMap.put("id", String.valueOf(i));
// 				userMap.put("imgpath", "../img/changjinglu.jpg");
// 				userMap.put("name", "y先生");
// 				userMap.put("job", "职位");
// 				userMap.put("money", "薪资");
// 				userMap.put("time", "发送时间在13分钟之前");
// 				userList.add(userMap);
// 			}
// 			map.put("userList", userList);
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//筛选候选人页面3
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/userviewPage3", produces = "application/json")
// 	public Map<String, Object> userviewPage3(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			putToForm(data);
// 			form.get("usertype");
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			map.put("userId", "1");//第一个用户id
// 			Map<String, String> headMap = new HashMap<String, String>();
// 			headMap.put("workplace", "工作地址");
// 			headMap.put("job", "java");
// 			headMap.put("money", "10w");
// 			headMap.put("name", "y先生");
// 			map.put("head", headMap);
// 			
// 			List<Map<String, String>> commitList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> commitMap = new HashMap<String, String>();
// 				commitMap.put("image", "../img/changjinglu.jpg");
// 				commitMap.put("name", "应聘人"+String.valueOf(i));
// 				commitMap.put("time", "2017-3-7");
// 				commitMap.put("content", "淘汰");
// 				commitList.add(commitMap);
// 			}
// 			map.put("commit", commitList);
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//筛选候选人安排页面
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/userviewanpaiPage3", produces = "application/json")
// 	public Map<String, Object> userviewanpaiPage3(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			List<Map<String, String>> interviewtimeList1 = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 1; i++){
// 				Map<String, String> timeMap = new HashMap<String, String>();
// 				timeMap.put("id", String.valueOf(i));
// 				timeMap.put("value", "time"+String.valueOf(i));
// 				interviewtimeList1.add(timeMap);
// 			}
// 			map.put("interviewtimeList1", interviewtimeList1);
// 			List<Map<String, String>> interviewtimeList2 = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 1; i++){
// 				Map<String, String> timeMap = new HashMap<String, String>();
// 				timeMap.put("id", String.valueOf(i));
// 				timeMap.put("value", "time"+String.valueOf(i));
// 				interviewtimeList2.add(timeMap);
// 			}
// 			map.put("interviewtimeList2", interviewtimeList2);
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//筛选候选人页面3保存
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/saveuserview3", produces = "application/json")
// 	public Map<String, Object> saveuserview3(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			putToForm(data);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//面试页面
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/interviewPage1", produces = "application/json")
// 	public Map<String, Object> interviewPage1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			map.put("interview1", "1");
// 			map.put("interview2", "2");
// 			map.put("interview3", "3");
// 			map.put("interview4", "4");
// 			map.put("interview5", "5");
// 			map.put("interview6", "6");
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//面试页面2
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/interviewPage2", produces = "application/json")
// 	public Map<String, Object> interviewPage2(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			putToForm(data);
// 			form.get("interviewtype");
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			map.put("firmId", "1");//第一个用户id
// 			List<Map<String, String>> firmList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> firmMap = new HashMap<String, String>();
// 				firmMap.put("id", String.valueOf(i));
// 				firmMap.put("imgpath", "../img/changjinglu.jpg");
// 				firmMap.put("address", "广州");
// 				firmMap.put("job", "职位");
// 				firmMap.put("money", "薪资");
// 				firmMap.put("time", "发送时间在13分钟之前");
// 				firmList.add(firmMap);
// 			}
// 			map.put("firmList", firmList);
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//面试页面3
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/interviewPage3", produces = "application/json")
// 	public Map<String, Object> interviewPage3(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			putToForm(data);
// 			form.get("interviewtype");
// 			form.get("firmId");
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			map.put("firmName", "广州公司");
// 			map.put("firmLogo", "../img/changjinglu.jpg");
// 			map.put("firmAddress", "广州");
// 			map.put("firmJob", "java工程师");
// 			map.put("firmMoney", "13k-14k");
// 			map.put("firmQiQuan", "无");
// 			map.put("firmResume", "公司很牛逼");
// 			
// 			List<Map<String, String>> commitList = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> commitMap = new HashMap<String, String>();
// 				commitMap.put("image", "../img/changjinglu.jpg");
// 				commitMap.put("name", "应聘人"+String.valueOf(i));
// 				commitMap.put("time", "2017-3-7");
// 				commitMap.put("content", "淘汰");
// 				commitList.add(commitMap);
// 			}
// 			map.put("commit", commitList);
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//面试页面3保存
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/saveinterview3", produces = "application/json")
// 	public Map<String, Object> saveinterview3(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			putToForm(data);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//筛选用户
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/finduserPage1", produces = "application/json")
// 	public Map<String, Object> finduserPage1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			List<Map<String, String>> saved = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> savedMap = new HashMap<String, String>();
// 				savedMap.put("id", String.valueOf(i));
// 				savedMap.put("value", "保存"+String.valueOf(i));
// 				saved.add(savedMap);
// 			}
// 			map.put("saved", saved);
// 			
// 			List<Map<String, String>> city = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> cityMap = new HashMap<String, String>();
// 				cityMap.put("id", String.valueOf(i));
// 				cityMap.put("value", "城市"+String.valueOf(i));
// 				city.add(cityMap);
// 			}
// 			map.put("city", city);
// 			
// 			List<Map<String, String>> job = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> savedMap = new HashMap<String, String>();
// 				savedMap.put("id", String.valueOf(i));
// 				savedMap.put("value", "职位"+String.valueOf(i));
// 				job.add(savedMap);
// 			}
// 			map.put("job", job);
// 			
// 			List<Map<String, String>> worked = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> savedMap = new HashMap<String, String>();
// 				savedMap.put("id", String.valueOf(i));
// 				savedMap.put("value", "工作"+String.valueOf(i));
// 				worked.add(savedMap);
// 			}
// 			map.put("worked", worked);
// 			
// 			List<Map<String, String>> citybutton = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 1; i++){
// 				Map<String, String> savedMap = new HashMap<String, String>();
// 				savedMap.put("id", String.valueOf(i));
// 				savedMap.put("value", "城市"+String.valueOf(i));
// 				citybutton.add(savedMap);
// 			}
// 			map.put("citybutton", citybutton);
// 			
// 			List<Map<String, String>> jobbutton = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 1; i++){
// 				Map<String, String> savedMap = new HashMap<String, String>();
// 				savedMap.put("id", String.valueOf(i));
// 				savedMap.put("value", "职位"+String.valueOf(i));
// 				jobbutton.add(savedMap);
// 			}
// 			map.put("jobbutton", jobbutton);
// 			
// 			List<Map<String, String>> workbutton = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 1; i++){
// 				Map<String, String> savedMap = new HashMap<String, String>();
// 				savedMap.put("id", String.valueOf(i));
// 				savedMap.put("value", "工作"+String.valueOf(i));
// 				workbutton.add(savedMap);
// 			}
// 			map.put("workbutton", workbutton);
// 			
// 			map.put("allnum", "20");
// 			map.put("pairnum", "10");
// 			map.put("u1", 10);
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//筛选用户保存
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/savefinduser1", produces = "application/json")
// 	public Map<String, Object> savefinduser1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			putToForm(data);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//筛选用户列表页面
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/findusersum1", produces = "application/json")
// 	public Map<String, Object> findusersum1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			Map<String, Object> map = new HashMap<String, Object>();
// 			List<Map<String, String>> userresume = new ArrayList<Map<String, String>>();
// 			for(int i = 0; i < 10; i++){
// 				Map<String, String> savedMap = new HashMap<String, String>();
// 				savedMap.put("id", String.valueOf(i));
// 				savedMap.put("school", "学校");
// 				savedMap.put("resume", "自我介绍");
// 				savedMap.put("nowyearwages", "女 28岁 现居住北京|C/C++工程师算法工程师|期望年薪34万");
// 				savedMap.put("username", "y公举");
// 				savedMap.put("photopath", "../img/changjinglu.jpg");
// 				userresume.add(savedMap);
// 			}
// 			map.put("userresume", userresume);
// 			
// 			return toJson(map);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
// 	//筛选用户修改用户状态
// 	@ResponseBody
// 	@RequestMapping(value = "/firm/selectfindusersum1", produces = "application/json")
// 	public Map<String, Object> selectfindusersum1(HttpServletRequest request, @RequestBody String data) {
// 		try {
// 			putToForm(data);
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return toJson(SUCCESS);
// 	}
 	//管理账号页面
 	@ResponseBody
 	@RequestMapping(value = "/manager/accoutPageType", produces = "application/json")
 	public Map<String, Object> accoutPageType(HttpServletRequest request, @RequestBody String data) {
 		try {
			OfferUser offerUser = offerUserService.getOfferUser(Integer.valueOf(data));
			if(offerUser != null){
				if(returnString(offerUser.getGuwenSelect()).equals("")){
					return toJson("0");
				}
				return toJson(returnString(offerUser.getGuwenSelect()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
 		return toJson(SUCCESS);
 	}
 	@ResponseBody
 	@RequestMapping(value = "/manager/saveAccoutPageType", produces = "application/json")
 	public Map<String, Object> saveAccoutPageType(HttpServletRequest request, @RequestBody String data) {
 		try {
 			String id = request.getParameter("id").toString();
 			OfferUser offerUser = offerUserService.getOfferUser(Integer.valueOf(id));
 			offerUser.setGuwenSelect(data);
 			offerUserService.updateOfferUser(offerUser);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	//管理账号页面
 	@ResponseBody
 	@RequestMapping(value = "/manager/accoutPage1", produces = "application/json")
 	public Map<String, Object> accoutPage1(HttpServletRequest request, @RequestBody String data) {
 		try {
 			Map<String, Object> map = new HashMap<String, Object>();
 			Map<String, String> isofferMap = new HashMap<String, String>();
 			isofferMap.put("1", "候选人");
 			isofferMap.put("2", "企业");
 			isofferMap.put("3", "顾问");
 			isofferMap.put("4", "管理员");
 			List<Map<String, String>> accout = new ArrayList<Map<String, String>>();
 			List<OfferUser> offerUsers = offerUserService.getAllsOfferUser();
 			int j = 0;
 			for(int i = 0; i < offerUsers.size(); i++){
 			   if (offerUsers.get(i).getIsoffer().equals("1") || offerUsers.get(i).getIsoffer().equals("2")) continue;
 				Map<String, String> accoutMap = new HashMap<String, String>();
 				accoutMap.put("id", offerUsers.get(i).getId().toString());
 				accoutMap.put("name", offerUsers.get(i).getOfferUserName());
 				accoutMap.put("address", offerUsers.get(i).getOfferUserEmail());
 				accoutMap.put("password", offerUsers.get(i).getOfferUserPassword());
 				accoutMap.put("type", isofferMap.get(returnString(offerUsers.get(i).getIsoffer())));
 				accoutMap.put("status", offerUsers.get(i).getStatus());
 				j++;
 				accout.add(accoutMap);
 			}
 			map.put("num", j);
 			map.put("accoutList", accout);
 			List<Map<String, String>> types = new ArrayList<Map<String, String>>();
 			Map<String, String> typeMap = new HashMap<String, String>();
 			typeMap.put("id", "0");
 			typeMap.put("value", "企业");
 			types.add(typeMap);
 			Map<String, String> typeMap2 = new HashMap<String, String>();
 			typeMap2.put("id", "1");
 			typeMap2.put("value", "用户");
 			types.add(typeMap2);
 			map.put("types", types);
 			return toJson(map);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	//管理账号新增修改
 	@ResponseBody
 	@RequestMapping(value = "/manager/editaccout1", produces = "application/json")
 	public Map<String, Object> editaccout1(HttpServletRequest request, @RequestBody String data) {
 		try {
 			putToForm(data);
 			OfferUser offerUser = new OfferUser();
 			offerUser.setOfferUserName(form.get("accountName"));
 			offerUser.setOfferUserEmail(form.get("accountEmail"));
 			offerUser.setOfferUserPassword(encryption.encryption(form.get("accountPsw")));
 			offerUser.setIsoffer("3");
 			offerUser.setStatus("4");
 			offerUser.setGuwenSelect("0");
 			Map<String, String> map = new HashMap<String, String>();
 			conUtil.objectToMap(map, offerUser);
 			offerUserService.saveOfferUser(map);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	//推荐设置页面
 	@ResponseBody
 	@RequestMapping(value = "/manager/tuijianPage1", produces = "application/json")
 	public Map<String, Object> tuijianPage1(HttpServletRequest request, @RequestBody String data) {
 		try {
 			Map<String, Object> map = new HashMap<String, Object>();
 			List<Map<String, String>> days = new ArrayList<Map<String, String>>();
 			String[] aStrings={"1天","两天","三天","一个星期","15天","一个月","半年"};
 			String[] times={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
 			Map<String, String> dayMap = new HashMap<String, String>();
 			Map<String, String> timeMap = new HashMap<String, String>();
 			for(int i = 0; i < times.length; i++){
 				if(i < 7){
 					dayMap.put(aStrings[i], String.valueOf(i));
 				}
 				timeMap.put(times[i], String.valueOf(i));
 			}
 			for(int i = 0; i < aStrings.length; i++){
 				Map<String, String> daysMap = new HashMap<String, String>();
 				daysMap.put("id", String.valueOf(i));
 				daysMap.put("value", aStrings[i]);
 				days.add(daysMap);
 			}
 			map.put("daysList", days);
 			
 			List<Map<String, String>> clocks = new ArrayList<Map<String, String>>();
 			for(int i = 0; i < times.length; i++){
 				Map<String, String> clocksMap = new HashMap<String, String>();
 				clocksMap.put("id", String.valueOf(i));
 				clocksMap.put("value", times[i]+"点");
 				clocks.add(clocksMap);
 			}
 			map.put("clocksList", clocks);
 			List<TJ> tjs = baseService.getTJ(1);
 			map.put("days", dayMap.get(tjs.get(0).getTJT()));
 			map.put("clocks", timeMap.get(tjs.get(0).getTJS()));
 			return toJson(map);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	//推荐设置保存
 	@ResponseBody
 	@RequestMapping(value = "/manager/savetuijian1", produces = "application/json")
 	public Map<String, Object> savetuijian1(HttpServletRequest request, @RequestBody String data) {
 		try {
 			String[] aStrings={"1天","两天","三天","一个星期","15天","一个月","半年"};
 			String[] times={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
 			Map<String, String> dayMap = new HashMap<String, String>();
 			Map<String, String> timeMap = new HashMap<String, String>();
 			for(int i = 0; i < times.length; i++){
 				if(i < 7){
 					dayMap.put(aStrings[i], String.valueOf(i));
 				}
 				timeMap.put(times[i], String.valueOf(i));
 			}
 			putToForm(data);
 			TJ tj = baseService.getTJ(1).get(0);
 			tj.setTJT(aStrings[Integer.valueOf(form.get("days").toString())]);
 			tj.setTJS(times[Integer.valueOf(form.get("clocks").toString())]);
 			baseService.saveObject(tj);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	//顾问联系保存
 	@ResponseBody
 	@RequestMapping(value = "/manager/saveguwencommit1", produces = "application/json")
 	public Map<String, Object> saveguwencommit1(HttpServletRequest request, @RequestBody String data) {
 		try {
 			putToForm(data);
 			Guwen guwen =baseService.getGuwen(1).get(0);
 			guwen.setGWemil(form.get("emil"));
 			guwen.setGWphone(form.get("phone"));
 			baseService.saveGuwen(guwen);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	//顾问联系展示
 	@ResponseBody
 	@RequestMapping(value = "/manager/showguwencommit1", produces = "application/json")
 	public Map<String, Object> showguwencommit1(HttpServletRequest request, @RequestBody String data) {
 		try {
 			Guwen guwen =baseService.getGuwen(1).get(0);
 			Map<String, Object> map = new HashMap<String, Object>();
 			map.put("guwenemil", guwen.getGWemil());
 			map.put("guwenphone", guwen.getGWphone());
 			return toJson(map);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	
 	//简历展示设置置页面
 	@ResponseBody
 	@RequestMapping(value = "/manager/resumeshowPage1", produces = "application/json")
 	public Map<String, Object> resumeshowPage1(HttpServletRequest request, @RequestBody String data) {
 		try {
 			Map<String, Object> map = new HashMap<String, Object>();
 			List<Map<String, String>> days = new ArrayList<Map<String, String>>();
 			String[] aStrings={"1天","两天","三天","一个星期","15天","一个月","半年"};
 			String[] times={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24"};
 			for(int i = 0; i < aStrings.length; i++){
 				Map<String, String> daysMap = new HashMap<String, String>();
 				daysMap.put("id", String.valueOf(i));
 				daysMap.put("value", aStrings[i]);
 				days.add(daysMap);
 			}
 			map.put("youxiaoList", days);
 			
 			List<Map<String, String>> clocks = new ArrayList<Map<String, String>>();
 			for(int i = 0; i < times.length; i++){
 				Map<String, String> clocksMap = new HashMap<String, String>();
 				clocksMap.put("id", String.valueOf(i));
 				clocksMap.put("value", times[i]+"点");
 				clocks.add(clocksMap);
 			}
 			map.put("tuijianList", clocks);
 			return toJson(map);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	//简历展示设置保存
 	@ResponseBody
 	@RequestMapping(value = "/manager/saveresumeshow1", produces = "application/json")
 	public Map<String, Object> saveresumeshow1(HttpServletRequest request, @RequestBody String data) {
 		try {
 			putToForm(data);
 			jlzssz jlzssz =baseService.getJLTYXQ(1).get(0);
 			jlzssz.setJLTJYXQ("一星期");
 			jlzssz.setJLYXQ("24");
 			baseService.saveJLTYXQ(jlzssz);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	@ResponseBody
 	@RequestMapping(value = "/user/filefilefile")
 	public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile[] files, @RequestParam("filea") MultipartFile[] fileas) {
 		try {
 			if(files!=null&&files.length>0){  
 	            //循环获取file数组中得文件  
 	            for(int i = 0;i<files.length;i++){  
 	                MultipartFile file = files[i];  
 	                String filePath = Code.systemPath+"upload"+File.separator+file.getOriginalFilename();
 	                //保存文件  
 	                FileUtils.saveFile(file,filePath);  
 	            }  
 	        }  
 			if(fileas!=null&&fileas.length>0){  
 				//循环获取file数组中得文件  
 				for(int i = 0;i<fileas.length;i++){  
 					MultipartFile file = fileas[i];  
 					String filePath = Code.systemPath+"upload"+File.separator+file.getOriginalFilename();
 					//保存文件  
 					FileUtils.saveFile(file,filePath);  
 				}  
 			}  
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	
 	@ResponseBody
 	@RequestMapping(value = "/test/testString")
 	public Map<String, Object> testString(HttpServletRequest request, @RequestBody String data) {
 		try {
 			jlzssz jlzssz =new jlzssz();
 			jlzssz.setJLTJYXQ(data);
 			baseService.saveJLTYXQ(jlzssz);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	
 	@ResponseBody
 	@RequestMapping(value = "/test/dateString")
 	public Map<String, Object> dateString(HttpServletRequest request, @RequestBody String data) {
 		try {
 			String year = "";
 			String month = "";
 			String day = "";
 			if(data != null){
 				String[] times = data.split("/");
 				if(times.length != 3){
 					return toJson(null);
 				}
 				year = times[0];
 				month = times[1];
 				day = times[2];
 				if(!isIntegeter(day.substring(1, 2))){
 					day+= "0" + day.substring(0, 1);
 				}
 	         String date = year + "-" + month + "-" + day;
 	         String offerUserId = request.getSession().getAttribute("id") + "";
 	         String offerFirmId = request.getSession().getAttribute("firmId") + "";
 	         Map<String, String> findMap = new HashMap<String, String>();
 	         findMap.put("offerUserId", offerUserId);
 	         findMap.put("offerFirmId", offerFirmId);
 	         findMap.put("status", "3");
 	         findMap.put("interviewtime", date);
 	         List<Map<String, String>> list = new ArrayList<Map<String, String>>();
 	         List<Map<String, String>> listMap = baseService.getOfferInviteChat(findMap);
 	         for (Map<String, String> item : listMap) {
 	            Map<String, String> map = new HashMap<String, String>();
 	            map.put("id", returnString(item.get("candidateId")));
 	            map.put("time", returnString(item.get("interviewtime2")));
 	            map.put("name", returnString(item.get("offerCandidateName")));
 	            map.put("job", returnString(item.get("jobName")));
 	            map.put("phone", returnString(item.get("offerCandidatePhone")));
 	            list.add(map);
 	         }
 	         return toJson(list);
 			}
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return toJson(SUCCESS);
 	}
 	
 	@ResponseBody
 	@RequestMapping(value = "/test/calenderTest")
 	public List<Map<String, String>> calenderTest(HttpServletRequest request) {
 		try {
 			String offerUserId = request.getSession().getAttribute("id") + "";
         String offerFirmId = request.getSession().getAttribute("firmId") + "";
         Map<String, String> findMap = new HashMap<String, String>();
         findMap.put("offerUserId", offerUserId);
         findMap.put("offerFirmId", offerFirmId);
         findMap.put("status", "3");
         findMap.put("needGroupBy", "true");
         List<Map<String, String>> list = new ArrayList<Map<String, String>>();
         List<Map<String, String>> listMap = baseService.getOfferInviteChat(findMap);
         for (Map<String, String> item : listMap) {
 				Map<String, String> map = new HashMap<String, String>();
 				map.put("start", item.get("interviewtime"));
 				map.put("end", item.get("interviewtime"));
 				list.add(map);
 			}
 			return list;
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	//后台登陆
 		@ResponseBody
 		@RequestMapping(value = "/login/stafflog1", produces = "application/json")
 		public Map<String, Object> stafflog1(HttpServletRequest request, @RequestBody String data) {
 			try {
 				putToForm(data);
 				Map<String, Object> map = new HashMap<String, Object>();
 				List<Map<String, String>> list = offerUserService.isUserLogin(form);
 				if (list.size() > 0) {
 				   if ("3".equals(list.get(0).get("isoffer"))|| "4".equals(list.get(0).get("isoffer"))) {
 				     request.getSession().setAttribute("id", list.get(0).get("id"));
 	              request.getSession().setAttribute("name", list.get(0).get("offer_user_name"));
 	              request.getSession().setAttribute("password", list.get(0).get("offer_user_password"));
 	              request.getSession().setAttribute("isoffer", list.get(0).get("isoffer"));
 	              request.getSession().setAttribute("type", list.get(0).get("status"));
 	              map.put("type", list.get(0).get("isoffer"));
 	              map.put("status", list.get(0).get("status"));
 	              map.put("guwenType", returnString(list.get(0).get("guwen_select")));//get不到值，不知道为什么
 	              return toJson(map);
               }else {
                  return toJson("loginError1");
               }
            }
 				else {
 				  return toJson("loginError");
 				}
// 				OfferUser offerUser = offerUserService.islogin(form);
// 	         if (offerUser != null) {
// 	            request.getSession().setAttribute("id", offerUser.getId());
// 	            request.getSession().setAttribute("name", offerUser.getOfferUserName());
// 	            request.getSession().setAttribute("password", offerUser.getOfferUserPassword());
// 	            request.getSession().setAttribute("isoffer", offerUser.getIsoffer());
// 	            request.getSession().setAttribute("type", offerUser.getStatus());
// 	            map.put("type", offerUser.getIsoffer());
// 	            map.put("status", offerUser.getStatus());
// 	            map.put("guwenType", returnString(offerUser.getGuwenSelect()));//get不到值，不知道为什么
// 	            return toJson(map);
// 	         }else {
// 	            return toJson("loginError");
// 	         }
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 			
 			return toJson("loginError");//返回密码错误
 		}
 		
 		//企业信息
 		@ResponseBody
 		@RequestMapping(value = "/login/firmInformation2", produces = "application/json")
 		public Map<String, Object> firmInformation2(HttpServletRequest request, @RequestBody String data) {
 			try {
 				Map<String, Object> map = new HashMap<String, Object>();
 				String firmId = request.getSession().getAttribute("firmId").toString();
 				List<OfferFirm> offerFirms = offerFirmService.getOfferFirms(firmId);
 				
 				List<OfferFirmInformation> offerFirmInformations = offerFirmInformationService.getOfferFirmInformation(firmId);
 				if(offerFirmInformations == null || offerFirmInformations.size() == 0){
 					return toJson(null);
 				}
 				List<OfferPhoto> photos = offerPhotoService.findByFirmIId(firmId);
 				Map<String, Object> informationmap = new HashMap<String, Object>();
 				if (photos.size()>0) {
 					informationmap.put("photo","../upload/photo/"+photos.get(0).getPhotoSavename());
				}else {
					informationmap.put("photo",FileUtils.getphotoPath("null", returnString(offerFirms.get(0).getOfferName())));
				}
 				
 				informationmap.put("name", offerFirmInformations.get(0).getFirmSimpleName());
 				informationmap.put("descript", offerFirmInformations.get(0).getFirmDescript());
 				informationmap.put("allname", offerFirmInformations.get(0).getFirmAllName());
 				informationmap.put("link", offerFirmInformations.get(0).getFirmWebLink());
 				map.put("information1", informationmap);
 				List<OfferFirmProduce> offerFirmProduces = offerFirmProduceService.getOfferFirmProduces(firmId);
 				map.put("chanpin", offerFirmProduces.size() == 0 ? "" : returnString(offerFirmProduces.get(0).getProduceDescript()));
 				
 				Map<String, Object> xinximap = new HashMap<String, Object>();
 				xinximap.put("firmType", offerFirmInformations.get(0).getAreaId());
 				xinximap.put("firmRongzi", offerFirmInformations.get(0).getFirmStage());
 				xinximap.put("firmSize", offerFirmInformations.get(0).getFirmSize());
 				xinximap.put("firmArddess",offerFirmInformations.get(0).getFirmAddress());
 				xinximap.put("firmPeople", offerFirmInformations.get(0).getFirmTeamSize());
 				map.put("xinxi", xinximap);
 				
 				map.put("jieshao", returnString(offerFirmInformations.get(0).getFirmDescript()));

 				List<OfferPhoto> photoss = offerPhotoService.findByFirmdId(firmId);
 				List<Map<String, Object>> carouselList = new ArrayList<Map<String, Object>>();
 				for(int i = 0; i < photoss.size(); i++){
 					Map<String, Object> carouselmap = new HashMap<String, Object>();
 					carouselmap.put("photo", "../upload/photo/"+photoss.get(i).getPhotoSavename());
 					carouselList.add(carouselmap);
 				}
 				map.put("carousel", carouselList);
 				
 				List<OfferFirmReport> offerFirmReports = offerFirmReportService.getOfferFirmReports(firmId);
 				map.put("news", offerFirmReports.size()>0?offerFirmReports.get(0).getReportLink():"");
 				
 				List<OfferFirmTechnology> offerFirmTechnologies = OfferFirmTechnologyService.getOfferFirmTechnologies(firmId);
 				List<Map<String, Object>> jishuList = new ArrayList<Map<String, Object>>();
 				String[] a = offerFirmTechnologies.get(0).getFirmSeo().split(";");
 				for(int i = 0; i < a.length; i++){
 					Map<String, Object> jishumap = new HashMap<String, Object>();
 					jishumap.put("name", a[i]);
 					jishuList.add(jishumap);
 				}
 				map.put("jishu", jishuList);
 				
 				List<Map<String, Object>> fuliList = new ArrayList<Map<String, Object>>();
 				List<OfferFirmWelfare> offerFirmWelfares = baseService.getwelfare(firmId);
 				String[] aStrings = offerFirmWelfares.get(0).getWelfareId().split(",");
 				for(int i = 0; i < aStrings.length; i++){
 					Map<String, Object> fulimap = new HashMap<String, Object>();
 					fulimap.put("id", aStrings[i]);
 					fulimap.put("name", Code.welfares[Integer.parseInt(aStrings[i]) - 1]);
 					fuliList.add(fulimap);
 				}
 				map.put("fuli", fuliList);
 				
 				Map<String, Object> dizhimap = new HashMap<String, Object>();
 				dizhimap.put("photo", offerFirmInformations.get(0).getFirmAddress());
 				dizhimap.put("name", offerFirmInformations.get(0).getFirmAddress());
 				map.put("dizhi", dizhimap);
 	            return toJson(map);
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 			
 			return toJson(SUCCESS);//返回密码错误
 		}
 		
 		@ResponseBody
 		@RequestMapping(value = "/login/sessionPutFirm", produces = "application/json")
 		public Map<String, Object> sessionPutFirm(HttpServletRequest request, @RequestBody String data) {
 			try {
 				if(data != null || !"".equals(data)){
 					request.getSession().setAttribute("firmId", data);
 				}
			} catch (Exception e) {
				e.printStackTrace();
			}
 			return toJson(SUCCESS);//返回密码错误
 		}
 		
 		@ResponseBody
 		@RequestMapping(value = "/login/sessionPutUser", produces = "application/json")
 		public Map<String, Object> sessionPutUser(HttpServletRequest request, @RequestBody String data) {
 			try {
 				if(data != null || !"".equals(data)){
 					request.getSession().setAttribute("userId", data);
 				}
			} catch (Exception e) {
				e.printStackTrace();
			}
 			return toJson(SUCCESS);//返回密码错误
 		}
 		
 		//企业信息
 		@ResponseBody
 		@RequestMapping(value = "/login/firmInformation1", produces = "application/json")
 		public Map<String, Object> firmInformation1(HttpServletRequest request, @RequestBody String data) {
 			try {
 				Map<String, Object> map = new HashMap<String, Object>();
 				List<Map<String, Object>> cityList = new ArrayList<Map<String, Object>>();
 				List<Map<String, String>> city = baseService.getDiShiCity("getAll");//所有的地市,getAll
 				for (Map<String, String> map2 : city) {
 	            Map<String, Object> m = new HashMap<String, Object>();
 	            m.put("id", String.valueOf(map2.get("id")));
 	            m.put("value", map2.get("cityName"));
 	            cityList.add(m);
 	         }
 				map.put("city", cityList);
 				
 				List<Map<String, Object>> jobList = new ArrayList<Map<String, Object>>();
 				List<OfferJob> offerJobsOne = offerJobService.getAllJob("1");//parentId=1的,例如"Java工程师"
            for (int i = 0; i < offerJobsOne.size(); i++) {
               Map<String, Object> m = new HashMap<String, Object>();
               m.put("id", String.valueOf(offerJobsOne.get(i).getId()));
               m.put("value", offerJobsOne.get(i).getJobName());
               jobList.add(m);
            }
 				map.put("job", jobList);
 				
 				List<Map<String, Object>> statusList = new ArrayList<Map<String, Object>>();
 				String[] strings = new String[]{ "停用", "启用", "待审批", "审批不通过", "审批通过" };//状态（0：停用，1：未提交，2：待审批，3：审批不通过，4：审批通过，5：已下线）
 				for (int i = 0; i < strings.length; i++) {
 				   Map<String, Object> cityMap = new HashMap<String, Object>();
 				   cityMap.put("id", String.valueOf(i));
 				   cityMap.put("value", String.valueOf(strings[i]));
 				   statusList.add(cityMap);
            }
 				map.put("status", statusList);
 				
 				List<OfferJob> offerJobs = offerJobService.getAllJob("");
 				List<Map<String, Object>> firmList = new ArrayList<Map<String, Object>>();
            String limit = request.getParameter("pageId") == null ? "" : request.getParameter("pageId");
            String firmstatus = request.getParameter("firmstatus") == null ? "" : request.getParameter("firmstatus");
            //            String firmstatusValue = request.getParameter("firmstatusValue") == null ? "" : request.getParameter("firmstatusValue");
            //            String firmcity = request.getParameter("firmcity") == null ? "" : request.getParameter("firmcity");
            String firmcityValue = request.getParameter("firmcityValue") == null ? "" : request.getParameter("firmcityValue");
            Map<String, String> nowMap = new HashMap<String, String>();
            nowMap.put("limit", limit);
            nowMap.put("isoffer", "2");
            nowMap.put("firmCity", firmcityValue);
            nowMap.put("status", firmstatus);
            nowMap.put("adminId", "true");
            List<Map<String, String>> allFirm = offerFirmService.getAllFirmInformation(nowMap);
            int size = allFirm.size();
            int pageId = Integer.valueOf(limit);
            boolean flag = (pageId * 20) < size;
            String status;
            for(int i = (pageId - 1) * 20; flag ? i < (pageId * 20) : i < size; i++){
               Map<String, Object> cityMap = new HashMap<String, Object>();
               cityMap.put("address",  String.valueOf(allFirm.get(i).get("firmAddress") == null ? "" : allFirm.get(i).get("firmAddress")));
               cityMap.put("lingyu",  String.valueOf(allFirm.get(i).get("areaId") == null ? "" : allFirm.get(i).get("areaId")));
               cityMap.put("name",  String.valueOf(allFirm.get(i).get("firmSimpleName") == null ? "" : allFirm.get(i).get("firmSimpleName")));
               cityMap.put("guimo",  String.valueOf(allFirm.get(i).get("firmSize") == null ? "" : allFirm.get(i).get("firmSize")));
               cityMap.put("rongzi",  String.valueOf(allFirm.get(i).get("firmStage") == null ? "" : allFirm.get(i).get("firmStage")));
               cityMap.put("shenqingren",  String.valueOf(allFirm.get(i).get("offerUserName") == null ? "" : allFirm.get(i).get("offerUserName")));
               cityMap.put("zhiwei",  "");
               for (OfferJob offerJob : offerJobs) {
                  if ((String.valueOf(allFirm.get(i).get("offerJobId"))).equals(String.valueOf(offerJob.getId()))) {
                     cityMap.put("zhiwei",  String.valueOf(offerJob.getJobName()));
                     break;
                  }
               }
               cityMap.put("phone",  String.valueOf(allFirm.get(i).get("offerUserPhone") == null ? "" : allFirm.get(i).get("offerUserPhone")));
               cityMap.put("shenqingtime",  String.valueOf(allFirm.get(i).get("firmCreateYear") == null ? "" : allFirm.get(i).get("firmCreateYear")));
               cityMap.put("teammember", "管理员");//"".equals(returnString(allFirm.get(i).get("num"))) ? "" : String.valueOf(allFirm.get(i).get("num")) + "人");
               status = allFirm.get(i).get("fStatus") == null ? "" : allFirm.get(i).get("fStatus");
               if (!"".equals(status)) {
                  status = status.equals("0") ? "未确认" : status.equals("1") ? "未提交" : status.equals("2") ? "待审批" : status.equals("3") ? "审批不通过" : "审批通过";
               }
               cityMap.put("status", status);
               String fistDate = returnString(allFirm.get(i).get("fCreateTime"));
               if (!"".equals(fistDate)) {
                  String secondDate = (Integer.valueOf(fistDate.substring(0, 4)) + 1) + fistDate.substring(4);
                  cityMap.put("fuwu", formatter.format(allFirm.get(i).get("fCreateTime")) + "~" + secondDate.substring(0,10).replace("-", "/"));
               }
               else {
                  cityMap.put("fuwu", "");
               }
               cityMap.put("id", String.valueOf(allFirm.get(i).get("offerFirmId")));
               firmList.add(cityMap);
            }
            map.put("firmList", firmList);

            map.put("allNum", allFirm.size());
            map.put("pageNum", allFirm.size() == 0 ? 1 : Math.ceil(allFirm.size() / 20.0));
            
            return toJson(map);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);//返回密码错误
      }
      
      //企业信息
      @ResponseBody
      @RequestMapping(value = "/login/houTaiFirmInformation1", produces = "application/json")
      public Map<String, Object> houTaiFirmInformation1(HttpServletRequest request, @RequestBody String data) {
         try {
            putToForm(data);
            String userId = request.getSession().getAttribute("userId") + "";
            Map<String, Object> map = new HashMap<String, Object>();
            List<Map<String, Object>> cityList = new ArrayList<Map<String, Object>>();
            List<Map<String, String>> city = baseService.getDiShiCity("getAll");//所有的地市,getAll
            for (Map<String, String> map2 : city) {
               Map<String, Object> m = new HashMap<String, Object>();
               m.put("id", String.valueOf(map2.get("id")));
               m.put("value", map2.get("cityName"));
               cityList.add(m);
            }
            map.put("city", cityList);
            
            List<Map<String, Object>> jobList = new ArrayList<Map<String, Object>>();
            List<OfferJob> offerJobsOne = offerJobService.getAllJob("1");//parentId=1的,例如"Java工程师"
            for (int i = 0; i < offerJobsOne.size(); i++) {
               Map<String, Object> m = new HashMap<String, Object>();
               m.put("id", String.valueOf(offerJobsOne.get(i).getId()));
               m.put("value", offerJobsOne.get(i).getJobName());
               jobList.add(m);
            }
            map.put("job", jobList);
            
            List<Map<String, Object>> statusList = new ArrayList<Map<String, Object>>();
            String[] strings = new String[]{ "停用", "启用", "待审批", "审批不通过", "审批通过" };//状态（0：停用，1：未提交，2：待审批，3：审批不通过，4：审批通过，5：已下线）
            for (int i = 0; i < strings.length; i++) {
               Map<String, Object> cityMap = new HashMap<String, Object>();
               cityMap.put("id", String.valueOf(i));
               cityMap.put("value", String.valueOf(strings[i]));
               statusList.add(cityMap);
            }
            map.put("status", statusList);
            
            List<OfferJob> offerJobs = offerJobService.getAllJob("");
            List<Map<String, Object>> firmList = new ArrayList<Map<String, Object>>();
            String limit = returnString(form.get("pageId"));//request.getParameter("pageId") == null ? "" : request.getParameter("pageId");
            String firmjob = returnString(form.get("firmjob"));//request.getParameter("firmjob") == null ? "" : request.getParameter("firmjob");
            //            String firmstatusValue = request.getParameter("firmstatusValue") == null ? "" : request.getParameter("firmstatusValue");
            //            String firmcity = request.getParameter("firmcity") == null ? "" : request.getParameter("firmcity");
            String firmcityValue = returnString(form.get("firmcityValue"));//request.getParameter("firmcityValue") == null ? "" : request.getParameter("firmcityValue");
            String firmName = returnString(form.get("firmName"));
            Map<String, String> nowMap = new HashMap<String, String>();
            nowMap.put("limit", limit);
            nowMap.put("isoffer", "2");
            nowMap.put("status", "4");
            nowMap.put("firmCity", firmcityValue);
            nowMap.put("firmjob", firmjob);
            nowMap.put("adminId", "true");
            nowMap.put("firmName", firmName);
            nowMap.put("offerUserId", userId);
            List<Map<String, String>> allFirm = offerUserService.getHouXuanRenHouTaiTuijianQiYe(nowMap);
            offerFirmService.getAllFirmInformation(nowMap);
            int size = allFirm.size();
            int pageId = Integer.valueOf(limit);
            boolean flag = (pageId * 20) < size;
            String status, jobName, allJobName = "";
            for(int i = (pageId - 1) * 20; flag ? i < (pageId * 20) : i < size; i++){
               Map<String, Object> cityMap = new HashMap<String, Object>();
               cityMap.put("address",  String.valueOf(allFirm.get(i).get("firmAddress") == null ? "" : allFirm.get(i).get("firmAddress")));
               cityMap.put("lingyu",  String.valueOf(allFirm.get(i).get("areaId") == null ? "" : allFirm.get(i).get("areaId")));
               cityMap.put("name",  String.valueOf(allFirm.get(i).get("firmSimpleName") == null ? "" : allFirm.get(i).get("firmSimpleName")));
               cityMap.put("guimo",  String.valueOf(allFirm.get(i).get("firmSize") == null ? "" : allFirm.get(i).get("firmSize")));
               cityMap.put("rongzi",  String.valueOf(allFirm.get(i).get("firmStage") == null ? "" : allFirm.get(i).get("firmStage")));
               cityMap.put("shenqingren",  String.valueOf(allFirm.get(i).get("offerUserName") == null ? "" : allFirm.get(i).get("offerUserName")));
               cityMap.put("zhiwei",  "");
//               for (OfferJob offerJob : offerJobs) {
//                  if ((String.valueOf(allFirm.get(i).get("offerJobId"))).equals(String.valueOf(offerJob.getId()))) {
//                     cityMap.put("zhiwei",  String.valueOf(offerJob.getJobName()));
//                     break;
//                  }
//               }
               jobName = returnString(allFirm.get(i).get("jobIds"));
               if (!"".equals(jobName)) {
                  for (String string : jobName.split(",")) {
                     allJobName += offerJobService.getOfferJob(Integer.parseInt(string)).get(0).getJobName() + ",";
                  }
                  allJobName = allJobName.substring(0, allJobName.lastIndexOf(","));
                  cityMap.put("zhiwei",  allJobName);
               }
               cityMap.put("phone",  String.valueOf(allFirm.get(i).get("offerUserPhone") == null ? "" : allFirm.get(i).get("offerUserPhone")));
               cityMap.put("shenqingtime",  String.valueOf(allFirm.get(i).get("firmCreateYear") == null ? "" : allFirm.get(i).get("firmCreateYear")));
               cityMap.put("teammember", "管理员");//"".equals(returnString(allFirm.get(i).get("num"))) ? "" : String.valueOf(allFirm.get(i).get("num")) + "人");
//               status = allFirm.get(i).get("fStatus") == null ? "" : allFirm.get(i).get("fStatus");
//               if (!"".equals(status)) {
//                  status = status.equals("0") ? "未确认" : status.equals("1") ? "未提交" : status.equals("2") ? "待审批" : status.equals("3") ? "审批不通过" : "审批通过";
//               }
               String cStatus = "".equals(returnString(allFirm.get(i).get("cStatus"))) ? "" : returnString(allFirm.get(i).get("cStatus"));
               String iStatus = "".equals(returnString(allFirm.get(i).get("iStatus"))) ? "" : returnString(allFirm.get(i).get("iStatus"));
               if (!"".equals(iStatus)) {
                  status = Code.houTaiCandidateMianShiStatus[Integer.valueOf(iStatus)];
               }
               else if (!"".equals(cStatus)) {
                  status = Code.collectStatus[Integer.valueOf(cStatus)];
               }
               else {
                  status = "";
               }
               cityMap.put("status", status);
               String fistDate = returnString(allFirm.get(i).get("fCreateTime"));
               if (!"".equals(fistDate)) {
                  String secondDate = (Integer.valueOf(fistDate.substring(0, 4)) + 1) + fistDate.substring(4);
                  cityMap.put("fuwu", formatter.format(allFirm.get(i).get("fCreateTime")) + "~" + secondDate.substring(0,10).replace("-", "/"));
               }
               else {
                  cityMap.put("fuwu", "");
               }
               cityMap.put("id", String.valueOf(allFirm.get(i).get("offerFirmId")));
               firmList.add(cityMap);
            }
            map.put("firmList", firmList);

            map.put("allNum", allFirm.size());
            map.put("pageNum", allFirm.size() == 0 ? 1 : Math.ceil(allFirm.size() / 20.0));
            
            return toJson(map);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);//返回密码错误
      }
      
      //用户信息(应该是账号信息吧)
      @ResponseBody
      @RequestMapping(value = "/login/useraccount1", produces = "application/json")
      public Map<String, Object> useraccount1(HttpServletRequest request, @RequestBody String data) {
         try {
            Map<String, Object> map = new HashMap<String, Object>();
            String offerCandidateId = request.getSession().getAttribute("userId").toString();
            map.put("offerCandidateId", offerCandidateId);
            Map<String, Object> information = new HashMap<String, Object>();
            Map<String, String> findMap = new HashMap<String, String>();
            findMap.put("offerUserId", offerCandidateId);
            List<Map<String, String>> list = offerUserInformationService.getOfferUserInformationByOfferUserId(findMap);
            
            information.put("userphoto", FileUtils.getphotoPath(offerCandidateId, list.get(0).get("offerUserName")));//
            information.put("userName", returnString(list.get(0).get("offerUserName")));
            information.put("usershenfen", "");
            information.put("zhucetime", formatter.format(list.get(0).get("createTime")));
            information.put("newtime", "");
            information.put("firmName", "");
            information.put("job", "");
            String status = list.get(0).get("status") == null ? "" : list.get(0).get("status");
            map.put("firmguwen", "");
            map.put("firmguwenValue", "");
            if (!"".equals(status)) {
               if (status.equals("3")) {
                  map.put("firmguwen", status);
                  map.put("firmguwenValue", "不通过");
               }
               else if(status.equals("4")) {
                  map.put("firmguwen", status);
                  map.put("firmguwenValue", "通过");
               }
               status = Code.status[Integer.valueOf(status)];
            }
            findMap.put("offerCandidateId", offerCandidateId);
            List<OfferInvite> offerInvites = baseService.getOfferInvite1(findMap);
            information.put("phone", returnString(list.get(0).get("offerUserPhone")));
            information.put("tongzhi", offerInvites.size() + "条");
            information.put("status", status);
            information.put("gewenbeizhu", list.get(0).get("offerAdviserRemark"));
            information.put("beizhu", list.get(0).get("offerAdviserRemark") == null ? "" : list.get(0).get("offerAdviserRemark"));
            map.put("information", information);
            
            List<Map<String, Object>> gewenList = new ArrayList<Map<String, Object>>();
            String[] strings = new String[]{ "不通过", "通过" };
            int i = 3;
            for (String string : strings) {
              Map<String, Object> gewen = new HashMap<String, Object>();
              gewen.put("id", String.valueOf(i++));
              gewen.put("value", string);
              gewenList.add(gewen);
            }
//             for(int i = 0; i < 2; i++){
//                Map<String, Object> gewen = new HashMap<String, Object>();
//                gewen.put("id", "1");
//                gewen.put("value", "通过");
//                gewenList.add(gewen);
//             }
            map.put("guwen", gewenList);
            return toJson(map);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);//返回密码错误
      }
      
      //企业信息(应该是账号信息吧)
      @ResponseBody
      @RequestMapping(value = "/login/firmaccount1", produces = "application/json")
      public Map<String, Object> firmaccount1(HttpServletRequest request, @RequestBody String data) {
         try {
            Map<String, Object> map = new HashMap<String, Object>();
            String offerFirmId = request.getSession().getAttribute("firmId").toString();
            List<Map<String, Object>> informations = new ArrayList<Map<String,Object>>();
            Map<String, String> findMap = new HashMap<String, String>();
            findMap.put("offerFirmId", offerFirmId);
            Map<String, String> map1 = new HashMap<String, String>();
            map1.put("firmId", String.valueOf(offerFirmId));
            List<OfferUser> offerUsers =  offerUserService.getOfferFirmTeam(map1);
            List<OfferFirm> offerFirms = offerFirmService.getOfferFirms(offerFirmId);
            if (offerFirms.size() > 0) {
               map.put("offerFirmId", offerFirmId);
               OfferFirm offerFirm = offerFirms.get(0);//new OfferFirm();
//            List<OfferFirmInformation> list = offerFirmInformationService.getOfferFirmInformation(offerFirmId);
               findMap.put("offerFirmId", offerFirmId);
               List<OfferInvite> offerInvites = baseService.getOfferInvite1(findMap);
               String status = offerFirm.getStatus() == null ? "" : offerFirm.getStatus();
               for (int i = 0; i < offerUsers.size(); i++) {
                  Map<String, Object> information = new HashMap<String, Object>();
                  information.put("photo", "../img/changjinglu.jpg");//暂时没有个人图像
                  information.put("userName", offerUsers.get(i).getOfferUserName());
                  information.put("userType", offerFirm.getAdminId() != null ? "（管理员）" : "（普通成员）");
                  information.put("firmName", offerFirm.getOfferName());
                  information.put("job", offerUsers.get(i).getOfferJobId()==null?"":offerJobService.getOfferJob(offerUsers.get(i).getOfferJobId()).get(0).getJobName());
                  information.put("createTime", zwsdf.format(offerFirm.getCreateTime()));
                  information.put("updataTime", "".equals(returnString(offerUsers.get(i).getLastLoginTime())) ? "" : zwsdf.format(offerUsers.get(i).getLastLoginTime()));
                  information.put("remark", returnString(offerFirm.getOfferAdviserRemark()));
                  information.put("msg", ("".equals(returnString(offerUsers.get(i).getIsAccountPhone())) ? "" : "手机通知&nbsp;&nbsp;") + ("".equals(returnString(offerUsers.get(i).getEmailmsg())) ? "" : "邮箱通知"));
                  information.put("phone", offerUsers.get(i).getOfferUserPhone());
                  information.put("tongzhi", offerInvites.size() + "条");
                  information.put("status", "".equals(status) ? "" : Code.status[Integer.valueOf(status)]);
                  informations.add(information);
               }
               map.put("information", informations);
               map.put("firmguwen", status.equals("3") || status.equals("4") ? status : "");
               map.put("firmguwenValue", status.equals("3") ? "不通过" : status.equals("4") ? "通过" : "");
               map.put("beizhu", returnString(offerFirm.getOfferAdviserRemark()));
               
               List<Map<String, Object>> gewenList = new ArrayList<Map<String, Object>>();
               String[] strings = new String[]{ "不通过", "通过" };
               int i = 3;
               for (String string : strings) {
                  Map<String, Object> gewen = new HashMap<String, Object>();
                  gewen.put("id", String.valueOf(i++));
                  gewen.put("value", string);
                  gewenList.add(gewen);
               }
               map.put("guwen", gewenList);
            }
            return toJson(map);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);//返回密码错误
      }
      
      @ResponseBody
      @RequestMapping(value = "/login/firmquestionnaire1", produces = "application/json")
      public Map<String, Object> firmquestionnaire1(HttpServletRequest request, @RequestBody String data) {
         try {
            putToForm(data);
            Map<String, Object> map = new HashMap<String, Object>();
            String offerFirmId = request.getSession().getAttribute("firmId") + "";
            List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//            List<OfferFirmSelect> offerFirmSelects = offerFirmSelectService.getOfferSelectByFirmId(offerFirmId);
            String limit = form.get("pageId");//request.getParameter("pageId") == null ? "" : request.getParameter("pageId");
            if ("".equals(limit)) {
               limit = "1";
            }
            List<Map<String, String>> getList = offerFirmSelectService.getOfferSelectByFirmId(offerFirmId, limit);
            String jobName, allJobName, workPlace, allWorkPlace;
            int size = getList.size();
            int pageId = Integer.valueOf(limit);
            boolean flag = (pageId * 20) < size;
            for(int i = (pageId - 1) * 20; flag ? i < (pageId * 20) : i < size; i++){
               jobName = allJobName = workPlace = allWorkPlace = "";
               Map<String, String> firmMap = new HashMap<String, String>();
               firmMap.put("name", returnString(getList.get(i).get("offerUserName")));
               firmMap.put("newTime", returnString(getList.get(i).get("lastLoginTime")));
               jobName = "".equals(returnString(getList.get(i).get("offerJobId"))) ? "" : offerJobService.getOfferJob(Integer.parseInt(returnString(getList.get(i).get("offerJobId")))).get(0).getJobName();
               firmMap.put("job", jobName);
               firmMap.put("phone", returnString(getList.get(i).get("offerUserPhone")));
               jobName = returnString(getList.get(i).get("jobIds"));
               if (!"".equals(jobName)) {
                  for (String string : jobName.split(",")) {
                     allJobName += offerJobService.getOfferJob(Integer.parseInt(string)).get(0).getJobName() + ",";
                  }
                  allJobName = allJobName.substring(0, allJobName.lastIndexOf(","));
               }
               workPlace = returnString(getList.get(i).get("cityIds"));
               if (!"".equals(workPlace)) {
                  for (String string : workPlace.split(",")) {
                     allWorkPlace += baseService.getDiShiCityName(string).get(0).get("cityName") + ",";
                  }
                  allWorkPlace = allWorkPlace.substring(0, allWorkPlace.lastIndexOf(","));
               }
               firmMap.put("zhaopin", allJobName);
               firmMap.put("workplace", allWorkPlace);
               firmMap.put("jingyan", returnString(getList.get(i).get("yearIds")));
               firmMap.put("id", returnString(getList.get(i).get("id")));
               list.add(firmMap);
            }
            map.put("questionnaire", list);
            
            map.put("allNum", size);
            map.put("pageNum", size == 0 ? 1 : Math.ceil(size / 20.0));
            return toJson(map);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);//返回密码错误
      }

      @ResponseBody
      @RequestMapping(value = "/login/firmtuijian1", produces = "application/json")
      public Map<String, Object> firmtuijian1(HttpServletRequest request, @RequestBody String data) {
         try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("allNum", "123");
            map.put("pageNum", "10");
//            List<Map<String, Object>> cityList = new ArrayList<Map<String, Object>>();
//            List<Map<String, String>> city = baseService.getDiShiCity("getAll");
//            for (Map<String, String> map2 : city) {
//               Map<String, Object> m = new HashMap<String, Object>();
//               m.put("id", String.valueOf(map2.get("id")));
//               m.put("value", map2.get("cityName"));
//               cityList.add(m);
//            }
//            map.put("city", cityList);
            
            List<Map<String, Object>> jobList = new ArrayList<Map<String, Object>>();
            List<OfferJob> offerJobsOne = offerJobService.getAllJob("1");//parentId=1的,例如"Java工程师"
            for (int i = 0; i < offerJobsOne.size(); i++) {
               Map<String, Object> m = new HashMap<String, Object>();
               m.put("id", String.valueOf(offerJobsOne.get(i).getId()));
               m.put("value", offerJobsOne.get(i).getJobName());
               jobList.add(m);
            }
            map.put("job", jobList);
            
            List<Map<String, Object>> statusList = new ArrayList<Map<String, Object>>();
            for(int i = 0; i < 10; i++){
               Map<String, Object> cityMap = new HashMap<String, Object>();
               cityMap.put("id", String.valueOf(i));
               cityMap.put("value", "状态"+String.valueOf(i));
               statusList.add(cityMap);
            }
            map.put("status", statusList);
            
            List<Map<String, Object>> firmList = new ArrayList<Map<String, Object>>();
            for(int i = 0; i < 10; i++){
               Map<String, Object> cityMap = new HashMap<String, Object>();
               cityMap.put("address",  String.valueOf(i));
               cityMap.put("job",  String.valueOf(i));
               cityMap.put("name",  String.valueOf(i));
               cityMap.put("xueli",  String.valueOf(i));
               cityMap.put("jingyan",  String.valueOf(i));
               cityMap.put("nowmoney",  String.valueOf(i));
               cityMap.put("planmoney",  String.valueOf(i));
               cityMap.put("plandidian",  String.valueOf(i));
               cityMap.put("tuijianTime",  String.valueOf(i));
               cityMap.put("status",  String.valueOf(i));
               cityMap.put("id", String.valueOf(i));
               firmList.add(cityMap);
            }
            map.put("firmList", firmList);
            return toJson(map);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);//返回密码错误
      }
      

      @ResponseBody
      @RequestMapping(value = "/login/firmzhaopin1", produces = "application/json")
      public Map<String, Object> firmzhaopin1(HttpServletRequest request, @RequestBody String data) {
         try {
           String firmId = request.getSession().getAttribute("firmId").toString();
            Map<String, Object> map = new HashMap<String, Object>();
            Map<String, String> nowMap = new HashMap<String, String>();
            nowMap.put("offerFirmId", firmId);
            
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
            
            map.put("wait", list1.size());
            map.put("waitanpai", list2.size());
            map.put("fankui", list3.size());
            map.put("tongguo", list4.size());
            map.put("guidang", list5.size());
            return toJson(map);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);//返回密码错误
      }
      //筛选候选人页面2
      @ResponseBody
      @RequestMapping(value = "/firm/firmzhaopin2", produces = "application/json")
      public Map<String, Object> firmzhaopin2(HttpServletRequest request, @RequestBody String data) {
         try {
            putToForm(data);
            String status = form.get("usertype");
            String offerFirmId = request.getSession().getAttribute("firmId") + "";
//             String offerUserId = request.getSession().getAttribute("firmId") + "";
//             OfferUser offerUsers = offerUserService.getOfferUser(offerUserId);
//             request.getSession().setAttribute("offerFirmId", offerUsers.getFirmId());
            Map<String, String> nowMap = new HashMap<String, String>();
//             nowMap.put("offerUserId", offerUserId);
            nowMap.put("offerFirmId", offerFirmId);
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
      @RequestMapping(value = "/firm/firmzhaopin3", produces = "application/json")
      public Map<String, Object> firmzhaopin3(HttpServletRequest request, @RequestBody String data) {
         try {
            putToForm(data);
            String inviteId = form.get("inviteId");
//             String offerUserId = request.getSession().getAttribute("id") + "";
//             OfferUser offerUsers = offerUserService.getOfferUser(offerUserId);
//             request.getSession().setAttribute("offerFirmId", offerUsers.getFirmId());
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
      
      @ResponseBody
      @RequestMapping(value = "/login/userinformation1", produces = "application/json")
      public Map<String, Object> userinformation1(HttpServletRequest request, @RequestBody String data) {
         try {
            Map<String, Object> map = new HashMap<String, Object>();
//             map.put("allNum", "123");
//             map.put("pageNum", "10");
            List<Map<String, Object>> cityList = new ArrayList<Map<String, Object>>();
            List<Map<String, String>> city = baseService.getDiShiCity("getAll");//所有的地市,getAll
            for (Map<String, String> map2 : city) {
               Map<String, Object> m = new HashMap<String, Object>();
               m.put("id", String.valueOf(map2.get("id")));
               m.put("value", map2.get("cityName"));
               cityList.add(m);
            }
//             for(int i = 0; i < 10; i++){
//                Map<String, Object> cityMap = new HashMap<String, Object>();
//                cityMap.put("id", String.valueOf(i));
//                cityMap.put("value", "城市"+String.valueOf(i));
//                cityList.add(cityMap);
//             }
            map.put("city", cityList);
            
            List<Map<String, Object>> jobList = new ArrayList<Map<String, Object>>();
            List<OfferJob> offerJobsOne = offerJobService.getAllJob("1");//parentId=1的,例如"Java工程师"
            for (int i = 0; i < offerJobsOne.size(); i++) {
               Map<String, Object> m = new HashMap<String, Object>();
               m.put("id", String.valueOf(offerJobsOne.get(i).getId()));
               m.put("value", offerJobsOne.get(i).getJobName());
               jobList.add(m);
            }
//             for(int i = 0; i < 10; i++){
//                Map<String, Object> cityMap = new HashMap<String, Object>();
//                cityMap.put("id", String.valueOf(i));
//                cityMap.put("value", "职位"+String.valueOf(i));
//                jobList.add(cityMap);
//             }
            map.put("job", jobList);
            
            List<Map<String, Object>> statusList = new ArrayList<Map<String, Object>>();
            String[] strings = new String[]{ "停用", "未提交", "待审批", "审批不通过", "审批通过", "已下线" };//状态（0：停用，1：未提交，2：待审批，3：审批不通过，4：审批通过，5：已下线）
            for (int i = 0; i < strings.length; i++) {
              Map<String, Object> cityMap = new HashMap<String, Object>();
              cityMap.put("id", String.valueOf(i));
              cityMap.put("value", String.valueOf(strings[i]));
              statusList.add(cityMap);
            }
//             for(int i = 0; i < 10; i++){
//                Map<String, Object> cityMap = new HashMap<String, Object>();
//                cityMap.put("id", String.valueOf(i));
//                cityMap.put("value", "状态"+String.valueOf(i));
//                statusList.add(cityMap);
//             }
            map.put("status", statusList);
            
            List<Map<String, Object>> firmList = new ArrayList<Map<String, Object>>();
            String limit = request.getParameter("pageId") == null ? "" : request.getParameter("pageId");
            String firmcityValue = request.getParameter("firmcityValue") == null ? "" : request.getParameter("firmcityValue");
            String firmstatus = request.getParameter("firmstatus") == null ? "" : request.getParameter("firmstatus");
            String firmjob = request.getParameter("firmjob") == null ? "" : request.getParameter("firmjob");
            Map<String, String> findMap = new HashMap<String, String>();
            findMap.put("isoffer", "1");
            findMap.put("offerUserAddress", firmcityValue);
            findMap.put("status", firmstatus);
            findMap.put("offerJobId", firmjob);
            List<Map<String, String>> allUser = offerUserInformationService.getOfferUserInformationByOfferUserId(findMap);
            int size = allUser.size();
            int pageId = Integer.valueOf(limit);
            boolean flag = (pageId * 20) < size;
            String status;
            for(int i = (pageId - 1) * 20; flag ? i < (pageId * 20) : i < size; i++){
               Map<String, Object> cityMap = new HashMap<String, Object>();
               cityMap.put("address",  String.valueOf(allUser.get(i).get("offerUserAddress") == null ? "" : allUser.get(i).get("offerUserAddress")));
               cityMap.put("job",  allUser.get(i).get("offerJobId") == null ? "" : offerJobService.getOfferJob(Integer.valueOf(String.valueOf(allUser.get(i).get("offerJobId")))).get(0).getJobName());
               cityMap.put("name",  String.valueOf(allUser.get(i).get("offerUserName") == null ? "" : allUser.get(i).get("offerUserName")));
               cityMap.put("xueli",  "");
               cityMap.put("works",  String.valueOf(allUser.get(i).get("offerUserWorktime") == null ? "" : allUser.get(i).get("offerUserWorktime")));
               cityMap.put("nowmoney",  allUser.get(i).get("offerUserNowYearWages") == null ? "" : String.valueOf(allUser.get(i).get("offerUserNowYearWages"))+ "万元");
               cityMap.put("planmoney",  allUser.get(i).get("offerUserPlanYearWages") == null ? "" : String.valueOf(allUser.get(i).get("offerUserPlanYearWages")) + "万元");
               cityMap.put("plandidian",  allUser.get(i).get("offerUserCity") == null ? "" : String.valueOf(allUser.get(i).get("offerUserCity")));
               cityMap.put("tuijiantime",  "");
               status = allUser.get(i).get("status") == null ? "" : allUser.get(i).get("status");
               if (!"".equals(status)) {
                  status = status.equals("0") ? "停用" : status.equals("1") ? "未提交" : status.equals("2") ? "待审批" : status.equals("3") ? "审批不通过" : status.equals("4")? "审批通过" : "已下线";
                }
               cityMap.put("status",  status);
               cityMap.put("id", String.valueOf(allUser.get(i).get("id")));
               firmList.add(cityMap);
            }
            map.put("users", firmList);
            
            map.put("allNum", allUser.size());
            map.put("pageNum", allUser.size() == 0 ? 1 : Math.ceil(allUser.size() / 20.0));
            return toJson(map);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);//返回密码错误
      }

      @ResponseBody
      @RequestMapping(value = "/login/userinformation2", produces = "application/json")
      public Map<String, Object> userinformation2(HttpServletRequest request, @RequestBody String data) {
         try {
            
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);//返回密码错误
      }

      @ResponseBody
      @RequestMapping(value = "/login/userqiuzhi1", produces = "application/json")
      public Map<String, Object> userqiuzhi1(HttpServletRequest request, @RequestBody String data) {
         try {
           String userId = request.getSession().getAttribute("userId").toString();
           Map<String, Object> map = new HashMap<String, Object>();
           Map<String, String> nowMap = new HashMap<String, String>();
           nowMap.put("offerCandidateId", userId);
           
           nowMap.put("status", "'0','1'");//新的面试邀请
           List<Map<String, String>> list1 = baseService.getOfferInvite(nowMap);
           
           nowMap.put("status", "1");//待沟通
           List<Map<String, String>> list2 = baseService.getOfferInvite(nowMap);
           
           nowMap.put("status", "2");//待安排面试
           List<Map<String, String>> list3 = baseService.getOfferInvite(nowMap);

           nowMap.put("status", "3");//已安排面试
           List<Map<String, String>> list4 = baseService.getOfferInvite(nowMap);

           nowMap.put("status", "'4','5'");//面试结果
           List<Map<String, String>> list5 = baseService.getOfferInvite(nowMap);

           nowMap.put("status", "6");//已拒绝面试邀请
           List<Map<String, String>> list6 = baseService.getOfferInvite(nowMap);
           
           map.put("new1", list1 == null ? "0" : list1.size());
           map.put("talk", list2 == null ? "0" : list2.size());
           map.put("waitanpai", list3 == null ? "0" : list3.size());
           map.put("anpaied", list4 == null ? "0" : list4.size());
           map.put("mianshi", list5 == null ? "0" : list5.size());
           map.put("jujue", list6 == null ? "0" : list6.size());
           return toJson(map);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);//返回密码错误
      }

      //面试页面2
      @ResponseBody
      @RequestMapping(value = "/firm/userqiuzhi2", produces = "application/json")
      public Map<String, Object> userqiuzhi2(HttpServletRequest request, @RequestBody String data) {
         try {
            putToForm(data);
            String status = form.get("interviewtype");
            String offerUserId = request.getSession().getAttribute("userId") + "";
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
//                firmMap.put("imgpath", "../img/changjinglu.jpg");
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
      @RequestMapping(value = "/firm/userqiuzhi3", produces = "application/json")
      public Map<String, Object> userqiuzhi3(HttpServletRequest request, @RequestBody String data) {
         try {
            putToForm(data);
            String inviteId = form.get("inviteId");
            String offerUserId = request.getSession().getAttribute("userId") + "";
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
      
      @ResponseBody
      @RequestMapping(value = "/change/changeUserMsgStatus", produces = "application/json")
      public Map<String, Object> changeUserMsgStatus(HttpServletRequest request, @RequestBody String data) {
         try {
             OfferUser offerUser = offerUserService.getOfferUser(request.getSession().getAttribute("id").toString());
             offerUser.setEmailmsg(data);
             offerUserService.updateOfferUser(offerUser);
             return toJson(SUCCESS);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);//返回密码错误
      }
      
      //面试页面3
      @ResponseBody
      @RequestMapping(value = "/firm/usertuijian", produces = "application/json")
      public Map<String, Object> usertuijian(HttpServletRequest request, @RequestBody String data) {
         try {
            putToForm(data);
            String firmId = request.getSession().getAttribute("firmId").toString();
            List<OfferFirm> offerFirms = offerFirmService.getOfferFirms(firmId);
            List<Map<String, String>> frims = new ArrayList<Map<String,String>>();
            if (offerFirms.size() >0) {
            	frims = offerFirmService.getfrimtuijianUsery(String.valueOf(offerFirms.get(0).getAdminId()),firmId, form);
			}
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("frims", frims);
            
            return toJson(map);
         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);
      }
      
      //面试页面3
      @ResponseBody
      @RequestMapping(value = "/system/changepsw", produces = "application/json")
      public Map<String, Object> changepsw(HttpServletRequest request, @RequestBody String data) {
         try {
            putToForm(data);
            
            Map<String, String> emailMap = new HashMap<String, String>();
            OfferEmail offerEmail = baseService.getEmailContent('8').get(0);
            emailMap.put("toMail", form.get("email"));
            emailMap.put("mailtitle", offerEmail.getEmailTitle());
            emailMap
                  .put("mailContent",
                        offerEmail
                              .getEmailContext()
                              .toString()
                              .replace("[0]",
                                    "<a href='"+Code.fangwenPath + "/system/changepsw1.do?offerUserEmail="+form.get("email")+"'>" + Code.fangwenPath + "/user/jihuoyouxiang.do?offerUserEmail="+form.get("email")+ "</a>"));
            sendEmail.sendEmail(emailMap);

         } catch (Exception e) {
            e.printStackTrace();
         }
         return toJson(SUCCESS);
      }
      
      //点击邮箱连接后跳转方法，保存状态完成后跳转到登录页面
      @ResponseBody
      @RequestMapping(value = "/system/changepsw1", produces = "application/json")
      public Map<String, Object> jihuoyouxiang(HttpServletResponse response,HttpServletRequest request) {//修改密码
         try {
           
           List<OfferUser> offerUsers = offerUserService.getOfferUserforEmail(request.getParameter("offerUserEmail").toString());
           if(offerUsers.size()>0){
              request.getSession().setAttribute("id", offerUsers.get(0).getId());
           }
           response.sendRedirect("../jsp/check_email3.jsp");
         }
         catch (Exception e) {
            e.printStackTrace();
         }
         return null;
      }
      
      private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
      
      @Autowired
      private OfferUserService offerUserService;
      
      @Autowired
      private OfferFirmService offerFirmService;
      
      @Autowired
      private OfferUserInformationService offerUserInformationService;
      
      @Autowired
      private OfferJobService offerJobService;
      
      @Autowired
      private BaseService     baseService;
      
      @Autowired
      private GeneratePDF     generatePDF;
      
      @Autowired
      private SendEmail sendEmail;
      
      @Autowired
      private OfferFirmInformationService offerFirmInformationService;
      
      @Autowired
      private Encryption encryption;
      
      @Autowired
      private ConUtil conUtil;
      
      @Autowired
      private OfferPhotoService offerPhotoService;
      
      @Autowired
      private OfferFirmTechnologyService OfferFirmTechnologyService;
      
      @Autowired
      private OfferFirmReportService offerFirmReportService;
      
      @Autowired
      private OfferInviteChatService offerInviteChatService;
      
      @Autowired
      private OfferInviteService offerInviteService;
      
      @Autowired
      private OfferFirmProduceService offerFirmProduceService;
      
      @Autowired
      private OfferFirmSelectService  offerFirmSelectService;
}
