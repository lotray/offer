<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<style>
.dropdown-submenu {  
    position: relative;  
}  
.dropdown-submenu > .dropdown-menu {  
    top: 0;  
    left: 100%;  
    margin-top: -6px;  
    margin-left: -1px;  
    -webkit-border-radius: 0 6px 6px 6px;  
    -moz-border-radius: 0 6px 6px;  
    border-radius: 0 6px 6px 6px;  
}  
.dropdown-submenu:hover > .dropdown-menu {  
    display: block;  
}  
.dropdown-submenu > a:after {  
    display: block;  
    content: " ";  
    float: right;  
    width: 0;  
    height: 0;  
    border-color: transparent;  
    border-style: solid;  
    border-width: 5px 0 5px 5px;  
    border-left-color: #ccc;  
    margin-top: 5px;  
    margin-right: -10px;  
}  
.dropdown-submenu:hover > a:after {  
    border-left-color: #fff;  
}  
.dropdown-submenu.pull-left {  
    float: none;  
}  
.dropdown-submenu.pull-left > .dropdown-menu {  
    left: -100%;  
    margin-left: 10px;  
    -webkit-border-radius: 6px 0 6px 6px;  
    -moz-border-radius: 6px 0 6px 6px;  
    border-radius: 6px 0 6px 6px;  
}
</style>
</head>
<script language="javascript">
	var removeHowMany = "";
	var note = "";
	function changeColor1(der){
		der.style.background="#999999";
	}
	function changeColor2(der){
		der.style.background="#000";
	}
	function init() {
		var firstIn = document.getElementById('firstIn').value;
		var url = "firm/finduserPage1.do?firstIn="+firstIn;
		var formId = "finduserForm";
		var data = ajaxSumbit(url, formId);
		addLi(data.saved,"saved");
		addLi(data.city,"city");
// 		addLi(data.job,"job");
        addcityLi(data.job,"job");
		addLi(data.worked,"worked");
		addbutton("c",data.citybutton,"citybutton");
		addbutton("j",data.jobbutton,"jobbutton");
		addbutton("w",data.workbutton,"workbutton");
		addallorpair(data.allnum,data.pairnum);
		document.getElementById('firmsaved').value = data.firmsaved;
		document.getElementById('userName').innerText = data.userName;
		/* addpageNum(data.pageNum,"u1"); *///阿华说隐藏可以显示分页器
		window.iframe1.location.href="mainfinduser_sum.jsp";
		$("#finduserForm").populateForm(data);
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
	function jobnote(items,id,liId){
		var note = "";
		for(var j in items){
			if(items[j].parentId==id){
				note = note + "<li><a role='menuitem' onclick='selectDownValue(" + items[j].id +",\"" + items[j].value +"\",\""+liId+"\")'>"+items[j].value+"</a></li>";
			}
		}
		return note;
	}
	//下拉列表
	function addcityLi(items,liId){
		var inn = "";
		
		for(var i in items){
			if(items[i].parentId==0){
				inn = inn + "<li role='presentation' class='dropdown-submenu'>"
				+"<a role='menuitem' onclick='selectDownValue(" + items[i].id +",\"" + items[i].value +"\",\""+liId+"\")'><font color='#000'>" + items[i].value
				+"</font></a>"
				+"<ul class='dropdown-menu'>"
				+jobnote(items,items[i].id,liId)
			    +"</ul>"
				+"</li>";
			}
			
		}
		document.getElementById(liId).innerHTML=inn;
	}

	function selectDownValue(ke, val, targetInput){
		var ti1 = "firm" + targetInput;
		var ti2 = "firm" + targetInput + "Value";
		document.getElementById(ti1).value=ke;
		document.getElementById(ti2).value=val;
		if(targetInput == 'saved'){
			buttonClean();
			/* document.getElementById('firmcity').value = "";
			document.getElementById('firmworked').value = "";
			document.getElementById('firmjob').value = "";
			document.getElementById('firmcityValue').value = "";
			document.getElementById('firmworkedValue').value = "";
			document.getElementById('firmjobValue').value = ""; */
			//document.getElementById('firstIn').value = 1;
			window.iframe1.location.href="mainfinduser_sum.jsp";
		}
	}
	//条件标签
	function addbutton(name,items,buttonId){
		var inn = "";
		for(var i in items){
			inn = inn + "<button type='button' class='close' aria-hidden='true' style='float:left;opacity:0.9;background:#00B38A;color:#FFF;padding:10px;'>"
				+"<font size='2' style='font-weight: normal;letter-spacing:2px;'>" + items[i].value 
				+"<a href='#' id='"+name+"_"+items[i].id+"' onclick='removebutton(this)' style='color:#FFF;'>&nbsp;&nbsp;&times;</a></font></button>";
				document.getElementById(name).value = items[i].id + "_" + items[i].value;
		}
		removeHowMany = "";
		document.getElementById(buttonId).innerHTML=inn;
	}
	function removebutton(obj){
		var value = obj.id;
		var childNode=obj.parentNode.parentNode;
		childNode.parentNode.removeChild(childNode);
		var nowRemoveHowMany = "";
		removeHowMany += value + ";";
		/* for (var i in removeHowMany.split(";")) {
			if (removeHowMany.split(';')[i].split('_')[0] != '') {
				if (removeHowMany.split(';')[i].split('_')[0] == value.split('_')[0]) {
					alert('相同');
					alert(removeHowMany.split(';')[i].split('_')[0]);
					alert(value.split('_')[0]);
					nowRemoveHowMany += value + ";";
				}
				else {
					alert('butong');
					nowRemoveHowMany += removeHowMany.split(";")[i] + ";";
				}
			}
		}
		alert("removeHowMany=" + removeHowMany); */
		//alert("nowRemoveHowMany=" + nowRemoveHowMany);
		document.getElementById("removeWho").value = removeHowMany;
		window.iframe1.location.href="mainfinduser_sum.jsp";
	}
	//保存
	function gosave(){
		top.location.href='finduser.jsp'
	}
	//清除
	function buttonClean(){
		/* document.getElementById('firmcity').value="";
		document.getElementById('firmcityValue').value="";
		document.getElementById('firmjob').value="";
		document.getElementById('firmjobValue').value="";
		document.getElementById('firmworked').value="";
		document.getElementById('firmworkedValue').value=""; */
		document.getElementById('citybutton').innerHTML="";
		document.getElementById('jobbutton').innerHTML="";
		document.getElementById('workbutton').innerHTML="";
	}
	//全部-已收藏
	function addallorpair(allnum,pairnum){
		document.getElementById('divall').innerHTML="<font size='1'>全部（"+allnum+")</font>";
		document.getElementById('divpair').innerHTML="<font size='1'>已收藏（"+pairnum+")</font>";
	}
	function goView(str){
		if(str == 'all'){
			document.getElementById(str).style.background="#00B38A";
			document.getElementById("pair").style.background="#DDDDDD";
			document.getElementById("allorpair").value = "quanbu";
			window.iframe1.location.href="mainfinduser_sum.jsp";
		}
		if(str == 'pair'){
			document.getElementById(str).style.backgroundColor="#00B38A";
			document.getElementById("all").style.background="#DDDDDD";
			document.getElementById("allorpair").value = "shoucang";
			window.iframe1.location.href="mainfinduser_sum.jsp";
		}
	}
	//页码
	function addpageNum(items,pageId){
		var inn = "";
		for(var i = 1; i < items; i++){
			inn = inn + "<li>"
				+"<a href='#' onclick='getpage("+items+")'>"+items+"</a>"
				+"</li>";
		}
		document.getElementById(pageId).innerHTML=inn;
	}
	function getpage(obj){
		document.getElementById('pageId').value = obj;
		window.iframe1.location.href="mainfinduser_sum.jsp";
	}
	function goSumbit(){
		var flag = false;
		if (document.getElementById('firmcityValue').value != "") {
			flag = true;
		}
		if (document.getElementById('firmjobValue').value != "") {
			flag = true;
		}
		if (document.getElementById('firmworkedValue').value != "") {
			flag = true;
		}
		if (flag) {
			document.getElementById('firstIn').value = 2;
		}
		var url = "firm/savefinduser1.do";
		var formId = "finduserForm";
		var data = ajaxSumbit(url, formId);
		if (data == 'success') {
			init();
		}
		//top.location.href="finduser.jsp";
	}
	function goSearch(){
		/* var url = "login/user.do";
		var formId = "finduserForm";
		var data = ajaxSumbit(url, formId);
		addLi(data.saved,"saved");
		addLi(data.city,"city");
		addLi(data.job,"job");
		addLi(data.worked,"worked"); */
	}
</script>
<style>
	.paddingC{
		padding-left:120px;
		padding-right:120px;
	}
</style>
<body bgcolor="#FFF" onload="init()">
	<div style="width:100%;height:55px;background: #000;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;">
		<table style="width:100%;white-space: nowrap;">
			<tr>
				<td width="270px" style="padding-left:150px;"><img src="../img/U-Offerlogo.png"></td>
				<td class="textL" style="padding-left:100px;">
				    <button type="button" style="height:55px !important;width:100px !important;color:#FFF;background-color:#000;" class="btn dropdown-toggle" id="dropdownMenu3" data-toggle="dropdown" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)" onclick="javascript:top.location.href='finduser.jsp'">
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
					            <a role="menuitem" tabindex="-1" href="#" onclick="javascript:top.location.href='firm_resume_add.jsp'"><font color="#000">企业信息</font></a>
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
	<table width="100%" id="t1">
		<tr height="30px"/>
		<tr>
			<td width="90px"/>
			<th colspan="2">
				<h4>候选人</h4>
			</th>
			<td width="90px"/>
		</tr>
		<tr>
			<td/>
			<td style="background:#F4F9F9;">
				<form id="finduserForm">
				<input type="hidden" id="thisId" name="thisId"/>
				<input type="hidden" id="status" name="status"/>
				<input type="hidden" id="c" name="c"/>
				<input type="hidden" id="j" name="j"/>
				<input type="hidden" id="w" name="w"/>
				<input type="hidden" id="removeWho" name="removeWho"/>
				<input type="hidden" id="removeHowMany" name="removeHowMany"/>
				<input type="hidden" id="pageSize" name="pageSize"/>
				<input type="hidden" id="firstIn" name="firstIn" value="1"/>
				<div id="div1" style="padding:10px;width:100%;">
					<table width="100%">
						<tr>
							<td style="padding-left:20px;"/>
							<td width="18%">
								<div class="input-group" style="margin-left:-10px !important;width: 160px !important">
									<div class="dropdown" style="">
										<input type="hidden" name="firmsavedFirst" id="firmsavedFirst"/>
										<input type="hidden" name="firmsavedSecond" id="firmsavedSecond"/>
										<input type="hidden" name="firmsaved" id="firmsaved"/>
										<input type="text" name="firmsavedValue" id="firmsavedValue" class="form-control" style="width: 120px !important" placeholder="已保存的搜索" readonly>
									    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
									        <span class="caret"></span>
									    </button>
									    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width:!important" id="saved"><!--  20px  -->
									    </ul>
									</div>
								</div>
							</td>
							<td width="18%">
								<div class="input-group" style="margin-left:-10px !important;width: 160px !important">
									<div class="dropdown" style="">
										<input type="hidden" name="firmcity" id="firmcity"/>
										<input type="text" name="firmcityValue" id="firmcityValue" class="form-control" style="width: 120px !important" placeholder="城市" readonly>
									    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
									        <span class="caret"></span>
									    </button>
									    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 20px !important" id="city">
									    </ul>
									</div>
								</div>
							</td>
							<td width="18%">
								<div class="input-group" style="margin-left:-10px !important;width: 160px !important">
									<div class="dropdown" style="">
										<input type="hidden" name="firmjob" id="firmjob"/>
										<input type="text" name="firmjobValue" id="firmjobValue" class="form-control" style="width: 120px !important" placeholder="职位" readonly>
									    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
									        <span class="caret"></span>
									    </button>
									    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 20px !important" id="job">
									    	<li class="dropdown-submenu">
									    		<a href="#">More options </a>
												<!-- <ul class="dropdown-menu">
													<li><a href="#">另一个功能1</a></li>
													<li><a href="#">另一个功能1</a></li>
												</ul> -->
											</li>
									    </ul>
									</div>
								</div>
							</td>
							<td width="18%">
								<div class="input-group" style="margin-left:-10px !important;width: 160px !important">
									<div class="dropdown" style="">
										<input type="hidden" name="firmworked" id="firmworked"/>
										<input type="text" name="firmworkedValue" id="firmworkedValue" class="form-control" style="width: 120px !important" placeholder="工作经验" readonly>
									    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
									        <span class="caret"></span>
									    </button>
									    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 20px !important" id="worked">
									    </ul>
									</div>
								</div>
							</td>
							<td>
								<input type="text" name="lastChoose" class="form-control" style="width: 280px !important">
							</td>
						</tr>
						<tr height="20px"/>
						<tr height="30px">
							<td />
							<td colspan="4">
								<table>
									<tr>
										<td class="textL" style="padding-left:10px;padding-right:10px;" id="citybutton">
										</td>
										<td class="textL" style="padding-left:10px;padding-right:10px;" id="jobbutton">
										</td>
										<td class="textL" style="padding-left:10px;padding-right:10px;" id="workbutton">
										</td>
									</tr>
								</table>
							</td>
							<td class="textR">
								<button type="button" class="btn btn-primary" onclick="goSumbit()" data-toggle="button"
								style="background-color: #00B38A !important; border-color: #00B38A !important; width: 100px;" onclick="gosave()">
								保存</button>
								<button type="button" class="btn btn-primary" onclick="buttonClean()" data-toggle="button" onclick="buttonClean()"
								style="background-color: #FFF !important;color:#00B38A; border-color: #00B38A !important; width: 100px;">
								清除</button>
							</td>
						</tr>
					</table>
				</div>
				</form>
			</td>
			<td  width="200px">
				<div style="background: #FFFFFF; width: 200px; margin-top:10px;padding-left:20px;">
					<table width="100%">
						<tr>
							<td valign="bottom" width="20px"><font size="1" color="#666666">家骏</font></td>
							<td class="textL" rowspan="2">
								<img src="../img/kefu.png" width="75px" height="75px" style="border:1px solid #CCCCCC;border-radius: 10px;padding:10px 15px;"/>
							</td>
						</tr>
						<tr height="7px">
							<td><font size="1" color="#666666">客户服务</font></td>
						</tr>
						<tr>
							<td colspan="2">
								<font size="1" color="#666666">
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
			<td/>
		</tr>
		<tr height="10px"/>
		<tr height="20px">
			<td/>
			<td>
				<font size="1">共<font color="#00B38A"><span id="dataNum">10</span></font>个匹配项，显示1~20</font>
			</td>
			<td>
				<input type="hidden" id="allorpair" name="allorpair"/>
				<table>
					<tr>
						<td class="textC"><div style="cursor:pointer;width:80px;" onclick="goView('all')" id="divall"><font size="1">全部(100)</font></div></td>
						<td class="textC"><div style="cursor:pointer;width:80px;" onclick="goView('pair')" id="divpair"><font size="1">已收藏(100)</font></div></td>
					</tr>
				</table>
			</td>
			<td/>
		</tr>
		<tr height="10px"/>
		<tr>
			<td/>
			<td style="background:#DDDDDD;height:1px;"/>
			<td style="background:#DDDDDD;height:1px;">
				<table>
					<tr>
						<td width="80px"><div style="width:100%;background:#00B38A;height:2px;" id="all"></div><td>
						<td width="80px"><div style="width:100%;background:#DDDDDD;height:2px;" id="pair"></div><td>
					</tr>
				</table>
			</td>
			<td/>
		</tr>
		<tr>
			<td/>
			<td colspan="2">
				<iframe id="iframe1" name="iframe1" width="100%" onload="changeFrameHeight()" style="" scrolling="yes" frameborder="0" marginheight="0px" marginwidth="0px" frameborder="0" ></iframe>
			</td>
			<td/>
		</tr>
		<tr id="pagecontrol">
			<td/>
			<td colspan="2">
				<input type="hidden" name="pageId" id="pageId" value="1"/>
				<ul class="pagination" id="u1" style="margin-top:10px;">
				</ul>
			</td>
			<td/>
		</tr>
	</table>
</body>
<script language="javascript">
	//调整iframe页面
	function changeFrameHeight(){
	    var ifm= document.getElementById("iframe1"); 
	    var dh = document.getElementById("div1").offsetHeight*2;
	    var uh = document.getElementById("pagecontrol").offsetHeight*2;
	    ifm.height=document.body.offsetHeight-55-dh-uh+"px";
	}
	window.onresize=function(){  
	     changeFrameHeight();  
	}
</script>
</html>