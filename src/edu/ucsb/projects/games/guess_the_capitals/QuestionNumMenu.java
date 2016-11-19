/**
 * QuestionNumMenu object that player sees when selecting how many questions they want to asked
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */

package edu.ucsb.cs56.projects.games.guess_the_capitals;

public class QuestionNumMenu extends Menu{
    
    /** Prints out options for number of questions to be quizzed on
     *  @param menuData contains information such as the number of possible choices, 
     *  question number and Territory and Capital objects
     */
    public void printMenu(MenuData menuData){
		System.out.println("\n0. Play with 10 questions");
		System.out.println("1. Play with 50 questions");
		System.out.println("2. Choose custom number of questions");
		System.out.println("\nPlease select a number: \n");
    }

}

