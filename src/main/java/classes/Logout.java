package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Logout {
	String phoneNumber;
	
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public void sessionCleared(String phoneNumber) {
		Logout log = new Logout();
		try {
			PreparedStatement pstmt = Database.dbConnection.prepareStatement("delete from Sessions where UserName = ?");
			System.out.println("enter");
			pstmt.setString(1, phoneNumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
