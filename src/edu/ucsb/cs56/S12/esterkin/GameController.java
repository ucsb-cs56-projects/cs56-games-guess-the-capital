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
		
		input = view.menuIO(GameView.QUESTION_NUM_MENU);
		// TODO: set SessionModel's number of questions

		// for (int i = 1; i <= model.getNumQuestions(); ++i) {	
        	input = view.menuIO(GameView.QUESTION_MENU);
		// TODO: check if answer is right or wrong, then increase or decrease num correct
		// might have to have gameview as an observer to sessionmodel to make this work

		input = view.menuIO(GameView.FINAL_MENU);
		// if input is 1, play again
    }    

}
