<!DOCTYPE html >
<html>
<body>
		<div style="overflow:auto;padding:5px;" border="false">
			<form id="aoxinUserForm"  method="post" >
                <div style="padding-top:7px;margin-bottom:20px">
                    <input class="easyui-textbox" name="name" style="width:250px" data-options="label:'物品名称:',required:true">
                </div>
                <div style="padding-top:7px;margin-bottom:20px">
                    <input class="easyui-textbox" name="price" style="width:250px" data-options="label:'物品价格:',required:true">
                </div>
                <div style="padding-top:7px;margin-bottom:20px">
                    <input class="easyui-textbox" name="minute" style="width:250px" data-options="label:'生产时间:',required:true">
                </div>
                <div style="padding-top:7px;margin-bottom:20px">
                    <input class="easyui-textbox" name="storeName" style="width:250px" data-options="label:'所属店名:',required:true">
                </div>
			</form>
		</div>
		<div class="datagrid-toolbar">
			<a icon="icon-save" href="javaScript:saveForm();" class="easyui-linkbutton" plain="true">保存</a>
			<a icon="icon-reload" href="javaScript:formReset();" class="easyui-linkbutton" plain="true">重置</a>
		</div>
		
		<script type="text/javascript">

		//保存表单
		function saveForm() {

			$.post("/aoXinBack/aoxinUser/saveOrUpdate.action",$("#aoxinUserForm").serialize(),function(data){
				$.messager.alert("提示",data);
				$("#commonWindow").window("close"); // 关闭window
				$('#grid').datagrid("reload"); // 表格重载
			});
			
		}
		
	</script>
</body>
</html>