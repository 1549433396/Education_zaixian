<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>课程节点</title>
<script type="text/javascript" src="/js/jquery-3.2.0.min.js"></script>
<link type="text/css" rel="stylesheet"
	href="/static/common/ztree/css/zTreeStyle.css" />
<script type="text/javascript"
	src="/static/common/ztree/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript"
	src="/static/common/ztree/jquery.ztree.excheck-3.5.min.js"></script>
<script type="text/javascript"
	src="/static/common/ztree/jquery.ztree.exedit-3.5.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/kindeditor/themes/default/default.css" />
<script type="text/javascript" src="/kindeditor/kindeditor-all.js"></script>
<script type="text/javascript"
	src="/static/admin/teacher/select_teacher_list.js"></script>
<script type="text/javascript"
	src="/static/common/uploadify/ccswfobject.js"></script>
<script type="text/javascript"
	src="/static/common/uploadify/swfobject.js"></script>
<script type="text/javascript"
	src="/static/common/uploadify/jquery.uploadify.v2.1.4.min.js"></script>
<script type="text/javascript" src="/static/admin/js/jquery-form.js"></script>
<script type="text/javascript" src="/static/admin/js/formdata.js"></script>
<script type="text/javascript" src="/static/admin/kpoint/kpoint.js"></script>
<style type="text/css">
#swfDiv embed {
	position: absolute;
	z-index: 1;
}

[type='file'] {
	/*   display: block !important; */
	
}

