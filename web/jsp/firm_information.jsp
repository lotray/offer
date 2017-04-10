<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<style>
	#userTable td{
		border:1px #CCCCCC solid;
		height:47px;
		min-width:80px;
	}
</style>
<script language="javascript">
	function init(){
		if(isResetLogin()) {
			alert("登陆超时!");
			top.location.href='stafflogin.jsp';
		}
		else{
			var url = "login/firmInformation1.do?pageId=" + 1;
			var formId = "finduserForm";
			var data = ajaxSumbit(url, formId);
			document.getElementById("allNum").innerText=data.allNum;
			addLi(data.city,"city");
			//addLi(data.job,"job");
			addLi(data.status,"status");
			addList(data.firmList);
			addpageNum(data.pageNum,"u1");
		}
	}
	//下拉列表
	function addLi(items,liId){
		var inn = "";
		for(var i in items){
			inn = inn + "<li role='presentation'>"
				+"<a role='menuitem' onclick='selectDownValue(" + items[i].id +",\"" + items[i].value +"\",\""+liId+"\")'><font color='#000'>" + items[i].value
				+"</font></a></li>";
		}
		document.getElementById(liId).innerHTML=inn;
	}
	function selectDownValue(ke, val, targetInput){
		var ti1 = "firm" + targetInput;
		var ti2 = "firm" + targetInput + "Value";
		document.getElementById(ti1).value=ke;
		document.getElementById(ti2).value=val;
		goSearch();
	}
	
	function goSearch() {
		/* var pageId = document.getElementById('pageId').value;
		var firmcity = document.getElementById('firmcity').value;
		var firmcityValue = document.getElementById('firmcityValue').value;
		var firmstatus = document.getElementById('firmstatus').value;
		var firmstatusValue = document.getElementById('firmstatusValue').value; */
		
		
		var url = "login/firmInformation1.do?";//pageId=" + pageId + "&firmcityValue=" + firmcityValue + "&firmstatus=" + firmstatus;
		var formId = "finduserForm";
		var data = ajaxSumbit(url, formId);
		addList(data.firmList);
	}
	//增加列表
	function addList(items){
		var j = 0;
		$("#userTable tbody").html("");
		for(var i in items){
			var tr1 = document.createElement("tr");
			tr1.id = "t" + j;
			document.getElementById("tbody").appendChild(tr1);
			document.getElementById("t" + j).innerHTML = "<td class='textC'>"
								+"<font size='1'>"+items[i].address+"</font>"
							+"</td>"       
							+"<td class='textC'>"
								+"<font size='1'>"+items[i].lingyu+"</font>"
							+"</td>"
							+"<td class='textC'>"
								+"<font size='1'>"+items[i].name+"</font>"
							+"</td>"
							+"<td class='textC'>"
								+"<font size='1'>"+items[i].guimo+"</font>"
							+"</td>"
							+"<td class='textC'>"
								+"<font size='1'>"+items[i].rongzi+"</font>"
							+"</td>"
							+"<td class='textC'>"
								+"<font size='1'>"+items[i].shenqingren+"</font>"
							+"</td>"
							+"<td class='textC'>"
								+"<font size='1'>"+items[i].zhiwei+"</font>"
							+"</td>"
							+"<td class='textC'>"
								+"<font size='1'>"+items[i].phone+"</font>"
							+"</td>"
							+"<td class='textC'>"
								+"<font size='1'>"+items[i].shenqingtime+"</font>"
							+"</td>"
							+"<td class='textC'>"
								+"<font size='1'>"+items[i].teammember+"</font>"
							+"</td>"
							+"<td class='textC'>"
								+"<font size='1'>"+items[i].status+"</font>"
							+"</td>"
							+"<td class='textC'>"
								+"<font size='1'>"+items[i].fuwu+"</font>"
							+"</td>"
							+"<td class='textC'>"
								+"<button type='button' style='height:34px !important;background-color:#3CBAFF;color:#FFF;' onclick='goView(\""+items[i].id+"\")' class='btn dropdown-toggle' data-toggle='dropdown'>"
								+"查看"
								+"</button>"
							+"</td>";
			j = j + 1;
		}
	}
	function addpageNum(items,pageId){
		var inn = "";
		for(var i = 1; i <= items; i++){
			inn = inn + "<li>"
				+"<a href='#' onclick='getpage("+i+")'>"+i+"</a>"
				+"</li>";
		}
		document.getElementById(pageId).innerHTML=inn;
	}
	function getpage(str) {
		document.getElementById('pageId').value = str;
		goSearch();
	}
	function goView(id){
		var url = "login/sessionPutFirm.do";
		var data = ajaxSumbitNoform(url, id);
		top.location.href='firm_all_information.jsp';
	}
</script>
<body bgcolor="#FFF" onload="init()">
	<form id="finduserForm">
	<div style="width:100%;padding:20px 200px;">
		<table width="100%">
			<!-- <tr height="20px"/> -->
			<tr>
				<td width="220px">
					<div class="input-group" style="width: 100%;">
						<div class="dropdown">
							<input type="hidden" id="firmcity" name="firmcity"/>
							<input type="text" name="firmcityValue" id="firmcityValue" class="form-control" placeholder="城市" style="margin-left:-20px;width: 164px !important" readonly>
						    <button type="button" style="height:34px !important;background-color:#3CBAFF;color:#FFF;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
						        <span class="caret"></span>
						    </button>
						    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="margin-left:-20px;width: 90% !important" id="city">
						        
						    </ul>
						</div>
					</div>
				</td>
				<td width="220px">
					<div class="input-group" style="width: 100%;">
						<div class="dropdown">
							<input type="hidden" id="firmstatus" name="firmstatus"/>
							<input type="text" name="firmstatusValue" id="firmstatusValue" class="form-control" placeholder="状态" style="margin-left:-20px;width: 164px !important" readonly>
						    <button type="button" style="height:34px !important;background-color:#3CBAFF;color:#FFF;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
						        <span class="caret"></span>
						    </button>
						    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="margin-left:-20px;width: 90% !important" id="status">
						        
						    </ul>
						</div>
					</div>
				</td>
				<td class="textR">
					<input type="text" name="firmSimpleName" id="firmSimpleName" class="form-control" placeholder="公司简称" style="margin-left:-20px;width: 164px !important" onchange="goSearch()">
				</td>
				<td/>
			</tr>
		</table>
	</div>
	<div style="width:100%;padding:20px 180px;">
		<font size="1">
			共
			<font color="#3CBAFF" size="3" id="allNum">140</font>
			个匹配项，显示
			<font color="#3CBAFF" size="3">1-20</font>
		</font>
		<br/>
		<br/>
		<table width="100%" style="border:1px #CCCCCC solid;" id="userTable">
			<thead>
				<tr>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">地区</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">领域</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">公司简称</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">公司规模</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">融资阶段</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">申请人</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">职位</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">电话</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">申请时间</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">团队成员</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">状态</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">服务期限</font>
					</td>
					<td class="textC" style="background:#E2E2E2;">
						<font size="1">操作</font>
					</td>
				</tr>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>
	</div>
	<div style="padding:0px 180px;">
		<input type="hidden" name="pageId" id="pageId" value="1"/>
		<ul class="pagination" id="u1" style="margin-top:10px;">
		</ul>
	</div>
	</form>
</body>
</html>