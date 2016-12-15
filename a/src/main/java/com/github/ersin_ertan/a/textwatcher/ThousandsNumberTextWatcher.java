package com.github.ersin_ertan.a.textwatcher;

import android.text.Editable;
import android.widget.EditText;
import com.github.ersin_ertan.a.Num;
import java.text.NumberFormat;

/**
 * Created by mms on 12/15/16.
 *
 * deleting will reset the cursor position
 */

class ThousandsNumberTextWatcher implements android.text.TextWatcher {

  private EditText editText;
  private String separator;
  private NumberFormat numberFormat = NumberFormat.getInstance();

  ThousandsNumberTextWatcher(EditText et, String separator) {
    editText = et;
    numberFormat.setGroupingUsed(true);
    this.separator = separator;
  }

  @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {

  }

  @Override public void onTextChanged(CharSequence s, int start, int before, int count) {

  }

  @Override public void afterTextChanged(Editable s) {
    editText.removeTextChangedListener(this);
    if (s != null && !s.toString().isEmpty()) {
      String text = s.toString();
      text = Num.only(text);
      if (text.contains(separator)) {
        text = text.replace(separator, "");
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
          editText.setText(formated);
          editText.setSelection(editText.getText().length());
        } catch (NumberFormatException nfe) {
          nfe.printStackTrace();
        }
      } else {
        editText.setText(text);
      }
    }
    editText.addTextChangedListener(this);
  }
}
