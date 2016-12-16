package com.github.ersin_ertan.a.textwatcher;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.widget.EditText;
import com.github.ersin_ertan.a.Find;
import com.github.ersin_ertan.a.Num;
import java.text.NumberFormat;

/**
 * Created by mms on 12/15/16.
 */

class CurrencyNumberTextWatcher implements android.text.TextWatcher {

  private String before = "";
  private EditText editText;

  private String separator;
  private int separatorLen;

  private String currencySymbol;
  private int currencySymbolLen;

  private boolean isCurrencySymbolOnRight;

  private NumberFormat numberFormat = NumberFormat.getInstance();

  CurrencyNumberTextWatcher(@NonNull final EditText et, @NonNull final String separator,
      @NonNull final String currencySymbol, final boolean isCurrencySymbolOnRight) {
    editText = et;
    numberFormat.setGroupingUsed(true);
    this.separator = separator;
    this.currencySymbol = currencySymbol;
    this.isCurrencySymbolOnRight = isCurrencySymbolOnRight;
    separatorLen = separator.length();
    currencySymbolLen = currencySymbol.length();
  }

  @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    if (s != null) before = s.toString();
  }

  @Override public void onTextChanged(CharSequence s, int start, int before, int count) {

  }

  @Override public void afterTextChanged(Editable s) {
    editText.removeTextChangedListener(this);
    if (s != null && !s.toString().isEmpty()) {

      boolean isDone = false;
      int checkForSymbolDeletionIndex;
      if (!"".equals(before)) {
        checkForSymbolDeletionIndex = Find.changeIndex(before, s.toString());
        // assuming the separator is 1 length
        try {
          if (before.charAt(checkForSymbolDeletionIndex) == separator.charAt(0)) {
            s.toString().charAt(checkForSymbolDeletionIndex);
            StringBuilder input = new StringBuilder(s.toString());
            input.setCharAt(checkForSymbolDeletionIndex - 1, ' ');
            s.clear();
            s.insert(0, input.toString());
          }
        } catch (IndexOutOfBoundsException e) {

        }
      }
      String after = Num.only(s.toString());
      if (!"".equals(after)) after = Long.valueOf(after).toString(); // strip trailing 0
      if ("".equals(after) || "0".equals(after)) {
        if (isCurrencySymbolOnRight) {
          editText.setText("0".concat(currencySymbol));
          editText.setSelection(editText.length());
        } else {
          editText.setText(currencySymbol.concat("0"));
          editText.setSelection(editText.length());
        }
        isDone = true;
      }
      if (!isDone) {
        boolean setSelection = true;
        int diffIndex = Find.changeIndex(Num.only(before), after); // for the new number placement
        if (diffIndex == -1) {
          // same number
          setSelection = false;
        }
        try {
          long num = Long.parseLong(after);
          if (!"".equals(before) && num > Long.parseLong(Num.only(before))) {
            ++diffIndex;
            // if the new number is larger we can know that it was an addition instead of a deletion, increase selection position
          }
          String formated = numberFormat.format(num);
          if (diffIndex > 0) {
            String startString = formated.substring(0, diffIndex);
            int countSymbols = startString.length() - startString.replace(separator, "").length();
            int spaceToMoveSelection = countSymbols * separatorLen;
            diffIndex += spaceToMoveSelection;
          } else {
            if (diffIndex != 0) setSelection = false;
          }

          formated = formated.replace(",", separator);

          if (isCurrencySymbolOnRight) {
            formated = formated.concat(currencySymbol);
          } else {
            formated = currencySymbol.concat(formated);
            diffIndex += currencySymbol.length();
          }
          editText.setText(formated);
          if (setSelection) {
            editText.setSelection(diffIndex);
          } else {
            editText.setSelection(formated.length());
          }
        } catch (NumberFormatException nfe) {
          nfe.printStackTrace();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    editText.addTextChangedListener(this);
  }
}