# frogger

Here are the features that i have addded to the game:

MENU:
A menu consits of 4 buttons that leads player to different pages.
PLAY - To play the game.
HIGH SCORE - To view the permanent scoreboard.
HELP - Consists of information that will instruct how should player play the game.
EXIT - Exit the game.

ENTER NAME:
After you hit play , player will be asked to key in their name , 
the player name and the score that he/she get in the game will be stored in the database.
Name cannot be empty.
Database will be checking duplicate name in the database , 
if there are duplicate names, player will be asked to enter another name ,
else procced to choosing level scene.
This action is to avoid confusion to player when they looking at their score on scoeboard.

CHOOSE LEVEL:
After player enter his/her name, player will get to choose any of the 10 levels to play.
The difficulty of the game increases as the level increases.

GAME (new features):
In each level , player will get 4 lifes , 
and player needs to move the frog into the hole in 30 seconds.
If the frog not in the hole in 30 seconds,
frog lifes will be decreased by 1.
Starting from level 4 to 10, there will be crocodile poping out randomly in the hold, 
if the frog hit the crocodile , lifes will be decrease by 1.

All of these features are just making the game more interesting.

GAME END:
If player wins the level ,
player will be asked if he/she wants to continue next level or back to menu.
If player proceed to next level, 
current score of player will be incremented with the final score in the next level.

If player lose the game, 
player will be asked to return to main menu, and their final score will be saved in database.
