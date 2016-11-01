package com.mmsofts.alib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.nullcognition.a.A;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    A.toast(this, String.valueOf(A.isInetConnected(MainActivity.this)));
  }
}
