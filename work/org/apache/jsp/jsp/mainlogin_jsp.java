/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2017-03-31 00:49:45 UTC
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

public final class mainlogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("</head>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction changeColor1(der){\r\n");
      out.write("\t\tder.style.background=\"#CCCCCC\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction changeColor2(der){\r\n");
      out.write("\t\tder.style.background=\"#32373C\";\r\n");
      out.write("\t}\r\n");
      out.write("\tvar code;\r\n");
      out.write("\tfunction getTran(ret) {\r\n");
      out.write("\t\tvar trans1 = document.getElementById('transparent1');\r\n");
      out.write("\t\tvar trans2 = document.getElementById('transparent2');\r\n");
      out.write("\t\tif (ret == '1') {\r\n");
      out.write("\t\t\ttrans1.setAttribute(\"class\", \"triangle-up\");\r\n");
      out.write("\t\t\ttrans2.setAttribute(\"class\", \"\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"type\").value=\"1\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (ret == '2') {\r\n");
      out.write("\t\t\ttrans2.setAttribute(\"class\", \"triangle-up\");\r\n");
      out.write("\t\t\ttrans1.setAttribute(\"class\", \"\");\r\n");
      out.write("\t\t\tdocument.getElementById(\"type\").value=\"2\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction changeRemeber() {\r\n");
      out.write("\t\tvar remeberId = document.getElementById('remeberId').value;\r\n");
      out.write("\t\tif (remeberId == '1') {\r\n");
      out.write("\t\t\tdocument.getElementById('remeber').src = \"../img/cha.png\";\r\n");
      out.write("\t\t\tdocument.getElementById('remeber').style.width = \"17px\";\r\n");
      out.write("\t\t\tdocument.getElementById('remeber').style.height = \"17px\";\r\n");
      out.write("\t\t\tdocument.getElementById('remeberId').value = '2';\r\n");
      out.write("\t\t} else if (remeberId == '2') {\r\n");
      out.write("\t\t\tdocument.getElementById('remeber').src = \"../img/gou.png\";\r\n");
      out.write("\t\t\tdocument.getElementById('remeber').style.width = \"20px\";\r\n");
      out.write("\t\t\tdocument.getElementById('remeber').style.height = \"20px\";\r\n");
      out.write("\t\t\tdocument.getElementById('remeberId').value = '1';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction init() {\r\n");
      out.write("\t\tvar url = \"logout/user.do\";\r\n");
      out.write("\t\tvar data = ajaxSumbitNoform(url, \"1\");\r\n");
      out.write("\t\tgetTran('1');\r\n");
      out.write("\t\tvar regit = document.getElementById('regit');\r\n");
      out.write("\t\tregit.focus();\r\n");
      out.write("\t\tvar b = document.getElementById('button1');\r\n");
      out.write("\t\tb.focus();\r\n");
      out.write("\t\tcode = createValidateCode('vCode2');\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction validateCode() {\r\n");
      out.write("\t\tif(!checkValue()){\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar ispass = true;//code.verify(document.getElementById(\"inputCode\").value);\r\n");
      out.write("\t\tif (ispass) {\r\n");
      out.write("\t\t\tvar url = \"login/user1.do\";\r\n");
      out.write("\t\t\tvar formId = \"loginForm\";\r\n");
      out.write("\t\t\tvar data = ajaxSumbit(url, formId);\r\n");
      out.write("\t\t\tif(data == 'loginError'){\r\n");
      out.write("        \t\talert(\"用户名或密码出错!\");\r\n");
      out.write("        \t\tcode.update();\r\n");
      out.write("        \t\treturn;\r\n");
      out.write("        \t}\r\n");
      out.write("\t\t\tif(data == '0'){\r\n");
      out.write("\t\t\t\talert(\"该账号已停用,请联系客服\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(data == '1'){\r\n");
      out.write("\t\t\t\talert(\"请确认你的邮箱\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(document.getElementById(\"type\").value == '1'){\r\n");
      out.write("\t\t\t\tif (data.status == '0') {//停用\r\n");
      out.write("\t\t\t\t\ttop.location.href='check_msg.jsp';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse if(data.status == '1') {//未提交\r\n");
      out.write("\t\t\t\t\ttop.location.href='resume_add_information.jsp';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse if(data.status == '2') {//待审批\r\n");
      out.write("\t\t\t\t\ttop.location.href='examine_user.jsp';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse if(data.status == '3') {//审批不通过\r\n");
      out.write("\t\t\t\t\ttop.location.href='examine_user_fail.jsp';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse if(data.status == '4') {//审批通过\r\n");
      out.write("\t\t\t\t\ttop.location.href='resume_edit.jsp';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(document.getElementById(\"type\").value == '2'){\r\n");
      out.write("\t\t\t\tif (data.status == '0') {//停用\r\n");
      out.write("\t\t\t\t\ttop.location.href='check_msg.jsp';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse if(data.status == '1'){//未提交\r\n");
      out.write("\t\t\t\t\ttop.location.href='firm_resume_add.jsp';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse if(data.status == '2'){//待审批\r\n");
      out.write("\t\t\t\t\ttop.location.href='examine_firm.jsp';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse if(data.status == '3'){//审批不通过\r\n");
      out.write("\t\t\t\t\ttop.location.href='examine_firm_fail.jsp';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse if(data.status == '4'){//审批通过\r\n");
      out.write("\t\t\t\t\tif (data.qytgdy == 'true') {\r\n");
      out.write("\t\t\t\t\t\ttop.location.href='finduser.jsp';\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse {\r\n");
      out.write("\t\t\t\t\t\ttop.location.href='examine_firm_success.jsp';\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\talert(\"验证码输入有误！\");\r\n");
      out.write("\t\t\tcode.update();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction checkValue(){\r\n");
      out.write("\t\tif(!checkInput('name',\"邮箱/手机号码\",\"30\",false)) return false;\r\n");
      out.write("\t\tif(!checkInput('password',\"密码\",\"30\",false)) return false;\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction forgetPSD(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body bgcolor=\"#F5F8F9\" onload=\"init()\">\r\n");
      out.write("\t<form id=\"loginForm\">\r\n");
      out.write("\t<div style=\"width:100%;height:60px;background: #32373C;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;\">\r\n");
      out.write("\t\t<table style=\"width:100%;white-space: nowrap;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"19%\" style=\"padding-left:14%;\"><img src=\"../img/U-Offerlogo.png\" width=\"109px\" height=\"26px\"></td>\r\n");
      out.write("\t\t\t\t<td width=\"5%\"/>\r\n");
      out.write("\t\t\t\t<td class=\"textC\">\r\n");
      out.write("\t\t\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" style=\"font-size:14px;height:60px !important;color:#F5F8F9;background-color:#32373C;\"\r\n");
      out.write("\t\t\t\t\t\t class=\"btn dropdown-toggle\" id=\"dropdownMenu1\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\"\r\n");
      out.write("\t\t\t\t\t\t onmouseout=\"changeColor2(this)\">看机会\r\n");
      out.write("\t\t\t\t\t        <span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t\t    <ul class=\"dropdown-menu pull-right\" role=\"menu\" aria-labelledby=\"dropdownMenu1\" style=\"\">\r\n");
      out.write("\t\t\t\t\t        <li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t            <a role=\"menuitem\" tabindex=\"-1\" href=\"#\"><font color=\"#000\">Java1</font></a>\r\n");
      out.write("\t\t\t\t\t        </li>\r\n");
      out.write("\t\t\t\t\t    </ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"btn-group\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" style=\"font-size:14px;height:60px !important;color:#F5F8F9;background-color:#32373C;\"\r\n");
      out.write("\t\t\t\t\t\t class=\"btn dropdown-toggle\" id=\"dropdownMenu2\" data-toggle=\"dropdown\" onmouseover=\"changeColor1(this)\"\r\n");
      out.write("\t\t\t\t\t\t onmouseout=\"changeColor2(this)\">招人才\r\n");
      out.write("\t\t\t\t\t        <span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t\t    <ul class=\"dropdown-menu pull-right\" role=\"menu\" aria-labelledby=\"dropdownMenu2\" style=\"\">\r\n");
      out.write("\t\t\t\t\t        <li role=\"presentation\">\r\n");
      out.write("\t\t\t\t\t            <a role=\"menuitem\" tabindex=\"-1\" href=\"#\"><font color=\"#000\">Java2</font></a>\r\n");
      out.write("\t\t\t\t\t        </li>\r\n");
      out.write("\t\t\t\t\t    </ul>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" style=\"font-size:14px;height:60px !important;color:#F5F8F9;background-color:#32373C;padding:0px 20px;\"\r\n");
      out.write("\t\t\t\t\t class=\"btn dropdown-toggle\" onmouseover=\"changeColor1(this)\"\r\n");
      out.write("\t\t\t\t\t onmouseout=\"changeColor2(this)\" onclick=\"javascript:top.location.href='check_email.jsp'\">推荐\r\n");
      out.write("\t\t\t\t    </button>\r\n");
      out.write("\t\t\t    </td>\r\n");
      out.write("\t\t\t    <td style=\"width:24%;padding-right:13%\">\r\n");
      out.write("\t\t\t\t    <button type=\"button\" class=\"btn btn-default\" style=\"width:101px;color:#00B38A;background:#F5F8F9;\" onclick=\"javascript:top.location.href='login.jsp'\">登录</button>\r\n");
      out.write("\t\t\t\t    <button id=\"regit\" type=\"button\" class=\"btn btn-default\" style=\"margin-left:9px;width:101px;color:#FFFFFF;background:#00B38A;\" onclick=\"javascript:top.location.href='register.jsp'\">注册</button>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"width:100%;height:127px;\"></div>\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\t<div style=\"background: #FFFFFF; min-width: 600px;width:42%;\">\r\n");
      out.write("\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"25%\" />\r\n");
      out.write("\t\t\t\t\t<td width=\"25%\" />\r\n");
      out.write("\t\t\t\t\t<td width=\"25%\" />\r\n");
      out.write("\t\t\t\t\t<td width=\"25%\" />\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td />\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" class=\"textC\">\r\n");
      out.write("\t\t\t\t\t\t<h3>登 录</h3>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td />\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td />\r\n");
      out.write("\t\t\t\t\t<td colspan=\"2\" class=\"textC\">\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"type\" id=\"type\"/>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"btn-group btn-group-lg\">\r\n");
      out.write("\t\t\t\t\t\t\t<button id=\"button1\" type=\"button\" class=\"btn btn-default\"\r\n");
      out.write("\t\t\t\t\t\t\t\tonclick=\"getTran('1')\">我是候选人</button>\r\n");
      out.write("\t\t\t\t\t\t\t<button id=\"button2\" type=\"button\" class=\"btn btn-default\"\r\n");
      out.write("\t\t\t\t\t\t\t\tonclick=\"getTran('2')\">我是HR/BOSS</button>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td />\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th />\r\n");
      out.write("\t\t\t\t\t<td class=\"textC\"><center>\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"transparent1\"></div>\r\n");
      out.write("\t\t\t\t\t\t</center></td>\r\n");
      out.write("\t\t\t\t\t<td class=\"textC\"><center>\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"transparent2\"></div>\r\n");
      out.write("\t\t\t\t\t\t</center></td>\r\n");
      out.write("\t\t\t\t\t<th />\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"height: 2px; min-width: 600px;width:42%; background-color: #00B38A;\"></div>\r\n");
      out.write("\t\t<div style=\"background: #FFFFFF; min-width: 600px;width:42%;\">\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<table\r\n");
      out.write("\t\t\t\tstyle=\"border-collapse: separate; border-spacing: 10px; width: 100%;\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th class=\"textR\" width=\"25%\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"1\" color=\"#666666\">邮箱/手机号码：</font>\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" id=\"name\" name=\"name\" class=\"form-control\" style=\"width: 75% !important\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th class=\"textR\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"1\" color=\"#666666\">密码：</font>\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" style=\"width: 75% !important\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th class=\"textR\">\r\n");
      out.write("\t\t\t\t\t\t<font size=\"1\" color=\"#666666\">图形验证码：</font>\r\n");
      out.write("\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-lg-6\" style=\"width:100%;\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"input-group\" style=\"width: 100% !important; margin-left: -22px !important;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" id=\"inputCode\" class=\"form-control\" style=\"width: 60% !important\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"vCode2\" style=\"width: 100px; height: 34px; border: 1px solid #ccc; display: inline-block;\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t<center>\r\n");
      out.write("\t\t\t\t<table width=\"250px\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"textL\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"remeberId\" value=\"1\" />\r\n");
      out.write("\t\t\t\t\t\t\t<img id=\"remeber\" src=\"../img/gou.png\" width=\"20px\" height=\"20px\" onclick=\"changeRemeber()\" />\r\n");
      out.write("\t\t\t\t\t\t\t<font size=\"1\" color=\"#999999\">记住密码</font>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"textR\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"#\" onclick=\"forgetPSD()\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<font size=\"1\" color=\"#00B38A\">忘记密码？</font>\r\n");
      out.write("\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr height=\"10px\" />\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" onclick=\"validateCode()\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"background-color: #00B38A !important; border-color: #00B38A !important; width: 100%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t确认提交</button>\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</center>\r\n");
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
