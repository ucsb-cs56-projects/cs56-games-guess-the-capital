package edu.ucsb.cs56.projects.games.guess_the_capitals;

import java.io.*;
import java.util.ArrayList;

/**
 * QuestionMenu object that player sees when mode is selected and the user is asked a question
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
public class QuestionMenu extends Menu{

    /**
     * Prints question, whether or not response is correct/incorrect
     * @param menuData contains information for the number of possible choices, 
     * question number and Territory and Capital objects
     */
    public void printMenu(MenuData menuData){
		assert (menuData != null);
		System.out.println("Question " + menuData.questionNum + ": " + "What is the capital of " + menuData.answerTerritory.getName() + "?\n");
		for(int i = 0; i < menuData.possibleChoices.size(); i++){
			System.out.println(i + ". " + menuData.possibleChoices.get(i).getCapital().getName());
		}

    }

}

