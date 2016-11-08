/**
 * FinalMenu object that player sees when game finishes
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */

import java.io.*;

public class FinalMenu extends Menu{
   
    public void printMenu(int numCorrect, int numQuestions){
	System.out.println("\n\n\n");
	System.out.println("Your Total Score: " + numCorrect + "/" + numQuestions);
	System.out.println("\n\n\n");
	System.out.println("Enter 1 to play again (entering anything else quits the game)");
    }

}
