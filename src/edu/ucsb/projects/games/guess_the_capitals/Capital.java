/** Contains the information for capitals in our game.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */

package edu.ucsb.cs56.projects.games.guess_the_capitals;

public class Capital {
	private String capitalName;

        /** Default constructor for a Capital object, name is auotmatically set to "Capital"
         *
	 */
	Capital() {
		this.capitalName = "Capital";
	}

        /** Constructor for a Capital object, name is set to whatever the user passes through
         *
	 */
	Capital(String capitalName) {
		this.capitalName = capitalName;
	}

        /** Returns the name of the capital in question
	 *  @return Capital's name
	 */
        public String getName() { return this.capitalName; }
    
        /** Indicates whether some other Capital is "equal to" this one. 
         *  @param capital will be compared to another Capital object
         *  @return true if Capital objects are equal, else return false
	 */
        public boolean equals(Capital capital){
	    return this.getName().equals(capital.getName());
	}
	

}
