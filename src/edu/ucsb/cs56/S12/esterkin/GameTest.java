package edu.ucsb.cs56.S12.esterkin;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/**
 * The test class GameTest, to test the Game class
 *
 * @author Edward Sterkin
 * @version CS56, Spring 2012
 * @see#Game()
 */

public class GameTest 
{
    
/**
 test readFile() from Game
 @see Game#readFile()
*/
    
@Test public void testreadFile()
{
//test to see if readFile() reads, parses text document, and stores the data into an ArrayList of size 50
Game g = new Game();
ArrayList<String> testlist = g.readFile("states.txt");
assertEquals(testlist.size(),50);
}

/**
 test generate4Capitals() from Game
 @see Game#generate4Capitals()
 */
/*    
@Test public void testgenerate4Capitals()
{    
//test to see if generate4Capitals() creates an arraylist of 4 String objects
Game g = new Game();
ArrayList<String> testlist = g.generate4Capitals(10);
assertEquals(testlist.size(),4);
} */

/**
 test Grade() from Game
 @see Game#Grade()
 */

@Test public void testGrade()
{
//test to see if Grade() converts a total score to the appropriate grade    
Game g = new Game();
    g.setScore(40);
    assertEquals(g.grade(),"F");     
}    
    
}
