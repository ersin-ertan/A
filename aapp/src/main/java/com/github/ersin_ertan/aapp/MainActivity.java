package com.github.ersin_ertan.aapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.github.ersin_ertan.a.Num;
import com.github.ersin_ertan.a.Show;
import com.github.ersin_ertan.a.textwatcher.TextWatcher;

public class MainActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Show.toast(this, android.R.string.untitled);
    //
    //Show.alertDialog(new AlertDialog.Builder(this), "Hello", "World");
    //
    //Show.alertDialogList(new AlertDialog.Builder(this), "title", new CharSequence[] { "a" }, null);
    //
    //ProgressDialog pd = Show.progressDialog(this, String.valueOf(Is.inetConnected(this)));
    //pd.cancel();
    //
    //Is.inetConnected(this);

    // text changed listener for phone number format and for currency and for plain numbers with ,
    EditText editText0 = (EditText) findViewById(R.id.editText0);
    editText0.addTextChangedListener(TextWatcher.thousands(editText0, ","));

    EditText editText1 = (EditText) findViewById(R.id.editText1);
    editText1.addTextChangedListener(TextWatcher.thousands(editText1, " "));

    EditText editText2 = (EditText) findViewById(R.id.editText2);
    editText2.addTextChangedListener(TextWatcher.currency(editText2, ",", "$", false));

    EditText editText3 = (EditText) findViewById(R.id.editText3);
    editText3.addTextChangedListener(TextWatcher.currency(editText3, ",", "¥", true));

    Button clean = (Button) findViewById(R.id.clean);
    clean.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        clean();
      }
    });
  }

  void clean() {
    EditText editText0 = (EditText) findViewById(R.id.editText0);
    EditText editText1 = (EditText) findViewById(R.id.editText1);
    EditText editText2 = (EditText) findViewById(R.id.editText2);
    EditText editText3 = (EditText) findViewById(R.id.editText3);

    Show.toast(this, "EditText 0: " + Num.only(editText0.getText().toString()));
    Show.toast(this, "EditText 1: " + Num.only(editText1.getText().toString()));
    Show.toast(this, "EditText 2: " + Num.only(editText2.getText().toString()));
    Show.toast(this, "EditText 3: " + Num.only(editText3.getText().toString()));
  }
}
