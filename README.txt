# CS611-1
## Tictactoe
---------------------------------------------------------------------------
<Student Name> Tongfan Wei
<Student Email> weitf@ bu.edu
<Student BUID> U14162196

## Files
---------------------------------------------------------------------------
<A brief description of each file and what it does>

Menu ---- the main file to run
BoradGame----includes TTT and OAC and super TTT
Ttt-----play tictactoe
OAC-----play Order&Chaos ---- for OAC I add the extra rule in wikipeida: only (size-1) in a row is order, (size) is not 
SuperTTT-----Play super TTT. only the size of big board can be modified
gameBoard----all things need to play the game
superBoard------Big Board that contains smaller boards
Cell---- construct gameBoard can place TTTPieces
winConditon----check if someone wins, includes TTTwin and OACwin
TTTwin----
OACwin----
TTTPieces---- X and O to put in the cell
player----- players and scores
inputV----used to input int and XO
Quoridor---- play Quoridor
PrintBoard---- printer for Quodior
Qmove---- to move and build wall in Quodior
Qwin---- wincheck in Quodior

## Notes
---------------------------------------------------------------------------
1. <Files to be parsed should be stored in ConfigFiles, for parser class to
read class>
2. <Bonus Done> not Done
3. <Notes to grader> I am using the terminal inside intellij so I am not sure what the compile argument is.

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "pa1" after unzipping the files
2. Run the following instructions:
-classpath ./TheGame
<Example below>
javac -d bin src/*.java
java -cp bin Main

## Input/Output Example
---------------------------------------------------------------------------
<Place here an example of how the program runs. Include both its
outputs and correctly formatted inputs. Please clearly mark the inputs.>
e.g.:
(illegal move will jump your turn as a penalty)

(for Quodior: Wall's cooridinate is the lower right corner of cell of same cooridinate
  wall limit is the same as height
  no addtional rule included)

（for super Tic tec toe, use A,B,C... to refer to smaller boards.
the size of small boards is always 3）
Output:	what game you want to play?: A:Tictactoe B:Order&Chaos
press A or B to continue
Input:		A                              ///tictactoe
Output:	height is?: (int from 3 to 20)          ///now support rectangular
Input:		3
OutPut:	height: 3
Output:	width is?: (int from 3 to 20)          
Input:		3
OutPut:	height: 3
		Player A's name is?: 
Input:		a
Output:	Player A: a. Piece is X
		Player B's name is?: 
Input:		b
Output:	Player B: b. Piece is O
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
a's move is?: 
enter first int as row
Input:	1
enter second int as col
Input:	1			/// invalid move will jump your turn
enter X or O as Piece
Input:	X		/// using your opponent's piece may help your opponent to win
OutPut:a's move: 1, 1
+--+--+--+
|X |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
|  |  |  |
+--+--+--+
b's move is?: 
enter first int as row
Input:	1
enter second int as col
Input:	2
......
......
a's move: 3, 1
+--+--+--+
|X |O |O |
+--+--+--+
|X |  |  |
+--+--+--+
|X |  |  |
+--+--+--+
a wins!
Do you want to play again?
Input:		yes           ///again
Input:		no
Out put:	a wins: 2
		b wins: 0
 



Input:		B	///Order&Chaos
Output:	Player A's name is?: 
Input:		a
Output:	Player A: a
	Player B's name is?: 
Input:		b
Output:	Player B: b
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
|  |  |  |  |  |  |
+--+--+--+--+--+--+
a's move is?: 
Input:		1
		1
		X
Output:	a's move: 1, 1 X
......

///for illegal move the output is Illiegal move!