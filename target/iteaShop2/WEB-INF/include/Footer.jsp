<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@page import="models.*"%>
<%@page import="controllers.CartController"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<%
	User userSe = (User) session.getAttribute("LOGGED_USER");
%>
</div>
<%
	if (session.getAttribute("cart") != null) {
		int cartCount = ((Cart) session.getAttribute("cart")).getSize();
	} else {
		int cartCount = 99999;
	}
%>
<div id="sidebar">
	<table border=1>
		<tr>
			<td width="252" align="left"><font color=white> <%=userSe == null ? "Вы не авторизованы" : "Добро пожаловать " + userSe.getName()%>
				<br />
				В вашей корзине <span id="cart"><%=(session.getAttribute("cart") != null) ? ((Cart) session.getAttribute("cart")).getSize() : "0"%></span>
				товаров. </font></td>
		</tr>
	</table>
	<h2>Боковое меню</h2>
	<ul>
		<li><a href="./products?category=1">Alco</a></li>
		<li><a href="./products?category=2">Drugs</a></li>
		<li><a href="./products?category=3">Cookie</a></li>
		<li><a href="/iteaShop2/register"><%=userSe == null ? "Регистрация" : "Редактирование"%></a></li>
		<li><a href="/iteaShop2/login"><%=userSe == null ? "Вход" : "Выход"%></a></li>
		<li><a href="/iteaShop2/cart">Корзина</a></li>
	</ul>
</div>
</div>
</div>
</div>
</div>
<div id="footer">
	<p>Copyright (c) by Бондаренко Антон</p>
</div>
<!-- end #footer -->
</body>
</html>
