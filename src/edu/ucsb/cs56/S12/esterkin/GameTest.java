package edu.ucsb.cs56.S12.esterkin;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/**
 * The test class GameTest, to test the Game class
 *
 * @author Edward Sterkin 
 * @author Yuki Mano
 * @version CS56, Winter 2016 (original version: CS56, Spring 2012)
 * @see Game
 */

public class GameTest 
{

    /**
       test two lists of ArrayList merge into one big ArrayList
    @see Game#addLists
    */
    @Test public void testAddLists()
    {
	Game g = new Game();
	ArrayList<String> testList1 = g.readFile("build/edu/ucsb/cs56/S12/esterkin/states.txt");
	ArrayList<String> testList2 = g.readFile("build/edu/ucsb/cs56/S12/esterkin/worldcountries.txt");
	ArrayList<String> testCombinedList = g.addLists(testList1, testList2);
	assertEquals(testCombinedList.size(), 246);
    }

  
/**
test to see if readFile() reads, parses text document, and stores the data into an ArrayList of size 50
@see Game#readFile
*/ 
    @Test public void testreadFile()
    {
	Game g = new Game();
	ArrayList<String> testlist = g.readFile("build/edu/ucsb/cs56/S12/esterkin/states.txt");
	assertEquals(testlist.size(),50);
    }


/**
test to see if generate4Capitals() creates an ArrayList of 4 String objects
@see Game#generate4Capitals()
*/     
    @Test public void testgenerate4Capitals()
    {    
	//test to see if generate4Capitals() creates an arraylist of 4 String objects
	Game g = new Game();
	ArrayList<String> testlist = g.generate4Capitals(10, g.readFile("build/edu/ucsb/cs56/S12/esterkin/worldcountries.txt"));
	assertEquals(testlist.size(),4);
    }
    

/**
 test Grade() from Game
 @see Game#grade()
 */

@Test public void testGrade()
    {
//test to see if Grade() converts a total score to the appropriate grade    
    Game g = new Game();
    g.setScore(62);
    assertEquals("D-", g.grade());
    }
    
}
