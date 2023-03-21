package login;

import java.io.IOException;

//import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import classes.Database;
import classes.SignUp;


/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Signup() {
        super();
    }
    public void init() {
    	Database.getDBConnection();
    }
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
        System.out.println("Signup servlet entered");
		JSONObject jsonObjSignUp = new JSONObject();
		SignUp signup = (SignUp) request.getAttribute("NewPlayer");
		String pass = signup.getPlayerName().substring(0,5)+signup.getPhoneNo().substring(4,6)+"@";
		jsonObjSignUp.put("StatusCode", 200);
		jsonObjSignUp.put("Message", "succesfully Registered");
		jsonObjSignUp.put("password",pass);
		
		response.getWriter().append(jsonObjSignUp.toString());
	}

}
