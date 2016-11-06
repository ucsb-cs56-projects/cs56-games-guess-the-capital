/**
 * Model that keeps track of the current session.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
import java.util.Observable;
import java.util.ArrayList;

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
    
    //private Territory territoryOfQuestion;
    
    //private Territory[] questionTerritories;
    
    /**
     * Represents answers for each question in the current session
     */
    private ArrayList<Capital> answers;

    /**
     * Constructor for a session of the game, by default sets 
     * number of questions to 10. Makes an empty ArrayList and
     * clears it just to be safe
     */
    SessionModel() {
	numQuestions = 10;
        answers = new ArrayList<Capital>();
	answers.clear();
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
    public boolean checkAnswer(Capital guess, int questionNumber){
		return answers.get(questionNumber-1) == guess;
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
    
    /*
    public void setTerritory(Capital capital){
	
    }*/

    
    
}
