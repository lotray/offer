<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<style>
.smailfont{
	font-size:1px;
}
.fontcol{
	padding-left: 20px;
	color:#666666;
}
</style>
</head>
<script language="javascript">
	//头部
	function changeColor1(der){
		der.style.background="#999999";
	}
	function changeColor2(der){
		der.style.background="#000";
	}
	function booleanInfot(url){
	}
</script>
<body bgcolor="#FFFFFF" onload="init()">
	<form id="loginForm">
	<div style="width:100%;height:55px;background: #000;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;">
		<table style="width:100%;white-space: nowrap;">
			<tr>
				<td width="270px" style="padding-left:150px;"><img src="../img/U-Offerlogo.png"></td>
				<td class="textC">
				    <button type="button" style="height:55px !important;width:80px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('interview.jsp')">
				    	<font size="3">面试邀请</font>
				    </button>
				    <button type="button" style="height:55px !important;width:80px !important;color:#FFF;background-color:#000;"class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('resume_edit.jsp')">
				    	<font size="3">我的简历</font>
				    </button>
			    </td>
			    <td class="textC" width="270px">
				    <button type="button" style="height:55px !important;width:80px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='personal_settings.jsp'">个人设置
				    </button>
				    <button type="button" style="height:55px !important;width:80px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu4" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='login.jsp'">退出
				    </button>
				</td>
			</tr>
		</table>
	</div>
	<br />
	<br />
	<br />
	<center>
		<div style="background: #FFFFFF; width: 80%;">
			<table width="100%">
				<tr height="50px"/>
				<tr>
					<td class="textC" style="padding:10px 0px;font-size:1px;color:#666666;">很抱歉，您提交的申请没有通过我们的审核，我们暂时无法向您提供合适的机会。</td>
				</tr>
				<tr>
					<td class="textC" style="padding:10px 0px;font-size:1px;color:#666666;">我们会在有合适机会时联系您，您也可以随时重新提交申请。</td>
				</tr>
				<tr>
					<td class="textC" style="padding:10px 0px;font-size:1px;">
						<div class="btn-group btn-group-lg">
				    		<button type="button" class="btn btn-default" style="width:180px;color:#FFF;background:#00B389;" onclick="javascript:top.location.href='resume_add_information.jsp'">
				    			<font size="1">重新申请</font>
				    		</button>
				    	</div>
			    	</td>
				</tr>
				<tr height="50px"/>
			</table>
		</div>
		<div style="height: 2px; width: 80%; background-color: #DDDDDD;"></div>
		<div style="background: #FFFFFF; width: 80%;">
			<br />
			<table
				style="border-collapse: separate; border-spacing: 10px; width: 100%;">
				<tr>
					<td class="textC" style="padding:10px 0px;font-size:1px;" colspan="4">完善简历</td>
				</tr>
				<tr>
					<td class="smailfont textR" valign="top" width="43%">简历完成度</td>
					<td style="width:153px;">
						<div class="progress" style="width:150px;height:15px;">
						    <div class="progress-bar" role="progressbar" aria-valuenow="60" 
						        aria-valuemin="0" aria-valuemax="100" style="width: 40%;background:#00B389;border:1px #00B389 solid;">
						        <span class="sr-only"></span>
						    </div>
						</div>
					</td>
					<td class="smailfont textL" valign="top" style="width:20px;">40%</td>
					<td class="smailfont textL" valign="top"><a href="#" onclick="javascript:top.location.href='resume_add_information.jsp'">修改简历</a></td>
				</tr>
				<tr>
					<td class="smailfont textC" colspan="4">
						<font color="#666666">简历的完善程度影响您能收获的机会，也是我们审核时重要的依据。<a href="#"><font color="#00B389" style="text-decoration: underline;">看看我们的审核标准</font></a></font>
					</td>
				</tr>
				<tr height="20px"/>
				<tr>
					<td colspan="4">
						<table width="100%">
							<tr>
								<td rowspan="6" class="textR" width="50%"><img src="../img/kefu.png" width="100px" style="border:2px solid #BBBBBB;padding:10px 20px;border-radius:13px;"/></td>
								<td class="textL fontcol smailfont" width="50%">我是张丽，你的职业顾问</td>
							</tr>
							<tr>
								<td class="textL fontcol smailfont">期待着与您交流工作、求职中的想法</td>
							</tr>
							<tr>
								<td class="textL fontcol smailfont">电话：</td>
							</tr>
							<tr>
								<td class="textL fontcol smailfont">微信：</td>
							</tr>
							<tr>
								<td class="textL fontcol smailfont">QQ:</td>
							</tr>
							<tr>
								<td class="textL fontcol smailfont">邮箱：</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
		</div>
		<div style="height: 2px; width: 80%; background-color: #DDDDDD;"></div>
		<div style="background: #FFFFFF; width: 80%;">
			<br />
			<table
				style="border-collapse: separate; border-spacing: 10px; width: 100%;">
				<tr>
					<td width="33%"/>
					<td class="textC" style="padding:10px 0px;"><font size="4" style="font-weight:bold;">看看申请后会发生什么</font></td>
					<td width="33%"/>
				</tr>
				<tr>
					<td class="textC"><img src="../img/project.png" width="100px"/></td>
					<td class="textC"><img src="../img/email.png" width="100px"/></td>
					<td class="textC"><img src="../img/aguy.png" width="180px"/></td>
				</tr>
				<tr>
					<td class="textC">
						<center>
							<div style="width:125px;font-size:1;margin-top:-20px">
								您的简历向您感兴趣的企业展示2周
							</div>
						</center>
					</td>
					<td class="textC">
						<center>
							<div style="width:140px;font-size:1;margin-top:-20px">
								企业向您发出面试邀请，并声明职位及薪酬
							</div>
						</center>
					</td>
					<td class="textC">
						<center>
							<div style="width:140px;font-size:1;margin-top:-10px">
								选择您满意的参加面试，挑选满意的offer入职
							</div>
						</center>
					</td>
				</tr>
			</table>
			<br />
		</div>
		<div style="height: 2px; width: 80%; background-color: #DDDDDD;"></div>
		<div style="background: #FFFFFF; width: 80%;">
			<br />
			<table
				style="border-collapse: separate; border-spacing: 10px; width: 100%;">
				<tr>
					<td width="33%"/>
					<td class="textC" style="padding:10px 0px;"><font size="4" style="font-weight:bold;">最近在U-offer招聘的企业</font></td>
					<td width="33%"/>
				</tr>
				<tr>
					<td class="textC"><img src="../img/firm_logo3.png" width="100px"/></td>
					<td class="textC"><img src="../img/firm_logo2.png" width="100px"/></td>
					<td class="textC"><img src="../img/firm_logo1.png" width="100px"/></td>
				</tr>
				<tr height="10px"/>
				<tr>
					<td class="textC"><img src="../img/firm_logo5.png" width="100px"/></td>
					<td class="textC"><img src="../img/firm_logo6.png" width="100px"/></td>
					<td class="textC"><img src="../img/firm_logo4.png" width="100px"/></td>
				</tr>
			</table>
			<br />
		</div>
	</center>
	</form>
</body>
</html>
