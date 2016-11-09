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
    private MainMenu main;

    GameController(){
		model = new SessionModel();
		view = new GameView();
	}

    GameController(SessionModel model, GameView view){
		this.model = model;
		this.view = view;
    }

    public void runGame(){
	view.menuIO(0); //change to static vars in GameView later, didn't compile with static vars for some reason
	view.menuIO(1);
        view.menuIO(2);
	view.menuIO(3);
    }    

}
