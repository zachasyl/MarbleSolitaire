package cs5004.marblesolitaire;

import java.io.InputStreamReader;

import cs5004.marblesolitaire.controller.MarbleSolitaireController;
import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs5004.marblesolitaire.model.hw08.EuropeanSolitaireModelImpl;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import cs5004.marblesolitaire.model.hw08.TriangleSolitaireModelImpl;

// I gave up/ran out of time and brute forced this the assignment is so long....

/**
 * Main class used to connect with the controller.
 */
public class MarbleSolitaire {
  /**
   * main fn used to take in args and direct controller to play appropriate board.
   */
  public static void main(String[] args) {

    MarbleSolitaireController controller
            = new MarbleSolitaireControllerImpl(new InputStreamReader(System.in), System.out);

    if (args.length == 1) {
      if (args[0].equals("english")) {
        controller.playGame(new MarbleSolitaireModelImpl());
      } else if (args[0].equals("european")) {
        controller.playGame(new EuropeanSolitaireModelImpl());
      } else {
        controller.playGame(new TriangleSolitaireModelImpl());
      }
    }

    if (args.length == 3) {
      if (args[0].equals("english") && args[1].equals("-size")) {
        controller.playGame(new MarbleSolitaireModelImpl(Integer.parseInt(args[2])));
      } else if (args[0].equals("european") && args[1].equals("-size")) {
        controller.playGame(new EuropeanSolitaireModelImpl(Integer.parseInt(args[2])));
      } else if (args[0].equals("triangular") && args[1].equals("-size")) {
        controller.playGame(new TriangleSolitaireModelImpl(Integer.parseInt(args[2])));
      } else if (args[0].equals("english") && args[1].equals("-hole")) {
        controller.playGame(new MarbleSolitaireModelImpl((Integer.parseInt(args[2])),
                Integer.parseInt(args[3])));
      } else if (args[0].equals("european") && args[1].equals("-hole")) {
        controller.playGame(new EuropeanSolitaireModelImpl((Integer.parseInt(args[2])),
                Integer.parseInt(args[3])));
      } else {
        controller.playGame(new TriangleSolitaireModelImpl((Integer.parseInt(args[2])),
                Integer.parseInt(args[3])));
      }
    }

    if (args.length == 6) {
      if ((args[0].equals("english")) && (args[1].equals("-size") && args[3].equals("-hole"))) {
        controller.playGame(new MarbleSolitaireModelImpl(Integer.parseInt(args[2]),
                Integer.parseInt(args[4]), Integer.parseInt(args[5])));
      }
      if ((args[0].equals("triangular")) && (args[1].equals("-size") && args[3].equals("-hole"))) {
        controller.playGame(new TriangleSolitaireModelImpl(Integer.parseInt(args[2]),
                Integer.parseInt(args[4]), Integer.parseInt(args[5])));
      }
      if ((args[0].equals("european")) && (args[1].equals("-size") && args[3].equals("-hole"))) {
        controller.playGame(new EuropeanSolitaireModelImpl(Integer.parseInt(args[2]),
                Integer.parseInt(args[4]), Integer.parseInt(args[5])));
      }
      // always order size, row column input parameters.
      if ((args[0].equals("english")) && (args[1].equals("-hole") && args[4].equals("-size"))) {
        controller.playGame(new MarbleSolitaireModelImpl(Integer.parseInt(args[5]),
                Integer.parseInt(args[2]), Integer.parseInt(args[3])));
      }
      if ((args[0].equals("triangular")) && (args[1].equals("-hole") && args[4].equals("-size"))) {
        controller.playGame(new TriangleSolitaireModelImpl(Integer.parseInt(args[5]),
                Integer.parseInt(args[2]), Integer.parseInt(args[3])));
      }

      if ((args[0].equals("european")) && (args[1].equals("-size") && args[4].equals("-hole"))) {
        controller.playGame(new EuropeanSolitaireModelImpl(Integer.parseInt(args[5]),
                Integer.parseInt(args[2]), Integer.parseInt(args[3])));
      }
    }
  }
}

