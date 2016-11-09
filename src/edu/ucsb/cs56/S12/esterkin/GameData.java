/**
 * Holds all of the data for the game
 *
 * Also contains the question, and can determine whether or not an answer
 * is right or wrong.
 *
 * @author Sean Shelton, Armin Mahini
 * @version for UCSB CS56, F16  
 */

import java.util.Observable;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameData extends Observable {
	// TODO: Maybe consider making GameData a static singleton?

	/**
	 * Maps all of the capitals to their territories.
	 * (e.g. HashMap<Capital, Territory>())
	 *
	 * A territory is either a state or a country, and the capitals should be mapped
	 * to their respective state or country.
	 */

	// Might want to consider making locationHashMap a JSON instead of a HashMap.
	private HashMap locationHashMap = new HashMap<Capital, Territory>();

	/** Singleton instance
	 */
	private static GameData instance = new GameData();

	/**
 	 *  File path for location of data
 	 */
	private final static String filePath = "build/edu/ucsb/cs56/S12/esterkin/";

	/** 
	 * Question's territory for the game (so this is either a state or country).
	 * 
	 * This is used to determine whether or not an answer is correct,
	 * and has its own getter and setter.
	 *
	 * The controller can set the questionTerritory by putting in a capital, and then
	 * the questionTerritory will be the territory that the capital maps to in the HashMap.
	 */

	//TODO: Made SessionModel, probably don't need questionTerritory
	//private Territory questionTerritory;

	//private int numOfQuestions;

	private GameData() {
		// not sure what to have for default constructor yet,
		// maybe default to the states HashMap?
		File capitalsFile = new File(filePath + "capitals.txt");
		File statesFile = new File(filePath + "states.txt");
		locationHashMap = createGameMap(capitalsFile, statesFile);

		//setQuestion(getTerritory(random capital));
	}

	private GameData(File capitalsFile, File territoriesFile) {
		locationHashMap = createGameMap(capitalsFile, territoriesFile);
	}

	public static GameData getInstance(){
		return instance;
	}

	/*GameData(HashMap setType) {
		locationHashMap = setType;
		//setQuestion(getTerritory(random capital));
	}*/

	/**
	 * Gets the territory that a capital maps to.
	 * Asserts that the capital provided is within the HashMap.
	 * @param capital Capital of some territory.
	 */
	public Territory getTerritory(Capital capital) {  
		assert(locationHashMap.containsKey(capital));
		return (Territory)locationHashMap.get(capital);
	}

	/**
	 * Returns the HashMap in GameData (Capitals to Territories)
	 */
	public HashMap<Capital, Territory> getHashMap() {
		return locationHashMap;
	} 

	/** 
	 * Sets locationHashMap to hashMap
	 *
	 * @param hashMap A hashMap that maps Capitals to Territories, and Capitals should match
	 * their territories.
	 */
	public void setHashMap(HashMap<Capital, Territory> hashMap) {
		this.locationHashMap = hashMap;
	}

	/**
	 * Checks if a given capital is the answer to the current question.
	 * @param answer Capital of some territory, answer to the question.
	 * @return True if capital is the correct answer, false otherwise.
	 */
	//public boolean checkAnswer(Capital answer) { return getQuestionTerritory() == getTerritory(answer); }

	// Still need a method to create our HashMap.
	//
	// Thinking of making an array of capitals from the capitals file, then
	// an array of territories from the second file, then mapping them 
	// together for our HashMap.
	
	public static HashMap createGameMap(File capitalsFile, File territoriesFile) {
		HashMap<Capital, Territory> gameHash = new HashMap<Capital, Territory>();

		try {
			// create strings to store input from files
			String capitalLine;
			String territoryLine; 

			// create file readers for the capitals/territories
			BufferedReader capitalsReader = 
				new BufferedReader(new FileReader(capitalsFile));
			BufferedReader territoriesReader = 
				new BufferedReader(new FileReader(territoriesFile));

			// create capitals and territories to fill the HashMap
			while ((capitalLine =  capitalsReader.readLine()) != null &&
					(territoryLine = territoriesReader.readLine()) != null) {
				gameHash.put(new Capital(capitalLine), new Territory(capitalLine, territoryLine));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}



		return gameHash;
	}

	// Still need to add all of the Observable methods. 
}
