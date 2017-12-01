package edu.ucsb.cs56.projects.games.guess_the_capitals;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

//adding timer
import java.util.Timer;
import java.util.TimerTask;


/**
 * View  class that handles what menu the player sees during the game.
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

    private String str = ""; //input variable to check if it's empty

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
     * Prints the appropriate Menu
     * @param menuNum corresponds to what menu to display given where in the game the user is
     * @param menuData is passed to print out possible choices
     * @return int that user selected to choose a menu
     */
    public int menuIO(int menuNum, MenuData menuData) {
	//this is where the timer will be added
	//this is when the menuIO used to figure out the user's input
	if (menuNum == QUESTION_MENU) {
	    menuList.get(menuNum).printMenu(menuData);
	    TimerTask task = new TimerTask() {
		    public void run() {
			if (str.equals("")) {
			    System.out.println("Time's up! Enter a choice to move on");
			    return;
			}
		    }
		};
	    try {
		Timer timer = new Timer();
		System.out.println("You have 5 seconds");
		timer.schedule(task, 5*1000);
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String id = input.readLine();
		int i = Integer.parseInt(id);
		timer.cancel();
		return i;
	    }
	    catch (Exception e) {
		return 0;
	    }
	}
		menuList.get(menuNum).printMenu(menuData);
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		return i;

	}   
}
    

