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
	GameData gameData = GameData.getInstance();

    GameController(){
		model = new SessionModel();
		view = new GameView();
	}

    //WIP
    GameController(SessionModel model, GameView view){
		this.model = model;
		this.view = view;
    }

    public void startGame(){
		//MainMenu.printMenu();
    }
}
