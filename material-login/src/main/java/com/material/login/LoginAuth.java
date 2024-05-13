package com.material.login;

import android.app.Activity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.google.android.material.tabs.TabLayout;

public class LoginAuth {
    private EditText email;
    private EditText username;
    private EditText password;
    private TabLayout loginSelector;
    private CardView usernameLayout;
    private Button loginBtn;
    private View googleBtn;
    private View twitterBtn;
    private SignInListener signInListener;

    private View passVisible;

    public LoginAuth(Activity context) {
        email = context.findViewById(R.id.email);
        password = context.findViewById(R.id.password);
        username = context.findViewById(R.id.username);
        loginSelector = context.findViewById(R.id.login_selector);
        usernameLayout = context.findViewById(R.id.usernameLayout);
        loginBtn = context.findViewById(R.id.login_btn);
        googleBtn = context.findViewById(R.id.googleBtn);
        twitterBtn = context.findViewById(R.id.twitterBtn);
        passVisible = context.findViewById(R.id.passVisible);
        //hide password (default)
        passVisible.setTag(1);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        password.setOnEditorActionListener((textView,i,event) ->{
            loginBtn.performClick();
            return false;
        });
        //login btn function
        loginBtn.setOnClickListener(view -> {
            String emailStr = email.getText().toString();
            String passwordStr = password.getText().toString();
            String userNameStr = username.getText().toString();
            if (loginSelector.getSelectedTabPosition() == 0) {
                //login
                if (isNotFormat(false, true)) return;
                if (signInListener == null) return;
                signInListener.onLogin(emailStr, passwordStr);
            } else {
                //Sign up
                if (isNotFormat(true, true)) return;
                if (signInListener == null) return;
                signInListener.onSignUp(userNameStr, emailStr, passwordStr);
            }
        });
        //log in with google
        googleBtn.setOnClickListener(view -> {
            signInListener.onGoogleLogin();
        });
        //log in with twitter
        twitterBtn.setOnClickListener(view -> {
            signInListener.onTwitterLogin();
        });
        //hide | unHide password
        passVisible.setOnClickListener(v -> {
            int start = password.getSelectionStart();
            int end = password.getSelectionEnd();
            if (v.getTag().equals(0)) {
                //hide password
                v.setTag(1);
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                ((ImageView) v).setImageDrawable(context.getDrawable(R.drawable.visibile));
            } else {
                //show password
                v.setTag(0);
                password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                ((ImageView) v).setImageDrawable(context.getDrawable(R.drawable.visibility_off));
            }
            password.setSelection(start, end);
        });
    }

    public void setSignInListener(SignInListener listener) {
        signInListener = listener;
    }

    public void setOnTabSelectedListener(@Nullable TabLayout.OnTabSelectedListener listener) {
        TabLayout.OnTabSelectedListener defListener = new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                usernameLayout.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
                loginBtn.setText(position == 0 ? "Log in" : "Sign up");
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
        loginSelector.addOnTabSelectedListener(listener != null ? listener : defListener /*default tab listener */);
    }

    public boolean isNotFormat(boolean chkUser, boolean chkPas) {
        // check if format is correct
        //return true if incorrect format
        if (chkUser) {
            //check username format
            if (!(username.getText().toString().trim().length() > 0)) {
                username.setError("UserName can't be empty");
                return true;
            }
            if (!(username.getText().toString().replaceAll("[^\\w\\s]", "").length() > 0)) {
                username.setError("UserName mustContain a letter");
                return true;
            }
        }
        //check email format
        if (!(email.getText().toString().trim().length() > 0)) {
            email.setError("email can't be empty");
            return true;
        }
        if (!(email.getText().toString().replaceAll("[^\\w\\s]", "").length() > 0)
                || !email.getText().toString().trim().contains("@")) {
            email.setError("Enter a Valid EMAIL");
            return true;
        }
        if (chkPas) {
            //check password format
            if (!(password.getText().toString().trim().length() > 8)) {
                password.setError("Password must be more then 8 characters");
                return true;
            }
            if (!(password.getText().toString().replaceAll("[^\\w\\s]", "").length() > 0)) {
                password.setError("Password must contain a letter");
                return true;
            }
        }
        //remove errors from editText
        email.setError(null);
        password.setError(null);
        username.setError(null);
        return false;
    }
}

