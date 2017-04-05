<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>

<body onload="init()">
<div style="width:100%;height:60px;background: #32373C;position:absolute;top:expression(documentElement.scrollTop + 'px');position:fixed;z-index:9999;">
		<table style="width:100%;white-space: nowrap;">
			<tr>
				<td width="19%" style="padding-left:14%;"><img src="../img/U-Offerlogo.png" width="109px" height="26px"></td>
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
					            <a tabindex="-1" href="#" style="height:46px;text-align:center;padding-top:10px;" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)"><font color="#F5F8F9">使用攻略</font></a>
					        </li>
					        <li role="presentation" style="height:46px;">
					            <a tabindex="-1" href="#" style="height:46px;text-align:center;padding-top:10px;" onmouseover="changeColor1(this)" onmouseout="changeColor2(this)"><font color="#F5F8F9">常见问题</font></a>
					        </li>
					    </ul>
					</div>
					<div class="btn-group">
						<button type="button" style="font-size:14px;height:60px !important;color:#F5F8F9;background-color:#32373C;"
						 class="btn dropdown-toggle" id="dropdownMenu2" data-toggle="dropdown" onmouseover="changeColor1(this)"
						 onmouseout="changeColor2(this)">招人才
					        <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu pull-right" role="menu" aria-labelledby="dropdownMenu2" style="">
					        <li role="presentation">
					            <a role="menuitem" tabindex="-1" href="#"><font color="#000">Java2</font></a>
					        </li>
					    </ul>
				    </div>
					<button type="button" style="font-size:14px;height:60px !important;color:#F5F8F9;background-color:#32373C;padding:0px 20px;"
					 class="btn dropdown-toggle" onmouseover="changeColor1(this)"
					 onmouseout="changeColor2(this)" onclick="javascript:top.location.href='check_email.jsp'">联系助理
				    </button>
			    </td>
			    <td style="width:24%;padding-right:13%">
				    <button type="button" class="btn btn-default" style="width:101px;color:#00B38A;background:#F5F8F9;" onclick="javascript:top.location.href='login.jsp'">登录</button>
				    <button id="regit" type="button" class="btn btn-default" style="margin-left:9px;width:101px;color:#FFFFFF;background:#00B38A;" onclick="javascript:top.location.href='register.jsp'">注册</button>
				</td>
			</tr>
		</table>
	</div>
	<div style="width:100%;height:100%;" id="div1">
		<img src="../img/use_strategy_user.png" width="100%" id="img1"/>
	</div>
</body>
<script language="javascript">
	function init(){
		//document.getElementById("div1").style.height=document.getElementById("img1").height-50;
		//alert(document.body.scrollHeight);
		var bodyHeight;//最小满足高度
		var saveBodyHeight = false;
		if(document.body.scrollHeight > document.getElementById("img1").height){
			if(!saveBodyHeight){
				bodyHeight = document.body.height;
				document.getElementById("img1").width = document.body.scrollWidth;
				//当前尺寸不满足全屏
				if(document.body.scrollHeight > document.getElementById("img1").height){
					document.getElementById("img1").height = document.body.scrollHeight;
					$("#img1").removeAttr("width");
				}
				saveBodyHeight = true;
			}
		}
		if(document.body.scrollWidth > document.getElementById("img1").width){
			document.getElementById("img1").width = document.body.scrollWidth;
			$("#img1").removeAttr("height");
			saveBodyHeight = false;
		}
		/* if(window.screen.height > document.getElementById("img1").height){
			document.getElementById("img1").width = window.screen.width - 20;
		} */
	}
	window.onresize=function(){  
		init();  
	}
</script>
</html>
