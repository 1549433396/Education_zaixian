<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问答标签</title>
</head>
<link rel="stylesheet" href="/js/ztree/css/demo.css" type="text/css">
<link rel="stylesheet" href="/js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="/js/ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="/js/ztree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="/js/ztree/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="/js/ztree/js/jquery.ztree.exedit.js"></script>
<body>
<ul id="treeDemo" class="ztree"></ul>
<button type="button" id="btn_add" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
新增问答标签
</button>
</body>
<script type="text/javascript">
	 var setting = {
	/*  view: {
	 addHoverDom: addHoverDom,
	 removeHoverDom: removeHoverDom,
	 selectedMulti: false
	 }, */
	 edit: {
	 enable: true
	 },
	 data: {
	 simpleData: {
	 enable: true
	 }
	 },
	 callback: {
	 beforeDrag: beforeDrag
	 } 
	 };

	/*  var zNodes =[
	  { id:1, pId:0, name:"parent node 1", open:true},  
	 { id:11, pId:1, name:"leaf node 1-1"},
	 { id:12, pId:1, name:"leaf node 1-2"},
	 { id:13, pId:1, name:"leaf node 1-3"},
	  { id:2, pId:0, name:"parent node 2", open:true}, 
	 { id:21, pId:2, name:"leaf node 2-1"},
	 { id:22, pId:2, name:"leaf node 2-2"},
	 { id:23, pId:2, name:"leaf node 2-3"},
	  { id:3, pId:0, name:"parent node 3", open:true },  
	 { id:31, pId:3, name:"leaf node 3-1"},
	 { id:32, pId:3, name:"leaf node 3-2"},
	 { id:33, pId:3, name:"leaf node 3-3"}
	 ]; */
	 var zNodes=${json};
	 var code;
	 function beforeDrag(treeId, treeNodes) {
	 return false;
	 } 
	
	 function filter(treeId, parentNode, childNodes) {
			if (!childNodes) return null;
			for (var i=0, l=childNodes.length; i<l; i++) {
				childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
			}
			return childNodes;
		}
		function beforeRemove(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			zTree.selectNode(treeNode);
			return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
		}		
		function beforeRename(treeId, treeNode, newName) {
			if (newName.length == 0) {
				alert("节点名称不能为空.");
				return false;
			}
			return true;
		}

		var newCount = 1;
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
			var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
				+ "' title='add node' onfocus='this.blur();'></span>";
			sObj.after(addStr);
			var btn = $("#addBtn_"+treeNode.tId);
			if (btn) btn.bind("click", function(){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
				return false;
			});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#addBtn_"+treeNode.tId).unbind().remove();
		};

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting);
		});
	 
		
		
		
	 function setEdit() {
	 var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
	 remove = $("#remove").attr("checked"),
	 rename = $("#rename").attr("checked"),
	 removeTitle = $.trim($("#removeTitle").get(0).value),
	 renameTitle = $.trim($("#renameTitle").get(0).value);
	 zTree.setting.edit.showRemoveBtn = remove;
	 zTree.setting.edit.showRenameBtn = rename;
	 zTree.setting.edit.removeTitle = removeTitle;
	 zTree.setting.edit.renameTitle = renameTitle;
	 showCode(['setting.edit.showRemoveBtn = ' + remove, 'setting.edit.showRenameBtn = ' + rename,
	 'setting.edit.removeTitle = "' + removeTitle +'"', 'setting.edit.renameTitle = "' + renameTitle + '"']);
	 }
	 function showCode(str) {
	 var code = $("#code");
	 code.empty();
	 for (var i=0, l=str.length; i<l; i++) {
	 code.append("<li>"+str[i]+"</li>");
	 }
	 }
	
	 $(document).ready(function(){
	 $.fn.zTree.init($("#treeDemo"), setting, zNodes);
	 setEdit();
	 $("#remove").bind("change", setEdit);
	 $("#rename").bind("change", setEdit);
	 $("#removeTitle").bind("propertychange", setEdit)
	 .bind("input", setEdit);
	 $("#renameTitle").bind("propertychange", setEdit)
	 .bind("input", setEdit);
	 }); 

</script>
</html>