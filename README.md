### API ###

- Show
- Hide
- Is

Toast, AlertDialog, ProgressDialog, Action Bar, System Status Bar, SoftKeyboard, Internet Connection
```java
Show.toast(this, android.R.string.untitled);

Show.alertDialog(new AlertDialog.Builder(this), "Hello", "World");

Show.alertDialogList(new AlertDialog.Builder(this), "title", new CharSequence[] { "a" }, null);

ProgressDialog pd = Show.progressDialog(this, String.valueOf(Is.inetConnected(this)));
pd.cancel();

Show.actionBar(this);

Is.inetConnected(this);

Show.softKeyboard(context, view);

```

### Dependency ###
Module `build.gradle` with version https://jitpack.io/#ersin-ertan/A
[comment]: # ([![Release](https://jitpack.io/v/ersin-ertan/a.svg?style=flat-square)](https://jitpack.io/#ersin-ertan/A))
```
dependencies {
// add line below
compile 'com.github.ersin-ertan:A:see.jitpack.version'
}
```

Then, app root `build.gradle`
```
allprojects {
  repositories {
    // add line below
    maven { url "https://jitpack.io" }
  }
}
```


