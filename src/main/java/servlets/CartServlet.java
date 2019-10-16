package servlets;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import models.Cart;
import models.Product;
import mySQL.MySQLProductDAO;
import utils.HTTPUtils;


@Controller
@RequestMapping("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	@RequestMapping(method = RequestMethod.GET)
	protected String get(RedirectAttributes redirectAttributes, ModelMap model, HttpServletRequest request,
			@RequestParam(value="productId", required = false) String productId) {
		HttpSession session = HTTPUtils.getCurrentSession();
    	model.addAttribute("session", session);
		
    	Cart cart = (Cart)session.getAttribute("cart");
    	
    	if (productId != null) {
			if (cart == null) {
				cart = new Cart();
			}
			Product product = new Product();
			String[] param = productId.split(":");
			product = new MySQLProductDAO().getProductById(Integer.parseInt(param[0]));
			Integer qnt = Integer.parseInt(param[1]);
			if (qnt > 0) {
				CartController.addProduct(cart, product, qnt);
			} else if (qnt < 0) {
				CartController.removeProduct(cart, product, qnt);
			}
			session.setAttribute("cart", cart);
			model.addAttribute("session", session);
			return "productsView";
		}
    	
    	
    	
		request.setAttribute("productToBuy", (List<Product>) session.getAttribute("cart"));
		return "cart";
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	protected String post(HttpServletRequest request, RequestAttribute requestAttribute, ModelMap model){
		
		if(request.getParameter("productToBuy")!=null) {
			long productId = Integer.parseInt(request.getParameter("productToBuy"));
			Product product = new MySQLProductDAO().getProductById(productId);
			HttpSession session = request.getSession();
			List<Product> products;
			if(session.getAttribute("cart")!=null) {		
				products = (List<Product>) session.getAttribute("cart");
			}else {
				products= new ArrayList<Product>();	
			}
			products.add(product);
			session.setAttribute("cart",products );
			System.out.println(products);
		}
		return "product";
	}

}
