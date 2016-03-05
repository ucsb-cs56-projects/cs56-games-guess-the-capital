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
    test two lists of ArrayList merge into one big ArrayList by comparing its size
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
   test to see if readFile() reads, parses text document, and stores the data into an ArrayList of size of the text file that was read
   @see Game#readFile
*/ 
    @Test public void testReadFile()
    {
	Game g = new Game();
	ArrayList<String> testlist = g.readFile("build/edu/ucsb/cs56/S12/esterkin/states.txt");
	assertEquals(testlist.size(),50);
    }


/**
   test to see if ChooseRandomStateorCountry() gets an random index from the ArrayList, and that index must be within the ArrayList's size
   @see Game#ChooseRandomStateorCountry
 */
    @Test public void testChooseRandomStateorCountry()
    {
	Game g = new Game();
	ArrayList<String> testlist1 = g.readFile("build/edu/ucsb/cs56/S12/esterkin/states.txt");
	ArrayList<String> testlist2 = g.readFile("build/edu/ucsb/cs56/S12/esterkin/states.txt");
	int index_randomState = g.ChooseRandomStateorCountry(testlist1, testlist2);
	for(int i=0; i<testlist1.size(); i++){
	    if(i == index_randomState)
		assertEquals(i, index_randomState);
	}
    }


/**
   test to see if generate4Capitals() creates an ArrayList of 4 String objects
   @see Game#generate4Capitals
*/     
    @Test public void testGenerate4Capitals()
    {    
	Game g = new Game();
	ArrayList<String> testlist = g.generate4Capitals(10, g.readFile("build/edu/ucsb/cs56/S12/esterkin/worldcountries.txt"));
	assertEquals(testlist.size(),4);
    }
    

/**
   test to see if compareAnswer() prints out whether the answer choice is correct or wrong
   @see Game#compareAnswer
 */
    @Test public void testCompareAnswer()
    {
	Game g = new Game();
	g.setCorrectcapital("Honolulu");
	g.setGuessChoice_int(2);
	ArrayList<String> testlist = new ArrayList<String>();
	testlist.add("Honolulu");
	testlist.add("Sacramento");
	testlist.add("Indianapolis");
	testlist.add("Boston");
	ArrayList<String> tl = g.generate4Capitals(2, testlist);
	assertEquals(g.compareAnswer(), "Wrong!");
    }


/**
   test to see if Grade() converts a total score to the appropriate grade
   @see Game#grade
 */
@Test public void testGrade1()
    {   
    Game g = new Game();
    g.setScore(0);
    assertEquals("F", g.grade());
    }

/**
   test to see if Grade() converts a total score to the appropriate grade
   @see Game#grade
*/
    @Test public void testGrade2()
    {
	Game g = new Game();
	g.setScore(100);
	assertEquals("A+", g.grade());
    }

/**
   test to see if Grade() converts a total score to the appropriate grade
   @see Game#grade
*/
    @Test public void testGrade3()
    {
	Game g = new Game();
	g.setScore(72);
	assertEquals("C-", g.grade());
    }
    
}
