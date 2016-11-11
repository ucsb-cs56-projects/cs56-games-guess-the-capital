
public class RunText {

	public static void main(String[] args) {
		GameData gameData = GameData.getInstance();
		SessionModel sessionModel = new SessionModel(gameData);
		GameView gameView = new GameView();
		GameController controller = new GameController(sessionModel, gameView, gameData);

		controller.runGame();
	}

}
