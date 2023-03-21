package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Forgotpassword {
    UserDetails user;
    
    
    public void forgetPassword(String profileNumber, String newPassword, String confirmpassword) {
    	try {
			PreparedStatement pstmt = Database.dbConnection.prepareStatement("update UsersDetails set Password = ? where PhoneNumber = ?");
			pstmt.setString(1, profileNumber);
			pstmt.setString(2, confirmpassword);
			pstmt.setString(3, user.getRole());
			pstmt.setString(4, user.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
}
