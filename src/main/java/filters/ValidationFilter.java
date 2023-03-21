package filters;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import classes.SignUp;

/**
 * Servlet Filter implementation class ValidatonFilter
 */
public class ValidationFilter extends HttpFilter implements Filter {
       
    private static final long serialVersionUID = 1L;

	/**
     * @see HttpFilter#HttpFilter()
     */
    public ValidationFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Validationfilter entered");
		JSONObject jsonB = null;
		JSONObject jsonObjSignUp = new JSONObject();
		JSONParser parser = new JSONParser();
		BufferedReader br = request.getReader();
		String jsonInput = "";
		String str = "";
		while((str = br.readLine()) != null) {
			jsonInput = jsonInput + str; 
		}
		try {
			jsonB = (JSONObject) parser.parse(jsonInput);
			String plName = (String) jsonB.get("name");
			String phoneNo = (String) jsonB.get("no");
			String state = (String) jsonB.get("state");
			String date = (String) jsonB.get("date");
			String role = (String) jsonB.get("role");
			SignUp signup = new SignUp(plName,phoneNo,state,date,role);
			SignUp signUpobj = signup.addTheDetails(signup);
			if(signUpobj != null ) {
				request.setAttribute("NewPlayer", signup);
				chain.doFilter(request, response);
				System.out.println("Validation Filter finished");
			}
			else {
				jsonObjSignUp.put("StatusCode", 500);
				jsonObjSignUp.put("Message", "Player already exits");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
