package model;

import java.util.ArrayList;
import java.util.List;

import DAO.DistributorDAO;
import DAO.EvaluationCommentReadDAO;
import DAO.ProductDetailDAO;

// productDetail.jspにて表示するためのクラスで,コントローラーで重複のある処理をまとめたクラス
// メソッドは3つ。コメントを取得、商品概要を取得、販売業者名を取得。いずれも引数String productId。
// 1.コメント取得のメソッド:戻り値List<EvaluationComment>型のIndicateComment(String productId)
// 2.商品概要取得のメソッド:戻り値Product型のIndicateDetail(String productId)
// 3.販売業者名取得のメソッド:戻り値String型のInidicateDistributorName(String productId)
// CommentDetailServlet,CommentPostServlet,ProductDetailServletにて使用

public class IndicateProductLogic {
	public List<EvaluationComment> IndicateComment(String productId) {
		// EvaluationCommentの取得
		List<EvaluationComment> commentList = new ArrayList<>();
		EvaluationCommentReadDAO readComment = new EvaluationCommentReadDAO();
		commentList = readComment.ReadCommentList(productId);
		return commentList;
	}
	
	public Product IndicateDetail(String productId) {
		// productIdからproductDetail取得
		ProductDetailDAO readDetail = new ProductDetailDAO();
		Product productDetail = readDetail.ReadProductDetail(productId);
		return productDetail;
	}
	
	public String IndicateDistributorName(String productId) {
		// productIdからdistributorIdを取得
		// distributorIdからdistributorNameを取得
		Product productDetail = this.IndicateDetail(productId);
		DistributorDAO readName = new DistributorDAO();
		String distributorName = readName.ReadDistributorName(productDetail.getDistributorId());
		return distributorName;
	}
}
