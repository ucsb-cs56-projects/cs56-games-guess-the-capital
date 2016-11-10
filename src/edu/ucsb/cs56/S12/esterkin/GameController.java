/**
 * Controller that takes input in order for View to know what to display
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class GameController{
    
    private SessionModel model;
    private GameView view;
    GameData gameData = GameData.getInstance();
    private MainMenu main;

	// use input to handle things accordingly
	private int input;

    GameController(){
		model = new SessionModel();
		view = new GameView();
	}

    GameController(SessionModel model, GameView view){
		this.model = model;
		this.view = view;
    }

    public void runGame(){
		input = view.menuIO(GameView.MAIN_MENU); //change to static vars in GameView later, didn't compile with static vars for some reason
		// TODO: set GameData to their selection
		if(input == 0)
		    GameData us = new GameData(capitalsFile, statesFile);
		else if(input == 1)
		    GameData world = new GameData(worldCapitalsFile, worldCountriesFile);
		else if(input == 2)
		    GameData all = new GameData();
	   
		input = view.menuIO(GameView.QUESTION_NUM_MENU);
		// TODO: set SessionModel's number of questions
		SessionModel ten = new SessionModel();
		if(input == 1)
		    SessionModel.setNumQuestions(50);
		else if(input == 2){
		    System.out.println("Enter the number of questions");
		    Scanner numIn = new Scanner(System.in);
		    int customNum = numIn.nextInt();
		    SessionModel.setNumQuestions(customNum);
		}

		// for (int i = 1; i <= model.getNumQuestions(); ++i) {	
        	input = view.menuIO(GameView.QUESTION_MENU);
		// TODO: check if answer is right or wrong, then increase or decrease num correct
		// might have to have gameview as an observer to sessionmodel to make this work
		for (int i = 1; i <= model.getNumQuestions(); ++i){
		    
		}

		input = view.menuIO(GameView.FINAL_MENU); //need to double check with Sean/Jack
		// if input is 1, play again
		try{
		    Scanner numIn = new Scanner(System.in);
		    int playAgain = numIn.nextInt();               
		} catch (IOException ioe) {
		    System.out.println("An unexpected error occured.");    
		}
		if(playagain != 1)
		    break;
    }

}
