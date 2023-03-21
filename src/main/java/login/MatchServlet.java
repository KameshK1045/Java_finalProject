package login;

import java.io.IOException;
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

/**
 * Servlet implementation class MatchServlet
 */
@WebServlet("/MatchServlet")
public class MatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	Database.getDBConnection();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MatchDetails matches = new MatchDetails();
		List<MatchDetails>match = matches.showThematch();
		JSONArray jsonArr = new JSONArray();
		for(int i=0; i<match.size(); i++) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("matchId", match.get(i).getMatchId());
			jsonObj.put("matchName", match.get(i).getMatchName());
			jsonObj.put("place", match.get(i).getPlace());
			jsonObj.put("date", match.get(i).getDate());
			jsonArr.add(jsonObj);
		}
		response.getWriter().append(jsonArr.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		doGet(request, response);
//	}

}
