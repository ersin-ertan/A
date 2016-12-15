package com.github.ersin_ertan.a.textwatcher;

import android.support.annotation.NonNull;
import android.text.Editable;
import android.widget.EditText;
import com.github.ersin_ertan.a.Num;
import java.text.NumberFormat;

/**
 * Created by mms on 12/15/16.
 */

class CurrencyNumberTextWatcher implements android.text.TextWatcher {

  private EditText editText;
  private String separator;
  private String currencySymbol;
  private boolean isCurrencySymbolOnRight;
  private NumberFormat numberFormat = NumberFormat.getInstance();
  private String before;

  CurrencyNumberTextWatcher(@NonNull final EditText et, @NonNull final String separator,
      @NonNull final String currencySymbol, final boolean isCurrencySymbolOnRight) {
    editText = et;
    numberFormat.setGroupingUsed(true);
    this.separator = separator;
    this.currencySymbol = currencySymbol;
    this.isCurrencySymbolOnRight = isCurrencySymbolOnRight;
  }

  @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    if (s != null && s.length() != 0) before = s.toString();
  }

  @Override public void onTextChanged(CharSequence s, int start, int before, int count) {

  }

  @Override public void afterTextChanged(Editable s) {
    editText.removeTextChangedListener(this);
    if (s != null && !s.toString().isEmpty()) {
      String text = s.toString();
      text = Num.only(text);
      if (before != null && before.length() != 0) {
        if (isCurrencySymbolOnRight) {
          if (before.substring(0, before.length() - 1).equals(text)) {
            text = text.substring(0, text.length() - 1);
          }
        } else {
          if (currencySymbol.equals(text)) {
            text = "";
          }
        }
      }
      if (!"".equals(text)) {
        if (text.contains(separator)) {
          text = text.replace(separator, "");
        }
        if (text.contains(currencySymbol)) {
          text = text.replace(currencySymbol, "");
        }
        if (!Character.isDigit(text.charAt(text.length() - 1))) {
          if (text.length() == 1) {
            text = "";
          } else {
            text = text.substring(0, text.length() - 1);
          }
        }

        if (!"".equals(text)) {
          try {
            long num = Long.parseLong(text);
            String formated = numberFormat.format(num);
            formated = formated.replace(",", separator);
            if (isCurrencySymbolOnRight) {
              formated = formated.concat(currencySymbol);
            } else {
              formated = currencySymbol.concat(formated);
            }
            editText.setText(formated);
            int i = editText.getText().length();
            editText.setSelection(i);
          } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
      if ("".equals(text)) {
        if (isCurrencySymbolOnRight) {
          editText.setText("0".concat(currencySymbol));
          editText.setSelection(editText.length());
        } else {
          editText.setText(currencySymbol.concat("0"));
          editText.setSelection(editText.length());
        }
      }
    }
    editText.addTextChangedListener(this);
  }
}