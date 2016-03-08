package edu.ucsb.cs56.S12.esterkin;

import java.util.Collections;
import java.util.ArrayList;
import java.util.*;
import java.lang.Math;
import java.io.*;

/**
 * The main class Game, to run and play guess-the-capital-game
 *
 * @author Edward Sterkin
 * @author Yuki Mano
 * @version CS56, Winter 2016 (original version: CS56, Spring 2012)
 */

public class Game{
    
    //Instance variables 
    private int index_choosenstate;
    private String correctcapital;
    private int index_duplicatechoosenstate;
    private String guesschoice_string;
    private int guesschoice_int;
    private String promptchoice_string;
    private int promptchoice_int1;
    private int promptchoice_int2;
    private int customprompt;
    private int score=0;
    private int x = 0;
    private int numitems;
    private ArrayList<String> fourcapitals;
    static private boolean play = true;
    static private char playagain;

    /**
       no-args constructor onlys runs the Game class
    */
    
    
    //setters and getters
    /** 
	get the index of the choosen state
	@return the index of an ArrayList that holds a choosen state
    */
    public int getIndex_choosenstate(){
        return index_choosenstate;
    }
    /** 
	set the index of the choosen state
	@param int take an integer to choose a particular state 
    */
    public void setIndex_choosenstate(int i){
        this.index_choosenstate = i;
    }

    /**
       get the string of the correct capital
       @return the correct capital as a String within the multiple choice
    */
    public String getCorrectcapital(){
        return correctcapital;
    }
    /**
       set the string of the correct capital
       @param String take a String to set the correct capital name
    */
    public void setCorrectcapital(String s){
        this.correctcapital = s;
    }

    /**
       get the index of the duplicatechoosenstate
       @return the index of an ArrayList that holds the choosen state
    */
    public int getIndex_duplicatechoosenstate(){
        return index_duplicatechoosenstate;
    }
    /**
       set the index of the duplicatechoosenstate
       @param int take an integer that locates the choosen state
    */
    public void setIndex_duplicatechoosenstate(int i){
        this.index_duplicatechoosenstate = i;
    }

    /**
       get the string of the choosen guess
       @return the String guesschoice_string
     */
    public String getGuessChoice_string(){
        return guesschoice_string;
    }
    /**
       set the string of the choosen guess
       @param String take a String and set it to guesschoice_string
    */
    public void setGuessChoice_string(String s){
        this.guesschoice_string = s;
    }

    /**
       get the integer of the choosen guess
       @return the int guesschoice_int
     */
    public int getGuessChoice_int(){
        return guesschoice_int;
    }
    /**
       set the integer o the choosen guess
       @param int set an integer to guesschoice_int
     */
    public void setGuessChoice_int(int i){
        this.guesschoice_int = i;
    }

    /**
       get the string of the prompt choice
       @return the String promptchoice_string
    */
    public String getPromptChoice_string(){
        return promptchoice_string;
    }
    /**
       set the string of the prompt choice
       @param String set a String to promptchoice_string
    */
    public void setPromptChoice_string(String s){
        this.promptchoice_string = s;
    }

    /**
       set the user's score
       @param int set the score of the game
    */
    public void setScore(int i){
        this.score = i;
    }
    /** 
	get the user's score
	@return the score of the game
    */
    public int getScore(){
        return score;
    }

    /**
       set the integer numitems
       @param int set an integer to numitems
    */
    public void setNumitems(int numitems){
        this.numitems = numitems;
    }
    /**
       get the integer numitems
       @return the integer numitems
    */
    public int getNumitems(){
        return numitems;
    }
    
    
    //get the text files that contain the US states and the world countries
    ArrayList<String> states = readFile("build/edu/ucsb/cs56/S12/esterkin/states.txt"); 
    ArrayList<String> statesCopy = new ArrayList<String>(states);
    
    ArrayList<String> worldcountries = readFile("build/edu/ucsb/cs56/S12/esterkin/worldcountries.txt"); 
    ArrayList<String> worldcountriesCopy = new ArrayList<String>(worldcountries);   
    ArrayList<String> statesAndCountries = addLists(states, worldcountries);
    ArrayList<String> statesAndCountriesCopy = new ArrayList<String>(statesAndCountries);

