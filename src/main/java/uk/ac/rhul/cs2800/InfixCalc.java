/*
 * Following the logic of https://mrtan.me/post/18.html, inspired by Dave Cohens Calculator.jar
 * file. In piazza forum @520 the instructor says you should reference any code you are inspired by.
 * from lines 43 - 56 to read symbol i have largely used Daves method. unsure if this is plagiarism
 * but i figured better to be safe than sorry and just reference it :P I have still TDD'd it as you
 * can see in my Git repo and ive applied my own coding construction to it
 */

package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * A calculator which will calculate expressions in infix notation.
 * 
 * @author ZKAC354
 *
 */
public class InfixCalc implements Calculator {

  private NumStack numStack = new NumStack();
  private OpStack opStack = new OpStack();
  private float returnFloat;
  private float operand1;
  private float operand2;
  private float total = 0;
  private boolean numberExpected = true;
  String operatorText;
  Symbol operatorSymbol;

  @Override
  public Float evaluate(String text) throws InvalidExpressionException, BadTypeException {

    // if the text is empty or only a single character then it is an invalid expression
    if (text == (null) || text.contentEquals("") || text.trim().length() == 1) {
      throw new InvalidExpressionException();
    }

    Scanner textScanner = new Scanner(text);

    // a loop to add all the numbers to numStack
    // a loop to add all the operators to opStack.
    while (textScanner.hasNext() == true) {
      if (numberExpected == true) {
        numStack.push(textScanner.nextFloat());
        numberExpected = false;
        continue;
      } else {
        String operatorText = textScanner.next();
        Symbol operatorSymbol = Symbol.INVALID;
        Symbol[] symbolArray = Symbol.values();
        for (int i = symbolArray.length, j = 0; j < i; j++) {
          Symbol symbol = symbolArray[j];
          if (symbol.toString().contentEquals(operatorText)) {
            operatorSymbol = symbol;
            opStack.push(operatorSymbol);
            numberExpected = true;
            break;
          }
        }
        numStack.push(textScanner.nextFloat());
      }

      // checks the symbol at the top of the stack and determines the next action
      operatorSymbol = opStack.top();
      switch (operatorSymbol) {
        case LEFT_BRACKET:
          // if a left bracket ignore it
          break;
        case RIGHT_BRACKET:
          // if a right bracket is detected then the next operator should be popped,
          // and the next 2 operands will be dealt with in infix notation.
          operand1 = numStack.pop();
          operand2 = numStack.pop();
          Symbol operator = opStack.pop();

          switch (operator) {
            case PLUS:
              total = operand1 + operand2;
              numStack.push(total);
              break;
            case MINUS:
              total = operand2 - operand1;
              numStack.push(total);
              break;
            case TIMES:
              total = operand1 * operand2;
              numStack.push(total);
              break;
            case DIVIDE:
              total = operand2 / operand1;
              numStack.push(total);
              break;
            default:
              break;
          }
          break;
        // using the same method as postfix.
        case PLUS:
          opStack.push(operatorSymbol);
          numStack.push(numStack.pop() + numStack.pop());
          break;
        case MINUS:
          // as a stack is a FIFO structure we must pop both then subtract the first
          operand1 = numStack.pop();
          operand2 = numStack.pop();
          opStack.push(operatorSymbol);
          numStack.push(operand2 - operand1);
          break;
        case TIMES:
          opStack.push(operatorSymbol);
          numStack.push(numStack.pop() * numStack.pop());
          break;
        case DIVIDE:
          // as a stack is a FIFO structure we must pop both then divide the first
          operand1 = numStack.pop();
          operand2 = numStack.pop();
          opStack.push(operatorSymbol);
          numStack.push(operand2 / operand1);
          break;
        default:
          numStack.push(total);
          break;
      }
    }

    returnFloat = numStack.pop();
    textScanner.close();
    if (numStack.isEmpty() == false) {
      // if popped and still not empty then the expression was imbalanced and an error will be
      // thrown
      throw new InvalidExpressionException();
    }
    return returnFloat;

  }
}
