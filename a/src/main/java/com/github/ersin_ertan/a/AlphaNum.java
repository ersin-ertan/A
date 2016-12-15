package com.github.ersin_ertan.a;

import static com.github.ersin_ertan.a.internal.ErrorExceptionMessages.ILLEGAL_INSTANCE;

/**
 * Created by mms on 12/15/16.
 */

public final class AlphaNum {

  private AlphaNum() {
    throw new IllegalStateException(ILLEGAL_INSTANCE);
  }
}