#swfDiv {
	*position: absolute;
	z-index: 2;
}
</style>
<script type="text/javascript">
		var ztree='${kpointList}';
		function Wopen(){
			var iWidth = 600;                          //弹出窗口的宽度;
			  var iHeight = 400;                        //弹出窗口的高度;
			  var iTop = ((window.screen.availHeight-30-iHeight)/2)+'px';       //获得窗口的垂直位置;
			  var iLeft = ((window.screen.availWidth-10-iWidth)/2)+'px';           //获得窗口的水平位置;
		    window.open('/admin/toTeacherList','','height='+iHeight+',innerHeight='+iHeight
		    		+',width='+iWidth+',innerWidth='+iWidth+',top='+iTop+',left='+iLeft+',toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no,status=yes');
		    } 
		$(function(){
			showKpointZtree(ztree);
			//文本编辑框
			//initKindEditor_addblog('content', 580, 350,'courseContxt','true');
		});


		//上传控件加载
		function uploadPicLoad(fileupload,showId,fileQueue){
			$("#fileuploadUploader").remove();
			 $("#"+fileupload).uploadify({
			    'uploader' : '/static/common/uploadify/uploadify.swf', //上传控件的主体文件，flash控件  默认值='uploadify.swf'
				'script'  :'/admin/kpoint/uploadVideo',
				'scriptData':{"fileType":"mp4","param":"video"},
				//'queueID' : fileQueue, //文件队列ID
				'fileDataName' : 'uploadfile', //您的文件在上传服务器脚本阵列的名称
				'auto' : true, //选定文件后是否自动上传
				'multi' :false, //是否允许同时上传多文件
				'hideButton' : false,//上传按钮的隐藏
				'buttonText' : 'Browse',//默认按钮的名字
				'buttonImg' : '/static/common/uploadify/liulan.png',//使用图片按钮，设定图片的路径即可
				'width' : 105,
				'simUploadLimit' : 3,//多文件上传时，同时上传文件数目限制
				'sizeLimit' : 5120000000,//控制上传文件的大小
				'queueSizeLimit' : 3,//限制在一次队列中的次数（可选定几个文件）
				'fileDesc' : '支持格式:mp4.',//出现在上传对话框中的文件类型描述
				'fileExt' : '*.MP4;*.mp4;',//支持的格式，启用本项时需同时声明fileDesc
				'cancelImg' : '/static/common/uploadify/cancel.png',
				'removeTimeout' : 0,          //完成后从列表清除时间，设置0，不用等，直接去掉。
                'removeCompleted' : true,
				onSelect : function(event, queueID,fileObj) {
					alert(fileObj.filePath);
					fileuploadIndex = 1;
					$("#"+fileQueue).html("");
					if (fileObj.size > 5120000000) {
						alert('文件太大最大限制5120000kb');
						return false;
					}
				},
				onComplete : function(event,queueID, fileObj, response,data) {
					$("#"+showId).val(response);
					$("#"+fileQueue).html("<br/><font color='red'>"+ fileObj.name + "上传成功！</font>");
					//$("#"+showId).show();
				},
				onError : function(event, queueID, fileObj,errorObj) {
					$("#"+fileQueue).html("<br/><font color='red'>"+ fileObj.name + "上传失败</font>");
				}  
			}); 
		}
		
		//确定修改
		function updateKpoint(){
			 var params = '';
//			初始代码
		 
		//	alert($("input[name='courseKpoint.kpointId']").val());
			//fd=	new FormData($("#updateForm")[0]);
			
			var name = $("input[name='courseKpoint.name']").val();
			if(name==null || $.trim(name)==''){
				alert('视频节点名不能为空');
				return false;
			}
			var sort = $("input[name='courseKpoint.sort']").val();
			var reg=/^\d+$/;
			if(!reg.test(sort)){
				alert('排序必须是正整数！');
				return false;
			}

			if($("#courseKpointKpointType").val()==1) {//章节专属验证
				var fileType = $("#fileType").val();
				if (fileType == 'TXT') {
					if ($("#content").val() != null) {
						alert("文本内容必填！");
						return;
					}
					var content = encodeURIComponent($("#content").val());
					params += "courseKpoint.content=" + content + "&";
				} else if (fileType == "VIDEO" && $("#videourl").val() == null) {
					alert("请填写视频地址");
					return;
				}
			}


			var playCount =$('input[name="courseKpoint.playCount"]').val();
			if(!reg.test(playCount)){
				alert('播放数必须是正整数！');
				return false;
			}

			 var kpoint_type=$("select").val();
			params+="kpoint_type="+kpoint_type+"&";
			var video_type=$("#courseKpointVideoType").val();
			params+="video_type="+video_type+"&";
			var file_type=$("#fileType").val();
			params+="file_type="+file_type+"&";  
			  $.ajax({
				url:'/admin/kpoint/updateKpoint',
				type:'post',
				dataType:'json',
				data:{'name':name,
					  'sort':sort,
					  'fileType':fileType,
					  'courseid':'${courseId}',
					  'pointtype':$("#courseKpointKpointType").val(),
					  'content':$("#content").val(),
					  'url':$("#videourl").val(),
					  'playCount':playCount,
					  'kpoint_id':$("#kpoint_id").val(),
					  'video_type':video_type,
					  'time':$("#time").val(),
					  'isfree':$('input[name="courseKpoint.free"]:checked').val(),
					  'teacherId':$("#teacherId").val()
				},
			/* 	processData: false,//用于对data参数进行序列化处理 这里必须false
		        contentType: false, //必须 */
				success:function(result){
					if(result.success==false){
						alert(result.message);
					}else{
						var obj = result.entity;
						ztreeObject = $.fn.zTree.getZTreeObj("kpointList");
						var node = ztreeObject.getNodeByParam('kpoint_id',obj.kpoint_id,null);
						node.name=obj.name;
						node.videoUrl=obj.video_url;
						node.sort = obj.sort;
						node.playCount = obj.play_count;
						node.free = obj.is_free;
						node.teacherId = obj.teacher_id;
						ztreeObject.updateNode(node);
						closeData();
					}
				},
				error:function(error){
					alert('系统繁忙，请稍后再操作！');
				}
			});  
		}
