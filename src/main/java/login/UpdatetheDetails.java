package login;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import classes.Database;
import classes.SignUp;

/**
 * Servlet implementation class UpdatetheDetails
 */
@WebServlet("/UpdatetheDetails")
public class UpdatetheDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatetheDetails() {
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
		System.out.println("Entered");
		JSONObject jsonb = null;
		JSONObject jsonb2 = new JSONObject();
		JSONParser parser = new JSONParser();
		BufferedReader br = request.getReader();
		String str = "";
		String jsoninput = "";
		while((str = br.readLine()) != null) {
			jsoninput += str;
		}
		
		try {
			jsonb = (JSONObject) parser.parse(jsoninput);
			String phoneNo = (String) jsonb.get("no");
			String name = (String) jsonb.get("name");
			String state = (String) jsonb.get("state");
			String dob = (String) jsonb.get("date");
			SignUp signup = new SignUp();
			
			String success = signup.updateThePlayerDetails(phoneNo, name, state, dob);
			if(success.equals("success")) {
				jsonb2.put("StatusCode", 200);
				jsonb2.put("Message", "SuccessfullyUpdated");
			}
			else {
				jsonb2.put("StatusCode", 500);
				jsonb2.put("Message", "Something went wrong please contact System administrator");
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		response.getWriter().append(jsonb2.toString());
	}

}
