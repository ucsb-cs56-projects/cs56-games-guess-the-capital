/**
 * Model that keeps track of the current session.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
import java.util.Observable;
import java.util.ArrayList;
import java.util.Random;

public class SessionModel extends Observable{
    
    /**
     * Represents number of questions in the current session
     */
    private int numQuestions;
    
    /**
     * Represents number of correct answers in the current session
     */
    private int numCorrect = 0;
    
    /**
     * Represents final grade of the current session
     */
    private double grade = 0;

	/**
	 * The number of choices available to pick from in the multiple choice game.
	 */ 
	private int numChoices;
    
    /**
     * Represents answers for each question in the current session
     */
    private ArrayList<Territory> possibleAnswers;

	/**
	 *	Current answer for the question
	 */
	private Territory answerTerritory;

	/** 
	 * Singleton GameData class used for generating questions/answers
	 */
	GameData gameData = GameData.getInstance();

    /**
     * Constructor for a session of the game, by default sets 
     * number of questions to 10. Makes an empty ArrayList and
     * clears it just to be safe
     */
    SessionModel() {
		numQuestions = 10;
		numChoices = 4;
        possibleAnswers = new ArrayList<Territory>();
		possibleAnswers.clear();
		updateCurrentQuestion();
	//questionTerritories
        //territoryOfQuestion = new Territory();
    }

    /**
     * Returns true if the capital guessed by the player is correct,
     * otherwhise returns false
     * @param guess represents the user's guess
     * @param questionNumber represents the number of the question the
     * user is currently on
     */
    public boolean checkAnswer(int guess){
		return possibleAnswers.get(guess).getName() == answerTerritory.getName();
		//return guess.getName() == answerTerritory.getCapital().getName();
		//return possibleAnswers.get(questionNumber-1) == guess;
    }

    /**
     * Sets the number of questions to the user's input
     * @param numQuestions represents the user's desired number of questions
     */
    public void setNumQuestions(int numQuestions){
		this.numQuestions = numQuestions;
    }
    
    /**
     * Returns the number of questions in the current session
     */
    public int getNumQuestions(){
		return numQuestions;
    }
    
    /**
     * Sets the number of correct answers in the current session
     * @param numCorrect represents the number of correct answers 
     */
    public void setNumCorrect(int numCorrect){
		this.numCorrect = numCorrect;
    }

    /**
     * Returns the number of correct answers in the current session
     */
    public int getNumCorrect(){
		return numCorrect;
    }

    /**
     * Sets the user's grade of their performance in the current session
     * @param grade represents the user's grade based on the number of correct responses 
     */
    public void setGrade(double grade){
		this.grade = grade;
    }

    /**
     * Returns the user's grade
     */
    public double getGrade(){
		return grade;
    }

	/**
	 *	Changes the number of choices to play the game with.
	 *	(e.g. having to guess between 6 choices instead of the usual 4)
	 */
	public void setNumChoices(int numChoices) {
		this.numChoices = numChoices;
	}

	/**
	 *	Gets the number of choices
	 */
	public int getNumChoices() {
		return this.numChoices;
	}

	public ArrayList<Territory> getPossibleAnswers() {
		return possibleAnswers;
	}

	/**
	 * Changes the possible answers to a random set of capitals
	 */
	public void updateCurrentQuestion(){
		// clear current set of answers
		possibleAnswers.clear();

		// Creating r to be our random number generator
		Random r = new Random();

		// Making an ArrayList of locations to make the question
		ArrayList<Territory> totalData = gameData.getLocations();
		Territory t = new Territory();

		for (int i = 0; i < numChoices; ++i) {
			// Set t equal to some random territory
			t = totalData.get(r.nextInt(totalData.size()));
			possibleAnswers.add(t);
		}

		// Choose a possible answer to actually be the answer
		answerTerritory = possibleAnswers.get(r.nextInt(numChoices));

		//gameData.getLocations.get(r.nextInt(
		
	}
    
    /*
    public void setTerritory(Capital capital){
	
    }*/

    
    
}
