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
import classes.MatchDetails;



@WebServlet("/Matchadded")
public class Matchadded extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Matchadded() {
        super();

    }
	public void init() {
		Database.getDBConnection();
	}
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JSONObject jsonObj = null;
		JSONObject jsonobj2 = new JSONObject();
		JSONParser parser = new JSONParser();
		BufferedReader br = request.getReader();
		String jsonIn = "";
		String str = "";
		while((str = br.readLine()) != null) {
			jsonIn += str;
		}
		System.out.println(jsonIn);
			try {
				jsonObj = (JSONObject) parser.parse(jsonIn);
				String matchName = (String) jsonObj.get("tName");
				String place = (String) jsonObj.get("place");
				String date = (String) jsonObj.get("date");
				MatchDetails match = new MatchDetails();
				match.setMatchName(matchName);
				match.setPlace(place);
				match.setDate(date);
				MatchDetails match1 = match.matchadd(match);
				if(match1 != null) {
				jsonobj2.put("StatusCode",200);
				jsonobj2.put("Message", "Succesfully Registered");
				}
				else {
					jsonobj2.put("StatusCode", 500);
					jsonobj2.put("Message", "Something went wrong");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			response.getWriter().append(jsonobj2.toString());
			


	}
}
