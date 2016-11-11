package edu.ucsb.cs56.projects.games.guess_the_capitals;

import java.util.ArrayList;
public class MenuData {
	public ArrayList<Territory> possibleChoices;
	public Territory answerTerritory;
	public int numQuestions;
	public int numCorrect;
	public int questionNum;

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
	
}
