<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form>
	<table border="1" text>
	    <tr>
	        <th>회원탈퇴</th>
	    </tr>
	    <tr>
	        <td>아이디</td>
	    </tr>
	    <tr>
	        <td></td>
	    </tr>
	    <tr>
	        <td>비밀번호</td>
	    </tr>
	    <tr>
	        <td>
	            <input type="password" class="passcheck" id="passcheck"/>
	            <input type="button" class="deletebtn" id="deletebtn" value="✕"/>
	            <input type="button" class="seebtn" id="seebtn" value="보기"/>
	        </td>
	    </tr>
	    <tr>
	        <td>
	            <input type="submit" class="smbtn" id="smbtn" value="계정삭제"/>
	        </td>
	    </tr>
	    <tr>
	        <td>
	            - 비밀번호 확인 후 아이디는 즉시 탈퇴됩니다.<br/>
	            - 탈퇴 후에는 기존의 아이디와 데이터는 복구할 수 없으니 신중하게 선택해주세요.
	        </td>
	    </tr>
	</table>
</form>
</body>
</html>