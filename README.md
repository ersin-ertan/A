### API ###

- Show, Hide, Is

Toast, AlertDialog, ProgressDialog, Action Bar, System Status Bar, SoftKeyboard, Internet Connection
``` java
Show.toast(this, android.R.string.untitled);
Show.alertDialog(new AlertDialog.Builder(this), "Hello", "World");
Show.alertDialogList(new AlertDialog.Builder(this), "title", new CharSequence[] { "a" }, null);
ProgressDialog pd = Show.progressDialog(this, String.valueOf(Is.inetConnected(this)));
pd.cancel();
Hide.actionBar(this);
Hide.softKeyboard(context, view);
Is.inetConnected(this);
```
### Dependency ###
**Module `build.gradle`**
[![](https://jitpack.io/v/ersin-ertan/A.svg?style=flat-square)](https://jitpack.io/#ersin-ertan/A)
<a href="http://www.methodscount.com/?lib=com.github.ersin-ertan%3AA%3A1.2.1"><img src="https://img.shields.io/badge/Methods and size-core: 60 | deps: 32 | 6 KB-e91e63.svg"/></a>
``` groovy
dependencies {
// add line below
compile 'com.github.ersin-ertan:A:see.jitpack.version'
}
```
**Root project `build.gradle`**
``` groovy
allprojects {
  repositories {
    // add line below
    maven { url "https://jitpack.io" }
  }
}
```

Hosted @ https://jitpack.io/#ersin-ertan/A
