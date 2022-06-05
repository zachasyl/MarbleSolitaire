import org.junit.Test;

import cs5004.marblesolitaire.model.hw08.EuropeanSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for EuroMarbleSolitaireControllerImpl.
 */
public class EuropeanSolitaireModelImplTest {


  @Test
  public void testDefaultLR() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();

    game.getGameState();
    game.getScore();
    //right
    game.move(3, 1, 3, 3);
    game.getGameState();
    game.getScore();
    //left
    game.move(3, 4, 3, 2);


    game.getScore();
    assertEquals(

            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O _ O _ _ O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", game.getGameState());
  }

  /**
   * game state on Default constructor after making a valid move down and a valid move up.
   */
  @Test
  public void testDefaultUD() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();

    game.getGameState();
    game.getScore();
    //down
    game.move(1, 3, 3, 3);
    game.getGameState();
    //up
    game.move(4, 3, 2, 3);

    game.getScore();
    assertEquals(

            "    O O O\n" +
                    "  O O _ O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O _ O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", game.getGameState());

  }

  /**
   * game state on AT constructor with same AT as default.
   */
  @Test
  public void testAT() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3);

    assertEquals(
            "    O O O\n" +
                    "  O O O O O\n" +
                    "O O O O O O O\n" +
                    "O O O _ O O O\n" +
                    "O O O O O O O\n" +
                    "  O O O O O\n" +
                    "    O O O", game.getGameState()

    );
  }


  /**
   * Tests whether constructor can take in R and C and make a board with a specified _ and AR.
   */
  @Test
  public void testUniqueEmpty() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3, 1, 3);

    assertEquals("    O O O\n" +
            "  O O _ O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", game.getGameState());
  }

  /**
   * Tests whether constructor can take in R and C and make a board with a specified _ and AR. and
   * row is 0, this one was failing on JUnit for a while.
   */
  @Test
  public void testUniqueEmpty2() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(5, 0, 4);

    assertEquals("        _ O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", game.getGameState());
  }


  /**
   * Tests whether constructor can take in R and C and make a board with a specified _ and AR. and
   * that you may move to the upper left corner.
   */
  @Test
  public void testUpCornerLeftLegal() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3, 1, 1);
    game.move(3, 1, 1, 1);

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O _ O O O O O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", game.getGameState());
  }

  /**
   * Tests whether constructor can take in R and C and make a board with a specified _ and AR. and
   * can move to upper right corner.
   */
  @Test
  public void testUpCornerRightLegal() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3, 1, 5);
    game.move(3, 5, 1, 5);

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O _ O\n" +
            "O O O O O _ O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", game.getGameState());
  }


  /**
   * Tests whether constructor can take in R and C and make a board with a specified _ and AR. and
   * can move to lower left corner.
   */
  @Test
  public void testLowerLeftLegal() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3, 5, 1);
    game.move(3, 1, 5, 1);

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ O O O O O\n" +
            "O _ O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", game.getGameState());
  }

  /**
   * Tests whether constructor can take in R and C and make a board with a specified _ and AR. and
   * can move to lower right corner.
   */
  @Test
  public void testLowerRightLegal() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3, 5, 5);
    game.move(3, 5, 5, 5);

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "O O O O O _ O\n" +
            "  O O O O O\n" +
            "    O O O", game.getGameState());
  }

  /**
   * Tests whether constructor can take in R and C and make a board with a specified _ and AR. and
   * can move FROM lower right corner.
   */
  @Test
  public void testLowerRightLegalfrom() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3, 3, 5);
    game.move(5, 5, 3, 5);

    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O _ O\n" +
            "  O O O O _\n" +
            "    O O O", game.getGameState());
  }

  /**
   * tests cant move diagonal in corners.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDiagCorner() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(5, 2, 2);
    game.move(4, 0, 2, 2);
  }

  /**
   * tests cant move diagonal in non corners.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDiagNonCorner() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(5, 0, 4);
    game.move(2, 6, 0, 4);
  }

  /**
   * tests cant move to marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testtoMarble() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();
    game.move(0, 3, 0, 5);
  }

  /**
   * tests cant move from space.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testfromspace() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();
    game.move(3, 3, 3, 1);
    assertEquals("", game.getGameState());
  }

  /**
   * Tests you cannot make a starting empty slot in one of the empty four corners.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testUniqueEmpty3() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3, 0, 0);

  }

  /**
   * Tests invalid start.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStart() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(-30, -1);

  }

  /**
   * Tests invalid start with 3 params. Added for Assignment 7.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidStart2() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3, -30, -1);

  }

  /**
   * Tests gameOver on default state. no moves.
   */
  @Test
  public void testGameOverDefault() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();

    assertEquals(false, game.isGameOver());

  }

  /**
   * tests is game over for board where game is not over, board of size 1 blank no marbles.
   */
  @Test
  public void GameOverYes() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(1);

    assertEquals(true, game.isGameOver());
  }

  /**
   * testMovesNotSameRowNorColumn. On a board of arm length 3 and default empty cell, should not be
   * able to move from (1,2) to (3,3). Illegal Argument should be thrown.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveDiffRowCol() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3);
    game.getGameState();
    game.move(1, 2, 3, 3);

  }

  /**
   * tests user cannot create a gameboard with even armthickness.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEvenAT() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(10);
    game.getGameState();
  }

  /**
   * tests user cannot move out of bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutOfBounds() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3);
    game.move(1, 3, 90, 40);
  }

  /**
   * tests user cannot move from position out of bounds.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveFromOfBounds() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3);
    game.move(90, 40, 1, 3);
  }

  /**
   * tests user cannot move where starting.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveToStart() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3);
    game.move(1, 3, 1, 3);
  }

  /**
   * tests user must select marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSelectMarble() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3);
    game.move(3, 3, 1, 3);
  }

  /**
   * tests user must move to empty space.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptySpace() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3);
    game.move(1, 2, 1, 2);
  }

  /**
   * tests cant move more than one apart.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoreThanOneApart() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(3);
    game.move(0, 2, 3, 3);
  }

  /**
   * tests cant move one apart within the corner illegal.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testICloseCorner() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(5);
    game.move(0, 0, 0, 1);
  }

  /**
   * tests cant move one apart within the corner legal squares..
   */
  @Test(expected = IllegalArgumentException.class)
  public void testCloseCorner() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl(0, 2);
    game.move(0, 3, 0, 2);
  }

  /**
   * Tests score for euro impl.
   */
  @Test
  public void EUroScore() {
    EuropeanSolitaireModelImpl game = new EuropeanSolitaireModelImpl();

    assertEquals(36, game.getScore());
  }
}