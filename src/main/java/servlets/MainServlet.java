package servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import models.Product;
import mySQL.MySQLProductDAO;
import utils.HTTPUtils;

/**
 * Servlet implementation class MainServlet
 */
@Controller
@RequestMapping("/mainPage")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @RequestMapping(method = RequestMethod.GET)
	protected String doGet(RedirectAttributes redirectAttributes, ModelMap model){
    	HttpSession session = HTTPUtils.getCurrentSession();
    	model.addAttribute("session", session);
    	int amountOfCategory = 3;
    	List<Product> products = new ArrayList<Product>();
    	for(int i = 1; i <= amountOfCategory; i++) {
    		Product prod = new MySQLProductDAO().getOneProductByCategory(i);
    		products.add(prod);
    	}
    	System.out.println(products);
    	session.setAttribute("productsMP", products);
    	return "mainPage";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @RequestMapping(method = RequestMethod.POST)
	protected String doPost(RedirectAttributes redirectAttributes, ModelMap model) {
    	HttpSession session = HTTPUtils.getCurrentSession();
    	model.addAttribute("session", session);
		return "mainPage";
	}

}
