package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

  private Stack stack;


  @BeforeEach
  /*
   * First attempt at this method, create the Stack object with no params Second attempt at this
   * method, create the object once before each test starts
   */
  public void creation() {
    stack = new Stack();
  }

  @Test
  /*
   * First attempt at this method, ensure the empty stack is of size 0 HardCoded Second attempt,
   * remove the hardcode by incrementing size everytime a num is pushed
   */
  void sizeTest() {
    assertEquals(stack.size(), 0);
  }

  @Test
  void pushTest() {
    /*
     * First attempt, ensure the size increases everytime a num is pushed Second attempt, ensure the
     * int is added to the list
     */
    stack.push(new Entry(3.0f));
    stack.push(new Entry(5.0f));
    stack.push(new Entry(Symbol.LEFT_BRACKET));
    assertEquals(stack.size(), 3);
  }

  @Test
  /*
   * First attempt, having a string representation of the list. Second attempt, with a new toString
   * that doesnt just return a code. Third attempt, adding the pushes to the list and it showing in
   * the toString. Fourth attempt, with pushes inside the test. WORKS WOOHOO. Fifth attempt,
   * refactoring with Entry instead of just integers. BROKEN Sixth attempt, changed the toString of
   * entry and stack to work. FIXED
   * 
   */
  void listCreation() {
    stack.push(new Entry(3.0f));
    stack.push(new Entry(5.0f));
    stack.push(new Entry(3.0f));

    assertEquals(stack.toString(), "The list contains: [3.0, 5.0, 3.0]");

  }

  @Test
  // First attempt, pushing a number and then returning it. Hardcoded
  // Second attempt, throwing exception if stack is empty. New test to be made*
  // Third attempt, integrating with Entry means having to create a getter for the number
  void pop() throws BadTypeException {
    stack.push(new Entry(5.0f));
    stack.push(new Entry(Symbol.LEFT_BRACKET));
    assertEquals(stack.pop().getSymbol(), Symbol.LEFT_BRACKET);
  }

  @Test
  void emptyPop() {
    // *pop tests second attempt
    assertThrows(EmptyStackException.class, () -> stack.pop(), "You cannot pop an empty stack");
  }

  @Test
  void pushPopSize() {
    stack.push(new Entry(5.0f));
    stack.push(new Entry(6.0f));
    stack.push(new Entry(7.0f));
    stack.pop();
    stack.pop();
    assertEquals(stack.size(), 1);
  }

  @Test
  // First attempt, push a number, return it
  // Second attempt, push and return it and check the toString to ensure its still in the stack
  // Third attempt, it is pushing 2 5.0's unknown why yet
  // In pop have to actually remove it in the list
  // Fourth attempt, testing top on empty stack*
  void testTop() throws BadTypeException {
    stack.push(new Entry(5.0f));
    stack.push(new Entry(3.0f));

    assertEquals(stack.top().getValue(), 3);
    assertEquals(stack.toString(), "The list contains: [5.0, 3.0]");

  }

  @Test
  // *testTop()
  // First attempt, needs to throw an EmptyStackException
  // Second attempt, following emptyPop it works
  void emptyTop() {
    assertThrows(EmptyStackException.class, () -> stack.top());
  }

  @Test
  // First Attempt, should add an entry and increase the index
  // Second attempt, should have index as float in the for statement
  void pushLots() {

    for (float index = 0; index < 1000; index++) {
      Entry entry = new Entry(index);
      stack.push(entry);
    }
    assertEquals(stack.size(), 1000);
  }


}
