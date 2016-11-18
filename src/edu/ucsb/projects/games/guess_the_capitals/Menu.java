/**
 * Menu object designed to print statements and handle input from the
 * user as the game progresses
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */

package edu.ucsb.cs56.projects.games.guess_the_capitals;
import java.io.*;
import java.util.ArrayList;

public abstract class Menu{

    /** Abstract method for printing menus throughout the game,
     *  to be implemented in classes that extend Menu
     */
    public abstract void printMenu(MenuData menuData); 
    
}
