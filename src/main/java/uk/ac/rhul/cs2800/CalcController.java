package uk.ac.rhul.cs2800;


/**
 * Controller which determines which observer is used and be a bridge between GUI and code.
 *
 * @author ZKAC354
 *
 */
public abstract class CalcController implements Observer {
  private CalcModel myModel;
  private ViewInterface myView;
  private boolean isInfix = myView.getIsInfix();



  @Override
  public void notifyObservers() {
    super.notifyAll();

  }


  private void calculateAction() throws InvalidExpressionException, BadTypeException {
    Float a = myModel.evaluate(myView.getExpression(), isInfix);
    myView.setResult(a.toString());
  }

  private void changeType(boolean isInfix) {
    isInfix(isInfix);
    notifyObservers();
  }

  /**
   * Returns the boolean value on whether the infix radio button is pressed.
   *
   * @param infix whether the user wants their expression to be interpreted in an Infix manner.
   * @return boolean value on whether the expression entered is in Infix notation
   */
  public boolean isInfix(boolean infix) {
    if (infix == isInfix) {
      return true;
    }
    return false;
  }

}
