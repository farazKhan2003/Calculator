package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReversePolishCalculatorTest {

  RevPolishCalc calc;

  @BeforeEach
  void creation() {
    calc = new RevPolishCalc();
  }


  // Test 1, just making a simple "2 + 3" work. HARDCODED
  // Test 2, WORKS!!!! with 2+3 anyways
  // Test 3, Works with multiple +'s
  // Test 4, testing incorrect expression, works!
  @Test
  void add() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("3 2 +"), 5.0f);
    assertEquals(calc.evaluate("3 4 5 + +"), 12.0f);
    assertEquals(calc.evaluate("-2 -3 + "), -5.0f);
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate(""));
  }

  // Test 1 integrate evaluate method to work with both addition and subtraction.
  // Test 2 making minus 2 with "3 1 -", flip pops perhaps?, WORKS
  // Test 3 minus and addition together in one expression, WORKS
  @Test
  void subtract() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("3 1 -"), 2.0f);
    assertEquals(calc.evaluate("3 1 + 2 -"), 2.0f);
  }


  // Test 1 making multiply work, using a switch statement instead.
  // Test 2 making sure the UML diagrams example of postfix calculation works
  @Test
  void multiply() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("3 2 *"), 6.0f);
    assertEquals(calc.evaluate("3 2 - 4 *"), 4.0f);
    assertEquals(calc.evaluate(" 5 6 7 + * 2 -"), 63.0f);
  }

  // Test 1 making divide work
  // Test 2 combining all operators
  @Test
  void divide() throws BadTypeException, InvalidExpressionException {
    assertEquals(calc.evaluate("3 2 /"), 1.5f);
    assertEquals(calc.evaluate("3 2 / 3 + 4 - 2 *"), 1.0f);
  }

  // Test 1 throws InvalidExpression when nothing is put
  // Test 2 throws InvalidExpression when null is entered
  // Test 3 throws InvalidExpression when only one number is input
  // Test 4 throws InvalidExpression when one number is put with a space, using .trim()
  // Test 5 throws InvalidExpression when false text is input
  // Test 6 throws InvalidExpression when multiple numbers and no operator are input
  // Test 7 throws InvalidExpression when only operators are input
  @Test
  void exceptionHandling() {

    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("3"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("3 "));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("blahblah"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate(""));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate(null));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("9 9 4"));
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("+-*/$"));



  }

}
