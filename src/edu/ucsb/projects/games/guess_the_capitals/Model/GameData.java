
package edu.ucsb.cs56.projects.games.guess_the_capitals;

import java.util.Observable;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Holds all of the data for the game
 *
 * Also contains the question, and can determine whether or not an answer
 * is right or wrong.
 *
 * @author Sean Shelton, Armin Mahini
 * @version for UCSB CS56, F16  
 */
public class GameData extends Observable {
	// TODO: Maybe consider making GameData a static singleton?

	// Might want to consider making locationHashMap a JSON instead of a HashMap.
	//private HashMap locationHashMap = new HashMap<Capital, Territory>();


    //trying to implement HashMap refactoring here
    private HashMap<String, ArrayList> games = new HashMap<String, ArrayList>();
    private String names[] = {"US", "North America", "South America",
			      "Europe", "Asia", "Africa", "Australia",
			      "World", "All"};

	/**
	 *  File path for location of data
	 */
	private final static String filePath = "build/edu/ucsb/cs56/projects/games/guess_the_capitals/";

	public static String getFilePath() {
		return filePath;
	}



	/** Singleton instance to restrict instantiaion since we'll be using this GameData
	 *  object across the whole game
	 */
	private static GameData instance = new GameData();

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
		File africaCountriesFile = new File(filePath + "africaCountries.txt");
		File africaCapsFile = new File(filePath + "africaCaps.txt");
		File asiaCountriesFile = new File(filePath + "asiaCountries.txt");
		File asiaCapsFile = new File(filePath + "asiaCaps.txt");
		File australiaCountriesFile = new File(filePath + "australiaCountries.txt");
		File australiaCapsFile = new File(filePath + "australiaCaps.txt");
		File europeCountriesFile = new File(filePath + "europeCountries.txt");
		File europeCapsFile = new File(filePath + "europeCaps.txt");
		File northAmCountriesFile = new File(filePath + "northAmCountries.txt");
		File northAmCapsFile = new File(filePath + "northAmCaps.txt");
		File southAmCountriesFile = new File(filePath + "southAmCountries.txt");
		File southAmCapsFile = new File(filePath + "southAmCaps.txt");
		File worldCapitalsFile = new File(filePath + "worldcapitals.txt");
		File worldCountriesFile = new File(filePath + "worldcountries.txt");

		//loading all files in an array refactoring
		//File directory = new File(filePath);
		//File[] gameFiles = directory.listFiles();
		
		// private final int US_GAME = 0
		// hashMap.put(US_GAME, usGameLocations
		ArrayList<Territory> usGame = createGameLocations(capitalsFile, statesFile);
		ArrayList<Territory> africaGame = createGameLocations(africaCapsFile, africaCountriesFile);
		ArrayList<Territory> asiaGame = createGameLocations(asiaCapsFile, asiaCountriesFile);
		ArrayList<Territory> australiaGame = createGameLocations(australiaCapsFile, australiaCountriesFile);
		ArrayList<Territory> europeGame = createGameLocations(europeCapsFile, europeCountriesFile);
		ArrayList<Territory> northAmGame = createGameLocations(northAmCapsFile, northAmCountriesFile);
		ArrayList<Territory> southAmGame = createGameLocations(southAmCapsFile, southAmCountriesFile);
		ArrayList<Territory> worldGame = createGameLocations(worldCapitalsFile, worldCountriesFile);
		ArrayList<Territory> allGame = new ArrayList<Territory>();
		allGame.addAll(usGame);
		allGame.addAll(worldGame);

		//adding HashMap implementation here
		games.put("US", usGame);
		games.put("Africa", africaGame);
		games.put("Australia", australiaGame);
		games.put("Europe", europeGame);
		games.put("North America", northAmGame);
		games.put("South America", southAmGame);
		games.put("World", worldGame);
		games.put("All", allGame);

	}


    /** Returns instance of singleton GameData
	 *  @return instance of GameData object
	 */
	public static GameData getInstance(){
		return instance;
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
				gameLocations.add(new Territory(capitalLine, territoryLine));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}



		return gameLocations;
	}

    //using the HashMap to get the ArrayList
	public ArrayList getGame(int gameKey) {
	    return games.get(names[gameKey]);
	}
	

}
