/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2017-04-01 02:56:44 UTC
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

public final class mainresume_005fedit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/common/header.jsp", Long.valueOf(1491013664146L));
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
      out.write("\tfunction changeColor1(der){\r\n");
      out.write("\t\tder.style.background=\"#999999\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction changeColor2(der){\r\n");
      out.write("\t\tder.style.background=\"#000\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction init() {\r\n");
      out.write("\t\t var url = \"user/resumeeditPage1.do\";\r\n");
      out.write("\t\tvar data = ajaxSumbitNoform(url, \"123\");\r\n");
      out.write("\t\taddgou(data);\r\n");
      out.write("\t\taddinformation1(data.informationTd1);\r\n");
      out.write("\t\taddinformation2(data.informationTd2);\r\n");
      out.write("\t\taddskillTd(data.skillTd);\r\n");
      out.write("\t\taddworkTd(data.workTd);\r\n");
      out.write("\t\taddeducationTd(data.educationTd);\r\n");
      out.write("\t\tadddescriptionTd(data.descriptionTd);\r\n");
      out.write("\t\taddworksTd(data.worksTd);\r\n");
      out.write("\t\taddprotectTd(data.protectTd); \r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addgou(data){\r\n");
      out.write("\t\tdocument.getElementById(\"integrity\").innerText = data.integrity;\r\n");
      out.write("\t\tif(data.information == '1'){\r\n");
      out.write("\t\t\tdocument.getElementById(\"information\").src = \"../img/gou.png\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(data.skill == '1'){\r\n");
      out.write("\t\t\tdocument.getElementById(\"skill\").src = \"../img/gou.png\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(data.work == '1'){\r\n");
      out.write("\t\t\tdocument.getElementById(\"work\").src = \"../img/gou.png\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(data.education == '1'){\r\n");
      out.write("\t\t\tdocument.getElementById(\"education\").src = \"../img/gou.png\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(data.project == '1'){\r\n");
      out.write("\t\t\tdocument.getElementById(\"project\").src = \"../img/gou.png\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(data.description == '1'){\r\n");
      out.write("\t\t\tdocument.getElementById(\"description\").src = \"../img/gou.png\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(data.works == '1'){\r\n");
      out.write("\t\t\tdocument.getElementById(\"works\").src = \"../img/gou.png\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(data.protect == '1'){\r\n");
      out.write("\t\t\tdocument.getElementById(\"protect\").src = \"../img/gou.png\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//informationTd1\r\n");
      out.write("\tfunction addinformation1(item){\r\n");
      out.write("\t\tvar information = \"\";\r\n");
      out.write("\t\tinformation = information + \"<div style='background: #FFFFFF; width: 750px;padding-top:30px;padding-left:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"<table width='100%'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td rowspan='5' width='160px'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"<img src=\"+ item.userPhoto +\" width='150px' height='150px'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td width='20%' class='textC'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"<a>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"<font size='2' color='#00B38A'><a href='#' onclick='javascript:top.location.href=\\\"resume_edit_type.jsp?1\\\"'>编辑</a></font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</a>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td style='padding-left:30px;'><font size='3' style='font-weight:bold;'>\"+item.userName+\"</font></td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td style='padding-left:30px;'><font size='1'>\" + item.simpleResume + \"</font></td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td style='padding-left:30px;'><font size='1'>邮箱：\"+item.email+\"</font></td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td style='padding-left:30px;'><font size='1'>电话：\"+item.phone+\"</font></td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"<tr height='20px'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"</table>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</div>\";\r\n");
      out.write("\t\tdocument.getElementById(\"informationTd1\").innerHTML = information;\r\n");
      out.write("\t}\r\n");
      out.write("\t//informationTd2\r\n");
      out.write("\tfunction addinformation2(item){\r\n");
      out.write("\t\tvar information = \"\";\r\n");
      out.write("\t\tinformation = information + \"<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"<table width='100%'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"<font size='3' style='font-weight:bold;margin-left:30px;'>关于\"+item.userName+\"</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"<ul>\";\r\n");
      out.write("\t\tfor(var i in item.informationList2){\r\n");
      out.write("\t\t\tinformation = information + \"<li><font size='1' color='#666666'>\"+item.informationList2[i].str+\"</font></li>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tinformation = information + \"</ul>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td width='20%' class='textC' valign='top'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"<font size='2' color='#00B38A'><a href='#' onclick='javascript:top.location.href=\\\"resume_edit_type.jsp?2\\\"'>编辑</a></font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"</table>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</div>\";\r\n");
      out.write("\t\tdocument.getElementById(\"informationTd2\").innerHTML = information;\r\n");
      out.write("\t}\r\n");
      out.write("\t//skillTd\r\n");
      out.write("\tfunction addskillTd(item){\r\n");
      out.write("\t\tvar skill = \"\";\r\n");
      out.write("\t\tskill = skill + \"<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<table width='100%'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<font size='3' style='font-weight:bold;margin-left:30px;'>技能</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<ul>\";\r\n");
      out.write("\t\tfor(var i in item.skillList1){\r\n");
      out.write("\t\t\tskill = skill + \"<li><font size='1' color='#666666'>\"+item.skillList1[i].str+\"</font></li>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tskill = skill + \"</ul>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td width='20%' class='textC' valign='top'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<a href='#' onclick='javascript:top.location.href=\\\"resume_edit_type.jsp?2\\\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"<font size='2' color='#00B38A'>编辑</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</a>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td colspan='2' style='padding-top:20px;'>\";\r\n");
      out.write("\t\tfor(var i in item.skillList2){\r\n");
      out.write("\t\t\tskill = skill + \"<div class='btn-group btn-group-lg' style='margin-left:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+\"<button type='button' class='btn btn-default' style='min-width:100px;height:40px;color:#00B389;background:#FFF;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+\"<font size='2'>\"+ item.skillList2[i].str +\"</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+\"</button>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"</div>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tskill = skill + \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"</table>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<br />\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<br />\"\r\n");
      out.write("\t\t\t\t\t\t+\"</div>\";\r\n");
      out.write("\t\tdocument.getElementById(\"skillTd\").innerHTML = skill; \r\n");
      out.write("\t}\r\n");
      out.write("\t//workTd\r\n");
      out.write("\tfunction addworkTd(item){\r\n");
      out.write("\t\tvar work = \"\";\r\n");
      out.write("\t\twork = work + \"<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<table width='100%'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<font style='font-weight:bold;margin-left:30px;'>工作经历</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<p style='padding:20px;'><font size='2'>\" + item.str + \"</font></p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td width='20%' class='textC' valign='top'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<a href='#' onclick='javascript:top.location.href=\\\"resume_edit_type.jsp?3\\\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"<font size='2' color='#00B38A'>编辑</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</a>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td colspan='2' style='padding-top:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"</table>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<br />\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<br />\"\r\n");
      out.write("\t\t\t\t\t\t+\"</div>\";\r\n");
      out.write("\t\tdocument.getElementById(\"workTd\").innerHTML = work; \r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addeducationTd(item){\r\n");
      out.write("\t\tvar education = \"\";\r\n");
      out.write("\t\teducation = education + \"<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"<table width='100%'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<font size='3' style='font-weight:bold;margin-left:30px;'>教育经历</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"<ul>\";\r\n");
      out.write("\t\tfor(var i in item.educationList){\r\n");
      out.write("\t\t\teducation = education + \"<li><font size='1' color='#666666'>\"+item.educationList[i].str+\"</font></li>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\teducation = education + \"</ul>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"<td width='20%' class='textC' valign='top'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"<a href='#' onclick='javascript:top.location.href=\\\"resume_edit_type.jsp?4\\\"' >\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"<font size='2' color='#00B38A'>编辑</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ \"</a>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"</table>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</div>\";\r\n");
      out.write("\t\tdocument.getElementById(\"educationTd\").innerHTML = education;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction adddescriptionTd(item){\r\n");
      out.write("\t\tvar description = \"\";\r\n");
      out.write("\t\tdescription = description + \"<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<table width='100%'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<font size='3' style='font-weight:bold;margin-left:30px;'>个人描述</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<p style='padding:20px 30px;'><font size='2'>\" + item.str + \"</font></p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td width='20%' class='textC' valign='top'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<a href='#' onclick='javascript:top.location.href=\\\"resume_edit_type.jsp?5\\\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"<font size='2' color='#00B38A'>编辑</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</a>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td colspan='2' style='padding-top:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"</table>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<br />\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<br />\"\r\n");
      out.write("\t\t\t\t\t\t+\"</div>\";\r\n");
      out.write("\t\tdocument.getElementById(\"descriptionTd\").innerHTML = description; \r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addworksTd(item){\r\n");
      out.write("\t\tvar works = \"\";\r\n");
      out.write("\t\tworks = works + \"<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<table width='100%'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<font size='3' style='font-weight:bold;margin-left:30px;'>个人作品</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<p style='padding:20px 30px;'><font size='2'>\" + item.str + \"</font></p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td width='20%' class='textC' valign='top'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<a href='#' onclick='javascript:top.location.href=\\\"resume_edit_type.jsp?6\\\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"<font size='2' color='#00B38A'>编辑</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</a>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td colspan='2' style='padding-top:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"</table>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<br />\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<br />\"\r\n");
      out.write("\t\t\t\t\t\t+\"</div>\";\r\n");
      out.write("\t\tdocument.getElementById(\"worksTd\").innerHTML = works; \r\n");
      out.write("\t}\r\n");
      out.write("\tfunction addprotectTd(item){\r\n");
      out.write("\t\tvar protect = \"\";\r\n");
      out.write("\t\tprotect = protect + \"<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<table width='100%'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<font size='2' style='font-weight:bold;margin-left:30px;'>私聊保护（可以填写您想屏蔽的公司邮箱后缀，让他们无法查看您的简历。）</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<p style='padding:20px 30px;'><font size='2'>\" + item.str + \"</font></p>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td width='20%' class='textC' valign='top'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"<a href='#' onclick='javascript:top.location.href=\\\"resume_edit_type.jsp?7\\\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ \"<font size='2' color='#00B38A'>编辑</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+ \"</a>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<td colspan='2' style='padding-top:20px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t+ \"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"</table>\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<br />\"\r\n");
      out.write("\t\t\t\t\t\t+ \"<br />\"\r\n");
      out.write("\t\t\t\t\t\t+\"</div>\";\r\n");
      out.write("\t\tdocument.getElementById(\"protectTd\").innerHTML = protect; \r\n");
      out.write("\t}\r\n");
      out.write("\tfunction openWindow(name){\r\n");
      out.write("\t\tdocument.getElementById(\"editbutton\").click();\r\n");
      out.write("\t\tvar content = \"\";\r\n");
      out.write("\t\tif(name == \"description\"){\r\n");
      out.write("\t\t\tdocument.getElementById(\"iframeTitle\").innerText = \"个人描述\";\r\n");
      out.write("\t\t\tcontent = \"<textarea id='editcontent' name='editcontent' rows='8' style='width:99%;'>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(name == \"works\"){\r\n");
      out.write("\t\t\tdocument.getElementById(\"iframeTitle\").innerText = \"个人作品\";\r\n");
      out.write("\t\t\tcontent = \"<textarea id='editcontent' name='editcontent' rows='8' style='width:99%;'>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(name == \"protect\"){\r\n");
      out.write("\t\t\tdocument.getElementById(\"iframeTitle\").innerText = \"隐私保护\";\r\n");
      out.write("\t\t\tcontent = \"<textarea id='editcontent' name='editcontent' rows='8' style='width:99%;'>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(\"iframeId\").innerHTML = content;\r\n");
      out.write("\t\tdocument.getElementById(\"selectId\").value = name;\r\n");
      out.write("\t\tvar url = \"user/editcontentPage1.do\";\r\n");
      out.write("\t\tvar data = ajaxSumbitNoform(url, name);\r\n");
      out.write("\t\tdocument.getElementById(\"editcontent\").value=data.editcontent;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction goSave(){\r\n");
      out.write("\t\tvar url = \"user/saveeditcontent1.do\";\r\n");
      out.write("\t\tvar formId = \"editForm\";\r\n");
      out.write("\t\tvar data = ajaxSumbit(url, formId);\r\n");
      out.write("\t\tif(data == \"success\"){\r\n");
      out.write("\t\t\ttop.location.href='resume_edit.jsp';\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\talert(\"数据出错!\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction dowmloadpdf(){\r\n");
      out.write("\t\ttop.location.href='../user/downloadPdf.do';\r\n");
      out.write("// \t\tvar url = \"user/saveeditcontent1.do\";\r\n");
      out.write("// \t\tvar formId = \"editForm\";\r\n");
      out.write("// \t\tvar data = ajaxSumbit(url, formId);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction booleanInfot(url){\r\n");
      out.write("\t\ttop.location.href=url;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body bgcolor=\"#F4F9F9\" onload=\"init()\">\r\n");
      out.write("\t<div style=\"width:100%;height:55px;background: #000;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;\">\r\n");
      out.write("\t\t<table style=\"width:100%;white-space: nowrap;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"270px\" style=\"padding-left:150px;\"><img id=\"photo\" src=\"../img/U-Offerlogo.png\"></td>\r\n");
      out.write("\t\t\t\t<td class=\"textL\" style=\"padding-left:150px;\">\r\n");
      out.write("\t\t\t\t    <button type=\"button\" style=\"height:55px !important;width:100px !important;color:#FFF;background-color:#000;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu3\" data-toggle=\"dropdown\" class=\"btn dropdown-toggle\" id=\"dropdownMenu3\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\" onmouseout=\"changeColor2(this)\" onclick=\"booleanInfot('interview.jsp')\">\r\n");
      out.write("\t\t\t\t    \t<font size=\"3\">面试邀请</font>\r\n");
      out.write("\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t    <button type=\"button\" style=\"height:55px !important;width:100px !important;color:#FFF;background-color:#000;\"class=\"btn dropdown-toggle\" id=\"dropdownMenu2\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\" onmouseout=\"changeColor2(this)\" onclick=\"booleanInfot('resume_edit.jsp')\">\r\n");
      out.write("\t\t\t\t    \t<font size=\"3\">我的简历</font>\r\n");
      out.write("\t\t\t\t    </button>\r\n");
      out.write("\t\t\t    </td>\r\n");
      out.write("\t\t\t    <td class=\"textC\" width=\"270px\">\r\n");
      out.write("\t\t\t\t    <button type=\"button\" style=\"height:55px !important;width:100px !important;color:#FFF;background-color:#000;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu1\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\" onmouseout=\"changeColor2(this)\" onclick=\"javascript:top.location.href='personal_settings.jsp'\">个人设置\r\n");
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
      out.write("\t<br />\r\n");
      out.write("\t<table width=\"100%\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"10%\" rowspan=\"10\"/>\r\n");
      out.write("\t\t\t<td rowspan=\"10\" valign=\"top\">\r\n");
      out.write("\t\t\t\t<table style=\"background:#FFF\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"100%\" class=\"textC\" style=\"padding-top:35px;padding-left:10px;padding-bottom:10px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<font size=\"3\" color=\"#999999\">简历完成度：</font>\r\n");
      out.write("\t\t\t\t\t\t\t<font size=\"4\" color=\"#00B38A\" id=\"integrity\">40%</font>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td height=\"1\" style=\"background:#CCCCCC;\"></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr><td class=\"textC\" style=\"padding-top:10px;\"><img id=\"information\" style=\"width:40px;padding:0px 10px;\"/><font size=\"2\" color=\"#00B38A\">个人信息</font></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td class=\"textC\" style=\"padding-top:10px;\"><img id=\"skill\" style=\"width:40px;padding:0px 10px;\"/><font size=\"2\" color=\"#00B38A\">个人技能</font></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td class=\"textC\" style=\"padding-top:10px;\"><img id=\"work\" style=\"width:40px;padding:0px 10px;\"/><font size=\"2\" color=\"#00B38A\">工作经历</font></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td class=\"textC\" style=\"padding-top:10px;\"><img id=\"education\" style=\"width:40px;padding:0px 10px;\"/><font size=\"2\" color=\"#00B38A\">教育经历</font></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td class=\"textC\" style=\"padding-top:10px;\"><img id=\"project\" style=\"width:40px;padding:0px 10px;\"/><font size=\"2\" color=\"#00B38A\">项目经历</font></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td class=\"textC\" style=\"padding-top:10px;\"><img id=\"description\" style=\"width:40px;padding:0px 10px;\"/><font size=\"2\" color=\"#00B38A\">个人描述</font></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td class=\"textC\" style=\"padding-top:10px;\"><img id=\"works\" style=\"width:40px;padding:0px 10px;\"/><font size=\"2\" color=\"#00B38A\">个人作品</font></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td class=\"textC\" style=\"padding-top:10px;\"><img id=\"protect\" style=\"width:40px;padding:0px 10px;\"/><font size=\"2\" color=\"#00B38A\">隐私保护</font></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"textC\" style=\"padding:20px 40px;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<button id=\"pdf\" type=\"button\" class=\"btn btn-default\" style=\"width:150px;height:40px;margin-left:20px;color:#FFF;background:#00B389;\" onclick=\"dowmloadpdf()\">\r\n");
      out.write("\t\t\t\t\t\t   \t\t\t<font size=\"1\">预览下载简历</font>\r\n");
      out.write("\t\t\t\t\t\t   \t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr height=\"20px\"/>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td width=\"30px\" rowspan=\"10\"/>\r\n");
      out.write("\t\t\t<td class=\"textL\" id=\"informationTd1\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td id=\"informationTd2\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td id=\"skillTd\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td id=\"workTd\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td id=\"educationTd\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td id=\"descriptionTd\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td id=\"worksTd\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td id=\"protectTd\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<button class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\" style=\"display:none;\" id=\"editbutton\"></button>\r\n");
      out.write("\t<form id=\"editForm\">\r\n");
      out.write("\t\t<center>\r\n");
      out.write("\t\t<div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\" style=\"margin-top:100px;\">\r\n");
      out.write("\t\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t&times;\r\n");
      out.write("\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t<h4 class=\"modal-title\" id=\"myModalLabel\">\r\n");
      out.write("\t\t\t\t\t\t\t<font id=\"iframeTitle\"></font>\r\n");
      out.write("\t\t\t\t\t\t</h4>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-body\" style=\"overflow-y:auto;height:200px;\" id=\"iframeId\">\r\n");
      out.write("\t\t            </div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" id=\"selectId\" name=\"edittype\"/>\r\n");
      out.write("\t\t\t\t\t\t<center><button type=\"button\" class=\"btn btn-default\" style=\"width:50%;color:#FFF;background:#00B389;\" data-dismiss=\"modal\" onclick=\"goSave()\">保存</button></center>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</center>\r\n");
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
