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
	function init(){
		var url = "user/resumeedit4.do";
		var formId = "resumeAddWorkexperienceForm1";
		var data = ajaxSumbit(url, formId);
		addmsgDiv(data.otherWorks);
		$("#resumeAddWorkexperienceForm1").populateForm(data);
		$(".form_datetime2").datetimepicker({
	        format: "yyyy-mm",
	        autoclose:true,
	        startView: 'year',
	        minView:'year',
	        maxView:'decade',
	        language:'zh-CN'
	    });
		if (data.otherWorks.length > 0) {
			document.getElementById("xiaoshi").style.display="none";
		}
		else {
			document.getElementById("xiaoshi").style.display="block";
		}
	}
	function saveData(ispass) {
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
				alert('保存成功！');
				document.getElementById("reset1").click();
				addmsgDiv(data.otherWorks);
				document.getElementById("xiaoshi").style.display="none";
			}
		}
		else {
			//document.getElementById("reset1").click();
			top.location.href='resume_edit.jsp';
		}
	}
	function test(){
		init();
		parent.document.getElementById("main1").height=0;
		parent.document.getElementById("main1").height=document.body.scrollHeight;
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
						+"<div style='width:100%;z-index:9999;display:none;' onmouseout='displaydiv(this)' id='e"+i+"'>"
							+"<table width='100%' style='height:100%;'>"
								+"<tr>"
									+"<td width='90%'/>"
									+"<td width='100px'>"
										+"<button type='button' class='btn btn-primary' data-toggle='button' id='del_"+items[i].thisId+"' onclick='delWork(this)'"
										+"style='font-size:14px;color:#00B389;background-color:#FFF;min-width:100px;'>"
										+"删除"
										+"</button>"
									+"</td>"
									+"<td width='100px'>"
										+"<button type='button' class='btn btn-primary' data-toggle='button' id='edit_"+items[i].thisId+"' onclick='editWork(this)'"
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
	function delWork(obj) {
		if(confirm("真的要删除吗？")) {
			document.getElementById('offerUserWorksId').value = obj.id.split('_')[1];
			var url = "user/delWork.do";
			var formId = "resumeAddWorkexperienceForm1";
			var data2 = ajaxSumbit(url, formId);
			if(data2 == 'success'){
				parent.document.getElementById("mainFrame").src = "edit_resume4.jsp";
			}
			else {
				alert("操作失败！");
			}
		}
	}
	function goAdd() {
		if (!checkValueWorkKuang()) {
			document.getElementById("offerUserWorksId").value = "";
			var url = "user/getNewWork.do";
			var formId = "resumeAddWorkexperienceForm1";
			var data = ajaxSumbit(url, formId);
			addmsgDiv(data.otherWorks);
			document.getElementById("xiaoshi").style.display="block";
			parent.document.getElementById("main1").height=0;
			parent.document.getElementById("main1").height=document.body.scrollHeight;
		}
		else {
			if(confirm("是否先保存下面的数据？")) {
				if(!checkValueWork()) return;
				if(checkToNow('work')) return;
				var url = "user/saveresumeAddWorkexperience1.do";
				var formId = "resumeAddWorkexperienceForm1";
				var data2 = ajaxSumbit(url, formId);
			}
			document.getElementById("reset1").click();
			document.getElementById("xiaoshi").style.display="block";
			parent.document.getElementById("main1").height=0;
			parent.document.getElementById("main1").height=document.body.scrollHeight;
		}
	}
	function checkValueWork(){
		if(!checkInput('firmName',"公司名称","30",false)) return false;
		if(!checkInput('jobName',"职位名称","30",false)) return false;
		if(!checkInput('jobstart',"开始时间","30",false)) return false;
		return true;
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
		addmsgDiv(data.otherWorks);
		$("#resumeAddWorkexperienceForm1").populateForm(data);
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
		<form id="resumeAddWorkexperienceForm1">
			<table width="100%">
				<tr height="49px"/>
				<tr>
					<td width="40px"/>
					<td width="54%">
						<font style="font-size:20px;" color="#4F4F4F">工作经历</font>
						<input id="offerUserWorksId" type="hidden" name="offerUserWorksId"/>
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
					</td>
					<td/>
				</tr>
				<tr height="48px"/>
			</table>
			<table width="100%" id="xiaoshi">
				<tr>
					<td width="40px"/>
					<td width="54%">
						<font color="#4F4F4F" style="font-size:14px;" >公司名称</font>
					</td>
					<td/>
					<td/>
				</tr>
				<tr height="16px"/>
				<tr>
					<td/>
					<td colspan="3">
						<input type="text" name="firmName" id="firmName" class="form-control" style="width: 56% !important">
					</td>
				</tr>
				<tr height="48px"/>
				<tr>
					<td/>
					<td>
						<font color="#4F4F4F" style="font-size:16px;" >职位名称</font>
					</td>
				</tr>
				<tr height="13px"/>
				<tr>
					<td/>
					<td colspan="3">
						<input type="text" name="jobName" id="jobName" class="form-control" style="width: 56% !important">
					</td>
				</tr>
				<tr height="56px"/>
				<tr>
					<td/>
					<td>
						<font color="#4F4F4F" style="font-size:16px;" >在职时间</font>
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
								<!-- <td class="textL" width="141px">
									<input type="text" name="jobstart" id="jobstart" class="form-control" style="width: 141px !important;">
								</td> -->
								<td>
									<div class='input-append date form_datetime2'>
										<input size='16' type='text' value='' class='date-control form-control' style="width: 75% !important;" readonly name='jobstart' id='jobstart'>
									    <span class='add-on'><i class='icon-th'></i></span>
									</div>
								</td>
								<td class="textC" width="50px">
									<font color="#4F4F4F" style="font-size:16px;" >结束</font>
								</td>
								<!-- <td class="textL" width="141px">
									<input type="text" name="jobend" id="jobend" class="form-control" style="width: 141px !important;">
								</td> -->
								<td>
									<div class='input-append date form_datetime2'>
										<input size='16' type='text' value='' class='date-control form-control' style="width: 75% !important;" readonly name='jobend' id='jobend'>
									    <span class='add-on'><i class='icon-th'></i></span>
									</div>
								</td>
								<td class="textR" width="80px">
									<input type="hidden" id="toNow1" name="toNow1"/>
									<input type="checkbox" id="toNowWork" name="toNowWork" /><font color="#4F4F4F" style="font-size:16px;" >至今</font>
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
						<font color="#4F4F4F" style="font-size:16px;" >工作内容</font>
					</td>
				</tr>
				<tr height="13px"/>
				<tr>
					<td/>
					<td colspan="3">
						<textarea rows="8" style="width:75%;min-width:300px;" id="workcontent" name="workcontent"></textarea>
					</td>
				</tr>
				<tr height="50px"/>
				<tr>
					<td/>
					<td colspan="3" class="textC">
						<input type="reset" name="reset1" id="reset1" style="display: none;" />
						<button type="button" class="btn btn-primary" data-toggle="button" onclick="saveData(false)"
							style="font-size:14px;border-color:#CCCCCC;color:#4F4F4F;background-color:#CCCCCC;min-width:140px;">
							取消
						</button>
						<button type="button" class="btn btn-primary" data-toggle="button" onclick="saveData(true)"
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