</script>
</head>
<body>
	<form action="" id="updateForm" method="post"
		enctype="multipart/form-data">
		<div class="mt20">
			<table width="100%" cellspacing="0" cellpadding="0" border="0"
				class="commonTab01">
				<thead>
					<tr>
						<th colspan="2" align="left"><span>${courseSellType}节点管理</span>
							<font color="red">*视频节点只支持二级</font></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="20%">
							<fieldset style="height: 662px;">
								<legend>
									<span>${courseSellType}节点管理</span> &gt; <span>节点列表</span>
								</legend>
								<div class="mt20">
									<div class="commonWrap">
										<div id="kpointList" class="ztree"></div>
										<a title="创建视频节点" onclick="addaKpoint(${courseId});"
											class="button tooltip" href="javascript:void(0)"> <span></span>
											创建视频节点
										</a> <a title="取消选中" onclick="ztreeCancelSelectedNode();"
											class="button tooltip" href="javascript:void(0)"> <span></span>
											取消选中
										</a>
									</div>
								</div>
							</fieldset>

						</td>
						<td width="80%">
							<fieldset id="updateWin" style="display: none; height: 662px;">
								<legend>
									&gt; <span>编辑节点</span>
								</legend>
								<div class="mt20">
									<div class="commonWrap">
										<input type="hidden" name="courseKpoint.kpointId" id="kpoint_id" />
										<table style="line-height: 35px;" width="100%" cellspacing="0"
											cellpadding="0" border="0" class="commonTab01">
											<tr>
												<td>节点名称:</td>
												<td style="text-align: left;"><input
													name="courseKpoint.name" type="text" /></td>
											</tr>
											<tr>
												<td>节点类型:</td>
												<td style="text-align: left;"><select
													id="courseKpointKpointType" name="courseKpoint.kpointType"
													onchange="kpointTypeChange()">
														<option value="0">目录</option>
														<option value="1">章节</option>
												</select></td>
											</tr>
											<tr style="display: none" class="tr_all">
												<td>课件类型:</td>
												<td style="text-align: left;"><select id="fileType"
													name="courseKpoint.fileType" onchange="chooseFileType()">
														<option value="VIDEO">视频</option>
														<option value="TXT">文本</option>
												</select></td>
											</tr>
											<tr style="display: none" class="tr_all videoType ">
												<td>视频类型:</td>
												<td style="text-align: left;"><select
													id="courseKpointVideoType" name="courseKpoint.videoType">
														<option value="INXEDUVIDEO">因酷云</option>
														<option value="IFRAME">其他</option>
														<option value="CC">CC视频</option>
														<option value="uploadVideo">上传本地视频</option>
												</select></td>
											</tr>
											<!-- 此处删除style="display: none;" -->
											<tr class="tr_fileType_control uploadVideo">
												<td>文件上传:</td>
												<td style='text-align: left;'><input type="file"
													id="fileupload" class="vam" name="mp4" /> <font style="font-size: 13px"
													color="red vam ml10">请上传mp4文件（<a target="_blank"
														href="http://www.ckplayer.com/manual/12/66.htm"><font style="font-size: 13px">边下边播文档</font></a>）
												</font>
													<div id="fileQueue" class="mt10"></div> <!-- <input type="hidden" name="courseKpoint.videoUrl" id="videourl" value="" style="width: 360px;"/> -->
												</td>
											</tr>
											<tr style="display: none" class="tr_all videoType">
												<td id="videoUrlTitle">视频地址:</td>
												<td style="text-align: left;"><input type="text"
													name="courseKpoint.videoUrl" id="videourl" value=""
													style="width: 360px;" />
											</tr>
											<tr class="tr_all txtContent" style="display: none;">
												<td>文本内容:</td>
												<td><textarea id="content" name="courseKpoint.content"
														rows="" cols=""></textarea></td>
											</tr>

											<tr>
												<td>排序:</td>
												<td><input type="text" value="0"
													name="courseKpoint.sort" /></td>
											</tr>
											<tr class="tr_all videoType">
												<td>播放次数:</td>
												<td><input type="text" value="0"
													name="courseKpoint.playCount" disabled="disabled"
													readonly="" readonly /></td>
											</tr>
											<tr class="tr_all videoType" id="timeLongTr">
												<td>播放时间:</td>
												<td><input type="text" value="00:00" id="time"
													name="courseKpoint.playTime" /></td>
											</tr>
											<tr class="tr_all videoType">
												<td>是否免费:</td>
												<td style="text-align: left;" id="isfree"><input
													type="radio" name="courseKpoint.free" value="1" /> 是 <input
													type="radio" name="courseKpoint.free" value="2" /> 否 <font
													color="red vam ml10">文档、文本格式、图片集、音频等格式暂不支持试听</font></td>
											</tr>
											<tr class="tr_all videoType" id="teacherTr">
												<td>视频讲师:</td>
												<td style="text-align: left;"><input type="hidden"
													name="courseKpoint.teacherId" id="courseKpoint.teacherId" value="0" /> <input
													type="hidden" name="teacherId" id="teacherId" value="" />
													<a href="javascript:void(0);" onClick="Wopen()"
													class="layui-btn">选择讲师</a> <span id="teacherName"></span></td>
											</tr>

											<tr>
												<td colspan="2">
													<input class="ui-state-default ui-corner-all"
														style="float: left;" 
														type="button" onclick="updateKpoint()" value="确定"  >
													<input class="ui-state-default ui-corner-all closeBut"
														style="float: left;" type="button" value="取消" >
												</td>
											</tr>
										</table>
									</div>
								</div>
							</fieldset>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="left"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- 修改视频节点信息窗口，结束 -->
	</form>
</body>
</html>