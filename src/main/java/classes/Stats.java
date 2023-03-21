package classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Stats {
    
	String name;
	int matches;
	int runs;
	int hs;
	
	public Stats() {};
	public Stats(int runs, int hs,int matches,String name) {
		this.name = name;
		this.matches = matches;
		this.runs = runs;
		this.hs = hs;
	}
	public int getMatches() {
		return matches;
	}
	public void setMatches(int matches) {
		this.matches = matches;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getHs() {
		return hs;
	}
	public void setHs(int hs) {
		this.hs = hs;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Stats getNames(String no) {
		System.out.println("enter");
		Stats stat2 = null;
		String findname = "";
		try {
			PreparedStatement ps = Database.dbConnection.prepareStatement("select * from PlayerDetails where PhoneNo = ?");
			ps.setString(1,no);
			ResultSet r = ps.executeQuery();
			if(r.next()) {
			 findname += r.getString(1);
			}
			Stats stat = new Stats();
			stat2 = stat.getTheStats(findname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(findname);
		System.out.println(stat2);
		return stat2;
	}
	
	public void updateTheRuns(int runs,int hs,int k, String name) {
		System.out.println("Enter");
		System.out.println(runs+","+hs+","+k+","+name);
		PreparedStatement pss;
		try {
			pss = Database.dbConnection.prepareStatement("select * from Stats where Player_Name = ?");
			pss.setString(1, name);
			ResultSet rss = pss.executeQuery();
			if(rss.next()) {
			    int hsss = rss.getInt(2);
			    if(hsss < hs) {
			        PreparedStatement psm = Database.dbConnection.prepareStatement("update Stats set Highest_Score = ? where Player_Name = ?");
			        psm.setInt(1, hs);
			        psm.setString(2, name);
			        psm.executeUpdate();
			    }
			    PreparedStatement pstmt = Database.dbConnection.prepareStatement("update Stats set Runs = ?, Matches = ? where Player_Name = ?");
			    pstmt.setInt(1, rss.getInt(1) + runs);
			    pstmt.setInt(2, rss.getInt(2)+k);
			    pstmt.setString(3, name);
			    pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
} 

    public Stats getTheStats(String names) {
    	System.out.println("enter2");
    	Stats stat3 = null;
    	try {
			PreparedStatement pstm = Database.dbConnection.prepareStatement("select * from Stats");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
		    if(rs.getString(4).equals(names))
			stat3 = new Stats(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	System.out.println(stat3);
    	return stat3;
    }
}
