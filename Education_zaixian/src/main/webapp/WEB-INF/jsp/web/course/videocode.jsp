<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<script type="text/javascript" src="/static/common/ckplayer/ckplayer.js"
	charset="utf-8"></script>
<div id="videoareaname" style="width: 100%; height: 100%"></div>
<script type="text/javascript">
 		 var cookie = {
				set: function(name, value) {
					var Days = 30;
					var exp = new Date();
					exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
					document.cookie = name + '=' + escape(value) + ';expires=' + exp.toGMTString();
				},
				get: function(name) {
					var arr, reg = new RegExp('(^| )' + name + '=([^;]*)(;|$)');
					if(arr = document.cookie.match(reg)) {
						return unescape(arr[2]);
					} else {
						return null;
					}
				},
				del: function(name) {
					var exp = new Date();
					exp.setTime(exp.getTime() - 1);
					var cval = getCookie(name);
					if(cval != null) {
						document.cookie = name + '=' + cval + ';expires=' + exp.toGMTString();
					}
				}
			};
			var videoID = ${kpointId}; //视频的区分ID，每个视频分配一个唯一的ID
			var cookieTime = cookie.get('time_' + videoID); //调用已记录的time
			//console.log(cookieTime);
			if(!cookieTime || cookieTime == undefined) { //如果没有记录值，则设置时间0开始播放
				cookieTime = 0;
			}
			if(cookieTime > 0) {
				alert('本视频记录的上次观看时间(秒)为：' + cookieTime);
			} 
           /*  var videoObject = {
				container: '.videosamplex', //“#”代表容器的ID，“.”或“”代表容器的class
				variable: 'player', //该属性必需设置，值等于下面的new chplayer()的对象
				poster: 'pic/wdm.jpg',
				loaded:'loadHandler',
				video: 'http://img.ksbbs.com/asset/Mon_1703/05cacb4e02f9d9e.mp4' //视频地址
			}; */ 
			/*  if(cookieTime > 0) { //如果记录时间大于0，则设置视频播放后跳转至上次记录时间
				videoObject['seek'] = cookieTime;
			} */
			/* var player = new ckplayer(videoObject); 
		 
			function loadHandler() {
				player.addListener('time', timeHandler); //监听播放时间
			} */
			
			  function loadedHandler(){
			    if(CKobject.getObjectById('ckplayer_a1').getType()){
			      CKobject.getObjectById('ckplayer_a1').addListener('time',timeHandler);
			    }
			    else{
			      CKobject.getObjectById('ckplayer_a1').addListener('time','timeHandler');
			    }
			  } 
			  
			/* function loadHandler() {
				  alert("qwert");
				  CKobject.getObjectById('ckplayer_a1').addListener('time', timeHandler); //监听播放时间
			} */
		 
			function timeHandler(t) {
				cookie.set('time_' + videoID, t); //当前视频播放时间写入cookie
			} 
			 var flashvars={
				f:'${videourl}',
				c:0,
				p:1,
				loaded:'loadedHandler'
			};
 			 if(cookieTime > 0) { //如果记录时间大于0，则设置视频播放后跳转至上次记录时间
				 flashvars['g'] = cookieTime;
				} 
			var video=['${videourl}->video/mp4'];
			CKobject.embed('/static/common/ckplayer/ckplayer.swf','videoareaname','ckplayer_a1','100%','100%',false,flashvars,video);
		</script>



