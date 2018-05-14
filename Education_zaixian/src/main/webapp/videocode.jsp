<%@ page contentType="text/html;charset=UTF-8" language="java"	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<script type="text/javascript" src="/static/common/ckplayer/ckplayer.js" charset="utf-8"></script>
		<div id="videoareaname" style="width: 100%;height: 100%"></div>
		<script type="text/javascript">
		alert('${videourl}');
			var flashvars={
				f:'${videourl}',
				c:0,
				p:1,
				g:30
			};
			var video=['images/upload/video/20180203/ggh.mp4->video/mp4'];
			CKobject.embed('/static/common/ckplayer/ckplayer.swf','videoareaname','ckplayer_a1','100%','100%',false,flashvars,video);
		</script>
 
 
 
