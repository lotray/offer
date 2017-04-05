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
	function init(){
		var url = "user/resumeedit5.do";
		var formId = "resumeAddWorkexperienceForm2";
		var data = ajaxSumbit(url, formId);
		addmsgDiv(data.otherEducate);
		$("#resumeAddWorkexperienceForm2").populateForm(data);
	}
	function saveData() {
		checkToNow();
		if(!checkValue()) return;
		var url = "user/saveresumeAddWorkexperience2.do";
		var formId = "resumeAddWorkexperienceForm2";
		var data = ajaxSumbit(url, formId);
		if(data == 'error'){
			alert('保存错误！');
		}
		else {
			alert('保存成功！');
			document.getElementById('offerUserEducationId').value = data.offerUserEducationId;
		}
	}
	function test(){
		init();
		parent.document.getElementById("main1").height=0;
		parent.document.getElementById("main1").height=document.body.scrollHeight;
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
	function addmsgDiv(items){
		var div1 = "";
		var j = 0;
		for(var i in items){
			div1 = div1 + "<div style='width:100%' onmouseover='appacerdiv(this)' id='d"+i+"' style='min-height:75px;'>"
							+"<table width='100%' id='editMsg'>"
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
						+"<div style='width:100%;z-index:9999;display:none;' onmouseout='displaydiv(this)' id='e" + i + "'>"
							+"<table width='100%' style='height:100%;'>"
								+"<tr>"
									+"<td width='90%'/>"
									+"<td width='100px'>"
										+"<button type='button' class='btn btn-primary' data-toggle='button' id='del_"+items[i].thisId+"' onclick='delEdu(this)'"
										+"style='font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;'>"
										+"删除"
										+"</button>"
									+"</td>"
									+"<td width='100px'>"
										+"<button type='button' class='btn btn-primary' data-toggle='button' id='edit_"+items[i].thisId+"' onclick='editEdu(this)'"
										+"style='font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;'>"
										+"编辑"
										+"</button>"
									+"</td>"
									+"<td width='3%'/>"
								+"</tr>"
							+"</table>"
						+"</div>";
		}
		document.getElementById("msgDiv").innerHTML=div1;
	}
	function delEdu(obj) {
		if(confirm("真的要删除吗？")) {
			document.getElementById('offerUserEducationId').value = obj.id.split('_')[1];
			var url = "user/delEducation.do";
			var formId = "resumeAddWorkexperienceForm2";
			var data2 = ajaxSumbit(url, formId);
			if(data2 == 'success'){
				parent.document.getElementById("mainFrame").src = "edit_resume5.jsp";
			}
			else {
				alert("操作失败！");
			}
		}
	}
	function checkValue() {
		if(!checkInput('schoolName',"学校名称","100",false)) return false;
		if(!checkInput('xueli',"学历","30",false)) return false;
		if(!checkInput('studstart',"开始时间","10",false)) return false;
		if(!checkInput('studend',"结束时间","10",false)) return false;
		return true;
	}
	function checkToNow() {
		if (document.getElementById("toNow1").checked == true) {
			document.getElementById("toNow").value = "true";
		}
		else {
			document.getElementById("toNow").value = "false";
		}
	}
	function editEdu(obj) {
		if(confirm("是否先保存下面的数据？")) {
			checkToNow();
			if(!checkValue()) return;
			var url = "user/saveresumeAddWorkexperience2.do";
			var formId = "resumeAddWorkexperienceForm2";
			var data2 = ajaxSumbit(url, formId);
		}
		document.getElementById("reset1").click();
		document.getElementById("offerUserEducationId").value = obj.id.split('_')[1];
		var url = "user/getNowEducation.do";
		var formId = "resumeAddWorkexperienceForm2";
		var data = ajaxSumbit(url, formId);
		addmsgDiv(data.otherEducate);
		$("#resumeAddWorkexperienceForm2").populateForm(data);
	}
	function goAdd() {
		if(confirm("是否先保存下面的数据？")) {
			checkToNow();
			if(!checkValue()) return;
			var url = "user/saveresumeAddWorkexperience2.do";
			var formId = "resumeAddWorkexperienceForm2";
			var data2 = ajaxSumbit(url, formId);
		}
		document.getElementById("reset1").click();
		document.getElementById("offerUserEducationId").value = "";
		var url = "user/getNewEducation.do";
		var formId = "resumeAddWorkexperienceForm2";
		var data = ajaxSumbit(url, formId);
		addmsgDiv(data.otherEducate);
	}
	function appacerdiv(obj){
		obj.style.height=obj.offsetHeight;
		var id = "e"+obj.id.substring(1,2);
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
</script>
<body bgcolor="#FFF" onload="test()">
	<div style="width:100%;">
		<form id="resumeAddWorkexperienceForm2">
			<table width="100%">
				<tr height="49px"/>
				<tr>
					<td width="40px"/>
					<td width="54%">
						<font style="font-size:20px;" color="#4F4F4F">教育经历</font>
						<input id="offerUserEducationId" type="hidden" name="offerUserEducationId"/>
					</td>
					<td class="textC">
						<button type="button" class="btn btn-primary" data-toggle="button" onclick="goAdd()"
							style="font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;">
							新增
						</button>
					</td>
					<td/>
				</tr>
				<tr>
					<td/>
					<td colspan="2" style="position: relative;" id="msgDiv">
						<!-- <div style="width:100%" onmouseover="appacerdiv(this)" style="min-height:75px;">
							<table width="100%" id="editMsg">
								<tr height="30px"/>
								<tr>
									<th width="55%">
										<font color="#4F4F4F" style="font-size:14px;" >深圳腾讯</font>
									</th>
									<td class="textC" valign="top" style="padding-top:5px;">
										<font color="#4F4F4F" style="font-size:14px;" >2016.03.02-</font>
									</td>
								</tr>
								<tr>
									<td>
										<font color="#4F4F4F" style="font-size:14px;" >运营经理</font>
									</td>
									<td/>
								</tr>
								<tr>
									<td>
										<font color="#4F4F4F" style="font-size:14px;" >运营经理</font>
									</td>
									<td/>
								</tr>
							</table>
						</div>
						<div style="width:100%;z-index:9999;display:none;" onmouseout="displaydiv(this)" id="test1">
							<table width="100%" style="height:100%;">
								<tr>
									<td width="90%"/>
									<td width="100px">
										<button type="button" class="btn btn-primary" data-toggle="button" onclick="resetOne(true)"
											style="font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;">
											删除
										</button>
									</td>
									<td width="100px">
										<button type="button" class="btn btn-primary" data-toggle="button" onclick="resetOne(true)"
											style="font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;">
											编辑
										</button>
									</td>
									<td width="3%"/>
								</tr>
							</table>
						</div> -->
					</td>
					<td/>
				</tr>
				<tr height="48px"/>
				<tr>
					<td/>
					<td>
						<font color="#4F4F4F" style="font-size:14px;" >学校名称</font>
					</td>
				</tr>
				<tr height="16px"/>
				<tr>
					<td/>
					<td colspan="3">
						<input type="text" name="schoolName" id="schoolName" class="form-control" style="width: 56% !important">
						<input id="offerUserWorksId" type="hidden" name="offerUserWorksId"/>
					</td>
				</tr>
				<tr height="48px"/>
				<tr>
					<td/>
					<td>
						<font color="#4F4F4F" style="font-size:16px;">学历</font>
					</td>
				</tr>
				<tr height="13px"/>
				<tr>
					<td/>
					<td colspan="3">
						<input type="text" name="xueli" id="xueli" class="form-control" style="width: 56% !important">
					</td>
				</tr>
				<tr height="56px"/>
				<tr>
					<td/>
					<td>
						<font color="#4F4F4F" style="font-size:16px;" >就读时间</font>
					</td>
				</tr>
				<tr height="13px"/>
				<tr>
					<td/>
					<td colspan="3">
						<table width="100%">
							<tr>
								<td class="textC" width="50px">
									<font color="#4F4F4F" style="font-size:16px;" >开始</font>
								</td>
								<td class="textL" width="141px">
									<input type="text" name="studstart" id="studstart" class="form-control" style="width: 141px !important;">
								</td>
								<td class="textC" width="50px">
									<font color="#4F4F4F" style="font-size:16px;" >结束</font>
								</td>
								<td class="textL" width="141px">
									<input type="text" name="studend" id="studend" class="form-control" style="width: 141px !important;">
								</td>
								<td class="textR" width="80px">
									<input type="hidden" id="toNow" name="toNow"/>
									<input type="checkbox" id="toNow1" name="toNow1"/><font color="#4F4F4F" style="font-size:16px;" >至今</font>
								</td>
								<td/>
							</tr>
						</table>
					</td>
				</tr>
				<tr height="48px"/>
				<tr>
					<td/>
					<td>
						<font color="#4F4F4F" style="font-size:16px;" >专业</font>
					</td>
				</tr>
				<tr height="13px"/>
				<tr>
					<td/>
					<td colspan="3">
						<!-- <textarea rows="8" style="width:75%;min-width:300px;" name="zhuanye"></textarea> -->
						<input type="text" name="zhuanye" id="zhuanye" class="form-control" style="width: 56% !important">
					</td>
				</tr>
				<tr height="50px"/>
				<tr>
					<td/>
					<td colspan="3" class="textC">
						<input type="reset" name="reset1" id="reset1" style="display: none;" />
						<button type="button" class="btn btn-primary" data-toggle="button"
							style="font-size:14px;border-color:#CCCCCC;color:#4F4F4F;background-color:#CCCCCC;min-width:140px;">
							取消
						</button>
						<button type="button" class="btn btn-primary" data-toggle="button" onclick="saveData()"
							style="margin-left:19px;font-size:14px;color:#FFF;background-color:#00B389;min-width:140px;">
							保存
						</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div style="width:100%;height:50px;"></div>
</body>
</html>