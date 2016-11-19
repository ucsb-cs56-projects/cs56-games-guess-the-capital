/**
 * Holds all of the data for the game
 *
 * Also contains the question, and can determine whether or not an answer
 * is right or wrong.
 *
 * @author Sean Shelton, Armin Mahini
 * @version for UCSB CS56, F16  
 */

package edu.ucsb.cs56.projects.games.guess_the_capitals;
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

	// Might want to consider making locationHashMap a JSON instead of a HashMap.
	//private HashMap locationHashMap = new HashMap<Capital, Territory>();

	// TODO: remove locations from GameData and move the logic of setting the current
	// set of locations to SessionModel
	private ArrayList<Territory> locations = new ArrayList<Territory>();
	private ArrayList<Territory> usGame = new ArrayList<Territory>();
	private ArrayList<Territory> worldGame = new ArrayList<Territory>();
	private ArrayList<Territory> allGame = new ArrayList<Territory>();

	/** Singleton instance to restrict instantiaion since we'll be using this GameData 
	 *  object across the whole game
	 */
	private static GameData instance = new GameData();

	/**
 	 *  File path for location of data
 	 */
	private final static String filePath = "build/edu/ucsb/cs56/projects/games/guess_the_capitals/";

	/** Constructs a newly allocated GameData object that knows all the territories and capitals for the
	 *  US, world and both of those games.
	 *  The controller can set the questionTerritory by putting in a capital, and then
	 *  the questionTerritory will be the territory that the capital maps to in the HashMap.
	 */
	private GameData() {
		// not sure what to have for default constructor yet,
		// maybe default to the states HashMap?
		File capitalsFile = new File(filePath + "capitals.txt");
		File statesFile = new File(filePath + "states.txt");
		File worldCapitalsFile = new File(filePath + "worldcapitals.txt");
		File worldCountriesFile = new File(filePath + "worldcountries.txt");

		usGame = createGameLocations(capitalsFile, statesFile);
		worldGame = createGameLocations(worldCapitalsFile, worldCountriesFile);
		allGame = new ArrayList<Territory>();
		allGame.addAll(usGame); // createGameLocations(capitalsFile, statesFile);
		allGame.addAll(worldGame);
		setLocations(usGame);
		//locations =  usGame;
		//usGame = createGameLocations(capitalsFile, statesFile);
		//setQuestion(getTerritory(random capital));
	}

        /** Constructs a newly allocated GameData object that passes in a file of  capitals and file of 
	 *  territories for the specific game the user has selected to play.
	 *  @param capitalsFile is the file with the capitals.
	 *  @param territoriesFile is the file with the territories.
         */
	private GameData(File capitalsFile, File territoriesFile) {
		//locationHashMap = createGameMap(capitalsFile, territoriesFile);
		locations = createGameLocations(capitalsFile, territoriesFile);
	}
    
        /** Returns instance of singleton GameData
	 *  @return instance of GameData object
	 */
	public static GameData getInstance(){
		return instance;
	}

	/*GameData(HashMap setType) {
		locationHashMap = setType;
		//setQuestion(getTerritory(random capital));
	}*/


	/**
	 * Returns the locations in GameData (ArrayList of Territories with Capitals inside)
	 * @return ArrayList of Territories from GameData
	 */
	public ArrayList<Territory> getLocations() {
		return locations;
	}

        /**
	 * @return Returns the list of Territory objects in a US capitals game (ArrayList of Territories with Capitals inside)
	 */
	public ArrayList<Territory> getUSGame() {
		return usGame;
	}

        /**
	 * @return Territory objects in a World capitals game (ArrayList of Territories with Capitals inside)
	 */
	public ArrayList<Territory> getWorldGame() {
		return worldGame;
	}
    
        /**
	 * @return Territory objects in a game of US and World capitals game (ArrayList of Territories with Capitals inside)
	 */
	public ArrayList<Territory> getAllGame() {
		return allGame;
	}

	/** 
	 * Sets the object's ArrayList of locations to a new ArrayList.
	 * @param locations An ArrayList that contains all of the Territories, with their Capitals inside.
	 */
	public void setLocations(ArrayList<Territory> locations) {
		this.locations = locations;
	}

	/** Creates an ArrayList of territories based on the capitals and territories files.
	 *	In the file, the lines should match between the capitals and the territories.
	 *
	 * @param capitalsFile is the file with the capitals.
	 * @param territoriesFile is the file with the territories.
	 * @return list of locations to be used in a session of the game
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

}
