package com.faustoc.tvapp_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.faustoc.tvapp_practice.Fragments.MainFragment;
import com.google.android.material.navigation.NavigationView;

public class TvActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    
    //variables
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar; //--revisar
    NavigationView navigationView;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private EditText codigo;
    private String pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv2);

        //NavigationDrawer
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.naigationView);

        //establecer evento onClick al navigationView
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        getActivityData();
        active_mainFragment();



    }

    public void getActivityData(){
        Intent intent = getIntent();
        pin = intent.getStringExtra("code");

        System.out.println("PIN: " + pin);

    }

    public void active_mainFragment(){

        //cargarFragment Principal
        Bundle bundle = new Bundle();
        bundle.putString("pin",pin);

        Fragment fragment = new MainFragment();
        fragment.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.commit();
        System.out.println("Bienvenido al nuevo fragmento de esta app");
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.home){
            active_mainFragment();
        }
        return false;
    }
}