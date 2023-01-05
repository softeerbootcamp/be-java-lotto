package kr.codesquad.app;

import kr.codesquad.common.exception.ExceptionHandler;
import kr.codesquad.common.io.Console;

public abstract class App implements Runnable {

  private static final Console console = new Console();
  private static final ExceptionHandler exceptionHandler = new ExceptionHandler(console);

  @Override
  public void run() {
    exceptionHandler.runWithHandler(this::execute);
  }

  abstract void execute();
}
