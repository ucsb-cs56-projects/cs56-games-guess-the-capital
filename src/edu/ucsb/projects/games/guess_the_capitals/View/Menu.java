package edu.ucsb.cs56.projects.games.guess_the_capitals;
import java.io.*;
import java.util.ArrayList;

/**
 * Menu object designed to print statements and handle input from the
 * user as the game progresses
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */

public abstract class Menu{

    /** Abstract method for printing menus throughout the game,
     *  to be implemented in classes that extend Menu
     *  @param menuData contains information such as the number of possible choices, 
     *  question number and Territory and Capital objects
     */
    public abstract void printMenu(MenuData menuData); 
    
}
