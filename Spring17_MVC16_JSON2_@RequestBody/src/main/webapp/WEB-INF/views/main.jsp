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
		//yyy이벤트처리 ("json"(문자열로된 json으로 보내줘야 함)-->LoginDTO)
		$("#yyy").on("click", function(){
			//ajax
			$.ajax({
				url:'yyy',
				type:"post", //post로 요청
				dataType:"text", //text로 응답받을거야 (응답데이터 타입)
				headers:{ //요청데이터 타입
					"Content-type":"application/json" //전달할 타입(json)을 알려줌
				},
				data:JSON.stringify({userid:"홍길동",passwd:"123"}), //보내는 데이터는 data속성으로 보낼 수 있다.
				success: function(data,status,xhr){
				},
				error:function(xhr,status,error){
					
				}
			});//end ajax
			
		});//end yyy
		
		//zzz이벤트처리 ("json"(문자열로된 json으로 보내줘야 함)-->LoginDTO)
		$("#zzz").on("click", function(){
			//ajax
			$.ajax({
				url:'zzz',
				type:"post", //post로 요청
				dataType:"text", //text로 응답받을거야 (응답데이터 타입)
				headers:{ //요청데이터 타입
					"Content-type":"application/json" //전달할 타입(json)을 알려줌
				},
				data:JSON.stringify([{userid:"홍길동1",passwd:"123"},{userid:"홍길동2",passwd:"456"}]), //보내는 데이터는 data속성으로 보낼 수 있다.
				success: function(data,status,xhr){
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