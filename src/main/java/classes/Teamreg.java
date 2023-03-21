package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teamreg {
     
	String teamName;
	String Captain;
	String teamPlayers;
	List <Teamreg> teams = new ArrayList<Teamreg>();
	

	public Teamreg() {};
	public Teamreg(String teamName, String teamPlayers, String Captain) {
		this.teamName = teamName;
		this.teamPlayers = teamPlayers;
		this.Captain = Captain;
	}
	
	
	
	public String getTeamName() {
		return teamName;
	}



	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}



	public String getTeamPlayers() {
		return teamPlayers;
	}



	public void setTeamPlayers(String teamPlayers) {
		this.teamPlayers = teamPlayers;
	}

	public String getCaptain() {
		return Captain;
	}
	public void setCaptain(String captain) {
		Captain = captain;
	}

	public Teamreg databaseaddTeamPlayer(Teamreg te) {
		try {
			System.out.println("entered");
			System.out.println(te.getTeamName()+", "+te.getTeamPlayers()+", "+te.getCaptain());
			PreparedStatement pstmt = Database.dbConnection.prepareStatement("insert into Team values(?,?,?)");
			pstmt.setString(1, te.getTeamName());
			pstmt.setString(2, te.getTeamPlayers());
			pstmt.setString(3, te.getCaptain());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return te;
	}
	
	public List <Teamreg> showTheteamName() {
		System.out.println("entered the method");
		try {
			PreparedStatement pstmt1 = Database.dbConnection.prepareStatement("select * from Team");
			ResultSet rs = pstmt1.executeQuery();
			while(rs.next()) {
		    Teamreg team = new Teamreg();
			team.setTeamName(rs.getString(1));
			team.setTeamPlayers(rs.getString(2));
			team.setCaptain(rs.getString(3));
//			System.out.println(team);
			teams.add(team);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teams;
	}
	
	
	public String toString() {
		return "teamname : "+teamName + " Captain : "+Captain + " Team Players : "+teamPlayers;
	}
}
