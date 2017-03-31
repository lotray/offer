<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<script language="javascript">
	function changeColor1(der){
		der.style.background="#999999";
	}
	function changeColor2(der){
		der.style.background="#000";
	}
	function init() {
		 var url = "user/resumeeditPage1.do";
		var data = ajaxSumbitNoform(url, "123");
		addgou(data);
		addinformation1(data.informationTd1);
		addinformation2(data.informationTd2);
		addskillTd(data.skillTd);
		addworkTd(data.workTd);
		addeducationTd(data.educationTd);
		adddescriptionTd(data.descriptionTd);
		addworksTd(data.worksTd);
		addprotectTd(data.protectTd); 
	}
	function addgou(data){
		document.getElementById("integrity").innerText = data.integrity;
		if(data.information == '1'){
			document.getElementById("information").src = "../img/gou.png";
		}
		if(data.skill == '1'){
			document.getElementById("skill").src = "../img/gou.png";
		}
		if(data.work == '1'){
			document.getElementById("work").src = "../img/gou.png";
		}
		if(data.education == '1'){
			document.getElementById("education").src = "../img/gou.png";
		}
		if(data.project == '1'){
			document.getElementById("project").src = "../img/gou.png";
		}
		if(data.description == '1'){
			document.getElementById("description").src = "../img/gou.png";
		}
		if(data.works == '1'){
			document.getElementById("works").src = "../img/gou.png";
		}
		if(data.protect == '1'){
			document.getElementById("protect").src = "../img/gou.png";
		}
	}
	//informationTd1
	function addinformation1(item){
		var information = "";
		information = information + "<div style='background: #FFFFFF; width: 750px;padding-top:30px;padding-left:20px;'>"
										+ "<table width='100%'>"
											+ "<tr>"
												+ "<td rowspan='5' width='160px'>"
													+ "<img src="+ item.userPhoto +" width='150px' height='150px'/>"
												+ "</td>"
												+ "<td/>"
												+ "<td width='20%' class='textC'>"
													+ "<a>"
														+ "<font size='2' color='#00B38A'><a href='#' onclick='javascript:top.location.href=\"resume_add_information.jsp\"'>编辑</a></font>"
													+ "</a>"
												+ "</td>"
											+ "</tr>"
											+ "<tr>"
												+ "<td style='padding-left:30px;'><font size='3' style='font-weight:bold;'>"+item.userName+"</font></td>"
												+ "<td/>"
											+ "</tr>"
											+ "<tr>"
												+ "<td style='padding-left:30px;'><font size='1'>" + item.simpleResume + "</font></td>"
												+ "<td/>"
											+ "</tr>"
											+ "<tr>"
												+ "<td style='padding-left:30px;'><font size='1'>邮箱："+item.email+"</font></td>"
												+ "<td/>"
											+ "</tr>"
											+ "<tr>"
												+ "<td style='padding-left:30px;'><font size='1'>电话："+item.phone+"</font></td>"
												+ "<td/>"
											+ "</tr>"
											+ "<tr height='20px'/>"
										+ "</table>"
									+ "</div>";
		document.getElementById("informationTd1").innerHTML = information;
	}
	//informationTd2
	function addinformation2(item){
		var information = "";
		information = information + "<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>"
										+ "<table width='100%'>"
											+ "<tr>"
												+ "<td>"
													+ "<font size='3' style='font-weight:bold;margin-left:30px;'>关于"+item.userName+"</font>"
													+ "<ul>";
		for(var i in item.informationList2){
			information = information + "<li><font size='1' color='#666666'>"+item.informationList2[i].str+"</font></li>";
		}
		information = information + "</ul>"
												+ "</td>"
												+ "<td width='20%' class='textC' valign='top'>"
													+ "<font size='2' color='#00B38A'><a href='#' onclick='javascript:top.location.href=\"resume_add_planjob.jsp\"'>编辑</a></font>"
												+ "</td>"
											+ "</tr>"
										+ "</table>"
									+ "</div>";
		document.getElementById("informationTd2").innerHTML = information;
	}
	//skillTd
	function addskillTd(item){
		var skill = "";
		skill = skill + "<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>"
						+ "<table width='100%'>"
							+ "<tr>"
								+ "<td>"
									+ "<font size='3' style='font-weight:bold;margin-left:30px;'>技能</font>"
									+ "<ul>";
		for(var i in item.skillList1){
			skill = skill + "<li><font size='1' color='#666666'>"+item.skillList1[i].str+"</font></li>";
		}
		skill = skill + "</ul>"
								+ "</td>"
								+ "<td width='20%' class='textC' valign='top'>"
									+ "<a href='#' onclick='javascript:top.location.href=\"resume_add_workexperience.jsp\"'>"
										+ "<font size='2' color='#00B38A'>编辑</font>"
									+ "</a>"
								+ "</td>"
							+ "</tr>"
							+ "<tr>"
								+ "<td colspan='2' style='padding-top:20px;'>";
		for(var i in item.skillList2){
			skill = skill + "<div class='btn-group btn-group-lg' style='margin-left:20px;'>"
											+"<button type='button' class='btn btn-default' style='min-width:100px;height:40px;color:#00B389;background:#FFF;'>"
												+"<font size='2'>"+ item.skillList2[i].str +"</font>"
											+"</button>"
										+"</div>";
		}
		skill = skill + "</td>"
							+ "</tr>"
						+ "</table>"
						+ "<br />"
						+ "<br />"
						+"</div>";
		document.getElementById("skillTd").innerHTML = skill; 
	}
	//workTd
	function addworkTd(item){
		var work = "";
		work = work + "<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>"
						+ "<table width='100%'>"
							+ "<tr>"
								+ "<td>"
									+ "<font style='font-weight:bold;margin-left:30px;'>工作经历</font>"
									+ "<p style='padding:20px;'><font size='2'>" + item.str + "</font></p>"
								+ "</td>"
								+ "<td width='20%' class='textC' valign='top'>"
									+ "<a href='#' onclick='javascript:top.location.href=\"resume_add_questionnaire.jsp\"'>"
										+ "<font size='2' color='#00B38A'>编辑</font>"
									+ "</a>"
								+ "</td>"
							+ "</tr>"
							+ "<tr>"
								+ "<td colspan='2' style='padding-top:20px;'>"
								"</td>"
							+ "</tr>"
						+ "</table>"
						+ "<br />"
						+ "<br />"
						+"</div>";
		document.getElementById("workTd").innerHTML = work; 
	}
	function addeducationTd(item){
		var education = "";
		education = education + "<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>"
										+ "<table width='100%'>"
											+ "<tr>"
												+ "<td>"
												+ "<font size='3' style='font-weight:bold;margin-left:30px;'>教育经历</font>"
													+ "<ul>";
		for(var i in item.educationList){
			education = education + "<li><font size='1' color='#666666'>"+item.educationList[i].str+"</font></li>";
		}
		education = education + "</ul>"
												+ "</td>"
												+ "<td width='20%' class='textC' valign='top'>"
													+ "<a href='#' onclick='javascript:top.location.href=\"resume_add_workexperience.jsp\"' >"
														+ "<font size='2' color='#00B38A'>编辑</font>"
													+ "</a>"
												+ "</td>"
											+ "</tr>"
										+ "</table>"
									+ "</div>";
		document.getElementById("educationTd").innerHTML = education;
	}
	function adddescriptionTd(item){
		var description = "";
		description = description + "<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>"
						+ "<table width='100%'>"
							+ "<tr>"
								+ "<td>"
									+ "<font size='3' style='font-weight:bold;margin-left:30px;'>个人描述</font>"
									+ "<p style='padding:20px 30px;'><font size='2'>" + item.str + "</font></p>"
								+ "</td>"
								+ "<td width='20%' class='textC' valign='top'>"
									+ "<a href='#' onclick='openWindow(\"description\")'>"
										+ "<font size='2' color='#00B38A'>编辑</font>"
									+ "</a>"
								+ "</td>"
							+ "</tr>"
							+ "<tr>"
								+ "<td colspan='2' style='padding-top:20px;'>"
								"</td>"
							+ "</tr>"
						+ "</table>"
						+ "<br />"
						+ "<br />"
						+"</div>";
		document.getElementById("descriptionTd").innerHTML = description; 
	}
	function addworksTd(item){
		var works = "";
		works = works + "<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>"
						+ "<table width='100%'>"
							+ "<tr>"
								+ "<td>"
									+ "<font size='3' style='font-weight:bold;margin-left:30px;'>个人作品</font>"
									+ "<p style='padding:20px 30px;'><font size='2'>" + item.str + "</font></p>"
								+ "</td>"
								+ "<td width='20%' class='textC' valign='top'>"
									+ "<a href='#' onclick='openWindow(\"works\")'>"
										+ "<font size='2' color='#00B38A'>编辑</font>"
									+ "</a>"
								+ "</td>"
							+ "</tr>"
							+ "<tr>"
								+ "<td colspan='2' style='padding-top:20px;'>"
								"</td>"
							+ "</tr>"
						+ "</table>"
						+ "<br />"
						+ "<br />"
						+"</div>";
		document.getElementById("worksTd").innerHTML = works; 
	}
	function addprotectTd(item){
		var protect = "";
		protect = protect + "<div style='background: #FFFFFF; width: 750px; margin-top:10px;padding-top:30px;padding-left:20px;'>"
						+ "<table width='100%'>"
							+ "<tr>"
								+ "<td>"
									+ "<font size='2' style='font-weight:bold;margin-left:30px;'>私聊保护（可以填写您想屏蔽的公司邮箱后缀，让他们无法查看您的简历。）</font>"
									+ "<p style='padding:20px 30px;'><font size='2'>" + item.str + "</font></p>"
								+ "</td>"
								+ "<td width='20%' class='textC' valign='top'>"
									+ "<a href='#' onclick='openWindow(\"protect\")'>"
										+ "<font size='2' color='#00B38A'>编辑</font>"
									+ "</a>"
								+ "</td>"
							+ "</tr>"
							+ "<tr>"
								+ "<td colspan='2' style='padding-top:20px;'>"
								"</td>"
							+ "</tr>"
						+ "</table>"
						+ "<br />"
						+ "<br />"
						+"</div>";
		document.getElementById("protectTd").innerHTML = protect; 
	}
	function openWindow(name){
		document.getElementById("editbutton").click();
		var content = "";
		if(name == "description"){
			document.getElementById("iframeTitle").innerText = "个人描述";
			content = "<textarea id='editcontent' name='editcontent' rows='8' style='width:99%;'>";
		}
		if(name == "works"){
			document.getElementById("iframeTitle").innerText = "个人作品";
			content = "<textarea id='editcontent' name='editcontent' rows='8' style='width:99%;'>";
		}
		if(name == "protect"){
			document.getElementById("iframeTitle").innerText = "隐私保护";
			content = "<textarea id='editcontent' name='editcontent' rows='8' style='width:99%;'>";
		}
		document.getElementById("iframeId").innerHTML = content;
		document.getElementById("selectId").value = name;
		var url = "user/editcontentPage1.do";
		var data = ajaxSumbitNoform(url, name);
		document.getElementById("editcontent").value=data.editcontent;
	}
	function goSave(){
		var url = "user/saveeditcontent1.do";
		var formId = "editForm";
		var data = ajaxSumbit(url, formId);
		if(data == "success"){
			top.location.href='resume_edit.jsp';
		}else{
			alert("数据出错!");
		}
	}
	
	function dowmloadpdf(){
		top.location.href='../user/downloadPdf.do';
// 		var url = "user/saveeditcontent1.do";
// 		var formId = "editForm";
// 		var data = ajaxSumbit(url, formId);
	}
	
	function booleanInfot(url){
		top.location.href=url;
	}
	
	function selectItem(obj){
		$(".textC").each(function () {
			if(this.style.backgroundColor == 'rgb(0, 179, 138)'){
				this.getElementsByTagName("font")[0].color = '#00B38A';
				this.style.backgroundColor = 'rgb(255, 255, 255)';
			}
		});
		obj.style.backgroundColor="#00B38A";
		obj.getElementsByTagName("font")[0].color="#FFF";
		document.getElementById("mainFrame").src="edit_resume"+obj.id+".jsp";
	}
