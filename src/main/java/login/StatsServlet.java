package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import classes.Database;
import classes.Stats;

/**
 * Servlet implementation class StatsServlet
 */
@WebServlet("/StatsServlet")
public class StatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

     public void init(){
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
		String nos = request.getParameter("nos");
		System.out.println(nos);
		JSONObject jsonb = new JSONObject();
	    Stats stat = new Stats();
	    Stats sta2 = stat.getNames(nos);
	    if(sta2 != null) {
	    	jsonb.put("run", sta2.getRuns());
	    	jsonb.put("hs", sta2.getHs());
	    	jsonb.put("mat", sta2.getMatches());
	    }
	    else {
	    	jsonb.put("StatusCode", 400);
	    	jsonb.put("Message", "No Stats");
	    }
	    
	    response.getWriter().append(jsonb.toString());
	}

}
