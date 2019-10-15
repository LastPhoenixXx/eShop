package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import models.User;
import mySQL.MySQLUserDAO;
import utils.HTTPUtils;

/**
 * Servlet implementation class LoginServlet
 */

@Controller
@RequestMapping("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MySQLUserDAO mySQLUserDAO=new MySQLUserDAO(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @RequestMapping(method = RequestMethod.GET)
	protected String get(RedirectAttributes redirectAttributes, ModelMap model){    	
    	HttpSession session = HTTPUtils.getCurrentSession();
    	model.addAttribute("session", session);
    	
    	System.out.println(session.getAttribute("LOGGED_USER"));
    	
    	return "login";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @RequestMapping(method = RequestMethod.POST)
	protected String post(RedirectAttributes redirectAttributes, ModelMap model,
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "password", required = false) String password) {
		User user = new User();
		
		
		if(mySQLUserDAO.getUserByLoginPassword(login, password) != null) {
			user = mySQLUserDAO.getUserByLoginPassword(login, password);
			HttpSession session = HTTPUtils.getCurrentSession();
	    	model.addAttribute("session", session);
	    	System.out.println(user);
			session.setAttribute("LOGGED_USER", user);
		} else {
			return "login";
		}
		
		
		return "mainPage";
	}

}