</script>
<body bgcolor="#F4F9F9">
	<div style="width:100%;height:55px;background: #000;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;">
		<table style="width:100%;white-space: nowrap;">
			<tr>
				<td width="270px" style="padding-left:150px;"><img id="photo" src="../img/U-Offerlogo.png"></td>
				<td class="textL" style="padding-left:150px;">
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('interview.jsp')">
				    	<font size="3">面试邀请</font>
				    </button>
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;"class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('resume_edit.jsp')">
				    	<font size="3">我的简历</font>
				    </button>
			    </td>
			    <td class="textC" width="270px">
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='personal_settings.jsp'">个人设置
				    </button>
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu4" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='login.jsp'">退出
				    </button>
				</td>
			</tr>
		</table>
	</div>
	<div style="height:90px;width:100%;"></div>
	<table width="100%">
		<tr>
			<td width="12%"/>
			<td valign="top" width="263px">
				<table style="background:#FFF;width:100%;">
					<tr>
						<td width="100%" class="textC" style="padding-top:35px;padding-left:10px;padding-bottom:10px;">
							<font size="3" color="#999999">简历完成度：</font>
							<font size="4" color="#00B38A" id="integrity">40%</font>
						</td>
					</tr>
					<tr>
						<td height="1" style="background:#CCCCCC;"></td>
					</tr>
					<tr height="9px"/>
					<tr><td class="textC" style="height:38px;" onclick="selectItem(this)" id="1"><img id="information" style="width:40px;padding:0px 10px;display:none;"/><font style="font-size:14px" color="#00B38A">个人信息</font></td></tr>
					<tr><td class="textC" style="height:38px;" onclick="selectItem(this)" id="2"><img id="skill" style="width:40px;padding:0px 10px;display:none;"/><font style="font-size:14px" color="#00B38A">个人技能</font></td></tr>
					<tr><td class="textC" style="height:38px;" onclick="selectItem(this)" id="3"><img id="work" style="width:40px;padding:0px 10px;display:none;"/><font style="font-size:14px" color="#00B38A">工作经历</font></td></tr>
					<tr><td class="textC" style="height:38px;" onclick="selectItem(this)" id="4"><img id="education" style="width:40px;padding:0px 10px;display:none;"/><font style="font-size:14px" color="#00B38A">教育经历</font></td></tr>
					<tr><td class="textC" style="height:38px;" onclick="selectItem(this)" id="5"><img id="project" style="width:40px;padding:0px 10px;display:none;"/><font style="font-size:14px" color="#00B38A">项目经历</font></td></tr>
					<tr><td class="textC" style="height:38px;" onclick="selectItem(this)" id="6"><img id="description" style="width:40px;padding:0px 10px;display:none;"/><font style="font-size:14px" color="#00B38A">个人描述</font></td></tr>
					<tr><td class="textC" style="height:38px;" onclick="selectItem(this)" id="7"><img id="works" style="width:40px;padding:0px 10px;display:none;"/><font style="font-size:14px" color="#00B38A">个人作品</font></td></tr>
					<tr><td class="textC" style="height:38px;" onclick="selectItem(this)" id="8"><img id="protect" style="width:40px;padding:0px 10px;display:none;"/><font style="font-size:14px" color="#00B38A">隐私保护</font></td></tr>
					<tr>
						<td class="textC" style="padding:20px 40px;">
							<div>
								<button id="pdf" type="button" class="btn btn-default" style="width:150px;height:40px;margin-left:20px;color:#FFF;background:#00B389;" onclick="dowmloadpdf()">
						   			<font size="1">预览下载简历</font>
						   		</button>
							</div>
						</td>
					</tr>
					<tr height="20px"/>
				</table>
			</td>
			<td width="28px"/>
			<td width="56%" id="main1" valign="top" style="min-width:760px;">
				<iframe src="edit_resume4.jsp" name="mainFrame" scrolling="no" id="mainFrame" title="mainFrame" style="width:100%;height:100%;border:none;"></iframe>
			</td>
			<td/>
		</tr>
		<tr height="40px"/>
	</table>
</body>
</html>
