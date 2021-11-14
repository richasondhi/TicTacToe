Task: -
Implement a Tic-Tac-Toe Game ( Xs and Os) solver
The game is based on a 3x3 grid where we consider the fields numbered like on a
telephone keypad, with the number 1 on the top left corner and the number 9 on the bottom right corner.

The two players take turns occupying the fields in the grids with their tiles.
The player who can first get a vertical, horizontal or diagonal stroke of 3 tiles wins.


NOTES: -

The input to the main function will be an  2D char array  representing the  Game board. char [i][j]={0,1,2}
put a space around each value, | as a columns separator and multiple - as rows separator
Our class TicTacToe shall provide a method playerTurn() and computerTurn()


Process:-
1.)initialize() ->Initialize the board to 2d matrix to empty square
2.)printboard()  ->The method shall always print an 2d Char array
3.)placemove() -> board char[i][j] , position , symbol x or o (Output of the function will be the index of the desired move (1-9).)
4.)isValidMove()    -> Player playing will always be X. It must make a valid move, and a winning move if available.
                       if there is  possible move or not  call method isValidMove()  player move is not a valid move if chosen position is
                       already filled in board or if position chosen is outside 1 to 9
5.)hasContestantWon()  ->Winner decision = player, computer, draw, undecided
6.)isGameFinished()
There are two tokens: “X” and “O”.
There are 9 spots on a Tic Tac Toe board.
To make a move, pass the number of the position  on board  as argument to the method.
computer make the next move will be using  Random class in java  to choose any random number from 1 to 9
There must be three symbol in a row in order to win, upon which the game is over.
If all the spots on the board contain a symbol, then the game is over.
If the board is full, but there is no winner, it’s a draw.
A player cannot place their symbol in a spot that already has a symbol.
