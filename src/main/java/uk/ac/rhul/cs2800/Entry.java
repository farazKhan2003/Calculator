package uk.ac.rhul.cs2800;

/**
 * This class holds the next entry in the calculator.
 *
 * @author ZKAC354
 */
public class Entry {

  /**
   * a default variable determining the number inputted.
   */
  private float number;
  /**
   * a default variable determining the String inputted, whether that be a command or algebra.
   */
  private String str;
  /**
   * a default variable differentiating the inputs from each other.
   */
  private  Type type;
  /**
   * a default variable differentiating symbols from other input types.
   */
  private Symbol other;


  /**
   * A constructor for number inputs, assigns the NUMBER type and a float.
   *
   * @param inpFloat the number inputted into the calculator
   */
  public Entry(float inpFloat) {
    this.number = inpFloat;
    this.type = Type.NUMBER;
  }


  /**
   * A constructor for String inputs, assigns the STRING type and a string.
   *
   * @param inpString the string inputted into the calculator
   */
  public Entry(String inpString) {
    this.str = inpString;
    this.type = Type.STRING;

  }

  /**
   * A constructor for Symbol inputs, assigns the SYMBOL type and a Symbol.
   *
   * @param which the symbol inputted into the calculator
   */
  public Entry(Symbol which) {
    this.other = which;
    this.type = Type.SYMBOL;
  }


  /**
   * A method which returns the number value or throws an exception if it has none.
   *
   * @return number the float value
   * @throws BadTypeException exception thrown if type is not NUMBER
   */
  public float getValue() throws BadTypeException {
    if (getType() != Type.NUMBER) {
      throw new BadTypeException();
    }
    return this.number;
  }

  /**
   * A method which returns the String value or throws an exception if it has none.
   *
   * @return str the String value
   * @throws BadTypeException exception thrown if type is not STRING
   */
  public String getString() throws BadTypeException {
    if (getType() != Type.STRING) {
      throw new BadTypeException();
    }
    return this.str;
  }

  /**
   * A method which returns the type or throws an exception if it has none.
   *
   * @return type the type of input
   */
  public Type getType() {
    return this.type;
  }

  /**
   * A method which returns the Symbol value or throws an exception if it has none.
   *
   * @return other the symbol value
   * @throws BadTypeException exception thrown if type is not SYMBOL
   */
  public Symbol getSymbol() throws BadTypeException {
    if (getType() != Type.SYMBOL) {
      throw new BadTypeException();
    }
    return this.other;
  }

  /**
   * A method which returns the string representation of the chosen type.
   */
  public String toString() {
    if (getType() == Type.NUMBER) {
      try {
        return "" + getValue();
      } catch (BadTypeException e) {
        return e.toString();
      }
    } else if (getType() == Type.STRING) {
      try {
        return "" + getString();
      } catch (BadTypeException e) {
        return e.toString();
      }
    } else {
      try {
        return "" + getSymbol();
      } catch (BadTypeException e) {
        return e.toString();
      }
    }
  }

  /**
   * Determines whether 2 entries are equal, first off their type then their values.
   */
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Entry)) {
      return false;
    }
    Entry other = (Entry) o;

    if (this.type == other.type) {
      if (this.type.equals(Type.NUMBER)) {
        try {
          return this.getValue() == other.getValue();
        } catch (BadTypeException e) {
          e.toString();
        }
      } else if (this.type.equals(Type.STRING)) {
        try {
          return this.getString().equals(other.getString());
        } catch (BadTypeException e) {
          e.toString();
        }
      }
    }
    return false;
  }

  /**
   * Determines whether two objects are equal if they have the same integer hashCode value.
   */
  @Override
  public int hashCode() {
    if (type.equals(Type.NUMBER)) {
      try {
        return (int) getValue();
      } catch (BadTypeException e) {
        e.toString();
        return 0;
      }
    } else {
      try {
        return getString().hashCode();
      } catch (BadTypeException e) {
        e.toString();
        return 0;
      }
    }
  }



}


