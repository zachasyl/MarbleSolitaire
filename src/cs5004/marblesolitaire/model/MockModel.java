package cs5004.marblesolitaire.model;

import java.util.Objects;

/**
 * This class represents a mock implementation of the MSM. It offers the operations and constructors
 * for a Marble Solitaire game but they are used for testing purposes and only move is used for
 * testing purposes (to determine if the model receives correct info from the controller.
 */
public class MockModel implements MarbleSolitaireModel {
  private final StringBuilder log;

  public MockModel(StringBuilder log) {
    this.log = Objects.requireNonNull(log);
  }

  /**
   * This class appends row, col, torow, and tocol so they can be compared in the
   * MarbleSolitaireControllerImplTest.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    log.append(fromRow + " " + fromCol + " " + toRow + " " + toCol);

  }

  /**
   * Not used for testing.
   */
  @Override
  public boolean isGameOver() {
    return false;
  }

  /**
   * Not used for testing.
   */
  @Override
  public String getGameState() {
    return null;
  }

  /**
   * Not used for testing.
   */
  @Override
  public int getScore() {
    return 0;
  }
}
