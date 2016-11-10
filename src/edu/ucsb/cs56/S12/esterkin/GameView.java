/**
 * View  class that handles what menu the player sees during teh game.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class GameView{ //extends Observable?
    
    /**
     * Used to store various menus the player will see throughout the game
     */
    private ArrayList<Menu> menuList = new ArrayList<Menu>();

    public static int MAIN_MENU = 0;
    public static int QUESTION_NUM_MENU = 1;
    public static int QUESTION_MENU = 2;
    public static int FINAL_MENU = 3;
    //private Controller controller;

    //initialized these in order to pass through capitals/territories for game that user wants to play (?)
    GameData usGame = new GameData(capitalsFile, statesFile);
    GameData worldGame = new GameData(worldCapitalsFile, worldCountriesFile);
    GameData allGame = new GameData();

    GameView(){
		menuList.add(new MainMenu());
		menuList.add(new QuestionNumMenu());
		menuList.add(new QuestionMenu());
		menuList.add(new FinalMenu());
    }

    /**
     * Decides what I display given the user's input
     */
    public int menuIO(int menuNum){//separated into 3 blocks for when the user is on the first 2 Menus (block 1), when they're on QuestionMenu (block 2), and for when they're on FinalMenu
	if(menuNum == 0 || menuNum == 1){
		menuList.get(menuNum).printMenu();
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		return i;
		//controller.menuInput(i); //stub for Controller
	}
	else if(menuNum == 2){
	    menuList.get(menuNum).printMenu();//TODO: need a way to pass through ArrayList<Territory> possibleChoices, Territory answerTerritory, int questionNum
	                                      //(aka know how many questions and what kinds of questions the user wants here)
	    Scanner input = new Scanner(System.in);
	    int i = input.nextInt();
	    return i;
	}
	else if(menuNum == 3){//TODO: need a way to pass through int numCorrect, int numQuestions
	                     //(aka know how many questions and what kinds of questions the user wants here)

	}
    }
   
}
    

