package com.github.ersin_ertan.a;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by mms on 11/2/16.
 */

public class Is {

  public static boolean inetConnected(Context appContext) {
    ConnectivityManager cm =
        (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
    return cm != null && (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo()
        .isConnected());
  }


}
