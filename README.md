# cs56-games-guess-the-capital
A command line 'Guess the Capital Game' where a player will be presented with either a random state or a random country and asked to guess that state's or country's capital from 4 choices: 3 random choices and 1 correct choice. If the player is correct they will be awarded points. No state or country is repeated during a single play of the game. The game duration is either 10 states/counries or 50 states/countries. The total number of points and a grade will be shown at the end of the game.

* javadoc link: https://ucsb-cs56-f17.github.io/cs56-games-guess-the-capital-javadoc/


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

## F16 final remarks
  Running the program via ant allows the user to play a command line version of the game "Guess the Capitals". The objective of the game, as the title implies, is to correctly guess the capital of the state or country in question. The user is prompted to select a game mode and then the number of questions they'd like to be quizzed on. The game then proceeds to offer 4 possible choices of capitals to choose from for the state or country in question. The game keeps track of the number of correct responses the user makes and display's the user's score in the form of a fraction (number of correct responses/number of questions asked) after the game is over. The user then enters their name and it is saved to "HighScores.txt", a text file that stores usernames and their corresponding scores, along with the number of correct responses a player had.
  
  Moving forward, I'd recommend adding a timer feature to force the player to answer each question in a limited amount of time. I also suggest separating the highscores by the number of questions asked and the game mode the user played in, as the highscores currently displayed are for any mode and any number of questions asked. Unlike the previous version of the game, this iteration lacks any sort of test coverage so adding that is highly recommended.
  
  One bug that exists is that when the user is at the main menu or the menu for selecting the number of questions to be quizzed and a number out of the menu's bounds is entered (for example, entering "34" at the main menu when the only options are 0 through 8), the game does not signal that the number entered does not correspond to an option. Another bug similar to this is that the game crashes when the user is answering questions and enters a number other than 0 through 3, as those are the only numbers that correspond to possible answers to a question. Ideally, the game should respond with a prompt stating that the number the user entered does not correspond to an option on the given menu and that the user should enter a number that is appropriate for the given menu.
  
  A possibility for refactoring exists in the FinalMenu.java file. That file handles the highscores as well as simply asking the user if they'd like to play again. This could be split into 2 separate Menu classes: one for handling highscores (say "HighScoreMenu.java") and the other simply for displaying the user's score and asking if they'd like to play again.
  
  As far as working with legacy code, I highly recommend playing around with the program to get an idea of how the game works before tackling the issues you've been presented - you'll learn a lot about the code that way than just reading about what it's suppsoed to do. You'll probably find it easier to tackle the smaller issues and then work your way up to the more challenging ones when getting started with issue fixing.

## F17 final remarks
    
   Before starting to change anything, play the game a couple times through. This will show how the game works and help understand some of the bugs. Then look up the Model-View-Controller Pattern and have a good understanding of it. This is important in understanding how the files all work together. 
   
   Refactoring and javadocs should be done first. When refactoring, clean up the commented out code. Then maybe clean up some of the functions to make single-purpose. Moving the timer into SessionModel may take some time to figure out.
   
   There is a strange issue with the first question having a duplicate answer. Wrong input in the question menu can crash the game. The timer and hints option seem to act strangely with each other.
   
   