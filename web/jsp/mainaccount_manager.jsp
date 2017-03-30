<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<script language="javascript">
	function init() {
		/* var url = "firm/userviewPage1.do";
		var formId = "userviewForm";
		var data = ajaxSumbit(url, formId);
		addtags("type1","等待候选人回应("+data.interview1+")");
		addtags("type2","待安排面试("+data.interview2+")");
		addtags("type3","待反馈结果("+data.interview3+")");
		addtags("type4","面试通过("+data.interview4+")");
		addtags("type5","归档("+data.interview5+")");
		addtags("type6","面试安排表");
		goSearch(); */
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
		$(".triangle-left").each(function () {
			this.setAttribute("class","");
        });
		if(seqno == 1){
			document.getElementById("type11").setAttribute("class","triangle-left");
			document.getElementById("usertype").value = seqno;
			window.iframe1.location.href="accout.jsp";
		}
		if(seqno == 2){
			document.getElementById("type12").setAttribute("class","triangle-left");
			document.getElementById("usertype").value = seqno;
			window.iframe1.location.href="tuijian.jsp";
		}
		if(seqno == 3){
			document.getElementById("type13").setAttribute("class","triangle-left");
			document.getElementById("usertype").value = seqno;
			window.iframe1.location.href="guwen_commit.jsp";
		}
		if(seqno == 4){
			document.getElementById("type14").setAttribute("class","triangle-left");
			document.getElementById("usertype").value = seqno;
			window.iframe1.location.href="resume_show.jsp";
		}
	}
	function addtags(typeId,typemsg){
		document.getElementById(typeId).innerHTML="<font size='3' color='#666666'>"+typemsg+"</font>";
	}
	function goSearch(){
		//window.iframe1.location.href="mainusers_view.jsp";
	}
</script>
<body bgcolor="#F4F9F9" onload="init()">
	<form id="userviewForm">
		<input type="hidden" id="userId" name="userId"/>
	</form>
	<div style="width:100%;height:46px;background: #000; position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;">
		<table style="width:100%;white-space: nowrap;">
			<tr>
				<td width="270px" style="padding-left:150px;"><img src="../img/U-Offerlogo.png"></td>
				<td class="textL" style="padding-left:100px;">
				    <button type="button" style="height:46px !important;width:80px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='user_manager.jsp'">
				    	<font size="3">候选人</font>
				    </button>
				    <button type="button" style="height:46px !important;width:80px !important;color:#FFF;background-color:#000;"class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='firm_manager.jsp'">
				    	<font size="3">企业</font>
				    </button>
				    <button type="button" style="height:46px !important;width:80px !important;color:#FFF;background-color:#000;"class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='account_manager.jsp'">
				    	<font size="3">数据统计</font>
				    </button>
			    </td>
			    <td class="textC" width="270px">
			    	<button type="button" style="height:46px !important;width:80px !important;color:#FFF;background-color:#000;"class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='stafflogin.jsp'">
				    	<font size="3">退出</font>
				    </button>
			    </td>
			</tr>
		</table>
	</div>
	<table width="100%" height="100%" style="position:fixed;margin-top:80px;">
		<tr>
			<td width="15%" rowspan="10"/>
			<td rowspan="10" valign="top" width="250px" valign="top">
				<input type="hidden" id="usertype" name="usertype" value="1"/>
				<table width="100%" style="background:#FFF">
					<tr>
						<td class="textL" style="cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" id="type1" onclick="selectInterviewType(1)">
							<font size="3">管理账号</font>
						</td>
					</tr>
					<tr><td class="textL" style="cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" id="type2" onclick="selectInterviewType(2)"><font size="3">推荐设置</font></td></tr>
					<tr><td class="textL" style="cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" id="type3" onclick="selectInterviewType(3)"><font size="3">顾问联系设置</font></td></tr>
					<tr><td class="textL" style="cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" id="type4" onclick="selectInterviewType(4)"><font size="3">简历展示设置</font></td></tr>
				</table>
			</td>
			<td width="20px" style="" valign="top">
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
				</table>
			</td>
			<td rowspan="10" class="textL" valign="top">
				<iframe src="accout.jsp" height="85%" width="70%" style="border-left:2px #0dad87 solid;" scrolling="auto" frameborder="0" marginheight="0px" marginwidth="0px" id="iframe1" name="iframe1"></iframe>
			</td>
		</tr>
	</table>
</body>
</html>