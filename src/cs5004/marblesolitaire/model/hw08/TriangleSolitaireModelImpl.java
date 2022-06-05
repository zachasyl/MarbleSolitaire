package cs5004.marblesolitaire.model.hw08;

import cs5004.marblesolitaire.model.AbstractMarbleSolitaire;

/**
 * This class represents an implementation of the MSM. It offers all the operations and constructors
 * for a Triangle Marble Solitaire game and extends the Abstract class.
 */
public class TriangleSolitaireModelImpl extends AbstractMarbleSolitaire {
  // stores triangle representation as string.
  private String triangleRepresentation = "";
  private int defaultRows = 5;

  /**
   * The default constructor which takes no parameters. It can be used for a game where there is one
   * blank space at the board's center and the armthickness, r, and c is 7.
   */
  public TriangleSolitaireModelImpl() {
    this.r = defaultRows;
    this.c = defaultRows;
    // allows r and c to be corrected so that this.r and c are used to get score --
    // that way I dont need to copy and paste the getscore function.
    // call helper construct.
    construct();
    // int defaultEmpty = (c / 2) * 2;
    this.board[0][0] = "_";
  }

  /**
   * A constructor which will take the dimensions of triange. and use those inputs to determine the
   * location of default tip blank.
   *
   * @param dimensions the amount of rows.
   */
  public TriangleSolitaireModelImpl(int dimensions) {
    if (dimensions <= 0) {
      throw new IllegalArgumentException("invalid starting position");
    }
    // allows r and c to be corrected so that this.r and c are used to get score --
    // that way I dont need to copy and paste the getscore function. Abstraction!

    this.r = dimensions; // default.
    this.c = dimensions;

    this.board = new String[r - 1][c - 1];  //5 and 9
    construct();
    this.board[0][0] = "_";


    //calculates center of board using default r and c.
  }

  /**
   * A constructor which will take in a row and a column of the triangle's blank.
   *
   * @param row the row number of the empty position.
   * @param col the column number of the empty position.
   */
  public TriangleSolitaireModelImpl(int row, int col) {
    // yea this took me forever to realize...
    if (col > row) {
      throw new IllegalArgumentException("Invalid starting position");
    }

    this.r = defaultRows;
    this.c = defaultRows;
    // allows r and c to be corrected so that this.r and c are used to get score --
    // that way I dont need to copy and paste the getscore function.
    // call helper construct.
    construct();
    this.board[row][col] = "_";

    //calculates center of board using default r and c.
  }


  /**
   * A constructor which will take in dimensions, a row and a column of the triangle's blank.
   *
   * @param dimensions the amount of rows of triangle.
   * @param row        the row number of the empty position.
   * @param col        the column number of the empty position.
   */
  public TriangleSolitaireModelImpl(int dimensions, int row, int col) {
    if (dimensions <= 0) {
      throw new IllegalArgumentException("invalid starting position");
    }

    // yea this took me forever to realize...
    if (col > row) {
      throw new IllegalArgumentException("Invalid starting position");
    }


    // allows r and c to be corrected so that this.r and c are used to get score --
    // that way I dont need to copy and paste the getscore function.
    this.r = dimensions; // default.
    this.c = r + r - 1;

    construct();

    // this.board = new String[r][c];  //5 and 9

    if (board[row][col].equals("O")) {
      this.board[row][col] = "_";
    }
    //calculates center of board using default r and c.
  }

  /**
   * Calling function will depict the board as a string. This function builds a string
   * triangleRepresentation, iterates through the board, and stuffs the current position into the
   * string before returning the stirng.
   *
   * @returns string, the board's current state as as string.
   */
  @Override
  public String getGameState() {
    int max = c - 1;  //7 // c-1
    int min = 0;
    int blankIterator = r - 1;
    for (int row = 0; row < r; row++) {
      if (row > 0) {
        triangleRepresentation += "\n";
      }
      //pushes rows over so no longer irght triangle.
      helper(blankIterator);
      max += 1;
      min += 1;
      blankIterator -= 1;
      for (int col = 0; col < c; col++) {
        if (!(col < max && this.board[row][col].equals(" "))) {
          triangleRepresentation += this.board[row][col];
          if (col < min - 1) {
            triangleRepresentation += " ";
          }

        }

      }
    }
    return triangleRepresentation;
  }

  /**
   * this function pusshes each row over such that triangle is no longer a right triangle/ As the
   * rows increase, less " " are needed to push the rows over.
   */
  public void helper(int g) {
    int adder = 0;
    while (adder < g) {
      triangleRepresentation += " ";
      adder++;
    }
  }


  /**
   * This private function is not intended to be called by any outside classes. It is used by each
   * constructor to setup the board to avoid code repetition. It sets up the initial triangle board
   * shape.
   *
   * @returns void
   */
  private void construct() {
    this.board = new String[r][c];  //5 and 9

    int max = 1;  //7
    for (int row = 0; row < r; row++) {
      if (row > 0) {
        max += 1;
      }
      for (int col = 0; col < c; col++) {

        if (col < max) {
          this.board[row][col] = "O";  // I was attmpting to do this but its a
          //string array and I ran out of time to implement it as a marble array.
        } else {
          this.board[row][col] = " ";
        }
      }
    }

  }


}
