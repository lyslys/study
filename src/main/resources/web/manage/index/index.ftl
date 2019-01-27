<!DOCTYPE html >
<html>
<head>
<title>后台管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	
	$(function() {
		
		$('.easyui-tree').tree({
			onClick: function(node){
				var name = node.target.childNodes[2].childNodes[0].value;
				var url = node.target.childNodes[2].childNodes[2].value;
				open(name,url);
			}
		});
		
	});
	
	// 创建一个新的tab页面
	function open(text, url) {
		if ($("#tabs").tabs('exists', text)) {
			$("#tabs").tabs('select', text);
		} else {
			var content = '<div style="width:100%;height:100%;overflow:hidden;">'
					+ '<iframe src="' + url + '" scrolling="auto" style="width:100%;height:100%;border:0;" ></iframe></div>';
			$('#tabs').tabs('add', {
				title : text,
				content : content,
				closable : true
			});
		}
	}
	
	</script>
</head>
<body class="easyui-layout">
	<!-- 北面布局  -->
	<div data-options="region:'north',border:false"
		style="height:80px;padding:10px;background:url('/images/header_bg.png') no-repeat right;">
		<div id="sessionInfoDiv"
			style="position: absolute;right: 5px;top:10px;">
			[<strong>焱</strong>]，欢迎您！您使用[<strong>66</strong>]IP登录！
		</div>
		<div style="position: absolute; right: 5px; bottom: 10px; ">
			<a href="javascript:void(0);" class="easyui-menubutton"
				data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-help'">控制面板</a>
		</div>
		<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
			<div onclick="showEditPasswordWin();">修改密码</div>
			<div onclick="showAbout();">联系管理员</div>
			<div class="menu-sep"></div>
			<div onclick="logout();">退出系统</div>
		</div>
	</div>
	<!-- 西面布局  -->
	<div data-options="region:'west',split:true,title:'菜单导航'"
		style="width:200px">
		<div class="easyui-accordion" fit="true" border="false">
				<div title="后台管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto">
					<ul class="easyui-tree" lines="true">
								<li>
	                        		<span><input type="hidden" value="方案管理">
									<input type="hidden" value="/aoXinBack/product/productMain.action">
									<a style="text-decoration:none;" href="javascript:void(0)">方案管理</a></span>   
	                    		</li>
	                    		<li>
	                        		<span><input type="hidden" value="方案分类管理">
									<input type="hidden" value="/aoXinBack/productType/productTypeMain.action">
									<a style="text-decoration:none;" href="javascript:void(0)">方案分类管理</a></span>   
	                    		</li>
								<li> 
	                        		<span><input type="hidden" value="业务员管理">
									<input type="hidden" value="/aoXinBack/salesman/salesmanMain.action">
									<a style="text-decoration:none;" href="javascript:void(0)">业务员管理</a></span>   
	                    		</li>
								<li>
	                        		<span><input type="hidden" value="邀请码管理">
									<input type="hidden" value="/aoXinBack/inviteCode/inviteCodeMain.action">
									<a style="text-decoration:none;" href="javascript:void(0)">邀请码管理</a></span>   
	                    		</li>
								<li>
	                        		<span><input type="hidden" value="客户管理">
									<input type="hidden" value="/aoXinBack/consumer/consumerMain.action">
									<a style="text-decoration:none;" href="javascript:void(0)">客户管理</a></span>   
	                    		</li>
								<li>
	                        		<span><input type="hidden" value="广告管理">
									<input type="hidden" value="/aoXinBack/banner/bannerMain.action">
									<a style="text-decoration:none;" href="javascript:void(0)">广告管理</a></span>   
	                    		</li>
								<li>
	                        		<span><input type="hidden" value="订单管理">
									<input type="hidden" value="/aoXinBack/productOrder/productOrderMain.action">
									<a style="text-decoration:none;" href="javascript:void(0)">订单管理</a></span>   
	                    		</li>
								<li>
	                        		<span><input type="hidden" value="系统配置">
										<input type="hidden" value="/aoXinBack/webConfig/webConfigMain.action">
									<a style="text-decoration:none;" href="javascript:void(0)">系统配置</a></span>   
	                    		</li>
					</ul>
				</div>
				<div title="系统管理" data-options="iconCls:'icon-mini-add'" style="overflow:auto" selected = "true">
					<ul class="easyui-tree" lines="true">
	                    		<li>
	                        		<span><input type="hidden" value="农场管理">
									<input type="hidden" value="/farm/farmMain">
									<a style="text-decoration:none;" href="javascript:void(0)">农场管理</a></span>
	                    		</li>
					</ul>
				</div>
		</div>
	</div>
	<!-- 中间布局  -->
	<div data-options="region:'center'">
		<div id="tabs" fit="true" class="easyui-tabs" border="false">
			<div title="消息中心" id="subWarp"
				style="width:100%;height:100%;overflow:hidden">
				这里显示公告栏、预警信息和代办事宜
			</div>
		</div>
	</div>
	<!-- 底部布局  -->
	<div data-options="region:'south',border:false"
		style="height:50px;padding:10px;background:url('/images/header_bg.png') no-repeat right;">
		<table style="width: 100%;">
			<tbody>
				<tr>
					<td style="width: 550px;">
						<div style="color: #999; font-size: 8pt;">
							赛亿科技开发有限公司 | Powered by &nbsp;&nbsp;<a
								href="http://www.saiyimcu.com/" target="_Blank">www.saiyimcu.com</a>
						</div>
					</td>
					<td style="width: *;" class="co1"><span id="online"
						style="background: url(/images/online.png) no-repeat left;padding-left:18px;margin-left:3px;font-size:8pt;color:#005590;">在线人数:1</span>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>