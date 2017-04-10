<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <%@include file="/common/header.jsp"%> --%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- <link href="../css/bootstrap.css" rel="stylesheet" /> -->
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/bootstrap-datetimepicker.css" rel="stylesheet" />
<link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
</head>
<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="../js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="../js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="../js/ajaxSubmit.js" type="text/javascript"></script>
<script language="javascript">
	var dataName;
	//头部
	function changeColor1(der){
		der.style.background="#CCCCCC";
	}
	function changeColor2(der){
		der.style.background="#32373C";
	}
	function init() {
		if(isResetLogin()) {
			alert("登陆超时!");
			top.location.href='login.jsp';
		}
		else{
			var url = "user/resumeAddWorkexperiencePage1.do";
			var data = ajaxSumbitNoform(url, "111");
			dataName = data.dataName;
			addmsgDivEdus(data.otherEducate);
			addmsgDivWorks(data.otherWorks);
			$("#resumeAddWorkexperienceForm1").populateForm(data);
			$("#resumeAddWorkexperienceForm2").populateForm(data);
			$(".form_datetime2").datetimepicker({
		        format: "yyyy-mm",
		        autoclose:true,
		        startView: 'year',
		        minView:'year',
		        maxView:'decade',
		        language:'zh-CN'
		    });
		}
	}
	function saveDataWork(ispass) {
		if (ispass) {
			if(!checkValueWork()) return;
			if(checkToNow('work')) return;
			var url = "user/saveresumeAddWorkexperience1.do";
			var formId = "resumeAddWorkexperienceForm1";
			var data = ajaxSumbit(url, formId);
			if(data == 'error'){
				alert('保存错误！');
			}
			else {
				document.getElementById("reset1").click();
				document.getElementById("offerUserWorksId").value = "";
				addmsgDivWorks(data.otherWorks);
			}
		}
		else {
			document.getElementById("offerUserWorksId").value = "";
			document.getElementById("reset1").click();
		}
	}
	function saveDataEdu(ispass) {
		if (ispass) {
			if(!checkValueEdu()) return;
			if(checkToNow('edu')) return;
			var url = "user/saveresumeAddWorkexperience2.do";
			var formId = "resumeAddWorkexperienceForm2";
			var data = ajaxSumbit(url, formId);
			if(data == 'error'){
				alert('保存错误！');
			}
			else {
				document.getElementById("reset2").click();
				document.getElementById("offerUserEducationId").value = "";
				addmsgDivEdus(data.otherEducate);
			}
		}
		else {
			document.getElementById("offerUserEducationId").value = "";
			document.getElementById("reset2").click();
		}
	}
	function resetOne(ispass){
		if(ispass){
			if(confirm("要保存数据吗？")){
				var url = "user/saveresumeAddWorkexperience1.do";
				var formId = "resumeAddWorkexperienceForm1";
				var data = ajaxSumbit(url, formId);
			}
		}
		document.getElementById("offerUserWorksId").value = "";
		document.getElementById("reset1").click();
	}
	function resetTwo(ispass){
		if(ispass){
			if(confirm("要保存数据吗？")){
				var url = "user/saveresumeAddWorkexperience2.do";
				var formId = "resumeAddWorkexperienceForm2";
				var data = ajaxSumbit(url, formId);
			}
		}
		document.getElementById("offerUserEducationId").value = "";
		document.getElementById("reset2").click();
	}
	function goSumbit(){
		if (checkValueWorkKuang() || checkValueEduKuang()) {
			var data1;
			var data2;
			if (checkValueWorkKuang()) {
				if(!checkValueWork()) return;
				var url = "user/saveWork.do";
				var formId = "resumeAddWorkexperienceForm1";
				data1 = ajaxSumbit(url, formId);
			}
			if (checkValueEduKuang()) {
				if(!checkValueEdu()) return;
				var url = "user/saveEdu.do";
				var formId = "resumeAddWorkexperienceForm2";
				data2 = ajaxSumbit(url, formId);
			}
			if (data1 == 'success' && data2 == 'success'){
				top.location.href='resume_add_questionnaire.jsp';
			}
			else {
				if (data1 == undefined || data2 == undefined) {
					top.location.href='resume_add_questionnaire.jsp';
				}
				else {
					alert("保存错误");
				}
			}
		}
		else {
			top.location.href='resume_add_questionnaire.jsp';
		}
	}
	function booleanInfot(url){
		if(dataName == '1'){
			top.location.href=url;
		}else{
			alert("请先填写好您的简历信息！");
		}
	}
	function checkValueWork(){
		if(!checkInput('firmName',"公司名称","30",false)) return false;
		if(!checkInput('jobName',"职位名称","30",false)) return false;
		if(!checkInput('jobstart',"开始","30",false)) return false;
		return true;
	}
	function checkValueEdu(){
		if(!checkInput('schoolName',"学校名称","30",false)) return false;
		if(!checkInput('xueli',"学历","30",false)) return false;
		if(!checkInput('studstart',"开始","30",false)) return false;
		return true;
	}
	function addmsgDivEdus(items){
		var div1 = "";
		var j = 0;
		for(var i in items){
			div1 = div1 + "<div style='width:100%' onmouseover='appacerdivEdus(this)' id='edus_"+i+"' style='min-height:75px;'>"
							+"<table width='100%' id=''>"
								+"<tr height='30px'/>"
								+"<tr>"
									+"<th width='55%'>"
										+"<font color='#4F4F4F' style='font-size:14px;' >"+items[i].schoolName+"</font>"
									+"</th>"
									+"<td class='textC' valign='top' style='padding-top:5px;'>"
										+"<font color='#4F4F4F' style='font-size:14px;' >"+items[i].studstart +"~"+items[i].studend+"</font>"
									+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td>"
										+"<font color='#4F4F4F' style='font-size:14px;' >"+items[i].xueli +"</font>"
									+"</td>"
									+"<td/>"
								+"</tr>"
								+"<tr>"
									+"<td>"
										+"<font color='#4F4F4F' style='font-size:14px;' >"+items[i].zhuanye +"</font>"
									+"</td>"
									+"<td/>"
								+"</tr>"
							+"</table>"
						+"</div>"
						+"<div style='width:100%;z-index:9999;display:none;' onmouseout='displaydiv(this)' id='eEdus_" + i + "'>"
							+"<table width='100%' style='height:100%;'>"
								+"<tr>"
									+"<td width='90%'/>"
									+"<td width='100px'>"
										+"<button type='button' class='btn btn-primary' data-toggle='button' id='delEdus_"+items[i].thisId+"' onclick='delEdu(this)'"
										+"style='font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;'>"
										+"删除"
										+"</button>"
									+"</td>"
									+"<td width='100px'>"
										+"<button type='button' class='btn btn-primary' data-toggle='button' id='editEdus_"+items[i].thisId+"' onclick='editEdu(this)'"
										+"style='font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;'>"
										+"编辑"
										+"</button>"
									+"</td>"
									+"<td width='3%'/>"
								+"</tr>"
							+"</table>"
						+"</div>";
		}
		document.getElementById("msgDivEdus").innerHTML=div1;
	}
	function addmsgDivWorks(items){
		var div1 = "";
		var j = 0;
		for(var i in items){
			div1 = div1 + "<div style='width:100%' onmouseover='appacerdivWorks(this)' id='works_"+i+"' style='min-height:75px;'>"
							+"<table width='100%' id=''>"
								+"<tr height='30px'/>"
								+"<tr>"
									+"<th width='55%'>"
										+"<font color='#4F4F4F' style='font-size:14px;' >"+items[i].firmName+"</font>"
									+"</th>"
									+"<td class='textC' valign='top' style='padding-top:5px;'>"
										+"<font color='#4F4F4F' style='font-size:14px;' >"+items[i].jobstart+"~"+items[i].jobend+"</font>"
									+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td>"
										+"<font color='#4F4F4F' style='font-size:14px;' >"+items[i].jobName+"</font>"
									+"</td>"
									+"<td/>"
								+"</tr>"
								+"<tr>"
									+"<td>"
										+"<font color='#4F4F4F' style='font-size:14px;' >"+items[i].workcontent+"</font>"
									+"</td>"
									+"<td/>"
								+"</tr>"
							+"</table>"
						+"</div>"
						+"<div style='width:100%;z-index:9999;display:none;' onmouseout='displaydiv(this)' id='eWorks_"+i+"'>"
							+"<table width='100%' style='height:100%;'>"
								+"<tr>"
									+"<td width='90%'/>"
									+"<td width='100px'>"
										+"<button type='button' class='btn btn-primary' data-toggle='button' id='delWorks_"+items[i].thisId+"' onclick='delWork(this)'"
										+"style='font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;'>"
										+"删除"
										+"</button>"
									+"</td>"
									+"<td width='100px'>"
										+"<button type='button' class='btn btn-primary' data-toggle='button' id='editWorks_"+items[i].thisId+"' onclick='editWork(this)'"
										+"style='font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;'>"
										+"编辑"
										+"</button>"
									+"</td>"
									+"<td width='3%'/>"
								+"</tr>"
							+"</table>"
						+"</div>";
		}
		document.getElementById("msgDivWorks").innerHTML=div1;
	}
	function appacerdivEdus(obj){
		obj.style.height=obj.offsetHeight;
		var id = "eEdus_"+obj.id.split('_')[1];
		document.getElementById(id).style.display="";
		if(document.getElementById(id).style.heigh != undefined){
			return;
		}
		document.getElementById(id).style.height=obj.offsetHeight-30;
		document.getElementById(id).style.marginTop=0-obj.offsetHeight+30 +"px";
	}
	function appacerdivWorks(obj){
		obj.style.height=obj.offsetHeight;
		var id = "eWorks_"+obj.id.split('_')[1];
		document.getElementById(id).style.display="";
		if(document.getElementById(id).style.heigh != undefined){
			return;
		}
		document.getElementById(id).style.height=obj.offsetHeight-30;
		document.getElementById(id).style.marginTop=0-obj.offsetHeight+30 +"px";
	}
	function displaydiv(obj){
		obj.style.display="none";
	}
	function delWork(obj) {
		if(confirm("真的要删除吗？")) {
			document.getElementById('offerUserWorksId').value = obj.id.split('_')[1];
			var url = "user/delWork.do";
			var formId = "resumeAddWorkexperienceForm1";
			var data2 = ajaxSumbit(url, formId);
			if(data2 == 'success'){
				init();
			}
			else {
				alert("操作失败！");
			}
		}
	}
	function delEdu(obj) {
		if(confirm("真的要删除吗？")) {
			document.getElementById('offerUserEducationId').value = obj.id.split('_')[1];
			var url = "user/delEducation.do";
			var formId = "resumeAddWorkexperienceForm2";
			var data2 = ajaxSumbit(url, formId);
			if(data2 == 'success'){
				init();
			}
			else {
				alert("操作失败！");
			}
		}
	}
	/* function checkDate(str, start, end, name) {
		var flag = false;
		var date = new Date;
		var year = date.getFullYear(); 
		var month = date.getMonth()+1;
		if (str == 'check') {
			if (start.split('-')[0] > year) {
				alert(name + "开始年份大于结束年份！");
				flag = true;
			}
			else if (start.split('-')[0] == year) {
				if (start.split('-')[1] > month) {
					alert(name + "开始月份大于结束月份！");
					flag = true;
				}
			}
		}
		else {
			if (start.split('-')[0] > end.split('-')[0]) {
				alert(name + "开始年份大于结束年份！");
				flag = true;
			}
			else if (start.split('-')[0] == end.split('-')[0]) {
				if (start.split('-')[1] > end.split('-')[1]) {
					alert(name + "开始月份大于结束月份！");
					flag = true;
				}
			}
		}
		return flag;
	}
	function checkToNow(str) {
		if (str == 'work') {
			var jobstart = document.getElementById("jobstart").value;
			var jobend = document.getElementById("jobend").value;
			if (document.getElementById("toNowWork").checked == true) {
				document.getElementById("toNow1").value = "true";
				return checkDate("check", jobstart, "", "工作");
			}
			else {
				document.getElementById("toNow1").value = "false";
				return checkDate("noCheck", jobstart, jobend, "工作");
			}
		}
		else {
			var studstart = document.getElementById("studstart").value;
			var studend = document.getElementById("studend").value;
			if (document.getElementById("toNowEdu").checked == true) {
				document.getElementById("toNow2").value = "true";
				return checkDate("check", studstart, "", "教育");
			}
			else {
				document.getElementById("toNow2").value = "false";
				return checkDate("noCheck", studstart, studend, "教育");
			}
		}
	} */
	function editWork(obj) {
		if (checkValueWorkKuang()) {
			if(confirm("是否先保存下面的数据？")) {
				if(!checkValueWork()) return;
				if(checkToNow('work')) return;
				var url = "user/saveresumeAddWorkexperience1.do";
				var formId = "resumeAddWorkexperienceForm1";
				var data = ajaxSumbit(url, formId);
			}
		}
		document.getElementById("reset1").click();
		document.getElementById("offerUserWorksId").value = obj.id.split('_')[1];
		var url = "user/getNowWork.do";
		var formId = "resumeAddWorkexperienceForm1";
		var data = ajaxSumbit(url, formId);
		addmsgDivWorks(data.otherWorks);
		$("#resumeAddWorkexperienceForm1").populateForm(data);
	}
	function editEdu(obj) {
		if (checkValueEduKuang()) {
			if(confirm("是否先保存下面的数据？")) {
				if(!checkValueEdu()) return;
				if(checkToNow('edu')) return;
				var url = "user/saveresumeAddWorkexperience2.do";
				var formId = "resumeAddWorkexperienceForm2";
				var data2 = ajaxSumbit(url, formId);
			}
		}
		document.getElementById("reset2").click();
		document.getElementById("offerUserEducationId").value = obj.id.split('_')[1];
		var url = "user/getNowEducation.do";
		var formId = "resumeAddWorkexperienceForm2";
		var data = ajaxSumbit(url, formId);
		addmsgDivEdus(data.otherEducate);
		$("#resumeAddWorkexperienceForm2").populateForm(data);
	}
	function checkValueWorkKuang() {
		var flag = false;
		var strings = "firmName,jobName,jobstart,jobend,workcontent";
		for (var i in strings.split(',')) {
			if (document.getElementById(strings.split(',')[i]).value != "") {
				flag = true;
				break;
			}
		}
		return flag;
	}
	function goAddWorks() {
		if (!checkValueWorkKuang()) return;
		if (confirm("是否先保存下面的数据？")) {
			if(!checkValueWork()) return;
			if(checkToNow('work')) return;
			var url = "user/saveresumeAddWorkexperience1.do";
			var formId = "resumeAddWorkexperienceForm1";
			var data2 = ajaxSumbit(url, formId);
		}
		document.getElementById("reset1").click();
		document.getElementById("offerUserWorksId").value = "";
		var url = "user/getNewWork.do";
		var formId = "resumeAddWorkexperienceForm1";
		var data = ajaxSumbit(url, formId);
		addmsgDivWorks(data.otherWorks);
	}
	function checkValueEduKuang() {
		var flag = false;
		var strings = "schoolName,xueli,studstart,studend,zhuanye";
		for (var i in strings.split(',')) {
			if (document.getElementById(strings.split(',')[i]).value != "") {
				flag = true;
				break;
			}
		}
		return flag;
	}
	function goAddEdus() {
		if (!checkValueEduKuang()) return;
		if (confirm("是否先保存下面的数据？")) {
			if(!checkValueEdu()) return;
			if(checkToNow('edu')) return;
			var url = "user/saveresumeAddWorkexperience2.do";
			var formId = "resumeAddWorkexperienceForm2";
			var data2 = ajaxSumbit(url, formId);
		}
		document.getElementById("reset2").click();
		document.getElementById("offerUserEducationId").value = "";
		var url = "user/getNewEducation.do";
		var formId = "resumeAddWorkexperienceForm2";
		var data = ajaxSumbit(url, formId);
		addmsgDivEdus(data.otherEducate);
	}
