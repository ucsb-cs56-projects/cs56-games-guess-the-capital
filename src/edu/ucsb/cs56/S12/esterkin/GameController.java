/**
 * Controller that takes input in order for View to know what to display
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
import java.util.ArrayList;

public class GameController{
    
    private SessionModel model;
    private GameView view;

    //WIP
    GameController(SessionModel model, GameView view){
	this.model = model;
	this.view = view;
    }

    /**
     * Stub from GameView class, not exactly sure what this is for
    
    public void getInput(int i){
	
    }
    */

    public void startGame(){
	MainMenu.printMenu();
    }
}
