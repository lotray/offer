<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<script language="javascript">
	function init(){
		goSearch();
	}
	function goSearch(){
		document.getElementById('inviteId').value=parent.document.getElementById('inviteId').value;
		var nowInviteId = parent.document.getElementById('inviteId').value;
		if (nowInviteId == 'undefined'){
			document.getElementById("header").style.display="none";
			document.getElementById("interviewdiv").style.display="none";
			document.getElementById("interviewtypediv").style.display = "none";
		}
		else if (nowInviteId != "") {
			document.getElementById('interviewtype').value=parent.document.getElementById('interviewtype').value;
			var url = "firm/userqiuzhi3.do";
			var formId = "returninterview";
			var data = ajaxSumbit(url, formId);
			parent.document.getElementById('inviteId').value = data.inviteId;
			addhead(data);
			addcommit(data.commit);
			document.getElementById('status').value=data.status;
			selectinterview(document.getElementById('interviewtype').value);
		}
		else {
			document.getElementById("header").style.display="none";
			document.getElementById("interviewdiv").style.display="none";
			document.getElementById("interviewtypediv").style.display = "none";
		}
	}
	function addhead(data){
		document.getElementById("firmName").innerText=data.firmName;
		document.getElementById("firmLogo").innerHTML="<img src='"+data.firmLogo+"' width='140px' height='140px'/>"
		document.getElementById("firmAddress").innerText=data.firmAddress;
		document.getElementById("firmJob").innerText=data.firmJob;
		document.getElementById("firmMoney").innerText=data.firmMoney;
		document.getElementById("firmQiQuan").innerText=data.firmQiQuan;
		document.getElementById("firmResume").innerText=data.firmResume;
	}
	function addcommit(items){
		var form1 = document.getElementById("commit");
		var div1 = "";
		var cStatus = "";
		for(var i in items){
			cStatus = items[i].cStatus;
			if (cStatus == 'true') {
				cStatus = "<td class='textL' style='padding:20px;'>"
					+ "<font size='1' color='green'>面试成功</font>"
					+ "</td>"
			}
			else {
				cStatus = "";
			}
			div1 = div1 + "<div class='getColor' style='width:100%;'>"
							+ "<table style='width: 100%;padding-top:25px;padding-left:50px;border-collapse:separate !important;'>"
								+ "<tr>"
									+ "<td style='width:100px !important;' class='textL'>"
										+ "<img src='" + items[i].image + "' width='80px' height='80px' />"
									+ "</td>"
									+ "<td class='textL' style='padding:20px;'>"
										+ "<font size='1'>"+items[i].name+"</font>"
									+ "</td>"
									+ "<td width='100px' class='textC'>"
										+ "<font size='1' color='#00B38A'>"+items[i].time+"</font>"
									+ "</td>"
								+ "</tr>"
								+ "<tr>"
								+ cStatus
								+ "</tr>"
								+ "<tr>"
									+ "<td class='textL' colspan='3' style='padding:20px;'><font size='1' style='line-height:23px;'>"+items[i].content+"</font></td>"
								+ "</tr>"
							+ "</table>"
						+ "</div>";
		}
		form1.innerHTML=div1;
	}
	function interviewreturn(title,tvalue){
		//var div1 = "<table style='width: 100%;padding-top:25px;padding-left:50px;border-collapse:separate !important;'>"
		/* var div1 = ""	+"<tr>"
							+"<td style='width:90px !important;padding:10px 0px;' class='textL'>"
								+"<font size='2'>"+title+"</font>"
							+"</td>"
						+"</tr>"
						+"<tr>"
							+"<td class='textL'>"
								+"<textarea style='width:90%;' rows='6' name='chatMessage' placeholder='"+tvalue+"'></textarea>"
							+"</td>"
						+"</tr>"
						+"<tr>"
							+"<td class='textL' style='padding:10px 0px;'>"
								+"<button type='button' class='btn btn-primary' onclick='goSumbit()' data-toggle='button'"
								+" style='background-color: #00B38A !important; border-color: #00B38A !important; width: 40%'>"
								+"提交</button>"
							+"</td>"
						+"</tr>";
					//+"</table>";
		document.getElementById("interviewdiv").innerHTML=div1; */
	}
	function selecttype(num){
		$(".active").each(function () {
			this.setAttribute("class","");
		});
		var id = "t" + num;
		document.getElementById(id).parentNode.setAttribute("class","active");
		document.getElementById("type").value=num;
	}
	function selectinterview(obj){
		document.getElementById("interviewtypediv").style.display="none";
		if(obj == "'0','1'"){
			document.getElementById("interviewtypediv").style.display="block";
			interviewreturn("你可与企业负责人进行沟通","与ta沟通");
			selecttype(7);
			document.getElementById('status').value = 1;
		}
		if(obj == 1){
			document.getElementById("interviewtypediv").style.display="block";
			interviewreturn("你可与企业负责人进行沟通","与ta沟通");
			selecttype(7);
			document.getElementById('status').value = obj;
		}
		if(obj == 2){
			document.getElementById("interviewtypediv").style.display="block";
			interviewreturn("你可与企业负责人进行沟通","与ta沟通");
			selecttype(7);
			document.getElementById("t7").style.display="block";
			document.getElementById("t8").style.display="none";
			document.getElementById("t9").style.display="none";
			document.getElementById('status').value = 1;
		}
		if(obj == 3){
			//document.getElementById('status').value = obj;
			interviewreturn("","可以在此处回复企业");
			document.getElementById('status').value = 1;
		}
		if(obj == 4){
			document.getElementById('status').value = obj;
			interviewreturn("","可以在此处回复企业");
			document.getElementById('status').value = 1;
		}
		if(obj == 5){
			document.getElementById('status').value = obj;
			interviewreturn("","回复HR");
		}
		if(obj == 6){
			document.getElementById('status').value = obj;
			interviewreturn("","回复HR");
		}
		if(obj == 7){
			document.getElementById("interviewtypediv").style.display="";
			interviewreturn("你可与企业负责人进行沟通","与ta沟通");
			selecttype(7);
			document.getElementById('status').value = 1;
		}
		if(obj == 8){
			document.getElementById("interviewtypediv").style.display="";
			interviewreturn("同意面试邀请后，顾问会协调安排面试时间","Hi，我周四或周五方便过来面试");
			selecttype(8);
			document.getElementById('status').value = 2;
		}
		if(obj == 9){
			document.getElementById("interviewtypediv").style.display="";
			interviewreturn("如果你对此邀请不满意，你可以拒绝企业邀请","你好，感谢邀请，对贵公司的职位不感兴趣...");
			//selecttype(9);
			document.getElementById('status').value = 6;
		}
		if(obj == "'4','5'"){
			document.getElementById("interviewtypediv").style.display="block";
			interviewreturn("你可与企业负责人进行沟通","与ta沟通");
			document.getElementById("t7").style.display="block";
			document.getElementById("t8").style.display="none";
			document.getElementById("t9").style.display="none";
			document.getElementById('status').value = 1;
		}
	}
