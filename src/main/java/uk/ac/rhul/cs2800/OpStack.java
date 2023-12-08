package uk.ac.rhul.cs2800;

/**
 * A facade class containing the symbolic values of the stack class.
 * 
 * @author ZKAC354
 *
 */
public class OpStack {

  private Stack opStack;

  /**
   * Constructor which creates a Stack object and sets the size to 0 as it is an empty stack.
   */
  public OpStack() {
    opStack = new Stack();
  }

  /**
   * Pushes a Symbol to the top of the stack and increments the stack size for the next Symbol.
   * 
   * @param inputSymbol the Symbol being pushed to the stack
   */
  public void push(Symbol inputSymbol) {
    opStack.push(new Entry(inputSymbol));
  }

  /**
   * Getter method to retrieve the size, using the original stack's size() method to create less
   * dependencies.
   * 
   * @return size The size of the current NumStack
   */
  public int getSize() {
    int size = opStack.size();
    return size;
  }

  /**
   * A textual representation of the stack's contents.
   *
   * @return str The contents of the list in a user friendly format
   */

  public String toString() {
    String str = opStack.toString();
    return str;
  }

  /**
   * removes and displays the top of the stack then decrements the size.
   *
   * @return poppedVal the Symbol being removed and displayed
   * @throws BadTypeException this cant actually be thrown due to the facade class.
   */
  public Symbol pop() throws BadTypeException {
    Symbol poppedVal = opStack.pop().getSymbol();
    return poppedVal;
  }

  /**
   * Displays the top of the stack without removing it.
   * 
   * @return toppedVal the Symbol at the top of the stack being displayed
   * @throws BadTypeException this cant actually be thrown due to the facade class
   */
  public Symbol top() throws BadTypeException {
    Symbol toppedVal = opStack.top().getSymbol();
    return toppedVal;

  }

  /**
   * Checks if the stack is empty.
   * 
   * @return true/false depending on whether the stack is empty
   */
  public boolean isEmpty() {
    if (opStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }



}
