package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryTest {

  private Entry entry;

  @BeforeEach
  // First attempt, create an entry object
  void creation() {
    entry = new Entry(5.0f);

  }


  @Test
  // First attempt, return the value of the entry object
  // Second attempt, try with 2 Entry objects of dif vals
  // Third attempt, try replace the original entry val
  void entryVal() throws BadTypeException {
    assertEquals(entry.getValue(), 5.0f, 0.0001f);
    entry = new Entry(6.0f);
    assertEquals(entry.getValue(), 6.0f, 0.0001f);

  }

  @Test
  // First Attempt, Testing a toString for entry
  // Second Attempt, making a custom toString for entry
  void stringRepresentation() {
    assertEquals(entry.toString(), "5.0");
  }



  @Test
  // First Attempt, Making strings work
  // Second Attempt, returning the value of a string
  // Third Attempt, equal String Entries
  // Fourth Attempt, throwing a BadTypeException
  void stringEntries() throws BadTypeException {
    entry = new Entry("integrate");
    assertEquals(entry.getString(), "integrate");
    Entry entry2 = new Entry("integrate");
    assertEquals(entry.getString(), entry2.getString());
  }

  @Test
  // First Attempt, equal Entries
  // Second Attempt, with overriden equals method
  // Third Attempt, Updating for strings, need to make a type enum corresponding with string, num
  // etc
  // Fourth Attempt, Hashcode (Hardcoded)
  // Fifth Attempt, Custom hashcode (String test still faked)
  // Sixth Attempt, Strings now work with custome Hashcode (called hash on it)
  void equalEntries() throws BadTypeException {
    entry = new Entry(4.0f);
    Entry entry2 = new Entry(4.0f);
    assertTrue(entry.equals(entry2));
    Entry entryStr1 = new Entry("integrate");
    Entry entryStr2 = new Entry("integrate");
    assertEquals(entry.hashCode(), 4);
    assertEquals(entryStr2.hashCode(), 492822833);
    assertEquals(entryStr1.getString(), entryStr2.getString());
  }

  @Test
  void testType() throws BadTypeException {
    // First Attempt, create an entry check the entry type is correct
    // Second Attempt, fix with toString in Type
    // Third Attempt, with String. Have to create String type
    // Fourth Attempt, with Symbol. Have to create symbol class and getter
    // Fifth Attempt, with Symbol toString
    entry = new Entry(4.0f);
    assertEquals(entry.getType(), Type.NUMBER);
    assertEquals(entry.getType().toString(), "NUMBER");
    entry = new Entry("integrate");
    assertEquals(entry.getType(), Type.STRING);
    assertEquals(entry.getType().toString(), "STRING");
    entry = new Entry(Symbol.DIVIDE);
    assertEquals(entry.getSymbol(), Symbol.DIVIDE);
    assertEquals(entry.getSymbol().toString(), "/");
  }

  @Test
  void wrongType() {
    // First Attempt, When calling getString on a NUMBER type it should throw BadTypeException
    // Second Attempt, when calling getNumber on a STRING type it should throw BadTypeException
    // Third Attempt, when calling getNumber/String on a SYMBOL type it should throw
    // BadTypeException

    entry = new Entry(5.0f);
    assertThrows(BadTypeException.class, () -> entry.getString());
    assertThrows(BadTypeException.class, () -> entry.getSymbol());

    entry = new Entry("integrate");
    assertThrows(BadTypeException.class, () -> entry.getValue());
    assertThrows(BadTypeException.class, () -> entry.getSymbol());

    entry = new Entry(Symbol.LEFT_BRACKET);
    assertThrows(BadTypeException.class, () -> entry.getString());
    assertThrows(BadTypeException.class, () -> entry.getValue());
  }


}