    //get the text files that contain the US states' and worlds' capitals
    ArrayList<String> stateCapitals = new ArrayList<String>(this.readFile("build/edu/ucsb/cs56/S12/esterkin/capitals.txt"));
    ArrayList<String> worldCapitals = new ArrayList<String>(this.readFile("build/edu/ucsb/cs56/S12/esterkin/worldcapitals.txt"));
    ArrayList<String> bothCapitals = addLists(stateCapitals, worldCapitals);

       
    /**
       combine two lists of ArrayList into one big ArrayList
       @param ArrayList<String> the first list
       @param ArrayList<String> the second list
       @return one ArrayList that contains all of the elements in the first and second list
    */
       public ArrayList<String> addLists(ArrayList<String> l1, ArrayList<String> l2) {
	ArrayList<String> newList = new ArrayList<String>();
	newList.addAll(l1);
	newList.addAll(l2);
	return newList;
    }


    /**
    Parse file function - adapted from http://www.java-tips.org/java-se-tips/java.util/scanning-text-with-java.util.scanner-3.html
    @param String takes a name of a text file
    @return an ArrayList of all of name in the text file
    */
    public ArrayList<String> readFile(String fileName) {
	ArrayList<String> StatesOrCapitals = new ArrayList<String>();
	try {
	    Scanner scanner = new Scanner(new File(fileName));
	    scanner.useDelimiter(System.getProperty("line.separator")); 
	    while (scanner.hasNext()) 
		StatesOrCapitals.add(scanner.next());
	    scanner.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	return StatesOrCapitals;
    }


    
    /**
       Returns the index of a random state from the duplicate states arraylist and removes that index from the original states arraylist    
       @param ArrayList<String> a list
       @param ArrayList<String> a copied version of that list
       @return an integer index_duplicatechoosenstate
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
    @param int the index of the choosen state 
    @param ArrayList<String> a list
    @return 3 random capitals and the capital corresponding to the choosen state
    */
    public ArrayList<String> generate4Capitals(int index_duplicatechoosenstate, ArrayList<String> list){
	ArrayList<String> capitals = new ArrayList<String>(list);
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
       Sets the user's guess choice, while peforms I/O and handles exceptions 
    */
    public void setGuessChoice(){
	try{
	    BufferedReader reader;
	    reader = new BufferedReader(new InputStreamReader(System.in));
	    while(x==0){
		this.setGuessChoice_string(reader.readLine());
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
    
    /**
       Sets the user's game type that he or she wants to play
       @return the integer that the user selects to play a certain game type
     */
    public int setPromptChoice(){
	int promptchoice_int = 0;
	int y = 0;
	try{
	    BufferedReader reader;
	    reader = new BufferedReader(new InputStreamReader(System.in));
	    while(y==0){
		promptchoice_string = reader.readLine();
		if( ( ! promptchoice_string.equals("0") ) && ( ! promptchoice_string.equals("1") ) && ( ! promptchoice_string.equals("2") ) )
		    System.out.println("Please type either 0, 1, 2");
		else
		    y=1;
	    }
	    promptchoice_int = Integer.parseInt(promptchoice_string);
            
	} catch(IOException ioe){
	    System.out.println("An unexpected error occured.");     
	}
	return promptchoice_int;
    }
    
    
    /**
     Compares the answer the player choose with the correct answer, and performs the appropriate actions
     @return a String as either "Correct!" if the guess is correct or "Wrong!" if the guess is wrong 
     */
    public String compareAnswer(){
	if(correctcapital.equals(fourcapitals.get(guesschoice_int))){
	    
	    score += (100/numitems);
	    return "Correct!\n";
	} 
        return "Wrong! The correct answer was " + correctcapital + ".\n";
    }
    
    /**
     Calculates a grade for the player based on their total score   
     @return the grade of user's performance playing the game
    */
	public String grade(){
	    String letterGrade = "";         
	    if(score == 100)
		return "A+";
	    if(score < 100)
		letterGrade = "A";
	    if(score < 90)
		letterGrade = "B";
	    if(score < 80)
		letterGrade = "C";
	    if(score < 70) 
		letterGrade = "D";
	    if(score < 60) 
		return "F";
	    
	    if(score %10 >= 7)
		return letterGrade + "+";
	    if(score %10 >= 3)
		return letterGrade;
	    else
		return letterGrade + "-";
	}

    /**
       Displays the prompt of the game
     */
    public void prompt(){
        System.out.println("\nWelcome to the capitals quiz game! \nWhat would you like to do?");

	System.out.println("\n0. Play US State Capitals Game");
	System.out.println("1. Play World Capitals Game");
	System.out.println("2. Play a game with World and State Capitals");
	System.out.println("\nPlease select a number: \n");
	promptchoice_int1 = this.setPromptChoice();

	System.out.println("\n0. Play with 10 questions");
	System.out.println("1. Play with 50 questions");
	System.out.println("2. Choose custom number of questions");
	System.out.println("\nPlease select a number: \n");
	promptchoice_int2 = this.setPromptChoice();

	if(promptchoice_int2 == 2){
	    System.out.println("Enter the number of questions");
	    customprompt = this.customNumQuestions();
	}
    }

    /**
       Check to see if the user input is an integer or not
       @return a boolean isInteger
     */
    public boolean checkInteger(String num) {
	boolean isInteger = true;
	try {
	    Integer.parseInt(num);
	} catch (Exception ex) {
	    isInteger = false;
	}
	return isInteger;
    }

    /**
      User can decide how many questions he or she wants to play in a game
      @return the integer customNumber
     */
    public int customNumQuestions() {
	int customNumber = 0;
	try {
	    int z = 0;
	    boolean isInt = true;
	    BufferedReader reader;
	    reader = new BufferedReader(new InputStreamReader(System.in));
	    while(z == 0){
		promptchoice_string = reader.readLine();
		isInt = checkInteger(promptchoice_string);
		if(isInt == true){
		    customNumber = Integer.parseInt(promptchoice_string);
		    if(promptchoice_int1==0 && (customNumber<1 || customNumber>50))
			System.out.println("Please type in the number between 1 and 50, inclusively");
		    else if(promptchoice_int1==1 && (customNumber<1 || customNumber>196))
			System.out.println("Please type in the number between 1 and 196, inclusively");
		    else if(promptchoice_int1==2 && (customNumber<1 || customNumber>246))
			System.out.println("Please type in the number between 1 and 246, inclusively");
		    else
			z=1;
		}
		else
		    System.out.println("Please only type in an integer");
	    }
		
		    
		
		
	
	} catch(IOException ioe){
	    System.out.println("An unexpected error occured.");
	}
	return customNumber;
    }

    
    /**
    Asks the questions, runs certain methods, sets appropriate instance variables, and prints appropriate responses. 
    @param int numitems
    @param ArrayList<String> list
    @param ArrayList<String> listCopy
    @param ArrayList<String> clist
    */
    public void QuestionRunner(int numitems, ArrayList<String> list, ArrayList<String> listCopy, ArrayList<String> clist) {
	for(int i=0; i<numitems; i++){
	    System.out.println("\nWhat is the capital of " + listCopy.get(this.ChooseRandomStateorCountry(list,listCopy)) + "?\n");
	    ArrayList<String> fourCapitals = generate4Capitals(index_duplicatechoosenstate, clist);
	    for(int j=0; j<4; j++){
		System.out.println("" + j + ". " + fourCapitals.get(j));
	    }
	    System.out.print("\nEnter Answer: ");
	    this.setGuessChoice();
	    x=0;
	    if(i<numitems-2)
		System.out.println(this.compareAnswer() + ((numitems-1)-i) + " questions to go.");
	    if(i==numitems-2)
		System.out.println(this.compareAnswer() + "The last question is...");
	    else if(i==numitems-1)
		System.out.println(this.compareAnswer());
	}
	System.out.println("\n\n\nYour Total Score: " + score + "/100");
    }
	    

    
    /**
     Initiates appropriate actions based on the user's choice  
     */
    public void runner(){
	if(promptchoice_int2 == 0)
	    numitems = 10;
	else if(promptchoice_int2 == 1)
	    numitems = 50;
	else if(promptchoice_int2 == 2)
	    numitems = customprompt;
	
	if(promptchoice_int1 == 0)
	    this.QuestionRunner(numitems, states, statesCopy, stateCapitals);
	else if(promptchoice_int1 == 1)
	    this.QuestionRunner(numitems, worldcountries, worldcountriesCopy, worldCapitals);
	else if(promptchoice_int1 == 2)
	    this.QuestionRunner(numitems, statesAndCountries, statesAndCountriesCopy, bothCapitals);
    }


    /**
       Initializes the game 
     */
    public static void main(String[] args){
        while(play){
	    Game game = new Game();
	    game.prompt();
	    game.runner();
	    System.out.println("Your Grade: " + game.grade()+"\n\n\n");
	    System.out.println("Enter x to play again (entering any other key quits the game)");
	    try{
		playagain = (char)System.in.read();                
	    } catch (IOException ioe) {
		System.out.println("An unexpected error occured.");    
	    }
	    if(playagain != 'x')
		play = false;
        }
    }
}




