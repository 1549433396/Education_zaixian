<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计图</title>
<link rel="stylesheet" type="text/css"
	href="/common/layui/css/layui.css" media="all">
<link rel="stylesheet" type="text/css"
	href="/common/bootstrap/css/bootstrap.css" media="all">
<link rel="stylesheet" type="text/css" href="/common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="/css/personal.css"
	media="all">
</head>
<body>
	<section class="layui-larry-box">
	<form action="/admin/statisticalFigure/shows" method="post">
		<div class="larry-personal">
			<div class="layui-tab">
				<blockquote class="layui-elem-quote news_search">
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input placeholder="请输入查询月份" name="createTime"
								class="laydate-icon"
								onClick="laydate({istime: true, format: 'YYYY-MM'})">
						</div>
					</div>
					<input type="submit" class="layui-btn search_btn" value="查询">
				</blockquote>
				<div align="center">
					<div id="main1" class="my_main2"
						style="width: 100%; height: 500px; float: left;"></div>
				</div>
			</div>
		</div>
	</form>
	</section>
	<script type="text/javascript" src="/js/echartJs/echarts.min.js"></script>
	<script type="text/javascript" src="/js/laydate.js"></script>
	<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
</body>
<script>
	var create_time = $("#create_time").val();
	alert(create_time);
	var num = $("#num").val();
	alert(num);
	$(document).ready(
			function() {
				// 路径配置
				require.config({
					paths : {
						echarts : 'http://echarts.baidu.com/build/dist'
					}
				});

				// 使用
				require([ 'echarts', 'echarts/chart/bar', 'echarts/chart/line',
						'echarts/chart/pie', 'echarts/chart/map', // 使用柱状图就加载bar模块，按需加载
				], function(ec) {
					// 基于准备好的dom，初始化echarts图表
					var myChart = ec.init(document.getElementById('main1'));
					var ecConfig = require('echarts/config');
					var option = {
						xAxis : {
							type : 'category',
							name : '时间',
							data : ${create_time}
						},
						yAxis : {
							type : 'value',
							name : '人数',
							min : 0,
							max : 10
						},
						series : [ {
							name : ${create_time},
							data : ${num},
							type : 'line'
						} ]
					};
					// 为echarts对象加载数据 
					myChart.setOption(option);
				});
			});
</script>
</html>