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

// eBookList.jspからリクエストを受けて商品の詳細(商品詳細、販売業者、商品についてるコメント)を表示するためのコントローラー
// String productIdをリクエストパラメータから取得
// IndicateProductLogicクラス(modelパッケージ)のメソッドを3つ使う。3つとも引数はString productId
// 1.Product型のインスタンスを生成。戻り値がProduct型のメソッドIndicateDetail(String productId)を使用
// 2.String distributorNameを取得。戻り値がString型のメソッドIndicateDistributorName(String productId)を使用
// 3.List<EvaluationCommen>を取得。戻り値がList<EvaluationCommnet>型のメソッドIndicateComment(String productId)を使用
// 上記3つをセッションスコープに保存してproductDetail.jspにフォワードする

@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータからproductIdを取得
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		
		// セッションスコープにproductDetail、distributorName、EvaluationCommentを保存
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