</script>
<style>
	.getColor{
		background-color:#FFF;
		border:1px #999999 solid;
	}
	.getTdColor{
		background-color:#00B38A;
		cursor:pointer;
	}
	.getTdColor:focus{
		background-color:#FFF;
		}
	.getTdColor:hover{
		background-color:#FFF;
	}
</style>
<body onload="init()">
	<form id="returninterview">
		<input type="hidden" id="inviteId" name="inviteId"/>
		<input type="hidden" id="status" name="status" />
		<input type="hidden" id="interviewtype" name="interviewtype"/>
		<input type="hidden" id="type" name="type">
	</form>		
	<div class="getColor" style="width:100%;" id="header">
		<table style=" width: 100%;padding-top:5px;padding-left:50px;border-collapse:separate !important;">
			<tr>
				<td>
					<font size="3" style="font-weight:bold;" id="firmName"></font>
				</td>
				<td rowspan="5" width="150px" style="padding-top:5px;padding-left:10px;padding-bottom:5px;padding-right:10px;" id="firmLogo">
					<img src="" width="100px" height="100px"/>
				</td>
			</tr>
			<tr>
				<td class="textL"><font size="1" id="firmAddress"></font></td>
			</tr>
			<tr>
				<td class="textL"><font size="1" color="#999999">职位：</font><font size="1" id="firmJob"></font></td>
			</tr>
			<tr>
				<td class="textL"><font size="1" color="#999999">薪酬：</font><font size="1" id="firmMoney"></font></td>
			</tr>
			<tr>
				<td class="textL"><font size="1" color="#999999">期权/股权：</font><font size="1" id="firmQiQuan"></font></td>
			</tr>
			<tr>
				<td class="textL"><font size="1" color="#999999">公司简介：</font><font size="1" id="firmResume"></font></td>
			</tr>
			<tr height="20px"/>
		</table>
	</div>
	<div id="commit">
	</div>
</body>
</html>
 