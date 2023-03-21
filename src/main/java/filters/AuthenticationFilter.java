package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

import org.json.simple.JSONObject;
import classes.UserDetails;

//@WebFilter("/LoginServlet")
public class AuthenticationFilter extends HttpFilter implements Filter {
       
    private static final long serialVersionUID = 1L;


    public AuthenticationFilter() {
        super();
    }

	public void destroy() {
	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("authentication filter entered");
		JSONObject jsonObj = new JSONObject(); 
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		System.out.println(name+"&"+pass);
		String responseText = "";
		
	   UserDetails loggedInUser = new UserDetails();
	   UserDetails user = loggedInUser.loadTheDetails(name, pass);
	   System.out.println(loggedInUser);
	   if(user!=null) {
			responseText = "Welcome, "+name+" !!";
			request.setAttribute("LoggedInUser", user);
			chain.doFilter(request, response);
			
		}else {
			responseText = "Password Incorrect!!";
			jsonObj.put("StatusCode", 400);
			jsonObj.put("Message","Password Incorrect!!");
			response.getWriter().append(jsonObj.toString());
		}
		System.out.println(responseText);
		System.out.println("authentication filter finished");
	}

	


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
