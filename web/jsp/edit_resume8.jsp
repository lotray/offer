<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<style>
</style>
<script language="javascript">
	function test(){
		parent.document.getElementById("main1").height=0;
		parent.document.getElementById("main1").height=document.body.scrollHeight;
		
		var url = "user/getuserendless.do";
		var data = ajaxSumbitNoform(url, "123");
		document.getElementById("endless").value = data;
	}
	function goSave(){
		var endless = document.getElementById("endless").value;
		var url = "user/saveuserendless.do";
		var formId = "editForm";
		var data = ajaxSumbitNoform(url, endless);
		if(data == "success"){
			alert("修改成功!");
		}else{
			alert("数据出错!");
		}
	}
</script>
<body bgcolor="#FFF" onload="test()">
	<div style="width:100%;">
		<table width="100%">
			<tr height="49px"/>
			<tr>
				<td width="40px"/>
				<td width="54%">
					<font style="font-size:20px;" color="#4F4F4F">隐私保护</font>
				</td>
				<td class="textC" width="19%">
				</td>
				<td/>
			</tr>
			<tr height="20px"/>
			<tr>
				<td/>
				<td colspan="3">
					<font color="#9A9A9A" style="font-size:16px;" >可以填写你想屏蔽的公式邮箱后缀，让他们无法查看你的简历</font>
				</td>
			</tr>
			<tr height="29px"/>
			<tr>
				<td/>
				<td colspan="3">
					<input type="text" id="endless" class="form-control" placeholder="assss@baidu.com" style="width: 42% !important;min-width:200px;">
				</td>
			</tr>
			<tr height="50px"/>
			<tr>
				<td/>
				<td colspan="3" class="textC">
					<button type="button" class="btn btn-primary" data-toggle="button"
						style="font-size:14px;border-color:#CCCCCC;color:#4F4F4F;background-color:#CCCCCC;min-width:140px;">
						取消
					</button>
					<button type="button" class="btn btn-primary" data-toggle="button"
						style="margin-left:19px;font-size:14px;color:#FFF;background-color:#00B389;min-width:140px;" onclick="goSave()">
						保存
					</button>
				</td>
			</tr>
		</table>
	</div>
	<div style="width:100%;height:50px;"></div>
</body>
</html>