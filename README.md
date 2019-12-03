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

When creating a level, select a piece from the first drop down menu, an attribute from the second (if a fox or a rabbit), and a square on the grid. Click add piece to add the piece to that square. If the player wishes to remove a piece from the board, they may select on the square occupied by the piece, and then click the remove piece button. Once the player is satisfied by the board, they may click the "Build New Board" button which will check if the board is solveable, and then add it to the list of challenges if it is. These new challenges can be accessed just like the built-in ones on the instructions screen.

You can save the state of any levels in progress from the file menu and load it back afterwards. These saves will be accessible even when restarting the game. If you wish to start fresh, go to the directory in which this game is stored and delete "JumpInGame Save".

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

### Deliverable 3
This submission includes the updated UML diagram, source code, test cases, along with documentation. In addition, an updated GUI component, a game solver, as well as undo and redo buttons.

### Deliverable 4
This submission includes an updated UML class diagram, an updated UML sequence diagram, updated source code, updated test cases, and updated documentation. In addition, an updated GUI component, along with a 'Save' and 'Load' feature. 

# Advancement

### Deliverable 1
A text-based playable version of the "Jump IN" game has been implemented from the UML diagram generated.
It has been designed to allow the user to play the game using the keyboard through the console. In our implementation,
we included a text-based view of the board at the beginning of the game and after each move. In addition, we hard coded the game 
to only implement one puzzle challenge, challenge 1. We plan to expand this to allow for different puzzle challenges.

### Deliverable 2
The GUI of the game has been implemented using the MVC Design pattern. This version allows the user to play the game using Buttons on a window and manipulate movable pieces using direction arrows at the bottom of the window. The puzzle challenge implemented is the same as challenge 1 in deliverable 1.

### Deliverable 3
A game solver was implemented and integrated in the GUI along with undo and redo functions. There are updates on the GUI to accomodate this and some changes were made to improve the GUI aesthetics, including new foxes, rabbits, mushrooms, colours, new buttons and more. In addtion, 2 new challenges were added to test the functionality of the solver.

### Deliverable 4
In the File menu, we added a 'Save' and 'Load' which enables a user to save the progress they've made in a level, and load a level that that they have previously saved to be able to continue playing. Additionally, we have added a game builder feature. This feature enables the user to suggest a level by selecting which pieces to put on the board. If the suggested level is feasible, it is saved and ready to play when the user wishes. The game also serializes itself when closed, so any created challenges are accessible when relaunched, and the player can load any previously saved levels.

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
Foxes can currently move through each other - does not greatly affect the difficulty of the only challenge, but in more difficult problems it could.
A lot of refactoring needs to be done; there are many methods (like start()) that either have redundant functionality or are just no longer in use.
Exporting the project in its current state does not include the images - this will be remedied in the next deliverable, but for now it must be run through an IDE.

### Deliverable 3
There is some delay while the solver is running, though this is less of an issue and more of a weakness of the chosen solve strategy. The user might have to wait up to about 35 seconds before they get the option to see the minimum set of moves required to solve the game. A bigger issue is that for especially complex challenges, like challenge 3, the tree becomes too large, and ends up running out of memory. Another non-major issue is that the challenges are currently hard coded into the system. By the next deliverable, this issue will be fixed with a method to add new challenges from a text file, and a level creator within the game.

