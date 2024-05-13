
# Material Login Page Design For Android

**This is a Login Page Design based on Google's Material Design.**

**It takes UserName, Email, Password as input.**

**Contents**

* [Features](#Features)
* [Demo](#demo)
* [Screenshots](#screenshots)
* [Installation](#installation)
* [Usage](#usage)
* [Theming](#theming)


## Features

- [x]  Light/dark mode
- [x]  Username validation
- [x]  Email validation
- [x]  Password validation
- [x]  Login With Google
- [x]  Login with Twitter
> - [ ]  Intigrated with Firebase

## Demo

https://github.com/aka-munan/material-login-android/assets/105623907/04627bb0-b4df-417f-ba49-eac5fb9a6bfc




## Screenshots
<img src="https://github.com/aka-munan/material-login-android/assets/105623907/370d44ed-fc14-47cc-8132-0a70ab5cbfbc" width="350"  /> <img src="https://github.com/aka-munan/material-login-android/assets/105623907/35f556b0-0300-48f6-90c5-8d66fc9dc623" width="350" />
## **Installation**
 ### Add jitpack repository in your root `build.gradle`
###
> ####     gradle
```
  maven {
            setUrl("https://jitpack.io")
        }
```
> #### maven

```
         <repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
```
 ### Add dependencies to app's `build.gradle` 
> #### gradle
```
implementation 'com.google.android.material:material:1.12.0'
implementation 'com.github.aka-munan:material-login-android:1.0-beta'
```
> #### maven
```
<dependency>
	<groupId>com.github.aka-munan</groupId>
	<artifactId>material-login-android</artifactId>
	<version>1.0-beta</version>
</dependency>

<dependency>
	<groupId>com.google.android.material</groupId>
	<artifactId>material</artifactId>
	<version>1.12.0</version>
</dependency>
```
## Usage

```java
import com.material.login.LoginAuth;
import com.material.login.R;
import com.material.login.SignInListener;
```
```java
private View backBtn;
private View forgotPass;
```
```java
backBtn = findViewById(R.id.backBtn);
forgotPass = findViewById(R.id.forgotPass);
```
 inside onCreate function

```java
setContentView(R.layout.login_page);
backBtn = findViewById(R.id.backBtn);
//create new instasnce 
LoginAuth auth = new LoginAuth(this);
auth.setOnTabSelectedListener(null);/*set null for default*/
auth.setSignInListener(new SignInListener() {
            @Override
            public void onLogin(String email, String password) {
                //logic for login (old user)
            }

            @Override
            public void onSignUp(String uName, String email, String password) {
                //logic for signUp (new usew)
            }

            @Override
            public void onGoogleLogin() {
                //logic for google api
            }

            @Override
            public void onTwitterLogin() {
                //logic for twitter api
            }
});
        
```
```java
forgotPass.setOnClickListener(view ->{
    //logic for forgot password
});
```
```java
backBtn.setOnClickListener(view ->{
    //close app
    finishAffinity();
});
```


## Customization
This liabrary uses `Theme.MaterialLogin` as its theme. Create new style inside `res/values/styles.xml` which extends `Theme.MaterialLogin` as shown bellow

```xml
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Base.Theme.SimpleLogin" parent="Theme.MaterialLogin">
        <!-- Customize your light/dark theme here. -->
        <!-- <item name="colorPrimary">@color/colorPrimary</item> -->
    </style>
</resources>
```
> [!TIP]
> Create two seperate `styles.xml` files inside `res/values` and `res/values-night` for light and dark mode respectively

**Theming**

Item  | Attribute | Default Value |
---------  | ------------- | ------------- |
Back Button |`android:backgroundTint` |`?attr/colorPrimary`
App name |`android:textColor` |`?attr/colorNeutral`
Login Selecter |`app:cardBackgroundColor`<br/> `app:tabIndicatorColor` <br/>  `app:tabSelectedTextColor` <br/>`app:tabTextColor` |`?attr/colorPrimaryVariant`<br/>`?attr/colorOnPrimary`<br/>`?attr/colorOnSecondary`<br/>`?attr/colorOnPrimary`
Username icon <br/> Email icon <br/> Password icon |`app:tint` |`?attr/colorNeutral_200`
Login button | `android:backgroundTint` |`?attr/colorPrimaryVariant`

## 🚀 About Me
I'm an Android Devloper proficient in Java.

## 🛠 Skills
java,python


## Feedback

If you have any feedback, please reach out to us at harismehraj543@gmail.com

