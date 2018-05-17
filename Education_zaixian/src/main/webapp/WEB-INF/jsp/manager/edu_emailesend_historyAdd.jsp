<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>发送邮件</title>
	<meta name="renderer" content="webkit">	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">	
	<meta name="apple-mobile-web-app-status-bar-style" content="black">	
	<meta name="apple-mobile-web-app-capable" content="yes">	
	<meta name="format-detection" content="telephone=no">	
	<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/common/layui/css/layui.css" media="all">
	<link rel="stylesheet" type="text/css" href="/common/bootstrap/css/bootstrap.css" media="all">
	<link rel="stylesheet" href="/common/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/js/bootstrap/css/bootstrap.css"/>
<script type="text/javascript" src="/js/bootstrap/js/bootstrap.js"></script>
	<link rel="stylesheet" type="text/css" href="/common/global.css" media="all">
	<link rel="stylesheet" type="text/css" href="/css/personal.css" media="all">
	<link href="/js/utf8-jsp/themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js"></script>
 <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.config.js"></script>
  <script type="text/javascript" charset="utf-8" src="/js/utf8-jsp/umeditor.min.js"></script>
  <script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
     
<script type="text/javascript">
  $(function() {
		$("#btns").click(function() {
				var content = UM.getEditor('editor').getContentTxt();
				if(content==""){
					alert("内容不能为空!");
					return false;
				}
				if($("#email").val()==""){
					alert("邮箱不能为空!");
					return false;
				}
				if($("#title").val()==""){
					alert("标题不能为空!");
					return false;
				}
				$("#in").val(content);
				$("#form1").submit();
			});
  })

function del () {
    var c="是否要发送邮件？";
    if (confirm(c)==true) {
    	return true;
    } else{
    	return false;
    }
}

function fun() {
	 if($("#email").val()==""){
   alert("邮箱不能为空");
   return false;
  }
  var email=$("#email").val();
   var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
  if(!myreg.test(email)){
   alert("格式不正确！请重新输入");
    myreg.focus();
    return false;
  }else{
 /*  alert("格式正确"); */
  }
 }

function fun2() {
var title = $("#title").val();
	if (title=="") {
		alert("标题不能为空");
	}
}

function fun3(){
	var content = UM.getEditor('editor').getContentTxt();
	if(content==""){
		alert("内容不能为空!");
	}
}
	var b;
	function xianshi() {
		var emass = $("#eid").val();
		if(emass == 0) {
			alert("请选择联系人")
		} else {
			b = b + emass + ";";
			$("#email").val(b);
		}
	}
	
	function dingshi () {
		var type = $("#type").val();	
		if (type==1) {
			document.getElementById("div").style.display="none";
		} else if (type==2) {
			document.getElementById("div").style.display="";
	
		} 
	}
	
	//全选反选
	function fun1() {
		var checklist = document.getElementsByName("subcheck");
		if (document.getElementById("checkbox").checked) {
			for (var i=0;i<checklist.length;i++) {
				checklist[i].checked = 1;
			}
		} else{
			for (var j=0;j<checklist.length;j++) {
				checklist[j].checked = 0;
			}
		}
	}
	var a=[];
	$(function(){
		$("#tton").click(function() {
			var email = document.getElementsByName("subcheck");
			for(var i=0;i<email.length;i++) {
				if (email[i].checked) {
					a.push(email[i].value);
				}
			}
			var b ="";
			for(var i =0;i<a.length;i++) {
				if (b.trim().length==0) {
					b = a[i]+";";
				}else{
				b+=a[i]+";";
				}
			}
			$("#email").text(b);
		})
	})
	
</script>

<style type="text/css">
#v{
	position: absolute;
	left: 420px;
	top: 70px;
}
.t1{
width: 100px;
}
#tab2{
font-family: '微软雅黑';
font-size:16px;
font-weight:bold; 
color:red; 
margin-left:30px;
width: 45%;
height: 40%;
}
#ta1{
padding:30px ;
margin-top: 30px;
height: 400px;
}
#put{
width: 200px;
height: 30px;
border: 1px solid black;
}
</style>
<script type="text/javascript">
$(function () {
	if(${type }!=0){
		$("#myModal").modal("show");
	}
})
</script>

