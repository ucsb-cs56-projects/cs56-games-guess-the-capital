/**
 * View  class that handles what menu the player sees during teh game.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class GameView{
    
    /**
     * Used to store various menus the player will see throughout the game
     */
    private ArrayList<Menu> menuList = new ArrayList<Menu>();

    public static int MAIN_MENU = 0;
    public static int QUESTION_NUM_MENU = 1;
    public static int QUESTION_MENU = 2;
    public static int FINAL_MENU = 3;
    //private Controller controller;
    GameView(){
	menuList.add(new MainMenu());
	menuList.add(new QuestionMenu());
	menuList.add(new QuestionNumMenu());
	menuList.add(new FinalMenu());
    }

    /**
     * Decides what I display given the user's input
     */
    public void menuIO(int menuNum){
	menuList.get(menuNum).printMenu();
	Scanner input = new Scanner(System.in);
	int i = input.nextInt();
        //controller.getInput(i); stub for Controller
    }
   
}
    

