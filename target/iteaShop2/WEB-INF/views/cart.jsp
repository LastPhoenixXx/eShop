<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/include/Heder.jsp"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="static/java-script/toCart.js"></script>

<h1>Cart page</h1>
<div style="color: white">

	<c:choose>
		<c:when test="${empty sessionScope.cart.products.keySet()}">
			<h1>Your cart is empty</h1>
		</c:when>
		<c:otherwise>
			<c:forEach var="product"
				items="${sessionScope.cart.products.keySet()}">
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
							onclick="minus(${product.id})" /> <span id="q${product.id}">${sessionScope.cart.products.get(product)}</span>
							<img src="static/images/plus.jpg" width="20"
							onclick="plus(${product.id})" /></td>
					</tr>
				</table>
				<br>
				<br>
			</c:forEach>
			<h1>Total cost: ${sessionScope.cart.totalCost }</h1>
		</c:otherwise>
	</c:choose>

</div>
<%@ include file="/WEB-INF/include/Footer.jsp"%>