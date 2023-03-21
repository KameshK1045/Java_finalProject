package login;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import classes.Database;
import classes.MatchDetails;
import classes.Teamreg;

/**
 * Servlet implementation class ShowteamServlet
 */
@WebServlet("/ShowteamServlet")
public class ShowteamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowteamServlet() {
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
//		doGet(request, response);
		
		JSONArray jsonArr = new JSONArray();
		Teamreg team = new Teamreg();
		List<Teamreg>teams = team.showTheteamName();
		MatchDetails match = new MatchDetails();
		List<MatchDetails>matches = match.showThematch();
		System.out.println(teams.size());
		for(int i=0; i<teams.size(); i++) {
		JSONObject jsonobj = new JSONObject();	
		jsonobj.put("teamName", teams.get(i).getTeamName());
		jsonobj.put("teamPlayers", teams.get(i).getTeamPlayers());
		jsonobj.put("teamCaptain", teams.get(i).getCaptain());
		jsonArr.add(jsonobj);
		}
		for(int j=0; j<matches.size(); j++) {
			JSONObject jsonobj2 = new JSONObject();
			jsonobj2.put("matchName",matches.get(j).getMatchName());
			jsonArr.add(jsonobj2);
		}
		System.out.println(jsonArr.toString());
		response.getWriter().append(jsonArr.toString());
	}

}
