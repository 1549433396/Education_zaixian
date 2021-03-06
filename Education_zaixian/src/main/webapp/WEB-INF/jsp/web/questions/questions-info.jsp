<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>问题详情</title>
</head>
<body>
	<div class="bg-fa of">
		<section class="container">
			<section class="i-question">
				<div class="fl col-7">
					<section class="mr30 pt10">
						<section class="path-wrap txtOf hLh30">
							<a href="${ctx }" title="" class="c-999 fsize14">首页</a>
							\
							<a href="${ctx }/front/questions/list/0" title="" class="c-999 fsize14">全部问答</a>
							\ <span class="c-333 fsize14">${questions.title }</span>
						</section>
						<!-- /问题详情 开始 -->
						<div>
							<section class="q-infor-box">
								<div class="pr">
									<aside class="q-head-pic">
										<c:choose>
											<c:when test="${not empty questiones.eduUser.pic_img }">
												<img src="<%=staticImage %>${questiones.eduUser.pic_img }" alt="">
											</c:when>
											<c:otherwise>
												<img src="${ctx }/static/inxweb/img/avatar-boy.gif" alt="">
											</c:otherwise>
										</c:choose>
										<p class="hLh30 txtOf"></p>
									</aside>
									<section class="q-txt-box">
										<aside class="q-share">
											<span class="fl" title="分享到："><em class="icon14 q-share-icon mt5">&nbsp;</em></span>
											<div class="fl ml10" style="width: 95px;">
												<div class="bdsharebuttonbox bdshare-button-style0-16" id="bdshare" data-bd-bind="1443601302583" style="right: -160px;">
													<a title="分享到新浪微博" href="#" class="bds_tsina" data-cmd="tsina"></a>
													<a title="分享到微信" href="#" class="bds_weixin" data-cmd="weixin"></a>
													<a title="分享到QQ空间" href="#" class="bds_qzone" data-cmd="qzone"></a>
													<a title="分享到腾讯微博" href="#" class="bds_tqq" data-cmd="tqq"></a>
												</div>
												<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
											</div>
											<div class="clear"></div>
										</aside>
										<h3 class="hLh30 txtOf">
											<em class="icon16 q-tw">&nbsp;</em> <span class="c-blue fsize14"> <c:if test="${empty questions.eduUser.show_name }">${questions.eduUser.email }</c:if> <c:if test="${not empty questions.eduUser.show_name }">${questions.eduUser.show_name }</c:if>
											</span> <span class="c-999 fsize14"> <c:if test="${questions.type==1 }">课程提问</c:if> <c:if test="${questions.type==2 }">学习分享</c:if>
											</span>
										</h3>
									</section>
									<section class="ml50 pl10">
										<div class="mt20">
											<h3 class="hLh30 txtOf">
												<span class="fsize18 c-333 vam">${questions.title }</span>
											</h3>
										</div>
										<div class="i-q-txt mt15">
											
												<span class="c-999 f-fA"><c:out value="${questions.content}"></c:out></span>
											
										</div>
										<div class="mt20 pr10">
											<section class="fr">
												<span> <a href="#i-art-comment" title="评论" class="noter-dy vam">
														<em class="icon18">&nbsp;</em>(<span id="questionsReplyCount">${questions.reply_count }</span>)
													</a> <tt class="noter-zan vam ml10 f-fM" title="赞一下" onclick="addPraise(${questions.id },1,this)">
														<em class="icon18">&nbsp;</em>(<span>${questions.praise_count }</span>)
													</tt>
												</span>
											</section>
											<span class="c-ccc fl vam">
											<fmt:formatDate value="${questions.add_time }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
											</span>
											<section class="fl ml20 pt10">
												<div class="taglist clearfix">
													<c:forEach items="${question.listtag }" var="questionsTag">
																	<a title="${questionsTag.questions_tag_name }" data-id="${questionsTag.questions_tag_id }" onclick="submitForm('${questionsTag.questions_tag_id }','questionsTagId')" class="list-tag" href="javascript:;">${questionsTag.questions_tag_name }</a>
													</c:forEach>
												</div>
											</section>
											<div class="clear"></div>
										</div>
									</section>
								</div>
								<span id="questionsCommentSpan"></span>
							</section>
						</div>
						<!-- /问题列表 结束 -->
					</section>
				</div>
				<aside class="fl col-3">
					<div class="mt30 pl10">
						<section class="pt10">
							<a href="javascript:void(0)" onclick="toAddQuestions()" title="我要提问" class="comm-btn c-btn-5">我要提问</a>
						</section>
						<section class="pt20">
							<div class="taglist clearfix">
								<form action="${ctx}/front/questions/list/0" id="searchForm" method="post">
									<input type="hidden" id="pageCurrentPage" name="page.currentPage" value="1" />
									<%-- <input type="hidden" name="questions.orderFalg" value="${questions.orderFalg}" /> --%>
									<input type="hidden" name="questions.type" value="${questions.type}" />
									<input type="hidden" name="questions.status" value="${questions.status}" />
									<input type="hidden" name="questions.questionsTagId" value="${questions.listtag}" />
								</form> 
								<a onclick="submitForm('0','questionsTagId')" href="javascript:;" class="list-tag <c:if test='${questionsTag.questions_tag_id==0 }' >onactive</c:if>" data-id="0" title="JAVA">全部</a>
								<c:forEach items="${listTag }" var="questionsTag">
									<a title="${questionsTag.questions_tag_name }" data-id="${questionsTag.questions_tag_id }" class="list-tag <c:if test='${questionsTag.questions_tag_id==questionsTag.questions_tag_id }' >onactive</c:if>" href="javascript:;" onclick="submitForm('${questionsTag.questions_tag_id }','questionsTagId')">${questionsTag.questions_tag_name }</a>
								</c:forEach>
							</div>
						</section>
						<!-- /标签云 -->
						<section class="mt30">
							<section class="c-infor-tabTitle c-tab-title">
								<a href="javascript: void(0)" title="热门问答推荐">热门问答推荐</a>
							</section>
							<div class="q-r-rank-list">
								<ul id="hotQuestions">
									<section class="no-data-wrap">
										<em class="icon30 no-data-ico">&nbsp;</em> <span class="c-666 fsize14 ml10 vam">没有相关数据，小编正在努力整理中...</span>
									</section>
								</ul>
							</div>
						</section>
						<!-- /热门问答排行 -->
					</div>
				</aside>
				<div class="clear"></div>
			</section>
		</section>
		<!-- /提问题 结束 -->
	</div>
	<script>
	var questionsId="${questions.id}";
	</script>
	<script type="text/javascript" src="${ctx}/static/inxweb/questions/questions_info.js"></script>
	<script type="text/javascript" src="${ctx}/static/inxweb/questions/questions.js"></script>
</body>
</html>