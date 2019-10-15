package servlets;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import models.Product;
import mySQL.MySQLProductDAO;
import utils.HTTPUtils;

@Controller
@RequestMapping("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(method = RequestMethod.GET)
	protected String doGet(RedirectAttributes redirectAttributes, ModelMap model, HttpServletRequest request){
		HttpSession session = HTTPUtils.getCurrentSession();
    	model.addAttribute("session", session);
		
		List<Product> products;
		if (request.getParameter("category") != null) {
			int category = Integer.parseInt(request.getParameter("category"));
			products = new MySQLProductDAO().getProductByCategory(category);
		} else {
			products = new MySQLProductDAO().getProductList();
		}
//		redirectAttributes.addAttribute("productsList", products);
		request.setAttribute("productList", products);
		return "products";
	}


	@RequestMapping(method = RequestMethod.POST)
	protected String doPost(RedirectAttributes redirectAttributes, ModelMap model){
		// TODO Auto-generated method stub
		return "products";
	}

}
