package com.akkupatel.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.akkupatel.loginpage.ui.home.HomeFragment;
import com.google.firebase.firestore.FirebaseFirestore;

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
                    if(check)
                        startActivity(new Intent(SplashScreen.this , home.class));
                    else
                        startActivity(new Intent(SplashScreen.this , AskingFromUser.class));
                    finish();
                }
            }
        }; thread.start();
    }
}