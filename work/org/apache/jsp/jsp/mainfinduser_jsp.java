/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2017-03-27 03:05:58 UTC
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

public final class mainfinduser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/common/header.jsp", Long.valueOf(1490578556541L));
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
      out.write("\tvar removeHowMany = \"\";\r\n");
      out.write("\tfunction changeColor1(der){\r\n");
      out.write("\t\tder.style.background=\"#999999\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction changeColor2(der){\r\n");
      out.write("\t\tder.style.background=\"#000\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction init() {\r\n");
      out.write("\t\tvar firstIn = document.getElementById('firstIn').value;\r\n");
      out.write("\t\tvar url = \"firm/finduserPage1.do?firstIn=\"+firstIn;\r\n");
      out.write("\t\tvar formId = \"finduserForm\";\r\n");
      out.write("\t\tvar data = ajaxSumbit(url, formId);\r\n");
      out.write("\t\taddLi(data.saved,\"saved\");\r\n");
      out.write("\t\taddLi(data.city,\"city\");\r\n");
      out.write("\t\taddLi(data.job,\"job\");\r\n");
      out.write("\t\taddLi(data.worked,\"worked\");\r\n");
      out.write("\t\taddbutton(\"c\",data.citybutton,\"citybutton\");\r\n");
      out.write("\t\taddbutton(\"j\",data.jobbutton,\"jobbutton\");\r\n");
      out.write("\t\taddbutton(\"w\",data.workbutton,\"workbutton\");\r\n");
      out.write("\t\taddallorpair(data.allnum,data.pairnum);\r\n");
      out.write("\t\tdocument.getElementById('firmsaved').value = data.firmsaved;\r\n");
      out.write("\t\tdocument.getElementById('userName').innerText = data.userName;\r\n");
      out.write("\t\t/* addpageNum(data.pageNum,\"u1\"); *///阿华说隐藏可以显示分页器\r\n");
      out.write("\t\twindow.iframe1.location.href=\"mainfinduser_sum.jsp\";\r\n");
      out.write("\t\t$(\"#finduserForm\").populateForm(data);\r\n");
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
      out.write("\t\tif(targetInput == 'saved'){\r\n");
      out.write("\t\t\tbuttonClean();\r\n");
      out.write("\t\t\t/* document.getElementById('firmcity').value = \"\";\r\n");
      out.write("\t\t\tdocument.getElementById('firmworked').value = \"\";\r\n");
      out.write("\t\t\tdocument.getElementById('firmjob').value = \"\";\r\n");
      out.write("\t\t\tdocument.getElementById('firmcityValue').value = \"\";\r\n");
      out.write("\t\t\tdocument.getElementById('firmworkedValue').value = \"\";\r\n");
      out.write("\t\t\tdocument.getElementById('firmjobValue').value = \"\"; */\r\n");
      out.write("\t\t\t//document.getElementById('firstIn').value = 1;\r\n");
      out.write("\t\t\twindow.iframe1.location.href=\"mainfinduser_sum.jsp\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//条件标签\r\n");
      out.write("\tfunction addbutton(name,items,buttonId){\r\n");
      out.write("\t\tvar inn = \"\";\r\n");
      out.write("\t\tfor(var i in items){\r\n");
      out.write("\t\t\tinn = inn + \"<button type='button' class='close' aria-hidden='true' style='float:left;opacity:0.9;background:#00B38A;color:#FFF;padding:10px;'>\"\r\n");
      out.write("\t\t\t\t+\"<font size='2' style='font-weight: normal;letter-spacing:2px;'>\" + items[i].value \r\n");
      out.write("\t\t\t\t+\"<a href='#' id='\"+name+\"_\"+items[i].id+\"' onclick='removebutton(this)' style='color:#FFF;'>&nbsp;&nbsp;&times;</a></font></button>\";\r\n");
      out.write("\t\t\t\tdocument.getElementById(name).value = items[i].id + \"_\" + items[i].value;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(buttonId).innerHTML=inn;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction removebutton(obj){\r\n");
      out.write("\t\tvar value = obj.id;\r\n");
      out.write("\t\tvar childNode=obj.parentNode.parentNode;\r\n");
      out.write("\t\tchildNode.parentNode.removeChild(childNode);\r\n");
      out.write("\t\tremoveHowMany += document.getElementById(\"removeHowMany\").value + value + \";\";\r\n");
      out.write("\t\tdocument.getElementById(\"removeWho\").value = removeHowMany;\r\n");
      out.write("\t\twindow.iframe1.location.href=\"mainfinduser_sum.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//保存\r\n");
      out.write("\tfunction gosave(){\r\n");
      out.write("\t\ttop.location.href='finduser.jsp'\r\n");
      out.write("\t}\r\n");
      out.write("\t//清除\r\n");
      out.write("\tfunction buttonClean(){\r\n");
      out.write("\t\tdocument.getElementById('citybutton').innerHTML=\"\";\r\n");
      out.write("\t\tdocument.getElementById('jobbutton').innerHTML=\"\";\r\n");
      out.write("\t\tdocument.getElementById('workbutton').innerHTML=\"\";\r\n");
      out.write("\t}\r\n");
      out.write("\t//全部-已收藏\r\n");
      out.write("\tfunction addallorpair(allnum,pairnum){\r\n");
      out.write("\t\tdocument.getElementById('divall').innerHTML=\"<font size='1'>全部（\"+allnum+\")</font>\";\r\n");
      out.write("\t\tdocument.getElementById('divpair').innerHTML=\"<font size='1'>已收藏（\"+pairnum+\")</font>\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction goView(str){\r\n");
      out.write("\t\tif(str == 'all'){\r\n");
      out.write("\t\t\tdocument.getElementById(str).style.background=\"#00B38A\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"pair\").style.background=\"#DDDDDD\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"allorpair\").value = \"quanbu\";\r\n");
      out.write("\t\t\twindow.iframe1.location.href=\"mainfinduser_sum.jsp\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(str == 'pair'){\r\n");
      out.write("\t\t\tdocument.getElementById(str).style.backgroundColor=\"#00B38A\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"all\").style.background=\"#DDDDDD\";\r\n");
      out.write("\t\t\tdocument.getElementById(\"allorpair\").value = \"shoucang\";\r\n");
      out.write("\t\t\twindow.iframe1.location.href=\"mainfinduser_sum.jsp\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t//页码\r\n");
      out.write("\tfunction addpageNum(items,pageId){\r\n");
      out.write("\t\tvar inn = \"\";\r\n");
      out.write("\t\tfor(var i = 1; i < items; i++){\r\n");
      out.write("\t\t\tinn = inn + \"<li>\"\r\n");
      out.write("\t\t\t\t+\"<a href='#' onclick='getpage(\"+items+\")'>\"+items+\"</a>\"\r\n");
      out.write("\t\t\t\t+\"</li>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(pageId).innerHTML=inn;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction getpage(obj){\r\n");
      out.write("\t\tdocument.getElementById('pageId').value = obj;\r\n");
      out.write("\t\twindow.iframe1.location.href=\"mainfinduser_sum.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction goSumbit(){\r\n");
      out.write("\t\tvar flag = false;\r\n");
      out.write("\t\tif (document.getElementById('firmcityValue').value != \"\") {\r\n");
      out.write("\t\t\tflag = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (document.getElementById('firmjobValue').value != \"\") {\r\n");
      out.write("\t\t\tflag = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (document.getElementById('firmworkedValue').value != \"\") {\r\n");
      out.write("\t\t\tflag = true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (flag) {\r\n");
      out.write("\t\t\tdocument.getElementById('firstIn').value = 2;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar url = \"firm/savefinduser1.do\";\r\n");
      out.write("\t\tvar formId = \"finduserForm\";\r\n");
      out.write("\t\tvar data = ajaxSumbit(url, formId);\r\n");
      out.write("\t\tif (data == 'success') {\r\n");
      out.write("\t\t\tinit();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t//top.location.href=\"finduser.jsp\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction goSearch(){\r\n");
      out.write("\t\t/* var url = \"login/user.do\";\r\n");
      out.write("\t\tvar formId = \"finduserForm\";\r\n");
      out.write("\t\tvar data = ajaxSumbit(url, formId);\r\n");
      out.write("\t\taddLi(data.saved,\"saved\");\r\n");
      out.write("\t\taddLi(data.city,\"city\");\r\n");
      out.write("\t\taddLi(data.job,\"job\");\r\n");
      out.write("\t\taddLi(data.worked,\"worked\"); */\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("\t.paddingC{\r\n");
      out.write("\t\tpadding-left:120px;\r\n");
      out.write("\t\tpadding-right:120px;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("<body bgcolor=\"#FFF\" onload=\"init()\">\r\n");
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
      out.write("\t<table width=\"100%\" id=\"t1\">\r\n");
      out.write("\t\t<tr height=\"30px\"/>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"90px\"/>\r\n");
      out.write("\t\t\t<th colspan=\"2\">\r\n");
      out.write("\t\t\t\t<h4>候选人</h4>\r\n");
      out.write("\t\t\t</th>\r\n");
      out.write("\t\t\t<td width=\"90px\"/>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td/>\r\n");
      out.write("\t\t\t<td style=\"background:#F4F9F9;\">\r\n");
      out.write("\t\t\t\t<form id=\"finduserForm\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"thisId\" name=\"thisId\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"status\" name=\"status\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"c\" name=\"c\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"j\" name=\"j\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"w\" name=\"w\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"removeWho\" name=\"removeWho\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"removeHowMany\" name=\"removeHowMany\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"pageSize\" name=\"pageSize\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"firstIn\" name=\"firstIn\" value=\"1\"/>\r\n");
      out.write("\t\t\t\t<div id=\"div1\" style=\"padding:10px;width:100%;\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td style=\"padding-left:20px;\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"18%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"input-group\" style=\"margin-left:-10px !important;width: 160px !important\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"dropdown\" style=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"firmsavedFirst\" id=\"firmsavedFirst\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"firmsavedSecond\" id=\"firmsavedSecond\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"firmsaved\" id=\"firmsaved\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"firmsavedValue\" id=\"firmsavedValue\" class=\"form-control\" style=\"width: 120px !important\" placeholder=\"已保存的搜索\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <button type=\"button\" style=\"height:34px !important;background-color:#E6E6E6;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu1\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t        <span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dropdownMenu1\" style=\"width:!important\" id=\"saved\"><!--  20px  -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"18%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"input-group\" style=\"margin-left:-10px !important;width: 160px !important\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"dropdown\" style=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"firmcity\" id=\"firmcity\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"firmcityValue\" id=\"firmcityValue\" class=\"form-control\" style=\"width: 120px !important\" placeholder=\"城市\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <button type=\"button\" style=\"height:34px !important;background-color:#E6E6E6;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu1\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t        <span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dropdownMenu1\" style=\"width: 20px !important\" id=\"city\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"18%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"input-group\" style=\"margin-left:-10px !important;width: 160px !important\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"dropdown\" style=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"firmjob\" id=\"firmjob\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"firmjobValue\" id=\"firmjobValue\" class=\"form-control\" style=\"width: 120px !important\" placeholder=\"职位\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <button type=\"button\" style=\"height:34px !important;background-color:#E6E6E6;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu1\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t        <span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dropdownMenu1\" style=\"width: 20px !important\" id=\"job\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"18%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"input-group\" style=\"margin-left:-10px !important;width: 160px !important\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"dropdown\" style=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"firmworked\" id=\"firmworked\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"firmworkedValue\" id=\"firmworkedValue\" class=\"form-control\" style=\"width: 120px !important\" placeholder=\"工作经验\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <button type=\"button\" style=\"height:34px !important;background-color:#E6E6E6;\" class=\"btn dropdown-toggle\" id=\"dropdownMenu1\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t        <span class=\"caret\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    <ul class=\"dropdown-menu\" role=\"menu\" aria-labelledby=\"dropdownMenu1\" style=\"width: 20px !important\" id=\"worked\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t    </ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"lastChoose\" class=\"form-control\" style=\"width: 280px !important\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr height=\"20px\"/>\r\n");
      out.write("\t\t\t\t\t\t<tr height=\"30px\">\r\n");
      out.write("\t\t\t\t\t\t\t<td />\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"textL\" style=\"padding-left:10px;padding-right:10px;\" id=\"citybutton\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<!-- <button type=\"button\" class=\"close\" aria-hidden=\"true\" style=\"float:left;opacity:0.9;background:#00B38A;color:#FFF;padding:10px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<font size=\"2\" style=\"font-weight: normal;letter-spacing:2px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t北京\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\"  onclick=\"javascript:alert(1);\" style=\"color:#FFF;\">&nbsp;&nbsp;&times;</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</button> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"textL\" style=\"padding-left:10px;padding-right:10px;\" id=\"jobbutton\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<!-- <button type=\"button\" class=\"close\" aria-hidden=\"true\" style=\"float:left;opacity:0.9;background:#00B38A;color:#FFF;padding:10px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<font size=\"2\" style=\"font-weight: normal;letter-spacing:2px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tjava\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\"  onclick=\"javascript:alert(1);\" style=\"color:#FFF;\">&nbsp;&nbsp;&times;</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</button> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td class=\"textL\" style=\"padding-left:10px;padding-right:10px;\" id=\"workbutton\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<!-- <button type=\"button\" class=\"close\" aria-hidden=\"true\" style=\"float:left;opacity:0.9;background:#00B38A;color:#FFF;padding:10px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<font size=\"2\" style=\"font-weight: normal;letter-spacing:2px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t3-5年\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\"  onclick=\"javascript:alert(1);\" style=\"color:#FFF;\">&nbsp;&nbsp;&times;</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</button> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textR\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" onclick=\"goSumbit()\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"background-color: #00B38A !important; border-color: #00B38A !important; width: 100px;\" onclick=\"gosave()\">\r\n");
      out.write("\t\t\t\t\t\t\t\t保存</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" onclick=\"buttonClean()\" data-toggle=\"button\" onclick=\"buttonClean()\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"background-color: #FFF !important;color:#00B38A; border-color: #00B38A !important; width: 100px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t清除</button>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td  width=\"200px\">\r\n");
      out.write("\t\t\t\t<div style=\"background: #FFFFFF; width: 200px; margin-top:10px;padding-left:20px;\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td valign=\"bottom\" width=\"20px\"><font size=\"1\" color=\"#666666\">家骏</font></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textL\" rowspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<img src=\"../img/kefu.png\" width=\"75px\" height=\"75px\" style=\"border:1px solid #CCCCCC;border-radius: 10px;padding:10px 15px;\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr height=\"7px\">\r\n");
      out.write("\t\t\t\t\t\t\t<td><font size=\"1\" color=\"#666666\">客户服务</font></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<font size=\"1\" color=\"#666666\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t电话：13580500688<br/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t微信号:fish_e<br/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tQQ:37651058<br/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t邮箱:jiajun@uoffer.com\r\n");
      out.write("\t\t\t\t\t\t\t\t</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr height=\"20px\"/>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td/>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=\"10px\"/>\r\n");
      out.write("\t\t<tr height=\"20px\">\r\n");
      out.write("\t\t\t<td/>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<font size=\"1\">共<font color=\"#00B38A\"><span id=\"dataNum\">10</span></font>个匹配项，显示1~20</font>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"allorpair\" name=\"allorpair\"/>\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"textC\"><div style=\"cursor:pointer;width:80px;\" onclick=\"goView('all')\" id=\"divall\"><font size=\"1\">全部(100)</font></div></td>\r\n");
      out.write("\t\t\t\t\t\t<td class=\"textC\"><div style=\"cursor:pointer;width:80px;\" onclick=\"goView('pair')\" id=\"divpair\"><font size=\"1\">已收藏(100)</font></div></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td/>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr height=\"10px\"/>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td/>\r\n");
      out.write("\t\t\t<td style=\"background:#DDDDDD;height:1px;\"/>\r\n");
      out.write("\t\t\t<td style=\"background:#DDDDDD;height:1px;\">\r\n");
      out.write("\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"80px\"><div style=\"width:100%;background:#00B38A;height:2px;\" id=\"all\"></div><td>\r\n");
      out.write("\t\t\t\t\t\t<td width=\"80px\"><div style=\"width:100%;background:#DDDDDD;height:2px;\" id=\"pair\"></div><td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td/>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td/>\r\n");
      out.write("\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t<iframe id=\"iframe1\" name=\"iframe1\" width=\"100%\" onload=\"changeFrameHeight()\" style=\"\" scrolling=\"yes\" frameborder=\"0\" marginheight=\"0px\" marginwidth=\"0px\" frameborder=\"0\" ></iframe>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td/>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr id=\"pagecontrol\">\r\n");
      out.write("\t\t\t<td/>\r\n");
      out.write("\t\t\t<td colspan=\"2\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"pageId\" id=\"pageId\" value=\"1\"/>\r\n");
      out.write("\t\t\t\t<ul class=\"pagination\" id=\"u1\" style=\"margin-top:10px;\">\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\" onclick=\"getpage(1)\">&laquo;</a></li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\">1</a></li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\">2</a></li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\">3</a></li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\">4</a></li>\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\">5</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td/>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</body>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\t//调整iframe页面\r\n");
      out.write("\tfunction changeFrameHeight(){\r\n");
      out.write("\t    var ifm= document.getElementById(\"iframe1\"); \r\n");
      out.write("\t    var dh = document.getElementById(\"div1\").offsetHeight*2;\r\n");
      out.write("\t    var uh = document.getElementById(\"pagecontrol\").offsetHeight*2;\r\n");
      out.write("\t    ifm.height=document.body.offsetHeight-55-dh-uh+\"px\";\r\n");
      out.write("\t    /* alert(ifm.height); */\r\n");
      out.write("\t}\r\n");
      out.write("\twindow.onresize=function(){  \r\n");
      out.write("\t     changeFrameHeight();  \r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
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