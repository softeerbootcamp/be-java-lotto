package kr.codesquad.common.exception;

public class ExceptionHandler {

  public void runWithHandler(Runnable runnable) {
    try {
      runnable.run();
    } catch (NumberFormatException e) {

    }
  }

}
