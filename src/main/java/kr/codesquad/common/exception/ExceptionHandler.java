package kr.codesquad.common.exception;

import kr.codesquad.common.io.Console;

public class ExceptionHandler {

  private final Console console;

  public ExceptionHandler(Console console) {
    this.console = console;
  }

  public void runWithHandler(Runnable runnable) {
    try {
      runnable.run();
    } catch (IllegalArgumentException e) {
      console.printErrorMessage(e);
    }
  }

}
