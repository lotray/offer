<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<script language="javascript">
    var phoneCode = ""; 
	//头部
	function changeColor1(der){
		der.style.background="#CCCCCC";
	}
	function changeColor2(der){
		der.style.background="#32373C";
	}
	function init() {
		code2 = createValidateCode('vCode2');
		getTran('1');
		var regit = document.getElementById('regit');
		regit.focus();
		var b = document.getElementById('button1');
		b.focus();
		var url = "register/jobList1.do";
		var formId = "registerForm";
		var data = ajaxSumbit(url, formId);
		addJob(data.nowJob);
		addJobF(data.jobF);
		addCity(data.city);
	}
	//选择用户/企业
	var code2;
	function getTran(ret) {
		var trans1 = document.getElementById('transparent1');
		var trans2 = document.getElementById('transparent2');
		if (ret == '1') {
			trans1.setAttribute("class", "triangle-up");
			trans2.setAttribute("class", "");
			document.getElementById("type").value="1";
			clearTable();
			code2.update();
			document.getElementById("firmTable").style.display="none";
			document.getElementById("userTable").style.display="";
		}
		if (ret == '2') {
			trans2.setAttribute("class", "triangle-up");
			trans1.setAttribute("class", "");
			document.getElementById("type").value="2";
			clearTable();
			code2.update();
			document.getElementById("userTable").style.display="none";
			document.getElementById("firmTable").style.display="";
		}
	}
	//目前职位
	function addJob(items){
		var inn = "";
		for(var i in items){
			inn = inn + "<li role='presentation'>"
				+"<a role='menuitem' onclick='jobValue(" + items[i].id +",\"" + items[i].value +"\")'><font color='#000'>" + items[i].value
				+"</font></a></li>";
		}
		document.getElementById("nowjob").innerHTML=inn;
	}
	function jobValue(ke, val){
		document.getElementById("nowjobkey").value=ke;
		document.getElementById("nowjobvalue").value=val;
	}
	//求职方向
	function addJobF(items){
		var inn = "";
		for(var i in items){
			inn = inn + "<li role='presentation'>"
				+"<a role='menuitem' onclick='jobFValue(" + items[i].id +",\"" + items[i].value +"\")'><font color='#000'>" + items[i].value
				+"</font></a></li>";
		}
		document.getElementById("jobF").innerHTML=inn;
	}
	function jobFValue(ke, val){
		document.getElementById("jobFkey").value=ke;
		document.getElementById("jobFvalue").value=val;
	}
	//所在城市
	function addCity(items){
		var inn = "";
		for(var i in items){
			inn = inn + "<li role='presentation'>"
				+"<a role='menuitem' onclick='cityValue(" + items[i].id +",\"" + items[i].value +"\")'><font color='#000'>" + items[i].value
				+"</font></a></li>";
		}
		document.getElementById("city").innerHTML=inn;
	}
	function cityValue(ke, val){
		document.getElementById("citykey").value=ke;
		document.getElementById("cityvalue").value=val;
	}
	function clearTable(){
		$(".form-control").each(function () {
			this.value = "";
        });
	}
	function getmsg(){
		phoneCode = Math.floor(Math.random()*9000)+1000;
		var phone = document.getElementById("offer_user_phone").value;
		var url = "register/getmsg1.do?code="+phoneCode;
		if(phone == ""){
			alert("请输入手机号码!")
			return;
		}
		ajaxSumbitNoform(url,phone);
	}
	//同意
	var isremeber = true;
	function changeRemeber() {
		var remeberId = document.getElementById('remeberId').value;
		if (remeberId == '1') {
			document.getElementById('remeber').src = "../img/cha.png";
			document.getElementById('remeber').style.width = "17px";
			document.getElementById('remeber').style.height = "17px";
			document.getElementById('remeberId').value = '2';
			isremeber = false;
		} else if (remeberId == '2') {
			document.getElementById('remeber').src = "../img/gou.png";
			document.getElementById('remeber').style.width = "17px";
			document.getElementById('remeber').style.height = "17px";
			document.getElementById('remeberId').value = '1';
			isremeber = true;
		}
	}
	function validateCode() {
		if(!checkValue()){
			return;
		}
		if(!isremeber){
			alert("请同意协议!");
			return;
		}
		var ispassword = false;
		if(document.getElementById("type").value=="1"){
			if(document.getElementById("offer_user_password").value === document.getElementById("offer_user_password_c").value){
				ispassword = true;
			}
		}
		if(document.getElementById("type").value=="2"){
			if(document.getElementById("password").value === document.getElementById("password_c").value){
				ispassword = true;
			}
		}
		if(!ispassword){
			alert("密码不一致！");
			return;
		}
		var ispass = false;
		ispass = true;//code2.verify(document.getElementById("inputCode2").value);
		if (ispass) {
			var url = "register/register1.do";
			var formId = "registerForm";
			var data = ajaxSumbit(url, formId);
			$("#registerForm").populateForm(data);
			if(data != 'success'){
				/* if(data == 'undefined') {
					return;
				} */
				if(data == 'error') {
					alert('已经存在该账号！');
				}
				return;
			}
			//alert("注册成功，请先查看邮箱！");
			top.location.href='user_check_msg.jsp';
		}else{
			alert("验证码输入有误！");
			code2.update();
		}
		return;
	}
	function checkValue(){
		if(document.getElementById("type").value=="1"){
			if(!checkInput('email',"邮箱","30",false)) return false;
			if(!checkInput('jobFkey',"求职方向","30",false)) return false;
			if(!checkInput('citykey',"所在城市","30",false)) return false;
			if(!checkInput('offer_user_password',"密码","30",false)) return false;
		}
		if(document.getElementById("type").value=="2"){
			if(!checkInput('offer_user_company',"公司","30",false)) return false;
			if(!checkInput('offer_user_name',"目前职位","30",false)) return false;
			if(!checkInput('nowjobkey',"职位","30",false)) return false;
			if(!checkInput('offer_user_email',"邮箱","30",false)) return false;
			if(!checkInput('offer_user_phone',"手机","30",false)) return false;
			if(!checkInput('password',"密码","30",false)) return false;
// 			if(phoneCode != document.getElementById("msgCode").value) return false;
		}
		return true;
	}
	
