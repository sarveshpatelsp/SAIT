package com.akkupatel.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView profileName , profileEmail , profileEnrollment;

    SharedPreferences sharedPreferences;
    private static final String MY_PREF_NAME = "my_pref" ;
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_ENROLLMENT = "enrollment";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileName = findViewById(R.id.profile_name);
        profileEmail = findViewById(R.id.profile_email);
        profileEnrollment = findViewById(R.id.profile_enrollment);

        sharedPreferences = getSharedPreferences(MY_PREF_NAME , MODE_PRIVATE);
        String fullname = sharedPreferences.getString(KEY_FULL_NAME , null);
        String email = sharedPreferences.getString(KEY_EMAIL , null);
        String enrollment = sharedPreferences.getString(KEY_ENROLLMENT , null);

        if(fullname!=null || email != null || enrollment != null)
        {
            profileName.setText(fullname);
            profileEmail.setText(email);
            profileEnrollment.setText(enrollment);
        }
    }
}