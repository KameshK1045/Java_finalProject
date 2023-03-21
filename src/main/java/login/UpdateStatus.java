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

import classes.SignUp;

/**
 * Servlet implementation class UpdateStatus
 */
@WebServlet("/UpdateStatus")
public class UpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStatus() {
        super();
        // TODO Auto-generated constructor stub
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        System.out.println("E");
		JSONObject jsonb = null;
		JSONObject jsonb2 = new JSONObject();
		JSONParser parser = new JSONParser();
		BufferedReader br = request.getReader();
		String str = "";
		String jsonInput = "";
		while((str = br.readLine()) != null) {
			jsonInput += str;
		}
		
		try {
			jsonb = (JSONObject) parser.parse(jsonInput);
			String team1 = (String) jsonb.get("team1");
			String team2 = (String) jsonb.get("team2");
			SignUp signup = new SignUp();
            System.out.println(team1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
