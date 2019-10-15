<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/include/Heder.jsp"%>
<script src = "https://code.jquery.com/jquery-3.4.1.js"></script>
<script>
function sendData(){
$.ajax({
        url:     "/cart", 
        type:     "GET", 
        dataType: "html", 
    data: 'product=${product.id}&qnt=1',
        success: function(response) { 
         alert("response = " + response);
    
        },
        error: function(response) { // Данные не отправлены
            document.getElementById(result_form).innerHTML = "Ошибка. Данные не отправленны.";
        }
    });
}
</script>
<h1>Product page</h1>
<div style="color: white">
	<c:forEach var="product" items="${requestScope.productList}">
		<table>
			<tr>
				<td width="200">${product.name}</td>
				<td width="400"></td>
			</tr>
			<tr>
				<td><img src="static/productImage/${product.id}.jpg" height="200"></td>
				<td>${product.description}</td>
			</tr>
			<tr>
				<td>price:${product.price}</td>
				<td>
				<form action = "./cart" method = "post"><input type = "hidden" name ="productToBuy" value ="${product.id}" /> 
				<input type="submit" value="buy" onclick= "sendData()" />
				
			</form></td></tr>
		</table>
		<br>
		<br>
	</c:forEach>
</div>
<%@ include file="/WEB-INF/include/Footer.jsp"%>