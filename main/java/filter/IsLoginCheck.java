package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")

public class IsLoginCheck implements Filter{
	public void init(FilterConfig fConfig) throws ServletException { }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("user_id");
		if (userId != null) { 
			
		} else {
			
		}*/
		chain.doFilter(request, response);
	}
	public void destroy() { }
}