package com.akkupatel.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    String[] selectYear = {"1" , "2" , "3" , "4"};
    String[] selectBranch = {"CS" , "ME" , "CE" , "EE" , "ECE"} ;
    AutoCompleteTextView autoCompleteTextView , autoCompleteTextView1;
    ArrayAdapter<String> arrayAdapter , arrayAdapter1;

        TextView alreadyHaveAccount;
        Button registerButton;
        EditText fullName , enrollmentNo , eMail , passWord;
        SharedPreferences sharedPreferences;
        private static final String MY_PREF_NAME = "my_pref" ;
        private static final String KEY_FULL_NAME = "full_name";
        private static final String KEY_ENROLLMENT = "enrollment";
        private static final String KEY_EMAIL = "email";
        private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        autoCompleteTextView = findViewById(R.id.autocomplete);
        autoCompleteTextView1 = findViewById(R.id.autocomplete1);
        alreadyHaveAccount = findViewById(R.id.alreadyhaveaccount);
        fullName = findViewById(R.id.fullname);
        enrollmentNo = findViewById(R.id.enrollment);
        eMail = findViewById(R.id.email);
        passWord = findViewById(R.id.password);
        registerButton = findViewById(R.id.registerButton);

        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.list, selectYear);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String year = adapterView.getItemAtPosition(i).toString();
            }
        });

        arrayAdapter1 = new ArrayAdapter<String>(this , R.layout.list , selectBranch) ;
        autoCompleteTextView1.setAdapter(arrayAdapter1);
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String branch = adapterView.getItemAtPosition(i).toString();
            }
        });

        sharedPreferences = getSharedPreferences(MY_PREF_NAME , MODE_PRIVATE);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_FULL_NAME , fullName.getText().toString());
                editor.putString(KEY_ENROLLMENT , enrollmentNo.getText().toString());
                editor.putString(KEY_EMAIL , eMail.getText().toString());
                editor.putString(KEY_PASSWORD , passWord.getText().toString());
                editor.putBoolean("flag" , true);

                editor.apply();

                startActivity(new Intent(SignUp.this , home.class));
                Toast.makeText(SignUp.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}