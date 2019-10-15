<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="models.*"%>
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
    
   <% //User userSe=(User) session.getAttribute("LOGGED_USER");%>
    
    </div>
            
				<div id="sidebar">
					<table border=1>
                    <tr>
                    <td width="252" align="left">
                    <font color=white>
                    <%=user==null?"Вы не авторизованы":"Добро пожаловать "+user.getName() %> <br />
                    В вашей корзине 0 товаров.
                    </font>
                    </td>
                    </tr>
                    </table>
                    <h2>Боковое меню</h2>
					<ul>
						<li><a href="./products?category=1">Alco</a></li>
						<li><a href="./products?category=2">Drugs</a></li>
						<li><a href="./products?category=3">Cookie</a></li>
						<li><a href="/register">Регистрация</a></li>
						<li><a href="/login">Вход</a></li>
						<li><a href="/cart">Корзина</a></li>
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
