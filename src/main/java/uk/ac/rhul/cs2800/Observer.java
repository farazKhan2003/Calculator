package uk.ac.rhul.cs2800;

/**
 * The interface defining an observer. Credits to Dave Cohen and the MVC-Seperated project.
 * 
 * @author ZKAC354
 *
 */
@FunctionalInterface
public interface Observer {
  /**
   * The named mechanism that will notify all observers that a change has occured.
   */
  public void notifyObservers();


}
