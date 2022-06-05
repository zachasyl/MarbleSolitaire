package cs5004.marblesolitaire.controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;


/**
 * This class represents the implementation of the MarbleSolitaireController and it runs the model
 * via playGame. As of Assignment 8, blank gaps have been removed, accidental system.out prints have
 * been removed, and print stack traces removed. On line 89 the variables are no longer initialized
 * to 0.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {

  private final Readable in;
  private final Appendable out;

  // if you quit the game you have quitter status.
  private boolean quitter = false;

  /**
   * Construct MarbleSolitaireControllerImpl. Throws IllegalArguments when in or out or null.
   *
   * @param in  Readable in.
   * @param out Appendable out.
   * @throws IllegalArgumentException if in or out are null.
   */
  public MarbleSolitaireControllerImpl(Readable in, Appendable out) {
    this.in = in;
    this.out = out;

    if (in == null || out == null) {
      throw new IllegalArgumentException("No readable/a");
    }
  }

  /**
   * Determines if string is int after converting it.
   *
   * @returns Boolean, true if is an int.
   */
  private boolean isInt(String s) {
    try {
      Integer.parseInt(s);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  /**
   * Determines if string is bad input (letter or negative).
   *
   * @returns Boolean, true if is bad input.
   */
  private boolean bad(String s) {
    return !(isInt(s));
  }

  /**
   * Determines if string is q or Q.
   *
   * @returns true if is q or Q.
   */
  private void isQuit(String col, MarbleSolitaireModel model) {
    if (col.equals("q") || col.equals("Q")) {
      try {
        this.out.append("\nGame quit!\nState of game when quit:\n" +
                model.getGameState() + "\n" +
                "Score: " + model.getScore() + "\n");
      } catch (IOException e) {
        throw new IllegalStateException();
      }
      quitter = true;
    }
  }

  /**
   * Takes the model as a parameter and appends input to output, displaying the state of game as
   * determined by the model. I removed stack trace and printing in A8 and throw
   * formatnumberexceptions instead.
   *
   * @returns void.
   */
  @Override
  public void playGame(MarbleSolitaireModel model) {
    String col;
    String row;
    String colTo;
    String rowTo;
    // string input by the user will be converted to irow/cols and fed to the model.
    int iCol;
    int iRow;
    int iColTo;
    int iRowTo;

    if (model == null) {
      throw new IllegalArgumentException();
    }

    // scanner takes Readable in
    Scanner scan = new Scanner(this.in);

    // Label used to break from this loop.
    outerloop:
    while (!model.isGameOver() && scan.hasNext()) {

      // board's original state.
      try {
        this.out.append(
                model.getGameState() + "\n" +
                        "Score: " + model.getScore() + "\n");
      } catch (IOException e) {
        throw new IllegalStateException();

      }
      // col is set to next user input.
      // isQuit determines if program should quit based on what was.
      // input and updates quitter status. If quit, then break from while loop.
      try {
        col = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException();
      }
      isQuit(col, model);
      if (quitter) {
        break;
      }
      // While the input is bad, program will ask to input again and will scan for col again.
      // IsQuit must be checked within this loop in case the user wants to quit at that stage.
      while (bad(col)) {
        try {
          this.out.append("Invalid move. Play again.\n");
        } catch (IOException e) {
          throw new IllegalStateException();
        }
        try {
          col = scan.next();
        } catch (NoSuchElementException e) {
          throw new IllegalStateException();
        }
        isQuit(col, model);
        if (quitter) {
          // breaks from main loop to avoid any more scans which would occur with a regular break.
          break outerloop;
        }
      }
      // row is set to next user input.

      try {
        row = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException();
      }
      isQuit(row, model);
      if (quitter) {
        break;
      }

      while (bad(row)) {
        try {
          this.out.append("Invalid move. Play again.\n");
        } catch (IOException e) {
          throw new IllegalStateException();
        }
        try {
          row = scan.next();
        } catch (NoSuchElementException e) {
          throw new IllegalStateException();
        }
        isQuit(row, model);
        if (quitter) {
          break outerloop;
        }
      }
      // colTo is set to next user input.
      try {
        colTo = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException();
      }
      isQuit(colTo, model);
      if (quitter) {
        break;
      }

      while (bad(colTo)) {
        try {
          this.out.append("Invalid move. Play again.\n");
        } catch (IOException e) {
          throw new IllegalStateException();
        }
        try {
          colTo = scan.next();
        } catch (NoSuchElementException e) {
          throw new IllegalStateException();
        }
        isQuit(colTo, model);
        if (quitter) {
          break outerloop;
        }
      }

      // rowTo is set to next user input.
      try {
        rowTo = scan.next();
      } catch (NoSuchElementException e) {
        throw new IllegalStateException();
      }
      isQuit(rowTo, model);
      if (quitter) {
        break;
      }

      while (bad(rowTo)) {
        try {
          this.out.append("Invalid move. Play again.\n");
        } catch (IOException e) {
          throw new IllegalStateException();
        }
        try {
          rowTo = scan.next();
        } catch (NoSuchElementException e) {
          throw new IllegalStateException();
        }
        isQuit(rowTo, model);
        if (quitter) {
          break outerloop;
        }
      }

      // Now that we have all the inputs we use iCol, Irow etc to parse since at this point
      // we should have something that can be converted to an integer.
      try {
        iCol = Integer.parseInt(col);
      } catch (NumberFormatException nfe) {
        throw new NumberFormatException("Number format exception.");
      }

      try {
        iRow = Integer.parseInt(row);
      } catch (NumberFormatException nfe) {
        throw new NumberFormatException("Number format exception.");
      }

      try {
        iColTo = Integer.parseInt(colTo);
      } catch (NumberFormatException nfe) {
        throw new NumberFormatException("Number format exception.");
      }

      try {
        iRowTo = Integer.parseInt(rowTo);
      } catch (NumberFormatException nfe) {
        throw new NumberFormatException("Number format exception.");
      }

      try {
        model.move(iCol - 1, iRow - 1, iColTo - 1, iRowTo - 1);
      } catch (IllegalArgumentException e) {
        try {
          this.out.append("try again.\n");

        } catch (IOException ioException) {
          throw new IllegalStateException();
        }
      }

      try {
        this.out.append(model.getGameState() + "\n" + "Score: " + model.getScore() + "\n");
      } catch (IOException e) {
        throw new IllegalStateException();
      }
      //MarbleSolitaireModelImpl

    }

    // Quitter status break from while loop is here. To avoid triggering the below code,
    // it will not run if there is quitter status.
    if (model.isGameOver() && !quitter) {
      try {
        // append game over state and show score.
        this.out.append("\nGame over!\n" +
                model.getGameState() + "\n" +
                "Score: " + model.getScore() + "\n");


      } catch (IOException e) {
        throw new IllegalStateException();
      }
    }
    // ISE if out is empty.
    if ("".equals(this.out.toString())) {
      throw new IllegalStateException();
    }
  }
}

