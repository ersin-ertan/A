# A
A for Android power methods, with little impact on permissions(internet so far), and dependencies to other libs. It does common functions in a readable manner.

```java
Show.toast(this, android.R.string.untitled);

Show.alertDialog(new AlertDialog.Builder(this), "Hello", "World");

Show.alertDialogList(new AlertDialog.Builder(this), "title", new CharSequence[] { "a" }, null);

ProgressDialog pd = Show.progressDialog(this, String.valueOf(Is.inetConnected(this)));
pd.cancel();

Is.inetConnected(this);
```
