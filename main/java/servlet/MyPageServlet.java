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
import javax.servlet.http.HttpSession;

import DAO.ProductDetailDAO;
import model.Product;
import model.Property;
import model.User;

@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// UserとList<Property>,List<Product>を生成
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<Property> propertyList = (List<Property>)session.getAttribute("propertyList");
		List<Product> myProductList = new ArrayList<>();
		
		// PropertyListからproductIdを取得してproductDeatilを取得しList<Product>に追加
		ProductDetailDAO readProduct = new ProductDetailDAO();
		for(Property property : propertyList) {
			Product product = readProduct.ReadProductDetail(property.getProductId());
			myProductList.add(product);
		}
		session.setAttribute("myProductList", myProductList);
		
		// ログインが確認できればmyPageにフォワード
		if(user != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPage.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
