package com.akkupatel.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
    String[] selectYear = {"1" , "2" , "3" , "4"};
    String[] selectBranch = {"CS" , "ME" , "CE" , "EE" , "ECE"} ;
    AutoCompleteTextView autoCompleteTextView;
    AutoCompleteTextView autoCompleteTextView1;
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapter1;
        TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        textView = findViewById(R.id.alreadyhaveaccount);
        autoCompleteTextView = findViewById(R.id.autocomplete);
        autoCompleteTextView1 = findViewById(R.id.autocomplete1);

        textView.setOnClickListener(new View.OnClickListener() {
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
    }
}