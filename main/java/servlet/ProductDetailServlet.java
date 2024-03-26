package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DistributorDAO;
import DAO.EvaluationCommentReadDAO;
import DAO.ProductDetailDAO;
import model.EvaluationComment;
import model.Product;

@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータからproductIdを取得
		// productIdに対応したデータをデータベースから取得
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		ProductDetailDAO readDetail = new ProductDetailDAO();
		Product productDetail = readDetail.ReadProductDetail(productId);
		
		// distributorIdからdistributorNameを取得
		DistributorDAO readName = new DistributorDAO();
		String distributorName = readName.ReadDistributorName(productDetail.getDistributorId());
		
		// EvaluationCommentの取得
		List<EvaluationComment> commentList = new ArrayList<>();
		EvaluationCommentReadDAO readComment = new EvaluationCommentReadDAO();
		commentList = readComment.ReadCommentList(productId);
		
		// リクエストパラメータにproductDetail、productName、EvaluationCommentを保存
		request.setCharacterEncoding("UTF-8");
		request.setAttribute("productDetail", productDetail);
		request.setAttribute("distributorName", distributorName);
		request.setAttribute("commentList", commentList);
		
		// productDetail.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
		dispatcher.forward(request, response);
	}
}
