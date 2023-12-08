package uk.ac.rhul.cs2800;

/**
 * This class will determine what symbol has been inputted to the calculator.
 *
 * @author ZKAC354
 *
 */
public enum Symbol {
  /**
   * LEFT_BRACKET - the symbol is a (, determines where the priority order starts.
   */
  LEFT_BRACKET("("),
  /**
   * RIGHT_BRACKET - the symbol is a ), determines where the priority order ends.
   */
  RIGHT_BRACKET(")"),
  /**
   * TIMES - the symbol is a *, multiplies two nums.
   */
  TIMES("*"),
  /**
   * DIVIDE - the symbol is a /, divides two nums.
   */
  DIVIDE("/"),
  /**
   * PLUS - the symbol is a +, adds two nums together.
   */
  PLUS("+"),
  /**
   * MINUS - the symbol is a -, subtracts two nums together or prefixes a negative num.
   */
  MINUS("-"),
  /**
   * INVALID - the symbol is not recognised ERROR.
   */
  INVALID("INVALID");

  public final String label;

  Symbol(String string) {
    label = string;
  }

  /**
   * This method will give a text representation for the symbol.
   *
   * @return this returns the text form of the symbol or an INVALID warning
   */
  public String toString() {
    return label;
  }
}
