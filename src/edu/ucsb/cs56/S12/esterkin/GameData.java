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
import java.util.ArrayList;

public class GameData extends Observable {
	// TODO: Maybe consider making GameData a static singleton?

	/**
	 * Creates an ArrayList of Territories, which has the capitals inside
	 * (e.g. ArrayList<Territory>(), each territory has a capital within it)
	 *
	 * A territory is either a state or a country, and the capitals should be mapped
	 * to their respective state or country.
	 */

	// Might want to consider making locationHashMap a JSON instead of a HashMap.
	//private HashMap locationHashMap = new HashMap<Capital, Territory>();
	private ArrayList<Territory> locations = new ArrayList<Territory>();
	private ArrayList<Territory> usGame = new ArrayList<Territory>();
	private ArrayList<Territory> worldGame = new ArrayList<Territory>();
	private ArrayList<Territory> allGame = new ArrayList<Territory>();

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
		File worldCapitalsFile = new File(filePath + "worldcapitals.txt");
		File worldCountriesFile = new File(filePath + "worldcountries.txt");

		usGame = createGameLocations(capitalsFile, statesFile);
		worldGame = createGameLocations(worldCapitalsFile, worldCountriesFile);
		allGame = createGameLocations(capitalsFile, statesFile);
		allGame.addAll(worldGame);
		setLocations(usGame);
		//locations =  usGame;
		//usGame = createGameLocations(capitalsFile, statesFile);

		//setQuestion(getTerritory(random capital));
	}

	private GameData(File capitalsFile, File territoriesFile) {
		//locationHashMap = createGameMap(capitalsFile, territoriesFile);
		locations = createGameLocations(capitalsFile, territoriesFile);
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
	//public Territory getTerritory(Capital capital) {
		
		//assert(locationHashMap.containsKey(capital));
		//return (Territory)locationHashMap.get(capital);
	//}

	/**
	 * Returns the HashMap in GameData (Capitals to Territories)
	 */
	public ArrayList<Territory> getLocations() {
		return locations;
	} 

	/** 
	 * Sets the object's ArrayList of locations to a new ArrayList.
	 *
	 * @param locations An ArrayList that contains all of the Territories, with their Capitals inside.
	 * 
	 */
	public void setLocations(ArrayList<Territory> locations) {
		this.locations = locations;
	}

	/** Creates an ArrayList of territories based on the capitals and territories files.
	 *	In the file, the lines should match between the capitals and the territories.
	 *
	 * @param capitalsFile is the file with the capitals.
	 * @param territoriesFile is the file with the territories.
	 */
	public static ArrayList<Territory> createGameLocations(File capitalsFile, File territoriesFile) {
		ArrayList<Territory> gameLocations = new ArrayList<Territory>();
		gameLocations.clear();

		try {
			// create strings to store input from files
			String capitalLine;
			String territoryLine; 

			// create file readers for the capitals/territories
			BufferedReader capitalsReader = 
				new BufferedReader(new FileReader(capitalsFile));
			BufferedReader territoriesReader = 
				new BufferedReader(new FileReader(territoriesFile));

			// create capitals and territories to fill the ArrayList
			while ((capitalLine =  capitalsReader.readLine()) != null &&
					(territoryLine = territoriesReader.readLine()) != null) {
				//gameHash.put(new Capital(capitalLine), new Territory(capitalLine, territoryLine));
				gameLocations.add(new Territory(capitalLine, territoryLine));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}



		//return gameHash;
		return gameLocations;
	}

	// Still need to add all of the Observable methods. 
}
