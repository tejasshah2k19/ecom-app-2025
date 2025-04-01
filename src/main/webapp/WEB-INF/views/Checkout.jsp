<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="pay" method="post">
	
	Amount : <input type="text" readonly="readonly" value="${amount}"/><Br><br> 
	Credit Card : <input type="text" size="16" name="ccNum"/><Br><Br>  
	CVV :  <input type="text" name="cvv" size="3"/><br><Br> 
	ExpDate : <input type="text" name="expDate" size="5"/><br><br> 
	
	<input type="submit" value="Pay"/> 

</form>
</body>
</html>