package login;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import classes.Database;
import classes.ResultMatch;
import classes.Scoreset;
import classes.SignUp;

/**
 * Servlet implementation class Result
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
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
		System.out.println("enter the result servlet");
		JSONObject jsonB = null;
		JSONObject jsonObjTeam = new JSONObject();
		JSONParser parser = new JSONParser();
		BufferedReader br = request.getReader();
		String jsonInput = "";
		String str = "";
		while((str = br.readLine()) != null) {
			jsonInput = jsonInput + str; 
		}
			try {
				jsonB = (JSONObject) parser.parse(jsonInput);
				String team1 = (String) jsonB.get("team1");
				String team2 = (String) jsonB.get("team2");
				String matchId  = (String) jsonB.get("matchid");
				String toss = (String) jsonB.get("toss");
				String over =  (String) jsonB.get("overs");
				System.out.println(jsonB.toString());
				ResultMatch res = new ResultMatch(team1,team2,toss,Integer.parseInt(over));
				res.result(team1);
				List<Scoreset>list = res.getPlayerName();
				JSONArray jsonarr = new JSONArray();
				for(int i=0; i<list.size(); i++) {
					JSONObject jsonb = new JSONObject();
					jsonb.put("playerName", list.get(i).getPlname());
					jsonb.put("playerScore", list.get(i).getScore());
					jsonarr.add(jsonb);
				}
				System.out.println(jsonarr.toString());
				response.getWriter().append(jsonarr.toString());
			} catch (ParseException e) {
				e.printStackTrace();
			}

            
	}

}
