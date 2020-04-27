<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>KOSPIECE</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/project/normalize.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/project/style.css">
    <!--웹 폰트 사용-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900&display=swap" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script>
    	$(function(){
    		$('#mypage').click(function(){
    			$(location).attr('href','<%=request.getContextPath()%>/project/mypage/mypageForm.jsp');
    		})
    	})
    </script>
</head>
<body>
<header class="Header">

    <h1><a href="#" class="logo" >KOSPIECE</a></h1>
        <nav class="nav">
            <ul class="list">
                <li class="list-item">
                    <a>맵</a>
                </li>
                <li class="list-item">
                    <a>실시간순위</a>
                </li>
                <li class="list-item">
                    <a>자유게시판</a>
                </li>
                <li class="list-item">
                    <a>관심주식</a>
                </li>
                <li class="list-item">
                    <a class="mypage" id="mypage">마이페이지</a>
                </li>
            </ul>
            <ul class="list2">
                <li class="list-item_search">
                    <form class="formS">
                    <input type="text" placeholder="&nbsp;&nbsp;Search" />
                    </form>
                    <form class="formL">
                    <input type="submit" value="🔍"/>
                    </form>
                </li>
                <li class="list-item_log">
                    <a href="#" target="_blank" rel="noopener">🚪&nbsp;&nbsp;login</a>
                </li>
            </ul>
        </nav>


</header>
</body>
</html>