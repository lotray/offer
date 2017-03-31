<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<style>
</style>
<script language="javascript">
	function init(){
		var url = "login/firmtuijian1.do";
		var formId = "finduserForm";
		var data = ajaxSumbit(url, formId);
		document.getElementById("allNum").innerText=data.allNum;
		addLi(data.status,"status");
		addLi(data.job,"job");
		addList(data.firmList);
		addpageNum(data.pageNum,"u1");
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
	}
	function test(){
		parent.document.getElementById("main1").height=0;
		parent.document.getElementById("main1").height=document.body.scrollHeight;
	}
	//添加城市
	function addCity(items){
		var citys = "<tr>"
						+"<td width='5%'/><td width='20%'/>"
						+"<td width='5%'/><td width='20%'/>"
						+"<td width='5%'/><td width='20%'/>"
						+"<td width='5%'/><td width='20%'/>"
					+"</tr>";
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
		citys = citys + "";
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
	function selected(obj){
		$(".circleA").each(function () {
			if(obj.id.indexOf('j') > -1 && this.id.indexOf('j') > -1){
				this.setAttribute("class","circleB");
			}
			if(obj.id.indexOf('i') > -1 && this.id.indexOf('i') > -1){
				this.setAttribute("class","circleB");
			}
		});
		obj.setAttribute("class","circleA");
		if(obj.id.indexOf('j') > -1){
			document.getElementById("jobstatus").value=obj.id;
		}
		if(obj.id.indexOf('i') > -1){
			document.getElementById("intime").value=obj.id;
		}
	}
</script>
<body bgcolor="#FFF" onload="test()">
	<div style="width:100%;">
		<table width="100%">
			<tr height="49px"/>
			<tr>
				<td width="40px"/>
				<td colspan="2">
					<font style="font-size:20px;" color="#4F4F4F">关于我</font>
				</td>
				<td/>
			</tr>
			<tr height="48px"/>
			<tr>
				<td/>
				<td>
					<font color="#4F4F4F" style="font-size:14px;" >您目前的税前收入是？</font><font color="#00B38A">*</font>
				</td>
			</tr>
			<tr height="16px"/>
			<tr>
				<td/>
				<td colspan="3">
					<table width="100%">
						<tr>
							<td width="121px">
								<div class="input-group">
									<div class="dropdown">
										<input type="text" readOnly="readOnly" class="form-control" style="width: 85px !important">
									    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
									        <span class="caret"></span>
									    </button>
									    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 119px !important;min-width:119px;">
									    </ul>
									</div>
								</div>
							</td>
							<td width="3%"/>
							<td width="140px">
								<input type="text" class="form-control" style="width:140px;"/>
							</td>
							<td class="textC" width="4%" style="min-width:50px;">
								<font color="#4F4F4F" style="font-size:14px;">每月</font>
							</td>
							<td class="textC" width="2%" style="min-width:25px;">
								<font color="#4F4F4F" style="font-size:14px;">X</font>
							</td>
							<td width="140px">
								<input type="text" class="form-control" style="width:140px;"/>
							</td>
							<td width="50px" class="textC">
								<font color="#4F4F4F" style="font-size:14px;">月&nbsp;=</font>
							</td>
							<td>
								<font color="#4F4F4F" style="font-size:14px;">0 万/年</font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr height="48px"/>
			<tr>
				<td/>
				<td>
					<font color="#4F4F4F" style="font-size:16px;" >您对下一份工作的最低税前年薪要求是？</font><font color="#00B38A">*</font>
				</td>
			</tr>
			<tr height="13px"/>
			<tr>
				<td/>
				<td colspan="3">
					<table width="100%">
						<tr>
							<td width="121px">
								<div class="input-group">
									<div class="dropdown">
										<input type="text" readOnly="readOnly" class="form-control" style="width: 85px !important">
									    <button type="button" style="height:34px !important;background-color:#E6E6E6;" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">
									        <span class="caret"></span>
									    </button>
									    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="width: 119px !important;min-width:119px;">
									    </ul>
									</div>
								</div>
							</td>
							<td width="3%"/>
							<td width="140px">
								<input type="text" class="form-control" style="width:140px;"/>
							</td>
							<td class="textC" width="4%" style="min-width:50px;">
								<font color="#4F4F4F" style="font-size:14px;">万/年</font>
							</td>
							<td/>
						</tr>
					</table>
				</td>
			</tr>
			<tr height="56px"/>
			<tr>
				<td/>
				<td>
					<font color="#4F4F4F" style="font-size:16px;" >您期望在哪个城市工作？（可多选）</font>
				</td>
			</tr>
			<tr height="13px"/>
			<tr>
				<td/>
				<td colspan="3">
					<input type="hidden" name="cityIds" id="cityIds"/>
					<table width="100%" id="city">
					</table>
				</td>
			</tr>
			<tr height="48px"/>
			<tr>
				<td/>
				<td>
					<font color="#4F4F4F" style="font-size:16px;" >您目前的求职状态是？</font><font color="#00B38A">*</font>
					<input type="hidden" id="jobstatus" name="jobstatus"/>
				</td>
			</tr>
			<tr height="13px"/>
			<tr>
				<td/>
				<td colspan="3">
					<table style="border-collapse:separate; border-spacing:0px 30px;">
						<tr>
							<td><div class="circleB" id="j1" onclick="selected(this)" style="cursor:pointer;"></div></td>
							<td><font color="#4F4F4F" style="font-size:14px;">&nbsp;不着急找工作，先看看机会</font></td>
						</tr>
						<tr>
							<td><div class="circleB" id="j2" onclick="selected(this)" style="cursor:pointer;"></div></td>
							<td><font color="#4F4F4F" style="font-size:14px;">&nbsp;已经有offer了，想看更好的</font></td>
						</tr>
						<tr>
							<td><div class="circleB" id="j3" onclick="selected(this)" style="cursor:pointer;"></div></td>
							<td><font color="#4F4F4F" style="font-size:14px;">&nbsp;正在找工作，还没有offer</font></td>
						</tr>
						<tr>
							<td><div class="circleB" id="j4" onclick="selected(this)" style="cursor:pointer;"></div></td>
							<td><font color="#4F4F4F" style="font-size:14px;">&nbsp;暂时不考虑换工作</font></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr height="48px"/>
			<tr>
				<td/>
				<td colspan="3">
					<font color="#4F4F4F" style="font-size:16px;" >如果找到合适的工作，您预计多久可以入职？</font><font color="#00B38A">*</font>
					<input type="hidden" id="intime" name="intime"/>
				</td>
			</tr>
			<tr height="13px"/>
			<tr>
				<td/>
				<td colspan="3">
					<table width="100%">
						<tr height="30px"/>
						<tr>
							<td class="textR" width="5%"><div class="circleB" id="i1" onclick="selected(this)" style="cursor:pointer;"></div></td>
							<td class="textL" width="45%"><font color="#4F4F4F" style="font-size:14px;">&nbsp;目前是离职状态，随时可以入职</font></td>
							<td class="textR" width="5%"><div class="circleB" id="i2" onclick="selected(this)" style="cursor:pointer;"></div></td>
							<td class="textL" width="45%"><font color="#4F4F4F" style="font-size:14px;">&nbsp;一周</font></td>
						</tr>
						<tr height="44px"/>
						<tr>
							<td class="textR"><div class="circleB" id="i3" onclick="selected(this)" style="cursor:pointer;"></div></td>
							<td class="textL"><font color="#4F4F4F" style="font-size:14px;">&nbsp;一个月</font></td>
							<td class="textR"><div class="circleB" id="i4" onclick="selected(this)" style="cursor:pointer;"></div></td>
							<td class="textL"><font color="#4F4F4F" style="font-size:14px;">&nbsp;不确定</font></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr height="48px"/>
			<tr>
				<td/>
				<td colspan="3">
					<font color="#4F4F4F" style="font-size:16px;" >您对哪种阶段的公司感兴趣？（可多选）</font><font color="#00B38A">*</font>
				</td>
			</tr>
			<tr height="13px"/>
			<tr>
				<td/>
				<td colspan="3">
					<input type="hidden" name="firmIds" id="firmIds"/>
					<table width="100%" id="firm">
					</table>
				</td>
			</tr>
			<tr height="48px"/>
			<tr>
				<td/>
				<td colspan="3">
					<font color="#4F4F4F" style="font-size:16px;" >您对下一份工作的其他要求是？</font><font color="#00B38A">*</font>
				</td>
			</tr>
			<tr height="13px"/>
			<tr>
				<td/>
				<td colspan="3">
					<textarea rows="8" name="offerRequestNextJob" id="offerRequestNextJob" style="width:75%;min-width:300px;"></textarea>
				</td>
			</tr>
			<tr height="50px"/>
			<tr>
				<td/>
				<td colspan="3" class="textC">
					<button type="button" class="btn btn-primary" data-toggle="button"
						style="font-size:14px;border-color:#CCCCCC;color:#4F4F4F;background-color:#CCCCCC;min-width:140px;">
						取消
					</button>
					<button type="button" class="btn btn-primary" onclick="setSexValue(0)" data-toggle="button" id="sex2"
						style="margin-left:19px;font-size:14px;color:#FFF;background-color:#00B389;min-width:140px;">
						保存
					</button>
				</td>
			</tr>
		</table>
	</div>
	<div style="width:100%;height:50px;"></div>
</body>
</html>