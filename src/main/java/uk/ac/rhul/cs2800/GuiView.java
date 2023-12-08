// largely inspired by Dave Cohens, MVC-Seperated File.

package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * This is the physical view for the calculator.
 *
 * @author ZKAC354
 *
 */
public class GuiView extends Application implements ViewInterface {


  private CalcModel calcModel = new CalcModel();
  private String expression;


  @FXML
  public Button calculateButton;

  @FXML
  private TextField expressionField;

  @FXML
  private RadioButton infixButton;

  @FXML
  private RadioButton postfixButton;

  @FXML
  private Button resetButton;

  @FXML
  private Label resultField;

  @FXML
  void calculateExpression(ActionEvent event) throws InvalidExpressionException, BadTypeException {
    // returns the result depending on whether the calculation is in postfix or infix notation
    Float f2 = calcModel.evaluate(getExpression(), getIsInfix());
    // set the result field to be that float in string form
    setResult(String.valueOf(f2));
  }

  @FXML
  void resetPressed(ActionEvent event) {
    // reset the fields to all be empty
    // reset the radio buttons to both be empty
    resultField.setText("");
    expressionField.setText("");
    infixButton.setSelected(false);
    postfixButton.setSelected(false);
  }

  private static volatile GuiView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * The Singleton class of the GUI view, ensures only one GUI can be loaded at once.
   * 
   * @return GuiView The GUI made on scenebuilder located in resources/myView.fxml
   * @throws Exception thrown when there is no instance of GUI View as ASCII view is not
   *         incorporated yet
   */
  public static synchronized GuiView getInstance() throws Exception {
    if (instance == null) {
      new Thread(() -> Application.launch(GuiView.class)).start();
      // Wait until the instance is ready since initialise has executed.
      while (instance == null) {
        throw new Exception();
      }
    }

    return instance;
  }

  /**
   * The main method which launches the GUI.
   *
   * @param args will determine whether the GUI or ASCII view will be used.
   */
  public static void main(String[] args) {
    launch(args);
  }

  private ArrayList<Observer> obs = new ArrayList<Observer>();

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/myView.fxml"));
    Scene scene = new Scene(root, 800, 500);
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  /**
   * This will add the calculate Observer.
   * 
   * @param observer the Observer being added
   */
  public void addCalcObserver(Observer observer) {
    calculateButton.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        observer.notifyObservers();
      }
    });
  }

  /**
   * This will add the reset Observer.
   * 
   * @param o the Observer being added
   */
  public void addResetObserver(Observer o) {
    obs.add(o);
    resetButton.setOnAction(event -> o.notifyObservers());
  }



  /**
   * Returns the expression in the expression text field.
   * 
   * @return expression The expression input by the user.
   */
  public String getExpression() {
    expression = expressionField.getText();
    return expression;
  }

  /**
   * Sets the result that has been calculated by the controller.
   */
  public void setResult(String result) {
    resultField.setText(result);
  }



  @Override
  // checks whether the Infix Button is selected which determines whether the expression will be
  // interpreted in infix notation
  public boolean getIsInfix() {
    return infixButton.isSelected();
  }

}
