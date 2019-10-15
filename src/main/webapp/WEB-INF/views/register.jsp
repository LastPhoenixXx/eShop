<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/Heder.jsp" %>
<%@page import="models.*"%>>
<%@page import="javax.servlet.http.HttpSession" %>

 <h1>Registration</h1>
 
   
<%user = session.getAttribute("LOGGED_USER") != null ? (User) session.getAttribute("LOGGED_USER") : new User();%>
 
 <table border = '0'>
		<tr>
			<td>
				<form action="" method="post">
					<table border='0'>
						<tr>
							<td>Login:</td>
							<td><input type="text" name="login" required pattern="^[a-zA-Z0-9.!#$%&*+/=?^_'{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" placeholder="Enter ur Email" value= <%=user.getLogin()!=null?user.getLogin():""%>></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" name="password" required placeholder="Enter ur Password"/></td>
						</tr>
						<tr>
							<td>Re-type password: </td>
							<td><input type="password" name="re-password" required placeholder="Repeat ur Password"/></td>
						</tr>
						<tr>
							<td>Name: </td>
							<td><input type="text" name="name" required pattern="[a-zA-Z]+" placeholder="Enter ur Name" value= <%=user.getName()!=null?user.getName():""%> ></td>
						</tr>
						<tr>
							<td>Region: </td>
							<td>
								<select name="region" required>
									<option value=""></option>
									<option <%=(user.getRegion() != null?(user.getRegion().equals("USA")?"selected":""):"")%> value="usa">USA</option>
									<option <%=(user.getRegion() != null?(user.getRegion().equals("UK")?"selected":""):"")%> value="uk">UK</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>Gender: </td>
							<td>
								M<input required type="radio" <%=(user.getGender() == 47?(user.getGender()==1?"checked":""):"")%>  value="male" name="gender"/>
								F<input required type="radio" <%=(user.getGender() == 47?(user.getGender()==0?"checked":""):"")%>  value="female" name="gender"/>
							</td>
						</tr>
						<tr>
							<td>Comment: </td>
							<td>
								<textarea name="comment" required cols="20" rows="10" placeholder="Leave ur cooment here"><%=user.getComment()!=null?user.getComment():""%></textarea>
							</td>
						</tr>
						<tr>
							<td>Install Amigo Browser</td>
							<td><input type="checkbox" name="cb"  /></td>
						</tr>
						<tr>
							<td></td>
							<td text-align="right"><input type="submit" value="Submit"/></td>
						</tr>
					</table>
				</form>
			</td>
			<td>
			<font color="red">
					
			</font>
				
			</td>
		</tr>
	</table>
 
 <%@ include file="/WEB-INF/include/Footer.jsp" %>
 
 
			  