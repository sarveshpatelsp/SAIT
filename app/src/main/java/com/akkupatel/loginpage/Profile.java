package com.akkupatel.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.cast.framework.media.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Profile extends AppCompatActivity {
    ImageView bg_profile;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        fab = findViewById(R.id.floatingActionButton);
        bg_profile = findViewById(R.id.background_profile);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ImagePicker.with(Profile.this)
//                        .crop()	    			//Crop image(Optional), Check Customization for more option
//                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
//                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
//                        .start();
            }
        });
    }
}