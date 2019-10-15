<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/include/Heder.jsp"%>
<h1>Cart page</h1>
<div style="color: white">
	<c:forEach var="product" items="${requestScope.productsToBuy}">
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
				</td></tr>
		</table>
		<br>
		<br>
	</c:forEach>
</div>
<%@ include file="/WEB-INF/include/Footer.jsp"%>