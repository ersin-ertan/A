package com.github.ersin_ertan.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

/**
 * Created by mms on 11/2/16.
 */

public class Is {

  public static boolean inetConnected(@NonNull final Context appContext) {
    ConnectivityManager cm =
        (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
    return cm != null && (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo()
        .isConnected());
  }
}
