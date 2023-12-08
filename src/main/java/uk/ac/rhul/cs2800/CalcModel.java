package uk.ac.rhul.cs2800;


/**
 * This will determine what type of calculator is used.
 * 
 * 
 * @author ZKAC354
 *
 */
public class CalcModel {
  private Calculator revPolCalc = new RevPolishCalc();
  private Calculator infixCalc = new InfixCalc();

  /**
   * Evaluates the users expression in either infix or postfix notation determined by the user.
   * 
   * @param expression the expression entered into the box by the User.
   * @param isInfix whether the user has ticked the infix radio button.
   * @return the result of the expression
   * @throws InvalidExpressionException thrown when the expression is imbalanced or in the wrong
   *         notation
   * @throws BadTypeException thrown when the wrong notation is entered
   */
  public float evaluate(String expression, boolean isInfix)
      throws InvalidExpressionException, BadTypeException {
    if (isInfix == true) {
      return infixCalc.evaluate(expression);
    }

    return revPolCalc.evaluate(expression);


  }
}
