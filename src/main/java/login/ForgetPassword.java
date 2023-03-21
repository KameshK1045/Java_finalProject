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

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import classes.Forgotpassword;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("entered forget password");
		JSONObject jsonObj = null;
		JSONObject jsonObj2 = new JSONObject();
		JSONParser parser = new JSONParser();
		BufferedReader br = request.getReader();
		String str = "";
		String jsonIn = "";
		while((str = br.readLine())!=null) {
			jsonIn += str;
		}
		System.out.println(jsonIn);
		
		try {
			jsonObj = (JSONObject) parser.parse(jsonIn);
			String profileNumber = (String) jsonObj.get("profileNumber");
			String newPassword = (String) jsonObj.get("newPassword");
			String confirmpassword = (String) jsonObj.get("confirmpassword");
			Forgotpassword forget = new Forgotpassword();
			forget.forgetPassword(profileNumber,newPassword,confirmpassword);
			jsonObj2.put("Statuscode", 200);
			jsonObj2.put("Message", "Success");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		response.getWriter().append(jsonObj2.toString());
	}

}
