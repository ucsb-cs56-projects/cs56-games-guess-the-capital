package edu.ucsb.cs56.S12.esterkin;

import java.util.Collections;
import java.util.ArrayList;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class Game{
    
	//Instance variables 
    
	private int index_choosenstate;
	private String correctcapital;
	private int index_duplicatechoosenstate;
	private String guesschoice_string;
	private int guesschoice_int;
    private String promptchoice_string;
	private int promptchoice_int;
    private int score=0;
    public ArrayList<String> fourcapitals;
	private int x;
    private int y;
    private int numitems;
    static boolean play = true;
    
    //setters and getters
    
    public int getIndex_choosenstate(){
        return index_choosenstate;
    }
    public void setIndex_choosenstate(int i){
        this.index_choosenstate = i;
    }
    
    public String getCorrectcapital(){
        return correctcapital;
    }
    public void setCorrectcapital(String s){
        this.correctcapital = s;
    }
    
    public int getIndex_duplicatechoosenstate(){
        return index_duplicatechoosenstate;
    }
    public void setIndex_duplicatechoosenstate(int i){
        this.index_duplicatechoosenstate = i;
    }
    
    public String getGuessChoice_string(){
        return guesschoice_string;
    }
    public void setGuessChoice_string(String s){
        this.guesschoice_string = s;
    }
    
    public int getGuessChoice_int(){
        return guesschoice_int;
    }
    public void setGuessChoice_int(int i){
        this.guesschoice_int = i;
    }
    
    public String getPromptChoice_string(){
        return promptchoice_string;
    }
    public void setPromptChoice_string(String s){
        this.promptchoice_string = s;
    }
    
    public int getPromptChoice_int(){
        return promptchoice_int;
    }
    public void setPromptChoice_int(int i){
        this.promptchoice_int = i;
    }
    
    public void setScore(int i){
        this.score = i;
    }
    
    public int getScore(){
        return score;
    }
    
    public void setNumitems(int numitems){
        this.numitems = numitems;
        
    }
    public int getNumitems(){
        return numitems;
    }
    static char playagain;
    
	ArrayList<String> states = readFile("build/edu/ucsb/cs56/S12/esterkin/states.txt"); //Moved from ChooseRandomStateorCountry();
	ArrayList<String> statesCopy = new ArrayList<String>(this.readFile("build/edu/ucsb/cs56/S12/esterkin/states.txt"));
    ArrayList<String> worldcountries = readFile("build/edu/ucsb/cs56/S12/esterkin/worldcountries.txt"); //Moved from ChooseRandomStateorCountry();
	ArrayList<String> worldcountriesCopy = new ArrayList<String>(this.readFile("build/edu/ucsb/cs56/S12/esterkin/worldcountries.txt"));

    
    
	//Parse file function - adapted from http://www.java-tips.org/java-se-tips/java.util/scanning-text-with-java.util.scanner-3.html
    
	public ArrayList<String> readFile(String fileName) {
        
		ArrayList<String> StatesOrCapitals = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File(fileName));
			scanner.useDelimiter
			(System.getProperty("line.separator")); 
			while (scanner.hasNext()) {
				StatesOrCapitals.add(scanner.next());}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return StatesOrCapitals;
	} 
    
    /**
     Returns the index of a random state from the duplicate states arraylist and removes that index from the original states arraylist    
     */
	public int ChooseRandomStateorCountry(ArrayList<String> alist, ArrayList<String> alistcopy){
        
		index_choosenstate = (int)(   Math.random() * alist.size()  );
		String choosenstate = alist.get(index_choosenstate);
		alist.remove(index_choosenstate);
		index_duplicatechoosenstate = alistcopy.indexOf(choosenstate);
        
		return index_duplicatechoosenstate; 
        
	}
    /**
     Generates an arraylist containing 3 random capitals and the capital corresponding to the choosen state, shuffles the arraylist before returning it     
     */
    
	public ArrayList<String> generate4Capitals(int index_duplicatechoosenstate){
		ArrayList<String> capitals = readFile("build/edu/ucsb/cs56/S12/esterkin/capitals.txt");
		correctcapital = capitals.get(index_duplicatechoosenstate);
		capitals.remove(index_duplicatechoosenstate);
		fourcapitals = new ArrayList<String>();
		for (int i=0;i<3;i++){
			int randomcapital_index = (int)(   Math.random() * capitals.size());
			fourcapitals.add(capitals.get(randomcapital_index));
			capitals.remove(randomcapital_index);	
		}
		fourcapitals.add(correctcapital);
		Collections.shuffle(fourcapitals);
        
		return fourcapitals;
	}
    
    public ArrayList<String> generate4CountryCapitals(int index_duplicatechoosenstate){
		ArrayList<String> capitals = readFile("build/edu/ucsb/cs56/S12/esterkin/worldcapitals.txt");
		correctcapital = capitals.get(index_duplicatechoosenstate);
		capitals.remove(index_duplicatechoosenstate);
		fourcapitals = new ArrayList<String>();
		for (int i=0;i<3;i++){
			int randomcapital_index = (int)(   Math.random() * capitals.size());
			fourcapitals.add(capitals.get(randomcapital_index));
			capitals.remove(randomcapital_index);	
		}
		fourcapitals.add(correctcapital);
		Collections.shuffle(fourcapitals);
        
		return fourcapitals;
	}
    
    /**
     Peforms I/O and handles exceptions
     */
    
	public void setGuessChoice(){
        
		try{
			BufferedReader reader;
			reader = new BufferedReader(new InputStreamReader(System.in));
            String choice = guesschoice_string;
			while(x==0){
				guesschoice_string = reader.readLine();
				if( ( ! guesschoice_string.equals("0") ) && ( ! guesschoice_string.equals("1") ) && ( ! guesschoice_string.equals("2") ) && ( ! guesschoice_string.equals("3") ))
					System.out.println("Please type either 0, 1, 2, or 3");
				else
					x=1;
			}
			guesschoice_int = Integer.parseInt(guesschoice_string);
            
		} catch(IOException ioe){
			System.out.println("An unexpected error occured.");     
		}
	}
    
    
    public void setPromptChoice(){
        
		try{
			BufferedReader reader;
			reader = new BufferedReader(new InputStreamReader(System.in));
			while(y==0){
				promptchoice_string = reader.readLine();
				if( ( ! promptchoice_string.equals("0") ) && ( ! promptchoice_string.equals("1") ) && ( ! promptchoice_string.equals("2") ) && ( ! promptchoice_string.equals("3") ))
					System.out.println("Please type either 0, 1, 2, or 3");
				else
					y=1;
			}
			promptchoice_int = Integer.parseInt(promptchoice_string);
            
		} catch(IOException ioe){
			System.out.println("An unexpected error occured.");     
		}
	}
    
    
    /**
     Compares the answer the player choose with the correct answer, and performs the appropriate actions    
     */
    
	public String compareAnswer(){
		if(correctcapital.equals(fourcapitals.get(guesschoice_int))){
            if(numitems == 50){
                score+=2;
                return "Correct!";
            }
            else if(numitems == 10){
                score+=10;
                return "Correct!";
            }
		} 
        return "Wrong!";
    }
    
    /**
     Calculates a grade for the player based on their total score   
     */
	public String grade(){
		if (score >= 90) 
			return "A";
		if (score >= 80) 
			return "B";
		if (score >= 70) 
			return "C";
		if (score >= 60) 
			return "D";
		else
			return "F";
	}
    
    public void prompt(){
        System.out.println("\nWelcome to the capitals quiz game! \nWhat would you like to do?");
        System.out.println("\n0. Play a 10 Question US State Capitals Game");
        System.out.println("1. Play a 50 Question US State Capitals Game");
        System.out.println("2. Play a 10 Question World Capitals Game");
        System.out.println("3. Play a 50 Question World Capitals Game");
        System.out.println("\nPlease select a number: \n");
        this.setPromptChoice();
    }
    
    /**
     Asks the questions, runs certain methods, sets appropriate instance variables, and prints appropriate responses. 
     */
	public void StatesRunner(int numitems){
		for(int i=0;i<numitems;i++){
			System.out.println("\nWhat is the capital of" + " " + statesCopy.get(this.ChooseRandomStateorCountry(states,statesCopy))+"?" +"\n");
			ArrayList<String> fourCapitals = generate4Capitals(index_duplicatechoosenstate);
			for(int j=0;j<4;j++){
				System.out.println("" + j +"." + " " + fourCapitals.get(j));
			}
			System.out.println("");
			System.out.print("Enter Answer: ");
			this.setGuessChoice();
			x=0;
            if(i<numitems-2)
                System.out.println(this.compareAnswer()+ " " + ((numitems-1)-i) + " " + "questions to go.");
            if(i==numitems-2)
                System.out.println(this.compareAnswer()+ " " + "The last question is...");
            else if(i==numitems-1)
                System.out.println(this.compareAnswer());
        }
		System.out.println("\n\n\nYour Total Score:" +" "+ score + "/" +"100");
	}
    
    /**
     Asks the questions, runs certain methods, sets appropriate instance variables, and prints appropriate responses. 
     */
    
    public void CountriesRunner(int numitems){
		for(int i=0;i<numitems;i++){
			System.out.println("\nWhat is the capital of" + " " + worldcountriesCopy.get(this.ChooseRandomStateorCountry(worldcountries,worldcountriesCopy))+"?" +"\n");
			ArrayList<String> fourCapitals = generate4CountryCapitals(index_duplicatechoosenstate);
			for(int j=0;j<4;j++){
				System.out.println("" + j +"." + " " + fourCapitals.get(j));
			}
			System.out.println("");
			System.out.print("Enter Answer: ");
			this.setGuessChoice();
			x=0;
			if(i<numitems-2)
                System.out.println(this.compareAnswer()+ " " + ((numitems-1)-i) + " " + "questions to go.");
            if(i==numitems-2)
                System.out.println(this.compareAnswer()+ " " + "The last question is...");
            else if(i==numitems-1)
                System.out.println(this.compareAnswer());
		}
		System.out.println("\n\n\nYour Total Score:" +" "+ score + "/" +"100");
    }
        
    /**
     Initiates appropriate actions based on the user's choice  
     */
    
    public void runner(){
        if(this.getPromptChoice_int()==0){
             numitems = 10;
             this.StatesRunner(10);   
        }
        else if(this.getPromptChoice_int()==1){
            numitems = 50;
            this.StatesRunner(50); 
        }
        
        else if(this.getPromptChoice_int()==2){
            numitems = 10;
            this.CountriesRunner(10);
        }
            
        else if (this.getPromptChoice_int()==3){
                numitems = 50;
                this.CountriesRunner(50); 
        }
    }
    
	public static void main(String[] args){
        while(play){
		Game game = new Game();
        game.prompt();
        game.runner();
        System.out.println("Your Grade:" + " " + game.grade()+"\n\n\n");
        System.out.println("Enter x to play again (entering any other key quits the game)");
        try{playagain = (char)System.in.read();                
            
        } catch (IOException ioe) {
			System.out.println("An unexpected error occured.");    
		}
        if(playagain != 'x')
            play = false;
        }
        }
}




