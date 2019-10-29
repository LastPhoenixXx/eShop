<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/Heder.jsp"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="static/java-script/toCart.js"></script>
<h1>Main page</h1>
<div style="color: white">
	<c:forEach var="product" items="${sessionScope.productsMP}">
		<table>
			<tr>
				<td width="200">${product.name}</td>
				<td width="400"></td>
			</tr>
			<tr>
				<td><img src="static/productImage/${product.id}.jpg"
					height="200"></td>
				<td>${product.description}</td>
			</tr>
			<tr>
				<td>price:${product.price}</td>
				<td><img src="static/images/minus.jpg" width="20"
					onclick="minus(${product.id})" /> <span id="q${product.id}">1</span>
					<img src="static/images/plus.jpg" width="20"
					onclick="plus(${product.id})" /> <input type="submit" value="buy"
					onclick="addToCart(${product.id})" /></td>
			</tr>
		</table>
		<br>
		<br>
	</c:forEach>
</div>
<%@ include file="/WEB-INF/include/Footer.jsp"%>