package servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import controllers.Check;
import controllers.PasswordHasher;
import models.User;
import mySQL.MySQLUserDAO;
import utils.HTTPUtils;

/**
 * Servlet implementation class RegisterServlet
 */

@Controller
@RequestMapping("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MySQLUserDAO mySQLUserDAO = new MySQLUserDAO();

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = RequestMethod.GET)
	protected String get(RedirectAttributes redirectAttributes, ModelMap model, HttpServletRequest request) {
		HttpSession session = HTTPUtils.getCurrentSession();
		model.addAttribute("session", session);
		User user = (User) session.getAttribute("LOGGED_USER");
		if (user != null) {
			request.setAttribute("user", user);

		}

		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String post(RedirectAttributes redirectAttributes, ModelMap model,
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "re-password", required = false) String rePassword,
			@RequestParam(value = "region", required = false) String region,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "comment", required = false) String comment,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "cb", required = false) String agree) {
		HttpSession session = HTTPUtils.getCurrentSession();
		model.addAttribute("session", session);

		Check checker = new Check();
		User user = new User();
		PasswordHasher passwordHasher = new PasswordHasher();

		user.setId(((User)session.getAttribute("LOGGED_USER")).getId());
		user.setLogin(login);
		user.setPassword(password);
		user.setName(name);
		user.setRegion(region);
		user.setGender(gender.equals("male") ? 1 : 0);
		user.setComment(comment);

		if (session.getAttribute("LOGGED_USER") == null) {
			if (checker.checkRegParams(user.getLogin(), user.getPassword(), rePassword, user.getName(),
					user.getRegion(), gender, user.getComment())) {
				System.out.println("if(!checker.checkRegParams(user.getLogin(),");
				if (!mySQLUserDAO.checkUserByLogin(user.getLogin())) {
					System.out.println("if(!mySQLUserDAO.getUserByLogin(user.getLogin()))");
					try {
						user.setPassword(passwordHasher.hash(user.getPassword()));
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					mySQLUserDAO.insertUser(user);
					session.setAttribute("LOGGED_USER", user);
					return "mainPage";
				}
			}
		} else {
			if (checker.checkRegParams(user.getLogin(), user.getPassword(), rePassword, user.getName(),
					user.getRegion(), gender, user.getComment())) {
				System.out.println("else");
				

					mySQLUserDAO.updateUser(user);
					session.setAttribute("LOGGED_USER", user);
					return "mainPage";
			}
			
		}

			return "register";
	}

}
