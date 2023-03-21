package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.UUID;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import classes.Database;
import classes.UserDetails;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	Database.getDBConnection();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("Servlet entered");
		JSONObject jsonobj = new JSONObject();
		UserDetails user = (UserDetails) request.getAttribute("user");
		String role = user.getRole();
		jsonobj.put("StatusCode", 200);
		jsonobj.put("Message", "succesfully LoggedIn");
		jsonobj.put("Role", role);
		UUID uuid=UUID.randomUUID(); 
		response.addCookie(new Cookie("SESSIONID",""+uuid));
		response.addCookie(new Cookie("PHONE",""+user.getPhoneNo()));
		try {
		     	PreparedStatement pstmt1 = Database.dbConnection.prepareStatement("insert into Sessions values(?,?)");
				pstmt1.setString(1, String.valueOf(uuid));
				pstmt1.setString(2,user.getPhoneNo());
				pstmt1.executeUpdate();
			} catch (SQLException e) {
					e.printStackTrace();
			}
			response.getWriter().append(jsonobj.toString());
	}
		
	}
