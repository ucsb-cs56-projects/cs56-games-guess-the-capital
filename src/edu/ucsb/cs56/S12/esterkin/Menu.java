/**
 * Model that keeps track of the current session.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */

import java.io.*;

public abstract class Menu{
    
    /**
     * Place to keep all the choices a user can make give the menu they're at
     */
    protected ArrayList<Choice> choices = new ArrayList<Choice>();

  
    public abstract void printMenu();

    
    
}
