package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDetailDAO;
import model.Product;

@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		ProductDetailDAO readDetail = new ProductDetailDAO();
		Product productDetail = readDetail.ReadProductDetail(productId);
		
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("productDetail", productDetail);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
		dispatcher.forward(request, response);
	}
}
