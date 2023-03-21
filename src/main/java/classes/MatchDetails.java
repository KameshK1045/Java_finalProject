package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatchDetails {
	int matchId;
	String matchName;
	String place;
	String date;
	List<MatchDetails>matches = new ArrayList<MatchDetails>();
	
	public MatchDetails() {}
	public MatchDetails(int matchId, String matchName, String place, String date) {
		super();
		this.matchId = matchId;
		this.matchName = matchName;
		this.place = place;
		this.date = date;
	}


	public int getMatchId() {
		return matchId;
	}


	public void setMatchId(int matchId2) {
		this.matchId = matchId2;
	}


	public String getMatchName() {
		return matchName;
	}


	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	public MatchDetails matchadd(MatchDetails match) {
		
		try {
			System.out.println("entered");
			PreparedStatement pstmt = Database.dbConnection.prepareStatement("insert into MatchDetails (TounamentName,Place,Date) values(?,?,?)");
			pstmt.setString(1, match.getMatchName());
			pstmt.setString(2, match.getPlace());
			pstmt.setString(3, match.getDate());
			pstmt.executeUpdate();
			return match;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<MatchDetails> showThematch(){
		try {
			PreparedStatement pstmt1 = Database.dbConnection.prepareStatement("select * from MatchDetails");
			ResultSet rs1 = pstmt1.executeQuery();
			while(rs1.next()) {
				Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs1.getString(4));
				MatchDetails mat = new MatchDetails();
				mat.setMatchId(Integer.parseInt(rs1.getString(1)));
				mat.setMatchName(rs1.getString(2));
				mat.setPlace(rs1.getString(3));
				mat.setDate(new SimpleDateFormat("dd-MM-yyyy").format(date));
				matches.add(mat);
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		return matches;
	}
	
	public String toString() {
		return "matchId : "+matchId +"matchname : "+matchName;
	}
	
}
