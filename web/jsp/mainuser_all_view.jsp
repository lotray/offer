<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<style>
	.date-control{
		width:100%;height:34px;padding:6px 12px;font-size:14px;line-height:1.42857143;
		color:#555;background-color:#fff;background-image:none;border:1px solid #ccc;border-radius:4px;
		-webkit-box-shadow:inset 0 1px 1px rgba(0,0,0,.075);box-shadow:inset 0 1px 1px rgba(0,0,0,.075);
		-webkit-transition:border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
		-o-transition:border-color ease-in-out .15s,box-shadow ease-in-out .15s;
		transition:border-color ease-in-out .15s,box-shadow ease-in-out .15s
	}
</style>
	
	
</head>
<script language="javascript">
	function init(){
		goSearch();
		selecttype();
	}
	function goSearch(){
		document.getElementById('inviteId').value=parent.document.getElementById('inviteId').value;
		var nowInviteId = parent.document.getElementById('inviteId').value;
		if (nowInviteId == 'undefined'){
			document.getElementById("interviewtypediv").style.display = "none";
		}
		else if (nowInviteId != "") {
			document.getElementById('usertype').value=parent.document.getElementById('usertype').value;
			var url = "firm/userviewPage3.do";
			var formId = "returninterview";
			var data = ajaxSumbit(url, formId);
			parent.document.getElementById('inviteId').value = data.inviteId;
			addhead(data.head);
			addcommit(data.commit);
			document.getElementById('status').value=data.status;
			if (document.getElementById('status').value == '0') {
				interviewreturn1("候选人还未查看你的邀请，请耐心等待");
			}
			else {
				interviewreturn("","可以在此处回复候选人");
			}
			document.getElementById('candidateId').value = data.candidateId;
		}
		else {
			document.getElementById("interviewtypediv").style.display = "none";
		}
	}
	function addhead(item){
		var header = "";
		header = header + "<table style='width: 100%;padding-top:5px;padding-left:50px;border-collapse:separate !important;'>"
							+"<tr>"
								+"<td class='textL' id='userName' style='padding:20px 0px;' colspan='2'><font size='3'>"+item.name+"</font></td>"
							+"</tr>"
							+"<tr>"
								+"<td class='textL' style='padding:5px 0px;'><font size='1' color='#999999' colspan='2'>职位：</font><font size='1' id='userJob'>"+item.job+"</font></td>"
							+"</tr>"
							+"<tr>"
								+"<td class='textL' style='padding:5px 0px;'><font size='1' color='#999999'>工作地点：</font><font size='1' id='userworkplace'>"+item.workplace+"</font></td>"
								+"<td class='textL' rowspan='2'>"
									+"<button type='button' class='btn btn-primary' onclick='viewresume()' data-toggle='button' style='border-radius: 20px;color:#00B389;background:#FFF; border-color: #00B38A; width: 150px'>"
										+"查看详细简历"
									+"</button>"
								+"</td>"
							+"</tr>"
							+"<tr>"
								+"<td class='textL' style='padding:5px 0px;'><font size='1' color='#999999'>薪酬：</font><font size='1' id='userMoney'>"+item.money+"</font></td>"
							+"</tr>"
							+"<tr height='20px'/>"
						+"</table>";
		document.getElementById("header").innerHTML = header;
	}
	function addcommit(items){
		var form1 = document.getElementById("commit");
		var div1 = "";
		var cStatus = "";
		for(var i in items){
			cStatus = items[i].cStatus;
			if (cStatus == 'true') {
				cStatus = "<td class='textL' style='padding:20px;'>"
					+ "<font size='1' color='green'>面试成功</font>"
					+ "</td>"
			}
			else {
				cStatus = "";
			}
			div1 = div1 + "<div style='width: 100%;border-top:1px #CCCCCC solid;border-bottom:1px #CCCCCC solid;'>"
							+ "<table style='width: 100%;padding-top:25px;padding-left:50px;border-collapse:separate !important;'>"
								+ "<tr>"
									+ "<td style='width:80px !important;' class='textL'>"
										+ "<img src='" + items[i].image + "' width='80px' height='80px'/>"
									+ "</td>"
									+ "<td class='textL' style='padding:20px;'>"
										+ "<font size='1'>"+items[i].name+"</font>"
									+ "</td>"
									+ "<td width='100px' class='textC'>"
										+ "<font size='1' color='#00B38A'>"+items[i].time+"</font>"
									+ "</td>"
								+ "</tr>"
								+ "<tr>"
								+ cStatus
								+ "</tr>"
								+ "<tr>"
									+ "<td class='textL' colspan='3' style='padding:20px;'><font size='1'>"+items[i].content+"</font></td>"
								+ "</tr>"
							+ "</table>"
						+ "</div>";
		}
		form1.innerHTML=div1;
	}
	function interviewreturn(title,tvalue){
		var div1 = "<table style='width: 100%;padding-top:5px;padding-left:50px;border-collapse:separate !important;'>"
						+"<tr>"
							+"<td style='width:90px !important;padding:10px 0px;' class='textL'>"
								+"<font size='2'>"+title+"</font>"
							+"</td>"
						+"</tr>"
						+"<tr>"
							+"<td class='textL'>"
								+"<textarea style='width:90%;' rows='6' name='chatMessage' placeholder='"+tvalue+"'></textarea>"
							+"</td>"
						+"</tr>"
						+"<tr>"
							+"<td class='textL' style='padding:10px 0px;'>"
								+"<button type='button' class='btn btn-primary' onclick='validateCode()' data-toggle='button'"
								+" style='background-color: #00B38A !important; border-color: #00B38A !important; width: 40%'>"
								+"提交</button>"
							+"</td>"
						+"</tr>"
					+"</table>";
		document.getElementById("interviewdiv").innerHTML=div1;
	}
	function interviewreturn1(title,tvalue){
		var div1 = "<table style='width: 100%;padding-top:5px;padding-left:50px;border-collapse:separate !important;'>"
						+"<tr>"
							+"<td style='width:90px !important;padding:10px 0px;' class='textL'>"
								+"<font size='2' color='gray' >"+title+"</font>"
							+"</td>"
						+"</tr>"
						+"<br/><br/>"
					+"</table><br/><br/>";
		document.getElementById("interviewdiv").innerHTML=div1;
	}
	function selectinterview(obj){
		$(".active").each(function () {
			this.setAttribute("class","");
		});
		if(obj.id == "interviewtype1"){
			interviewreturn("","可以在此处回复候选人");
			document.getElementById('status').value = 1;
			document.getElementById("ispass").style.display = "none";
		}
		if(obj.id == "interviewtype2"){
			var title = "发送面试通知，候选人会收到邮件提示，<br/>如果候选人同意面试的时间不合适，可致电我们，由我们顾问来协调时间。";
			var url = "firm/userviewanpaiPage3.do";
			var formId = "returninterview";
			var data = ajaxSumbit(url, formId);
			addanpai(title);
			addtime(data);
			$(".form_datetime2").datetimepicker({
		        format: "yyyy-mm-dd",
		        autoclose:true,
		        startView: 'month',
		        minView:'month',
		        maxView:'decade',
		        language:'zh-CN'
		    });
			document.getElementById('interviewworkspace').value = data.interviewworkspace;
			document.getElementById('interviewWay').value = data.interviewWay;
			document.getElementById('interviewman').value = data.interviewman;
			document.getElementById('status').value = 3;
		}
		if(obj.id == "interviewtype3"){
			interviewreturn("候选人同意面试邀请后，如因简历不合适，可以在此处撤销面试邀请","可以在此处回复候选人");
			document.getElementById('status').value = 6;
		}
		if(obj.id == "interviewtype4"){
			interviewreturn("无论候选人是否通过面试，第一时间反馈结果是对候选人的尊重","可以在此处回复候选人");
			document.getElementById('status').value = 4;
			document.getElementById("ispass").style.display = "block";
		}
		obj.parentNode.setAttribute("class","active");
		document.getElementById("interviewtype").value=obj.id;
	}
	
	function isPass(str) {
		if (str == '通过') {
			document.getElementById('status').value = 4;
			document.getElementById('passValue').value = "通过";
		}
		else {
			document.getElementById('status').value = 5;
			document.getElementById('passValue').value = "不通过";
		}
	}
	function viewresume(){
		var userId = document.getElementById('candidateId').value;
		var url = "firm/findUserInformation.do?offerCandidateId="+userId;
		var formId = "returninterview";
		var data = ajaxSumbit(url, formId);
		if(data == 'success'){
			top.location.href='resume_view.jsp';
		}
	}
	function selecttype(){
		if(document.getElementById("usertype").value == "'0','1'"){
			document.getElementById("interviewtypediv").style.display = "none";
		}
		if(document.getElementById("usertype").value == 1){
			document.getElementById("interviewtypediv").style.display = "none";
		}
		if(document.getElementById("usertype").value == 2){
			document.getElementById("interviewtypediv").style.display = "";
			document.getElementById("interviewtype1").parentNode.style.display = "";
			document.getElementById("interviewtype2").parentNode.style.display = "";
			document.getElementById("interviewtype3").parentNode.style.display = "";
			document.getElementById("interviewtype4").parentNode.style.display = "none";
		}
		if(document.getElementById("usertype").value == 3){
			document.getElementById("interviewtypediv").style.display = "";
			document.getElementById("interviewtype1").parentNode.style.display = "";
			document.getElementById("interviewtype2").parentNode.style.display = "none";
			document.getElementById("interviewtype3").parentNode.style.display = "none";
			document.getElementById("interviewtype4").parentNode.style.display = "";
		}
		if(document.getElementById("usertype").value == 4){
			document.getElementById("interviewtypediv").style.display = "";
			document.getElementById("interviewtype1").parentNode.style.display = "";
			document.getElementById("interviewtype2").parentNode.style.display = "none";
			document.getElementById("interviewtype3").parentNode.style.display = "none";
			document.getElementById("interviewtype4").parentNode.style.display = "none";
		}
		if(document.getElementById("usertype").value == 5){
			document.getElementById("interviewtypediv").style.display = "";
			document.getElementById("interviewtype1").parentNode.style.display = "";
			document.getElementById("interviewtype2").parentNode.style.display = "";
			document.getElementById("interviewtype3").parentNode.style.display = "";
			document.getElementById("interviewtype4").parentNode.style.display = "none";
		}
		if(document.getElementById("usertype").value == "'4','5','6'"){
			document.getElementById("interviewtypediv").style.display = "";
			document.getElementById("interviewtype1").parentNode.style.display = "";
			document.getElementById("interviewtype2").parentNode.style.display = "none";
			document.getElementById("interviewtype3").parentNode.style.display = "none";
			document.getElementById("interviewtype4").parentNode.style.display = "none";
		}
	}
	/* $(function(){
	    $(".form_datetime2").datetimepicker({
	        format: "yyyy-mm-dd",
	        autoclose:true,
	        startView: 'month',
	        minView:'month',
	        maxView:'decade',
	        language:'zh-CN'
	    });
	}) */
	function addanpai(title){
		var div1 = "<table style='width: 100%;padding-top:25px;padding-left:50px;border-collapse:separate !important;'>"
			+"<tr>"
				+"<td style='width:90px !important;padding:10px 0px;' class='textL' colspan='3'>"
					+"<font size='2'>"+title+"</font>"
				+"</td>"
			+"</tr>"
			+"<tr height='70px'>"
				+"<td class='textL' width='70px'>"
					+"<font size='1'>面试时间</font>"
				+"</td>"
				+"<td class='textL' width='200px'>"
					+"<div class='input-append date form_datetime2' style='width: 90% !important'>"//input-group 
						//+"<div class='dropdown'>"
							+"<input type='hidden' name='interviewtime' id='interviewtime' data-date-format='yyyy-mm-dd'>"
							+"<input size='16' type='text' value='' class='date-control' readonly name='interviewtimeValue' id='interviewtimeValue'>"//style='width:100%;height:34px;padding:6px 12px;font-size:14px;line-height:1.42857143;color:#555;background-color:#fff;background-image:none;border:1px solid #ccc;border-radius:4px;'
							//+"<input type='text' name='interviewtimeValue' id='interviewtimeValue' class='form-control' style='width: 180px;'>"
							+"<span class='add-on'><i class='icon-th'></i></span>"
							/* +"<button type='button' style='height:34px !important;background-color:#E6E6E6;' class='btn dropdown-toggle' id='dropdownMenu1' data-toggle='dropdown'>"
								+"<span class='caret'></span>"
							+"</button>"
							+"<ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1' style='width: 90% !important;' id='interviewtimeList'>"
							+"</ul>" */
						//+"</div>"
					+"</div>"
				+"</td>"
				+"<td class='textL'>"
					+"<div class='input-group' style='margin-left:-10px !important;width: 90% !important'>"
						+"<div class='dropdown'>"
							+"<input type='hidden' name='interviewtime2' id='interviewtime2'>"
							+"<input type='text' name='interviewtimeValue2' id='interviewtimeValue2' class='form-control' style='width: 50px;'>"
							+"<button type='button' style='height:34px !important;background-color:#E6E6E6;' class='btn dropdown-toggle' id='dropdownMenu1' data-toggle='dropdown'>"
								+"<span class='caret'></span>"
							+"</button>"
							+"<ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1' style='width: 90% !important;' id='interviewtimeList2'>"
							+"</ul>"
						+"</div>"
					+"</div>"
				+"</td>"
			+"</tr>"
			+"<tr height='70px'>"
				+"<td class='textL' width='70px'>"
					+"<font size='1'>面试地点</font>"
				+"</td>"
				+"<td class='textL' width='230px'>"
					+"<input type='text' name='interviewworkspace' id='interviewworkspace' class='form-control' style='width: 200px;'>"
				+"</td>"
			+"</tr>"
			+"<tr height='70px'>"
				+"<td class='textL' width='70px'>"
					+"<font size='1'>联系人</font>"
				+"</td>"
				+"<td class='textL' width='230px'>"
					+"<input type='text' name='interviewman' id='interviewman' class='form-control' style='width: 200px;'>"
				+"</td>"
			+"</tr>"
			+"<tr height='70px'>"
				+"<td class='textL' width='70px'>"
					+"<font size='1'>联系方式</font>"
				+"</td>"
				+"<td class='textL' width='230px'>"
					+"<input type='text' name='interviewWay' id='interviewWay' class='form-control' style='width: 200px;'>"
				+"</td>"
			+"</tr>"
			+"<tr>"
				+"<td class='textL' style='padding:10px 0px;' colspan='3'>"
					+"<button type='button' class='btn btn-primary' onclick='goSumbit()' data-toggle='button'"
					+" style='background-color: #00B38A !important; border-color: #00B38A !important; width: 40%'>"
					+"提交</button>"
				+"</td>"
			+"</tr>"
		+"</table>";
		document.getElementById("interviewdiv").innerHTML=div1;
	}
	function addtime(data){
		var time1 = ""+"<li role='presentation'>";
		var time2 = ""+"<li role='presentation'>";
		for(var i in data.interviewtimeList1){
			time1+="<a role='menuitem' tabindex='-1' href='#' onclick=selecttime1(this) id='"+data.interviewtimeList1[i].id+"'><font color='#000'>"+data.interviewtimeList1[i].value+"</font></a>"
		}
		for(var i in data.interviewtimeList2){
			time2+="<a role='menuitem' tabindex='-1' href='#' onclick=selecttime2(this) id='"+data.interviewtimeList2[i].id+"'><font color='#000'>"+data.interviewtimeList2[i].value+"</font></a>"
		}
		time1 = time1 + "</li>";
		time2 = time2 + "</li>";
		//document.getElementById("interviewtimeList").innerHTML=time1;
		document.getElementById("interviewtimeList2").innerHTML=time2;
	}
	function selecttime1(obj){
		document.getElementById("interviewtime").value = obj.id;
		document.getElementById("interviewtimeValue").value = obj.innerText;
	}
	function selecttime2(obj){
		document.getElementById("interviewtime2").value = obj.id;
		document.getElementById("interviewtimeValue2").value = obj.innerText;
	}
	function goSumbit(){
		var status = document.getElementById('status').value;
		var url = "firm/saveuserview3.do";
		var formId = "returninterview";
		var data = ajaxSumbit(url, formId);
		if (data == 'success') {
			parent.document.getElementById('inviteId').value=document.getElementById('inviteId').value;
			if (status == 3 || status == 4 || status == 5 || status == 6) {
				top.location.href="user_view.jsp";
			}
			else {
				parent.window.iframe2.location.href="mainuser_all_view.jsp";
			}
		}
		else {
			alert("保存出错!");
		}
	}
	
	function validateCode() {
		var status = document.getElementById('status').value;
		var url = "firm/saveuserview3.do";
		var formId = "returninterview";
		var data = ajaxSumbit(url, formId);
		if (data == 'success') {
			parent.document.getElementById('inviteId').value=document.getElementById('inviteId').value;
			if (status == 3 || status == 4 || status == 5 || status == 6) {
				top.location.href="user_view.jsp";
			}
			else {
				parent.window.iframe2.location.href="mainuser_all_view.jsp";
			}
		}
		else {
			alert("保存出错!");
		}
	}
