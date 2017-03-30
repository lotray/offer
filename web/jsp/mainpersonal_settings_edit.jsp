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
	var nowJobList;
	var emadilstatus;

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
	function booleanInfot(url){
		top.location.href=url;
	}
	function disedit(ret){
		if(ret == "1"){
			document.getElementById("edit").style.display="";
			document.getElementById("edita").style.display="none";
			document.getElementById("username").style.display="none";
		}
		if(ret == "2"){
			document.getElementById("edit").style.display="none";
			document.getElementById("edita").style.display="";
			document.getElementById("username").style.display="";
		}
	}
	function openWindow(name){
		document.getElementById("wins").click();
		var title ="";
		var content = "";
		if(name == 'job'){
			title = "请选择您的职位";
			content = addjob();
		}
		if(name == 'password'){
			title = "修改密码";
			content = addpassword();
		}
		if(name == 'phone'){
			title = "解绑手机";
			content = addphone();
		}
		if(name == 'email'){
			title = "通知信息设置";
			content = addemail();
		}
		document.getElementById("myModalLabel").innerText=title;
		document.getElementById("winbody").innerHTML=content;
	}
	function addjob(){
		document.getElementById("footer").style.display="";
		var jobName = "ali";
		var returnjob = "<table width='100%'>";
		for(var i in nowJobList){
			returnjob = returnjob + "<tr height='5px' style='border-radius:5px;'/>"
			returnjob = returnjob + "<tr style='border:1px #999999 solid;'>"
				+ "<td style='width:60px;padding:10px 0px;'>"
				+ "<div class='circleB' style='margin:0px auto;' id='"+nowJobList[i].id+"' onclick='selectjob(this)'></div></td>"
				+ "<td class='textC'>"+nowJobList[i].value+"</td></tr>";
		}
		//returnjob = returnjob +"<tr><td colspan='2' class='textC' style='padding:20px 0px;'><button type='button' class='btn btn-default' data-dismiss='modal' style='width:350px;'>确定</button></td></tr>";
		returnjob = returnjob + "</table>";
		return returnjob;
	}
	function addpassword(){
		document.getElementById("footer").style.display="";
		var returnjob = "<table width='100%'>";
		returnjob = returnjob + "<tr>"
									+"<td width='120px' style='padding-left:40px;padding-top:20px;padding-bottom:20px;'>"
										+"当前密码"
									+"</td>"
									+"<td>"
										+"<input type='text' name='oldPassword' id='oldPassword' class='form-control' style='width: 80% !important'>"
									+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td style='padding-left:40px;padding-top:20px;padding-bottom:20px;'>"
										+"新密码"
									+"</td>"
									+"<td>"
										+"<input type='text' name='newPassword' id='newPassword' class='form-control' style='width: 80% !important'>"
									+"</td>"
								+"</tr>"
								+"<tr>"
									+"<td style='padding-left:40px;padding-top:20px;padding-bottom:20px;'>"
										+"重复密码"
									+"</td>"
									+"<td>"
										+"<input type='text' name='comfirmpsw' id='inputCode' class='form-control' style='width: 80% !important'>"
									+"</td>"
								+"</tr>"
								//+"<tr><td colspan='2' class='textC' style='padding:20px 0px;'><button type='button' class='btn btn-default' data-dismiss='modal' style='background:#00B389;color:#FFF;width:250px;'>确定</button></td></tr>"
							+"</table>";
		return returnjob;
	}
	function addphone(){
		document.getElementById("footer").style.display="";
		var returnjob = "<table width='100%'>";
		returnjob = returnjob + "<tr>"
									+"<td width='120px' style='padding-left:40px;padding-top:20px;padding-bottom:20px;'>"
										+"验证码:"
									+"</td>"
									+"<td>"
										+"<div class='input-group'>"
											+"<input type='text' id='inputCode' class='form-control'>"
											+"<span class='input-group-addon' style='background:#00B389;color:#FFF;'>获取验证码</span>"
										+"</div>"
									+"</td>"
								+"</tr>"
								//+"<tr><td colspan='2' class='textC' style='padding:20px 0px;'><button type='button' class='btn btn-default' data-dismiss='modal' style='background:#00B389;color:#FFF;width:250px;'>确定</button></td></tr>"
							+"</table>";
		return returnjob;
	}
	function addemail(){
		document.getElementById("footer").style.display="none";
		var returnjob = "<table width='100%'>";
		for(var i in emadilstatus){
		returnjob = returnjob + "<tr>"
									+"<td>"
										+"<div style='width:100%;border-top:1px #CCCCCC solid;border-bottom:1px #CCCCCC solid;padding:20px 0px;'>"
											+"<table width='100%'>"
												+"<tr>"
													+"<td>"
														+"邮件通知"
													+"</td>"
													+"<td rowspan='2'>"
														+"<table>"
															+"<tr>"
																+"<td>"
																	+"<div class='"+emadilstatus[i].statusValue+"' onclick='open123(this)' id='"+emadilstatus[i].id+"'>"
																		+"<input tabindex='2' type='checkbox' style='opacity:0;'>"
																	+"</div>"
																+"</td>"
																+"<td style='padding-left:10px;'>"
																	+"<font id='tongzhi_"+emadilstatus[i].id+"' size='1' color='#CCCCCC'>"+emadilstatus[i].statustext+"</font>"
																+"</td>"
															+"</tr>"
														+"</table>"
													+"</td>"
												+"</tr>"
												+"<tr>"
													+"<td>"
														+"<font size='1' color='#CCCCCC'>"
															+"每当候选人响应了您的面试邀请或者给您发送消息，会给"+emadilstatus[i].email+"发送邮件进行通知"
														+"</font>"
													+"</td>"
												+"</tr>"
											+"</table>"
										+"</div>"
									+"</td>"
								+"</tr>";
		}
		returnjob = returnjob +"</table>";
		return returnjob;
	}
	function selectjob(selectedfirm){
		$(".circleA").each(function () {
			this.setAttribute("class", "circleB");
        });
		selectedfirm.setAttribute("class", "circleA");
		document.getElementById('selectjobId').value = selectedfirm.id;
	}
	function open123(obj){
		if(obj.getAttribute('class') == "icheckbox_square-green checked"){
			obj.setAttribute("class","icheckbox_square-green hover");
			document.getElementById('tongzhi_'+obj.getAttribute('id')).innerHTML = "未开启";
			var url = "user/updateOfferInviteEmail.do";
			var data = ajaxSumbitNoform(url, obj.getAttribute('id')+","+"0");
			if(data == "success"){
// 				alert("修改成功");
				init();
			}else{
				alert("保存出错！");
			}
		}
		else if(obj.getAttribute('class') == "icheckbox_square-green hover"){
			obj.setAttribute("class","icheckbox_square-green checked");
			document.getElementById('tongzhi_'+obj.getAttribute('id')).innerHTML = "开启";
			var url = "user/updateOfferInviteEmail.do";
			var data = ajaxSumbitNoform(url, obj.getAttribute('id')+","+"1");
			if(data == "success"){
// 				alert("修改成功");
				init();
			}else{
				alert("保存出错！");
			}
		}
	}
	function saveModal(){
		if(document.getElementById("myModalLabel").innerText == "请选择您的职位"){
			var url = "user/updateOfferUserJobId.do";
			var data = ajaxSumbitNoform(url, document.getElementById('selectjobId').value);
			if(data == "success"){
				alert("修改成功");
				init();
			}else{
				alert("保存出错！");
			}
		}
		else if(document.getElementById("myModalLabel").innerText == "修改密码"){
			var url = "user/updateOfferUserPassword.do";
			var formId = "savemyModalFROM";
			var data = ajaxSumbit(url, formId);
			if(data == "success"){
				alert("修改成功");
			}else{
				alert("保存出错！");
			}
		}
		else if(document.getElementById("myModalLabel").innerText == "解绑手机"){
			alert(3);
		}
		else{
			alert("保存出错！");
		}
	}
	
	function submitName(){
		var url = "user/savepersonalSettingsEditName.do";
		var formId = "personalSettingsEditForm";
		var data = ajaxSumbit(url, formId);
		if(data == "success"){
			alert("修改成功");
			disedit('2');
			init();
		}else{
			alert("保存出错！");
		}
	}
	
	function init(){
		var url = "user/personalSettingsEdit.do";
		var data = ajaxSumbitNoform(url, "123");
		document.getElementById('name').innerHTML = data.username;
		document.getElementById('editName').value = data.name;
		document.getElementById('jobName').innerHTML =data.JobName ;
		document.getElementById('phone').innerHTML = data.phone;
		document.getElementById('creatTime').innerHTML = "注册时间："+data.CreatTime;
		document.getElementById('userName').innerText = data.userName;
		document.getElementById('touxiang').src = data.touxiang;
		nowJobList = data.nowJobList;
		emadilstatus = data.emadilstatus;
	}
	
