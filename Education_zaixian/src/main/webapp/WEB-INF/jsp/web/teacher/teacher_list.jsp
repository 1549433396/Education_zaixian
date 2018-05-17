<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>讲师列表</title> 
</head>
<body>
	<div id="aCoursesList" class="bg-fa of">
		<!-- /课程列表 开始 -->
		<section class="container">
			<header class="comm-title all-teacher-title">
				<h2 class="fl tac">
					<span class="c-333">全部讲师</span>
				</h2>
				<section class="c-tab-title">
					<a id="subjectAll" title="全部" href="${ctx }/front/teacher">全部</a>
					<c:forEach var="subject" items="${subjectList }">
						<a id="subject_id" title="${subject.subject_name }" href="javascript:void(0)" onclick="submitForm(${subject.subject_id})">${subject.subject_name }</a>
					</c:forEach>
				</section>
			</header>
			<section class="c-sort-box unBr">
				<div>
					<!-- /无数据提示 开始-->
					<c:if test="${empty teacherList }">
						<section class="no-data-wrap">
							<em class="icon30 no-data-ico">&nbsp;</em> <span class="c-666 fsize14 ml10 vam">没有相关数据，小编正在努力整理中...</span>
						</section>
					</c:if>
					<!-- /无数据提示 结束-->
					<article class="i-teacher-list">
						<ul class="of">
							<c:if test="${not empty teacherList }">
								<c:forEach var="teacher" items="${teacherList }">
									<li>
										<section class="i-teach-wrap">
											<div class="i-teach-pic">
												<a href="${ctx }/front/teacher/getById/${teacher.id}" title="${teacher.name }">
													<c:choose>
														<c:when test="${not empty teacher.pic_path }">
															<img src="${ctx }/static/inxweb/img/default-tea-img.gif" xsrc="<%=staticImage %>${teacher.pic_path}" alt="">
														</c:when>
														<c:otherwise>
															<img xSrc="${ctx }/static/inxweb/img/default-tea-img.gif" src="${ctx }/static/inxweb/img/default-tea-img.gif" alt="">
														</c:otherwise>
													</c:choose>
												</a>
											</div>
											<div class="mt10 hLh30 txtOf tac">
												<a href="${ctx }/front/teacher/getById/${teacher.id}" title="${teacher.name }" class="fsize18 c-666">${teacher.name }</a>
											</div>
											<div class="hLh30 txtOf tac">
												<span class="fsize14 c-999">${teacher.career }</span>
											</div>
											<div class="mt15 i-q-txt">
												<p class="c-999 f-fA">${teacher.education}</p>
											</div>
										</section>
									</li>
								</c:forEach>
							</c:if>
						</ul>
						<div class="clear"></div>
					</article>
				</div>
				<!-- 公共分页 开始 -->
				<div>
					<form action="${ctx }/front/getParBySub" method="post" id="searchForm">
						<input type="hidden" name="page" id="page" value="${totalPage }" />
						<input type="hidden" name="page.currentPage" id="pageCurrentPage" value="1">
						<input type="hidden" name="queryTeacher_subjectId" id="queryTeacher_subjectId" value="${subject_id }">
					</form>
					<%-- <jsp:include page="${ctx }/front/teacher/page"></jsp:include> --%>
				</div>
				<!-- 公共分页 结束 -->
			</section>
		</section>
		<!-- /课程列表 结束 -->
		
		<div align="center" class="scott">
			<a href="${ctx }/front/teacher?page=${page.prePage }"><</a>&nbsp;&nbsp;
			<c:forEach items="${pageNum }" var="p">
				<c:if test="${p==totalPage }">
					${p }&nbsp;&nbsp;
				</c:if>
				<c:if test="${p!=totalPage }">
				<a href="${ctx }/front/teacher?page=${p }">${p }</a>&nbsp;&nbsp;
				</c:if>
			</c:forEach> 
			<a href="${ctx }/front/teacher?page=${page.nextPage }">></a>
		</div>
		
	</div>
<script type="text/javascript">
	$(function() {
		if ('${subject_id}' == null || '${subject_id}' == 0) {
			$("#subjectAll").addClass("current");
		}else{
			$("#${subject_id}").addClass("current");
		};
		scrollLoad(); //响应滚动加载课程图片
	})
	
	/**
	 * 条件查询
	 */
	function submitForm(val){
		$("#queryTeacher_subjectId").val(val);
		$("#searchForm").submit();
	}
</script>
	<style>
div.scott {
	padding: 3px;
	margin: 3px;
	text-align: center;
}

div.scott a {
	border: #ddd 1px solid;
	padding: 2px 5px;
	color: #88af3f;
	margin: 0 2px 0 0;
	text-decoration: none;
}

div.scott a:hover {
	border: #85bd1e 1px solid;
	color: #638425;
	background-color: #f1ffd6;
}

div.scott a:active {
	border: #85bd1e 1px solid;
	color: #638425;
	background-color: #f1ffd6;
}

div.scott span.current {
	border: #b2e05d 1px solid;
	padding: 2px 5px;
	font-weight: bold;
	color: #fff;
	margin: 0 2px 0 0;
	background-color: #b2e05d;
}

div.scott span.disabled {
	border: #f3f3f3 1px solid;
	padding: 2px 5px;
	color: #ccc;
	margin: 0 2px 0 0;
}
</style>
</body>
</html>