/** Contains the information for capitals in our game.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */

package edu.ucsb.cs56.projects.games.guess_the_capitals;

public class Capital {
	private String capitalName;

	Capital() {
		this.capitalName = "Capital";
	}

	Capital(String capitalName) {
		this.capitalName = capitalName;
	}

	public String getName() { return this.capitalName; }

        public boolean equals(Capital capital){
	    return this.getName().equals(capital.getName());
	}
	

}
