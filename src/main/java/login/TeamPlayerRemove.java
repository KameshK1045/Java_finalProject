package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import classes.TeamNameWithPlayer;

/**
 * Servlet implementation class TeamPlayerRemove
 */
@WebServlet("/TeamPlayerRemove")
public class TeamPlayerRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamPlayerRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	@SuppressWarnings("unchecked")
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	    
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String teamName = request.getParameter("teamname");
	    System.out.println(teamName);
	    JSONObject json = new JSONObject();
	    TeamNameWithPlayer teams = new TeamNameWithPlayer();
	    String teamPlayers = teams.getTeam(teamName);
	    if(teamPlayers != "") {
	    	json.put("TeamPlayers", teamPlayers.substring(0,teamPlayers.length()-1));
	    }
	    else {
	    	json.put("StatusCode", 400);
	    	json.put("Message", "Succesfully Updated");
	    }
	    System.out.println(json.toString());
	    response.getWriter().append(json.toString());
	}

}
