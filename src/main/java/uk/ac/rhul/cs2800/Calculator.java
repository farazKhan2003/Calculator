package uk.ac.rhul.cs2800;

/**
 * The interface which defines a Calculator (whether that be infix or postfix).
 * 
 * @author ZKAC354
 *
 */
public interface Calculator {

  /**
   * Called to actually evaluate an arithmetic expression.
   * 
   * @param expression the arithmetic expression
   * @return the evaluation
   * @throws BadTypeException Thrown when the incorrect Type is handled
   * @throws InvalidExpressionException Thrown when an expression cannot be handled.
   */
  public Float evaluate(String expression) throws InvalidExpressionException, BadTypeException;

}
