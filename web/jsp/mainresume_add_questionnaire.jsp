<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<script language="javascript">
	var dataName;
	//头部
	function changeColor1(der){
		der.style.background="#999999";
	}
	function changeColor2(der){
		der.style.background="#000";
	}
	function init() {
		var url = "user/resumeAddQuestionnairePage1.do";
		var formId = "saveresumeAddQuestionnaireForm";
		var data = ajaxSumbit(url, formId);
		dataName = data.dataName;
		addli(data.moneytypeList,"money1");
		addli(data.moneytypeList,"money2");
		$("#saveresumeAddQuestionnaireForm").populateForm(data);
		var jobstatus = document.getElementById("jobstatus").value;
		if (jobstatus != "") {
			document.getElementById(jobstatus).setAttribute("class","circleA");
		}
		var intime = document.getElementById("intime").value;
		if (intime != "") {
			document.getElementById(intime).setAttribute("class","circleA");
		}
	}
	function jobId(job){
		if(job.getAttribute('class') == "icheckbox_square-green checked"){
			job.setAttribute("class","icheckbox_square-green hover");
		}
		else if(job.getAttribute('class') == "icheckbox_square-green hover"){
			job.setAttribute("class","icheckbox_square-green checked");
		}
	}
	function selected(obj){
		$(".circleA").each(function () {
			if(obj.id.indexOf('j') > -1 && this.id.indexOf('j') > -1){
				this.setAttribute("class","circleB");
			}
			if(obj.id.indexOf('i') > -1 && this.id.indexOf('i') > -1){
				this.setAttribute("class","circleB");
			}
		});
		obj.setAttribute("class","circleA");
		if(obj.id.indexOf('j') > -1){
			document.getElementById("jobstatus").value=obj.id;
		}
		if(obj.id.indexOf('i') > -1){
			document.getElementById("intime").value=obj.id;
		}
	}
	function addli(items,liId){
		var li1 = "";
		for(var i in items){
			li1 = li1 + "<li role='presentation'>"
						+"<a role='menuitem' tabindex='-1' href='#' onclick='"+liId+"(this)'><font color='#000'>"+items[i].value+"</font></a>"
						+"</li>";
		}
		document.getElementById(liId).innerHTML = li1;
	}
	function money1(obj){
		document.getElementById("nowmoneytype").value=obj.innerText;
	}
	function money2(obj){
		document.getElementById("planmoneytype").value=obj.innerText;
	}
	function moneysum(){
		var monthmoney = 0;
		var month = 0;
		if(document.getElementById("monthmoney").value != '' && document.getElementById("month").value != ''){
			monthmoney = document.getElementById("monthmoney").value
			month = document.getElementById("month").value
		}
		document.getElementById("summoney").innerText = "= "+monthmoney * month / 10000 +"万/年";
	}
	function getmsg(){
		var phone = document.getElementById("phone").value;
		var url = "register/getmsg1.do";
		if(phone == ""){
			alert("请输入手机号码!")
			return;
		}
		ajaxSumbitNoform(url,phone);
	}
	function goSubmit(){
		if(!checkValue()){
			return;
		}
		var url = "user/saveresumeAddQuestionnaire1.do";
		var formId = "saveresumeAddQuestionnaireForm";
		var data = ajaxSumbit(url, formId);
		if(data == "success"){
			top.location.href='examine_user.jsp';
		}else{
			alert("保存出错！");
		}
	}
	function booleanInfot(url){
		if(dataName == '1'){
			top.location.href=url;
		}else{
			alert("请先填写好您的简历信息！");
		}
	}
	function checkValue(){
		if(!checkInput('jobstatus',"求职状态","30",false)) return false;
		if(!checkInput('intime',"入职时间","30",false)) return false;
		if(!checkInput('nowmoneytype',"税前收入","30",false)) return false;
		if(!checkNum('monthmoney',"税前收入","30",false)) return false;
		if(!checkNum('month',"税前收入","30",false)) return false;
		if(!checkInput('planmoneytype',"最低税前年薪要求","30",false)) return false;
		if(!checkInput('planmoney',"最低税前年薪要求","30",false)) return false;
		if(!checkInput('offerRequestNextJob',"下一份工作的要求","130",false)) return false;
		return true;
	}
