/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2017-04-01 01:25:39 UTC
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

public final class edit_005fresume5_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/common/header.jsp", Long.valueOf(1490944951835L));
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
      out.write("\tfunction addmsgDiv(items){\r\n");
      out.write("\t\tvar div1 = \"\";\r\n");
      out.write("\t\tvar j = 0;\r\n");
      out.write("\t\tfor(var i in items){\r\n");
      out.write("\t\t\tdiv1 = div1 + \"<div style='width:100%' onmouseover='appacerdiv(this)' id='d\"+j+\"' style='min-height:75px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"<table width='100%' id='editMsg'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<tr height='30px'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<th width='55%'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"<font color='#4F4F4F' style='font-size:14px;' >深圳腾讯</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"</th>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<td class='textC' valign='top' style='padding-top:5px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"<font color='#4F4F4F' style='font-size:14px;' >2016.03.02-</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"<font color='#4F4F4F' style='font-size:14px;' >运营经理</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<td/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"<font color='#4F4F4F' style='font-size:14px;' >运营经理</font>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<td/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"</table>\"\r\n");
      out.write("\t\t\t\t\t\t+\"</div>\"\r\n");
      out.write("\t\t\t\t\t\t+\"<div style='width:100%;z-index:9999;display:none;' onmouseout='displaydiv(this)' id='e\"+j+\"'>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"<table width='100%' style='height:100%;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<td width='90%'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<td width='100px'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"<button type='button' class='btn btn-primary' data-toggle='button' onclick='resetOne(true)'\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"style='font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"删除\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"</button>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<td width='100px'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"<button type='button' class='btn btn-primary' data-toggle='button' onclick='resetOne(true)'\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"style='font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;'>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"编辑\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+\"</button>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"</td>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t+\"<td width='3%'/>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+\"</tr>\"\r\n");
      out.write("\t\t\t\t\t\t\t+\"</table>\"\r\n");
      out.write("\t\t\t\t\t\t+\"</div>\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(\"msgDiv\").innerHTML=div1;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction appacerdiv(obj){\r\n");
      out.write("\t\tobj.style.height=obj.offsetHeight;\r\n");
      out.write("\t\tvar id = \"e\"+obj.id.substring(1,2);\r\n");
      out.write("\t\tdocument.getElementById(id).style.display=\"\";\r\n");
      out.write("\t\tif(document.getElementById(id).style.heigh != undefined){\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdocument.getElementById(id).style.height=obj.offsetHeight-30;\r\n");
      out.write("\t\tdocument.getElementById(id).style.marginTop=0-obj.offsetHeight+30 +\"px\";\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction displaydiv(obj){\r\n");
      out.write("\t\tobj.style.display=\"none\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body bgcolor=\"#FFF\" onload=\"test()\">\r\n");
      out.write("\t<div style=\"width:100%;\">\r\n");
      out.write("\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t<tr height=\"49px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"40px\"/>\r\n");
      out.write("\t\t\t\t<td width=\"54%\">\r\n");
      out.write("\t\t\t\t\t<font style=\"font-size:20px;\" color=\"#4F4F4F\">教育经历</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td class=\"textC\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\" onclick=\"resetOne(true)\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;\">\r\n");
      out.write("\t\t\t\t\t\t新增\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" style=\"position: relative;\" id=\"msgDiv\">\r\n");
      out.write("\t\t\t\t\t<!-- <div style=\"width:100%\" onmouseover=\"appacerdiv(this)\" style=\"min-height:75px;\">\r\n");
      out.write("\t\t\t\t\t\t<table width=\"100%\" id=\"editMsg\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr height=\"30px\"/>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th width=\"55%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:14px;\" >深圳腾讯</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td class=\"textC\" valign=\"top\" style=\"padding-top:5px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:14px;\" >2016.03.02-</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:14px;\" >运营经理</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:14px;\" >运营经理</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div style=\"width:100%;z-index:9999;display:none;\" onmouseout=\"displaydiv(this)\" id=\"test1\">\r\n");
      out.write("\t\t\t\t\t\t<table width=\"100%\" style=\"height:100%;\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"90%\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"100px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\" onclick=\"resetOne(true)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyle=\"font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t删除\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"100px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\" onclick=\"resetOne(true)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tstyle=\"font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t编辑\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"3%\"/>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div> -->\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"48px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:14px;\" >学校名称</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"16px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"firmName\" id=\"firmName\" class=\"form-control\" style=\"width: 56% !important\">\r\n");
      out.write("\t\t\t\t\t<input id=\"offerUserWorksId\" type=\"hidden\" name=\"offerUserWorksId\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"48px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:16px;\" >学历</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"13px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"jobName\" id=\"jobName\" class=\"form-control\" style=\"width: 56% !important\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"56px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:16px;\" >就读时间</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"13px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textC\" width=\"50px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:16px;\" >开始</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textL\" width=\"141px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"jobstart\" id=\"jobstart\" class=\"form-control\" style=\"width: 141px !important;\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textC\" width=\"50px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:16px;\" >结束</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textL\" width=\"141px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"jobend\" class=\"form-control\" style=\"width: 141px !important;\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"textR\" width=\"80px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"toNow1\"/><font color=\"#4F4F4F\" style=\"font-size:16px;\" >至今</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"48px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<font color=\"#4F4F4F\" style=\"font-size:16px;\" >专业</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"13px\"/>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td/>\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<textarea rows=\"8\" style=\"width:75%;min-width:300px;\" name=\"workcontent\"></textarea>\r\n");
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
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\"\r\n");
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
