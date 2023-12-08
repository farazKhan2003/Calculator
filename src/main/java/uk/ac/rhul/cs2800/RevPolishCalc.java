/*
 * Following the logic of https://mrtan.me/post/19.html, inspired by Dave Cohens Calculator.jar
 * file. In piazza forum @520 the instructor says you should reference any code you are inspired by.
 * from lines 43 - 52 to read symbols i have largely used Daves method. unsure if this is plagiarism
 * but i figured better to be safe than sorry and just reference it :P I have still TDD'd it as you
 * can see in my Git repo and ive applied my own coding construction to it
 */

package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * This is the reverse Polish Postfix Calculator using a Stack data type.
 * 
 * @author ZKAC354
 *
 */
public class RevPolishCalc implements Calculator {

  private NumStack numStack = new NumStack();
  private float returnFloat;
  private float operand1;
  private float operand2;

  @Override
  public Float evaluate(String text) throws InvalidExpressionException, BadTypeException {

    // if the text is empty or a single number then it is an unbalanced expression.
    if (text == (null) || text.contentEquals("") || text.trim().length() == 1) {
      throw new InvalidExpressionException();
    }

    Scanner textScanner = new Scanner(text);

    // add all the numbers to the numStack.
    while (textScanner.hasNext() == true) {
      if (textScanner.hasNextFloat() == true) {
        numStack.push(textScanner.nextFloat());
        continue;
      }

      // add the operators at the end.
      String operatorText = textScanner.next();
      Symbol operatorSymbol = Symbol.INVALID;
      Symbol[] symbolArray = Symbol.values();
      for (int i = symbolArray.length, j = 0; j < i; j++) {
        Symbol symbol = symbolArray[j];
        if (symbol.toString().contentEquals(operatorText)) {
          operatorSymbol = symbol;
          break;
        }
      }

      // do the operation by the first operator.
      switch (operatorSymbol) {
        case PLUS:
          numStack.push(numStack.pop() + numStack.pop());
          continue;
        case MINUS:
          // as a stack is a FIFO structure we must pop both then subtract the first
          operand1 = numStack.pop();
          operand2 = numStack.pop();
          numStack.push(operand2 - operand1);
          continue;
        case TIMES:
          numStack.push(numStack.pop() * numStack.pop());
          continue;
        case DIVIDE:
          // as a stack is a FIFO structure we must pop both then divide the first
          operand1 = numStack.pop();
          operand2 = numStack.pop();
          numStack.push(operand2 / operand1);
          continue;
        case INVALID:
          throw new InvalidExpressionException();
        default:
          throw new InvalidExpressionException();
      }
    }
    returnFloat = numStack.pop();
    textScanner.close();
    // if the expression was 2 numbers and no operator was input, it is an invalid expression
    if (numStack.isEmpty() == false) {
      throw new InvalidExpressionException();
    }
    return returnFloat;

  }

}
