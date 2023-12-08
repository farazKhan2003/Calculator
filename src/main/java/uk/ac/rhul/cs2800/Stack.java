package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

/**
 * A FIFO structure holding custom entries consisting of numbers, strings and symbols.
 *
 * @author ZKAC354
 *
 */
public class Stack {
  /**
   * Size - the amount of entries in the stack, useful for determining the position of entries too.
   */
  private int size;

  /**
   * The list of entries (the stack), using an ArrayList as it is dynamic in size.
   */
  private List<Entry> list = new ArrayList<Entry>();

  /**
   * The current entry being pushed/popped/topped.
   */
  private Entry val;

  /**
   * The constructor default creates the size as zero as a new stack is made.
   */
  public Stack() {
    size = 0;
  }

  /**
   * Determines the amount of entries in the current stack.
   *
   * @return the size of the stack
   */
  public int size() {
    return size;
  }

  /**
   * Pushes an entry to the top of the stack and increments the stack size for the next entry.
   *
   * @param input the number/string/symbol being pushed onto the stack
   */
  public void push(Entry input) {
    val = input;
    list.add(size, val);
    size++;
  }

  /**
   * A textual representation of the stack's contents.
   *
   * @return str The contents of the list in a user friendly format
   */

  @Override
  public String toString() {
    String str = ("The list contains: " + Arrays.toString(list.toArray()));

    return str;

  }

  /**
   * removes and displays the top of the stack then decrements the size.
   *
   * @return entry the entry at the top of the stack
   * @throws EmptyStackException cant index into the negatives for ArrayLists
   */
  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }

    Entry entry = list.get(size - 1);
    list.remove(entry);
    size--;
    return entry;
  }

  /**
   * displays the top of the stack.
   *
   * @return top the Entry at the top of the stack
   * @throws EmptyStackException cant pop an empty stack [SEE POP]
   */
  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    Entry top = pop();
    push(top);
    return top;
  }



}
