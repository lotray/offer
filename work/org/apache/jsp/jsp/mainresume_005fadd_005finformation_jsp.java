/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2017-04-06 03:26:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;

public final class mainresume_005fadd_005finformation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/common/header.jsp", Long.valueOf(1491447915118L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>My JSP 'index.jsp' starting page</title>\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("<link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../css/base.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../skins/all.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"../css/bootstrap-datetimepicker.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"../img/title.ico\" type=\"image/x-icon\"/>\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<script src=\"../js/jquery-3.1.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../js/ajaxfileupload.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../js/ajaxSubmit.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"../js/Carousel.js\"></script>\r\n");
      out.write("<script src=\"../js/jquery.icheck.js\"></script>\r\n");
      out.write("<script src=\"../js/custom.js\"></script>\r\n");
      out.write("<script src=\"../js/custom.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/bootstrap-datetimepicker.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"../js/locales/bootstrap-datetimepicker.zh-CN.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("\t\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction upload() {\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"register/firm.do\", // 自行按需配置好完整的url，包括ip和端口号  \r\n");
      out.write("\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\tdatatype : \"text\",\r\n");
      out.write("\t\t\tdata : JSON.stringify($(\"#form1\").serializeObject()),\r\n");
      out.write("\t\t\tcontentType : \"application/json\",\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t//头部\r\n");
      out.write("\tfunction changeColor1(der){\r\n");
      out.write("\t\tder.style.background=\"#CCCCCC\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction changeColor2(der){\r\n");
      out.write("\t\tder.style.background=\"#32373C\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<title></title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("</head>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tvar dataName;\r\n");
      out.write("\t//头部\r\n");
      out.write("\tfunction changeColor1(der){\r\n");
      out.write("\t\tder.style.background=\"#999999\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction changeColor2(der){\r\n");
      out.write("\t\tder.style.background=\"#000\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction init() {\r\n");
      out.write("\t\tif(isResetLogin()) {\r\n");
      out.write("\t\t\talert(\"登陆超时!\");\r\n");
      out.write("\t\t\ttop.location.href='login.jsp';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse{\r\n");
      out.write("\t\t\tvar url = \"user/resumeAddInformationPage1.do\";\r\n");
      out.write("\t\t\tvar formId = \"userInformationForm\";\r\n");
      out.write("\t\t\tvar data = ajaxSumbit(url, formId);\r\n");
      out.write("\t\t\tdataName = data.dataName;\r\n");
      out.write("\t\t\taddCheckJob(data.nowJobList);\r\n");
      out.write("\t\t\tif(data.offerUserName != undefined){\r\n");
      out.write("\t\t\t\teditCheckJob(data.jobId1,data.jobId2, data.jobvalue1, data.jobvalue2);\r\n");
      out.write("\t\t\t\tsetSexValue(data.offerUserSex);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t$(\"#userInformationForm\").populateForm(data);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//性别\r\n");
      out.write("\tfunction setSexValue(id) {\r\n");
      out.write("\t\tif(id == 1){\r\n");
      out.write("\t\t\tdocument.getElementById(\"sex1\").style=\"color:#FFF;background-color:#00B38A;border-color:#00B38A;width:100px;\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"sex2\").style=\"color:#00B38A;background-color:#FFF;border-color:#00B38A;width:100px;\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"offerUserSex\").value=\"1\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(id == 0){\r\n");
      out.write("\t\t\tdocument.getElementById(\"sex2\").style=\"color:#FFF;background-color:#00B38A;border-color:#00B38A;width:100px;\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"sex1\").style=\"color:#00B38A;background-color:#FFF;border-color:#00B38A;width:100px;\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"offerUserSex\").value=\"0\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//工作年限\r\n");
      out.write("\tfunction workTimeValue(time){\r\n");
      out.write("\t\tdocument.getElementById(\"offerUserWorktime\").value=time;\r\n");
      out.write("\t}\r\n");
      out.write("\t//添加职位\r\n");
      out.write("\tfunction addCheckJob(items){\r\n");
      out.write("\t\tvar jobs = \"<table width='100%'>\";\r\n");
      out.write("\t\tvar j = 1;\r\n");
      out.write("\t\tfor(var i in items){\r\n");
      out.write("\t\t\tif(j == 1){\r\n");
      out.write("\t\t\t\tjobs = jobs + \"<tr>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tjobs = jobs + \"<td class='textR' style='padding-top:10px;padding-bottom:10px;width:45;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"<div class='icheckbox_square-green hover' onclick='jobId(this)' id='\"+items[i].id+\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<input type='hidden' value='\"+items[i].value+\"'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<input tabindex='2' type='checkbox' style='opacity:0;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"</div>\"\r\n");
      out.write("\t\t\t\t\t\t+\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t+\"<td class='textL'><font size='2'>\"+items[i].value+\"</font></td>\";\r\n");
      out.write("\t\t\tif(j == 4){\r\n");
      out.write("\t\t\t\tjobs = jobs + \"</tr>\";\r\n");
      out.write("\t\t\t\tj = 1;\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tj = j+1;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tjobs = jobs + \"</table>\";\r\n");
      out.write("\t\tdocument.getElementById('checkJob').innerHTML=jobs;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction editCheckJob(job1, job2, jobname1, jobname2){\r\n");
      out.write("\t\tif(job1 != undefined){\r\n");
      out.write("\t\t\tdocument.getElementById(job1).setAttribute(\"class\",\"icheckbox_square-green checked\");\r\n");
      out.write("\t\t\teditworkyears(job1, jobname1, 1);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(job2 != undefined){\r\n");
      out.write("\t\t\tdocument.getElementById(job2).setAttribute(\"class\",\"icheckbox_square-green checked\");\r\n");
      out.write("\t\t\teditworkyears(job2, jobname2, 2);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//职位\r\n");
      out.write("\tfunction jobId(job){\r\n");
      out.write("\t\tvar jobNum = 1;\r\n");
      out.write("\t\tif(job.getAttribute('class') == \"icheckbox_square-green checked\"){\r\n");
      out.write("\t\t\tdelworkyears(job);\r\n");
      out.write("\t\t\tjob.setAttribute(\"class\",\"icheckbox_square-green hover\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(job.getAttribute('class') == \"icheckbox_square-green hover\"){\r\n");
      out.write("\t\t\t$(\".checked\").each(function () {\r\n");
      out.write("\t\t\t\tjobNum = jobNum + 1;\r\n");
      out.write("\t        });\r\n");
      out.write("\t\t\tif(jobNum > 2){\r\n");
      out.write("\t\t\t\talert(\"最多选择两项\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\taddworkyears(job);\r\n");
      out.write("\t\t\tjob.setAttribute(\"class\",\"icheckbox_square-green checked\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//职位年限\r\n");
      out.write("\tfunction addworkyears(obj){\r\n");
      out.write("\t\tvar jobId;\r\n");
      out.write("\t\tvar jobName;\r\n");
      out.write("\t\tvar jobtitle;\r\n");
      out.write("\t\tif(document.getElementById(\"job1\").getElementsByTagName(\"td\")[0] == undefined){\r\n");
      out.write("\t\t\tjobId = \"job1\";\r\n");
      out.write("\t\t\tjobName = \"jobyear1\";\r\n");
      out.write("\t\t\tjobtitle = \"job1_title\";\r\n");
      out.write("\t\t}else if(document.getElementById(\"job2\").getElementsByTagName(\"td\")[0] == undefined){\r\n");
      out.write("\t\t\tjobId = \"job2\";\r\n");
      out.write("\t\t\tjobName = \"jobyear2\";\r\n");
      out.write("\t\t\tjobtitle = \"job2_title\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(jobtitle).innerHTML = \"<td colspan='2'>您在\"+obj.getElementsByTagName(\"input\")[0].value+\"岗位上有多长时间的工作经验</td>\";\r\n");
      out.write("\t\tdocument.getElementById(jobId).innerHTML = \"\"\r\n");
      out.write("\t\t +\"<td class='textL'>\"\r\n");
      out.write("\t\t \t+\"<div class='input-group' style='margin-left:-10px !important;width: 90% !important'>\"\r\n");
      out.write("\t\t\t\t+\"<div class='dropdown'>\"\r\n");
      out.write("\t\t\t \t\t+\"<input type='text' name='\"+jobName+\"' id='\"+jobName+\"' class='form-control' style='width: 80% !important'>\"\r\n");
      out.write("\t\t\t \t\t+\"<button type='button' style='height:34px !important;background-color:#E6E6E6;' class='btn dropdown-toggle' id='dropdownMenu1' data-toggle='dropdown'>\"\r\n");
      out.write("\t\t\t \t\t\t+\"<span class='caret'></span>\"\r\n");
      out.write("\t\t\t \t\t+\"</button>\"\r\n");
      out.write("\t\t\t\t \t+\"<ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1' style='width: 90% !important'>\"\r\n");
      out.write("\t\t\t\t \t\t+\"<li role='presentation'>\"\r\n");
      out.write("\t\t\t\t \t\t\t+\"<a role='menuitem' tabindex='-1' href='#' onclick=\\\"workTime('1年','\"+jobName+\"')\\\"><font color='#000'>1年</font></a>\"\r\n");
      out.write("\t\t\t\t \t\t\t+\"<a role='menuitem' tabindex='-1' href='#' onclick=\\\"workTime('一至三年','\"+jobName+\"')\\\"><font color='#000'>一至三年</font></a>\"\r\n");
      out.write("\t\t\t\t \t\t\t+\"<a role='menuitem' tabindex='-1' href='#' onclick=\\\"workTime('三至五年','\"+jobName+\"')\\\"><font color='#000'>三至五年</font></a>\"\r\n");
      out.write("\t\t\t\t \t\t\t+\"<a role='menuitem' tabindex='-1' href='#' onclick=\\\"workTime('五年以上','\"+jobName+\"')\\\"><font color='#000'>五年以上</font></a>\"\r\n");
      out.write("\t\t\t\t \t\t+\"</li>\"\r\n");
      out.write("\t\t\t\t \t+\"</ul>\"\r\n");
      out.write("\t\t \t\t+\"</div>\"\r\n");
      out.write("\t\t \t+\"</div>\"\r\n");
      out.write("\t\t +\"</td>\"\r\n");
      out.write("\t\t ;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction editworkyears(jobId, jobN, a){\r\n");
      out.write("\t\tvar jobId;\r\n");
      out.write("\t\tvar jobName;\r\n");
      out.write("\t\tvar jobtitle;\r\n");
      out.write("\t\tif(a == 1){\r\n");
      out.write("\t\t\tjobId = \"job1\";\r\n");
      out.write("\t\t\tjobName = \"jobyear1\";\r\n");
      out.write("\t\t\tjobtitle = \"job1_title\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(a == 2){\r\n");
      out.write("\t\t\tjobId = \"job2\";\r\n");
      out.write("\t\t\tjobName = \"jobyear2\";\r\n");
      out.write("\t\t\tjobtitle = \"job2_title\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(jobtitle).innerHTML = \"<td colspan='2'>您在\"+jobN+\"岗位上有多长时间的工作经验</td>\";\r\n");
      out.write("\t\tdocument.getElementById(jobId).innerHTML = \"\"\r\n");
      out.write("\t\t +\"<td class='textL'>\"\r\n");
      out.write("\t\t \t+\"<div class='input-group' style='margin-left:-10px !important;width: 90% !important'>\"\r\n");
      out.write("\t\t\t\t+\"<div class='dropdown'>\"\r\n");
      out.write("\t\t\t \t\t+\"<input type='text' name='\"+jobName+\"' id='\"+jobName+\"' class='form-control' style='width: 80% !important'>\"\r\n");
      out.write("\t\t\t \t\t+\"<button type='button' style='height:34px !important;background-color:#E6E6E6;' class='btn dropdown-toggle' id='dropdownMenu1' data-toggle='dropdown'>\"\r\n");
      out.write("\t\t\t \t\t\t+\"<span class='caret'></span>\"\r\n");
      out.write("\t\t\t \t\t+\"</button>\"\r\n");
      out.write("\t\t\t\t \t+\"<ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1' style='width: 90% !important'>\"\r\n");
      out.write("\t\t\t\t \t\t+\"<li role='presentation'>\"\r\n");
      out.write("\t\t\t\t \t\t\t+\"<a role='menuitem' tabindex='-1' href='#' onclick=\\\"workTime('1年','\"+jobName+\"')\\\"><font color='#000'>1年</font></a>\"\r\n");
      out.write("\t\t\t\t \t\t\t+\"<a role='menuitem' tabindex='-1' href='#' onclick=\\\"workTime('一至三年','\"+jobName+\"')\\\"><font color='#000'>一至三年</font></a>\"\r\n");
      out.write("\t\t\t\t \t\t\t+\"<a role='menuitem' tabindex='-1' href='#' onclick=\\\"workTime('三至五年','\"+jobName+\"')\\\"><font color='#000'>三至五年</font></a>\"\r\n");
      out.write("\t\t\t\t \t\t\t+\"<a role='menuitem' tabindex='-1' href='#' onclick=\\\"workTime('五年以上','\"+jobName+\"')\\\"><font color='#000'>五年以上</font></a>\"\r\n");
      out.write("\t\t\t\t \t\t+\"</li>\"\r\n");
      out.write("\t\t\t\t \t+\"</ul>\"\r\n");
      out.write("\t\t \t\t+\"</div>\"\r\n");
      out.write("\t\t \t+\"</div>\"\r\n");
      out.write("\t\t +\"</td>\"\r\n");
      out.write("\t\t ;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction delworkyears(job){\r\n");
      out.write("\t\tvar title=\"您在\"+job.getElementsByTagName(\"input\")[0].value+\"岗位上有多长时间的工作经验\";\r\n");
      out.write("\t\tif(document.getElementById(\"job1_title\").innerText == title){\r\n");
      out.write("\t\t\tdocument.getElementById(\"job1_title\").innerHTML = \"\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"job1\").innerHTML = \"\";\r\n");
      out.write("\t\t}else if(document.getElementById(\"job2_title\").innerText == title){\r\n");
      out.write("\t\t\tdocument.getElementById(\"job2_title\").innerHTML = \"\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"job2\").innerHTML = \"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction workTime(jobval,jobName){\r\n");
      out.write("\t\tdocument.getElementById(jobName).value=jobval;\r\n");
      out.write("\t}\r\n");
      out.write("\t//下一步\r\n");
      out.write("\tfunction goSubmit(){\r\n");
      out.write("\t\tvar jobs = \"\";\r\n");
      out.write("\t\t$(\".checked\").each(function () {\r\n");
      out.write("\t\t\tif(jobs != \"\"){\r\n");
      out.write("\t\t\t\tjobs = jobs + \",\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tjobs = jobs + this.id\r\n");
      out.write("        });\r\n");
      out.write("\t\tdocument.getElementById(\"jobs\").value=jobs;\r\n");
      out.write("\t\tif(!checkValue()){\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar url = \"user/saveResumeAddInformation1.do\";\r\n");
      out.write("\t\tvar formId = \"userInformationForm\";\r\n");
      out.write("\t\tvar data = ajaxSumbit(url, formId);\r\n");
      out.write("\t\tif(data == \"success\"){\r\n");
      out.write("\t\t\ttop.location.href='resume_add_planjob.jsp';\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\talert(\"保存出错！\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction booleanInfot(url){\r\n");
      out.write("\t\tif(dataName == '1'){\r\n");
      out.write("\t\t\ttop.location.href=url;\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\talert(\"请先填写好您的简历信息！\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkValue(){\r\n");
      out.write("\t\tif(!checkInput('offerUserName',\"姓名\",\"30\",false)) return false;\r\n");
      out.write("\t\tif(!checkInput('offerUserSex',\"性别\",\"30\",false)) return false;\r\n");
      out.write("\t\tif(!checkInput('offerUserWorktime',\"工作年限\",\"30\",false)) return false;\r\n");
      out.write("\t\tif(!checkInput('jobs',\"工作岗位\",\"30\",false)) return false;\r\n");
      out.write("\t\tif(!checkInput('offerUserDescription',\"工作技能\",\"30\",true)) return false;\r\n");
      out.write("\t\tif(!checkInput('offerUserZhihu',\"知乎ID\",\"30\",true)) return false;\r\n");
      out.write("\t\tif(!checkInput('offerUserBlog',\"blog地址\",\"30\",true)) return false;\r\n");
      out.write("\t\tif(!checkInput('offerUserGithub',\"github账号\",\"30\",true)) return false;\r\n");
      out.write("\t\tif(!checkInput('offerUserPersonWeb',\"个人网站\",\"30\",true)) return false;\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body bgcolor=\"#F4F9F9\" onload=\"init()\">\r\n");
      out.write("\t<form id=\"userInformationForm\" style=\"overflow-y:auto;\">\r\n");
      out.write("\t<div style=\"width:100%;height:55px;background: #000;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;\">\r\n");
      out.write("\t\t<table style=\"width:100%;white-space: nowrap;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"270px\" style=\"padding-left:150px;\"><img src=\"../img/U-Offerlogo.png\"></td>\r\n");
      out.write("\t\t\t\t<td class=\"textC\">\r\n");
      out.write("\t\t\t\t    <button type=\"button\" style=\"height:55px !important;width:100px !important;color:#FFF;background-color:#000;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu3\" data-toggle=\"dropdown\" class=\"btn dropdown-toggle\" id=\"dropdownMenu3\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\" onmouseout=\"changeColor2(this)\" onclick=\"booleanInfot('interview.jsp')\">\r\n");
      out.write("\t\t\t\t    \t<font size=\"3\">面试邀请</font>\r\n");
      out.write("\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t    <button type=\"button\" style=\"height:55px !important;width:100px !important;color:#FFF;background-color:#000;\"class=\"btn dropdown-toggle\" id=\"dropdownMenu2\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\" onmouseout=\"changeColor2(this)\" onclick=\"booleanInfot('resume_edit.jsp')\">\r\n");
      out.write("\t\t\t\t    \t<font size=\"3\">我的简历</font>\r\n");
      out.write("\t\t\t\t    </button>\r\n");
      out.write("\t\t\t    </td>\r\n");
      out.write("\t\t\t    <td class=\"textC\" width=\"270px\">\r\n");
      out.write("\t\t\t\t    <button type=\"button\" style=\"height:55px !important;width:100px !important;color:#FFF;background-color:#000;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu1\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\" onmouseout=\"changeColor2(this)\" onclick=\"booleanInfot('personal_settings.jsp')\">个人设置\r\n");
      out.write("\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t    <button type=\"button\" style=\"height:55px !important;width:100px !important;color:#FFF;background-color:#000;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu4\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\" onmouseout=\"changeColor2(this)\" onclick=\"javascript:top.location.href='login.jsp'\">退出\r\n");
      out.write("\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<div style=\"width:600px;\">\r\n");
      out.write("\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"textC\" style=\"padding-left:10px;padding-top:10px;padding-bottom:10px;width:25%;\">\r\n");
      out.write("\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><div class=\"circleA\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><font color=\"#00B38A\">&nbsp;&nbsp;基本信息 </font></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"textC\" style=\"padding-left:10px;padding-top:10px;padding-bottom:10px;width:25%;\">\r\n");
      out.write("\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><div class=\"circleB\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><font color=\"#999999\">&nbsp;&nbsp;期望工作 </font></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"textC\" style=\"padding-left:10px;padding-top:10px;padding-bottom:10px;width:25%;\">\r\n");
      out.write("\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><div class=\"circleB\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><font color=\"#999999\">&nbsp;&nbsp;个人经历 </font></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"textC\" style=\"padding-left:10px;padding-top:10px;padding-bottom:10px;width:25%;\">\r\n");
      out.write("\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><div class=\"circleB\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><font color=\"#999999\">&nbsp;&nbsp;调查问卷 </font></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"background: #FFFFFF; width: 600px;padding-top:20px;padding-bottom:20px;\">\r\n");
      out.write("\t\t\t<center><font size=\"3\" color=\"#666666\">Hi,欢迎您的到来！让我们来认识一下吧。</font></center>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"height: 2px; width: 600px; background-color: #999999;\"></div>\r\n");
      out.write("\t\t<div style=\"background: #FFFFFF; width: 600px;\">\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<table\r\n");
      out.write("\t\t\t\tstyle=\"border-collapse: separate; border-spacing: 10px; width: 100%; padding-left:30px;\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th class=\"textL\" colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"1\" color=\"#4F4F4F\">姓名*</font>\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"offerUserName\" id=\"offerUserName\" class=\"form-control\" style=\"width: 75% !important\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th class=\"textL\" colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"1\" color=\"#4F4F4F\">性别*</font>\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"offerUserSex\" id=\"offerUserSex\"/>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" onclick=\"setSexValue(1)\" data-toggle=\"button\" id=\"sex1\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: #00B38A !important;background-color: #FFF !important; border-color: #00B38A !important; width: 100px;\">\r\n");
      out.write("\t\t\t\t\t\t\t男</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" onclick=\"setSexValue(0)\" data-toggle=\"button\" id=\"sex2\"\r\n");
      out.write("\t\t\t\t\t\t\tstyle=\"color: #00B38A !important;background-color: #FFF !important; border-color: #00B38A !important; width: 100px;\">\r\n");
      out.write("\t\t\t\t\t\t\t女</button>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th class=\"textL\" colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"1\" color=\"#4F4F4F\">工作年限*</font>\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"textL\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"input-group\" style=\"margin-left:-10px !important;width: 90% !important\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"dropdown\" style=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"offerUserWorktime\" id=\"offerUserWorktime\" readOnly=\"readOnly\" class=\"form-control\" style=\"width: 80% !important\">\r\n");
      out.write("\t\t\t\t\t\t\t    <button type=\"button\" style=\"height:34px !important;background-color:#E6E6E6;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu1\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t        <span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t\t\t\t    <ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dropdownMenu1\" style=\"width: 90% !important\" id=\"offerUserWorktime\">\r\n");
      out.write("\t\t\t\t\t\t\t        <li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t\t\t            <a role=\"menuitem\" tabindex=\"-1\" href=\"#\" onclick='workTimeValue(\"1年\")'><font color=\"#000\">1年</font></a>\r\n");
      out.write("\t\t\t\t\t\t\t            <a role=\"menuitem\" tabindex=\"-1\" href=\"#\" onclick='workTimeValue(\"一至三年\")'><font color=\"#000\">一至三年</font></a>\r\n");
      out.write("\t\t\t\t\t\t\t            <a role=\"menuitem\" tabindex=\"-1\" href=\"#\" onclick='workTimeValue(\"三至五年\")'><font color=\"#000\">三至五年</font></a>\r\n");
      out.write("\t\t\t\t\t\t\t            <a role=\"menuitem\" tabindex=\"-1\" href=\"#\" onclick='workTimeValue(\"五年以上\")'><font color=\"#000\">五年以上</font></a>\r\n");
      out.write("\t\t\t\t\t\t\t        </li>\r\n");
      out.write("\t\t\t\t\t\t\t    </ul>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th class=\"textL\" colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"1\" color=\"#4F4F4F\">您期望的工作岗位是？（最多选择两项）*</font>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" id=\"jobs\" name=\"jobs\"/>\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" id=\"checkJob\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr id=\"job1_title\"/>\r\n");
      out.write("\t\t\t\t<tr id=\"job1\"/>\r\n");
      out.write("\t\t\t\t<tr id=\"job2_title\"/>\r\n");
      out.write("\t\t\t\t<tr id=\"job2\"/>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th class=\"textL\" colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"1\" color=\"#4F4F4F\">您擅长哪些工作技能？（请用逗号分隔你的技能特长）</font>\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"offerUserDescription\" id=\"offerUserDescription\" class=\"form-control\" style=\"width: 75% !important\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr height=\"10px\"/>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"height: 2px; width: 600px; background-color: #999999;\"></div>\r\n");
      out.write("\t\t<div style=\"width: 600px; background-color: #FFF;\">\r\n");
      out.write("\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t<tr height=\"40px\">\r\n");
      out.write("\t\t\t\t\t<td style=\"padding-left:50px;font-size:1px;\" colspan=\"4\"><b>关联你的社交网络</b></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr height=\"60px\">\r\n");
      out.write("\t\t\t\t\t<td width=\"75px\" class=\"textR\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"../img/zhihu.png\" width=\"35px\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"215px\" class=\"textL\" style=\"padding-left:10px;\">\r\n");
      out.write("\t\t\t            <input type=\"text\" class=\"form-control\" name=\"offerUserZhihu\" id=\"offerUserZhihu\" placeholder=\"请输入你的知乎ID\" style=\"width: 180px !important\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"75px\" class=\"textR\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"../img/github.png\" width=\"35px\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"235px\" class=\"textL\" style=\"padding-left:10px;\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"offerUserGithub\" id=\"offerUserGithub\" placeholder=\"请输入你的github账号\" style=\"width: 180px !important\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr height=\"60px\">\r\n");
      out.write("\t\t\t\t\t<td width=\"100px\" class=\"textR\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"../img/blog.png\" width=\"35px\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"200px\" class=\"textL\" style=\"padding-left:10px;\">\r\n");
      out.write("\t\t\t            <input type=\"text\" class=\"form-control\" name=\"offerUserBlog\" id=\"offerUserBlog\" placeholder=\"请输入你的blog地址\" style=\"width: 180px !important\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"100px\" class=\"textR\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"../img/personlink.png\" width=\"35px\"/>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"200px\" class=\"textL\" style=\"padding-left:10px;\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"offerUserPersonWeb\" id=\"offerUserPersonWeb\" placeholder=\"请输入你的个人网站\" style=\"width: 180px !important\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<br/>\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-primary\" onclick=\"goSubmit()\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\tstyle=\"color: #FFF !important;background-color: #00B38A !important; border-color: #00B38A !important; width: 200px;\">\r\n");
      out.write("\t\t\t\t下一步</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</center>\r\n");
      out.write("\t<br/>\r\n");
      out.write("\t<br/>\r\n");
      out.write("\t</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
