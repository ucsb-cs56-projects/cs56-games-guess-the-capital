/**
 * Holds all of the data for the menus
 *
 * Includes possible answer choices, the correct Territory, number of questions
 * and correct responses, and a way to update the information to correspond 
 * to the current state of the game
 *
 * @author Sean Shelton, Armin Mahini
 * @version for UCSB CS56, F16  
 */

package edu.ucsb.cs56.projects.games.guess_the_capitals;

import java.util.Observer;
import java.util.Observable;

import java.util.ArrayList;

public class MenuData implements Observer{
	public ArrayList<Territory> possibleChoices;
	public Territory answerTerritory;
	public int numQuestions;
	public int numCorrect;
	public int questionNum;
	private SessionModel model;

    /** Constructs a newly allocated MenuData object
     */
	MenuData() {
		possibleChoices = null;
		answerTerritory = null;
		numQuestions = 10;
		numCorrect = 0;
		questionNum = 0;
	}

     /** Constructs a newly allocated MenuData object that assigns 
      *  its variables to what it gets from the SessionModel passed through.
      *  @param sessionModel assigns values to the following variables
      *  to correspond with what the given menu needs to know
     */
	MenuData(SessionModel sessionModel) {
		possibleChoices = sessionModel.getPossibleAnswers();
		answerTerritory = sessionModel.getAnswerTerritory();
		numQuestions = sessionModel.getNumQuestions();
		numCorrect = sessionModel.getNumCorrect();
		questionNum = sessionModel.getQuestionNum();
	}

    /** Sets the question number to correspond to the question 
     *  the user is currently on
     *  @param questionNum is the number of question
    */
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}

    /** Updates the Menu object's information through the Observer pattern
     *  as the game progresses
     *  @param obs is passed through to allow the game to update the Menu's state
     */
	public void update(Observable obs, Object ov) {
		// This needs to be a session model
		if (obs instanceof SessionModel) {
			SessionModel modelUpdate = (SessionModel)obs;
			possibleChoices = modelUpdate.getPossibleAnswers();
			answerTerritory = modelUpdate.getAnswerTerritory();
			numQuestions = modelUpdate.getNumQuestions();
			numCorrect = modelUpdate.getNumCorrect();
			questionNum = modelUpdate.getQuestionNum();
		}	
	}
	
}
