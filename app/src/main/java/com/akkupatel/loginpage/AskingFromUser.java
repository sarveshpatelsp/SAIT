package com.akkupatel.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AskingFromUser extends AppCompatActivity {
        Button studentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asking_from_user);
        studentButton = findViewById(R.id.studentbutton);
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AskingFromUser.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}