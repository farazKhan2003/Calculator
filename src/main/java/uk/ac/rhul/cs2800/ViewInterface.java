package uk.ac.rhul.cs2800;

/**
 * The interface responsible for choosing the View Type.
 * 
 * @author ZKAC354
 *
 */
public interface ViewInterface {


  /**
   * This will set the result to the result field on the GUI.
   *
   * @param s The final total of the expression
   */
  void setResult(String s);

  /**
   * This will return the expression input by the user.
   * 
   * @return the expression input by the user
   */
  String getExpression();

  /**
   * This will check if the expression inputted by the user is in infix notation.
   * 
   * @return boolean for whether infix button has been pressed` 1
   */
  boolean getIsInfix();



}

