package com.github.ersin_ertan.aapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.github.ersin_ertan.a.A;
import com.mmsofts.alib.R;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    A.toast(this, String.valueOf(A.isInetConnected(MainActivity.this)));
  }
}
