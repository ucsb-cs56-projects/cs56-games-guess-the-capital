/**
 * Model that keeps track of the current session.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */

import java.io.*;
import java.util.ArrayList;

public abstract class Menu{
    
    /**
     * Place to keep all the choices a user can make give the menu they're at
     */
    protected ArrayList<Choice> choices;
  
    public abstract void printMenu();

    public Menu(){
	choices = new ArrayList<Choice>();
    }
    
    
}
