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
import classes.Teamreg;

/**
 * Servlet implementation class TeamServlet
 */
@WebServlet("/TeamServlet")
public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		JSONObject jsonB = null;
		JSONObject jsonTeam = new JSONObject();
		JSONParser teamParser = new JSONParser();
		BufferedReader br = request.getReader();
		String jsonInputs = "";
		String str1 = "";
		while((str1 = br.readLine()) != null) {
			jsonInputs = jsonInputs + str1; 
		}
		
			try {
				jsonB = (JSONObject) teamParser.parse(jsonInputs);
				String teamName = (String) jsonB.get("teamName");
				String Captain = (String) jsonB.get("captain");
				String teamPlayers = (String) jsonB.get("players");
//				System.out.println(Captain);
				Teamreg teamreg = new Teamreg();
				SignUp sign = new SignUp();
				teamreg.setTeamName(teamName);
				teamreg.setCaptain(Captain);
				teamreg.setTeamPlayers(teamPlayers);
				teamreg.databaseaddTeamPlayer(teamreg);
				sign.updateTheStatus(teamPlayers);
				jsonTeam.put("StatusCode", 200);
				jsonTeam.put("Message", "Successfully Added");
//				System.out.println(teamreg);
			} catch (ParseException e) {
				jsonTeam.put("StatusCode", 400);
				jsonTeam.put("Message", "Something went wrong");
				e.printStackTrace();
			}
			
			response.getWriter().append(jsonTeam.toString());
			
	}

}
