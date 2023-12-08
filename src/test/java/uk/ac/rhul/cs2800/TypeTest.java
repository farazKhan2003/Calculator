package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TypeTest {

  Type type;

  @Test
  void typeNumber() {
    // First Attempt, Create a type enum and make a number
    // Second Attempt, write a toString and check equality
    assertEquals(Type.NUMBER.toString(), "NUMBER");
  }

  @Test
  void typeString() {
    assertEquals(Type.STRING.toString(), "STRING");
  }

  @Test
  void typeSymbol() {
    assertEquals(Type.SYMBOL.toString(), "SYMBOL");
  }

  @Test
  void typeInvalid() {
    assertEquals(Type.INVALID.toString(), "INVALID");
  }

}
