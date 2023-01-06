package kr.codesquad.exception;

import java.io.IOException;

public interface InputExceptionHandler {
    IllegalArgumentException handleIOException(IOException e);

    IllegalArgumentException handleNumberFormatExceptionAndInputOutOfRangeException();

    IllegalArgumentException handleLottoNumberOutOfRangeException(LottoNumberOutOfRangeException e);
}
