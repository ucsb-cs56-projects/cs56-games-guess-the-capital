/**
 * QuestionNumMenu object that player sees when selecting how many questions they want to asked
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */

import java.io.*;

public class QuestionNumMenu extends Menu{
    
    public int setPromptChoice(){
	super.setPromptChoice();
    }
   
    public void printMenu(){
	System.out.println("\n0. Play with 10 questions");
	System.out.println("1. Play with 50 questions");
	System.out.println("2. Choose custom number of questions");
	System.out.println("\nPlease select a number: \n");
    }

}

