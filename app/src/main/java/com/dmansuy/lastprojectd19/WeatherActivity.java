package com.dmansuy.lastprojectd19;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dmansuy.lastprojectd19.model.beans.weather.MainBean;
import com.dmansuy.lastprojectd19.model.beans.weather.WeatherBean;
import com.dmansuy.lastprojectd19.model.ws.WSUtils;

import java.util.List;

public class WeatherActivity extends AppCompatActivity {

    private Button btnLoad;
    private TextView tv;
    private EditText editVille;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        View v = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        btnLoad = findViewById(R.id.WbtnLoad);
        tv = findViewById(R.id.tvw);
        editVille = findViewById(R.id.editVille);
    }

    public void onClick(View v) {
        MonAt monAt = new MonAt();
        monAt.execute();
    }

    public class MonAt extends AsyncTask {
        List<WeatherBean> result;
        MainBean main;
        Exception e;

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                result = WSUtils.getWeatherCity(editVille.getText().toString());
                main = WSUtils.getTemperatureCity(editVille.getText().toString());
            } catch (Exception e) {
                e.printStackTrace();
                this.e = e;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            if (e != null) {
                tv.setText(e.getMessage());
            } else {
                String s = "";
                for (WeatherBean datum : result) {
                    s += datum.getDescription();
                }
                tv.setText(s + "\n" + main.getTemp() + " F"
                        + "\n Humidity : " + main.getHumidity()
                        + "\n Pressure : " + main.getPressure());
            }
        }
    }
}
