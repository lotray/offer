package com.offer.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.text.Normalizer.Form;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offer.dao.BaseDao;
import com.offer.model.Guwen;
import com.offer.model.OfferCollect;
import com.offer.model.OfferEmail;
import com.offer.model.OfferFirm;
import com.offer.model.OfferFirmChoose;
import com.offer.model.OfferFirmInformation;
import com.offer.model.OfferFirmIntroduce;
import com.offer.model.OfferFirmProduce;
import com.offer.model.OfferFirmReport;
import com.offer.model.OfferFirmSelect;
import com.offer.model.OfferFirmTechnology;
import com.offer.model.OfferFirmWelfare;
import com.offer.model.OfferInvite;
import com.offer.model.OfferInviteChat;
import com.offer.model.OfferUser;
import com.offer.model.OfferUserInformation;
import com.offer.service.BaseService;
import com.offer.service.OfferFirmInformationService;
import com.offer.service.OfferFirmIntroduceService;
import com.offer.service.OfferFirmProduceService;
import com.offer.service.OfferFirmReportService;
import com.offer.service.OfferFirmSelectService;
import com.offer.service.OfferFirmService;
import com.offer.service.OfferFirmTechnologyService;
import com.offer.service.OfferUserService;
import com.offer.util.Code;
import com.offer.util.ConUtil;
import com.offer.util.Encryption;
import com.offer.util.FileUtils;
import com.offer.util.SendEmail;

@Service("offerFirmService")
public class OfferFirmServiceImpl extends BaseServiceImpl implements OfferFirmService {

   @Autowired
   private BaseDao    baseDao;

   @Autowired
   private Encryption encryption;
   
   @Autowired
   private ConUtil conUtil;
   
   @Autowired
   private BaseService baseService;
   
   @Autowired
   private OfferUserService offerUserService;
   
   @Autowired
   private OfferFirmInformationService offerFirmInformationService;
   
   @Autowired
   private OfferFirmTechnologyService offerFirmTechnologyService;
   
   @Autowired
   private OfferFirmProduceService offerFirmProduceService;
   
   @Autowired
   private OfferFirmReportService offerFirmReportService;
   
   @Autowired
   private OfferFirmIntroduceService offerFirmIntroduceService;
   
   @Autowired
   private SendEmail             sendEmail;

   @Override
   public List<OfferFirm> getOfferFirms(Serializable id) throws Exception {
      return (List<OfferFirm>) baseDao.findField(OfferFirm.class, id);
   }

   @Override
   public void saveOfferFirm(HttpServletRequest request) throws Exception {
      String firmName = request.getParameter("firmName");
      String userName = request.getParameter("userName");
      String nowJob = request.getParameter("nowJob");
      String email = request.getParameter("email");
      String phone = request.getParameter("phone");
      String password = request.getParameter("password");
      String emailSuffix = email.substring(email.lastIndexOf("@"), email.length());

      List<OfferFirm> offerFirms = findByNameAndEmail(firmName, emailSuffix);
      OfferFirm offerFirm = new OfferFirm();
      if (offerFirms == null || offerFirms.size() == 0) {
         offerFirm.setCreateTime(new Date());
         offerFirm.setOfferName(firmName);
         offerFirm.setOfferEmail(emailSuffix);
         offerFirm.setStatus("2");
         baseDao.save(offerFirm);
      }
      else {
         offerFirm = offerFirms.get(0);
      }

      OfferUser offerUser = new OfferUser();
      offerUser.setCreateTime(new Date());
      offerUser.setFirmId(offerFirm.getId());
      offerUser.setIsoffer("1");
      offerUser.setOfferUserEmail(email);
      offerUser.setOfferUserPassword(encryption.encryption(password));
      offerUser.setOfferJobId(Integer.valueOf(nowJob));
      offerUser.setOfferUserPhone(phone);
      offerUser.setOfferUserName(userName);
      baseDao.save(offerUser);
      
//      try {
//    	  Map<String, String> emailMap = new HashMap<String, String>();
//    	  OfferEmail offerEmail = baseService.getEmailContent('4').get(0);
//    	  emailMap.put("toMail", email);
//    	  emailMap.put("mailtitle", offerEmail.getEmailTitle());
//    	  emailMap.put("mailContent", offerEmail.getEmailContext().toString().replace("[0]", "<a>"+Code.fangwenPath+"/user/jihuoyouxiang.do?userIdString="+offerUser.getId()+"&userStatus="+1+"</a>"));
//    	  sendEmail.sendEmail(emailMap);
//	} catch (Exception e) {
//		e.printStackTrace();
//	}

   }

