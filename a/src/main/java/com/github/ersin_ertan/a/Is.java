package com.github.ersin_ertan.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

import static com.github.ersin_ertan.a.internal.ErrorExceptionMessages.ILLEGAL_INSTANCE;

/**
 * Created by mms on 11/2/16.
 */

public class Is {

  private Is() {
    throw new IllegalStateException(ILLEGAL_INSTANCE);
  }

  public static boolean inetConnected(@NonNull final Context appContext) {
    ConnectivityManager cm =
        (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
    return cm != null && (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo()
        .isConnected());
  }
}
