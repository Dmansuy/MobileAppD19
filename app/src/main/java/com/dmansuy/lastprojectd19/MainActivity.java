package com.dmansuy.lastprojectd19;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private static final int MENU_ID_CP = 25;
    private static final int MENU_ID_WEATHER = 26;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_ID_CP, 0, "Postal Code");
        menu.add(0, MENU_ID_WEATHER, 0, "Weather");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == MENU_ID_CP) {
            startActivity(new Intent(this, PostalCodeActivity.class));
        } else if (item.getItemId() == MENU_ID_WEATHER) {
            startActivity(new Intent(this, WeatherActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
