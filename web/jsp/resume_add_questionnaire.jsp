<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <%@include file="/common/header.jsp"%> --%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<script language="javascript">
	function goSubmit() {
		var url = "register/firm.do";
		var formId = "loginForm";
		ajaxSumbit(url, formId);
	}
</script>
<frameset rows="*,45" frameborder="no" border="0"
	framespacing="0">
	<frame src="mainresume_add_questionnaire.jsp" name="mainFrame" scrolling="yes"
		noresize="noresize" id="mainFrame" title="mainFrame" />
	<frame src="bottom.jsp" name="topFrame" scrolling="auto" noresize="noresize"
		id="topFrame" title="topFrame" />
</frameset>
</html>
