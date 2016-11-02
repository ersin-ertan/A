# A
module build.gradle

`dependencies {`
`compile 'com.github.ersin-ertan:A:` [![Release](https://jitpack.io/v/ersin-ertan/a.svg)](https://jitpack.io/#ersin-ertan/A)
`}`

### API ###
Toast, AlertDialog, ProgressDialog, Internet Connection
```java
Show.toast(this, android.R.string.untitled);

Show.alertDialog(new AlertDialog.Builder(this), "Hello", "World");

Show.alertDialogList(new AlertDialog.Builder(this), "title", new CharSequence[] { "a" }, null);

ProgressDialog pd = Show.progressDialog(this, String.valueOf(Is.inetConnected(this)));
pd.cancel();

Is.inetConnected(this);
```

Hosted at https://jitpack.io/#ersin-ertan/A
