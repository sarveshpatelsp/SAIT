package com.akkupatel.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String MY_PREF_NAME = "my_pref" ;
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_ENROLLMENT = "enrollment";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread = new Thread()
        {
            public void run()
            {
                try {
                    sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_NAME , MODE_PRIVATE);
                    Boolean check = sharedPreferences.getBoolean("flag" , false);
                    Intent intent;
                    if(check)
                        intent = new Intent(SplashScreen.this , home.class);
                    else
                        intent = new Intent(SplashScreen.this , AskingFromUser.class);
                    startActivity(intent);
                    finish();
                }
            }
        }; thread.start();
    }
}