</script>
<style>
</style>
<body bgColor="#FFF" onload="init()" style="overflow-x:hidden;">
	<div class="getColor" style="width:100%;" id="header">
	</div>
	<div id="commit" style="width:100%;">
	</div>
	<form id="returninterview">
	<div style="width:100%;border:1px #999999 solid;background:#00B38A;" id="interviewtypediv">
		<input type="hidden" id="interviewtype" name="interviewtype">
		<input type="hidden" id="inviteId" name="inviteId"/>
		<input type="hidden" id="usertype" name="usertype"/>
		<input type="hidden" id="status" name="status" />
		<input type="hidden" id="candidateId" name="candidateId" />
		<ul class="nav nav-tabs nav-justified" style="width:100%">
		  <li style="bottom:-3px;float:left;width:20%" class="active"><a href="#" onclick="selectinterview(this)" id="interviewtype1"><font color="#000" size="1">和ta沟通</font></a></li>
		  <li style="bottom:-3px;float:left;width:20%" ><a href="#" onclick="selectinterview(this)" id="interviewtype2"><font color="#000" size="1">安排面试</font></a></li>
		  <li style="bottom:-3px;float:left;width:30%" ><a href="#" onclick="selectinterview(this)" id="interviewtype3"><font color="#000" size="1">撤销此面试邀请</font></a></li>
		  <li style="bottom:-3px;float:left;width:30%" ><a href="#" onclick="selectinterview(this)" id="interviewtype4"><font color="#000" size="1">反馈面试结果</font></a></li>
		</ul>
	</div>
	<div id="ispass" style="display:none">
		<table style="border-collapse: separate; border-spacing: 10px; width: 100%; padding-left:30px;">
			<tr>
				<td colspan="2">
					<div class="input-group" style="margin-left:0px !important;width: 90% !important">
						<div class="dropdown" style="">
							<input type="text" name="passValue" id="passValue" readOnly="readOnly" class="form-control" style="width: 30% !important">
						    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
						        <span class="caret"></span>
						    </button>
						    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 30% !important">
						        <li role="presentation">
						            <a role="menuitem" tabindex="-1" href="#" onclick='isPass("通过")'><font color="#000">通过</font></a>
						            <a role="menuitem" tabindex="-1" href="#" onclick='isPass("不通过")'><font color="#000">不通过</font></a>
						        </li>
						    </ul>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div class="getColor" style="width:100%;" id="interviewdiv">
	</div>
	</form>
</body>
</html>
