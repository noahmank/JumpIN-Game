# JumpIN-Game
Smart Games' JumpIN' game implemented with Java for SYSC3110 course

The objective of the game is to move the rabbits and foxes around the game board until all of the rabbits are safe in brown holes. There are 3 rabbits, 3 mushrooms and 2 foxes.

• Foxes move by sliding forward or backward. Foxes cannot jump over obstacles or be placed elsewhere on the board.

• Mushrooms are stationary and cannot be moved.

• Rabbits move by jumping horizontally or vertically over one or more spaces with obstacles: other rabbits, foxes, mushrooms or a combination of these:

    - Rabbits must land on the first empty space after a jump - they can never move over empty spaces.

    - Rabbits can never move without jumping over at least 1 obstacle, thus they can never move to an adjacent space.

    - A hole with a rabbit inside is an obstacle, while empty holes are not obstacles.

    - A rabbit can jump into – but not over – an empty hole.

    - If needed, rabbits can jump out of holes they are already sitting in.

    - Rabbits can jump over a fox no matter the orientation of the fox: tail to front, front to tail, or over the side.

You have found a solution when all of the rabbits are inside brown holes! The end position of the foxes is not important.
For more information regarding the rules, visit http://www.smartgamesandpuzzles.com/inventor/JumpIn.html

# Authors

 - Adela Tullio
 - Aubin Musingya
 - Kelly Harrison
 - Liya Abebe
 - Noah Mank

# Deliverables

### Deliverable 1
This submission includes an up-to-date UML diagram, source code and executable code, along with documentation. 

### Deliverable 2
This submission includes the updates UML diagram, source code and along with documentation and in addition, a GUI component for the game.

# Advancement

### Deliverable 1
A text-based playable version of the "Jump IN" game has been implemented from the UML diagram generated.
It has been designed to allow the user to play the game using the keyboard through the console. In our implementation,
we included a text-based view of the board at the beginning of the game and after each move. In addition, we hard coded the game 
to only implement one puzzle challenge, challenge 1. We plan to expand this to allow for different puzzle challenges.

### Deliverable 2
The GUI of the game has been implemented using the MVC Design pattern. This version allows the user to play the game using Buttons on a window and manipulate movable pieces using direction arrows at the bottom of the window. The puzzle challenge implemented is the same as challenge 1 in deliverable 1.

# Solution for Challenge 1

One of the solutions for the current challenge is:
(GR, SOUTH); (GR, SOUTH); (BR, EAST); (GR, NORTH); (WR, WEST); (F1, SOUTH); (GR, WEST); (F2, WEST) x3; (GR, SOUTH);

# Known Issues

### Deliverable 1
Some exceptions are not handled correctly - namely, when moving certain pieces in invalid directions, an exception is thrown,
but no message describing the issue is provided to the user.
The Direction enum currently describes North and South opposite to how they are logically, due to our board being located in the
fourth quadrant. When the GUI is properly implemented, this will be shifted back to the first quadrant and fixed.

### Deliverable 2
 
# Design

### Deliverable 1
Three classes were made to describe the Mushroom, Rabbit, and Fox pieces. As these are all considered to be a Piece, we made an interface implemented by the three of them to describe that relationship. The Fox class requires a description of its direction (while still and to describe its movement) so a Direction enumeration was created to represent the cardinal directions. A Hole class was also constructed to be the main unit of the GameBoard, and these Hole objects have an instance variable to hold a Piece if required. This class is inherited by RaisedHole, which is in turn inherited by BrownHole. The GameBoard class stores and handles the movement and placement of all the pieces and holes on the Board, and keeps track of all of the moveable pieces. It currently only has the capability to create 5x5 boards, but this will be expanded on later. It also has a method to see if all the rabbits on the board are currently occupying brown holes, indicating a completed game. The JumpInGame class stores an instance of GameBoard and provides an interface for the user to interact with. This interface describes the rules of the game and prompts the user for input, which is then used to call various methods to try and complete the game.

### Deliverable 2
JumpInController and JumpInView were added implementing the roles of a controller and view class in a MVC design pattern. The JumpInGame plays the role of a model class.
