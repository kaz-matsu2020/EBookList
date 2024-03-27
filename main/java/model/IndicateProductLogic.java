package model;

import java.util.ArrayList;
import java.util.List;

import DAO.DistributorDAO;
import DAO.EvaluationCommentReadDAO;
import DAO.ProductDetailDAO;

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
		// distributorIdからdistributorNameを取得
		Product productDetail = this.IndicateDetail(productId);
		DistributorDAO readName = new DistributorDAO();
		String distributorName = readName.ReadDistributorName(productDetail.getDistributorId());
		return distributorName;
	}
}
