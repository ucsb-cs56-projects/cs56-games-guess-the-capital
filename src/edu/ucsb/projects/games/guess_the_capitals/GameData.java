
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

	// TODO: remove locations from GameData and move the logic of setting the current
	// set of locations to SessionModel
	//private ArrayList<Territory> locations = new ArrayList<Territory>();
	private ArrayList<Territory> usGame = new ArrayList<Territory>();
    private ArrayList<Territory> northAmGame = new ArrayList<Territory>();
    private ArrayList<Territory> southAmGame = new ArrayList<Territory>();
    private ArrayList<Territory> europeGame = new ArrayList<Territory>();
    private ArrayList<Territory> asiaGame = new ArrayList<Territory>();
    private ArrayList<Territory> africaGame = new ArrayList<Territory>();
    private ArrayList<Territory> australiaGame = new ArrayList<Territory>();
	private ArrayList<Territory> worldGame = new ArrayList<Territory>();
	private ArrayList<Territory> allGame = new ArrayList<Territory>();

	/**
	 *  File path for location of data
	 */
	private final static String filePath = "build/edu/ucsb/cs56/projects/games/guess_the_capitals/";

	public static String getFilePath() {
		return filePath;
	}


	//get rid of all the get() with this?
	static File capitalsFile = new File(getFilePath() + "capitals.txt");
	static File statesFile = new File(getFilePath() + "states.txt");
	static File africaCountriesFile = new File(getFilePath() + "africaCountries.txt");
	static File africaCapsFile = new File(getFilePath() + "africaCaps.txt");
	static File asiaCountriesFile = new File(getFilePath()+ "asiaCountries.txt");
	static File asiaCapsFile = new File(getFilePath() + "asiaCaps.txt");
	static File australiaCountriesFile = new File(getFilePath() + "australiaCountries.txt");
	static File australiaCapsFile = new File(getFilePath() + "australiaCaps.txt");
	static File europeCountriesFile = new File(getFilePath() + "europeCountries.txt");
	static File europeCapsFile = new File(getFilePath() + "europeCaps.txt");
	static File northAmCountriesFile = new File(getFilePath() + "northAmCountries.txt");
	static File northAmCapsFile = new File(getFilePath() + "northAmCaps.txt");
	static File southAmCountriesFile = new File(getFilePath() + "southAmCountries.txt");
	static File southAmCapsFile = new File(getFilePath() + "southAmCaps.txt");
	static File worldCapitalsFile = new File(getFilePath() + "worldcapitals.txt");
	static File worldCountriesFile = new File(getFilePath() + "worldcountries.txt");

	//private ArrayList<Level> = new ArrayList<Level>();
	// In the constructor, load these ^^^

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

		usGame = createGameLocations(capitalsFile, statesFile);
		africaGame = createGameLocations(africaCapsFile, africaCountriesFile);
		asiaGame = createGameLocations(asiaCapsFile, asiaCountriesFile);
		australiaGame = createGameLocations(australiaCapsFile, australiaCountriesFile);
		europeGame = createGameLocations(europeCapsFile, europeCountriesFile);
		northAmGame = createGameLocations(northAmCapsFile, northAmCountriesFile);
	    southAmGame = createGameLocations(southAmCapsFile, southAmCountriesFile);
		worldGame = createGameLocations(worldCapitalsFile, worldCountriesFile);
		allGame = new ArrayList<Territory>();
		allGame.addAll(usGame);
		allGame.addAll(worldGame);
		//SessionModel.setLocations(usGame);
		//locations =  usGame;
		//usGame = createGameLocations(capitalsFile, statesFile);
		//setQuestion(getTerritory(random capital));
	}

    /** Constructs a newly allocated GameData object that passes in a file of  capitals and file of 
	 *  territories for the specific game the user has selected to play.
	 *  This might be unused (?)
	 *  @param capitalsFile is the file with the capitals.
	 *  @param territoriesFile is the file with the territories.
	 *
     */
	private GameData(File capitalsFile, File territoriesFile) {
		//SessionModel.setlocations(createGameLocations(capitalsFile, territoriesFile));
	}
    
    /** Returns instance of singleton GameData
	 *  @return instance of GameData object
	 */
	public static GameData getInstance(){
		return instance;
	}


        /**
	 * @return Returns the list of Territory objects in a US capitals game (ArrayList of Territories with Capitals inside)
	 */
	public ArrayList<Territory> getUSGame() {
		return usGame;
	}

        /**
	 * @return Returns the list of Territory objects in a North American capitals game (ArrayList of Territories with Capitals inside)
	 */
	public ArrayList<Territory> getNorthAmGame() {
		return northAmGame;
	}

        /**
	 * @return Returns the list of Territory objects in a South American capitals game (ArrayList of Territories with Capitals inside)
	 */
	public ArrayList<Territory> getSouthAmGame() {
		return southAmGame;
	}

        /**
	 * @return Returns the list of Territory objects in a European capitals game (ArrayList of Territories with Capitals inside)
	 */
	public ArrayList<Territory> getEuropeGame() {
		return europeGame;
	}

        /**
	 * @return Returns the list of Territory objects in an Asian capitals game (ArrayList of Territories with Capitals inside)
	 */
	public ArrayList<Territory> getAsiaGame() {
		return asiaGame;
	}

        /**
	 * @return Returns the list of Territory objects in an African capitals game (ArrayList of Territories with Capitals inside)
	 */
	public ArrayList<Territory> getAfricaGame() {
		return africaGame;
	}

     /**
	 * @return Returns the list of Territory objects in an Australian capitals game (ArrayList of Territories with Capitals inside)
	 */
	public ArrayList<Territory> getAustraliaGame() {
		return australiaGame;
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
	/*
	public void setLocations(ArrayList<Territory> locations) {
		this.locations = locations;
	}
	*/

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
