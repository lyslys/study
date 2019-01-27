<!DOCTYPE html >
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">

		// 按条件查询
		function doSearch() {
			var elWin = $("#main").get(0).contentWindow;
			elWin.$('#grid').datagrid(
				{
					pagination : true,
					url : "/aoXinBack/aoxinUser/queryList.action",
					method : "post",
					queryParams : {
						name : $("#_name").val(),
						departmentId : $("#_departmentId").combobox("getValue")
					}
				});
		}

		//重置搜索
		function resetSearch(){
			$("#searchForm").form("reset");
			var elWin = $("#main").get(0).contentWindow;
			elWin.$('#grid').datagrid(
					{
						queryParams : {
							name : "",
						}
					});
			elWin.$('#grid').datagrid("reload");
		}
	</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'east',split:true,title:'搜索'" style="width:250px;overflow:auto;">
		<div>
			<form id="searchForm" name="searchForm">
				<table class="table-edit" width="100%" align="left">
					<tr>
						<td colspan="2" height="10"></td>
					</tr>
					<tr>
						<td style="width:60px;">关键字：</td>
						<td style="padding:0;margin:0;">
							<input type="text"  class="easyui-textbox" name="name" id="_name"  prompt="电话或姓名" />
						</td>
					</tr>
					<tr>
						<td colspan="2" height="5"></td>
					</tr>
					<tr>
						<td colspan="2" height="10"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><a href="javascript:void(0)"
							class="easyui-linkbutton" data-options="iconCls:'icon-search'"
							onclick="doSearch()">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)"
							class="easyui-linkbutton" data-options="iconCls:'icon-reload'"
							onclick="resetSearch()">重置</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div region="center" style="overflow:hidden;" border="false">
		<iframe id="main"
			src="/farm/farmList"
			scrolling="no" style="width:100%;height:100%;border:0;"></iframe>
	</div>
</body>
</html>