/**
 * Model that keeps track of the current session.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */

import java.io.*;

public abstract class Menu{
    
    /**
     * Place to keep all the choices a user can make give the menu they're at
     */
     private ArrayList<Choice> choices = new ArrayList<Choice>();

    /**
     * Represents the int input by the user to make a guess for a given question
     */
    protected int guesschoice_int;

    /**
     * Represents the int input by the user to make a prompt for a game mode
     */
    protected int promptchoice_int;

    protected String promptchoice_string;

    protected String guesschoice_string;

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
     * Sets the user's guess choice, while peforms I/O and handles exceptions 
     */
    public void setGuessChoice(){
	int x = 0;
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
   
    public abstract void printMenu();

    
    
}
