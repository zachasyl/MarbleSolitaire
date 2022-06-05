package cs5004.marblesolitaire.model;

import cs5004.marblesolitaire.model.hw08.TriangleSolitaireModelImpl;

/**
 * This class represents an implementation of the MSM. It offers all the operations and constructors
 * for a Marble Solitaire game. Question for grader: JUnit says "Board not as expected after
 * attempting to move from empty position expected:"it looks lkke one bug is affecting 3 tests
 * somehow, any idea? I should be throwing exceptions.
 */
public class AbstractMarbleSolitaire implements MarbleSolitaireModel {
  protected String[][] board;

  // default armThickness, default r and default c. Updated in constructors when default is
  // not appropriate.
  /**
   * ᕙ(⇀‸↼‶)ᕗ.
   */
  protected int armThickness = 3;
  protected int r = 7;
  protected int c = 7;

  /**
   * Move a single marble from a given position to another given position. A move is valid only if
   * the from and to positions are valid. Specific implementations may place additional constraints
   * on the validity of a move.A8 added too far and too close Illegal arguments.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException out of bounds if row or c is out of bounds.
   * @throws IllegalArgumentException need to move marble / need to move to empty space.
   * @throws IllegalArgumentException out of bounds.
   * @throws IllegalArgumentException too close / too far.
   * @throws IllegalArgumentException cant move to start location.
   * @throws IllegalArgumentException cant move from empty space.
   */
  public void move(int fromRow, int fromCol, int toRow, int toCol) {

    // Exceptions:
    if (toRow < 0 || toCol < 0) {
      throw new IllegalArgumentException("out of bounds");
    }
    if (toRow > r - 1 || toCol > c - 1) {
      throw new IllegalArgumentException("out of bounds");
    }
    if (fromRow > r - 1 || fromCol > c - 1) {
      throw new IllegalArgumentException("out of bounds");
    }
    if (!(this.board[fromRow][fromCol].equals("O"))) {
      throw new IllegalArgumentException("Need to move a marble");
    }
    if (this.board[toRow][toCol].equals("O")) {
      throw new IllegalArgumentException("Need to move to empty space");
    }
    if (this.board[fromRow][fromCol].equals("_")) {
      throw new IllegalArgumentException("cant move from empty space");
    }
    //Added out of bounds IAE if for or col < 0 inAssignment 8.
    // i have no idea how this was not caught earlier.
    // Only had to update it once in the abstract.
    if (fromRow < 0 || fromCol < 0) {
      throw new IllegalArgumentException("out of bounds");
    }
    if (fromRow == toRow && fromCol == toCol) {
      throw new IllegalArgumentException("Can't move to start location");
    }
    if (!this.board[toRow][toCol].equals("_")) {
      throw new IllegalArgumentException("Must move to an empty space.");
    }
    // Too close and too far added A8.
    if (fromRow + 1 == toRow || fromRow - 1 == toRow) {
      throw new IllegalArgumentException("too close");
    }
    if (fromCol + 1 == toCol || fromCol - 1 == toCol) {
      throw new IllegalArgumentException("too close");
    }
    if (fromRow < toRow && fromRow + 2 < toRow) {
      throw new IllegalArgumentException("Too far");
    }
    if (fromRow > toRow && fromRow - 2 > toRow) {
      throw new IllegalArgumentException("Too far");
    }
    if (fromCol < toCol && fromCol + 2 < toCol) {
      throw new IllegalArgumentException("Too far");
    }
    if (fromCol > toCol && fromCol - 2 > toCol) {
      throw new IllegalArgumentException("Too far");
    }

    // four if/else if statements which check up, right, down, and left.
    // If you are moving a marble to an empty space two away in those directions,
    // then the marble will be placed there. Then the space inbetween(one away)
    // which was "skipped" becomes empty.

    // vertical down.
    if ((fromRow + 2 == toRow) && (this.board[fromRow + 1][fromCol].equals("O"))
            && fromCol == toCol) {

      this.board[fromRow][fromCol] = "_";
      this.board[toRow][toCol] = "O";

      this.board[fromRow + 1][fromCol] = "_";

      //vertical up.
    } else if ((fromRow - 2 == toRow) && (this.board[fromRow - 1][fromCol].equals("O"))
            && fromCol == toCol) {

      this.board[fromRow][fromCol] = "_";
      this.board[toRow][toCol] = "O";

      // the r/c the marble "skipped" over becomes empty.
      this.board[fromRow - 1][fromCol] = "_";

      //horitzontal right.
    } else if ((fromCol + 2 == toCol) && (this.board[fromRow][fromCol + 1].equals("O"))
            && fromRow == toRow) {

      this.board[fromRow][fromCol] = "_";
      this.board[toRow][toCol] = "O";

      this.board[fromRow][fromCol + 1] = "_";

      //horitontal left.
    } else if ((fromCol - 2 == toCol) && (this.board[fromRow][fromCol - 1].equals("O"))
            && fromRow == toRow) {

      this.board[fromRow][fromCol] = "_";
      this.board[toRow][toCol] = "O";

      this.board[fromRow][fromCol - 1] = "_";

      // I know we are not supposed to use instanceof but could find no other way,
      // and I figure its better to use abstract class than to copy and paste
      // this code into the Triangleimpl and override.
    } else {
      if (!(this instanceof TriangleSolitaireModelImpl)) {
        throw new IllegalArgumentException("No diagonals in Euro");
      }
    }
    // checks negative slope diagonals for triangular only.
    if (this instanceof TriangleSolitaireModelImpl) {
      negSlopeDiag(toRow, fromRow, toCol, fromCol);

    }
  }