</script>
<body bgcolor="#F4F9F9" onload="init()">
	<div style="width:100%;height:55px;background: #000;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;">
		<table style="width:100%;white-space: nowrap;">
			<tr>
				<td width="270px" style="padding-left:150px;"><img src="../img/U-Offerlogo.png"></td>
				<td class="textC">
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('interview.jsp')">
				    	<font size="3">面试邀请</font>
				    </button>
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;"class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('resume_edit.jsp')">
				    	<font size="3">我的简历</font>
				    </button>
			    </td>
			    <td class="textC" width="270px">
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('personal_settings.jsp')">个人设置
				    </button>
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu4" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='login.jsp'">退出
				    </button>
				</td>
			</tr>
		</table>
	</div>
	<br />
	<br />
	<br />
	<center>
		<div style="width:600px;">
			<table width="100%">
				<tr>
					<td class="textC" style="padding-left:10px;padding-top:10px;padding-bottom:10px;width:25%;">
						<table>
							<tr>
								<td><div class="circleB"></div></td>
								<td><font color="#999999">&nbsp;&nbsp;基本信息 </font></td>
							</tr>
						</table>
					</td>
					<td class="textC" style="padding-left:10px;padding-top:10px;padding-bottom:10px;width:25%;">
						<table>
							<tr>
								<td><div class="circleB"></div></td>
								<td><font color="#999999">&nbsp;&nbsp;期望工作 </font></td>
							</tr>
						</table>
					</td>
					<td class="textC" style="padding-left:10px;padding-top:10px;padding-bottom:10px;width:25%;">
						<table>
							<tr>
								<td><div class="circleB"></div></td>
								<td><font color="#999999">&nbsp;&nbsp;个人经历 </font></td>
							</tr>
						</table>
					</td>
					<td class="textC" style="padding-left:10px;padding-top:10px;padding-bottom:10px;width:25%;">
						<table>
							<tr>
								<td><div class="circleA"></div></td>
								<td><font color="#00B38A">&nbsp;&nbsp;调查问卷 </font></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div style="background: #FFFFFF; width: 600px;padding-top:20px;padding-bottom:20px;">
			<center><font size="3" color="#666666">最后一步，谈谈您对新工作的要求吧！</font></center>
		</div>
		<div style="height: 2px; width: 600px; background-color: #999999;"></div>
		<form id="saveresumeAddQuestionnaireForm">
		<div style="background: #FFFFFF; width: 600px;">
			<br />
			<table
				style="border-collapse: separate; border-spacing: 10px; width: 100%; padding-left:30px;">
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#666666">您目前的求职状态是？*</font>
						<input type="hidden" id="jobstatus" name="jobstatus"/>
					</th>
				</tr>
				<tr>
					<td class="textL">
						<table style="border-collapse:separate; border-spacing:0px 10px;">
							<tr>
								<td><div class="circleB" id="j1" onclick="selected(this)" style="cursor:pointer;"></div></td>
								<td><font color="#666666" size="1">&nbsp;不着急找工作，先看看机会</font></td>
							</tr>
							<tr>
								<td><div class="circleB" id="j2" onclick="selected(this)" style="cursor:pointer;"></div></td>
								<td><font color="#666666" size="1">&nbsp;已经有offer了，想看更好的</font></td>
							</tr>
							<tr>
								<td><div class="circleB" id="j3" onclick="selected(this)" style="cursor:pointer;"></div></td>
								<td><font color="#666666" size="1">&nbsp;正在找工作，还没有offer</font></td>
							</tr>
							<tr>
								<td><div class="circleB" id="j4" onclick="selected(this)" style="cursor:pointer;"></div></td>
								<td><font color="#666666" size="1">&nbsp;暂时不考虑换工作</font></td>
							</tr>
						</table>
					</td>
					<td/>
				</tr>
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#666666">如果找到合适的工作，您预计多久可以入职？*</font>
						<input type="hidden" id="intime" name="intime"/>
					</th>
				</tr>
				<tr>
					<td colspan="2">
						<table width="100%">
							<tr height="20px">
								<td class="textR" width="5%"><div class="circleB" id="i1" onclick="selected(this)" style="cursor:pointer;"></div></td>
								<td class="textL" width="45%"><font color="#666666" size="1">&nbsp;目前是离职状态，随时可以入职</font></td>
								<td class="textR" width="5%"><div class="circleB" id="i2" onclick="selected(this)" style="cursor:pointer;"></div></td>
								<td class="textL" width="45%"><font color="#666666" size="1">&nbsp;一周</font></td>
							</tr>
							<tr height="20px">
								<td class="textR"><div class="circleB" id="i3" onclick="selected(this)" style="cursor:pointer;"></div></td>
								<td class="textL"><font color="#666666" size="1">&nbsp;一个月</font></td>
								<td class="textR"><div class="circleB" id="i4" onclick="selected(this)" style="cursor:pointer;"></div></td>
								<td class="textL"><font color="#666666" size="1">&nbsp;不确定</font></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#666666">您目前的税前收入是？*</font>
					</th>
				</tr>
				<tr>
					<td colspan="2">
						<table width="100%">
							<tr>
								<td width="25%">
									<div class="input-group" style="margin-left:-10px !important;width: 135px !important">
										<div class="dropdown" style="">
											<input type="text" id="nowmoneytype" name="nowmoneytype" readOnly="readOnly" class="form-control" style="width: 80px !important">
										    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
										        <span class="caret"></span>
										    </button>
										    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 20px !important" id="money1">
										        
										    </ul>
										</div>
									</div>
								</td>
								<td width="25%">
									<div class="input-group">
										<input type="text" name="monthmoney" id="monthmoney" onchange="moneysum()" class="form-control" style="width: 80px !important"><span class="input-group-addon">每月</span>
									</div>
								</td>
								<td class="textC" width="5%">X</td>
								<td width="25%">
									<div class="input-group">
										<input type="text" name="month" id="month" onchange="moneysum()" class="form-control" style="width: 80px !important"><span class="input-group-addon">月</span>
									</div>
								</td>
								<td id="summoney">= 0 万/年</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#666666">您对下一份工作的最低税前年薪要求是？*</font>
					</th>
				</tr>
				<tr>
					<td>
						<table>
							<tr>
								<td>
									<div class="input-group" style="margin-left:-10px !important;width: 135px !important">
										<div class="dropdown">
											<input type="text" readOnly="readOnly" id="planmoneytype" name="planmoneytype" class="form-control" style="width: 80px !important">
										    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
										        <span class="caret"></span>
										    </button>
										    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 20px !important" id="money2">
										    </ul>
										</div>
									</div>
								</td>
								<td>
									<div class="input-group">
										<input type="text" id="planmoney" name="planmoney" class="form-control" style="width: 80px !important"><span class="input-group-addon">万/年</span>
									</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#666666">您对下一份工作的要求是？*</font>
					</th>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="8" name="offerRequestNextJob" id="offerRequestNextJob" style="width:90%;"></textarea>
					</td>
				</tr>
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#666666">请验证您的手机号码？*</font>
					</th>
				</tr>
				<tr>
					<td>
						<div class="col-lg-6">
							<div class="input-group" style="width: 250% !important; margin-left: -22px !important;">
								<input type="text" id="phone" class="form-control" style="width: 180px !important">
								<button type="button" class="btn btn-default">获取验证码</button>
							</div>
						</div>
					</td>
					<td/>
				</tr>
				<tr>
					<td class="textL" colspan="2">
						<input type="text" name="inputCode" class="form-control" style="width: 180px !important">
					</td>
				</tr>
				<tr height="10px"/>
			</table>
		</div>
		</form>
		<div style="height: 2px; width: 600px; background-color: #999999;"></div>
		<div style="width: 600px; background-color: #FFF;">
			<table>
				<tr>
					<td style="padding-top:40px;padding-bottom:40px;" class="textC">
						<button type="button" class="btn btn-primary" onclick="javascript:top.location.href='resume_add_workexperience.jsp';" data-toggle="button"
							style="color: #000 !important;background-color: #999999 !important; border-color: #999999 !important; width: 200px;">
							上一步</button>
						<button type="button" class="btn btn-primary" onclick="goSubmit()" data-toggle="button"
							style="color: #00B38A !important;background-color: #FFF !important; border-color: #00B38A !important; width: 200px;">
							提交资料</button>
					</td>
				</tr>
			</table>
		</div>
	</center>
	<br/>
	<br/>
</body>
</html>
