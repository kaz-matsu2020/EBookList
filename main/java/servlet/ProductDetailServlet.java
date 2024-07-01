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
import model.User;

/**
 * eBookList.jspからGETリクエストを受けて商品の詳細(商品詳細、販売業者、商品についてるコメント)を表示するためのコントローラー
 * @author kazuo
 */

@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータから 文字列 productIdを取得
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		// myProductListから所有物かどうか判定
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		boolean mine = false;
		if(user != null) {
			List<Product> myProductList = (List<Product>)session.getAttribute("myProductList");
			for(Product my : myProductList) {
				if(my.getProductId().equals(productId)) { mine = true; }
			}
		}
		session.setAttribute("mine", mine);
		// productIdを引数にして商品詳細,販売業者名,コメントを取得
		// IndicateProductLogicのメソッドを使用する
		IndicateProductLogic ipl = new IndicateProductLogic();
		Product productDetail = ipl.IndicateDetail(productId);
		String distributorName = ipl.IndicateDistributorName(productId);
		List<EvaluationComment> commentList = ipl.IndicateComment(productId);
		// セッションスコープにProduct型、文字列 ditributorName,List<EvaluationComment>型を保存
		session.setAttribute("productDetail", productDetail);
		session.setAttribute("distributorName", distributorName);
		session.setAttribute("commentList", commentList);
		
		// productDetail.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
		dispatcher.forward(request, response);
	}
}
