package com.akkupatel.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class OtpScreen extends AppCompatActivity {
    int code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_screen);

    }
    public void sendVerifyEmail(View view)
    {
        Random random = new Random();
        code = random.nextInt(8999)+1000;
        EditText emailId = findViewById(R.id.enterUsernameoremail);
    }
}