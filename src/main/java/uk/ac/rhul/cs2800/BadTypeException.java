 package uk.ac.rhul.cs2800;



/**
 * This class is an exception thrown when the method called doesnt match the type.
 *
 * @author ZKAC354
 */
public class BadTypeException extends Exception {

  /**
   * The constructor calls the toString method as soon as its created to ensure the user understands
   * the exception.
   */
  public BadTypeException() {
    toString();
  }

  /**
   * This method prints a user friendly message when the exception is thrown.
   */
  public String toString() {
    return "INCORRECT TYPE FOR METHOD";
  }

}
