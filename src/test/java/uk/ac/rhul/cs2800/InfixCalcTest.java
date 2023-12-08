package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InfixCalcTest {

  InfixCalc calc;

  @BeforeEach
  void creation() {
    calc = new InfixCalc();
  }

  // Test 1 works when hardcoded'
  // Test 2 testing for simple addition
  @Test
  void add() throws InvalidExpressionException, BadTypeException {
    assertEquals(calc.evaluate(" 1 + 4 "), 5.0f);
  }

  // Test 1 testing for simple subtraction
  @Test
  void subtract() throws InvalidExpressionException, BadTypeException {
    assertEquals(calc.evaluate("4 - 2"), 2.0f);
  }

  // Test 1 testing for simple multiplication
  @Test
  void multiply() throws InvalidExpressionException, BadTypeException {
    assertEquals(calc.evaluate("2 * 2"), 4.0f);
  }

  // Test 1 testing for simple division
  @Test
  void division() throws InvalidExpressionException, BadTypeException {
    assertEquals(calc.evaluate("2 / 2"), 1.0f);
  }
}