</script>
<body bgcolor="#F4F9F9" onload="init()">
<form id="personalSettingsEditForm">
	<div style="width:100%;height:55px;background: #000;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;">
		<table style="width:100%;white-space: nowrap;">
			<tr>
				<td width="270px" style="padding-left:150px;"><img src="../img/U-Offerlogo.png"></td>
				<td class="textC">
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('finduser.jsp')">
				    	<font size="3">候选人</font>
				    </button>
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="booleanInfot('user_view.jsp')">
				    	<font size="3">已发邀请</font>
				    </button>
			    </td>
			    <td class="textC" width="270px">
				    <div class="btn-group">
						<button type="button" style="height:55px !important;color:#FFF;background-color:#000;"
						 class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)"
						 onmouseout="changeColor2(this)" id="user"><span id="userName" name="userName"></span>
					        <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu2" style="">
					        <li role="presentation">
					            <a role="menuitem" tabindex="-1" href="#" onclick="javascript:top.location.href='personal_settings_edit.jsp'"><font color="#000">个人设置</font></a>
					            <a role="menuitem" tabindex="-1" href="#" onclick="javascript:top.location.href='firm_resume_add.jsp'"><font color="#000">企业信息</font></a>
					        </li>
					    </ul>
				    </div>
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
			<td width="5%" rowspan="10"/>
			<td rowspan="10" width="250px" valign="top">
				<table width="100%" style="background:#FFF">
					<tr><td class="textL" style="background:#00B38A;color:#FFF;cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" onclick="javascript:top.location.href='personal_settings_edit.jsp'"><font size="3">账号信息</font></td></tr>
					<tr><td class="textL" style="cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" onclick="javascript:top.location.href='team_member.jsp'"><font size="3">团队成员</font></td></tr>
					<tr><td class="textL" style="cursor:pointer;padding-top:15px;padding-bottom:15px;padding-left:60px;padding-right:20px;" onmouseover="changeColor3(this)" onmouseout="changeColor4(this)" onclick="javascript:top.location.href='personal_questionnaire.jsp'"><font size="3">需求问卷</font></td></tr>
				</table>
			</td>
			<td width="30px" rowspan="2" style="border-right:2px #0dad87 solid;" valign="top">
				<table width="100%">
					<tr><td class="textR" style="padding-top:15px;padding-bottom:15px;"><div class="triangle-left" style="float:right"></div></td></tr>
					<tr><td class="textR" style="padding-top:15px;padding-bottom:15px;"></td></tr>
					<tr><td class="textR" style="padding-top:15px;padding-bottom:15px;"></td></tr>
				</table>
			</td>
			<td class="textL">
				<div style="background: #FFFFFF; width: 750px;padding-top:30px;padding-left:40px;">
					<table width="100%">
						<tr>
							<td width="100px" style="padding-top:10px;padding-bottom:10px;" class="textL" rowspan="2">
								<img id="touxiang" src="../img/changjinglu.jpg" width="100px" height="100px" style="border-radius:20px;"/>
							</td>
							<td valign="bottom" style="width:120px;padding:10px;" ><font id="name" size="5" ></font></td>
							<td valign="bottom">
								<table id="edit" style="display:none;">
									<tr>
										<td style="padding:0px 10px;"><input id="editName" type="text" name="editName" class="form-control" style="width:200px;"></td>
										<td style="padding:0px 10px;">
											<button type="button" class="btn btn-primary" data-toggle="button"
											style="background-color: #00B38A; border-color: #00B38A;" onclick="submitName()">
											保存</button>
										</td>
										<td style="padding:0px 10px;">
											<a onclick="disedit('2')" href="#"><font color="#00B38A">取消</font></a>
										</td>
									</tr>
								</table>
								<a onclick="disedit('1')" href="#" id="edita"><font size="1" color="#00B38A">编辑</font></a>
							</td>
							<td width="120px"/>
						</tr>
						<tr>
							<td colspan="2"><font id="creatTime" color="#999999" size="1"></font></td>
						</tr>
						<tr height="20px"/>
						<tr>
							<td style="height:1px;background:#999999;" colspan="3"></td>
						</tr>
					</table>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div style="background: #FFFFFF; width: 750px;padding-top:30px;padding-left:40px;">
					<table width="100%">
						<tr height="40px">
							<td width="100px">
								<font style="background:#DDDDDD;padding:5px 20px;width:100px;" size="1">
								&nbsp;&nbsp;&nbsp;&nbsp;职位&nbsp;&nbsp;&nbsp;&nbsp;
								</font>
							</td>
							<td style="width:500px;">
								<font id="jobName" size="2"></font>&nbsp;&nbsp;&nbsp;
								<a href="#" onclick="openWindow('job')"><font size="1" color="#00B38A">修改职位</font></a>
							</td>
							<td/>
						</tr>
						<tr height="40px">
							<td width="100px">
								<font style="background:#DDDDDD;padding:5px 20px;width:100px;" size="1">
								&nbsp;&nbsp;&nbsp;&nbsp;密码&nbsp;&nbsp;&nbsp;&nbsp;
								</font>
							</td>
							<td style="width:500px;">
								<a href="#" onclick="openWindow('password')"><font size="1" color="#00B38A">修改密码</font></a>
							</td>
							<td/>
						</tr>
						<tr height="40px">
							<td width="100px">
								<font style="background:#DDDDDD;padding:5px 20px;width:100px;" size="1">
									&nbsp;&nbsp;&nbsp;&nbsp;手机&nbsp;&nbsp;&nbsp;&nbsp;
								</font>
							</td>
							<td style="width:500px;">
								<font id="phone" size="2"></font>&nbsp;&nbsp;&nbsp;
								<a href="#" onclick="openWindow('phone')"><font size="1" color="#00B38A">解绑手机</font></a>
							</td>
							<td/>
						</tr>
						<tr height="40px">
							<td width="100px">
								<font style="background:#DDDDDD;padding:5px 20px;width:100px;" size="1">通知信息</font>
							</td>
							<td style="width:500px;">
								<font size="2">已开启&nbsp;邮件通知&nbsp;邮件订阅</font>&nbsp;&nbsp;&nbsp;
								<a href="#" onclick="openWindow('email')"><font size="1" color="#00B38A">编辑</font></a>
							</td>
							<td/>
						</tr>
						<tr height="100px"/>
					</table>
				</div>
			</td>
		</tr>
	</table>
	</form>
	<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" style="display:none;" id="wins">开始演示模态框</button>
	<form id=savemyModalFROM">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="overflow-y:hidden;margin-top:100px;">
	    <input type='hidden' name='selectjobId1' id='selectjobId'/>
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title textC" id="myModalLabel"></h4>
	            </div>
	            <div class="modal-body" id="winbody" style="overflow-y:auto;min-height:200px;max-height:300px;border-bottom:none;">
	            </div>
	            <div class="modal-footer" style="border-top:none;" id="footer">
	            	<center>
	            		<button type='button' class='btn btn-default' data-dismiss='modal' style="background:#00B389;color:#FFF;width:350px;" onclick="saveModal()">确定</button>
	            	</center>
	            </div>
	        </div>
	    </div>
	</div>
	</form>
</body>
</html>