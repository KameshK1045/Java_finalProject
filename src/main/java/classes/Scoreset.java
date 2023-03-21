package classes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Scoreset {

	String plname = "";
	String winner = "";
	String runner = "";
    int score = 0;
    int total1 = 0;
    int total2 = 0;
    int k = 0;
    Map<String,Scoreset> map = new HashMap<String,Scoreset>();
    Map<String,Scoreset> map2 = new HashMap<String,Scoreset>();
    List<Scoreset>list = new ArrayList<>();
    
	public Scoreset(){};
    public Scoreset(String plname, int score) {
		this.plname = plname;
		this.score = score;
	}
    
    
	public String getPlname() {
		return plname;
	}


	public void setPlname(String plname) {
		this.plname = plname;
	}
    
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTotal1() {
		return total1;
	}
	public void setTotal1(int total1) {
		this.total1 = total1;
	}
	public int getTotal2() {
		return total2;
	}
	public void setTotal2(int total2) {
		this.total2 = total2;
	}
    
    public List<Scoreset> scoreset(String arr[],String arr2[], int overs) {
    	Stats stat = new Stats();
    	System.out.println("enter the scoreset");
    	k += 1;
		for(int i=0; i<overs; i++) {
			score = (int) Math.floor(Math.random()*30);
			Scoreset sc = new Scoreset(arr[i],score);
			System.out.println(score+","+score+","+k+","+arr[i]);
			stat.updateTheRuns(score,score,k,arr[i]);
			total1 += score;
			map.put(arr[i],sc);
		}
		for(int j=0; j<overs; j++) {
			score = (int) Math.floor(Math.random()*30);
			Scoreset sc = new Scoreset(arr2[j],score);
			System.out.println(score+","+score+","+k+","+arr2[j]);
			stat.updateTheRuns(score,score,k,arr2[j]);
			total2 += score;
			map2.put(arr2[j], sc);
		}
		for(Entry<String, Scoreset> m:map.entrySet()) {
			System.out.println(m.getKey()+","+m.getValue());
			list.add(m.getValue());
		}
		for(Entry<String, Scoreset> n:map2.entrySet()) {
			System.out.println(n.getKey()+","+n.getValue());
			list.add(n.getValue());
		}
		System.out.println(total1+","+total2);
		System.out.println("end of the score set");
		return list;
	}
	
	public void insertTheResult(String team1, String team2, String toss) {
		if(total1>total2) {
			winner = team1;
			runner = team2;
		}
		else{
			winner = team2;
			runner = team1;
		}
		try {
			PreparedStatement pstmt2 = Database.dbConnection.prepareStatement("insert into Result values(?,?,?,?,?)");
			pstmt2.setString(1, winner);
			pstmt2.setString(2, runner);
			pstmt2.setString(3, toss);
			pstmt2.setInt(4, (Math.max(total1, total2)));
			pstmt2.setInt(5, Math.min(total1, total2));
			pstmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return "score : "+score;
	}
}


