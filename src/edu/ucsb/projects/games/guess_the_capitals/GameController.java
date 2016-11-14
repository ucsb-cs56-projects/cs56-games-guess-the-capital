/**
 * Controller that takes input in order for View to know what to display
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
package edu.ucsb.cs56.projects.games.guess_the_capitals;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


public class GameController{
    
    private SessionModel model;
    private MenuData menuData;
    private GameView view;
    GameData gameData = GameData.getInstance();
    private MainMenu main;

	// use input to handle things accordingly
	private int input;

    GameController(){
		model = new SessionModel();
		view = new GameView();
		menuData = new MenuData();
		model.addObserver(menuData);
	}

    GameController(SessionModel model, GameView view, GameData gameData){
		this.model = model;
		this.view = view;
		this.gameData = gameData;
		menuData = new MenuData();
		model.addObserver(menuData);
    }

    public void runGame(){
		// reset our model
		boolean keepGoing = true;
		while (keepGoing) {
			model.reset();

			// prints out the main menu and handles the mode the user wants
			mainMenu();

			// prints out the question number menu and handles how many questions
			// the user wants
			questionNumMenu(); 

			playTheQuestions();

			// prints out the final menu and handles whether or not the user wants
			// to play again
			keepGoing = finalMenu();
		}

    }

	public void mainMenu() {
		input = view.menuIO(GameView.MAIN_MENU, null); 
		// TODO: set GameData to their selection
		if(input == 0)
			gameData.setLocations(gameData.getUSGame());
		    //GameData us = new GameData(capitalsFile, statesFile);
		else if(input == 1)
			gameData.setLocations(gameData.getWorldGame());
			//gameData.setLocations(GameData.worldGame);
		    //GameData world = new GameData(worldCapitalsFile, worldCountriesFile);
		else if(input == 2)
			gameData.setLocations(gameData.getAllGame());
			//gameData.setLocations(GameData.allGame);
		    //GameData all = new GameData();
	}

	public void questionNumMenu() {
		input = view.menuIO(GameView.QUESTION_NUM_MENU, null);
		// TODO: set SessionModel's number of questions
		//SessionModel ten = new SessionModel();
		if (input == 0)
			model.setNumQuestions(10);
		if(input == 1)
		    model.setNumQuestions(50);
		else if(input == 2){
		    System.out.println("Enter the number of questions");
		    Scanner numIn = new Scanner(System.in);
		    int customNum = numIn.nextInt();
		    model.setNumQuestions(customNum);
		}
	}

	public void playTheQuestions() {
        //input = view.menuIO(GameView.QUESTION_MENU);

		// TODO: check if answer is right or wrong, then increase or decrease num correct
		// might have to have gameview as an observer to sessionmodel to make this work

		// initializes game session
		model.updateCurrentQuestion();
		//menuData = new MenuData(model);

		for (int i = 1; i <= model.getNumQuestions(); ++i){
			// print out question menu and get input
			//model.setQuestionNum(i);
			menuData.setQuestionNum(i);
			//model.setQuestionNum(i);
			input = view.menuIO(GameView.QUESTION_MENU, menuData);

			// evaluate input for correctness
			if (model.checkAnswer(input))
				model.setNumCorrect(model.getNumCorrect() + 1);

			model.updateCurrentQuestion();
		}
	}




	public boolean finalMenu() {
		input = view.menuIO(GameView.FINAL_MENU, menuData); //need to double check with Sean/Jack
		return input == 1;

	}

}
