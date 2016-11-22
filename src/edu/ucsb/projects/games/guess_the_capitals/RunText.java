package edu.ucsb.cs56.projects.games.guess_the_capitals;

/**
 * RunText is responsible for setting up our model, view and controller to run the text version of the game
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
public class RunText {

	public static void main(String[] args) {
		GameData gameData = GameData.getInstance();
		SessionModel sessionModel = new SessionModel(gameData);
		GameView gameView = new GameView();
		GameController controller = new GameController(sessionModel, gameView, gameData);

		controller.runGame();
	}

}
