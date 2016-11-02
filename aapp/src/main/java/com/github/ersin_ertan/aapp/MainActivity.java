package com.github.ersin_ertan.aapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import com.github.ersin_ertan.a.Is;
import com.github.ersin_ertan.a.Show;

public class MainActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Show.toast(this, android.R.string.untitled);

    Show.alertDialog(new AlertDialog.Builder(this), "Hello", "World");

    Show.alertDialogList(new AlertDialog.Builder(this), "title", new CharSequence[] { "a" }, null);

    ProgressDialog pd = Show.progressDialog(this, String.valueOf(Is.inetConnected(this)));
    pd.cancel();

    Is.inetConnected(this);
  }
}
