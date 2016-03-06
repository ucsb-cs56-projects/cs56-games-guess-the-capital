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