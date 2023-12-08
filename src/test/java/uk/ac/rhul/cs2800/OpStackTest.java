package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {

  private OpStack opStack;
  // Test 1 creating an empty OpStack
  // Test 2 checking the stack size is empty upon creation

  @BeforeEach
  @Test
  void creation() {
    opStack = new OpStack();
  }

  // Test 1 check if size is increased and numbers are actually added to NumStack.
  // Test 2 created a getSize method to retrieve the NumStacks size.
  // Test 3 confirms the lists contents with a toString method.
  @Test
  void pushTest() {
    opStack.push(Symbol.LEFT_BRACKET);
    assertEquals(opStack.getSize(), 1);
    assertEquals(opStack.toString(), "The list contains: [(]");
  }


  // Test 1 push and pop work together by checking if size is correctly reduced.
  // Test 2 ensure pop value is correct
  // Test 3 check against empty stacks. Ensure an appropriate error message is thrown
  @Test
  void popTest() throws BadTypeException {
    opStack.push(Symbol.LEFT_BRACKET);
    assertEquals(opStack.getSize(), 1);
    assertEquals(opStack.pop().toString(), "(");
    assertEquals(opStack.getSize(), 0);
    assertThrows(EmptyStackException.class, () -> opStack.pop(), "You cannot pop an empty stack");
  }

  // Test 1 ensure the top method keeps the size the same
  // Test 2 ensures the value is correct when topped.
  // Test 3 ensures an empty stack cannot be topped without an appropriate error message
  @Test
  void topTest() throws BadTypeException {
    opStack.push(Symbol.LEFT_BRACKET);
    opStack.top();
    assertEquals(opStack.getSize(), 1);
    assertEquals(opStack.top().toString(), "(");
    opStack.pop();
    assertThrows(EmptyStackException.class, () -> opStack.top());
  }

  // Test 1 ensures the method returns true if the stack is currently empty
  // Test 2 ensures the method returns false if the stack is not empty
  @Test
  void isEmptyTest() {
    assertEquals(opStack.isEmpty(), true);
    opStack.push(Symbol.LEFT_BRACKET);
    assertEquals(opStack.isEmpty(), false);
  }
}