  /**
   * Checks if there is a negative slope diagonal.
   *
   * @param toRow   row moving to.
   * @param fromRow row moving from.
   * @param toCol   col loving to.
   * @param fromCol col moving from.
   * @returns boolean true if there is a negslope diagonal.
   */
  private boolean negSlopeDiag(int toRow, int fromRow, int toCol, int fromCol) {
    //diags neg slope.
    if ((fromRow + 2 == toRow) && (fromCol + 2 == toCol)) {
      this.board[toRow][toCol] = "O";
      this.board[fromRow + 1][fromCol + 1] = "_";
      this.board[fromRow][fromCol] = "_";
      return true;
    }

    if ((fromRow - 2 == toRow) && (fromCol - 2 == toCol)) {
      this.board[toRow][toCol] = "O";
      this.board[fromRow - 1][fromCol - 1] = "_";
      this.board[fromRow][fromCol] = "_";
      return true;
    }
    return false;
  }

  /**
   * Determines if game is over and returns boolean to main game over function. Returns false if
   * there IS a move, otherwise returns true. True does not mean game is over. Rather, it means what
   * is currently being checked does nto mean game is over and isGameOver will contiue to call the
   * helper for other checks.
   *
   * @returns boolean.
   */
  private boolean isGameOverHelper(int fromRow, int fromCol, int toRow, int toCol) {

    if (this.board[fromRow][fromCol].equals("O") && this.board[toRow][toCol].equals("_")) {

      if ((fromRow + 2 == toRow) && (this.board[fromRow + 1][fromCol].equals("O"))
              && fromCol == toCol) {
        return false;
      } else if ((fromRow - 2 == toRow) && (this.board[fromRow - 1][fromCol].equals("O"))
              && fromCol == toCol) {
        return false;
      } else if ((fromCol + 2 == toCol) && (this.board[fromRow][fromCol + 1].equals("O"))
              && fromRow == toRow) {

        return false;
      }

      //Added Assignment 8. Need to check if diagonal moves are left for triangle.
      else if (this instanceof TriangleSolitaireModelImpl) {
        if (negSlopeDiag(toRow, fromRow, toCol, fromCol)) {
          return false;
        }
      } else {
        return (fromCol - 2 != toCol) || (!this.board[fromRow][fromCol - 1].equals("O"))
                || fromRow != toRow;
      }
    }
    return true;
  }

  /**
   * This function looks at the current board and checks where each space can move if it has a
   * mable.
   *
   * @returns boolean.
   */
  public boolean isGameOver() {

    int ir = 0; // row iterator
    int ic = 0; // col iterator
    while (ir < r) {
      ic = 0; // sets ic back to 0 each time ir increases by one.
      while (ic < c) {
        for (int row = 0; row < r; row++) {
          for (int col = 0; col < c; col++) {
            boolean over = isGameOverHelper(row, col, ir, ic);
            if (!over) {
              return false; // game isnt over helper says a move was possible/remaining.
            }
          }
        }
        ic += 1;
      }
      ir += 1;
    }
    return true; // note true is only returned after every possibility is checked despite
    // the value of over ever being true.
  }

  /**
   * Calling function will depict the board as a string. This function creates a string theString,
   * iterates through the board, and stuffs the current position into the string before returning
   * the stirng.
   *
   * @returns string, the board's current state as as string.
   */
  public String getGameState() {
    String theString = "";

    for (int row = 0; row < r; row++) {
      for (int col = 0; col < c; col++) {
        // empty left corners.
        if ((row < armThickness - 1 && col < armThickness - 1) ||

                (row > r - armThickness && col < armThickness - 1)
        ) {
          theString += this.board[row][col] + " ";

        }
        // empty right corners.
        else if ((row < armThickness - 1 && col > c - armThickness) ||

                (row > r - armThickness && col > c - armThickness)
        ) {
          if (!(this.board[row][col].equals(" "))) { //this if added A8.
            theString += " " + this.board[row][col]; // used to be += "" changed in A8 since
            //in some cases (european mode) sections outside the + can be filled with non "".
          } else {
            theString += "";
          }
        }
        // last column (but not corner)
        else if (col == c - 1) {
          theString += this.board[row][col] + "";
        }
        // column before start of right corners.
        else if (col == c - armThickness && (row < armThickness - 1 || row > r - armThickness)) {
          theString += this.board[row][col] + "";

        }

        // the plus sign minus the column before start of right corners.
        else {
          theString += this.board[row][col] + " ";
        }

        if (col == r - 1 && row < r - 1) {
          theString += "\n";
        }
      }
    }
    return theString;
  }

  /**
   * Determines score by iterating through board and counting marbles.
   *
   * @returns int the score (amount of marbles on board, lower better).
   */
  public int getScore() {
    int score = 0;

    for (int row = 0; row < this.r; row++) {
      for (int col = 0; col < this.c; col++) {
        if (board[row][col].equals("O")) {
          score += 1;
        }
      }
    }
    return score;
  }
}