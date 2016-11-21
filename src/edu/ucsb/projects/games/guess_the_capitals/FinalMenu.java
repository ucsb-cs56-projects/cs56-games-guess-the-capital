/**
 * FinalMenu object that player sees when game finishes
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
package edu.ucsb.cs56.projects.games.guess_the_capitals;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class FinalMenu extends Menu{

    File myFile = new File("HighScores.txt");
    HashMap <String, Integer> lines = new HashMapt <String,Integer>();
    //HashMap <String, Integer> result = new HashMap <String, Integer>();
    //ArrayList<String[]> parsed = new ArrayList<String[]>();

    /** Prints last menu the user sees once the game is over. Displays the users score and gives
     *  them the option to play again or end the session
     */
    public void printMenu(MenuData menuData){
		assert (menuData != null);
		System.out.println("\n\n\n");
		System.out.println("Your Total Score: " + menuData.numCorrect + "/" + menuData.numQuestions);
		System.out.println("\n\n\n");
		writeScore(menuData);
		getScores();
		//sortByValue(lines);
		//parseLines(lines);
		//sort(parsed):
		printScores(lines);
		System.out.println("Enter 1 to play again (entering anything else quits the game)");
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
	    /*File highScores = new File("HighScores.txt");
	    highScores.createNewFile();
	    FileWriter writer = new FileWriter(highScores);*/
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
	    //BufferedReader bufferedReader = new BufferedReader(fileReader);
	    //String line = null;
	    //while ((line = bufferedReader.readLine()) != null){
	    Scanner scanner = new Scanner(fileReader);
	    while (scanner.hasNextLine() && count < 20){
		//lines.add(bufferedReader.readLine());
		//lines.add(scanner.nextLine());
		String line = scanner.nextLine();
		String[] result = line.split("\t");
		lines.put(result[0], Integer.parseInt(result[1]));
		count++;
		//System.out.println(scanner.nextLine());
		//fileScanner.nextLine();		 
	    }
	    //bufferedReader.close();
	    scanner.close();
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return lines;
    }

    /*public ArrayList<String[]> parseLines(ArrayList<String> lines){
	for (String l: lines){
	    parsed.add(l.split("\t"));
	}
	return parsed;
	}*/
    /**
     * Generic sort function for HashMap to organize player's names in order of the score they got
     * @param map collection of generic types K and V (names and scores for the purpose of my game)
     * @return result is the sorted map
     */
    /*public static <K, V extends Comparable<? super V>> Map<K, V>
                                sortByValue( Map<K, V> map)
    {
        List<Map.Entry<K, V>> list =
            new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>()
                          {
                              public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
                              {
                                  return (o1.getValue()).compareTo( o2.getValue() );
                              }
                          } );

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list)
            {
                result.put( entry.getKey(), entry.getValue() );
            }
        return result;
    }*/

    /**
     * Prints players' names and their corresponding scores
     * @param lines is the HashMap
     */
    public void printScores(HashMap<String, Integer> lines){
	Iterator it = result.entrySet().iterator();
	while (it.hasNext()){
	    HashMap.Entry pair = (HashMap.Entry)it.next();
	    System.out.println(pair.getKey() + "=" + pair.getValue());
	    it.remove();
	}
    }

    
}
