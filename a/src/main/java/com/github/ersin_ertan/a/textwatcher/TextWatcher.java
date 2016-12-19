package com.github.ersin_ertan.a.textwatcher;

import static com.github.ersin_ertan.a.internal.ErrorExceptionMessages.ILLEGAL_INSTANCE;

/**
 * Created by mms on 12/15/16.
 */

public final class TextWatcher {

  private TextWatcher() {
    throw new IllegalStateException(ILLEGAL_INSTANCE);
  }

  //public static android.text.TextWatcher thousands(@NonNull final EditText editText,
  //    @NonNull final String separator) {
  //  return new ThousandsNumberTextWatcher(editText, separator);
  //}
  //
  //public static android.text.TextWatcher currency(@NonNull final EditText editText,
  //    @NonNull final String separator, @NonNull final String currencySymbol,
  //    boolean isCurrencySymbolOnRight) {
  //  return new CurrencyNumberTextWatcher(editText, separator, currencySymbol,
  //      isCurrencySymbolOnRight);
  //}
}