### Deliverable 4
Some of the classes in this project are not as cohesive as they could be, mainly due to time constraints. There is also very little feedback when using the builder (doesn't tell you if the board has been added to the list of challenges) due to a lack of console output. When adding a piece to the board (In the board builder), the user may not know to select the attribute (the drop down next to it) before the piece can be added to the board.

# Design

### Deliverable 1
Three classes were made to describe the Mushroom, Rabbit, and Fox pieces. As these are all considered to be a Piece, we made an interface implemented by the three of them to describe that relationship. The Fox class requires a description of its direction (while still and to describe its movement) so a Direction enumeration was created to represent the cardinal directions. A Hole class was also constructed to be the main unit of the GameBoard, and these Hole objects have an instance variable to hold a Piece if required. This class is inherited by RaisedHole, which is in turn inherited by BrownHole. The GameBoard class stores and handles the movement and placement of all the pieces and holes on the Board, and keeps track of all of the moveable pieces. It currently only has the capability to create 5x5 boards, but this will be expanded on later. It also has a method to see if all the rabbits on the board are currently occupying brown holes, indicating a completed game. The JumpInGame class stores an instance of GameBoard and provides an interface for the user to interact with. This interface describes the rules of the game and prompts the user for input, which is then used to call various methods to try and complete the game.

### Deliverable 2
JumpInController and JumpInView were added, implementing the roles of a controller and view class in a MVC design pattern. The JumpInGame plays the role of a model class. An ArrayList collection of type JumpInView was added so that the view could 'subscribe' to the model for updates. JumpInView creates a window using JFrame with challenge 1 initialized (this will be expanded upon in the later deliverables). This window has: a board display consisting of a grid of BoardButtons; the rules of the game; a console output; and DirectionButtons. The user can play the game by selecting a piece and then pressing direction buttons to move the piece around. These buttons create events which are handled by the controller, which calls move methods in the model based on whichever piece is selected. The model then performs the move and then notifies the subscribed views about changes to the model's board. The updateView method in the view then recreates the board by using the HashMaps for each piece. This is why an additional HashMap of Mushroom objects was created. Other than the new HashMap and the ArrayList of JumpInViews, no major changes were made to the data structures in the model from Deliverable 1. The UML diagram was updated to included the new GUI implimentation classes. These consisted of the BoardButton, DirectionButton, JumpInView, JumpInController classes as well as the built in java classes that they extend. 

### Deliverable 3
JumpInController and JumpInView were split up to increase the modularity of the controller and view, and increase cohesion. There are now individual classes for separate panels and frames for the view, and different controllers for different groups of components, to avoid long lists of 'instanceof' checks. Currently the view is set up so that when the game is launched, a frame pops up with the rules of the game, a challenge selector (there are currently 3 challenges hard-coded into the model), and buttons to bring the user to either the solver frame or the playing frame. The playing frame is identical to that of the previous deliverable. The solver frame has a display of the board that needs to be solved, and a button that starts the solver. This can take a substantial amount of time to finish. Once the board is solved (internally), the user can press the button, now renamed to "Do next move", to apply the solution's moves to the board until completion. 

The logic of the board solver is made up of 3 classes: BoardSolver, BoardTree, and BoardTreeNode. Each node contains a board, and the action taken to get to that board. The BoardSolver takes a board in its constructor, creates a node with that board, and creates a tree with that node. When the solveBoard method is called, it uses the BFS algorithm to try and find the solved board. As this method checks each node, it populates the children of that node based on the possible actions from the parent. This helps to avoid the massive tree that would be generated by creating all of the possible nodes from the start. There is also an extra ArrayList of nodes that have been checked, to avoid creating children for nodes that have already been visited (this helped cut down the size of the tree greatly as it removed looping actions). Once the solution node is found, the solver can then go back up the tree through its parents and generate a stack of the moves required to arrive at the solution from the root.

In the model, various methods were added, removed, and split up to improve cohesion and to avoid breaking the law of demeter. The move functions in GameBoard were split up into methods to check if the move was valid, and a method to actually execute the move. The methods to check if moves were valid (canMoveFox and canMoveRabbit) were quite useful in the solver to help populate the children nodes. This separation also facilitated the removal of many thrown Exceptions and try/catch statements. A few common checks in GameBoard were also extracted into new methods like spaceIsEmpty and spaceIsOnBoard. Many additional constructors were added, such as a copy constructor for GameBoard (again to help with the solver). An equals method for GameBoard was als added to check the copy constructor and to facilitate the comparison of BoardTreeNodes.

### Deliverable 4
A new frame was added and integrated into the view to be used when building new levels for the game. The user is able to select a piece and an attribute (if the piece needs one) and add it to the board. Once they are happy with the board, they can press the "Build New Board" button at the bottom of the frame to add it to the list of challenges. It is also saved in an XML file with its challenge number. This button calls the solver from Deliverable 3 first to see if there is a valid solution for the given board. A new class BoardBuilder was introduced in the model to implement this behaviour. Two other classes were introduced to generate an XML file from a board, and to parse an XML file and generate a board from it.

A save/load feature was also introduced to save and load the progress that the user makes in a level. If the user starts a level, does a few moves, and then saves it, they can then return to the same level at any time and load that save. To implement this, a new HashMap of in-progress GameBoards was added to keep track of any levels that were in progress.

Finally, the game is now serializable, and the game is automatically serialized when the game is closed. The game will also automatically try to load a previously-serialized version of the game before starting from a blank slate. This was done by implementing Serializable in JumpInGame. Many of the fields in the class were marked as transient as their state was not important to the game, but importantly, the collection of challengesInProgress, and the numChallenges were left so that the game would remember the state of the in-progress levels, and the existence of any user-created levels (other variables were serializable as well, but less important to the state of the game).
