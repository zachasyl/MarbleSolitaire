package cs5004.marblesolitaire.controller;

import cs5004.marblesolitaire.model.MarbleSolitaireModel;

/**
 * This interface contains all controller's public operations.
 */
public interface MarbleSolitaireController {

  /**
   * Takes the model as a parameter and appends input to output, displaying the state of game as
   * determined by the model.
   *
   * @returns void.
   */
  void playGame(MarbleSolitaireModel model);
}
