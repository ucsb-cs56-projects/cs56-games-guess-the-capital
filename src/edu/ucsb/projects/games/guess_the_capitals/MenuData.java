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

	MenuData() {
		possibleChoices = null;
		answerTerritory = null;
		numQuestions = 10;
		numCorrect = 0;
		questionNum = 0;
	}

	MenuData(SessionModel sessionModel) {
		possibleChoices = sessionModel.getPossibleAnswers();
		answerTerritory = sessionModel.getAnswerTerritory();
		numQuestions = sessionModel.getNumQuestions();
		numCorrect = sessionModel.getNumCorrect();
		questionNum = sessionModel.getQuestionNum();
	}

	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}

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
