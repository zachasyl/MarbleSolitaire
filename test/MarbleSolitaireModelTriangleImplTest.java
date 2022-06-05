import org.junit.Test;

import cs5004.marblesolitaire.model.hw08.TriangleSolitaireModelImpl;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class MarbleSolitaireModelTriangleImpl.
 */
public class MarbleSolitaireModelTriangleImplTest {

  /**
   * Default triangle.
   */
  @Test
  public void testDefault() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();


    assertEquals(


            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O", game.getGameState());

  }

  /**
   * Tests user can create triangle with speicfied dimensions. Also tests odd is okay.
   */
  @Test
  public void testDimensionsOdd() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(7);

    assertEquals(

            "      _\n" +
                    "     O O\n" +
                    "    O O O\n" +
                    "   O O O O\n" +
                    "  O O O O O\n" +
                    " O O O O O O\n" +
                    "O O O O O O O", game.getGameState());

  }

  @Test
  public void testDimensionsTiny() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(2);

    assertEquals(

            " _\n" +
                    "O O", game.getGameState());

  }

  /**
   * Tests user can create triangle with speicfied dimensions. Also tests even is okay.
   */
  @Test
  public void testDimensions() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(6);

    assertEquals(

            "     _\n" +
                    "    O O\n" +
                    "   O O O\n" +
                    "  O O O O\n" +
                    " O O O O O\n" +
                    "O O O O O O", game.getGameState());

  }

  /**
   * Tests user cant create board with zero as dimensions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDimensionsIllegal() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(0);

    assertEquals(

            "     _\n" +
                    "    O O\n" +
                    "   O O O\n" +
                    "  O O O O\n" +
                    " O O O O O\n" +
                    "O O O O O O", game.getGameState());

  }

  /**
   * Tests user cant create board with negative dimensions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDimensionsIllegal2() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(-300);

    assertEquals(

            "     _\n" +
                    "    O O\n" +
                    "   O O O\n" +
                    "  O O O O\n" +
                    " O O O O O\n" +
                    "O O O O O O", game.getGameState());

  }

  /**
   * Tests user can specifiy row and col of blank.
   */
  @Test
  public void testRowCol() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(4, 4);

    assertEquals(

            "    O\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O _", game.getGameState());

  }

  /**
   * Tests user can create board with dimensions row and col.
   */
  @Test
  public void testDimensionRowCol() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(2, 0, 0);
    assertEquals(" _\n" +
            "O O", game.getGameState());
  }

  /**
   * Tests user can't create empty slot where c > r meaning empty slot is right of circle and
   * actually in disallowed area.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDimensionRowColIllegal() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(2, 0, 1);
  }

  /**
   * Tests moving and capturing rightward works.
   */
  @Test
  public void testHorizonRight() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(4, 4);
    game.move(4, 2, 4, 4);


    assertEquals(

            "    O\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O _ _ O", game.getGameState());

  }

  /**
   * Tests moving and capturing leftward works.
   */
  @Test
  public void testHorizonLeft() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(4, 2);
    game.move(4, 4, 4, 2);


    assertEquals(

            "    O\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O _ _", game.getGameState());

  }

  /**
   * Default triangle. 00 10.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testcantMoveFromEmpty() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();
    game.move(0, 0, 1, 0);


    assertEquals(


            "    _\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O O O", game.getGameState());

  }

  /**
   * Testing cant move upward 1 because too close.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testVerticalUp() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();
    game.move(1, 0, 0, 0);


    assertEquals(

            "    O\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O _ _", game.getGameState());

  }

  /**
   * Testing cant move upward 1 because too close diag.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testVerticalDown() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(1, 0);
    game.move(0, 0, 1, 0);


    assertEquals(

            "    O\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O O _ _", game.getGameState());

  }

  /**
   * Tests pos with 4,2 blank because this will be used as blank in diag checks.
   */
  @Test
  public void test42Blank() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(4, 2);

    assertEquals(

            "    O\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "O O _ O O", game.getGameState());

  }

  /**
   * Tests negative slope legal diag move. To row higher than from row.
   */
  @Test
  public void testDiagNeg() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(4, 2);
    game.move(2, 2, 4, 2);

    assertEquals(

            "    O\n" +
                    "   O O\n" +
                    "  O O _\n" +
                    " O O _ O\n" +
                    "O O O O O", game.getGameState());
  }

  /**
   * Tests negative slope legal diag move. from row higher than to row.
   */
  @Test
  public void testDiagneg2() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();
    game.move(2, 2, 0, 0);

    assertEquals(

            "    O\n" +
                    "   O _\n" +
                    "  O O _\n" +
                    " O O O O\n" +
                    "O O O O O", game.getGameState());

  }

  /**
   * Tests pos with 0,4 blank because this will be used as blank in diag checks.
   */
  @Test
  public void test42Blank2() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(4, 0);

    assertEquals(

            "    O\n" +
                    "   O O\n" +
                    "  O O O\n" +
                    " O O O O\n" +
                    "_ O O O O", game.getGameState());
  }

  /**
   * Tests positive slope legal diag move.
   */
  @Test
  public void testDiagsPos() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(4, 0);
    game.move(2, 0, 4, 0);

    assertEquals(

            "    O\n" +
                    "   O O\n" +
                    "  _ O O\n" +
                    " _ O O O\n" +
                    "O O O O O", game.getGameState());

  }


  /**
   * Tests cannot move FROM illegal position where 0,2 is illegal and 01 would be the tip.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveFromIllegalPosition() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();
    game.move(0, 2, 0, 0);

    assertEquals(

            "    O\n" +
                    "   O O\n" +
                    "  _ O O\n" +
                    " _ O O O\n" +
                    "O O O O O", game.getGameState());

  }

  /**
   * Tests cannot move TO illegal position where 0,1 is legal (the tip) and 02 is illegal because it
   * is not a marble.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveToIllegalPosition() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();
    game.move(0, 1, 0, 2);

    assertEquals(

            "    O\n" +
                    "   O O\n" +
                    "  _ O O\n" +
                    " _ O O O\n" +
                    "O O O O O", game.getGameState());

  }


  /**
   * Tests score for triangle impl.
   */
  @Test
  public void triangleScore() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();

    assertEquals(14, game.getScore());
  }

  /**
   * tests is game over for initial board, game not over.
   */
  @Test
  public void GameOverNo() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();

    assertEquals(false, game.isGameOver());
  }

  /**
   * tests is game over for board where game is not over, board of size 1 blank no marbles.
   */
  @Test
  public void GameOverYes() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(1);

    assertEquals(true, game.isGameOver());
  }

  /**
   * tests game isnt over because a diagonal is possible.
   */
  @Test(expected = IllegalArgumentException.class)
  public void GameOverDiag() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl(3, 2);
  }


  /**
   * tests is game over for board where game is not over, board of size 1 blank no marbles.
   */
  @Test
  public void GameOverDefault() {
    TriangleSolitaireModelImpl game = new TriangleSolitaireModelImpl();

    assertEquals(false, game.isGameOver());
  }
}


