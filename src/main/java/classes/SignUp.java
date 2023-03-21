package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SignUp {
      String PlayerName;
      String PhoneNo;
      String State;
      String DOB;
      String Role;
      String Status;
  

	String teamArr[] = new String[11];
	String teamArr2[] = new String[11]; 
	  Map<String,SignUp> map1 = new HashMap<String,SignUp>();
      List<SignUp>list = new ArrayList<SignUp>();

        
        public SignUp(){}
	    public SignUp(String playerName, String phoneNo, String state, String dOB, String role) {
		PlayerName = playerName;
		PhoneNo = phoneNo;
		State = state;
		DOB = dOB;
		Role = role;

	}
	    
		public String getPlayerName() {
			return PlayerName;
		}
		public void setPlayerName(String playerName) {
			PlayerName = playerName;
		}
		public String getPhoneNo() {
			return PhoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			PhoneNo = phoneNo;
		}
		public String getState() {
			return State;
		}
		public void setState(String state) {
			State = state;
		}
		public String getDOB() {
			return DOB;
		}
		public void setDOB(String dOB) {
			DOB = dOB;
		}
		public String getRole() {
			return Role;
		}
		public void setRole(String role) {
			Role = role;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		
	    public SignUp addTheDetails(SignUp signup) {
	    	//Database.getDBConnection();
	    	try {
	    	System.out.println("Called");
	    	PreparedStatement pstmt = Database.dbConnection.prepareStatement("insert into PlayerDetails values(?,?,?,?,?,?)");
			pstmt.setString(1, signup.getPlayerName());
			pstmt.setString(2, signup.getPhoneNo());
			pstmt.setString(3, signup.getState());
			pstmt.setString(4, signup.getDOB());
			pstmt.setString(5, signup.getRole());
			pstmt.setString(6, "Available");
			pstmt.executeUpdate();
			
			String pass = signup.getPlayerName().substring(0,5)+signup.getPhoneNo().substring(4,6)+"@";
			PreparedStatement pstmt1 = Database.dbConnection.prepareStatement("insert into UsersDetails values(?,?,?,?)");
			pstmt1.setString(1,signup.getPhoneNo());
			pstmt1.setString(2, pass);
			pstmt1.setString(3, "PLAYER");
			pstmt1.setString(4, signup.getPlayerName());
			pstmt1.executeUpdate();
			
			PreparedStatement pstmt2 = Database.dbConnection.prepareStatement("insert into Stats values(?,?,?,?)");
			pstmt2.setInt(1,0);
			pstmt2.setInt(2, 0);
			pstmt2.setInt(3,0);
			pstmt2.setString(4, signup.getPlayerName());
			pstmt2.executeUpdate();
	    	}
	    	catch(SQLException ex) {
	    		System.out.println("Something went wrong");
	    		return null;
	    	}
	    	return signup;
	    }
	    
	    public static Map<String,SignUp> showTheDetails(){
	    	SignUp s = new SignUp();
			try {
				PreparedStatement pstmt1 = Database.dbConnection.prepareStatement("select * from PlayerDetails");
				
				ResultSet rs1 = pstmt1.executeQuery();
				while(rs1.next()) {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs1.getString(4));
					SignUp signup = new SignUp();
					signup.setPlayerName(rs1.getString(1));
					signup.setPhoneNo(rs1.getString(2));
					signup.setState(rs1.getString(3));
					signup.setDOB(new SimpleDateFormat("dd-MM-yyyy").format(date));
					signup.setRole(rs1.getString(5));
					signup.setStatus(rs1.getString(6));
					s.map1.put(signup.getPlayerName(),signup);
				}
			} catch (SQLException | ParseException e) {
				e.printStackTrace();
			}
			return s.map1;
	}
	    
	    public List<SignUp> splitTheValue() {
			Set<Entry<String,SignUp>> set = showTheDetails().entrySet();
			Iterator<Entry<String,SignUp>> itr = set.iterator();
			while(itr.hasNext()) {
				Entry<String,SignUp> key = itr.next();
				list.add(key.getValue());	
			}
			return list;
		}
      
	    public void updateTheStatus(String teamPlayers) {
	    	teamArr = teamPlayers.split(",");
			try {
				for(int i=0; i<teamArr.length; i++) {
				PreparedStatement pstm = Database.dbConnection.prepareStatement("update PlayerDetails set Status = ? where PhoneNo = ?");
				pstm.setString(1, "Unavailable");
				pstm.setString(2, teamArr[i]);
				pstm.executeUpdate();
				}
				} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	   
	    
	    public String updateThePlayerDetails(String phoneNo,String playerName,String state, String dOB) {
	    	try {
				PreparedStatement pst = Database.dbConnection.prepareStatement("update PlayerDetails set PlayerName = ?,State = ?,DOB = ? where PhoneNo = ?");
				pst.setString(1, playerName);
				pst.setString(2, state);
				pst.setString(3, dOB);
				pst.setString(4, phoneNo);
				pst.executeUpdate();
				return "success";
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	
	    	return null;
	    }
	    
}
