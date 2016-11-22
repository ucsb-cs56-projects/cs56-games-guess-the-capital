package edu.ucsb.cs56.projects.games.guess_the_capitals;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

/**
 * View  class that handles what menu the player sees during teh game.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
public class GameView { //extends Observable?
    
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
    //GameData usGame = new GameData(capitalsFile, statesFile);
    //GameData worldGame = new GameData(worldCapitalsFile, worldCountriesFile);
    //GameData allGame = new GameData();

    /** Default constructor that adds the 4 menus a user will see through the game. They will be 
     *  iterated throughout the game as the user makes a numerical input indicating what the want 
     *  to do (select US/World, number of questions, etc.)
     */
    GameView(){
		menuList.add(new MainMenu());
		menuList.add(new QuestionNumMenu());
		menuList.add(new QuestionMenu());
		menuList.add(new FinalMenu());
    }

    /**
     * Decides what to display given the user's input
     * @param menuNum corresponds to what menu to display given where in the game the user is
     * @param menuData is passed to print out possible choices
     * @return int that user selected to choose a menu
     */
    public int menuIO(int menuNum, MenuData menuData) {
		menuList.get(menuNum).printMenu(menuData);
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		return i;

	}   
}
    

