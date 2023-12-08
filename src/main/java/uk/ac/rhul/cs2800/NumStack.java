package uk.ac.rhul.cs2800;

/**
 * A facade class containing the numerical values of the stack class.
 * 
 * @author ZKAC354
 */
public class NumStack {

  private Stack stack;

  /**
   * Constructor which creates a Stack object and sets the size to 0 as it is an empty stack.
   */

  public NumStack() {
    stack = new Stack();
  }

  /**
   * Getter method to retrieve the size, using the original stack's size() method to create less
   * dependencies.
   * 
   * @return size The size of the current NumStack
   */
  public int getSize() {
    int size = stack.size();
    return size;
  }

  /**
   * Pushes a float to the top of the stack and increments the stack size for the next float.
   * 
   * @param inputFloat float entry being pushed to stack
   */
  public void push(float inputFloat) {
    stack.push(new Entry(inputFloat));
  }

  /**
   * A textual representation of the stack's contents.
   *
   * @return str The contents of the list in a user friendly format
   */

  public String toString() {
    String str = stack.toString();
    return str;
  }


  /**
   * removes and displays the top of the stack then decrements the size.
   *
   * @return poppedVal the float being removed and displayed
   * @throws BadTypeException this cant actually be thrown due to the facade class.
   */
  public Float pop() throws BadTypeException {
    float poppedVal = stack.pop().getValue();
    return poppedVal;
  }

  /**
   * Displays the top of the stack without removing it.
   * 
   * @return toppedVal the float at the top of the stack being displayed
   * @throws BadTypeException this cant actually be thrown due to the facade class
   */
  public float top() throws BadTypeException {
    float toppedVal = stack.top().getValue();
    return toppedVal;

  }

  /**
   * Checks if the stack is empty.
   * 
   * @return true/false depending on whether the stack is empty
   */
  public boolean isEmpty() {
    if (stack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

}
