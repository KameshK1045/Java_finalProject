package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultMatch {
       String team1 ="";
       String team2 ="";
       String team1Players = "";
       String team2Players = "";
       String toss = "";
       int overs = 0;
       String team1Arrphone[] = new String[11];
       String team2Arrphone[] = new String[11];
       String team1Arrname[] = new String[11];
       String team2Arrname[] = new String[11];
       List<Scoreset>list = new ArrayList<>();
  
    public ResultMatch() {}     
	public ResultMatch(String team1, String team2, String toss,int over) {
		this.team1 = team1;
		this.team2 = team2;
		this.toss = toss;
		this.overs = over;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public String getToss() {
		return toss;
	}
	public void setToss(String toss) {
		this.toss = toss;
	}
	
	
	public void result(String batteam) {
		ResultMatch res = new ResultMatch();
		try {
			PreparedStatement pstmt = Database.dbConnection.prepareStatement("select * from Team");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(batteam)){
					team1Players += rs.getString(2); 
				}
				else {
					team2Players += rs.getString(2);
				}
			}
//			System.out.println(team1Players);
//			System.out.println(team2Players);
			team1Arrphone = team1Players.split(",");
			team2Arrphone = team2Players.split(",");
//			System.out.println(Arrays.toString(team1Arrphone));
//			System.out.println(Arrays.toString(team2Arrphone));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Scoreset> getPlayerName() {
		Scoreset sc = new Scoreset();
		try {
			PreparedStatement pstmt1 = Database.dbConnection.prepareStatement("select * from PlayerDetails");
			ResultSet rs1 = pstmt1.executeQuery();
				while(rs1.next()) {
					for(int i=0; i<team1Arrphone.length; i++) {
					if(rs1.getString(2).equals(team1Arrphone[i])) {
					team1Arrname[i] = rs1.getString(1);
					}
					else if(rs1.getString(2).equals(team2Arrphone[i])) {
						team2Arrname[i] = rs1.getString(1);
					}
				}
			}
//			System.out.println(Arrays.toString(team1Arrname));
//			System.out.println(Arrays.toString(team2Arrname));
		} catch (SQLException e) {
			e.printStackTrace();
		}
//	    System.out.println("1 :"+team1Arrname.length);
//	    System.out.println("2 :"+team2Arrname.length);
		List<Scoreset>list = sc.scoreset(team1Arrname,team2Arrname,overs);
	    sc.insertTheResult(team1,team2,toss);
	    
	    return list;
	}
	}
	
	