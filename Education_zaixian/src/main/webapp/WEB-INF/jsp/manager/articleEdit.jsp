<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/js/utf8-jsp/themes/default/css/umeditor.css"
	type="text/css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="/css/bootstrap.min.css" />
<script src="/js/jquery-3.2.0.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/js/utf8-jsp/umeditor.min.js"></script>
<link rel="stylesheet" href="/css/bootstrap-table.min.css" />
<script src="/js/bootstrap-table.js" type="text/javascript"
	charset="utf-8"></script>
<script src="/js/bootstrap-table-zh-CN.min.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="/js/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
</head>
<style type="text/css">
#s1 {
	width: 100px;
	position: absolute;
}

#s2 {
	width: 100px;
	position: absolute;
}

#s3 {
	width: 100px;
	position: absolute;
}

#s4 {
	width: 100px;
	position: absolute;
}

#s5 {
	width: 100 px;
	position: absolute;
}

#s6 {
	width: 100 px;
	position: absolute;
}

#s7 {
	width: 100px;
	position: absolute;
}

#s8 {
	width: 100px;
	position: absolute;
}
</style>
<body>
	<form action="/admin/edit" class="form-horizontal"
		enctype="multipart/form-data" method="post">
		<div class="form-group">
			<hr style="height: 1px; border: none; border-top: 1px solid #555555;" />
			<input type="hidden" name="article_id" value="${article.article_id }" />
		</div>
		<div class="form-group">
			<label for="title" class="col-sm-1 control-label">标题</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="title"
					value="${article.title }" name="title" placeholder="允许输入3-100字符"
					onblur="titleFun()">
			</div>
		</div>
		<div class="form-group">
			<label for="summary" class="col-sm-1 control-label">摘要</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="summary"
					value="${article.summary }" name="summary"
					placeholder="允许输入3-200字符" onblur="summaryFun()">
			</div>
		</div>
		<div class="form-group">
			<label for="author" class="col-sm-1 control-label">作者</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="author" name="author"
					placeholder="允许输入3-200字符" value="${article.author }"
					onblur="authorFun()">
			</div>
		</div>
		<div class="form-group">
			<label for="source" class="col-sm-1 control-label">来源</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="source" name="sources"
					placeholder="允许输入3-50字符" value="${article.source }"
					onblur="sourceFun()">
			</div>
		</div>
		<div class="form-group">
			<label for="imgInp" class="col-sm-1 control-label">封面图片</label>
			<div class="col-sm-4">
				<image id="blah" src="${article.image_url }"
					style="width:530px; height:250px;" />
				<input type="hidden" name="hiddens"
					value="${article.image_url }"><input
					type="file" name="file" id="imgInp">
			</div>
		</div>
		<div class="form-group">
			<label for="source" class="col-sm-1 control-label">内容</label>
			<div class="col-sm-5">
				<script type="text/plain" id="content" name="contents"
					style="width:800px;height:400px;">
                      ${article.acontent.content }
                </script>
			</div>
		</div>
		<div class="form-group">
			<label for="sort" class="col-sm-1 control-label">排序值</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="sort" name="sorts"
					placeholder="默认为0" value="${article.sort }" onblur="sortFun()">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">修改</button>
				<button type="button" class="btn btn-default" onclick="resetFun()">重置</button>
				<button type="button" class="btn btn-default" onclick="returnFun()">返回列表</button>
			</div>
		</div>
	</form>
</body>
<!-- 实例化编辑器 -->
<script type="text/javascript">
	//实例化编辑器
	var um = UM.getEditor('content');
</script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#imgInp").change(function() {
		readURL(this);
	});

	function resetFun() {
		$("#title").val("");
		$("#summary").val("");
		$("#article_type").val("");
		$("#author").val("");
		$("#source").val("");
		$("#click_num").val("");
		$("#content").val("");
		$("#sort").val("");
	}
	function returnFun() {
		window.location.href = "/admin/article/showlist";
	}
</script>
</html>