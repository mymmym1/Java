import java.util.*;
import java.io.*;

public class Stats {
	private static Map<String,Integer> map = new HashMap<String,Integer>();
//   mapping the names of the players (String) to the number of wins (Integer) that player has accumulated
	public static Map wins() {
		try {
		    BufferedReader in  = new BufferedReader (new FileReader("C:\\Users\\mymmym\\Desktop\\CS18000\\lab try\\lab14\\lab14inputfile.txt"));
		    String eachLine = null;
		    while ( (eachLine = in.readLine()) != null ) {	    
		        int wins = Integer.parseInt(eachLine.split(" ")[0]);
		        String[] player = new String[10];
		        for (int i = 0; i < 5; i++)
		    	    player[i] = eachLine.split(" ")[i+1];
		        for (int j = 0; j < 5; j++ )
		    	    player[j + 5] = eachLine.split(" ")[j+7];		    
		        if (wins == 1) {
		    	    for (int i = 0; i < 5; i++ ) {
		    		    Integer count = map.get(player[i]);
		    		    if (count == null) count = 1;
		    		    else count++;
		    		    map.put(player[i], count);
		    	    }
		        }
		        else if (wins == 0) {
		    	    for (int j = 0; j < 5; j++ ) {
		    		    Integer count = map.get(player[j + 5]);
		    		    if (count == null) count = 1;
		    		    else count++;
		    		    map.put(player[j + 5], count);
		    	    }
		        }
		    }
		} catch (IOException e) { e.printStackTrace(); }
		return map;
	}
	
	public static String winner(Map map){
		int top = 0;
		String mvp = "";
	    Iterator iterator = map.keySet().iterator();
    	while (iterator.hasNext()) {
	        String name = iterator.next().toString();
	        int count = (int)map.get(name);	
	        if (count >= top) {
	        	top = count;
	        	mvp = name;
	        }
    	}
    	return mvp;
	}
//   iterates through a HashMap, such as returned by wins, returning the name of the player with the most wins
	public static void main(String[] args) {
		Stats statistics = new Stats();
		System.out.println (statistics.wins());
		System.out.println (statistics.winner(wins()));
	}
}
