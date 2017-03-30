<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<style>
.greenTd{
	background:#00B38A !important;
	color:#FFF !important;
}
</style>
</head>
<script language="javascript">
	function pareUrl(){
		var name,value; 
		var str=parent.location.href; //取得整个地址栏
		var num=str.indexOf("?") 
		str=str.substr(num+1);
		if(num == -1){
			return false;
		}
		selectInterviewType(str);
		return true;
	}
	function init() {
		var url = "firm/userviewPage1.do";
		var formId = "userviewForm";
		var data = ajaxSumbit(url, formId);
		addtags("type1","等待候选人回应("+data.interview1+")");
		addtags("type2","待安排面试("+data.interview2+")");
		addtags("type3","待反馈结果("+data.interview3+")");
		addtags("type4","面试通过("+data.interview4+")");
		addtags("type5","归档("+data.interview5+")");
		addtags("type6","面试安排表");
		document.getElementById('userName').innerText = data.userName;
		document.getElementById("type1").setAttribute("class","greenTd");
		if(!pareUrl()){
			goSearch();
		}
	}
	function changeColor1(der){
		der.style.background="#999999";
	}
	function changeColor2(der){
		der.style.background="#000";
	}
	function changeColor3(der){
		der.style.background="#00B38A";
		der.style.color="#FFF";
	}
	function changeColor4(der){
		der.style.background="#FFF";
		der.style.color="#666666";
	}
	function jobId(job){
		if(job.getAttribute('class') == "icheckbox_square-green checked"){
			job.setAttribute("class","icheckbox_square-green hover");
		}
		else if(job.getAttribute('class') == "icheckbox_square-green hover"){
			job.setAttribute("class","icheckbox_square-green checked");
		}
	}
	function selectInterviewType(seqno){
		window.iframe2.location.href="e.html";
		$(".greenTd").each(function () {
			this.setAttribute("class","");
        });
		var tdId = "type" + seqno;
		document.getElementById(tdId).setAttribute("class","greenTd");
		$(".triangle-left").each(function () {
			this.setAttribute("class","");
        });
		$(".triangle-left").each(function () {
			this.setAttribute("class","");
        });
		if(seqno == 1){
			document.getElementById("type11").setAttribute("class","triangle-left");
			document.getElementById("usertype").value = "'0','1'";
		}
		if(seqno == 2){
			document.getElementById("type12").setAttribute("class","triangle-left");
			document.getElementById("usertype").value = seqno;
		}
		if(seqno == 3){
			document.getElementById("type13").setAttribute("class","triangle-left");
			document.getElementById("usertype").value = seqno;
		}
		if(seqno == 4){
			document.getElementById("type14").setAttribute("class","triangle-left");
			document.getElementById("usertype").value = seqno;
		}
		if(seqno == 5){
			document.getElementById("type15").setAttribute("class","triangle-left");
			document.getElementById("usertype").value = "'4','5','6'";
		}
		if(seqno == 6){
			document.getElementById("type16").setAttribute("class","triangle-left");
			document.getElementById("usertype").value = seqno;
		}
		goSearch();
	}
	function addtags(typeId,typemsg){
		document.getElementById(typeId).innerHTML="<font size='3' color='#666666'>"+typemsg+"</font>";
	}
	function goSearch(){
		window.iframe1.location.href="mainusers_view.jsp";
	}