</head>
<body>
			<form action="/admin/email/sendEmail" method="post" id="form1">
			<div id="d1">
			
					<table id="tab1">
					<tr height="50px">
						<td id="t1">添加联系人:</td>
						<td id="t2">
							<textarea onblur="fun()" name="email" id="email" rows="8" cols="50" style="width:400px;height:40px;" placeholder="请选输入对方邮箱,多个请用(;)分号隔开" title="请选输入对方邮箱,多个请用(;)分号隔开"></textarea>
						</td>
							<td>
							<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                                                                         导入联系人</button>
						</td>
					</tr>
				</table>
					
				<table  id="tab2">
					<tr >
						<td>规则</td>
					</tr>
					<tr>
						<td>1.邮件格式：****@qq.com</td>
					</tr>
					<tr>
						<td>或者******@126.com,*****@163.com,*****@sina.com..等</td>
					</tr>
					<tr>
						<td>2.发送流程：添加邮箱号->设置邮箱号->提交发送</td>
					</tr>
					<tr>
						<td>3.添加邮箱号时，查询后可以选择添加所选学员及添加所有学员，请慎重选择。</td>
					</tr>
					<tr>
						<td>4.群发邮件最多不能超过1000条</td>
					</tr>
					<tr>
						<td>5.定时邮件会有几分钟的延迟。</td>
					</tr>
				</table>
				
				<table id="ta1" >
					<tr>
						<td>邮箱标题：</td>
						<td > <input type="text" onblur="fun2()" name="title" id="title" value="" placeholder="请选输入邮件标题" style="width:200px;height:30px" /></td>
					</tr>
					<tr>
						<td>正文内容：</td>
						<td >
						<script type="text/plain" name="editor" id="editor" style="width: 1000px;height: 220px"></script>
						<input type="hidden" id="in" name="content" />
						</td>
					</tr>
					<tr height="40px">
						<td>邮箱类型：</td>
						<td >
							<select name="type" id="type" onchange="dingshi()">
								<option value="1">正常</option>
								<option value="2">定时</option>
							</select>
							<div id="div" style="display: none" >
							<table>
							<tr>
							<td>请选择时间:</td><td>
							<input id="put" class="layui-input search_input" type="text" name="StartTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
						</td>
							</tr>
							</table></div>
							
						</td>
					</tr>
					<tr height="30px">
						<td colspan="2" >
						<input type="button" onclick="javascript:return del()" id="btns" class="btn btn-success"  value="发送" ></input></td>
					</tr>
				</table>
		</form>
		</div>		
	</div>
	
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加联系人</h4>
      </div>
      <table class="layui-table table-hover" lay-even="" lay-skin="nob" id="tb">
      	<tr>
      	    <td><input type="checkbox" id="checkbox" name="checkbox" onclick="fun1()"></td>
      		<td>姓名</td>
      		<td>邮箱</td>
      	</tr>
      <c:forEach items="${list}" var="a">
      <tr>
      <td><input type="checkbox" name="subcheck" value="${a.email}"></td>
      <td>${a.user_name}</td>
      <td>${a.email}</td>
      </tr>
      </c:forEach>
      <tr>
						<td colspan="2">一共<input type="text"
										value="${page.pages}" style="width: 25px; text-align: center;" />页
										<a href="/admin/email/toEmailMsg?page=${page.firstPage}&type=2"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>第一页</a> <a
										href="/admin/email/toEmailMsg?page=${page.prePage}&type=2"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>上一页</a> <a
										href="/admin/email/toEmailMsg?page=${page.nextPage}&type=2"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>下一页</a> <a
										href="/admin/email/toEmailMsg?page=${page.lastPage}&type=2"
										class="layui-btn layui-btn-small"><i
											class="iconfont icon-shanchu1"></i>最后页</a></td>
						</tr>
      </table>
     
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" id="tton">确认</button>
      </div>
    </div>
  </div>
</div>
	
<script type="text/javascript" src="/common/layui/layui.js"></script>
<script type="text/javascript">
	layui.use(['form','upload'],function(){
         var form = layui.form();
         layui.upload({ 
             url: '' ,//上传接口 
             success: function(res){
              //上传成功后的回调 
              console.log(res) 
            } 
         });

	});
</script>
<script>     
    laydate({         
        elem: '#data',    //选择input的id     
        event: 'focus',     //鼠标获得input焦点开始下拉日期控件
        format: 'YYYY-MM-DD', //日期格式
                festival: true, //显示节日
                choose: function(datas){ //选择日期完毕的回调
              
                	/* alert('得到：'+datas);*/
                }
    }); 
//添加第二个input日期下拉的方法
    laydate({         
        elem: '#txt',         
        event: 'focus'     
    }); 
</script>
<script type="text/javascript">
   var ue = UM.getEditor('editor');
   </script>
</body>
</html>