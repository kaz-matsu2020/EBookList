package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import model.Product;

// @WebFilter("/*")

public class IndicateProduct extends HttpServlet implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
		// データベースからproductをReadしてListに入れる
		List<Product> productList;
		
		// アプリケーションスコープにListを保存する
		ServletContext application = this.getServletContext();
		application.setAttribute("productList", productList);
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("user_id");
		if (userId != null) { 
			
		} else {
			
		}*/
		chain.doFilter(request, response);
	}
	public void destroy() {
		ServletContext application = this.getServletContext();
		application.removeAttribute("eBookList");
	}
}
