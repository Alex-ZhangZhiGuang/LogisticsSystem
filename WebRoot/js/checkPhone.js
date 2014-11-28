$().ready
(
	function()
	{	
		$("#cphone").blur
		(
			function()
			{
				var para =  $("#cphone").serialize();
				$.ajax
				(
					{
			             type:"POST",
			             url:"c!checkname.action",
			             dataType:"TEXT",
			             data:para,
			             cache:false,
			             success:function(data)
			             {
			             	var obj = eval("("+data+")");
			             	$("#msg").html(obj.msg);
			             }
					}
				)
			}
		)
	}
)

