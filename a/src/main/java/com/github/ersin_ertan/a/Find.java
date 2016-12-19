package com.github.ersin_ertan.a;

import static com.github.ersin_ertan.a.internal.ErrorExceptionMessages.ILLEGAL_INSTANCE;

/**
 * Created by mms on 12/15/16.
 */

public final class Find {

  private Find() {
    throw new IllegalStateException(ILLEGAL_INSTANCE);
  }

  //public static int changeIndex(@NonNull final String a, @NonNull final String b) {
  //  if (a.equals(b)) return -1;
  //  int aLen = a.length();
  //  int bLen = b.length();
  //  int goTil = aLen > bLen ? aLen : bLen;
  //  if (goTil == 1 && !a.equals(b)) return 0;
  //  for (int i = 0; i < goTil; i++) {
  //    char cA, cB;
  //    try {
  //      cA = a.charAt(i);
  //    } catch (IndexOutOfBoundsException ioobe) {
  //      if (a.charAt(i - 1) == b.charAt(i)) --i;
  //      return i;
  //    }
  //    try {
  //      cB = b.charAt(i);
  //    } catch (IndexOutOfBoundsException ioobe) {
  //      if (b.charAt(i - 1) == a.charAt(i)) --i;
  //      return i;
  //    }
  //    if (cA != cB) return i;
  //  }
  //  return -1;
  //}
}