</script>
<body bgcolor="#F4F9F9" onload="init()">
	<div style="width:100%;height:55px;min-width:1000px;background: #32373C;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;">
		<table style="width:100%;white-space: nowrap;">
			<tr>
				<td width="270px" style="padding-left:150px;"><img src="../img/U-Offerlogo.png"></td>
				<td class="textC">
				    <button type="button" style="font-size:14px;height:55px !important;width:100px !important;color:#F5F8F9;background-color:#32373C;" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('interview.jsp')">
				    	<font>面试邀请</font>
				    </button>
				    <button type="button" style="font-size:14px;height:55px !important;width:100px !important;color:#F5F8F9;background-color:#32373C;"class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('resume_edit.jsp')">
				    	<font>我的简历</font>
				    </button>
			    </td>
			    <td class="textC" width="270px">
				    <button type="button" style="font-size:14px;height:55px !important;width:100px !important;color:#F5F8F9;background-color:#32373C;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('personal_settings.jsp')">个人设置
				    </button>
				    <button type="button" style="font-size:14px;height:55px !important;width:100px !important;color:#F5F8F9;background-color:#32373C;" class="btn dropdown-toggle" id="dropdownMenu4" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='login.jsp'">退出
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
								<td><div class="circleA"></div></td>
								<td><font color="#00B38A">&nbsp;&nbsp;个人经历 </font></td>
							</tr>
						</table>
					</td>
					<td class="textC" style="padding-left:10px;padding-top:10px;padding-bottom:10px;width:25%;">
						<table>
							<tr>
								<td><div class="circleB"></div></td>
								<td><font color="#999999">&nbsp;&nbsp;调查问卷 </font></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div style="background: #FFFFFF; width: 600px;padding-top:20px;padding-bottom:20px;">
			<center><font size="3" color="#666666">您在哪里工作和学习过？</font></center>
		</div>
		<div style="height: 2px; width: 600px; background-color: #999999;"></div>
		<div style="background: #FFFFFF; width: 600px;">
			<br />
			<form id="resumeAddWorkexperienceForm1">
			<table
				style="border-collapse: separate; border-spacing: 10px; width: 100%; padding-left:30px;">
				<tr>
					<th class="textL">
						<font size="1" color="#666666">工作经历*</font>
					</th>
					<td class="textR" style="padding-right:30px;">
						<a href="#" onclick="goAddWorks()"><font size="1" color="#00B389">新增</font></a>
					</td>
				</tr>
				<tr>
					<td colspan="2" id="msgDivWorks">
					</td>
				</tr>
				<tr>
					<td class="textL" colspan="2">
						<font size="1" color="#666666">公司名称</font>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="firmName" id="firmName" class="form-control" style="width: 75% !important">
						<input id="offerUserWorksId" type="hidden" name="offerUserWorksId"/>
					</td>
				</tr>
				<tr>
					<td class="textL" colspan="2">
						<font size="1" color="#666666">职位名称</font>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="jobName" id="jobName" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr>
					<td class="textL" colspan="2">
						<font size="1" color="#666666">在职时间</font>
					</td>
				</tr>
				<tr>
					<td class="textL" width="45%">
						<table width="100%">
							<tr>
								<td class="textR">
									<font size="1" color="#666666">开始</font>
								</td>
								<!-- <td class="textL">
									<input type="text" name="jobstart" id="jobstart" class="form-control" style="width: 75% !important;">
								</td> -->
								<td>
									<div class='input-append date form_datetime2'>
										<input size='16' type='text' value='' class='date-control form-control' style="width: 75% !important;" readonly name='jobstart' id='jobstart'>
									    <span class='add-on'><i class='icon-th'></i></span>
									</div>
								</td>
							</tr>
						</table>
					</td>
					<td class="textL" width="55%">
						<table width="100%">
							<tr>
								<td class="textR">
									<font size="1" color="#666666">结束</font>
								</td>
								<!-- <td class="textL">
									<input type="text" id="jobend" name="jobend" class="form-control" style="width: 75% !important;">
								</td> -->
								<td>
									<div class='input-append date form_datetime2'>
										<input size='16' type='text' value='' class='date-control form-control' style="width: 75% !important;" readonly name='jobend' id='jobend'>
									    <span class='add-on'><i class='icon-th'></i></span>
									</div>
								</td>
								<td class="textL">
									<input type="hidden" id="toNow1" name="toNow1"/>
									<input type="checkbox" id="toNowWork" name="toNowWork"/><font size="1">至今</font>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="textL" colspan="2">
						<font size="1" color="#666666">工作内容</font>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea rows="8" style="width:90%;" id="workcontent" name="workcontent"></textarea>
					</td>
				</tr>
				<tr>
					<td/>
					<td class="textR">
						<input type="reset" name="reset1" id="reset1" style="display: none;" />
						<button type="button" class="btn btn-primary" onclick="saveDataWork(false)" data-toggle="button"
							style="background-color: #999999 !important; border-color: #999999 !important; width: 100px;">
							取消</button>
						<button type="button" class="btn btn-primary" onclick="saveDataWork(true)" data-toggle="button"
										style="background-color: #00B38A !important; border-color: #00B38A !important; width: 100px;">
										保存</button>
					</td>
				</tr>
			</table>
			</form>
			<form id="resumeAddWorkexperienceForm2">
			<table style="border-collapse: separate; border-spacing: 10px; width: 100%; padding-left:30px;">
				<tr height="20px"/>
				<tr>
					<th class="textL">
						<font size="1" color="#666666">教育经历*</font>
						<input id="offerUserEducationId" type="hidden" name="offerUserEducationId"/>
					</th>
					<td class="textR" style="padding-right:30px;">
						<a href="#" onclick="goAddEdus()"><font size="1" color="#00B389">新增</font></a>
					</td>
				</tr>
				<tr>
					<td colspan="2" id="msgDivEdus">
					</td>
				</tr>
				<tr>
					<td class="textL" colspan="2">
						<font size="1" color="#666666">学校名称</font>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" id="schoolName" name="schoolName" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr>
					<td class="textL" colspan="2">
						<font size="1" color="#666666">学历</font>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" id="xueli" name="xueli" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr>
					<td class="textL" colspan="2">
						<font size="1" color="#666666">就读时间</font>
					</td>
				</tr>
				<tr>
					<td class="textL" width="45%">
						<table width="100%">
							<tr>
								<td class="textR">
									<font size="1" color="#666666">开始</font>
								</td>
								<!-- <td class="textL">
									<input type="text" id="studstart" name="studstart" class="form-control" style="width: 75% !important;">
								</td> -->
								<td>
									<div class='input-append date form_datetime2'>
										<input size='16' type='text' value='' class='date-control form-control' style="width: 75% !important;" readonly name='studstart' id='studstart'>
									    <span class='add-on'><i class='icon-th'></i></span>
									</div>
								</td>
							</tr>
						</table>
					</td>
					<td class="textL" width="55%">
						<table width="100%">
							<tr>
								<td class="textR">
									<font size="1" color="#666666">结束</font>
								</td>
								<!-- <td class="textL">
									<input type="text" id="studend" name="studend" class="form-control" style="width: 75% !important;">
								</td> -->
								<td>
									<div class='input-append date form_datetime2'>
										<input size='16' type='text' value='' class='date-control form-control' style="width: 75% !important;" readonly name='studend' id='studend'>
									    <span class='add-on'><i class='icon-th'></i></span>
									</div>
								</td>
								<td class="textL">
									<input type="hidden" id="toNow2" name="toNow2"/>
									<input type="checkbox" id="toNowEdu" name="toNowEdu"/><font size="1">至今</font>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="textL" colspan="2">
						<font size="1" color="#666666">专业</font>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" id="zhuanye" name="zhuanye" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr>
					<td/>
					<td class="textR">
						<input type="reset" name="reset2" id="reset2" style="display: none;" />
						<button type="button" class="btn btn-primary" onclick="saveDataEdu(false)" data-toggle="button"
							style="background-color: #999999 !important; border-color: #999999 !important; width: 100px;">
							取消</button>
						<button type="button" class="btn btn-primary" onclick="saveDataEdu(true)" data-toggle="button"
										style="background-color: #00B38A !important; border-color: #00B38A !important; width: 100px;">
										保存</button>
					</td>
				</tr>
				<tr height="20px"/>
				<tr>
					<td colspan="2" class="textC">
						<button type="button" class="btn btn-primary" onclick="validateCode()" data-toggle="button"
							style="color: #00B38A !important;background-color: #FFF !important; border-color: #00B38A !important; width: 300px;">
							上传简历，自动解析</button>
					</td>
				</tr>
			</table>
			</form>
			<br />
			<br />
		</div>
		<div style="height: 2px; width: 600px; background-color: #999999;"></div>
		<div style="width: 600px; background-color: #FFF;">
			<table>
				<tr>
					<td style="padding-top:40px;padding-bottom:40px;" class="textC">
						<button type="button" class="btn btn-primary" onclick="javascript:top.location.href='resume_add_planjob.jsp'" data-toggle="button"
							style="color: #000 !important;background-color: #999999 !important; border-color: #999999 !important; width: 200px;">
							上一步</button>
						<button type="button" class="btn btn-primary" onclick="goSumbit()" data-toggle="button"
							style="color: #FFF !important;background-color: #00B38A !important; border-color: #00B38A !important; width: 200px;">
							下一步</button>
					</td>
				</tr>
			</table>
		</div>
	</center>
	<br/>
	<br/>
</body>
</html>
