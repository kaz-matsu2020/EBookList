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

@WebServlet("/ProductDatailServlet")
public class ProductDateailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータからproductIdを取得
		// productIdに対応したデータをデータベースから取得
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		ProductDetailDAO readDetail = new ProductDetailDAO();
		Product productDetail = readDetail.ReadProductDetail(productId);
		
		// distributorIdからdistributorNameを取得
		
		
		// リクエストパラメータにproductDetailを保存
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("productDetail", productDetail);
		
		// productDetail.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
		dispatcher.forward(request, response);
	}
}
