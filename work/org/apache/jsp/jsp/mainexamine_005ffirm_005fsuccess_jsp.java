/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2017-03-31 06:55:22 UTC
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

public final class mainexamine_005ffirm_005fsuccess_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/common/header.jsp", Long.valueOf(1490919067445L));
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
      out.write("<link rel=\"shortcut icon\" href=\"../img/title.ico\" type=\"image/x-icon\"/>\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<script src=\"../js/jquery-3.1.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../js/ajaxSubmit.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"../js/ajaxfileupload.js\" type=\"text/javascript\"></script>\r\n");
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
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<title></title>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\r\n");
      out.write("<style>\r\n");
      out.write(".smailfont{\r\n");
      out.write("\tfont-size:1px;\r\n");
      out.write("}\r\n");
      out.write(".fontcol{\r\n");
      out.write("\tpadding-left: 20px;\r\n");
      out.write("\tcolor:#666666;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction changeColor1(der){\r\n");
      out.write("\t\tder.style.background=\"#999999\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction changeColor2(der){\r\n");
      out.write("\t\tder.style.background=\"#000\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addCheckJob(items){\r\n");
      out.write("\t\tvar jobs = \"<table width='100%'><tr>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t+\"</tr>\";\r\n");
      out.write("\t\tvar j = 1;\r\n");
      out.write("\t\tfor(var i in items){\r\n");
      out.write("\t\t\tif(j == 1){\r\n");
      out.write("\t\t\t\tjobs = jobs + \"<tr>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tjobs = jobs + \"<td class='textR' style='padding-top:10px;padding-bottom:10px;width:5%;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"<div class='icheckbox_square-green hover' onclick='jobId(this)' id='\"+items[i].id+\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<input type='hidden' name='CheckJob' value='CheckJob'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<input tabindex='2' type='checkbox' style='opacity:0;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"</div>\"\r\n");
      out.write("\t\t\t\t\t\t+\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t+\"<td class='textL' width='20%'><font size='2'>\"+items[i].value+\"</font></td>\";\r\n");
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
      out.write("\tfunction addCheckJob1(items){\r\n");
      out.write("\t\tvar jobs = \"<table width='100%'><tr>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t+\"</tr>\";\r\n");
      out.write("\t\tvar j = 1;\r\n");
      out.write("\t\tfor(var i in items){\r\n");
      out.write("\t\t\tif(j == 1){\r\n");
      out.write("\t\t\t\tjobs = jobs + \"<tr>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tjobs = jobs + \"<td class='textR' style='padding-top:10px;padding-bottom:10px;width:5%;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"<div class='icheckbox_square-green hover' onclick='jobId(this)' id='\"+items[i].id+\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<input type='hidden' name='CheckJob1' value='CheckJob1'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<input tabindex='2' type='checkbox' style='opacity:0;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"</div>\"\r\n");
      out.write("\t\t\t\t\t\t+\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t+\"<td class='textL' width='20%'><font size='2'>\"+items[i].value+\"</font></td>\";\r\n");
      out.write("\t\t\tif(j == 4){\r\n");
      out.write("\t\t\t\tjobs = jobs + \"</tr>\";\r\n");
      out.write("\t\t\t\tj = 1;\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tj = j+1;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tjobs = jobs + \"</table>\";\r\n");
      out.write("\t\tdocument.getElementById('checkJob1').innerHTML=jobs;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addcity(items){\r\n");
      out.write("\t\tvar jobs = \"<table width='100%'><tr>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t+\"</tr>\";\r\n");
      out.write("\t\tvar j = 1;\r\n");
      out.write("\t\tfor(var i in items){\r\n");
      out.write("\t\t\tif(j == 1){\r\n");
      out.write("\t\t\t\tjobs = jobs + \"<tr>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tjobs = jobs + \"<td class='textR' style='padding-top:10px;padding-bottom:10px;width:5%;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"<div class='icheckbox_square-green hover' onclick='jobId(this)' id='\"+items[i].id+\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<input type='hidden' name='city' value='city'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<input tabindex='2' type='checkbox' style='opacity:0;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"</div>\"\r\n");
      out.write("\t\t\t\t\t\t+\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t+\"<td class='textL' width='20%'><font size='2'>\"+items[i].cityName+\"</font></td>\";\r\n");
      out.write("\t\t\tif(j == 4){\r\n");
      out.write("\t\t\t\tjobs = jobs + \"</tr>\";\r\n");
      out.write("\t\t\t\tj = 1;\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tj = j+1;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tjobs = jobs + \"</table>\";\r\n");
      out.write("\t\tdocument.getElementById('citys').innerHTML=jobs;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addworktime(items){\r\n");
      out.write("\t\tvar jobs = \"<table width='100%'><tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"</tr>\";\r\n");
      out.write("\t\tvar j = 1;\r\n");
      out.write("\t\tfor(var i in items){\r\n");
      out.write("\t\t\tif(j == 1){\r\n");
      out.write("\t\t\t\tjobs = jobs + \"<tr>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tjobs = jobs + \"<td class='textR' style='padding-top:10px;padding-bottom:10px;;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"<div class='icheckbox_square-green hover' onclick='jobId(this)' id='\"+items[i].value+\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<input type='hidden' name='worktime' value='worktime'/>\"\r\n");
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
      out.write("\t\tdocument.getElementById('worktime').innerHTML=jobs;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction jobId(obj){\r\n");
      out.write("\t\tif(obj.getAttribute('class') == \"icheckbox_square-green checked\"){\r\n");
      out.write("\t\t\tobj.setAttribute(\"class\",\"icheckbox_square-green hover\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(obj.getAttribute('class') == \"icheckbox_square-green hover\"){\r\n");
      out.write("\t\t\tobj.setAttribute(\"class\",\"icheckbox_square-green checked\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction savefirmSelect(){\r\n");
      out.write("\t\tvar CheckJobId = \"\";\r\n");
      out.write("\t\tvar CheckJobId1 = \"\";\r\n");
      out.write("\t\tvar cityId = \"\";\r\n");
      out.write("\t\tvar worktimeId = \"\";\r\n");
      out.write("\t\t$(\".checked\").each(function () {\r\n");
      out.write("\t\t\tvar id = this.getElementsByTagName(\"input\")[0].value;\r\n");
      out.write("\t\t\tif(id==\"worktime\"){\r\n");
      out.write("\t\t\t\tif(worktimeId != \"\"){\r\n");
      out.write("\t\t\t\t\tworktimeId = worktimeId + \",\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tworktimeId = worktimeId + this.id;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(id==\"city\"){\r\n");
      out.write("\t\t\t\tif(cityId != \"\"){\r\n");
      out.write("\t\t\t\t\tcityId = cityId + \",\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tcityId = cityId + this.id;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(id==\"CheckJob1\"){\r\n");
      out.write("\t\t\t\tif(CheckJobId1 != \"\"){\r\n");
      out.write("\t\t\t\t\tCheckJobId1 = CheckJobId1 + \",\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tCheckJobId1 = CheckJobId1 + this.id;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(id==\"CheckJob\"){\r\n");
      out.write("\t\t\t\tif(CheckJobId != \"\"){\r\n");
      out.write("\t\t\t\t\tCheckJobId = CheckJobId + \",\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tCheckJobId = CheckJobId + this.id;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("        });\r\n");
      out.write("\t\tdocument.getElementById(\"cityIds\").value = cityId;\r\n");
      out.write("\t\tdocument.getElementById(\"worktimeIds\").value = worktimeId;\r\n");
      out.write("\t\tdocument.getElementById(\"CheckJobIds\").value = CheckJobId;\r\n");
      out.write("\t\tdocument.getElementById(\"CheckJobId1s\").value = CheckJobId1;\r\n");
      out.write("// \t\tif(!checkValue()){\r\n");
      out.write("// \t\t\treturn;\r\n");
      out.write("// \t\t}\r\n");
      out.write("\t\tvar url = \"user/saveofferSelect.do\";\r\n");
      out.write("\t\tvar formId = \"examinefirmForm\";\r\n");
      out.write("\t\tvar data = ajaxSumbit(url, formId);\r\n");
      out.write("\t\tif(data == \"success\"){\r\n");
      out.write("\t\t\ttop.location.href='finduser.jsp';\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\talert(\"保存出错！\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction initfirmSelect(items){\r\n");
      out.write("\t\tvar CheckJobId = \"\";\r\n");
      out.write("\t\tvar CheckJobId1 = \"\";\r\n");
      out.write("\t\tvar cityId = \"\";\r\n");
      out.write("\t\tvar worktimeId = \"\";\r\n");
      out.write("\t\t$(\".hover\").each(function () {\r\n");
      out.write("\t\t\tvar id = this.getElementsByTagName(\"input\")[0].value;\r\n");
      out.write("\t\t\tif(id==\"worktime\"){\r\n");
      out.write("\t\t\t\tvar strs= new Array();\r\n");
      out.write("\t\t\t\tstrs = items[0].YearId.split(\",\");\r\n");
      out.write("\t\t\t\tfor(var i in strs){\r\n");
      out.write("\t\t\t\t\tif(this.id == strs[i]){\r\n");
      out.write("\t\t\t\t\t\tjobId(this);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(id==\"city\"){\r\n");
      out.write("\t\t\t\tvar strs= new Array();\r\n");
      out.write("\t\t\t\tstrs = items[0].getCityId.split(\",\");\r\n");
      out.write("\t\t\t\tfor(var i in strs){\r\n");
      out.write("\t\t\t\t\tif(this.id == strs[i]){\r\n");
      out.write("\t\t\t\t\t\tjobId(this);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(id==\"CheckJob1\"){\r\n");
      out.write("\t\t\t\tvar strs= new Array();\r\n");
      out.write("\t\t\t\tstrs = items[0].getJobId.split(\",\");\r\n");
      out.write("\t\t\t\tfor(var i in strs){\r\n");
      out.write("\t\t\t\t\tif(this.id == strs[i]){\r\n");
      out.write("\t\t\t\t\t\tjobId(this);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(id==\"CheckJob\"){\r\n");
      out.write("\t\t\t\tvar strs= new Array();\r\n");
      out.write("\t\t\t\tstrs = items[0].getJobId.split(\",\");\r\n");
      out.write("\t\t\t\tfor(var i in strs){\r\n");
      out.write("\t\t\t\t\tif(this.id == strs[i]){\r\n");
      out.write("\t\t\t\t\t\tjobId(this);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("        });\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction init() {\r\n");
      out.write("\t\tvar url = \"user/personalQuestionnaire.do\";\r\n");
      out.write("\t\tvar formId = \"examinefirmForm\";\r\n");
      out.write("\t\tvar data = ajaxSumbit(url, formId);\r\n");
      out.write("\t\tdataName = data.dataName;\r\n");
      out.write("\t\taddCheckJob(data.nowJobList);\r\n");
      out.write("\t\taddCheckJob1(data.changOfferJobs);\r\n");
      out.write("\t\taddcity(data.cityList);\r\n");
      out.write("\t\taddworktime(data.worktimeList);\r\n");
      out.write("\t\tinitfirmSelect(data.offerFirmSelectList);\r\n");
      out.write("\t\tdocument.getElementById('userName').innerText = data.userName;\r\n");
      out.write("\t\tif(data.offerUserName != undefined){\r\n");
      out.write("\t\t\teditCheckJob(data.jobId1,data.jobId2, data.jobvalue1, data.jobvalue2);\r\n");
      out.write("\t\t\tsetSexValue(data.offerUserSex);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(\"#userInformationForm\").populateForm(data);\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body bgcolor=\"#F4F9F9\" onload=\"init()\">\r\n");
      out.write("\t<form id=\"examinefirmForm\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"cityIds\" id=\"cityIds\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"worktimeIds\" id=\"worktimeIds\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"CheckJobIds\" id=\"CheckJobIds\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"CheckJobId1s\" id=\"CheckJobId1s\"/>\r\n");
      out.write("\t<div style=\"width:100%;height:55px;background: #000;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;\">\r\n");
      out.write("\t\t<table style=\"width:100%;white-space: nowrap;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"270px\" style=\"padding-left:150px;\"><img src=\"../img/U-Offerlogo.png\"></td>\r\n");
      out.write("\t\t\t\t<td class=\"textL\" style=\"padding-left:100px;\">\r\n");
      out.write("\t\t\t\t    <button type=\"button\" style=\"height:55px !important;width:100px !important;color:#FFF;background-color:#000;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu3\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\" onmouseout=\"changeColor2(this)\" onclick=\"javascript:top.location.href='finduser.jsp'\">\r\n");
      out.write("\t\t\t\t    \t<font size=\"3\">候选人</font>\r\n");
      out.write("\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t    <button type=\"button\" style=\"height:55px !important;width:100px !important;color:#FFF;background-color:#000;\"class=\"btn dropdown-toggle\" id=\"dropdownMenu2\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\" onmouseout=\"changeColor2(this)\" onclick=\"javascript:top.location.href='user_view.jsp'\">\r\n");
      out.write("\t\t\t\t    \t<font size=\"3\">已发邀请</font>\r\n");
      out.write("\t\t\t\t    </button>\r\n");
      out.write("\t\t\t    </td>\r\n");
      out.write("\t\t\t    <td class=\"textC\" width=\"270px\">\r\n");
      out.write("\t\t\t\t    <div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" style=\"height:55px !important;color:#FFF;background-color:#000;\"\r\n");
      out.write("\t\t\t\t\t\t class=\"btn dropdown-toggle\" id=\"dropdownMenu2\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\"\r\n");
      out.write("\t\t\t\t\t\t onmouseout=\"changeColor2(this)\" ><span id=\"userName\" name=\"userName\"></span>\r\n");
      out.write("\t\t\t\t\t        <span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t\t    <ul class=\"dropdown-menu pull-right\" role=\"menu\" aria-labelledby=\"dropdownMenu2\" style=\"\">\r\n");
      out.write("\t\t\t\t\t        <li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t            <a role=\"menuitem\" tabindex=\"-1\" href=\"#\" onclick=\"javascript:top.location.href='personal_settings_edit.jsp'\"><font color=\"#000\">个人设置</font></a>\r\n");
      out.write("\t\t\t\t\t            <a role=\"menuitem\" tabindex=\"-1\" href=\"#\" onclick=\"javascript:top.location.href='firm_resume_add.jsp'\"><font color=\"#000\">企业信息</font></a>\r\n");
      out.write("\t\t\t\t\t        </li>\r\n");
      out.write("\t\t\t\t\t    </ul>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t    <button type=\"button\" style=\"height:55px !important;width:80px !important;color:#FFF;background-color:#000;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu4\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\" onmouseout=\"changeColor2(this)\" onclick=\"javascript:top.location.href='login.jsp'\">退出\r\n");
      out.write("\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<div style=\"background: #FFFFFF; width: 80%;\">\r\n");
      out.write("\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"textC\" style=\"padding:10px 0px;\"><img src=\"../img/gou.png\" width=\"100px\" height=\"100px\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"textC\" style=\"padding:10px 0px;font-size:17px;\">企业已通过审核</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr height=\"30px\">\r\n");
      out.write("\t\t\t\t\t<td class=\"textC\"><font size=\"1\">花一分钟填写招聘岗位的需求，我们每期都将为你推荐合适的候选人</font></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr height=\"20px\"/>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"height: 2px; width: 80%; background-color: #DDDDDD;\"></div>\r\n");
      out.write("\t\t<div style=\"background: #FFFFFF; width: 80%;\">\r\n");
      out.write("\t\t\t<table\r\n");
      out.write("\t\t\t\tstyle=\"border-collapse: separate; border-spacing: 10px; width: 100%;\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<div style=\"background: #FFFFFF; width: 100%;min-height:300px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<table style=\"border-collapse: separate; border-spacing: 10px; width: 100%; padding-left:30px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>1.招聘岗位的需求</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td style=\"padding-left:20px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<font size=\"1\" color=\"#666666\">技术类岗位（最多选5项）</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td style=\"paddding:0px 20px;\" id=\"checkJob\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td style=\"padding-left:20px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<font size=\"1\" color=\"#666666\">产品类岗位（最多选2项）</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td style=\"paddding:0px 20px;\" id=\"checkJob1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t<div style=\"height:2px;width:100%;background:#CCCCCC;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<table style=\"border-collapse: separate; border-spacing: 10px; width: 100%; padding-left:30px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>2.职位工作地点</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td style=\"paddding:0px 20px;\" id=\"citys\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t<div style=\"height:2px;width:100%;background:#CCCCCC;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<table style=\"border-collapse: separate; border-spacing: 10px; width: 100%; padding-left:30px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<th>3、对候选人工作经验要求</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td style=\"paddding:0px 20px;\" id=\"worktime\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td class=\"textC\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\" onclick=\"savefirmSelect()\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyle=\"background-color: #00B38A; border-color: #00B38A; width: 240px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t确认提交</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr height=\"30px\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</center>\r\n");
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
