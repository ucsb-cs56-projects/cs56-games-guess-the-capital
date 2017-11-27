package edu.ucsb.cs56.projects.games.guess_the_capitals;

import java.util.Observable;
import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.util.Collections;


/**
 * Model that keeps track of the current session.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
public class SessionModel extends Observable{

	/**
	 * The set of locations for current game
	 */
	private ArrayList<Territory> locations = new ArrayList<Territory>();


	private final static String filePath = "build/edu/ucsb/cs56/projects/games/guess_the_capitals/";

	/**
	 * Current Territories used as question
	 */
	private ArrayList<Territory> answerTers = new ArrayList<Territory>();

	/**
     * Represents number of questions in the current session
     */
    private int numQuestions;

	/**
	 * Current question number
	 */
	private int questionNum;

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

    }

    /** Constructor for a session of the game. Like the one above, sets number of questions to 10,
     *  creates an  empty ArrayList and clears it.
     *  @param gameData gameData allows this SessionModel to access a particular list of capitals
     *  and terroritories depending on which selections the user has made.
     */
	SessionModel(GameData gameData) {
		this.gameData = gameData;
		numQuestions = 10;
		numChoices = 4;
        possibleAnswers = new ArrayList<Territory>();
		possibleAnswers.clear();
	}

    /**
     * Returns true if the capital guessed by the player is correct,
     * otherwhise returns false
     * @param guess represents the user's guess
     * @return true if guess is correct, else return false
     */
    public boolean checkAnswer(int guess){
		return possibleAnswers.get(guess).getName() == answerTerritory.getName();
    }

    /**
     * Sets the number of questions to the user's input
     * @param numQuestions represents the user's desired number of questions
     */
    public void setNumQuestions(int numQuestions){
		this.numQuestions = numQuestions;
		setChanged();
		notifyObservers();
    }

    /**
     * @return number of questions in the current session
     */
    public int getNumQuestions(){
		return numQuestions;
    }

    /** Sets the number of questions to 10, 50, or a custom number selected by the user
     * @param questionNum is number of questions indicated by the user
     */
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
		setChanged();
		notifyObservers();
	}

    /**
     * @return the current question number
     */
	public int getQuestionNum() {
		return this.questionNum;
	}

    /**
     * Sets the number of correct answers in the current session
     * @param numCorrect represents the number of correct answers
     */
    public void setNumCorrect(int numCorrect){
		this.numCorrect = numCorrect;
		setChanged();
		notifyObservers();
    }

    /**
     * @return  number of correct answers in the current session
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
		setChanged();
		notifyObservers();
    }

    /**
     * @return the user's grade
     */
    public double getGrade(){
		return grade;
    }

	/**
	 *	Changes the number of choices to play the game with.
	 *	(e.g. having to guess between 6 choices instead of the usual 4)
	 * @param numChoices represents number of options the user can pick from
	 */
	public void setNumChoices(int numChoices) {
		this.numChoices = numChoices;
		setChanged();
		notifyObservers();
	}

	/**
	 *  @return number of choices for this session of the game
	 */
	public int getNumChoices() {
		return this.numChoices;
	}

    /**
	 * @return the possible answers for the question
	 */
	public ArrayList<Territory> getPossibleAnswers() {
		return possibleAnswers;
	}

    /**
     * @return the Territory for which the Capital belongs to
     */
	public Territory getAnswerTerritory() {
		return answerTerritory;
	}

	/**
	 * set locations to the one GameController (the user) specifies
	 * @param locations
	 */
	public void setLocations(ArrayList<Territory> locations) {
		this.locations = locations;
	}

	public void setLocations(File capitalsFile, File territoriesFile) {
		locations = GameData.createGameLocations(capitalsFile, territoriesFile);
	}

	/**
	 * print hint for current question
	 */
	public void printHint(){
		for (int i=0; i < possibleAnswers.size(); i++){
			if(possibleAnswers.get(i) != answerTerritory){
				System.out.println("The answer is not " + possibleAnswers.get(i).getCapital().getName());
				return;
			}
		}
	}

	/**
	 * Changes the possible answers to a random set of capitals
	 */
	public void updateCurrentQuestion(){

		System.out.print("sdfs");
		// clear current set of answers
		possibleAnswers.clear();

		// Creating r to be our random number generator
		Random r = new Random();

		// Making an ArrayList of locations to make the question
		ArrayList<Territory> totalData = locations;
		Territory t = new Territory();

		/**
		boolean terUsed = true;
		while(terUsed){
			t = totalData.get(r.nextInt(totalData.size()));
			for(Territory ter : answerTers){
				if(t != ter){
					possibleAnswers.add(t);
					answerTerritory = t;
					terUsed = false;
				}
			}
		}
		 **/

		//pick random answer # to be the answer
		int answerNum = r.nextInt(numChoices);

		//prevent duplicates with possibleAnswers
		for (int i = 0; i < numChoices; ++i) {
			boolean contains = false;
			boolean terUsed = true;

			// Set t equal to some random territory
			t = totalData.get(r.nextInt(totalData.size()));

			for(Territory ter : possibleAnswers){
				if (t == ter){
					contains = true;
				}
			}

			if(contains){
				i--;
			}

			if(i==answerNum){

				if(!answerTers.contains(t)){
					answerTers.add(t);
					possibleAnswers.add(t);
					terUsed = false;
				}

				if(terUsed == true){
					i--;
				}
			}

			else {
				possibleAnswers.add(t);
			}
		}

		//Collections.shuffle(possibleAnswers);
		answerTerritory = possibleAnswers.get(answerNum);

		setChanged();
		notifyObservers();
	}

    /** Sets the number of questions, correct answers and grade to their default users to get the game ready
     * for the next session to be played
     */
	public void reset() {
		this.numQuestions = 10;
		this.numCorrect = 0;
		this.grade = 0;
		setChanged();
		notifyObservers();
	}



}
