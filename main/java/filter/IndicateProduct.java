package filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import DAO.ProductListReadDAO;
import model.Product;

// アプリケーション起動時に書籍一覧を取得するためのクラス
// List<Product>型をアプリケーションスコープに保存する
// データ取得はProductListReadDAOクラスのメソッドを使用する
// 使用するメソッドは戻り値がList<Product>型のReadProductList()を使用

@WebFilter("/*")

public class IndicateProduct implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
		// データベースからproductをReadしてListに入れる
		List<Product> productList = new ArrayList<>();
		ProductListReadDAO readList = new ProductListReadDAO();
		productList = readList.ReadProductList();
		
		// アプリケーションスコープにListを保存する
		ServletContext application = fConfig.getServletContext();
		application.setAttribute("productList", productList);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
	}
	
	public void destroy() {	}
}
