<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title></title>
	<link rel="stylesheet" href="">
	<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
</head>
<body>
	<form>
		名字：<input id="staffName" type="text" name="staffName" value=""><br>
		天数：<input id="travel" type="text" name="travel" value=""><br>
		经费：<input id="cost" type="text" name="cost" value="0" ><br>
		<input id="appeal" type="button" name="appeal" value="申请"><br>
		<label id="label"></label>
	</form>
	
	 <script type="text/javascript">
            $(function () {        			    
			    $("#appeal").click(function(){		  
			    	var staffName=$("#staffName").val();
			    	var loadingIndex=null;
			    	$.ajax({
			    		type:"post",
			    		url :"${APP_PATH}/stafftravel/appeal",
			    		data:{
			    			"staffName":staffName,
			    			"travel" :$("#travel").val(),
			    			"cost" :$("#cost").val()
			    		},
			    		success:function(ajaxResult){
			    			if(ajaxResult.success){
			    				$("#label").html(ajaxResult.data);  				
			    			}
			    			else{
			    				$("#label").html(ajaxResult.data);
			    			}
			    		}
			    	})
			    })		    
            });
      </script>
</body>
</html>