package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import classes.UserDetails;


//@WebFilter("/LoginServlet")
public class AuthorizationFilter extends HttpFilter implements Filter {
       
    private static final long serialVersionUID = 1L;

    public AuthorizationFilter() {
        super();
    }

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("authorization filter entered");
		UserDetails users = (UserDetails) request.getAttribute("LoggedInUser");
		request.setAttribute("user", users);
		System.out.println(users);
		System.out.println("authorization filter finished");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
	
}
