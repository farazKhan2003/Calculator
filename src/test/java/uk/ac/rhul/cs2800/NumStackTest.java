package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {

  private NumStack numStack;
  // Test 1 creating an empty NumStack()
  // Test 2 checking the stack size is empty upon creation

  @BeforeEach
  @Test
  void creation() {
    numStack = new NumStack();
    assertEquals(numStack.getSize(), 0);
  }

  // Test 1 check if size is increased and numbers are actually added to NumStack.
  // Test 2 created a getSize method to retrieve the NumStacks size.
  // Test 3 created to ensure floats are input in correct order with a textual representation
  @Test
  void pushTest() {
    numStack.push(1.0f);
    numStack.push(2.0f);
    assertEquals(numStack.getSize(), 2);
    numStack.push(3.0f);
    assertEquals(numStack.toString(), "The list contains: [1.0, 2.0, 3.0]");


  }

  // Test 1 create pop method and check if size is reduced
  // Test 2 ensure popped value is correct
  // Test 3 check against empty stacks. Ensure an appropriate error message is thrown
  @Test
  void popTest() throws BadTypeException {
    numStack.push(1.0f);
    assertEquals(numStack.getSize(), 1);
    numStack.pop();
    assertEquals(numStack.getSize(), 0);
    numStack.push(2.0f);
    assertEquals(numStack.pop(), 2.0f);
    assertThrows(EmptyStackException.class, () -> numStack.pop(), "You cannot pop an empty stack");

  }

  // Test 1 ensure the top method keeps the size the same
  // Test 2 ensures the value is correct when topped.
  // Test 3 ensures an empty stack cannot be topped without an appropriate error message

  @Test
  void topTest() throws BadTypeException {
    numStack.push(1.0f);
    numStack.top();
    assertEquals(numStack.getSize(), 1);
    assertEquals(numStack.top(), 1.0f);
    numStack.pop();
    assertThrows(EmptyStackException.class, () -> numStack.top(), "You cannot top an empty stack");
  }

  // Test 1 ensures the method returns true if the stack is currently empty
  // Test 2 ensures the method returns false if the stack is not empty
  @Test
  void isEmptyTest() {
    assertEquals(numStack.isEmpty(), true);
    numStack.push(1.0f);
    assertEquals(numStack.isEmpty(), false);
  }

}