</script>
<body bgcolor="#F4F9F9" onload="init()">
	<form id="userviewForm"></form>
	<input type="hidden" id="inviteId" name="inviteId"/>
	<div style="width:100%;height:55px;background: #000;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;">
		<table style="width:100%;white-space: nowrap;">
			<tr>
				<td width="270px" style="padding-left:150px;"><img src="../img/U-Offerlogo.png"></td>
				<td class="textL" style="padding-left:100px;">
				    <button type="button" style="height:55px !important;width:80px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='finduser.jsp'">
				    	<font size="3">候选人</font>
				    </button>
				    <button type="button" style="height:55px !important;width:80px !important;color:#FFF;background-color:#000;"class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='user_view.jsp'">
				    	<font size="3">已发邀请</font>
				    </button>
			    </td>
			    <td class="textC" width="270px">
				    <div class="btn-group">
						<button type="button" style="height:55px !important;color:#FFF;background-color:#000;"
						 class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)"
						 onmouseout="changeColor2(this)" ><span id="userName"></span>
					        <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu2" style="">
					        <li role="presentation">
					            <a role="menuitem" tabindex="-1" href="#" onclick="javascript:top.location.href='personal_settings_edit.jsp'"><font color="#000">个人设置</font></a>
					            <a role="menuitem" tabindex="-1" href="#" onclick="javascript:top.location.href='firm_resume_add.jsp'"><font color="#000">企业信息</font></a>
					        </li>
					    </ul>
				    </div>
				    <button type="button" style="height:55px !important;width:80px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu4" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='login.jsp'">退出
				    </button>
				</td>
			</tr>
		</table>
	</div>
	<table width="100%" height="100%" style="position:fixed;margin-top:80px;">
		<tr>
			<td width="15%" rowspan="10"/>
			<td rowspan="10" valign="top" width="250px" valign="top">
				<input type="hidden" id="usertype" name="usertype" value="'0','1'"/>
				<table width="100%" style="background:#FFF">
					<tr><td class="textL" style="border-bottom:1px #E3E6E6 solid;cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" id="type1" onclick="selectInterviewType(1)"><font size="3">账号信息</font></td></tr>
					<tr><td class="textL" style="border-bottom:1px #E3E6E6 solid;cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" id="type2" onclick="selectInterviewType(2)"><font size="3">待沟通(1)</font></td></tr>
					<tr><td class="textL" style="border-bottom:1px #E3E6E6 solid;cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" id="type3" onclick="selectInterviewType(3)"><font size="3">待安排面试(1)</font></td></tr>
					<tr><td class="textL" style="border-bottom:1px #E3E6E6 solid;cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" id="type4" onclick="selectInterviewType(4)"><font size="3">已安排面试(1)</font></td></tr>
					<tr><td class="textL" style="border-bottom:1px #E3E6E6 solid;cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" id="type5" onclick="selectInterviewType(5)"><font size="3">面试结果(1)</font></td></tr>
					<tr><td class="textL" style="border-bottom:1px #E3E6E6 solid;cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" id="type6" onclick="javascript:top.location.href='calendar.jsp'"><font size="3">已拒绝面试邀请(1)</font></td></tr>
				</table>
			</td>
			<td width="20px" style="border-right:2px #0dad87 solid;" valign="top">
				<table width="100%">
					<tr height="49px">
						<td class="textR" style="padding-top:15px;padding-bottom:15px;">
							<div class="triangle-left" style="float:right" id="type11"></div>
						</td>
					</tr>
					<tr height="49px">
						<td class="textR" style="padding-top:15px;padding-bottom:15px;">
							<div class="" style="float:right" id="type12"></div>
						</td>
					</tr>
					<tr height="49px">
						<td class="textR" style="padding-top:15px;padding-bottom:15px;">
							<div class="" style="float:right" id="type13"></div>
						</td>
					</tr>
					<tr height="49px">
						<td class="textR" style="padding-top:15px;padding-bottom:15px;">
							<div class="" style="float:right" id="type14"></div>
						</td>
					</tr>
					<tr height="49px">
						<td class="textR" style="padding-top:15px;padding-bottom:15px;">
							<div class="" style="float:right" id="type15"></div>
						</td>
					</tr>
					<tr height="49px">
						<td class="textR" style="padding-top:15px;padding-bottom:15px;">
							<div class="" style="float:right" id="type16"></div>
						</td>
					</tr>
				</table>
			</td>
			<td class="textL" width="200px" valign="top" height="84%" style="min-width:200px;">
				<iframe height="100%" width="100%" scrolling="auto" frameborder="0" marginheight="0px" marginwidth="0px" style="background:#FFF;border-top:2px #CCCCCC solid;border-bottom:1px #CCCCCC solid;" id="iframe1" name="iframe1"></iframe>
			</td>
			<td class="textL" valign="top" height="84%">
				<iframe height="100%" width="70%" scrolling="auto" frameborder="0" marginheight="0px" marginwidth="0px" style="background:#FFF;border:2px #CCCCCC solid;" id="iframe2" name="iframe2"></iframe>
			</td>
		</tr>
	</table>
</body>
</html>