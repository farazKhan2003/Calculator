package uk.ac.rhul.cs2800;

/**
 * This class is an exception thrown when the expression cannot be evaluated.
 *
 * @author ZKAC354
 */
public class InvalidExpressionException extends Exception {

  /**
   * The constructor calls the toString method as soon as its created to ensure the user understands
   * the exception.
   */
  public InvalidExpressionException() {
    toString();
  }

  /**
   * This method prints a user friendly message when the exception is thrown.
   */
  public String toString() {
    return "INVALID EXPRESSSION, PLEASE TRY AGAIN";
  }

}
