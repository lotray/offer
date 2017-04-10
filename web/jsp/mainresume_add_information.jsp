<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<script language="javascript">
	//头部
	function changeColor1(der){
		der.style.background="#CCCCCC";
	}
	function changeColor2(der){
		der.style.background="#32373C";
	}
	function init() {
		/* if(isResetLogin()) {
			alert("登陆超时!");
			top.location.href='login.jsp';
		}
		else{ */
			var url = "user/resumeAddInformationPage1.do";
			var formId = "userInformationForm";
			var data = ajaxSumbit(url, formId);
			dataName = data.dataName;
			addCheckJob(data.nowJobList);
			if(data.offerUserName != undefined){
				editCheckJob(data.jobId1,data.jobId2, data.jobvalue1, data.jobvalue2);
				setSexValue(data.offerUserSex);
			}
			$("#userInformationForm").populateForm(data);
		/* } */
	}
	//性别
	function setSexValue(id) {
		if(id == 1){
			document.getElementById("sex1").style="color:#FFF;background-color:#00B38A;border-color:#00B38A;width:100px;";
			document.getElementById("sex2").style="color:#00B38A;background-color:#FFF;border-color:#00B38A;width:100px;";
			document.getElementById("offerUserSex").value="1";
		}
		if(id == 0){
			document.getElementById("sex2").style="color:#FFF;background-color:#00B38A;border-color:#00B38A;width:100px;";
			document.getElementById("sex1").style="color:#00B38A;background-color:#FFF;border-color:#00B38A;width:100px;";
			document.getElementById("offerUserSex").value="0";
		}
	}
	//工作年限
	function workTimeValue(time){
		document.getElementById("offerUserWorktime").value=time;
	}
	//添加职位
	function addCheckJob(items){
		var jobs = "<table width='100%'>";
		var j = 1;
		for(var i in items){
			if(j == 1){
				jobs = jobs + "<tr>";
			}
			jobs = jobs + "<td class='textR' style='padding-top:10px;padding-bottom:10px;width:45;'>"
							+"<div class='icheckbox_square-green hover' onclick='jobId(this)' id='"+items[i].id+"'>"
								+"<input type='hidden' value='"+items[i].value+"'/>"
								+"<input tabindex='2' type='checkbox' style='opacity:0;'>"
							+"</div>"
						+"</td>"
						+"<td class='textL'><font size='2'>"+items[i].value+"</font></td>";
			if(j == 4){
				jobs = jobs + "</tr>";
				j = 1;
			}else{
				j = j+1;
			}
		}
		jobs = jobs + "</table>";
		document.getElementById('checkJob').innerHTML=jobs;
	}
	function editCheckJob(job1, job2, jobname1, jobname2){
		if(job1 != undefined){
			document.getElementById(job1).setAttribute("class","icheckbox_square-green checked");
			editworkyears(job1, jobname1, 1);
		}
		if(job2 != undefined){
			document.getElementById(job2).setAttribute("class","icheckbox_square-green checked");
			editworkyears(job2, jobname2, 2);
		}
	}
	//职位
	function jobId(job){
		var jobNum = 1;
		if(job.getAttribute('class') == "icheckbox_square-green checked"){
			delworkyears(job);
			job.setAttribute("class","icheckbox_square-green hover");
		}
		else if(job.getAttribute('class') == "icheckbox_square-green hover"){
			$(".checked").each(function () {
				jobNum = jobNum + 1;
	        });
			if(jobNum > 2){
				alert("最多选择两项");
				return;
			}
			addworkyears(job);
			job.setAttribute("class","icheckbox_square-green checked");
		}
	}
	//职位年限
	function addworkyears(obj){
		var jobId;
		var jobName;
		var jobtitle;
		if(document.getElementById("job1").getElementsByTagName("td")[0] == undefined){
			jobId = "job1";
			jobName = "jobyear1";
			jobtitle = "job1_title";
		}else if(document.getElementById("job2").getElementsByTagName("td")[0] == undefined){
			jobId = "job2";
			jobName = "jobyear2";
			jobtitle = "job2_title";
		}
		document.getElementById(jobtitle).innerHTML = "<td colspan='2'>您在"+obj.getElementsByTagName("input")[0].value+"岗位上有多长时间的工作经验</td>";
		document.getElementById(jobId).innerHTML = ""
		 +"<td class='textL'>"
		 	+"<div class='input-group' style='margin-left:-10px !important;width: 90% !important'>"
				+"<div class='dropdown'>"
			 		+"<input type='text' name='"+jobName+"' id='"+jobName+"' class='form-control' style='width: 80% !important'>"
			 		+"<button type='button' style='height:34px !important;background-color:#E6E6E6;' class='btn dropdown-toggle' id='dropdownMenu1' data-toggle='dropdown'>"
			 			+"<span class='caret'></span>"
			 		+"</button>"
				 	+"<ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1' style='width: 90% !important'>"
				 		+"<li role='presentation'>"
				 			+"<a role='menuitem' tabindex='-1' href='#' onclick=\"workTime('1年','"+jobName+"')\"><font color='#000'>1年</font></a>"
				 			+"<a role='menuitem' tabindex='-1' href='#' onclick=\"workTime('一至三年','"+jobName+"')\"><font color='#000'>一至三年</font></a>"
				 			+"<a role='menuitem' tabindex='-1' href='#' onclick=\"workTime('三至五年','"+jobName+"')\"><font color='#000'>三至五年</font></a>"
				 			+"<a role='menuitem' tabindex='-1' href='#' onclick=\"workTime('五年以上','"+jobName+"')\"><font color='#000'>五年以上</font></a>"
				 		+"</li>"
				 	+"</ul>"
		 		+"</div>"
		 	+"</div>"
		 +"</td>"
		 ;
	}
	function editworkyears(jobId, jobN, a){
		var jobId;
		var jobName;
		var jobtitle;
		if(a == 1){
			jobId = "job1";
			jobName = "jobyear1";
			jobtitle = "job1_title";
		}
		if(a == 2){
			jobId = "job2";
			jobName = "jobyear2";
			jobtitle = "job2_title";
		}
		document.getElementById(jobtitle).innerHTML = "<td colspan='2'>您在"+jobN+"岗位上有多长时间的工作经验</td>";
		document.getElementById(jobId).innerHTML = ""
		 +"<td class='textL'>"
		 	+"<div class='input-group' style='margin-left:-10px !important;width: 90% !important'>"
				+"<div class='dropdown'>"
			 		+"<input type='text' name='"+jobName+"' id='"+jobName+"' class='form-control' style='width: 80% !important'>"
			 		+"<button type='button' style='height:34px !important;background-color:#E6E6E6;' class='btn dropdown-toggle' id='dropdownMenu1' data-toggle='dropdown'>"
			 			+"<span class='caret'></span>"
			 		+"</button>"
				 	+"<ul class='dropdown-menu' role='menu' aria-labelledby='dropdownMenu1' style='width: 90% !important'>"
				 		+"<li role='presentation'>"
				 			+"<a role='menuitem' tabindex='-1' href='#' onclick=\"workTime('1年','"+jobName+"')\"><font color='#000'>1年</font></a>"
				 			+"<a role='menuitem' tabindex='-1' href='#' onclick=\"workTime('一至三年','"+jobName+"')\"><font color='#000'>一至三年</font></a>"
				 			+"<a role='menuitem' tabindex='-1' href='#' onclick=\"workTime('三至五年','"+jobName+"')\"><font color='#000'>三至五年</font></a>"
				 			+"<a role='menuitem' tabindex='-1' href='#' onclick=\"workTime('五年以上','"+jobName+"')\"><font color='#000'>五年以上</font></a>"
				 		+"</li>"
				 	+"</ul>"
		 		+"</div>"
		 	+"</div>"
		 +"</td>"
		 ;
	}
	function delworkyears(job){
		var title="您在"+job.getElementsByTagName("input")[0].value+"岗位上有多长时间的工作经验";
		if(document.getElementById("job1_title").innerText == title){
			document.getElementById("job1_title").innerHTML = "";
			document.getElementById("job1").innerHTML = "";
		}else if(document.getElementById("job2_title").innerText == title){
			document.getElementById("job2_title").innerHTML = "";
			document.getElementById("job2").innerHTML = "";
		}
	}
	function workTime(jobval,jobName){
		document.getElementById(jobName).value=jobval;
	}
	function replaceAll(str, str1, str2) {
		var lstr = ""
		for (var i in str.split(str1)) {
			str = str.replace(str1, str2);
		}
		for (var i in str.split(str2)) {
			if (str.split(str2)[i] != '') lstr += str.split(str2)[i] + ",";
		}
		lstr = lstr.substring(0, lstr.length - 1);
		return lstr;
	}
	//下一步
	function goSubmit(){
		var jobs = "";
		$(".checked").each(function () {
			if(jobs != ""){
				jobs = jobs + ",";
			}
			jobs = jobs + this.id
        });
		document.getElementById("jobs").value=jobs;
		if(!checkValue()) return;
		var offerUserDescription = document.getElementById('offerUserDescription').value;
		offerUserDescription = replaceAll(offerUserDescription, "，", ",");
		document.getElementById('offerUserDescription').value = offerUserDescription;
		var url = "user/saveResumeAddInformation1.do";
		var formId = "userInformationForm";
		var data = ajaxSumbit(url, formId);
		if(data == "success"){
			top.location.href='resume_add_planjob.jsp';
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
		if(!checkInput('offerUserName',"姓名","30",false)) return false;
		if(!checkInput('offerUserSex',"性别","30",false)) return false;
		if(!checkInput('offerUserWorktime',"工作年限","30",false)) return false;
		if(!checkInput('jobs',"工作岗位","30",false)) return false;
		if(!checkInput('offerUserDescription',"工作技能","200",true)) return false;
		if(!checkInput('offerUserZhihu',"知乎ID","30",true)) return false;
		if(!checkInput('offerUserBlog',"blog地址","30",true)) return false;
		if(!checkInput('offerUserGithub',"github账号","30",true)) return false;
		if(!checkInput('offerUserPersonWeb',"个人网站","30",true)) return false;
		return true;
	}
</script>
<body bgcolor="#F4F9F9" onload="init()">
	<form id="userInformationForm" style="overflow-y:auto;">
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
								<td><div class="circleA"></div></td>
								<td><font color="#00B38A">&nbsp;&nbsp;基本信息 </font></td>
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
			<center><font size="3" color="#666666">Hi,欢迎您的到来！让我们来认识一下吧。</font></center>
		</div>
		<div style="height: 2px; width: 600px; background-color: #999999;"></div>
		<div style="background: #FFFFFF; width: 600px;">
			<br />
			<table
				style="border-collapse: separate; border-spacing: 10px; width: 100%; padding-left:30px;">
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#4F4F4F">姓名*</font>
					</th>
				</tr>
				<tr>
					<td>
						<input type="text" name="offerUserName" id="offerUserName" class="form-control" style="width: 75% !important">
					</td>
					<td/>
				</tr>
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#4F4F4F">性别*</font>
					</th>
				</tr>
				<tr>
					<td colspan="2">
						<input type="hidden" name="offerUserSex" id="offerUserSex"/>
						<button type="button" class="btn btn-primary" onclick="setSexValue(1)" data-toggle="button" id="sex1"
							style="color: #00B38A !important;background-color: #FFF !important; border-color: #00B38A !important; width: 100px;">
							男</button>
						<button type="button" class="btn btn-primary" onclick="setSexValue(0)" data-toggle="button" id="sex2"
							style="color: #00B38A !important;background-color: #FFF !important; border-color: #00B38A !important; width: 100px;">
							女</button>
					</td>
				</tr>
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#4F4F4F">工作年限*</font>
					</th>
				</tr>
				<tr>
					<td class="textL">
						<div class="input-group" style="margin-left:-10px !important;width: 90% !important">
							<div class="dropdown" style="">
								<input type="text" name="offerUserWorktime" id="offerUserWorktime" readOnly="readOnly" class="form-control" style="width: 80% !important">
							    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
							        <span class="caret"></span>
							    </button>
							    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 90% !important" id="offerUserWorktime">
							        <li role="presentation">
							            <a role="menuitem" tabindex="-1" href="#" onclick='workTimeValue("1年")'><font color="#000">1年</font></a>
							            <a role="menuitem" tabindex="-1" href="#" onclick='workTimeValue("一至三年")'><font color="#000">一至三年</font></a>
							            <a role="menuitem" tabindex="-1" href="#" onclick='workTimeValue("三至五年")'><font color="#000">三至五年</font></a>
							            <a role="menuitem" tabindex="-1" href="#" onclick='workTimeValue("五年以上")'><font color="#000">五年以上</font></a>
							        </li>
							    </ul>
							</div>
						</div>
					</td>
					<td/>
				</tr>
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#4F4F4F">您期望的工作岗位是？（最多选择两项）*</font>
						<input type="hidden" id="jobs" name="jobs"/>
					</th>
				</tr>
				<tr>
					<td colspan="2" id="checkJob">
					</td>
				</tr>
				<tr id="job1_title"/>
				<tr id="job1"/>
				<tr id="job2_title"/>
				<tr id="job2"/>
				<tr>
					<th class="textL" colspan="2">
						<font size="1" color="#4F4F4F">您擅长哪些工作技能？（请用逗号分隔你的技能特长）</font>
					</th>
				</tr>
				<tr>
					<td colspan="2">
						<input type="text" name="offerUserDescription" id="offerUserDescription" class="form-control" style="width: 75% !important">
					</td>
				</tr>
				<tr height="10px"/>
			</table>
		</div>
		<div style="height: 2px; width: 600px; background-color: #999999;"></div>
		<div style="width: 600px; background-color: #FFF;">
			<table width="100%">
				<tr height="40px">
					<td style="padding-left:50px;font-size:1px;" colspan="4"><b>关联你的社交网络</b></td>
				</tr>
				<tr height="60px">
					<td width="75px" class="textR">
						<img src="../img/zhihu.png" width="35px"/>
					</td>
					<td width="215px" class="textL" style="padding-left:10px;">
			            <input type="text" class="form-control" name="offerUserZhihu" id="offerUserZhihu" placeholder="请输入你的知乎ID" style="width: 180px !important">
					</td>
					<td width="75px" class="textR">
						<img src="../img/github.png" width="35px"/>
					</td>
					<td width="235px" class="textL" style="padding-left:10px;">
						<input type="text" class="form-control" name="offerUserGithub" id="offerUserGithub" placeholder="请输入你的github账号" style="width: 180px !important">
					</td>
				</tr>
				<tr height="60px">
					<td width="100px" class="textR">
						<img src="../img/blog.png" width="35px"/>
					</td>
					<td width="200px" class="textL" style="padding-left:10px;">
			            <input type="text" class="form-control" name="offerUserBlog" id="offerUserBlog" placeholder="请输入你的blog地址" style="width: 180px !important">
					</td>
					<td width="100px" class="textR">
						<img src="../img/personlink.png" width="35px"/>
					</td>
					<td width="200px" class="textL" style="padding-left:10px;">
						<input type="text" class="form-control" name="offerUserPersonWeb" id="offerUserPersonWeb" placeholder="请输入你的个人网站" style="width: 180px !important">
					</td>
				</tr>
			</table>
			<br/>
			<button type="button" class="btn btn-primary" onclick="goSubmit()" data-toggle="button"
				style="color: #FFF !important;background-color: #00B38A !important; border-color: #00B38A !important; width: 200px;">
				下一步</button>
		</div>
	</center>
	<br/>
	<br/>
	</form>
</body>
</html>
