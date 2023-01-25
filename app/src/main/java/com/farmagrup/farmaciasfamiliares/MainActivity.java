package com.farmagrup.farmaciasfamiliares;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    BottomAppBar bottomAppBar;
    FrameLayout contenedor;
    HomeFragment homeFragment = new HomeFragment();
    PromotionsFragment promotionsFragment = new PromotionsFragment();
    ProductosFragment productosFragment = new ProductosFragment();
    PerfilFragment perfilFragment = new PerfilFragment();
    MaterialToolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setBackground(null);
        bottomAppBar = findViewById(R.id.bottombar);
        contenedor = findViewById(R.id.contenedor);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, homeFragment).commit();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, homeFragment)
                               .commit();
                        break;
                    case R.id.menu_promociones:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, promotionsFragment)
                                .commit();
                        break;
                    case R.id.menu_cuenta:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, perfilFragment)
                                .commit();
                        break;
                    case R.id.menu_productos:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, productosFragment)
                                .commit();
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.top_search:
                break;
            case R.id.top_cart:
                Toast.makeText(this, "Proximamente...", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void abrir_tarjeta(View view) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewcard = layoutInflater.inflate(R.layout.tarjeta_puntos, null);
        PopupWindow popupWindow = new PopupWindow(viewcard, FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT,true);
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0,0);
        popupWindow.update();
    }

    @Override
    public void onBackPressed() {
            finish();
    }

}

