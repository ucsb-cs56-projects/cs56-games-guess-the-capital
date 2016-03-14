# cs56-games-guess-the-capital
A command line 'Guess the Capital Game' where a player will be presented with either a random state or a random country and asked to guess that state's or country's capital from 4 choices: 3 random choices and 1 correct choice. If the player is correct they will be awarded points. No state or country is repeated during a single play of the game. The game duration is either 10 states/counries or 50 states/countries. The total number of points and a grade will be shown at the end of the game.

* javadoc link: http://www.cs.ucsb.edu/~yukelele/cs56/cs56/S12/issues/0000768/javadoc


## Run the Game

Make sure that you are in the cs56-games-guess-the-capital directory 

```sh
$ ant run 
```


## High Level Description 

By typing 'ant run' in the command line, the compiler will run Game class that has all of the methods and performances to run the actual 'Guess-the-Capital-Game'. 
By typing 'ant test' in the command line, the compiler will run GameTest class that will use JUnit test to test most of the methods in Game class. It will check the end boundaries of those methods' functionality (both failure and success).

  
## Description of the files/directories

- W16_lab05.md and W16_lab07.md are the answers for the questions in lab05. 
- lib subdirectory holds the junit-4.8.2.jar file, which is esstential to perform the JUnit test for GameTest class. 
- buil.xml contains all of the ant targets' implementations. 
- src subdirectory holds Game.java and GameTest.java files, including all of the neccessary text files to play the game. 
- build subdirectory holds the compiled verison of Game.java and GameTest.java, including all of the nexxessary text files to play the game. 


## Project History 

```sh
W16 | yukelele 5pm | Yuki Mano | Guess the Capital Game
```


## W16 Final Remarks

   Running the Game.java file allows the user to play a command line game called "Guess the Capital Game." The game will give the user a choice to pick which game mode to play and ask the number of questions he/she wants to play. Each question will provide 4 different capitals' name, and the user must pick the correct capital correspond to the given US states or the world countries in order to earn points toward the total score. After the game is played, the code will provide the total score for that game and will give the user the test grade based on his/her test performance.
   Running the GameTest.java provides a test to some methods in the Game.java file by using junit. The GameTest.java file is setted up to have intial values for each of those methods, so each method is independently tested. 
  
   At this point of code, the features that I can think of are only expanding the game. In other words, the game can have a mode of testing capitals in certain countries such as Africa and Asia. Beside those features, another one can be adding a GUI into a game, so the game does not have to be played on the command line. If GUI is added into the game, then further features can be easily added. 

   A possible refactoring I see is that few of the methods can possibly be simply. Furthermore, javadoc comments can be worded better.

   The only bug I see so far is that running the junit test for compareAnswer() will sometime result an Error. (Within around 4 'ant test' or less, the Error will show up.)
```sh
$ Testcase: testCompareAnswer took 0.006 sec
$	 Cause an ERROR
$ / by zero
$ java.lang.ArithmeticException: / by zero
$   at edu.ucsb.cs56.S12.esterkin.Game.compareAnswer(Game.java:305)
$   at edu.ucsb.cs56.S12.esterkin.GameTest.testCompareAnswer(GameTest.java:101)

```