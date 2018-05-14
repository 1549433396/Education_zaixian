<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="js/ztree/zTreeStyle.css" />
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="js/ztree/jquery.ztree.all.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	$(function() {
		//页面加载完成后，执行这段代码----动态创建ztree
		var setting = {
			data : {
				simpleData : {
					enable : true,
					idKey : "function_id",
					pIdKey : "parent_id",
					rootPId : "0"
				},
				key : {
					name : "function_name"
				}
			},
			check : {
				enable : true
			}
		};

		var url = "/admin/roles";
		$.post(url, function(data) {
			//初始化ztree
			$.fn.zTree.init($("#mytree"), setting, data);
		}, 'json');
	});

	function submit_form() {
		//根据ztree的id获取ztree对象
		var treeObj = $.fn.zTree.getZTreeObj("mytree");
		//获取ztree上选中的节点，返回数组对象
		var nodes = treeObj.getCheckedNodes(true);
		var array = new Array();
		for (var i = 0; i < nodes.length; i++) {
			var id = nodes[i].function_id;
			array.push(id);
		}
		var functionIds = array.join(",");
		//为隐藏域赋值（权限的id拼接成的字符串）
		$("#perid").val(functionIds);
		$("#roleForm").submit();
	}
</script>

</head>
<body>
	<form id="roleForm" action="/admin/role_Add" method="get">
		<input type="hidden" value="" id="perid" name="perid" />
		<table align="center" width="600px">
			<tr>
				<td>角色名称:</td>
				<td><input type="text" name="role_name"></td>
			</tr>
			<tr>
				<td>授权:</td>
				<td><ul id="mytree" class="ztree"></ul></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="button" value="提交"
					onclick="submit_form()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>