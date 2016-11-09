/**
 * QuestionMenu object that player sees when mode is selected and the user is asked a question
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */

import java.io.*;
import java.util.ArrayList;

public class QuestionMenu extends Menu{ //implements Choice

    /**
     * Prints question, whether or not response is correct/incorrect
     */
    public void printMenu(ArrayList<Territory> possibleChoices, Territory answerTerritory,
			  int questionNum){

		System.out.println("Question " + questionNum + ": " + "What is the capital of " + answerTerritory.getName() + "?\n");
		for(int i = 0; i < possibleChoices.size(); i++){
			System.out.println(i + ". " + possibleChoices.get(i).getCapital().getName());
			//System.out.println(i + ". " + choices.get(i).toString());
		}

    }

	public void printMenu(){
		// stub
	}

}

