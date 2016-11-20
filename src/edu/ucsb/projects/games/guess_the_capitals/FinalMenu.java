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
    ArrayList <String> lines = new ArrayList<String>();
    ArrayList <String[]> parsed = new ArrayList<String[]>();

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
		parseLines(lines);
		//sort(parsed);
		printScores(parsed);
		System.out.println("Enter 1 to play again (entering anything else quits the game)");
    }

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

    public ArrayList<String> getScores(){
	int count = 0;
	try {
	    FileReader fileReader = new FileReader(myFile);
	    //BufferedReader bufferedReader = new BufferedReader(fileReader);
	    //String line = null;
	    //while ((line = bufferedReader.readLine()) != null){
	    Scanner scanner = new Scanner(fileReader);
	    while (scanner.hasNextLine() && count < 9){
		//lines.add(bufferedReader.readLine());
		lines.add(scanner.nextLine());
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

    public ArrayList<String[]> parseLines(ArrayList<String> lines){
	for (String l: lines){
	    parsed.add(l.split("\t"));
	}
	return parsed;
    }

    public void sort(ArrayList<String[]> parsed){
	boolean swapped = true;
	int j = 0;
	String[] temp = new String[2];
	String first;
	String second;
	for (int i = 0; i < parsed.size() - j; i++){
            while(swapped){
		swapped = false;
		j++;
		first = (parsed.get(i))[1];
		second = (parsed.get(i+1))[1];
		if (Integer.parseInt(first) > Integer.parseInt(second)){
		    //temp = parsed.get(i).clone();
		    temp[0] = (parsed.get(i))[0]; //set contents of temp to those of the larger array at i
		    temp[1] = (parsed.get(i))[1];
		    //parsed.get(i) = parsed.get(i+1).clone(); //set array with the larger score to the array with the lower score
		    parsed.get(i)[0] = (parsed.get(i+1))[0]; //set contents of larger array at i to those of smaller array at i+1
		    parsed.get(i)[1] = (parsed.get(i+1))[1];
		    //parsed.get(i+1) = temp.clone(); //set array with lower score to array with
		    parsed.get(i+1)[0] = temp[0];
		    parsed.get(i+1)[1] = temp[1];
		    swapped = true;
		}
	    } 
	}
    }
    
    public void printScores(ArrayList<String[]> parsed){
	for (String[] p: parsed){
	    for (int i = 0; i < p.length; i++){
		System.out.println(p[i]);
	    }
	}
    }
    
}
