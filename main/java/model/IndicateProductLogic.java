package model;

import java.util.ArrayList;
import java.util.List;

import DAO.DistributorDAO;
import DAO.EvaluationCommentReadDAO;
import DAO.ProductDetailDAO;

/**
 * productDetail.jspにて表示するためのクラスで,重複のある処理をまとめたクラス
 * @author kazuo
 */

public class IndicateProductLogic {
	
	/**
	 * IndicateCommentメソッド
	 * @param productId 文字列
	 * @return 引数に対応したコメントをEvaluationCommentに格納したList型
	 */
	
	public List<EvaluationComment> IndicateComment(String productId) {
		// EvaluationCommentの取得
		List<EvaluationComment> commentList = new ArrayList<>();
		EvaluationCommentReadDAO readComment = new EvaluationCommentReadDAO();
		commentList = readComment.ReadCommentList(productId);
		return commentList;
	}
	
	/**
	 * IndicateDetailメソッド
	 * @param productId 文字列
	 * @return 引数に対応したProduct型
	 */
	
	public Product IndicateDetail(String productId) {
		// productIdからproductDetail取得
		ProductDetailDAO readDetail = new ProductDetailDAO();
		Product productDetail = readDetail.ReadProductDetail(productId);
		return productDetail;
	}
	
	/**
	 * IndicateDistributorName
	 * @param productId 文字列
	 * @return 引数に対応した販売業者名を格納した文字列
	 */
	
	public String IndicateDistributorName(String productId) {
		// productIdからdistributorIdを取得
		// distributorIdからdistributorNameを取得
		Product productDetail = this.IndicateDetail(productId);
		DistributorDAO readName = new DistributorDAO();
		String distributorName = readName.ReadDistributorName(productDetail.getDistributorId());
		return distributorName;
	}
}
