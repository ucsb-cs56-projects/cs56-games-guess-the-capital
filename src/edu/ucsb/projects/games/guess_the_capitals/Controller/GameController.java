package edu.ucsb.cs56.projects.games.guess_the_capitals;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.io.File;


/**
 * Controller that takes input in order for View to know what to display
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
public class GameController{
    
    private SessionModel model;
    private MenuData menuData;
    private GameView view;
    GameData gameData = GameData.getInstance();
    private MainMenu main;

	/**
	 * Use input to handle things accordingly
	 */
	private int input;

    /** Default constructor for the controller. Responsible for sending commands to  model 
     *  and view to update their states'
     */
    GameController(){
		model = new SessionModel();
		view = new GameView();
		menuData = new MenuData();
		model.addObserver(menuData);
    }

    /** Constructor for GameController. Responsible for sending commands to  model and 
     *  view to update their states'. Assigns user-inputted model, view, 
     *  and gameData to SessionModel, GameView and GameData objects, respectively.
     */
    GameController(SessionModel model, GameView view, GameData gameData){
		this.model = model;
		this.view = view;
		this.gameData = gameData;
		menuData = new MenuData();
		model.addObserver(menuData);
    }
    
    /** Responsible for actually running the game, menu-by-menu.
     */ 
    public void runGame(){
		// reset our model
		boolean keepGoing = true;
		while (keepGoing) {

			//refresh SessionModel
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

        /** Displays main menu and allows user to select which set of 
         *  territories they'd like to be quizzed on
         */
	public void mainMenu() {
		//This prints the MainMenu and also takes in an input. The input decides which locations to set.
		input = view.menuIO(GameView.MAIN_MENU, null); 
		// TODO: set GameData to their selection
		/*if(input == 0)
		    model.setLocations(gameData.getUSGame());
		else if(input == 1)
			model.setLocations(gameData.getNorthAmGame());
		else if(input == 2)
			model.setLocations(gameData.getSouthAmGame());
		else if(input == 3)
			model.setLocations(gameData.getEuropeGame());
		else if(input == 4)
			model.setLocations(gameData.getAsiaGame());
		else if(input == 5)
			model.setLocations(gameData.getAfricaGame());
		else if(input == 6)
			model.setLocations(gameData.getAustraliaGame());
		else if(input == 7)
			model.setLocations(gameData.getWorldGame());
		else if(input == 8)
			model.setLocations(gameData.getAllGame());
		*/
		model.setLocations(gameData.getGame(input));
	}

	/** Displays menu that allows user how many questions they'd like to be asked
	 *  given their numerical input
	 */
	public void questionNumMenu() {
		//Prints out questionNumMenu and take in input that will decide the number of questions
		input = view.menuIO(GameView.QUESTION_NUM_MENU, null);
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
    
    /** Iterates through questions that user will be asked given 
	 *  their choices of territory and number of questions
	 */
	public void playTheQuestions() {

		// initializes game session
		model.updateCurrentQuestion();

		for (int i = 1; i <= model.getNumQuestions(); ++i){
			// print out question menu and get input
			menuData.setQuestionNum(i);
			input = view.menuIO(GameView.QUESTION_MENU, menuData);

			if(input == menuData.possibleChoices.size()){
				model.printHint();
				i--;
			}

			// evaluate input for correctness
			else if (model.checkAnswer(input)) {
				model.setNumCorrect(model.getNumCorrect() + 1);
			}

			if(input != menuData.possibleChoices.size()) {
				model.updateCurrentQuestion();
			}
		}
	}

    /** Displays final menu and allows user to play another game or end the session
	 *  @return true if the user selected 1, else return false if they did not
	 */
	public boolean finalMenu() {
		input = view.menuIO(GameView.FINAL_MENU, menuData); //need to double check with Sean/Jack
		return input == 1;

	}

}
