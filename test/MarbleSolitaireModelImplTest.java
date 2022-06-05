import org.junit.Test;

import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class MarbleSolitaireModelImpl.
 */
public class MarbleSolitaireModelImplTest {


  /**
   * game state on Default constructor after making a valid move right and a valid move left.
   */
  @Test
  public void testDefaultLR() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl();

    game.getGameState();
    game.getScore();

    game.move(3, 1, 3, 3);
    game.getGameState();
    game.getScore();
    game.move(3, 4, 3, 2);


    game.getScore();
    assertEquals(

            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O _ O _ _ O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", game.getGameState());

  }

  /**
   * game state on Default constructor after making a valid move down and a valid move up.
   */
  @Test
  public void testDefaultUD() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl();

    game.getGameState();
    game.getScore();

    game.move(1, 3, 3, 3);
    game.getGameState();
    game.move(4, 3, 2, 3);


    game.getScore();
    assertEquals(

            "    O O O\n" +
                    "    O _ O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O _ O O O\n" +
                    "    O O O\n" +
                    "    O O O", game.getGameState());

  }

  /**
   * game state on AT constructor with same AT as default.
   */
  @Test
  public void testAT() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3);

    assertEquals(
            "    O O O\n" +
                    "    O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "    O O O\n" +
                    "    O O O", game.getGameState()

    );
  }


  /**
   * Tests whether constructor can take in R and C and make a board with a specified _ and AR.
   */
  @Test
  public void testUniqueEmpty() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3, 0, 3);

    assertEquals("    O _ O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", game.getGameState());
  }

  /**
   * Tests whether constructor can take in R and C and make a board with a specified _. and use
   * default AR.
   */
  @Test
  public void testSRConstructor() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(0, 3);

    assertEquals("    O _ O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", game.getGameState());
  }

  /**
   * Tests invalid start. Added for Assignment 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStart() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(-30, -1);

  }

  /**
   * Tests invalid start with 3 params. Added for Assignment 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStart2() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3, -30, -1);

  }

  /**
   * game state on AT constructor with 5 AT.
   */
  @Test
  public void testAT2() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(5);

    assertEquals(
            "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O _ O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O", game.getGameState()

    );
  }

  /**
   * tests move on unique AR.
   */
  @Test
  public void testMoveUnique() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(5);
    game.move(6, 4, 6, 6);
    assertEquals(

            "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O _ _ O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "O O O O O O O O O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O\n" +
                    "        O O O O O"


            , game.getGameState()
    );
  }

  /**
   * Tests gameOver on default state. no moves.
   */
  @Test
  public void testGameOverDefault() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl();

    assertEquals(false, game.isGameOver());

  }

  /**
   * testMovesNotSameRowNorColumn. On a board of arm length 3 and default empty cell, should not be
   * able to move from (1,2) to (3,3). Illegal Argument should be thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveDiffRowCol() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3);
    game.getGameState();
    game.move(1, 2, 3, 3);

  }

  /**
   * tests user cannot create a gameboard with even armthickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEvenAT() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(10);
    game.getGameState();
  }

  /**
   * tests user cannot move out of bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutOfBounds() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3);
    game.move(1, 3, 90, 40);
  }

  /**
   * tests user cannot move from position out of bounds. Added Assignment 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveFromOfBounds() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3);
    game.move(90, 40, 1, 3);
  }

  /**
   * tests user cannot move where starting.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveToStart() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3);
    game.move(1, 3, 1, 3);
  }

  /**
   * tests user must select marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSelectMarble() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3);
    game.move(3, 3, 1, 3);
  }

  /**
   * tests user must move to empty space.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptySpace() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3);
    game.move(1, 2, 1, 2);
  }

  /**
   * tests cant move more than one apart.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoreThanOneApart() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3);
    game.move(0, 2, 3, 3);
  }

  /**
   * Tests game over / losing the game.
   */
  @Test
  public void testGameOverLose() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl();
    game.move(1, 3, 3, 3);
    game.move(4, 3, 2, 3);
    game.move(6, 3, 4, 3);
    game.move(3, 1, 3, 3);
    game.move(3, 4, 3, 2);
    game.move(3, 6, 3, 4);

    assertEquals(true, game.isGameOver());

  }

  /**
   * Tests game over / winning the game.... thanks cole.
   */
  @Test
  public void testGameOverWin() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3, 3);
    game.move(5, 3, 3, 3);
    game.move(4, 5, 4, 3);
    game.move(6, 4, 4, 4);
    game.move(6, 2, 6, 4);
    game.move(3, 4, 5, 4);
    game.move(6, 4, 4, 4);
    game.move(1, 4, 3, 4);
    game.move(2, 6, 2, 4);
    game.move(4, 6, 2, 6);
    game.move(2, 3, 2, 5);
    game.move(2, 6, 2, 4);
    game.move(2, 1, 2, 3);
    game.move(0, 2, 2, 2);
    game.move(3, 2, 1, 2);
    game.move(0, 4, 0, 2);
    game.move(0, 2, 2, 2);
    game.move(5, 2, 3, 2);
    game.move(4, 0, 4, 2);
    game.move(2, 0, 4, 0);
    game.move(4, 3, 4, 1);
    game.move(4, 0, 4, 2);
    game.move(2, 3, 2, 5);
    game.move(2, 5, 4, 5);
    game.move(4, 5, 4, 3);
    game.move(4, 3, 4, 1);
    game.move(4, 1, 2, 1);
    game.move(2, 1, 2, 3);
    game.move(3, 3, 3, 5);
    game.move(1, 3, 3, 3);
    game.move(3, 2, 3, 4);
    game.move(3, 5, 3, 3);
    assertEquals(true, game.isGameOver());

  }

  /**
   * Tests game over / winning the game, the score.... thanks cole.
   */
  @Test
  public void testGameOverWinScore() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl(3, 3);
    game.move(5, 3, 3, 3);
    game.move(4, 5, 4, 3);
    game.move(6, 4, 4, 4);
    game.move(6, 2, 6, 4);
    game.move(3, 4, 5, 4);
    game.move(6, 4, 4, 4);
    game.move(1, 4, 3, 4);
    game.move(2, 6, 2, 4);
    game.move(4, 6, 2, 6);
    game.move(2, 3, 2, 5);
    game.move(2, 6, 2, 4);
    game.move(2, 1, 2, 3);
    game.move(0, 2, 2, 2);
    game.move(3, 2, 1, 2);
    game.move(0, 4, 0, 2);
    game.move(0, 2, 2, 2);
    game.move(5, 2, 3, 2);
    game.move(4, 0, 4, 2);
    game.move(2, 0, 4, 0);
    game.move(4, 3, 4, 1);
    game.move(4, 0, 4, 2);
    game.move(2, 3, 2, 5);
    game.move(2, 5, 4, 5);
    game.move(4, 5, 4, 3);
    game.move(4, 3, 4, 1);
    game.move(4, 1, 2, 1);
    game.move(2, 1, 2, 3);
    game.move(3, 3, 3, 5);
    game.move(1, 3, 3, 3);
    game.move(3, 2, 3, 4);
    game.move(3, 5, 3, 3);
    assertEquals(1, game.getScore());
  }

  /**
   * Tests score on my loss.
   */
  @Test
  public void testScore() {
    MarbleSolitaireModelImpl game = new MarbleSolitaireModelImpl();
    game.move(1, 3, 3, 3);
    game.move(4, 3, 2, 3);
    game.move(6, 3, 4, 3);
    game.move(3, 1, 3, 3);
    game.move(3, 4, 3, 2);
    game.move(3, 6, 3, 4);

    assertEquals(26, game.getScore());

  }

}
