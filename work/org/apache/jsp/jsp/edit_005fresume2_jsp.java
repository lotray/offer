/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2017-03-31 00:50:09 UTC
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

public final class edit_005fresume2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction init(){\r\n");
      out.write("\t\tvar url = \"login/firmtuijian1.do\";\r\n");
      out.write("\t\tvar formId = \"finduserForm\";\r\n");
      out.write("\t\tvar data = ajaxSumbit(url, formId);\r\n");
      out.write("\t\tdocument.getElementById(\"allNum\").innerText=data.allNum;\r\n");
      out.write("\t\taddLi(data.status,\"status\");\r\n");
      out.write("\t\taddLi(data.job,\"job\");\r\n");
      out.write("\t\taddList(data.firmList);\r\n");
      out.write("\t\taddpageNum(data.pageNum,\"u1\");\r\n");
      out.write("\t}\r\n");
      out.write("\t//下拉列表\r\n");
      out.write("\tfunction addLi(items,liId){\r\n");
      out.write("\t\tvar inn = \"\";\r\n");
      out.write("\t\tfor(var i in items){\r\n");
      out.write("\t\t\tinn = inn + \"<li role='presentation'>\"\r\n");
      out.write("\t\t\t\t+\"<a role='menuitem' onclick='selectDownValue(\" + items[i].id +\",\\\"\" + items[i].value +\"\\\",\\\"\"+liId+\"\\\")'><font color='#000'>\" + items[i].value\r\n");
      out.write("\t\t\t\t+\"</font></a></li>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(liId).innerHTML=inn;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction selectDownValue(ke, val, targetInput){\r\n");
      out.write("\t\tvar ti1 = \"firm\" + targetInput;\r\n");
      out.write("\t\tvar ti2 = \"firm\" + targetInput + \"Value\";\r\n");
      out.write("\t\tdocument.getElementById(ti1).value=ke;\r\n");
      out.write("\t\tdocument.getElementById(ti2).value=val;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction test(){\r\n");
      out.write("\t\tparent.document.getElementById(\"main1\").height=0;\r\n");
      out.write("\t\tparent.document.getElementById(\"main1\").height=document.body.scrollHeight;\r\n");
      out.write("\t}\r\n");
      out.write("\t//添加城市\r\n");
      out.write("\tfunction addCity(items){\r\n");
      out.write("\t\tvar citys = \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t\t\t\t+\"<td width='5%'/><td width='20%'/>\"\r\n");
      out.write("\t\t\t\t\t+\"</tr>\";\r\n");
      out.write("\t\tvar j = 1;\r\n");
      out.write("\t\tfor(var i in items){\r\n");
      out.write("\t\t\tif(j == 1){\r\n");
      out.write("\t\t\t\tcitys = citys + \"<tr>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tcitys = citys + \"<td class='textR' style='padding-top:10px;padding-bottom:10px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"<div class='icheckbox_square-green hover' onclick='cityId(this)' id='\"+items[i].id+\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<input type='hidden' value='city'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<input tabindex='2' type='checkbox' style='opacity:0;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"</div>\"\r\n");
      out.write("\t\t\t\t\t\t+\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t+\"<td class='textL'><font size='2'>\"+items[i].value+\"</font></td>\";\r\n");
      out.write("\t\t\tif(j == 4){\r\n");
      out.write("\t\t\t\tcitys = citys + \"</tr>\";\r\n");
      out.write("\t\t\t\tj = 1;\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\tj = j+1;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tcitys = citys + \"\";\r\n");
      out.write("\t\tdocument.getElementById('city').innerHTML=citys;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction cityId(obj){\r\n");
      out.write("\t\tif(obj.getAttribute('class') == \"icheckbox_square-green checked\"){\r\n");
      out.write("\t\t\tobj.setAttribute(\"class\",\"icheckbox_square-green hover\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse if(obj.getAttribute('class') == \"icheckbox_square-green hover\"){\r\n");
      out.write("\t\t\tobj.setAttribute(\"class\",\"icheckbox_square-green checked\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction selected(obj){\r\n");
      out.write("\t\t$(\".circleA\").each(function () {\r\n");
      out.write("\t\t\tif(obj.id.indexOf('j') > -1 && this.id.indexOf('j') > -1){\r\n");
      out.write("\t\t\t\tthis.setAttribute(\"class\",\"circleB\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(obj.id.indexOf('i') > -1 && this.id.indexOf('i') > -1){\r\n");
      out.write("\t\t\t\tthis.setAttribute(\"class\",\"circleB\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tobj.setAttribute(\"class\",\"circleA\");\r\n");
      out.write("\t\tif(obj.id.indexOf('j') > -1){\r\n");
      out.write("\t\t\tdocument.getElementById(\"jobstatus\").value=obj.id;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(obj.id.indexOf('i') > -1){\r\n");
      out.write("\t\t\tdocument.getElementById(\"intime\").value=obj.id;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body bgcolor=\"#FFF\" onload=\"test()\">\r\n");
      out.write("\t<div style=\"width:100%;\">\r\n");
      out.write("\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t<tr height=\"49px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"40px\"/>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t<font style=\"font-size:20px;\" color=\"#4F4F4F\">关于我</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"48px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:14px;\" >您目前的税前收入是？</font><font color=\"#00B38A\">*</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"16px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"121px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" readOnly=\"readOnly\" class=\"form-control\" style=\"width: 85px !important\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <button type=\"button\" style=\"height:34px !important;background-color:#E6E6E6;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu1\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t        <span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dropdownMenu1\" style=\"width: 119px !important;min-width:119px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"3%\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"140px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" style=\"width:140px;\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textC\" width=\"4%\" style=\"min-width:50px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:14px;\">每月</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textC\" width=\"2%\" style=\"min-width:25px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:14px;\">X</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"140px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" style=\"width:140px;\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"50px\" class=\"textC\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:14px;\">月&nbsp;=</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:14px;\">0 万/年</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"48px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:16px;\" >您对下一份工作的最低税前年薪要求是？</font><font color=\"#00B38A\">*</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"13px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"121px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" readOnly=\"readOnly\" class=\"form-control\" style=\"width: 85px !important\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <button type=\"button\" style=\"height:34px !important;background-color:#E6E6E6;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu1\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t        <span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dropdownMenu1\" style=\"width: 119px !important;min-width:119px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"3%\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"140px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" style=\"width:140px;\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textC\" width=\"4%\" style=\"min-width:50px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:14px;\">万/年</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"56px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:16px;\" >您期望在哪个城市工作？（可多选）</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"13px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"cityIds\" id=\"cityIds\"/>\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" id=\"city\">\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"48px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:16px;\" >您目前的求职状态是？</font><font color=\"#00B38A\">*</font>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id=\"jobstatus\" name=\"jobstatus\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"13px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<table style=\"border-collapse:separate; border-spacing:0px 30px;\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><div class=\"circleB\" id=\"j1\" onclick=\"selected(this)\" style=\"cursor:pointer;\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><font color=\"#4F4F4F\" style=\"font-size:14px;\">&nbsp;不着急找工作，先看看机会</font></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><div class=\"circleB\" id=\"j2\" onclick=\"selected(this)\" style=\"cursor:pointer;\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><font color=\"#4F4F4F\" style=\"font-size:14px;\">&nbsp;已经有offer了，想看更好的</font></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><div class=\"circleB\" id=\"j3\" onclick=\"selected(this)\" style=\"cursor:pointer;\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><font color=\"#4F4F4F\" style=\"font-size:14px;\">&nbsp;正在找工作，还没有offer</font></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td><div class=\"circleB\" id=\"j4\" onclick=\"selected(this)\" style=\"cursor:pointer;\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><font color=\"#4F4F4F\" style=\"font-size:14px;\">&nbsp;暂时不考虑换工作</font></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"48px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:16px;\" >如果找到合适的工作，您预计多久可以入职？</font><font color=\"#00B38A\">*</font>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" id=\"intime\" name=\"intime\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"13px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t<tr height=\"30px\"/>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textR\" width=\"5%\"><div class=\"circleB\" id=\"i1\" onclick=\"selected(this)\" style=\"cursor:pointer;\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textL\" width=\"45%\"><font color=\"#4F4F4F\" style=\"font-size:14px;\">&nbsp;目前是离职状态，随时可以入职</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textR\" width=\"5%\"><div class=\"circleB\" id=\"i2\" onclick=\"selected(this)\" style=\"cursor:pointer;\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textL\" width=\"45%\"><font color=\"#4F4F4F\" style=\"font-size:14px;\">&nbsp;一周</font></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr height=\"44px\"/>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textR\"><div class=\"circleB\" id=\"i3\" onclick=\"selected(this)\" style=\"cursor:pointer;\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textL\"><font color=\"#4F4F4F\" style=\"font-size:14px;\">&nbsp;一个月</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textR\"><div class=\"circleB\" id=\"i4\" onclick=\"selected(this)\" style=\"cursor:pointer;\"></div></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textL\"><font color=\"#4F4F4F\" style=\"font-size:14px;\">&nbsp;不确定</font></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"48px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:16px;\" >您对哪种阶段的公司感兴趣？（可多选）</font><font color=\"#00B38A\">*</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"13px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"firmIds\" id=\"firmIds\"/>\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" id=\"firm\">\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"48px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:16px;\" >您对下一份工作的其他要求是？</font><font color=\"#00B38A\">*</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"13px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<textarea rows=\"8\" name=\"offerRequestNextJob\" id=\"offerRequestNextJob\" style=\"width:75%;min-width:300px;\"></textarea>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"50px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\" class=\"textC\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"font-size:14px;border-color:#CCCCCC;color:#4F4F4F;background-color:#CCCCCC;min-width:140px;\">\r\n");
      out.write("\t\t\t\t\t\t取消\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" onclick=\"setSexValue(0)\" data-toggle=\"button\" id=\"sex2\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"margin-left:19px;font-size:14px;color:#FFF;background-color:#00B389;min-width:140px;\">\r\n");
      out.write("\t\t\t\t\t\t保存\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"width:100%;height:50px;\"></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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