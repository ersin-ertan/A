package com.github.ersin_ertan.a;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mms on 11/2/16.
 */

public class Show {
  public static void toast(@NonNull final Context context, @StringRes int message) {
    toastCenterShow(Toast.makeText(context, context.getString(message), Toast.LENGTH_SHORT));
  }

  public static void toast(@NonNull final Context context, @NonNull final String message) {
    toastCenterShow(Toast.makeText(context, message, Toast.LENGTH_SHORT));
  }

  private static void toastCenterShow(@NonNull Toast toast) {
    ((TextView) toast.getView().findViewById(android.R.id.message)).setGravity(Gravity.CENTER);
    toast.show();
  }

  public static void alertDialog(@NonNull final AlertDialog.Builder adb, @StringRes final int title,
      @StringRes final int message) {
    adb.setTitle(title);
    adb.setMessage(message);
    alertDialog(adb);
  }

  public static void alertDialog(@NonNull final AlertDialog.Builder adb, @StringRes final int title,
      @NonNull final String message) {
    adb.setTitle(title);
    adb.setMessage(message);
    alertDialog(adb);
  }

  public static void alertDialog(@NonNull final AlertDialog.Builder adb,
      @NonNull final String title, @StringRes final int message) {
    adb.setTitle(title);
    adb.setMessage(message);
    alertDialog(adb);
  }

  public static void alertDialog(@NonNull final AlertDialog.Builder adb,
      @NonNull final String title, @NonNull final String message) {
    adb.setTitle(title);
    adb.setMessage(message);
    alertDialog(adb);
  }

  private static void alertDialog(@NonNull final AlertDialog.Builder adb) {
    AlertDialog ad = adb.create();
    ad.show(); // must call show first
    TextView message = (TextView) ad.findViewById(android.R.id.message);
    message.setGravity(Gravity.CENTER);
  }

  public static void alertDialogList(@NonNull final AlertDialog.Builder adb,
      @StringRes final int title, @ArrayRes final int items,
      @NonNull final DialogInterface.OnClickListener onClickListener) {
    adb.setTitle(title);
    adb.setItems(items, onClickListener);
    adb.create().show();
  }

  public static void alertDialogList(@NonNull final AlertDialog.Builder adb,
      @NonNull final String title, @ArrayRes final int items,
      @NonNull final DialogInterface.OnClickListener onClickListener) {
    adb.setTitle(title);
    adb.setItems(items, onClickListener);
    adb.create().show();
  }

  public static void alertDialogList(@NonNull final AlertDialog.Builder adb,
      @StringRes final int title, @NonNull final CharSequence[] items,
      @NonNull final DialogInterface.OnClickListener onClickListener) {
    adb.setTitle(title);
    adb.setItems(items, onClickListener);
    adb.create().show();
  }

  public static void alertDialogList(@NonNull final AlertDialog.Builder adb,
      @NonNull final String title, @NonNull final CharSequence[] items,
      @NonNull final DialogInterface.OnClickListener onClickListener) {
    adb.setTitle(title);
    adb.setItems(items, onClickListener);
    adb.create().show();
  }

  public static ProgressDialog progressDialog(@NonNull final Context context,
      @StringRes int message) {
    ProgressDialog pd = new ProgressDialog(context);
    pd.setMessage(context.getString(message));
    pd.setIndeterminate(true);
    pd.setCanceledOnTouchOutside(false);
    pd.show();
    return pd;
  }

  public static ProgressDialog progressDialog(@NonNull final Context context,
      @NonNull String message) {
    ProgressDialog pd = new ProgressDialog(context);
    pd.setMessage(message);
    pd.setIndeterminate(true);
    pd.setCanceledOnTouchOutside(false);
    pd.show();
    return pd;
  }
}
