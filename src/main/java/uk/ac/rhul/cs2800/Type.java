package uk.ac.rhul.cs2800;

/**
 * This class will differentiate numbers, string and symbols in the calculator.
 *
 * @author ZKAC354
 *
 */
public enum Type {
  /**
   * NUMBER - the type is a number.
   */
  NUMBER,
  /**
   * STRING - the type is a letter (algebra) or a command (integrate).
   */
  STRING,
  /**
   * SYMBOL - the type is a symbol (+-/* ect..).
   */
  SYMBOL,
  /**
   * INVALID - the type cannot be determined ERROR.
   */
  INVALID;

  /**
   * This method gives a text representation for the type of input in the calc.
   */
  public String toString() {
    switch (this) {
      case NUMBER:
        return "NUMBER";
      case STRING:
        return "STRING";
      case SYMBOL:
        return "SYMBOL";
      case INVALID:
        return "INVALID";
      default:
        return "INVALID";
    }
  }

}
