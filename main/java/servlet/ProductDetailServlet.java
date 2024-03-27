package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EvaluationComment;
import model.IndicateProductLogic;
import model.Product;

@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータからproductIdを取得
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		
		// セッションにproductDetail、productName、EvaluationCommentを保存
		IndicateProductLogic ipl = new IndicateProductLogic();
		Product productDetail = ipl.IndicateDetail(productId);
		String distributorName = ipl.IndicateDistributorName(productId);
		List<EvaluationComment> commentList = ipl.IndicateComment(productId);
		HttpSession session = request.getSession();
		session.setAttribute("productDetail", productDetail);
		session.setAttribute("distributorName", distributorName);
		session.setAttribute("commentList", commentList);
		
		// productDetail.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
		dispatcher.forward(request, response);
	}
}
