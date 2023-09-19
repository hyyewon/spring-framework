<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script> <!-- CDN방식으로 jQuery설치 -->
<script type="text/javascript">
	$(document).ready(function(){
		//yyy이벤트처리
		$("#yyy").on("click", function(){
			//ajax
			$.ajax({
				url:'yyy',
				type:"get",
				dataType:"json", //json타입으로 받을거야
				success: function(data,status,xhr){
					console.log(data);
					console.log(data.userid);
					//JSON --> str 변경
					var str = JSON.stringify(data); 
				},
				error:function(xhr,status,error){
					
				}
			});//end ajax
			
		});//end yyy
		
		//zzz이벤트처리
		$("#zzz").on("click", function(){
			//ajax
			$.ajax({
				url:'zzz',
				type:"get",
				dataType:"json", //json타입으로 받을거야
				success: function(data,status,xhr){
					console.log(data);
					console.log(data.userid);
					
					//배열반복
					$.each(data,function(idx,ele){
						console.log(ele);
						console.log(ele.userid);
					});
					
					//JSON --> str 변경
					var str = JSON.stringify(data); 
				},
				error:function(xhr,status,error){
					
				}
			});//end ajax
			
		});//end zzz
		
	});//end ready
</script>
</head>
<body>
<button id="yyy">yyy</button>
<button id="zzz">zzz</button>
</body>
</html>