import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;

import cs5004.marblesolitaire.controller.MarbleSolitaireController;
import cs5004.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs5004.marblesolitaire.model.MarbleSolitaireModel;
import cs5004.marblesolitaire.model.MarbleSolitaireModelImpl;
import cs5004.marblesolitaire.model.MockModel;

import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class MarbleSolitaireControllerImpl.
 */
public class MarbleSolitaireControllerImplTest {

  /**
   * Tests that input to the controller that is sent to a model is the same, except that each string
   * input that can convert to an integer will be one less when it is utilized by the model.
   */
  @Test
  public void mockTest() {
    Reader in = new StringReader("4 2 4 4");
    StringBuilder out = new StringBuilder();

    MarbleSolitaireController mock = new MarbleSolitaireControllerImpl(in, out) {
    };
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel m = new MockModel(log);

    mock.playGame(m);
    assertEquals("3 1 3 3", log.toString());
  }

  /**
   * Tests that input to the controller sent to the model is  identical, except that each string
   * input that can convert to an integer will be one less when it is utilized by the model. An ISE
   * will be thrown because not enough numbers are input. This is just to show that regular
   * controller exceptions will be thrown just the same for any model.
   */
  @Test(expected = IllegalStateException.class)
  public void mockTest2() {
    Reader in = new StringReader("a 2 4 4");
    StringBuilder out = new StringBuilder();

    MarbleSolitaireController mock = new MarbleSolitaireControllerImpl(in, out) {
    };
    StringBuilder log = new StringBuilder();
    MarbleSolitaireModel m = new MockModel(log);

    mock.playGame(m);
  }

  //Invalid Inputs Tests:

  /**
   * Tests that an ISE will be thrown with a negative input.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidInputNegative() {
    Reader in = new StringReader("-500");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  /**
   * Tests that an ISE will be thrown with an input of zero.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidInputZero() {
    Reader in = new StringReader("0");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  /**
   * Tests that an ISE will be thrown with character input.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidInputCharacter() {
    Reader in = new StringReader("a");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  /**
   * Tests that an ISE will be thrown with character input.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidInputCharacterOther() {
    Reader in = new StringReader("!");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  /**
   * Tests that an ISE will be thrown with empty string input.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidInputCharacterOther2() {
    Reader in = new StringReader("");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  /**
   * Tests that you can quit after inputting invalid data since the isntructions say the program
   * should be able to quit at any time. THis tests that the label in ControllerImpls allows for the
   * exit from "outerloop."
   */
  @Test
  public void testInvalidThenQuit() {
    Reader in = new StringReader("a -493 q");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.\n" +

            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", out.toString());
  }

  // Valid Input Tests:

  /**
   * Tests that user may quit with Q.
   */
  @Test
  public void testQuitQ() {
    Reader in = new StringReader("Q");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", out.toString());
  }

  /**
   * Tests that user may quit with q.
   */
  @Test
  public void testQuitq() {
    Reader in = new StringReader("q");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", out.toString());
  }

  /**
   * Tests that user may input valid moves multiple of four after an invalid input.
   */
  @Test
  public void testInvalidFollowedByValid() {
    Reader in = new StringReader("z 4 2 4 4");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());
  }


  /**
   * Tests that an ISE will be thrown when no more valid input can be found.
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidTooFew() {
    Reader in = new StringReader("3 3 2");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  /**
   * Tests that an ISE will be thrown when no more valid input can be found (too many numbers, not
   * multiple of four).
   */
  @Test(expected = IllegalStateException.class)
  public void testInvalidTooManyNotMultiple() {
    Reader in = new StringReader("2 4 2 3 4 5 4");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
  }

  /**
   * Tests that an ISE will be thrown when no more valid input can be found (too many numbers, not
   * multiple of four).
   */
  @Test
  public void testValidMoves() {
    Reader in = new StringReader("4 2 4 4");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", out.toString());
  }

  /**
   * Tests one may input several valid moves without being a multiple of four and then quit.
   */
  @Test
  public void testValidThenQuit() {
    Reader in = new StringReader("4 4 q");
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(new MarbleSolitaireModelImpl());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", out.toString());

  }

  /**
   * Tests that an IllegalArgumentException is thrown when reader in is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void readerInNull() {
    Reader in = null;
    StringBuilder out = new StringBuilder();
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    MarbleSolitaireModelImpl x = new MarbleSolitaireModelImpl();
    controller.playGame(x);
  }

  /**
   * Tests that an IllegalArgumentException is thrown when reader out is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void readerOutNull() {
    Reader in = new StringReader("1 2 3 5 1 2 3 8");
    StringBuilder out = null;
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    MarbleSolitaireModelImpl x = new MarbleSolitaireModelImpl();
    controller.playGame(x);
  }

  /**
   * Tests that an IllegalArgumentException is thrown when model is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void modelNull() {
    Reader in = new StringReader("4 2 4 4");
    StringBuilder out = null;
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(in, out);
    controller.playGame(null);
  }

}