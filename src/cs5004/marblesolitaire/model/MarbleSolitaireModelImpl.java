package cs5004.marblesolitaire.model;

/**
 * This class represents an implementation of the MSM. It offers all the operations and constructors
 * for a Marble Solitaire game.
 */
public class MarbleSolitaireModelImpl extends AbstractMarbleSolitaire {


  /**
   * This private function is not intended to be called by any outside classes. It is used by each
   * constructor to setup the board to avoid code repetition. It determines which part of the board
   * will be the plus shape. Note that the _ space is calculated by the actual constructor after the
   * helper call.
   *
   * @returns void
   */
  private void implHelper() {
    this.board = new String[r][c];

    for (int row = 0; row < r; row++) {
      for (int col = 0; col < c; col++) {
        if (// The fours corners which will be filled with " " are calculated here.
                (row < armThickness - 1 && (col < armThickness - 1 || col > c - armThickness))
                        ||
                        (row > r - armThickness && (col < armThickness - 1
                                || col > c - armThickness))
        ) {

          board[row][col] = " ";

        } else {
          // part of the "plus" shape to be filled with Os
          board[row][col] = "O";
        }
      }

    }


  }

  /**
   * The default constructor which takes no parameters. It can be used for a game where there is one
   * blank space at the board's center and the armthickness, r, and c is 7.
   */
  public MarbleSolitaireModelImpl() {

    implHelper();
    //calculates center of board using default r and c.
    this.board[(r / 2)][(c / 2)] = "_";
  }

  /**
   * A constructor which will take in a row and a column and use those inputs to determine the
   * location of the chosen "_". Everything else is default.
   *
   * @param sRow the row number of the empty position.
   * @param sCol the column number of the empty position.
   */
  public MarbleSolitaireModelImpl(int sRow, int sCol) {
    implHelper();
    //calculates center of board using parameter r and c.
    //Exception added during assignment 7.
    if (sRow < 0 || sCol < 0) {
      throw new IllegalArgumentException("invalid starting position");
    }
    this.board[sRow][sCol] = "_";
  }

  /**
   * A constructor which will take in a row and a column and arm thickness and use those inputs to
   * determine the location of the chosen "_". It will calculate r and c based on the armthickness.
   * Invalid starting position srow or scol < 0 added assignment 7.
   *
   * @param armThickness the thicc of left right top and bottom of plus sign.
   * @param sRow         the row number of the empty position.
   * @param sCol         the column number of the empty position.
   * @throws IllegalArgumentException if user tries to enter an even arm thickness.
   * @throws IllegalArgumentException if user tries to enter an invalid start pos.
   */
  public MarbleSolitaireModelImpl(int armThickness, int sRow, int sCol) {

    if (sRow < 0 || sCol < 0) {
      throw new IllegalArgumentException("invalid starting position");
    }

    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("Odd numbers only");
    }
    this.armThickness = armThickness;

    // calculates r and c since we cannot use the defaults due to new armthickness.
    int r = armThickness + (armThickness - 1) + (armThickness - 1);
    int c = r;
    // this objects r and c will be set to calculation based on parameters.
    this.r = r;
    this.c = c;
    implHelper();
    if (!board[sRow][sCol].equals("O")) {
      throw new IllegalArgumentException("stop");
    } else {
      this.board[sRow][sCol] = "_";
    }
  }


  /**
   * A constructor which will take the arm thickness and use those inputs to determine the location
   * of the chosen "_". It will calculate r and c based on the armthickness.
   *
   * @param armThickness the thicc of left right top and bottom of plus sign.
   * @throws IllegalArgumentException if user tries to enter an even arm thickness.
   */
  public MarbleSolitaireModelImpl(int armThickness) {

    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("Odd numbers only");
    }
    this.armThickness = armThickness;

    int r = armThickness + (armThickness - 1) + (armThickness - 1);
    int c = r;

    this.r = r;
    this.c = c;
    implHelper();

    this.board[(r / 2)][(c / 2)] = "_";

  }

}

