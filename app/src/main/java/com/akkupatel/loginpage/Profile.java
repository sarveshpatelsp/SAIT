package com.akkupatel.loginpage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Profile extends AppCompatActivity {

    TextView profileName , profileEmail , profileEnrollment;
    ImageView bg_profile;
    FloatingActionButton bg_fab;
    private final int GALLERY_REQ_CODE = 1000;
    private final int CAMERA_REQ_CODE = 100;

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
        bg_profile = findViewById(R.id.background_profile);
        bg_fab = findViewById(R.id.floatingActionButton);

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

        bg_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.camera_gallery_dialog_layout ,null);
                builder.setCancelable(true);
                builder.setView(dialogView);

                ImageView camera_dialog = dialogView.findViewById(R.id.dialog_camera);
                ImageView gallery_dialog = dialogView.findViewById(R.id.dialog_gallery);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                camera_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(myCamera, CAMERA_REQ_CODE);
                    }
                });

                gallery_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent myGallery = new Intent(Intent.ACTION_PICK);
                        myGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(myGallery , GALLERY_REQ_CODE);
                    }
                });
            }
        });
    }

        @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode)
        {
            case GALLERY_REQ_CODE:
                if(resultCode==RESULT_OK)
                bg_profile.setImageURI(data.getData());
                break;
            case CAMERA_REQ_CODE:
                if(resultCode==RESULT_OK){
                Bundle bundle = data.getExtras();
                Bitmap bitmapimage = (Bitmap) bundle.get("data");
                bg_profile.setImageBitmap(bitmapimage);
                }
        }
    }
}