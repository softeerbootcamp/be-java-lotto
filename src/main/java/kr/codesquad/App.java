package kr.codesquad;

import kr.codesquad.common.exception.ExceptionHandler;

public abstract class App implements Runnable {

  private static final ExceptionHandler exceptionHandler = new ExceptionHandler();

  @Override
  public void run() {
    exceptionHandler.runWithHandler(this::execute);
  }

  abstract void execute();
}
