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
import classes.SignUp;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
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
		// TODO Auto-generated method stub
		SignUp signup = new SignUp();
		List<SignUp> list = signup.splitTheValue();
		JSONArray jsonArr = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("PlName", list.get(i).getPlayerName());
			jsonObj.put("PlNo", list.get(i).getPhoneNo());
			jsonObj.put("PLState",list.get(i).getState());
			jsonObj.put("PLDob", list.get(i).getDOB());
			jsonObj.put("PlRole", list.get(i).getRole());
			jsonObj.put("plStatus", list.get(i).getStatus());
			jsonArr.add(jsonObj);
		}
		System.out.println(jsonArr.toString());
		response.getWriter().append(jsonArr.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
