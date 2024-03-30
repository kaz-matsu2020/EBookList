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

// eBookList.jspからGETリクエストを受けて商品の詳細(商品詳細、販売業者、商品についてるコメント)を表示するためのコントローラー

// 処理内容
// IndicateProductLogicクラス(modelパッケージ)のメソッドを3つ使って商品詳細、販売業者、コメントを取得する
// 3つのメソッド全ての引数がString 商品IDとなっている
// 商品IDはリクエストパラメータから取得する
// 商品詳細を取得するメソッドは戻り値がProduct型のIndicateDetail(String 商品ID)を使用
// 販売業者を取得するメソッドは戻り値がString型のIndicateDistributorName(String 商品ID)を使用
// コメントを取得するメソッドは戻り値がList<EvaluationCommnet>型のIndicateComment(String 商品ID)を使用
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
