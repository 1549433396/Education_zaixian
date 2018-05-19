<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/base.jsp"%>
<section class="">
	<section class="question-list lh-bj-list pr">
		<ul class="pr10">
				<li>
					<aside class="noter-pic">
						<c:choose>
							<c:when test="${not empty questionsComments.eduUser.pic_img }">
								<img src="<%=staticImage %>${questionsComments.eduUser.pic_img }" alt="" width="50" height="50">
							</c:when>
							<c:otherwise>
								<img src="${ctx }/static/inxweb/img/avatar-boy.gif" alt="" width="50" height="50">
							</c:otherwise>
						</c:choose>
					</aside>
					<div class="of hLh20">
						<c:if test="${questions.status==0 and  questions.cus_id==eduUser.user_id and questionsComments.cus_id != questions.cus_id}">
							<span class="fr"><a href="javascript:void(0)" onclick="acceptComment(${questionsComments.id})" title="" class="comm-btn c-btn-6">采纳为最佳答案</a></span>
						</c:if>
						<span class="fl"> <font class="fsize12 c-blue"> <c:if test="${not empty questionsComments.eduUser.show_name }">${questionsComments.eduUser.show_name }</c:if> <c:if test="${empty questionsComment.eduUser.show_name }">${questionsComment.eduUser.email }</c:if>
						</font> <font class="fsize12 c-999 ml5">回复：</font></span>
					</div>
					<div class="noter-txt mt5">
						<p><c:out value="${questionsComments.content }"></c:out></p>
					</div>
					<div class="of mt5">
						<span class="fr"><font class="fsize12 c-999 ml5"> <!-- <a href="" class="c-blue mr10">删除</a> --> <fmt:formatDate type="both" value="${questionsComment.add_time }" pattern="yyyy-MM-dd HH:mm" />
						</font></span> <span class="fl"> <a href="javascript: void(0)" title="回答" class="noter-dy vam" onclick="getCommentById(this,${questionsComment.id })">
								<em class="icon18">&nbsp;</em>(<span>${questionsComments.replyCount }</span>)
							</a> <tt class="noter-zan vam ml10" title="赞一下" onclick="addPraise(${questionsComment.id },2,this)">
								<em class="icon18">&nbsp;</em>(<span>${questionsComment.praise_count }</span>)
							</tt>
						</span>
					</div>
					<div class="">
						<div class="mt10 pl10 pr10 pb10 commentReply${questionsComments.comment_id}">
							<dl class="n-reply-list">
								<c:forEach items="${questionsComments }" var="questionsComment" varStatus="index">
									<dd>
										<aside class="n-reply-pic">
												<c:choose>
													<c:when test="${not empty questionsComment.eduUser.pic_img }">
														<img src="<%=staticImage %>${questionsComment.eduUser.pic_img }" alt="">
													</c:when>
													<c:otherwise>
														<img src="${ctx }/static/inxweb/img/avatar-boy.gif" alt="">
													</c:otherwise>
												</c:choose>
										</aside>
										<div class="of">
											<span class="fl">
												<font class="fsize12 c-blue">
													<c:if test="${empty questionsComment.eduUser.show_name }">${questionsComment.eduUser.email }</c:if>
													<c:if test="${not empty questionsComment.eduUser.show_name }">${questionsComment.eduUser.show_name }</c:if>
												</font><font class="fsize12 c-999 ml5">评论：</font></span>
										</div>
										<div class="noter-txt mt5">
											<p><c:out value="${questionsComment.content }"></c:out></p>
										</div>
										<div class="of mt5">
											<span class="fr"><font class="fsize12 c-999 ml5"><fmt:formatDate type="both" value="${questionsComment.add_time }" pattern="yyyy-MM-dd HH:mm"/></font></span>
											<span class="fl">
												<tt class="noter-zan vam" title="赞一下" onclick="addPraise(${questionsComment.id },2,this)"><em class="icon18">&nbsp;</em>(<span>${questionsComment.praise_count }</span>)</tt>
											</span>
										</div>
									</dd>
								</c:forEach>
								<!-- 公共分页 开始 -->
								<%-- <jsp:include page="/WEB-INF/view/common/ajaxpage2.jsp"></jsp:include> --%>
								<!-- 公共分页 结束 -->
							</dl>
						</div>
					</div> <!-- /回复盒子 -->
				</li>
		</ul>
	</section>
</section>
