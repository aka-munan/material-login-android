package com.simple.material.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.material.login.LoginAuth;
import com.material.login.R;
import com.material.login.SignInListener;

public class MainActivity extends AppCompatActivity {

    private View backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        backBtn = findViewById(R.id.backBtn);
        LoginAuth auth = new LoginAuth(this);
        auth.setOnTabSelectedListener(null);
        auth.setSignInListener(new SignInListener() {
            @Override
            public void onLogin(String email, String password) {
                Toast.makeText(MainActivity.this,"login",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSignUp(String uName, String email, String password) {
                Toast.makeText(MainActivity.this,"signup",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onGoogleLogin() {
                Toast.makeText(MainActivity.this,"Google",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTwitterLogin() {
                Toast.makeText(MainActivity.this,"Twitter",Toast.LENGTH_SHORT).show();
            }
        });
    }



}