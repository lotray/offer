<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<script language="javascript">
	var dataName = "";
	//头部
	function changeColor1(der){
		der.style.background="#999999";
	}
	function changeColor2(der){
		der.style.background="#000";
	}
	function init() {
		if(isResetLogin()) {
			alert("登陆超时!");
			top.location.href='login.jsp';
		}
		else{
			var url = "user/resumeAddPlanjobPage1.do";
			var formId = "resumeAddPlanjobForm";
			var data = ajaxSumbit(url, formId);
			dataName = data.dataName;
			addWorkplace(data.workplaces);
			addCity(data.citys);
			addFirm(data.firms);
			editId(data.cityIdList, "city");
			editId(data.firmIdList, "firm");
			$("#resumeAddPlanjobForm").populateForm(data);
		}
	}
	//修改
	function editId(items, type){
		$(".hover").each(function () {
			var va = this.getElementsByTagName("input")[0].value;
			if(va == type){
				for(var i in items){
					if(this.id == items[i]){
						this.setAttribute("class","icheckbox_square-green checked");
					}
				}
			}
		});
	}
	function addWorkplace(items){
		var li = "";
		for(var i in items){
			li = li + "<li role='presentation'>"
						+"<a role='menuitem' tabindex='-1' href='#' id='"+items[i].id+"' onclick='workplaceId(this)'><font color='#000'>"+items[i].value+"</font></a>"
					+ "</li>"
		}
		document.getElementById("workplaceUl").innerHTML = li;
	}
	function workplaceId(obj){
		document.getElementById("workplaceId").value = obj.id;
		document.getElementById("workplace").value = obj.innerText;
	}
	//添加城市
	function addCity(items){
		var citys = "<table width='100%'>";
		var j = 1;
		for(var i in items){
			if(j == 1){
				citys = citys + "<tr>";
			}
			citys = citys + "<td class='textR' style='padding-top:10px;padding-bottom:10px;'>"
							+"<div class='icheckbox_square-green hover' onclick='cityId(this)' id='"+items[i].id+"'>"
								+"<input type='hidden' value='city'/>"
								+"<input tabindex='2' type='checkbox' style='opacity:0;'>"
							+"</div>"
						+"</td>"
						+"<td class='textL'><font size='2'>"+items[i].value+"</font></td>";
			if(j == 4){
				citys = citys + "</tr>";
				j = 1;
			}else{
				j = j+1;
			}
		}
		citys = citys + "</table>";
		document.getElementById('city').innerHTML=citys;
	}
	function cityId(obj){
		if(obj.getAttribute('class') == "icheckbox_square-green checked"){
			obj.setAttribute("class","icheckbox_square-green hover");
		}
		else if(obj.getAttribute('class') == "icheckbox_square-green hover"){
			obj.setAttribute("class","icheckbox_square-green checked");
		}
	}
	//添加公司
	function addFirm(items){
		var firms = "<table width='100%'>";
		var j = 1;
		for(var i in items){
			if(j == 1){
				firms = firms + "<tr>";
			}
			var a = "";
			if(items[i].value.length < 3){
				a = "style='padding-right:13px;'";
			}
			firms = firms + "<td class='textR' style='padding-top:10px;padding-bottom:10px;'>"
							+"<div class='icheckbox_square-green hover' onclick='firmId(this)' id='"+items[i].id+"'>"
							+"<input type='hidden' value='firm'/>"
								+"<input tabindex='2' type='checkbox' style='opacity:0;'>"
							+"</div>"
						+"</td>"
						+"<td class='textL'><font size='2' "+a+" >"+items[i].value+"</font></td>";
			if(j == 4){
				firms = firms + "</tr>";
				j = 1;
			}else{
				j = j+1;
			}
		}
		firms = firms + "</table>";
		document.getElementById('firm').innerHTML=firms;
	}
	function firmId(obj){
		if(obj.getAttribute('class') == "icheckbox_square-green checked"){
			obj.setAttribute("class","icheckbox_square-green hover");
		}
		else if(obj.getAttribute('class') == "icheckbox_square-green hover"){
			obj.setAttribute("class","icheckbox_square-green checked");
		}
	}
	//保存
	function goSumbit(){
		var cityId = "";
		var firmId = "";
		$(".checked").each(function () {
			var id = this.getElementsByTagName("input")[0].value;
			if(id=="firm"){
				if(firmId != ""){
					firmId = firmId + ",";
				}
				firmId = firmId + this.id;
			}
			if(id=="city"){
				if(cityId != ""){
					cityId = cityId + ",";
				}
				cityId = cityId + this.id;
			}
        });
		document.getElementById("cityIds").value = cityId;
		document.getElementById("firmIds").value = firmId;
		if(!checkValue()){
			return;
		}
		var url = "user/saveresumeAddPlanjob1.do";
		var formId = "resumeAddPlanjobForm";
		var data = ajaxSumbit(url, formId);
		if(data == "success"){
			top.location.href='resume_add_workexperience.jsp';
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
		if(!checkInput('firmIds',"您对哪个阶段的公司感兴趣","30",false)) return false;
		if(!checkInput('cityIds',"您期望在哪个城市工作","30",false)) return false;
		if(!checkInput('workplace',"工作地点","30",false)) return false;
		return true;
	}
</script>
<body bgcolor="#F4F9F9" onload="init()">
	<form id="resumeAddPlanjobForm">
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
								<td><div class="circleA"></div></td>
								<td><font color="#00B389">&nbsp;&nbsp;期望工作 </font></td>
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
								<td><div class="circleB"></div></td>
								<td><font color="#999999">&nbsp;&nbsp;调查问卷 </font></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div style="background: #FFFFFF; width: 600px;padding-top:20px;padding-bottom:20px;">
			<center><font size="3" color="#666666">Hi,你打算去哪儿工作</font></center>
		</div>
		<div style="height: 2px; width: 600px; background-color: #999999;"></div>
		<div style="background: #FFFFFF; width: 600px;">
			<br />
			<table
				style="border-collapse: separate; border-spacing: 10px; width: 100%; padding-left:30px;">
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#666666">工作地点*</font>
					</th>
				</tr>
				<tr>
					<td class="textL">
						<div class="input-group" style="margin-left:-10px !important;width: 90% !important">
							<div class="dropdown" style="">
								<input type="hidden" name="workplaceId" id="workplaceId"/>
								<input type="text" name="workplace" id="workplace" readOnly="readOnly" class="form-control" style="width: 80% !important">
							    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
							        <span class="caret"></span>
							    </button>
							    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 90% !important;height:100px;overflow-y:auto;" id="workplaceUl">
							        
							    </ul>
							</div>
						</div>
					</td>
					<td/>
				</tr>
				<tr>
					<td class="textL" colspan="2">
						<font size="1" color="#666666">您期望在哪个城市工作？（可多选）*</font>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" name="cityIds" id="cityIds"/>
						<table width="100%" id="city">
						</table>
					</td>
				</tr>
				<tr>
					<td class="textL" colspan="2">
						<font size="1" color="#666666">您对哪个阶段的公司感兴趣？（可多选）*</font>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" name="firmIds" id="firmIds"/>
						<table width="100%" id="firm">
						</table>
					</td>
				</tr>
				<tr height="10px"/>
			</table>
		</div>
		<div style="height: 2px; width: 600px; background-color: #999999;"></div>
		<div style="width: 600px; background-color: #FFF;">
			<table>
				<tr>
					<td style="padding-top:40px;padding-bottom:40px;" class="textC">
						<button type="button" class="btn btn-primary" onclick="javascript:top.location.href='resume_add_information.jsp';" data-toggle="button"
							style="color: #000 !important;background-color: #D0D0D0 !important; border-color: #999999 !important; width: 200px;">
							上一步</button>
						<button type="button" class="btn btn-primary" onclick="goSumbit()" data-toggle="button"
							style="color: #00B38A !important;background-color: #FFF !important; border-color: #00B38A !important; width: 200px;">
							下一步</button>
					</td>
				</tr>
			</table>
		</div>
	</center>
	<br/>
	<br/>
	</form>
</body>
</html>
