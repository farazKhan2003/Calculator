package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SymbolTest {

  private Symbol symbol;


  @Test
  // First Attempt, LEFT_BRACKET should return a (
  void lbTest() {
    symbol = Symbol.LEFT_BRACKET;
    assertEquals(symbol.toString(), "(");
  }

  @Test
  // First Attempt, RIGHT_BRACKET should return a )

  void rbTest() {
    symbol = Symbol.RIGHT_BRACKET;
    assertEquals(symbol.toString(), ")");
  }

  @Test
  // First Attempt, TIMES should return a X
  // Second Attempt, TIMES should return a *

  void timesTest() {
    symbol = Symbol.TIMES;
    assertEquals(symbol.toString(), "*");
  }

  @Test
  // First Attempt, DIVIDE should return a /

  void divideTest() {
    symbol = Symbol.DIVIDE;
    assertEquals(symbol.toString(), "/");
  }

  @Test
  // First Attempt, PLUS should return a +

  void plusTest() {
    symbol = Symbol.PLUS;
    assertEquals(symbol.toString(), "+");
  }

  @Test
  // First Attempt, MINUS should return a -

  void minusTest() {
    symbol = Symbol.MINUS;
    assertEquals(symbol.toString(), "-");
  }

  @Test
  // First Attempt, INVALID should return a String saying INVALID

  void invalidTest() {
    symbol = Symbol.INVALID;

    assertEquals(symbol.toString(), "INVALID");
  }

}
