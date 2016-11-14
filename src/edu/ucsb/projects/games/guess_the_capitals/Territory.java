/**
 * Contains the data for the territories in our game.
 *
 * @author Sean Shelton, Armin Mahini
 * @version for UCSB CS56, F16  
 */

package edu.ucsb.cs56.projects.games.guess_the_capitals;

public class Territory {

	private String territoryName;
	private Capital capital;

	Territory() {
		this.territoryName = "Territory";
		capital = new Capital();
	}

	Territory(String capitalName, String territoryName) {
		capital = new Capital(capitalName);
		this.territoryName = territoryName;
	}

	public String getName() { return this.territoryName; }
	public Capital getCapital() { return this.capital; }
}
