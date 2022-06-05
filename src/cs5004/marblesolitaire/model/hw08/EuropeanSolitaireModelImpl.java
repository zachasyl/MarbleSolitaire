package cs5004.marblesolitaire.model.hw08;

import cs5004.marblesolitaire.model.AbstractMarbleSolitaire;

/**
 * This class represents an implementation of the MSM. It offers all the operations and constructors
 * for a European Marble Solitaire game.
 */
public class EuropeanSolitaireModelImpl extends AbstractMarbleSolitaire {

  /**
   * The default constructor which takes no parameters. It can be used for a game where there is one
   * blank space at the board's center and the armthickness, r, and c is 7.
   */
  public EuropeanSolitaireModelImpl() {

    implHelperEuro();
    //calculates center of board using default r and c.
    this.board[(r / 2)][(c / 2)] = "_";
  }


  /**
   * A constructor which will take the arm thickness and use those inputs to determine the location
   * of the chosen "_". It will calculate r and c based on the armthickness.
   *
   * @param armThickness the thicc of left right top and bottom of plus sign.
   * @throws IllegalArgumentException if user tries to enter an even arm thickness.
   */
  public EuropeanSolitaireModelImpl(int armThickness) {

    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("Odd numbers only");
    }

    this.armThickness = armThickness;

    int r = armThickness + (armThickness - 1) + (armThickness - 1);
    int c = r;

    this.r = r;
    this.c = c;
    implHelperEuro();

    this.board[(r / 2)][(c / 2)] = "_";

  }

  /**
   * A constructor which will take the arm thickness and use those inputs to determine the location
   * of the chosen "_". Row and Column of blank is also input by user.
   *
   * @param armThickness the thicc of left right top and bottom of plus sign.
   * @param row          the row of blank.
   * @param col          the row of blank.
   * @throws IllegalArgumentException if user tries to enter an even arm thickness.
   */
  public EuropeanSolitaireModelImpl(int armThickness, int row, int col) {

    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("Odd numbers only");
    }
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("invalid starting position");
    }


    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("Odd numbers only");
    }

    this.armThickness = armThickness;

    int r = armThickness + (armThickness - 1) + (armThickness - 1);
    int c = r;

    this.r = r;
    this.c = c;
    implHelperEuro();


    if (this.board[row][col].equals("O")) {
      this.board[row][col] = "_";
    } else {
      throw new IllegalArgumentException("Cannot create empty space there");
    }
  }

  /**
   * A constructor which will take the row and column for a blank ut use default Armthickness,.
   *
   * @param r the thicc of left right top and bottom of plus sign.
   * @param c the thicc of left right top and bottom of plus sign.
   * @throws IllegalArgumentException if user tries to enter an even arm thickness.
   */
  public EuropeanSolitaireModelImpl(int r, int c) {

    if (armThickness % 2 == 0) {
      throw new IllegalArgumentException("Odd numbers only");
    }
    if (r < 0 || c < 0) {
      throw new IllegalArgumentException("invalid starting position");
    }

    r = armThickness + (armThickness - 1) + (armThickness - 1);
    c = r;

    this.r = r;
    this.c = c;
    implHelperEuro();

    this.board[(r / 2)][(c / 2)] = "_";

  }

  /**
   * This private function is not intended to be called by any outside classes. It is used by each
   * constructor to setup the board to avoid code repetition. It determines which part of the board
   * will be the plus shape. Note that the _ space is calculated by the actual constructor after the
   * helper call.
   *
   * @returns void
   */
  private void implHelperEuro() {
    this.board = new String[r][c];
    //COL
    //from starting row 0 until row armthickness - 2, the 3rd element, 2nd and 3rd, 1 2 and 3.
    //from starting row 0 until row armthickness - 2, armthickness - 2, at-2 and at-3, at-2 and.
    // at-3 and at-4.
    int i = 0;
    int z = 0;
    for (int row = 0; row < r; row++) {
      i++;
      // z is used to rowcount the bottom half of the cross and begins
      // at the row where the bottom cross arm is.
      // as z increments, col < z produces more " " whereas
      // while i increments, col < armthickness - i produces less " ".
      if (row > r - armThickness) {
        z++;
      }
      for (int col = 0; col < c; col++) {
        if (// as i increments each row, less " " are produced per row as column nears 0.
                (row < armThickness - 1 && (col < armThickness - i))
        ) {

          board[row][col] = " ";

        } else if (// as i increments each row, less " " are produced per row as column nears 0.
                (row < armThickness - 1 && (col > c - armThickness - 1 + i))
        ) {
          board[row][col] = " ";

        } else if (// The fours corners which will be filled with " " are calculated here.
                (row > r - armThickness && (col < z))
        ) {

          board[row][col] = " ";
        } else if (// The fours corners which will be filled with " " are calculated here.
                (row > r - armThickness && (col > c - z - 1))
        ) {

          board[row][col] = " ";

        } else {
          // part of the "plus" shape to be filled with Os
          board[row][col] = "O";
        }


      }
    }

  }
}