</script>
<body bgcolor="#F5F8F9" onload="init()">
	<form id="registerForm" style="overflow-y:auto;">
	<div style="width:100%;height:60px;min-width:1000px;background: #32373C;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;">
		<table style="width:100%;white-space: nowrap;">
			<tr>
				<td width="19%" style="padding-left:12%;"><img src="../img/U-Offerlogo.png" width="109px" height="26px"></td>
				<td width="5%"/>
				<td class="textC">
					<div class="btn-group">
						<button type="button" style="font-size:14px;height:60px !important;color:#F5F8F9;background-color:#32373C;"
						 class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" onmouseover="changeColor1(this)"
						 onmouseout="changeColor2(this)">看机会
					        <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu1" style="background-color:#32373C;width:150px;">
					        <li role="presentation">
					            <a tabindex="-1" href="homepage.jsp" style="height:46px;text-align:center;padding-top:10px;" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)"><font color="#F5F8F9">首页</font></a>
					        </li>
					        <li role="presentation">
					            <a tabindex="-1" href="#" onclick="javascript:top.location.href='mainuse_strategy.jsp'" style="height:46px;text-align:center;padding-top:10px;" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)"><font color="#F5F8F9">使用攻略</font></a>
					        </li>
					        <li role="presentation" style="height:46px;">
					            <a tabindex="-1" href="mainuser_question.jsp" style="height:46px;text-align:center;padding-top:10px;" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)"><font color="#F5F8F9">常见问题</font></a>
					        </li>
					    </ul>
					</div>
					<div class="btn-group">
						<button type="button" style="font-size:14px;height:60px !important;color:#F5F8F9;background-color:#32373C;"
						 class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)"
						 onmouseout="changeColor2(this)">招人才
					        <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu2" style="background-color:#32373C;width:150px;">
					        <li role="presentation">
					            <a tabindex="-1" href="homepage.jsp" style="height:46px;text-align:center;padding-top:10px;" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)"><font color="#F5F8F9">首页</font></a>
					        </li>
					        <li role="presentation">
					            <a tabindex="-1" href="#" onclick="javascript:top.location.href='mainfirm_strategy.jsp'" style="height:46px;text-align:center;padding-top:10px;" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)"><font color="#F5F8F9">使用攻略</font></a>
					        </li>
					        <li role="presentation" style="height:46px;">
					            <a tabindex="-1" href="mainfirm_question.jsp" style="height:46px;text-align:center;padding-top:10px;" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)"><font color="#F5F8F9">常见问题</font></a>
					        </li>
					    </ul>
				    </div>
					<button type="button" style="font-size:14px;height:60px !important;color:#F5F8F9;background-color:#32373C;padding:0px 20px;"
					 class="btn dropdown-toggle" onmouseover="changeColor1(this)"
					 onmouseout="changeColor2(this)" onclick="javascript:top.location.href='maincontact_assistant.jsp'">推荐
				    </button>
			    </td>
			    <td style="width:24%;padding-right:13%">
				    <button type="button" class="btn btn-default" style="width:101px;color:#00B38A;background:#F5F8F9;" onclick="javascript:top.location.href='login.jsp'">登录</button>
				    <button id="regit" type="button" class="btn btn-default" style="margin-left:9px;width:101px;color:#FFFFFF;background:#00B38A;" onclick="javascript:top.location.href='register.jsp'">注册</button>
				</td>
			</tr>
		</table>
	</div>
	<div style="width:100%;height:90px;"></div>
	<center>
		<div style="background: #FFFFFF; width: 600px;">
			<table width="100%">
				<tr>
					<td width="25%" />
					<td width="25%" />
					<td width="25%" />
					<td width="25%" />
				</tr>
				<tr>
					<td />
					<td colspan="2" class="textC">
						<h3>注 册</h3>
					</td>
					<td />
				</tr>
				<tr>
					<td />
					<td colspan="2" class="textC">
						<input type="hidden" name="type" id="type"/>
						<div class="btn-group btn-group-lg">
							<button id="button1" type="button" class="btn btn-default"
								onclick="getTran('1')">我是候选人</button>
							<button id="button2" type="button" class="btn btn-default"
								onclick="getTran('2')">我是HR/BOSS</button>
						</div>
					</td>
					<td />
				</tr>
				<tr>
					<th />
					<td class="textC"><center>
							<div id="transparent1"></div>
						</center></td>
					<td class="textC"><center>
							<div id="transparent2"></div>
						</center></td>
					<th />
				</tr>
			</table>
		</div>
		<div style="height: 2px; width: 600px; background-color: #00B38A;"></div>
		<div style="background: #FFFFFF; width: 600px;">
			<br />
			<table style="border-collapse: separate; border-spacing: 10px; width: 100%;" id="userTable">
				<tr>
					<th class="textR" width="25%">
						<font size="1" color="#666666">邮箱：</font>
					</th>
					<td>
						<input type="text" name="email" class="form-control" style="width: 75% !important" id="email">
					</td>
				</tr>
				<tr height="1px"/>
				<tr>
					<th class="textR" width="25%">
						<input type="hidden" name="jobFkey" id="jobFkey"/>
						<font size="1" color="#666666">求职方向：</font>
					</th>
					<td>
						<div class="input-group" style="margin-left:-10px !important;width: 90% !important">
							<div class="dropdown" style="">
								<input type="text" name="jobFvalue" id="jobFvalue" class="form-control" readOnly="readOnly" style="width: 80% !important">
							    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
							        <span class="caret"></span>
							    </button>
							    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 90% !important" id="jobF">
							        
							    </ul>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<th class="textR" width="25%">
						<input type="hidden" name="citykey" id="citykey"/>
						<font size="1" color="#666666">所在城市：</font>
					</th>
					<td>
					<div class="input-group" style="margin-left:-10px !important;width: 90% !important">
						<div class="dropdown" style="">
							<input type="text" name="cityvalue" id="cityvalue" class="form-control" readOnly="readOnly" style="width: 80% !important">
						    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
						        <span class="caret"></span>
						    </button>
						    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 90% !important" id="city">
						        
						    </ul>
						</div>
					</div>
					</td>
				</tr>
				<tr height="1px"/>
				<tr>
					<th class="textR">
						<font size="1" color="#666666">密码：</font>
					</th>
					<td>
						<input type="password" name="offer_user_password" id="offer_user_password" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr height="9px"/>
				<tr>
					<th class="textR" width="25%">
						<font size="1" color="#666666">确认密码：</font>
					</th>
					<td>
						<input type="password" name="offer_user_password_c" id="offer_user_password_c" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr height="1px"/>
			</table>
			<table style="border-collapse: separate; border-spacing: 10px; width: 100%;" id="firmTable">
				<tr>
					<th class="textR" width="25%">
						<font size="1" color="#666666">公司：</font>
					</th>
					<td>
						<input type="text" name="offer_user_company" id="offer_user_company" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr height="1px"/>
				<tr>
					<th class="textR" width="25%">
						<font size="1" color="#666666">姓名：</font>
					</th>
					<td>
						<input type="text" name="offer_user_name" id="offer_user_name" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr>
					<th class="textR" width="25%">
						<input type="hidden" name="nowjobkey" id="nowjobkey"/>
						<font size="1" color="#666666">目前职位：</font>
					</th>
					<td>
					<div class="input-group" style="margin-left:-10px !important;width: 90% !important">
						<div class="dropdown" style="">

							<input type="text" name="nowjobvalue" id="nowjobvalue" readOnly="readOnly" class="form-control" style="width: 80% !important">
						    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
						        <span class="caret"></span>
						    </button>
						    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 90% !important" id="nowjob">
						        
						    </ul>
						</div>
					</div>
					</td>
				</tr>
				<tr>
					<th class="textR" width="25%">
						<font size="1" color="#666666">邮箱：</font>
					</th>
					<td>
						<input type="text" name="offer_user_email" id="offer_user_email" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr/>
				<tr>
					<th class="textR" width="25%">
						<font size="1" color="#666666">手机：</font>
					</th>
					<td>
						<input type="text" name="offer_user_phone" id="offer_user_phone" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr>
					<th class="textR" width="25%">
						<font size="1" color="#666666">验证码：</font>
					</th>
					<td>
						<div class="col-lg-6" style="width:100%;">
							<div class="input-group" style="width: 100% !important; margin-left: -22px !important;">
								<input type="text" id="msgCode" name="msgCode" class="form-control" style="width: 60% !important">
								<button type="button" class="btn btn-default" onclick="getmsg()" id="msgtime">获取验证码</button>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<th class="textR">
						<font size="1" color="#666666">密码：</font>
					</th>
					<td>
						<input type="password" name="password" id="password" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr/>
				<tr>
					<th class="textR" width="25%">
						<font size="1" color="#666666">确认密码：</font>
					</th>
					<td>
						<input type="password" name="password_c" id="password_c" class="form-control" style="width: 75% !important">
					</td>
				</tr>
			</table>
			<table style="border-collapse: separate; border-spacing: 10px; width: 100%;margin-top:-10px;">
				<tr>
					<th class="textR" width="25%">
						<font size="1" color="#666666">图形验证码：</font>
					</th>
					<td>
						<div class="col-lg-6" style="width:100%;">
							<div class="input-group" style="width: 100% !important; margin-left: -22px !important;">
								<input type="text" id="inputCode2" name="inputCode2" class="form-control" style="width: 60% !important">
								<div id="vCode2" style="width: 100px; height: 34px; border: 1px solid #ccc; display: inline-block;"></div>
							</div>
						</div>
					</td>
				</tr>
			</table>
			<center>
				<table width="250px">
					<tr>
						<td class="textL">
							<input type="hidden" id="remeberId" value="1" />
							<img id="remeber" src="../img/gou.png" width="17px" height="17px" onclick="changeRemeber()" />
							<font size="1" color="#999999">我已阅读并同意</font>
							<a href="#">
								<font size="1" color="#00B38A">《U-Offer企业注册协议》</font>
							</a>
						</td>
					</tr>
					<tr height="10px" />
					<tr>
						<td colspan="2">
							<button type="button" class="btn btn-primary" onclick="validateCode()" data-toggle="button"
								style="background-color: #00B38A !important; border-color: #00B38A !important; width: 100%">
								确认提交</button>
						</td>
					</tr>
				</table>
			</center>
			<br />
		</div>
	</center>
	</form>
</body>
</html>
