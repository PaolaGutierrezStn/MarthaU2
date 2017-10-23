package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.ProductDOM;
import model.Product;



/**
 * Servlet implementation class ProductController
 */
@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Product product;
	private List<Product> products;
	private ProductDOM productDOM;
	private List<String> ids = new ArrayList<String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        product = new Product();
        products = new ArrayList<Product>();
        productDOM = new ProductDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
			product.setName(request.getParameter("name"));
			
			
try {
				
				product.setUnitInStock(Integer.parseInt(request.getParameter("units")));
			}catch(NumberFormatException e) {
				product.setUnitInStock(10);
			}

try {
	
	product.setUnitPrice(Integer.parseInt(request.getParameter("price")));
}catch(NumberFormatException e) {
	product.setUnitInStock(10);
	

}
product.setType(request.getParameter("type"));


			if(product.getId()=="") {
				int id = 1;
				String newId= "PRD"+String.format("%05d", 1);
				product.setId(newId);;
				
				if (products.size()>0) {
					ids.clear();
					for (Product p: products) {
						ids.add(p.getId());
					}
					for (int i=0; i<= ids.size(); i++){
						newId= "PRD"+ String.format("%05d", i+1);
						
						if (! ids.contains(newId)) {
						product.setId(newId);
						break;
						}
					}
				}
				productDOM.add(product);
			}else {
				productDOM.update(product);
			}

			products = productDOM.getProduct();
			request.setAttribute("products", products);
			request.getRequestDispatcher("products_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			product = new Product();
			request.getRequestDispatcher("products_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				String id = request.getParameter("id");
				product = productDOM.findById(id);
				
			}catch (Exception e) {
				
				product = new Product();
			}
			request.setAttribute("product", product);
			
			request.getRequestDispatcher("products_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			String id = request.getParameter("id");
			productDOM.delete(id);
			products= productDOM.getProduct();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("products", products);
			request.getRequestDispatcher("products_list.jsp").forward(request, response);
		}else {
			products = productDOM.getProduct();
			request.setAttribute("products", products);
			request.getRequestDispatcher("products_list.jsp").forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
