/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.54
 * Generated at: 2017-04-06 15:27:19 UTC
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

public final class edit_005fresume7_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction test() {\r\n");
      out.write("\t\tvar url = \"user/getresume7.do\";\r\n");
      out.write("\t\tvar data = ajaxSumbitNoformofstring(url, \"123\");\r\n");
      out.write("\t\tdocument.getElementById(\"descript\").value = data==undefined?\"\":data;\r\n");
      out.write("\r\n");
      out.write("\t\tparent.document.getElementById(\"main1\").height = 0;\r\n");
      out.write("\t\tparent.document.getElementById(\"main1\").height = document.body.scrollHeight;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction insertTest() {\r\n");
      out.write("\t\tvar font1 = document.createElement(\"font\");\r\n");
      out.write("\t\tvar font2 = document.createElement(\"font\");\r\n");
      out.write("\t\tvar font3 = document.createElement(\"font\");\r\n");
      out.write("\t\tvar font4 = document.createElement(\"font\");\r\n");
      out.write("\t\tfont1.style = \"font-weight:bold;font-size:30px;\";\r\n");
      out.write("\t\tfont2.style = \"font-weight:bold;font-size:30px;\";\r\n");
      out.write("\t\tfont3.style = \"font-weight:bold;font-size:30px;\";\r\n");
      out.write("\t\tfont4.style = \"font-weight:bold;font-size:30px;\";\r\n");
      out.write("\t\tfont1.innerHTML = \"<br/>##个人简历<br/>\"\r\n");
      out.write("\t\tfont2.innerHTML = \"##技术经历和项目技术细节<br/>\"\r\n");
      out.write("\t\tfont3.innerHTML = \"##其他开源项目和个人作品<br/>\"\r\n");
      out.write("\t\tfont4.innerHTML = \"##理想团队<br/>\";\r\n");
      out.write("\t\tdocument.getElementById(\"descript_html\").contentWindow.document.body\r\n");
      out.write("\t\t\t\t.appendChild(font1);\r\n");
      out.write("\t\tdocument.getElementById(\"descript_html\").contentWindow.document.body\r\n");
      out.write("\t\t\t\t.appendChild(font2);\r\n");
      out.write("\t\tdocument.getElementById(\"descript_html\").contentWindow.document.body\r\n");
      out.write("\t\t\t\t.appendChild(font3);\r\n");
      out.write("\t\tdocument.getElementById(\"descript_html\").contentWindow.document.body\r\n");
      out.write("\t\t\t\t.appendChild(font4);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction goSave() {\r\n");
      out.write("\t\tvar endless = document.getElementById(\"descript\").value;\r\n");
      out.write("\t\tvar url = \"user/saveresume7.do\";\r\n");
      out.write("\t\tvar formId = \"editForm\";\r\n");
      out.write("\t\tvar data = ajaxSumbitNoformofstring(url, endless);\r\n");
      out.write("\t\tif (data == \"SUCCESS\") {\r\n");
      out.write("\t\t\talert(\"修改成功!\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\talert(\"数据出错!\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<body bgcolor=\"#FFF\" onload=\"test()\">\r\n");
      out.write("\t<div style=\"width: 100%;\">\r\n");
      out.write("\t\t<table width=\"100%\">\r\n");
      out.write("\t\t\t<tr height=\"49px\" />\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td width=\"40px\" />\r\n");
      out.write("\t\t\t\t<td width=\"54%\"><font style=\"font-size: 20px;\" color=\"#4F4F4F\">个人作品</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td class=\"textC\" width=\"19%\"></td>\r\n");
      out.write("\t\t\t\t<td />\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"26px\" />\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td />\r\n");
      out.write("\t\t\t\t<td colspan=\"2\"><font color=\"#4F4F4F\" style=\"font-size: 16px;\">介绍一下自己的作品</font>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td />\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"29px\" />\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td />\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" height=\"420px\"><textarea rows=\"28\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"width: 100%; min-width: 300px;\" id=\"descript\"></textarea></td>\r\n");
      out.write("\t\t\t\t<td />\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr height=\"50px\" />\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td />\r\n");
      out.write("\t\t\t\t<td colspan=\"3\" class=\"textC\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"font-size: 14px; border-color: #CCCCCC; color: #4F4F4F; background-color: #CCCCCC; min-width: 140px;\">\r\n");
      out.write("\t\t\t\t\t\t取消</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" onclick=\"goSave()\" class=\"btn btn-primary\" data-toggle=\"button\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"margin-left: 19px; font-size: 14px; color: #FFF; background-color: #00B389; min-width: 140px;\">\r\n");
      out.write("\t\t\t\t\t\t保存</button></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"width: 100%; height: 50px;\"></div>\r\n");
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
