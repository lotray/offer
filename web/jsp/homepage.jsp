<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/common/header.jsp"%>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>
<script language="javascript">
	function goSubmit() {
		var url = "register/firm.do";
		var formId = "loginForm";
		ajaxSumbit(url, formId);
	}
</script>
<body bgcolor="#000">
	<div id="myCarousel" class="carousel slide" style="width:100%;height:382px;">
	    <!-- 轮播（Carousel）指标 -->
	    <ol class="carousel-indicators">
	        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	        <li data-target="#myCarousel" data-slide-to="1"></li>
	        <li data-target="#myCarousel" data-slide-to="2"></li>
	    </ol>   
	    <!-- 轮播（Carousel）项目 -->
	    <div class="carousel-inner">
	        <div class="item active" style="height:382px;">
	            <img src="../img/banner1.png">
				<div style="width:480px;margin-top:-280px;margin-left:800px;z-index:9999;">
	            	<table>
	            		<tr height="40px">
	            			<td>
				            	<font color="#FFF" size="5">连接中高端人才，我们更懂业务</font>
	            			</td>
	            		</tr>
	            		<tr height="40px">
	            			<td>
				            	<font color="#FFF">每周100+优质互联网人才等你邀请</font>
	            			</td>
	            		</tr>
	            		<tr height="40px">
	            			<td>
				            	<font color="#FFF">Java、Web前端、iOS、android、UI设计、产品经理等火热应聘中</font>
	            			</td>
	            		</tr>
	            		<tr height="40px">
	            			<td>
				            	<button type="button" class="btn btn-default" style="width:150px">免费注册</button>
	            			</td>
	            		</tr>
	            	</table>
	            </div>
	        </div>
	        <div class="item">
	            <img src="/wp-content/uploads/2014/07/slide2.png" alt="Second slide">
	        </div>
	        <div class="item">
	            <img src="/wp-content/uploads/2014/07/slide3.png" alt="Third slide">
	        </div>
	    </div>
	    <!-- 轮播（Carousel）导航 -->
	    <a class="carousel-control left" href="#myCarousel" 
	        data-slide="prev">&lsaquo;
	    </a>
	    <a class="carousel-control right" href="#myCarousel" 
	        data-slide="next">&rsaquo;
	    </a>
	</div>
	<div style="background-color:#FFF;height:300px;">
		<table class="textC" width="100%">
			<tr height="60px">
				<td colspan="6" class="textC" height="20px"><font size="4" color="#777777">一种全新招聘流程体验</font></td>
			</tr>
			<tr>
				<td width="15%"></td>
				<td class="textC" height="100px"><img src="../img/notebook.png" width="70px" height="70px"/></td>
				<td class="textC" height="100px"><img src="../img/yearbook.png" width="70px" height="70px"/></td>
				<td class="textC" height="100px"><img src="../img/paper_plane.png" width="70px" height="70px"/></td>
				<td class="textC" height="100px"><img src="../img/anpaimianshi.png" width="70px" height="70px"/></td>
				<td width="15%"></td>
			</tr>
			<tr>
				<td width="15%"></td>
				<td class="textC" style="height:40px"><font size="3" color="#777777" style="font-weight:bold;">1、开始推荐简历</font></td>
				<td class="textC" style="height:40px"><font size="3" color="#777777" style="font-weight:bold;">2、挑选合适的候选人</font></td>
				<td class="textC" style="height:40px"><font size="3" color="#777777" style="font-weight:bold;">3、发送面试邀请</font></td>
				<td class="textC" style="height:40px"><font size="3" color="#777777" style="font-weight:bold;">4、安排面试</font></td>
				<td width="15%"></td>
			</tr>
			<tr>
				<td width="15%"></td>
				<td class="textC" valign="top"><font size="1" color="#808080" style="text-align:left">我们每周会推荐一批<br/>大致符合贵公司招聘<br/>需求的全新候选人。</font></td>
				<td class="textC" valign="top"><font size="1" color="#808080" style="text-align:left">通过职位、工作年限<br/>候选人项目经验、顾问<br/>综合评价等就可以从中<br/>筛选出满意的候选人。</font></td>
				<td class="textC" valign="top"><font size="1" color="#808080" style="text-align:left">填写职位、薪资范围<br/>股权期权以及邀请信<br/>既可向候选人发送面试<br/>邀请。</font></td>
				<td class="textC" valign="top"><font size="1" color="#808080" style="text-align:left">候选人接收面试邀请<br/>之后，可以查看到TA<br/>的姓名及其联系方式，<br/>顾问会协助线下安排<br/>面试。</font></td>
				<td width="15%"></td>
			</tr>
		</table>
	</div>
	<div style="height:300px;background-color:#E4E7E6;">
		<table width="100%">
			<tr height="50px"/>
			<tr>
				<td colspan="4" class="textC"><font size="4">u<font color="#00B38A">o</font>ffer 帮你发现这样的人才</font></td>
			</tr>
			<tr height="20px"/>
			<tr>
				<td width="25%" class="textR"></td>
				<td width="25%" class="textC"></td>
				<td width="25%" class="textC"></td>
				<td width="25%" class="textL"></td>
			</tr>
		</table>
	</div>
	<div style="background-color:#FFF;height:600px;">
		<table width="100%">
			<tr height="50px"/>
			<tr>
				<td colspan="5" class="textC"><font size="5">u<font color="#00B38A">o</font>ffer Q&A</font></td>
			</tr>
			<tr height="30px"/>
			<tr>
				<td width="20%"></td>
				<td width="20%">
					<table style="font-size:1px;">
						<tr>
							<td rowspan="2"><img src="../img/Q.png" width="30px" height="30px"/></td>
							<td><font style="font-weight:bold;">U<font color="#00B38A">o</font>ffer是一个什么样</font></td>
						</tr>
						<tr>
							<td><font style="font-weight:bold;">招聘网站？</font></td>
						</tr>
					</table>
				</td>
				<td width="20%"></td>
				<td width="20%">
					<table style="font-size:1px;">
						<tr>
							<td rowspan="2"><img src="../img/Q.png" width="30px" height="30px"/></td>
							<td><font style="font-weight:bold;">U<font color="#00B38A">o</font>ffer与别的招聘网站</font></td>
						</tr>
						<tr>
							<td><font style="font-weight:bold;">有何不同？</font></td>
						</tr>
					</table>
				</td>
				<td width="20%"></td>
			</tr>
			<tr height="10px"/>
			<tr>
				<td width="20%"></td>
				<td width="20%" style="background-color:#EEFFF5;padding:20px;">
					<font size="1">
						<font style="font-weight:bold;">U<font color="#00B38A">o</font>ffer</font>
						是国内目前唯一一个可以高效批量接触到
						优质互联网人才的网站，而且简历信息里包括
						候选人的具体求职意向以及社交类网址，省去了
						HR漫长的搜索优质候选人的过程,您可以集中精力
						跟候选人沟通、面试、大大提升招聘效率。
					</font>
				</td>
				<td width="20%"></td>
				<td width="20%" style="background-color:#EEFFF5;padding:20px;">
					<font size="1">
						在<font style="font-weight:bold;">U<font color="#00B38A">o</font>ffer</font>
						您不需要撰写JD、发布职位，我们把所有的候选人直接展示在您的面前，
						您只需要挑选出合适的候选人邀请他们过来面试既可，uoffer对每一位
						候选人严格审核，确保只将最优秀的互联网人才被推荐，而在传统招聘网站
						您只会收到大量参差不起的简历更有可能求职意向不明，严重影响您的工作效率。
					</font>
				</td>
				<td width="20%"></td>
			</tr>
			<tr height="60px"/>
			<tr>
				<td width="20%"></td>
				<td width="20%">
					<table style="font-size:1px;">
						<tr>
							<td rowspan="2"><img src="../img/Q.png" width="30px" height="30px"/></td>
							<td><font style="font-weight:bold;">U<font color="#00B38A">o</font>ffer提供怎样的</font></td>
						</tr>
						<tr>
							<td><font style="font-weight:bold;">候选人？</font></td>
						</tr>
					</table>
				</td>
				<td width="20%"></td>
				<td width="20%">
					<table style="font-size:1px;">
						<tr>
							<td rowspan="2"><img src="../img/Q.png" width="30px" height="30px"/></td>
							<td><font style="font-weight:bold;">U<font color="#00B38A">o</font>ffer如何进行</font></td>
						</tr>
						<tr>
							<td><font style="font-weight:bold;">收费？</font></td>
						</tr>
					</table>
				</td>
				<td width="20%"></td>
			</tr>
			<tr height="10px"/>
			<tr>
				<td width="20%"></td>
				<td width="20%" style="background-color:#EEFFF5;padding:20px;">
					<font size="1">
						<font style="font-weight:bold;">U<font color="#00B38A">o</font>ffer</font>
						是一个中高端人才招聘网站，专注为互联网行业推荐中高端技术类、产品类、
						设计类等职位人才，他们工作3年以上，近期有明确求职意向，平均年薪15w
						以上，并通过我们顾问沟通后严格筛选出来的简历。
					</font>
				</td>
				<td width="20%"></td>
				<td width="20%" style="background-color:#EEFFF5;padding:20px;">
					<font size="1">
						<font style="font-weight:bold;">U<font color="#00B38A">o</font>ffer</font>
						按招聘结果付费的形式收费，在uoffer注册账号、看简历、发面试邀请、
						面试候选人都是不需要任何费用，只有在候选人成功入职后，我们才会收费，
						且大部分人选我们只收取候选人一个月月薪，高端人才按年薪的比例佣金，
						而且我们有三个月的保证期。
					</font>
				</td>
				<td width="20%"></td>
			</tr>
		</table>
	</div>
</body>
</html>