package com.github.ersin_ertan.a;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by mms on 11/11/16.
 */

public class Hide {

  public static void statusBar(@NonNull final Activity activity) {
    if (Build.VERSION.SDK_INT < 16) {
      activity.getWindow()
          .setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              WindowManager.LayoutParams.FLAG_FULLSCREEN);
    } else {
      activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
  }

  public static void actionBar(@NonNull final Activity activity) {
    ActionBar actionBar = activity.getActionBar();
    if (actionBar != null) {
      actionBar.hide();
    }
  }
}
