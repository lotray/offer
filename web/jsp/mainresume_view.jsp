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
	function openWindow(){
		document.getElementById("firmmuban").click();
	}
	function jobId(job){
		document.getElementById("isstock").value = "0";
		if(job.getAttribute('class') == "icheckbox_square-green checked"){
			job.setAttribute("class","icheckbox_square-green hover");
			document.getElementById("isstock").value = "0";
		}
		else if(job.getAttribute('class') == "icheckbox_square-green hover"){
			job.setAttribute("class","icheckbox_square-green checked");
			document.getElementById("isstock").value = "1";
		}
	}
	
	function init() {
		var url = "user/resumeviewPage1.do";
		var data = ajaxSumbitNoform(url, "123");
		document.getElementById('userId').value = data.userId;
		document.getElementById('userName').innerText = data.userName;
		addinformation1(data.informationTd1);
		addinformation2(data.informationTd2);
		addskillTd(data.skillTd);
		addworkTd(data.workTd);
		addeducationTd(data.educationTd);
		adddescriptionTd(data.descriptionTd);
		addworksTd(data.worksTd);
		addprotectTd(data.protectTd);
		//addmuban();
	}
	
	function nofeel() {//不感兴趣
		var id = document.getElementById('userId').value;
		var url = "firm/selectfindusersum1.do?status=0&offerCandidateId=" + id;//状态（0：不敢兴趣，1：收藏）
		var formId = "findusersumForm";
		var data = ajaxSumbit(url, formId);
		if(data == 'success'){
			alert("下次不再为您提供该候选人信息");
		}
	}
	
	function hadfeel() {//收藏
		var id = document.getElementById('userId').value;
		var url = "firm/selectfindusersum1.do?status=1&offerCandidateId=" + id;//状态（0：不敢兴趣，1：收藏）
		var formId = "findusersumForm";
		var data = ajaxSumbit(url, formId);
		if(data == 'success'){
			alert("收藏成功");
		}
	}
	
	//informationTd1
	function addinformation1(item){
		var information = "";
		information = information + "<div style='background: #FFFFFF; width: 80%;margin-left:15%;padding-top:30px;padding-left:30px;'>"
										+ "<table width='100%'>"
											+ "<tr>"
												+ "<td rowspan='5' width='150px'>"
													+ "<img src="+ item.userPhoto +" width='150px' height='150px'/>"
												+ "</td>"
												+ "<td/>"
												+ "<td width='20%'/>"
											+ "</tr>"
											+ "<tr>"
												+ "<td style='padding-left:30px;'><font size='3' style='font-weight:bold;'>"+item.userName+"</font></td>"
												+ "<td/>"
											+ "</tr>"
											+ "<tr>"
												+ "<td style='padding-left:30px;'><font size='1'>" + item.simpleResume + "</font></td>"
												+"<td>"
													+"<table width='100%'>"
														+"<tr>"
															+"<td style='padding-right:10px;'>"
																+"<div class='btn-group btn-group-lg'>"
																	+"<button type='button' class='btn btn-default' style='width: 120px;height:40px;' onclick='nofeel()'>"
																		+"<img src='../img/delete.png'/>"
																		+"<font size='2'>不感兴趣</font>"
																	+"</button>"
																+"</div>"
															+"</td>"
															+"<td style='padding:0px 10px;'>"
																+"<div class='btn-group btn-group-lg'>"
																	+"<button type='button' class='btn btn-default' style='width: 120px;height:40px;' onclick='hadfeel()'>"
																		+"<img src='../img/collection.png'/>"
																		+"<font size='2'>收藏</font>"
																	+"</button>"
																+"</div>"
															+"</td>"
														+"</tr>"
													+"</table>"
												+"</td>"
											+ "</tr>"
											+ "<tr height='50px'>"
												+ "<td style='padding-left:30px;'><font size='1'>邮箱："+item.email+"</font></td>"
												+"<td>"
												+"</td>"
											+ "</tr>"
											+ "<tr>"
												+ "<td style='padding-left:30px;'><font color='#00B38A' size='1'>候选人同意面试邀请后方能查看联系方式</font></td>"
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
		information = information + "<div style='background: #FFFFFF; width: 80%; margin-top:30px;margin-left:15%;padding-top:30px;padding-left:20px;'>"
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
												+ "</td>"
											+ "</tr>"
										+ "</table>"
									+ "</div>";
		document.getElementById("informationTd2").innerHTML = information;
	}
	//skillTd
	function addskillTd(item){
		var skill = "";
		skill = skill + "<div style='background: #FFFFFF; width: 80%; margin-top:30px;margin-left:15%;padding-top:30px;padding-left:20px;'>"
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
		work = work + "<div style='background: #FFFFFF; width: 80%; margin-top:30px;margin-left:15%;padding-top:30px;padding-left:20px;'>"
						+ "<table width='100%'>"
							+ "<tr>"
								+ "<td>"
									+ "<font style='font-weight:bold;margin-left:30px;'>工作经历</font>"
									+ "<p style='padding:20px;'><font size='2'>" + item.str + "</font></p>"
								+ "</td>"
								+ "<td width='20%' class='textC' valign='top'>"
									+ "<a href='#' onclick='javascript:top.location.href=\"resume_add_questionnaire.jsp\"'>"
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
		education = education + "<div style='background: #FFFFFF; width: 80%; margin-top:30px;margin-left:15%;padding-top:30px;padding-left:20px;'>"
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
													+ "</a>"
												+ "</td>"
											+ "</tr>"
										+ "</table>"
									+ "</div>";
		document.getElementById("educationTd").innerHTML = education;
	}
	function adddescriptionTd(item){
		var description = "";
		description = description + "<div style='background: #FFFFFF; width: 80%; margin-top:30px;margin-left:15%;padding-top:30px;padding-left:20px;'>"
						+ "<table width='100%'>"
							+ "<tr>"
								+ "<td>"
									+ "<font size='3' style='font-weight:bold;margin-left:30px;'>个人描述</font>"
									+ "<p style='padding:20px 30px;'><font size='2'>" + item.str + "</font></p>"
								+ "</td>"
								+ "<td width='20%' class='textC' valign='top'>"
									+ "<a href='#' onclick='openWindow(\"description\")'>"
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
		works = works + "<div style='background: #FFFFFF; width: 80%; margin-top:30px;margin-left:15%;padding-top:30px;padding-left:20px;'>"
						+ "<table width='100%'>"
							+ "<tr>"
								+ "<td>"
									+ "<font size='3' style='font-weight:bold;margin-left:30px;'>个人作品</font>"
									+ "<p style='padding:20px 30px;'><font size='2'>" + item.str + "</font></p>"
								+ "</td>"
								+ "<td width='20%' class='textC' valign='top'>"
									+ "<a href='#' onclick='openWindow(\"works\")'>"
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
		protect = protect + "<div style='background: #FFFFFF; width: 80%; margin-top:30px;margin-left:15%;padding-top:30px;padding-left:20px;'>"
						+ "<table width='100%'>"
							+ "<tr>"
								+ "<td>"
									+ "<font size='2' style='font-weight:bold;margin-left:30px;'>私聊保护（可以填写您想屏蔽的公司邮箱后缀，让他们无法查看您的简历。）</font>"
									+ "<p style='padding:20px 30px;'><font size='2'>" + item.str + "</font></p>"
								+ "</td>"
								+ "<td width='20%' class='textC' valign='top'>"
									+ "<a href='#' onclick='openWindow(\"protect\")'>"
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
	
	function saveOfferInvite() {
		var url = "firm/saveOfferInvite.do";
		var formId = "saveOfferInviteForm";
		var data = ajaxSumbit(url, formId);
		if(data == "success"){
			alert("提交成功!");
		}else{
			alert("保存出错!");
		}
	}
	
	function dowmloadpdf(){
		top.location.href='../user/downloadPdf2.do';
	}
	
	function selected(ret){
		if(ret.id == 'd1'){
			document.getElementById("noXinZi").setAttribute("class","circleB");;
			document.getElementById("haveXinZi").setAttribute("class","circleA");;
			document.getElementById("noXinZi1").style.color="#CCCCCC";
			document.getElementById("haveXinZi1").style.color="#00B38A";
			document.getElementById("d1").style.border="1px #00B38A solid";
			document.getElementById("d2").style.border="1px #CCCCCC solid";
			document.getElementById('banben').value = ret.id;
		}
		if(ret.id == 'd2'){
			document.getElementById("noXinZi").setAttribute("class","circleA");;
			document.getElementById("haveXinZi").setAttribute("class","circleB");;
			document.getElementById("noXinZi1").style.color="#00B38A";
			document.getElementById("haveXinZi1").style.color="#CCCCCC";
			document.getElementById("d1").style.border="1px #CCCCCC solid";
			document.getElementById("d2").style.border="1px #00B38A solid";
			document.getElementById('banben').value = ret.id;
		}
	}
	
	function saveXinZi(){
		var id = document.getElementById('userId').value;
		var zhuanfaEmail = document.getElementById('zhuanfaEmail').value;
		var banben = document.getElementById('banben').value;
		var shapetion = document.getElementById('shapetion').value;
		var url = "user/zhuanpdf.do?userId="+id+"&zhuanfaEmail="+zhuanfaEmail+"&banben=" + banben+"&shapetion="+shapetion;
		var data = ajaxSumbitNoform(url, "");
		if(data == 'success'){
			alert("转发成功");
		}
	}
	
	function addmuban(){
		var td1 = document.createElement("td");
		td.innerHTML = "<button type='button' class='btn btn-default' style='margin-left:10px;border-radius:20px;'>"
						+"<font style='font-size:14px;'>java工程师</font>"
						+"</button>";
		document.getElementById("canused").appendChild(td1);
	}
</script>
<body bgcolor="#F4F9F9" onload="init()">
	<div style="width:100%;height:55px;background: #000;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;">
		<table style="width:100%;white-space: nowrap;">
			<tr>
				<td width="270px" style="padding-left:150px;"><img src="../img/U-Offerlogo.png"></td>
				<td class="textL" style="padding-left:100px;">
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='finduser.jsp'">
				    	<font size="3">候选人</font>
				    </button>
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;"class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='user_view.jsp'">
				    	<font size="3">已发邀请</font>
				    </button>
			    </td>
			    <td class="textC" width="270px">
				    <div class="btn-group">
						<button type="button" style="height:55px !important;color:#FFF;background-color:#000;"
						 class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)"
						 onmouseout="changeColor2(this)" ><span id="userName" name="userName"></span>
					        <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu2" style="">
					        <li role="presentation">
					            <a role="menuitem" tabindex="-1" href="#" onclick="javascript:top.location.href='personal_settings_edit.jsp'"><font color="#000">个人设置</font></a>
					        </li>
					    </ul>
				    </div>
				<button type="button" style="height:55px !important;width:80px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu4" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='login.jsp'">退出
			    </button>
				</td>
			</tr>
		</table>
	</div>
	<br />
	<br />
	<br />
	<br />
	<table width="100%">
		<tr>
			<td id="informationTd1">
				<!-- <div style="background: #FFFFFF; width: 80%;margin-left:15%;padding-top:30px;padding-left:30px;">
					<table width="100%">
						<tr>
							<td rowspan="5" width="100px">
								<img src="../img/changjinglu.jpg" width="90px"/>
							</td>
							<td />
							<td width="20%"/>
						</tr>
						<tr>
							<td><font size="3" style="font-weight:bold;">Y小姐</font></td>
							<td/>
						</tr>
						<tr height="50px">
							<td><font size="1">女 28岁 现居住北京|C/C++工程师算法工程师|期望年薪34万</font></td>
							<td>
								<div class="btn-group btn-group-lg">
						    		<button type="button" class="btn btn-default" style="width: 120px;height:40px;">
						    			<img src="../img/delete.png"/>
						    			<font size="2">不感兴趣</font>
						    		</button>
						    	</div>
							</td>
						</tr>
						<tr height="50px">
							<td><font size="1">通信工程，太原理工大学</font></td>
							<td>
								<div class="btn-group btn-group-lg">
						    		<button id="regit" type="button" class="btn btn-default" style="width:120px;height:40px;">
						    			<img src="../img/collection.png"/>
						    			<font size="2">收藏</font>
						    		</button>
						    	</div>
							</td>
						</tr>
						<tr>
							<td><font color="#00B38A" size="1">候选人同意面试邀请后方能查看联系方式</font></td>
							<td/>
						</tr>
						<tr height="20px"/>
					</table>
				</div> -->
			</td>
			<td width="10px" rowspan="7"/>
			<td class="textC">
				<div style="background: #FFFFFF; width: 250px;padding-top:20px;padding-left:20px;">
					<table width="100%">
						<tr height="60px">
							<td class="textC">
								<button type="button" class="btn btn-default btn-primary btn-lg" style="width: 150px;height:40px;background:#00B38A;" data-toggle="modal" data-target="#myModal">
						   			<font size="2">发送面试邀请</font>
						   		</button>
								<form id="saveOfferInviteForm">
									<input type="hidden" id="userId" name="userId" />
									<input type="hidden" id="haveCollect" name="haveCollect" />
									<input type="hidden" id="haveInvite" name="haveInvite" />
							   		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top:35px;">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														&times;
													</button>
													<h4 class="modal-title" id="myModalLabel">
														发送面试邀请
													</h4>
												</div>
												<div class="modal-body">
													<table width="100%" style="border-collapse:separate;border-spacing:10px;">
														<tr>
															<td colspan="2"><font size="1" color="#999999">你发送的面试邀请会自动存为模板</font></td>
														</tr>
														<tr>
															<td colspan="2">
																<table>
																	<tr id="canused">
																		<td>
																			<font size="1" color="#00B38A">可用模板</font>
																		</td>
																		<!-- <td>
																			<button type="button" class="btn btn-default" style="margin-left:10px;border-radius:20px;">
																	   			<font size="1">java工程师</font>
																	   		</button>
																		</td>
																		<td>
																			<button type="button" class="btn btn-default" style="margin-left:10px;border-radius:20px;">
																	   			<font size="1">java工程师</font>
																	   		</button>
																		</td> -->
																	</tr>
																</table>
															</td>
														</tr>
														<tr>
															<td>
																<font size="1">职位名称</font>
															</td>
															<td class="textR">
																<font size="1" color="#999999">期望职位：java工程师</font>
															</td>
														</tr>
														<tr>
															<td colspan="2">
																<input type="text" name="jobName" class="form-control">
															</td>
														</tr>
														<tr>
															<td>
																<font size="1">工作地点</font>
															</td>
															<td class="textR">
																<font size="1" color="#999999">期望地点：北京</font>
															</td>
														</tr>
														<tr>
															<td colspan="2">
																<input type="text" name="jobPlace" class="form-control">
															</td>
														</tr>
														<tr>
															<td colspan="2">
																<font size="1">薪资范围</font>
															</td>
															<td>
															</td>
														</tr>
														<tr>
															<td colspan="2">
																<table width="100%">
																	<tr>
																		<td>
																			<div class="input-group" style="width: 135px !important">
																				<div class="dropdown" style="">
																					<input type="text" name="name" class="form-control" style="width: 80px !important">
																				    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
																				        <span class="caret"></span>
																				    </button>
																				    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 20px !important">
																				        <li role="presentation">
																				            <a role="menuitem" tabindex="-1" href="#"><font color="#000">人民币</font></a>
																				        </li>
																				        <li role="presentation">
																				            <a role="menuitem" tabindex="-1" href="#"><font color="#000">Java2</font></a>
																				        </li>
																				    </ul>
																				</div>
																			</div>
																		</td>
																		<td>
																			<div class="input-group">
																				<input type="text" name="jobMonthWagesFirst" class="form-control" style="width: 80px !important"><span class="input-group-addon">K/月</span>
																			</div>
																		</td>
																		<td class="textC" width="5%">~</td>
																		<td>
																			<div class="input-group">
																				<input type="text" name="jobMonthWagesSecond" class="form-control" style="width: 80px !important"><span class="input-group-addon">K/月</span>
																			</div>
																		</td>
																		<td class="textC" width="5%">X</td>
																		<td>
																			<div class="input-group">
																				<input type="text" name="jobMonth" class="form-control" style="width: 80px !important"><span class="input-group-addon">月</span>
																			</div>
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
														<tr>
															<td>
																<input type="hidden" name="isstock" id="isstock"/>
																<div class="icheckbox_square-green hover" onclick="jobId(this)">
													            	<input tabindex="2" type="checkbox" style="opacity:0;" class="jobId">
																</div>
																<font size="1">提供期权/股份</font>
															</td>
														</tr>
														<tr>
															<td><font size="1">邀请信</font></td>
															<td class="textR"><font size="1" color="#00B38A"><a href="#" onclick="openWindow()">查看邀请模板</a></font></td>
														</tr>
														<tr>
															<td colspan="2">
																<textarea rows="4" style="width:99%;" name="chatMessage" ></textarea>
															</td>
														</tr>
													</table>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default" data-dismiss="modal">关闭
													</button>
													<button type="button" onclick="saveOfferInvite()" class="btn btn-default" style="background:#00B38A;color:#FFF;" data-dismiss="modal">
														提交更改
													</button>
												</div>
											</div>
										</div>
									</div>
								</form>
							</td>
						</tr>
						<tr height="60px">
							<td class="textC">
								<button type="button" class="btn btn-default" style="width: 150px;height:40px;" onclick="dowmloadpdf()">
						   			<img src="../img/download.png" width="17px" height="17px"/>&nbsp;<font size="2">下载该简历</font>
						   		</button>
							</td>
						</tr>
						<tr height="60px">
							<td class="textC">
						   		<button type="button" class="btn btn-default" style="width: 150px;height:40px;" data-toggle="modal" data-target="#myModal123">
						   			<img src="../img/zhuanfa.png" width="17px" height="17px"/>&nbsp;<font size="2">转发该简历</font>
						   		</button>
						   		<form id="saveXinZiForm">
							   		<div class="modal fade" id="myModal123" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top:35px;">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
														&times;
													</button>
													<h4 class="modal-title" id="myModalLabel">
														转发该简历
													</h4>
												</div>
												<div class="modal-body">
													<table width="100%" style="border-collapse:separate;border-spacing:10px;">
														<tr>
															<td colspan="2"><font size="1" color="#999999">收件人邮箱</font></td>
														</tr>
														<tr>
															<td colspan="2">
																<div class="input-group" style="width:100%;">
																	<input type="text" id="zhuanfaEmail" name="zhuanfaEmail" class="form-control">
																	<span class="input-group-addon" style="background:#FFF;border:none;">
																		<font size="1" color="#999999" id="emailSuffer" style="float:left;">@qq.com</font>
																	</span>
																</div>
															</td>
														</tr>
														<tr>
															<td colspan="2"><font size="1" color="#999999">选择版本</font></td>
														</tr>
														<tr>
															<td class="textC">
																<input type="hidden" id="banben" name="banben" class="form-control">
																<div style="width:90%;height:40px;border:1px #00B38A solid;padding:auto 0px;border-radius:5px;" onclick="selected(this)" id="d1">
																	<table width="100%" height="100%">
																		<tr>
																			<td class="textR" style="width:46%;">
																	   			<div class="circleA" id="haveXinZi" style="float:right;width:15px;height:15px;"></div>
																			</td>
																			<td style="width:54%;padding-left:10px;">
																	   			<font size="1" id="haveXinZi1" color="#00B38A">有薪资</font>
																			</td>
																		</tr>
																	</table>
																</div>
															</td>
															<td class="textC">
																<div style="width:90%;height:40px;border:1px #CCCCCC solid;padding:auto 0px;border-radius:5px;" onclick="selected(this)" id="d2">
																	<table width="100%" height="100%">
																		<tr>
																			<td class="textR" style="width:46%;">
																	   			<div class="circleB" id="noXinZi" style="float:right;width:15px;height:15px;"></div>
																			</td>
																			<td style="width:54%;padding-left:10px;">
																	   			<font size="1" id="noXinZi1" color="#CCCCCC">无薪资</font>
																			</td>
																		</tr>
																	</table>
																</div>
															</td>
														</tr>
														<tr>
															<td><font size="1">分享描述</font></td>
														</tr>
														<tr>
															<td colspan="2">
																<textarea rows="4" style="width:99%;" id="shapetion" name="shapetion" ></textarea>
															</td>
														</tr>
													</table>
												</div>
												<div class="modal-footer">
													<center>
														<button type="button" onclick="saveXinZi()" class="btn btn-default" style="width:100px;background:#00B38A;color:#FFF;" data-dismiss="modal">
															确定
														</button>
													</center>
												</div>
											</div>
										</div>
									</div>
								</form>
							</td>
						</tr>
					</table>
				</div>	
			</td>
		</tr>
		<tr>
		    <td id="informationTd2"></td>
			<td rowspan="6" valign="top">
				<div style="background: #FFFFFF;width: 250px; margin-top:30px;padding-top:20px;padding-left:20px;">
					<table width="100%">
						<tr>
							<td class="textL">
								<img src="../img/kefu.png" width="80px" height="80px" style="border-radius:20px;border:2px solid #BBBBBB;padding:10px 20px;"/>
							</td>
						</tr>
						<tr height="10px"/>
						<tr>
							<td>
								<font size="1" color="#666666">
									我是家骏，您的职业顾问<br/>
									期待着与您交流工作，求职中的想法<br/>
									电话：13580500688<br/>
									微信号:fish_e<br/>
									QQ:37651058<br/>
									邮箱:jiajun@uoffer.com
								</font>
							</td>
						</tr>
						<tr height="20px"/>
					</table>
				</div>
			</td>
		</tr>
		<tr>
			<td id="skillTd" class="textR">
			</td>
		</tr>
		<tr>
			<td id="workTd">
			</td>
		</tr>
		<tr>
			<td id="educationTd">
			</td>
		</tr>
		<tr>
			<td id="descriptionTd">
			</td>
		</tr>
		<tr>
			<td>
				<div style="background: #FFFFFF; width: 80%; margin-top:30px;margin-left:15%;padding-top:30px;padding-left:20px;">
					<font size="3" style="font-weight:bold;margin-left:30px;">顾问备注</font>
					<p></p>
					<br />
					<br />
				</div>
			</td>
		</tr>
	</table>
	<br/>
	<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2" style="display:none;" id="firmmuban"></button>
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="margin-top:100px;margin-left:-35px;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						邀请信样例
					</h4>
					<div style="width:100%">
						<table style="width:100%;border-collapse:separate;border-spacing:20px;">
							<tr>
								<th><font size="1">简单介绍公司业务：</font></th>
							</tr>
							<tr>
								<td>
									<font size="1">
										我们是一家刚开始创业的互联网公司，专注于K12领域，做老师最给力的教学 辅助利器，通过大数据和人工智能，让孩子更有效地提高成绩。
									</font>
								</td>
							</tr>
							<tr>
								<th><font size="1">描述一下团队构成： </font></th>
							</tr>
							<tr>
								<td>
									<font size="1">
										我们的团队成员自阿里UC、腾讯、百度的技术专家和专业的教研老师共同 深耕教育。
									</font>
								</td>
							</tr>
							<tr>
								<th><font size="1"> 简述一下企业文化：</font></th>
							</tr>
							<tr>
								<td>
									<font size="1">
										 除了coding，教育本身就是一个伟大的事业，我们欢迎有激情有热情有潜力 能够认识到我们在做的事情是有意义有价值的对味小伙伴们，共享未来的那 一刻。加入我们，这一段人生经历才会更加丰富多彩。加入我们，你的孩子 有一天会以你为傲。
									</font>
								</td>
							</tr>
							<tr>
								<th><font size="1">最后表达一下所招职位的岗位描述：</font></th>
							</tr>
							<tr>
								<td>
									<font size="1">
										招聘Android开发，扎实的Java基础，精通Android平台开发，熟悉WebView 混合应用开发及C++混合开发，熟练使用Android Studio、Git等工具。常年 混迹GitHub及各大技术网站，对当下主流的开源框架有所研究和实践，对于 自己所掌握的技术有总结，会写一些技术文章者优先。对于Android的性能优 化有自己的理解，了解敏捷开发，掌握开发中保证程序质量的方法及工具，良 好的沟通能力和团队合作精神。
									</font>
								</td>
							</tr>
							<tr>
								<td class="textC">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>