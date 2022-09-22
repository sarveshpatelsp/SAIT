package com.akkupatel.loginpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.akkupatel.loginpage.databinding.ActivityHomeBinding;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class home extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;
    private DrawerLayout drawerLayout;
    private  NavigationView navigationView;
    private NavController navController;

    SharedPreferences sharedPreferences;
    private static final String MY_PREF_NAME = "my_pref" ;
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_ENROLLMENT = "enrollment";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.close();
                int id = item.getItemId();
                if(id==R.id.nav_home) {
                    Toast.makeText(home.this, "Home", Toast.LENGTH_SHORT).show();
                    navController.navigate(R.id.nav_home);
                }
                else if(id==R.id.nav_about)
                    Toast.makeText(home.this, "About", Toast.LENGTH_SHORT).show();
                else if(id==R.id.nav_gallery) {
                    Toast.makeText(home.this, "Gallery", Toast.LENGTH_SHORT).show();
                    navController.navigate(R.id.nav_gallery);
                }
                else if(id==R.id.nav_today_attendence)
                    Toast.makeText(home.this, "Today", Toast.LENGTH_SHORT).show();
                else if(id==R.id.nav_total_attendence)
                    Toast.makeText(home.this, "Total", Toast.LENGTH_SHORT).show();
                else if(id==R.id.nav_batch_mates)
                    Toast.makeText(home.this, "Batch-mates", Toast.LENGTH_SHORT).show();
                else
                {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    editor.commit();
                    Toast.makeText(home.this, "Sign Out Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(home.this , MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                return true;
            }
        });

        setSupportActionBar(binding.appBarTest.toolbar);
        binding.appBarTest.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home.this , Profile.class));
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_gallery)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        //NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}