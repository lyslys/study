<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/js/easyui/themes/icon.css">
    <script type="text/javascript" src="/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">

		$(function() {

			var toolbar = [ {
				id : 'button-add',
				text : '增加',
				iconCls : 'icon-add',
				handler : showWin
			} , {
				id : 'button-delete',
				text : '批量删除',
				iconCls : 'icon-cancel',
				handler : batchDelete
			}];

			var columns = [ [
					{
						field : 'id',
						checkbox : true
					},{
						field : 'loginName',
						title : '登录名',
						width : 110,
						align : 'center'
					},{
						field : 'name',
						title : '姓名',
						width : 150,
						align : 'center',
					},{
						field : 'phone',
						title : '电话',
						width : 150,
						align : 'center',
					},{
						field : 'createTime',
						title : '创建时间',
						width : 150,
						align : 'center',
					},{
						field : 'status',
						title : '状态',
						width : 150,
						align : 'center',
					},{
						field : 'opt',
						title : '操作',
						width : 80,
						align : 'center',
						formatter:function(value, row, index){
							return  '<a onclick="showWin(\''+row.id+'\')" href="javascript:void(0)">编辑</a>';
						 }
					} ] ];

			//表格加载
			$('#grid')
					.datagrid(
							{
								fit : true,
								rownumbers : true,
								pageList : [ 30, 50, 100 ],
								pageSize : 30,
								pagination : true,
								toolbar : toolbar,
								striped : true,
								url : "/aoXinBack/aoxinUser/queryList.action",
								loadMsg : "加载中，请稍后.....",
								idField : 'id',
								emptyMsg: '<b style="color:red;">没有相关记录！</b>',
								columns : columns
							});

		});

		//弹出窗口
		function showWin(id) {

			var titleNew ="";

			if(typeof id == "object"){
				id="";
				titleNew = "添加物品";
			}else{
				titleNew = "编辑物品";
			}

			$("#commonWindow").window({
				title: titleNew,
				href:"/farm/toForm?id="+id,
				width: 600,
                height: 300,
				modal: true,
				shadow: true,
				resizable:false,
			 });

			$("#commonWindow").window("open");

		}

		//批量删除
	   function batchDelete(){
			var ids = [];
			var items = $("#grid").datagrid("getSelections");
			if (items.length == 0) {
				$.messager.alert("提示", "至少选中一行！");
				return;
			}
			for (var i = 0; i < items.length; i++) {
				ids.push(items[i].id);
			}

			$.messager.confirm(
							"操作提示",
							"您确定要执行删除操作吗？",
							function(isTure) {
								if (isTure) {
									$.post("/aoXinBack/aoxinUser/batchDelete.action",{id : ids.join(",")},function(msg){
										$('#grid').datagrid("reload");//刷新表格
										$('#grid').datagrid("uncheckAll");
										$.messager.alert("提示",msg);
									});
								}
							});
	   }
	</script>
</head>
<body class="easyui-layout">

	<div region="center" border="false">
		<table id="grid"></table>
	</div>
	<div class="easyui-window" id="commonWindow" collapsible="false" minimizable="false" maximizable="false" closed="true" style="top:20px;left:200px"></div>
    <br/>
</body>
</html>