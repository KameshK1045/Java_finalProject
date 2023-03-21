package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamNameWithPlayer {
	
	String teamName = "";
	String PlayerName = "";
	String PlayerNameArr = "";
	String PlayerNoArr[] = new String[11];
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getPlayerName() {
		return PlayerName;
	}
	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	
	public String getTeam(String teamName) {
		System.out.println(teamName+",");
		System.out.println("enter");
		try {
			PreparedStatement pstmt = Database.dbConnection.prepareStatement("select * from Team where TeamName = ?");
			pstmt.setString(1, teamName);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
			    PlayerName += rs.getString(2);
			}

			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String pls = getTeamPlayers(PlayerName);
		return pls;
	}
	
	public String getTeamPlayers(String pl) {
		System.out.println("enters");
		PlayerNoArr = pl.split(",");
		try {
			for(int i=0; i<PlayerNoArr.length; i++) {
				PreparedStatement pstm = Database.dbConnection.prepareStatement("select * from PlayerDetails where PhoneNo = ? ");
				pstm.setString(1, PlayerNoArr[i]);
				ResultSet rs = pstm.executeQuery();

				if (rs.next()) {
				    PlayerNameArr += rs.getString(1)+",";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    return PlayerNameArr;
}
}

