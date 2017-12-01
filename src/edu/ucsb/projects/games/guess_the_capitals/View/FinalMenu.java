package edu.ucsb.cs56.projects.games.guess_the_capitals;

import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**                                                                                                                                     
 * FinalMenu object that player sees when game finishes                                                                                 
 *                                                                                                                                      
 * @author Sean Shelton, Armin Mahini                                                                                                   
 * @version UCSB CS56, F16                                                                                                              
 */
public class FinalMenu extends Menu{

    File myFile = new File("HighScores.txt");
    
    private HashMap <String, Integer> lines = new HashMap <String, Integer>();

    //HashMap <String, Integer> result = new HashMap <String, Integer>();
    //ArrayList<String[]> parsed = new ArrayList<String[]>();

    /** Prints last menu the user sees once the game is over. Displays the users score and gives
     *  them the option to play again or end the session
     *  @param menuData lets us access the number of correct responses
     */
    public void printMenu(MenuData menuData){
		assert (menuData != null);
		System.out.println("\n\n\n");
		System.out.println("Your Total Score: " + menuData.numCorrect + "/" + menuData.numQuestions);
		System.out.println("\n\n\n");
		writeScore(menuData);
		//sortByValue(lines);
		//parseLines(lines);
		//sort(parsed):
		printScores(getScores());
		System.out.println("Enter 1 to let another player play the game (entering anything else quits the game)");
    }

    /**
     * Writes scores and names from text file to a HashMap
     * @param menuData is passed through to access the player's score
     */
    public void writeScore(MenuData menuData){
		System.out.println("Please enter your username: ");
		Scanner scanner = new Scanner(System.in);
       	String name = scanner.next();
		String strScore = String.valueOf(menuData.numCorrect);
        try {
	    	FileWriter writer = new FileWriter(myFile, true);
	    	writer.write(name + "\t" + strScore + "\n");
	    	writer.close();
		} catch (IOException ex) {
	    	ex.printStackTrace();
		}    
    }

    /** 
     * Reads high scores file and parses names from scores to save them in a HashMap
     * @return a HashMap with the players' names and their corresponding scores
     */
    public HashMap<String, Integer> getScores(){
		int count = 0;
		try {
	    	FileReader fileReader = new FileReader(myFile);
	    	Scanner scanner = new Scanner(fileReader);
	    	scanner.nextLine();
	    	scanner.nextLine();
	    	while (scanner.hasNextLine()/* && count < 10*/){
				String line = scanner.nextLine();
				String[] result = line.split("\t");
				lines.put(result[0], Integer.parseInt(result[1]));
				count++;		 
	    	}
	    	scanner.close();
		} catch (Exception ex) {
	    	ex.printStackTrace();
		}
		return lines;
    }

    /**
     * Prints players' names and their corresponding scores
     * @param lines is the HashMap
     */
    public void printScores(HashMap<String, Integer> h){
		List<String> users = new ArrayList<String>(h.keySet());
		Collections.sort(users, (u1,u2) -> h.get(u2).compareTo(h.get(u1)));
		System.out.println("Name" + "\t" + "Score");
		/*	for (String u: users){
	    	System.out.println(u + "\t" + h.get(u));
		}*/
		for(int i = 0; i < 10; i++) {
		    System.out.println(users.get(i) + "\t" + h.get(users.get(i)));
		}
    }

}
