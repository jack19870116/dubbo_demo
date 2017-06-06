<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="js/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
	这是个测试页面


	<input type="button" onclick="test()" value="测试实名" />
	
	
	<form action="${pageContext.request.contextPath}/server/Index.do" enctype="multipart/form-data" method="post"  >
	<input type="text" name="test" value="测试实名" />
	<input type="text" name="test1" value="测试实名" />
	<input type="text" name="test2" value="测试实名" />
	<input type="text" name="test3" value="测试实名" />
	<input type="text" name="test4" value="测试实名" />
	<input type="text" name="test5" value="测试实名" />
	<input type="text" name="test6" value="测试实名" />

<input   type="submit"  value="提交测试" >	
	</form>
	
	
	
	
	
	
	
<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>  
	<script type="text/javascript">
function test(){
	$.ajax({
		type : 'post',
		url :'${pageContext.request.contextPath}/server/Index.do',
		dataType : 'json',
		data : {
			"token":"00cbe22bfa51fabbcf2deb4f3d550dcb",
			 "plat":"6091",
			 "ip":"123456",
			 "client":"test",
			 "amount":"1.00",
			 "source":"",
			 "host":""
		},
		success : function(data) {
			
			 
		 document.write(data); 
		},
		error : function(data) {
			alert("失败访问");
		}
	});
}

</script>




</body>
</html>