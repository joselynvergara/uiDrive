package com.example.uidrive.Interfaces;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.uidrive.Entidades.DriveDoc;
import com.example.uidrive.Fragments.BandejaMensajeFragment;
import com.example.uidrive.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        iComunicaFragmentsMensaje {

        DrawerLayout drawerLayout;
        ActionBarDrawerToggle actionBarDrawerToggle;
        Toolbar toolbar;

        NavigationView navigationView;

        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        //variable del fragment detalle

        TextView texttoolbar;
        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        //texttoolbar = findViewById(R.id.tittle_toolbar);
        setSupportActionBar(toolbar);

            drawerLayout = findViewById(R.id.drawer);
            navigationView = (NavigationView) findViewById(R.id.navigationView);
            navigationView.setNavigationItemSelectedListener(this);

            actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
            actionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBarDrawerToggle.syncState();

            //cargar fragment principal en la actividad
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.container_fragment,new BandejaMensajeFragment());
            fragmentTransaction.commit();

            BottomNavigationView bottomNavigationView = findViewById(R.id.btn_navig);
            bottomNavigationView.setSelectedItemId(R.id.Priori);
    }

        @SuppressLint({"WrongConstant", "ShowToast"})
        @Override
        public boolean onNavigationItemSelected (@NonNull MenuItem menuItem){

        drawerLayout.closeDrawer(GravityCompat.START);
            if (menuItem.getItemId() == R.id.home) {
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, new BandejaMensajeFragment());
                fragmentTransaction.commit();
            }
            if (menuItem.getItemId() == R.id.reciente) {

            }
            return false;


    }

    @Override
    public void enviarDoc(DriveDoc mensajes) {

    }




/*
        @Override
        public void enviarMensaje (Mensajes mensajes){
        detallePersonaFragment = new DetallePersonaFragment();
        //objeto bundle para transportar la informacion
        Bundle bundleEnvio = new Bundle();
        //se manda el objeto que le esta llegando:
        bundleEnvio.putSerializable("objeto", mensajes);
        detallePersonaFragment.setArguments(bundleEnvio);

        //CArgar fragment en el activity
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, detallePersonaFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }*/
    }