   @Override
   public void saveOfferFirm(OfferFirm offerFirm) throws Exception {
      baseDao.save(offerFirm);
   }

   @Override
   public void updateOfferFirm(OfferFirm offerFirm) throws Exception {
      baseDao.update(offerFirm);
   }

   @Override
   public void deleteOfferFirm(OfferFirm offerFirm) throws Exception {
      baseDao.delete(offerFirm);
   }

   public List<OfferFirm> findAllOfferFirms() throws Exception {
      try {
         Map<String, String> map = new HashMap<String, String>();
         List<OfferFirm> offerFirms = (List<OfferFirm>) baseDao.findField(OfferFirm.class, map);
         return offerFirms;
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   @Override
   public List<OfferFirm> findByNameAndEmail(String name, String email) throws Exception {
      Map<String, String> map = new HashMap<String, String>();
      map.put("offerEmail", email);
      map.put("offerName", name);
      List<OfferFirm> offerFirms = (List<OfferFirm>) baseDao.findField(OfferFirm.class, map);
      return offerFirms;
   }

   @Override
   public String findByName(String name) throws Exception {
      Map<String, String> map = new HashMap<String, String>();
      map.put("offerName", name);
      List<OfferFirm> offerFirms = (List<OfferFirm>) baseDao.findField(OfferFirm.class, map);
      if (offerFirms != null && offerFirms.size() > 0) {

      }
      return null;
   }

   @Override
   public String findByuserId(String userId) throws Exception {
      Map<String, String> map = new HashMap<String, String>();
      map.put("admin_id", userId);
      List<OfferFirm> offerFirms = (List<OfferFirm>) baseDao.findField(OfferFirm.class, map);
      if (offerFirms != null && offerFirms.size() > 0) {

      }
      return null;
   }
   
   @Override
   public List<Map<String, String>> findByEmail(String email) throws Exception {
	   if(email.indexOf("@") < 0){
		   return null;
	   }
      String emailSuffix = email.substring(email.lastIndexOf("@"), email.length());
      String sql = "SELECT firm.id,firm.offer_name AS name FROM offer_firm firm WHERE firm.offer_email like '%" + emailSuffix + "%' and firm.status = '4'";
      return baseDao.findBySql(sql);
   }

   @Override
   public List<Map<String, String>> getFirmInformation(String id) throws Exception {
      Map<String, String> param = new HashMap<String, String>();
      param.put("param", "WHERE U.ID = '" + id + "' ");
      return baseDao.findByQuery("/sql/sql_firm_information.xml", param);
   }
   
   @Override
   public List<Map<String, String>> getAllFirmInformation(Map<String, String> nowMap) throws Exception {
      Map<String, String> map = new HashMap<String, String>();
      StringBuffer param = new StringBuffer();
      param.append("WHERE 1=1 ");
      String str = nowMap.get("isoffer");
      if (str != null && str.length() > 0) {
         param.append(" AND isoffer = '" + str + "' ");
      }
      str = nowMap.get("status");
      if (str != null && str.length() > 0) {
         param.append(" AND F.status = '" + str + "' ");
      }
      str = nowMap.get("firmCity");
      if (str != null && str.length() > 0) {
         param.append(" AND I.firm_city = '" + str + "' ");
      }
      str = nowMap.get("adminId");
      if (str != null && str.length() > 0) {
         param.append(" AND F.ADMIN_ID = U.ID ");
      }
      str = nowMap.get("firmSimpleName");
      if (str != null && str.length() > 0) {
         param.append(" AND I.FIRM_SIMPLE_NAME LIKE '%" + str + "%' ");
      }
//      str = nowMap.get("firmjob");
//      if (str != null && str.length() > 0) {
//         param.append(" AND S.allJobIds LIKE '%" + str + "%' ");
//      }
      str = nowMap.get("firmName");
      if (str != null && str.length() > 0) {
         param.append(" AND (I.FIRM_ALL_NAME LIKE '%" + str + "%' OR I.FIRM_SIMPLE_NAME LIKE '%" + str + "%')");
      }
      str = nowMap.get("limit");
      if (str != null && str.length() > 0) {
         param.append(" GROUP BY U.ID LIMIT " + (Integer.valueOf(str) - 1) * 20 + "," + Integer.valueOf(str) * 20 + " ");
      }
      map.put("param", param.toString());
      return baseDao.findByQuery("/sql/sql_firm_information.xml", map);
   }
   
	public void saveOfferFirm(Map<String, String> map) throws Exception{
	   try {
         String offerUserId = map.get("offerUserId").equals("null") ? "" : map.get("offerUserId");
         OfferUser offerUser = offerUserService.getOfferUser(Integer.valueOf(offerUserId));
	      Date date = new Date();
	      map.put("areaId", map.get("firmAreaValue"));
	      map.put("firmCreateYear", map.get("firmCreateYearValue"));
	      map.put("firmTeamSize", map.get("firmTeamSizeValue"));
	      map.put("firmSize", map.get("firmSizeValue"));
	      map.put("firmStage", map.get("firmStageValue"));
         map.put("reportLink", map.get("inputCode"));
         map.put("welfareId", map.get("firmWelfare"));
	      
	      String offerFirmId = map.get("offerFirmId").equals("null") ? "" : map.get("offerFirmId");
	      OfferFirm offerFirm;
	      if ("".equals(offerFirmId)) {
	         offerFirm = new OfferFirm();
	         offerFirm.setCreateTime(date);
	         if (map.get("ret").equals("2")) {
	            offerFirm.setStatus("2");
            }
	         else {
	            offerFirm.setStatus("1");
	         }
	         offerFirm.setAdminId(Integer.valueOf(offerUserId));
	         offerFirm.setOfferEmail(offerUser.getOfferUserEmail());
	         String emailSuffix = offerUser.getOfferUserEmail();
	         emailSuffix = emailSuffix.substring(emailSuffix.lastIndexOf("@"), emailSuffix.length());
	         offerFirm.setEndless(emailSuffix);
	      }
	      else {
   	      offerFirm = getOfferFirms(Integer.valueOf(offerFirmId)).get(0);
   	      map.put("id", offerFirmId);
   	      if (!"4".equals(offerFirm.getStatus())) {
               offerFirm.setStatus("2");
            }
   	   }
	      map.put("offerName", map.get("firmAllName"));
	      conUtil.mapToObject(offerFirm, map);
//         if (returnString(offerFirm.getStatus()).equals("4")) {
//            
//         }
//         else {
//            offerFirm.setStatus("2");
//            
//         }
	      baseDao.saveOrUpdate(offerFirm);

         map.put("firmId", offerFirm.getId() + "");
         if (!"4".equals(offerUser.getStatus())) {
            if (map.get("ret").equals("2")) {
               offerUser.setStatus("2");
            }
         }
         offerUser.setFirmId(offerFirm.getId());
         baseDao.update(offerUser);
	      
	      map.put("firmId", offerFirm.getId()+"");
         
         String offerFirmInformationId = map.get("offerFirmInformationId").equals("null") ? "" : map.get("offerFirmInformationId");
         OfferFirmInformation offerFirmInformation;
         if ("".equals(offerFirmInformationId)) {
            offerFirmInformation = new OfferFirmInformation();
            map.put("id", "");
         }
         else {
            offerFirmInformation = offerFirmInformationService.getOfferFirmInformationById(offerFirmInformationId).get(0);
            map.put("id", offerFirmInformationId);
         }
         conUtil.mapToObject(offerFirmInformation, map);
         baseDao.saveOrUpdate(offerFirmInformation);

	      String offerFirmTechologyId = map.get("offerFirmTechologyId").equals("null") ? "" : map.get("offerFirmTechologyId");
	      OfferFirmTechnology offerFirmTechnology;
	      if ("".equals(offerFirmTechologyId)) {
	         offerFirmTechnology = new OfferFirmTechnology();
	         offerFirmTechnology.setCreateTime(date);
	         map.put("id", "");
	      }
	      else{
	         offerFirmTechnology = offerFirmTechnologyService.getOfferFirmTechnology(Integer.valueOf(offerFirmTechologyId)).get(0);
	         map.put("id", offerFirmTechologyId);
	      }
	      conUtil.mapToObject(offerFirmTechnology, map);
	      baseDao.saveOrUpdate(offerFirmTechnology);
	      
	      String offerFirmProduceId = map.get("offerFirmProduceId").equals("null") ? "" : map.get("offerFirmProduceId");
	      OfferFirmProduce offerFirmProduce;
	      if ("".equals(offerFirmProduceId)) {
	         offerFirmProduce = new OfferFirmProduce();
	         offerFirmProduce.setCreateTime(date);
            map.put("id", "");
	      }
	      else {
	         offerFirmProduce = offerFirmProduceService.getOfferFirmProduces(Integer.valueOf(offerFirmProduceId)).get(0);
	         map.put("id", offerFirmProduceId);
	      }
	      conUtil.mapToObject(offerFirmProduce, map);
	      baseDao.saveOrUpdate(offerFirmProduce);
	      
	      String offerFirmReportId = map.get("offerFirmReportId").equals("null") ? "" : map.get("offerFirmReportId");
	      OfferFirmReport offerFirmReport;
	      if ("".equals(offerFirmReportId)) {
	         offerFirmReport = new OfferFirmReport();
	         map.put("id", "");
         }
	      else {
	         offerFirmReport = offerFirmReportService.getOfferFirmReports(Integer.valueOf(offerFirmReportId)).get(0);
	         map.put("id", offerFirmReportId);
	      }
	      conUtil.mapToObject(offerFirmReport, map);
         baseDao.saveOrUpdate(offerFirmReport);
         
         String offerFirmIntroduceId = map.get("offerFirmIntroduceId").equals("null") ? "" : map.get("offerFirmIntroduceId");
         OfferFirmIntroduce offerFirmIntroduce;
         if ("".equals(offerFirmIntroduceId)) {
            offerFirmIntroduce = new OfferFirmIntroduce();
            offerFirmIntroduce.setCreateTime(date);
            map.put("id", "");
         }
         else {
            offerFirmIntroduce = offerFirmIntroduceService.getOfferFirmIntroduces(Integer.valueOf(offerFirmIntroduceId)).get(0);
            map.put("id", offerFirmIntroduceId);
         }
         conUtil.mapToObject(offerFirmIntroduce, map);
         baseDao.saveOrUpdate(offerFirmIntroduce);
         
         String offerFirmWelfareId = map.get("offerFirmWelfareId").equals("null") ? "" : map.get("offerFirmWelfareId");
         OfferFirmWelfare offerFirmWelfare;
         if ("".equals(offerFirmWelfareId)) {
            offerFirmWelfare = new OfferFirmWelfare();
            map.put("id", "");
         }
         else {
            map.put("id", offerFirmWelfareId);
            offerFirmWelfare = ((List<OfferFirmWelfare>) baseDao.findField(OfferFirmWelfare.class, offerFirmWelfareId)).get(0);
         }
         conUtil.mapToObject(offerFirmWelfare, map);
         baseDao.saveOrUpdate(offerFirmWelfare);
      }
      catch (Exception e) {
         e.printStackTrace();
      }
	   
   }
	
	public void saveOfferFirmPhoto(String FILE_PATH, File fileLogo, List<File> fileEnvironment) throws Exception {
	   if (fileLogo != null) {
	      String saveStoreName = "";
	      String cName = String.valueOf(System.currentTimeMillis());
	      String path = FILE_PATH + File.separator + "upload/photo/" + File.separator;
	      String endless = fileLogo.getName().substring(fileLogo.getName().lastIndexOf("."));
	      FileUtils.fileUpload(path + File.separator + cName + endless, fileLogo);
	      String thumbnailpath = FILE_PATH + File.separator + "upload/auction/" + File.separator + cName;
	      String imagePath = thumbnailpath + File.separator + saveStoreName.split(",")[0];
	      String extension = "";
	      BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
	      int width = bufferedImage.getWidth();
	      int height = bufferedImage.getHeight();
	      /**
	       * 压缩计算 float resizeTimes = 0.3f; //这个参数是要转化成的倍数,如果是1就是转化成1倍//
	       * 调整后的图片的宽度和高度 int toWidth = (int) (width * resizeTimes); int
	       * toHeight = (int) (height * resizeTimes);
	       **/
	      int newSize = 100;
	      if (newSize >= width) {
	         if (newSize < height) {
	            width = (int) (width * newSize / height);
	            height = newSize;
	         }
	      }
	      else {
	         if (newSize >= height) {
	            height = (int) (height * newSize / width);
	            width = newSize;
	         }
	         else {
	            if (height > width) {
	               width = (int) (width * newSize / height);
	               height = newSize;
	            }
	            else {
	               height = (int) (height * newSize / width);
	               width = newSize;
	            }
	         }
	      }
	      Thumbnails.of(imagePath).size(width, height).outputFormat(extension).outputQuality(0.8f)
	      .toFile(thumbnailpath + File.separator + "thumbnail" + File.separator + saveStoreName.split(",")[0]);//保存小图
	   }
   }
	
	public void saveOfferFirmChoose(Map<String, String> map) throws Exception {//保存选筛选条件，5条记录
	   String firmcity = map.get("firmcity");
	   String firmjobValue = map.get("firmjob");//firmjobValue
	   String firmworkedValue = map.get("firmworkedValue");
	   String lastChoose = map.get("lastChoose");
	   map.put("offerFirmChooseCity", firmcity);
	   map.put("offerFirmChooseJob", firmjobValue);
	   map.put("offerFirmChooseWorkTime", firmworkedValue);
	   map.put("offerLastChoose", lastChoose);
	   
	   if (!"".equals(firmcity) || !"".equals(firmjobValue) || !"".equals(firmworkedValue) || !"".equals(lastChoose)) {
	      List<OfferFirmChoose> offerFirmChooses = baseService.getOfferFirmChooses(map.get("offerUserId"), map.get("offerFirmId"));
	      if (offerFirmChooses.size() >= 5) {
	         baseDao.delete(offerFirmChooses.get(0));
	      }
         OfferFirmChoose offerFirmChoose = new OfferFirmChoose();
         conUtil.mapToObject(offerFirmChoose, map);
         baseDao.save(offerFirmChoose);
      }
	}
	
	public void selectfindusersum1(Map<String, String> map) throws Exception {
	   OfferCollect offerCollect;
	   List<OfferCollect> offerCollects = baseService.getOfferCollects(map);
	   if (offerCollects.size() > 0) {
	      offerCollect = offerCollects.get(0);
	      conUtil.mapToObject(offerCollect, map);
	      offerCollect.setCreateTime(new Date());
	      baseDao.update(offerCollect);
      }
	   else{
	      offerCollect = new OfferCollect();
	      conUtil.mapToObject(offerCollect, map);
	      offerCollect.setCreateTime(new Date());
	      baseDao.save(offerCollect);
	   }
	}
	
	public void saveOfferInvite(Map<String, String> map) throws Exception {
	   String candidateId = map.get("offerCandidateId");
	   map.put("candidateId", candidateId);
	   
	   Date date = new Date();
	   OfferInvite offerInvite = new OfferInvite();
	   conUtil.mapToObject(offerInvite, map);
	   offerInvite.setCreateTime(date);
	   offerInvite.setStatus(0);
	   baseDao.save(offerInvite);
	   
	   OfferInviteChat offerInviteChat = new OfferInviteChat();
	   conUtil.mapToObject(offerInviteChat, map);
	   offerInviteChat.setInviteId(offerInvite.getId());
	   offerInviteChat.setChatCreateTime(date);
	   offerInviteChat.setStatus(0);
      baseDao.save(offerInviteChat);
	}

	@Override
	public void changefirmStatus(Map<String, String> map) throws Exception {
		 try {
		     String beizhu = map.get("beizhu");
		     String offerFirmId = map.get("offerFirmId");
		     List<OfferFirm> offerFirms = getOfferFirms(map.get("offerFirmId"));
		     offerFirms.get(0).setOfferAdviserRemark(beizhu);
		     offerFirms.get(0).setStatus(map.get("status"));
		     baseDao.update(offerFirms.get(0));
	         
		     List<OfferUser> offerUsers = offerUserService.getOfferUserByfirmId(offerFirmId);
		     for (int i = 0; i < offerUsers.size(); i++) {
		    	 offerUsers.get(i).setStatus(map.get("status"));
		    	 baseDao.saveOrUpdate(offerUsers.get(i));
			 }
	         
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
	@Override
	public void saveexaminefirm1(Map<String, String> map) throws Exception {
	   try {
         String offerUserId = map.get("offerUserId");
         String offerFirmId = map.get("offerFirmId");
         List<OfferFirm> offerFirms = getOfferFirms(offerFirmId);
         if (offerFirms.size() == 1) {
            String offerName = map.get("firmAllName");
            OfferFirm offerFirm = offerFirms.get(0);
            offerFirm.setOfferName(offerName);
            offerFirm.setStatus("2");
            baseDao.update(offerFirm);
            List<OfferFirmInformation> offerFirmInformations = offerFirmInformationService.getOfferFirmInformation(offerFirmId);
            if (offerFirmInformations.size() == 1) {
               String firmStageValue = map.get("firmStageValue");
               String firmCityValue = map.get("firmCityValue");
               OfferFirmInformation offerFirmInformation = offerFirmInformations.get(0);
               conUtil.mapToObject(offerFirmInformation, map);
               offerFirmInformation.setFirmStage(firmStageValue);
               offerFirmInformation.setFirmCity(firmCityValue);
               baseDao.update(offerFirmInformation);
            }
            OfferUser offerUser = offerUserService.getOfferUser(offerUserId);
            offerUser.setStatus("2");
            baseDao.update(offerUser);
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
	}
	
	@Override
	public List<Map<String, String>> getfrimtuijianUsery(String userId,String frimId, Map<String, String> nowMap) throws Exception {//地市城市
	   StringBuffer param = new StringBuffer();
	   Map<String, String> map = new HashMap<String, String>();
//	   List<OfferFirmSelect> offerFirmSelects = offerFirmSelectService.getOfferSelect(userId);		   
//	   param.append(" SELECT oc.city_name as address, oj.job_name as job, ou.offer_user_name as name, oue.offer_user_xueli as xueli, oui.offer_user_worktime as jingyan,"+
//                   "oui.offer_user_now_year_wages as nowmoney,oui.offer_user_plan_year_wages as planmoney,oc.city_name as plandidian,DATE_FORMAT(ou.last_login_time,'%Y-%m-%d') as tuijianTime,oin.`status` "+
//                   " FROM offer_user ou LEFT JOIN offer_user_infomation oui ON oui.offer_user_id = ou.id " +
//                   " LEFT JOIN offer_city oc ON oc.city_name = oui.offer_user_work_place LEFT JOIN offer_job oj ON oj.id = oui.offer_user_job1" +
//                   " LEFT JOIN offer_user_education oue ON oue.offer_user_id = ou.id LEFT JOIN offer_invite oin ON oin.candidate_id = ou.id WHERE ou.isoffer = '1' ");
//	   if (offerFirmSelects.size() >0) {
//	   if (userId != null && userId.length() > 0) {
//		   String limit = nowMap.get("pageId");
//	      param.append(" AND ou.last_login_time < SYSDATE() AND ou.last_login_time > date_sub(SYSDATE(),interval "+getTJ("1").get(0).getTJT().charAt(0)
//	    		  +" day) AND (oui.offer_user_worktime = '"+offerFirmSelects.get(0).getYearIds()+"' OR oui.offer_user_job1 in ("+offerFirmSelects.get(0).getJobIds()+
//	    		  ") OR oui.offer_user_job2 in ("+offerFirmSelects.get(0).getJobIds()+
//	    		  ") OR oc.id in ("+offerFirmSelects.get(0).getCityIds()+"))" + 
//	    		  " GROUP BY ou.offer_user_name LIMIT " + (Integer.valueOf(limit) - 1) * 20 + "," + Integer.valueOf(limit) * 20 + " ");
//
//		  }
//	   }
	   if (userId != null && userId.length() > 0) {
		   String limit = nowMap.get("pageId");
		   param.append(" WHERE of.id = '"+frimId+"'LIMIT " + (Integer.valueOf(limit) - 1) * 20 + "," + Integer.valueOf(limit) * 20 + " ");
	   }
	   
	   map.put("param1", param.toString());
	   List<Map<String, String>> list = baseDao.findByQuery("/sql/sql_frimTuijianUser.xml", map);
//	   List<Map<String, String>> list = baseDao.findBySql(param.toString());
	   return list;
	}
	
	@Override
	public List<Map<String, String>> getfrimfinduser(String cityIds,String jobIds, String yearIds) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer param = new StringBuffer();
		Map<String, String> map = new HashMap<String, String>();
		param.append( " AND (oui.offer_user_worktime = '"+yearIds+"' OR oui.offer_user_job1 in ("+jobIds+
		    		  ") OR oui.offer_user_job2 in ("+jobIds+
		    		  ") OR oc.id in ("+cityIds+"))");
		map.put("param", param.toString());
		List<Map<String, String>> list = baseDao.findByQuery("/sql/sql_finduser_tuijian.xml", map);
		return list;
	}
	
	  @Override
	   public List<Map<String, String>> getfrimfinduser4two(String cityIds,String jobIds, String yearIds) throws Exception {
	      // TODO Auto-generated method stub
	      StringBuffer param = new StringBuffer();
	      Map<String, String> map = new HashMap<String, String>();
	      param.append( " AND (oui.offer_user_worktime = '"+yearIds+"' OR oui.offer_user_job1 in ("+jobIds+
	                 ") OR oui.offer_user_job2 in ("+jobIds+
	                 ") OR oc.id in ("+cityIds+"))");
	      map.put("param", param.toString());
	      List<Map<String, String>> list = baseDao.findByQuery("/sql/sql_finduser_tuijian.xml", map);
	      return list;
	   }
	
	@Autowired
	private OfferFirmSelectService offerFirmSelectService;


}
