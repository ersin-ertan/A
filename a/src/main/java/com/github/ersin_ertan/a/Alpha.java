package com.github.ersin_ertan.a;

import android.support.annotation.NonNull;

import static com.github.ersin_ertan.a.internal.ErrorExceptionMessages.ILLEGAL_INSTANCE;

/**
 * Created by mms on 12/15/16.
 */

public final class Alpha {

  private Alpha() {
    throw new IllegalStateException(ILLEGAL_INSTANCE);
  }

  public static String only(@NonNull String alphaNum) {
    return alphaNum.replaceAll("[A-Za-z]*", "");
  }

  public static String onlyAndSpaces(@NonNull String alphaNum) {
    return alphaNum.replaceAll("[A-Za-z ]*", "");
  }
}
