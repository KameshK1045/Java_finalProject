package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDetails {
      String PhoneNo;
      String Password;
      String Role;
      String Name;
     
     public UserDetails() {}
	 UserDetails(String PhoneNo, String password, String role, String Name) {
		super();
		this.PhoneNo = PhoneNo;
		this.Password = password;
		this.Role = role;
		this.Name = Name;
	}
	 
	 
      
    public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String PhoneNo) {
		this.PhoneNo = PhoneNo;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public UserDetails loadTheDetails(String username,String password){
		UserDetails users = null;
		try {
			PreparedStatement pstmt = Database.dbConnection.prepareStatement("select * from UsersDetails where PhoneNumber = ?");
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("pass");
				if(rs.getString(2).equals(password)) {
                    String phone = rs.getString(1);
                    String passwor = rs.getString(2);
                    String roles = rs.getString(3);
                    String names = rs.getString(4);
					users = new UserDetails(phone,passwor,roles,names);
					System.out.println(users);
				}
				}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return users;
		}
		
		public String toString() {
			return "role :"+ Role;
		}
	}
	      

