package com.dmansuy.lastprojectd19;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dmansuy.lastprojectd19.model.beans.city.PlaceBean;
import com.dmansuy.lastprojectd19.model.ws.WSUtils;

import java.util.List;

public class PostalCodeActivity extends AppCompatActivity {

    private Button btnLoad;
    private TextView tv;
    private EditText editCP;
    private EditText editVille;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postal_code);

        View v = LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        btnLoad = findViewById(R.id.btnLoad);
        tv = findViewById(R.id.tvcp);
        editCP = findViewById(R.id.editCP);
        editVille = findViewById(R.id.editCountry);
    }

    public void onClick(View v) {
        MonAt monAt = new MonAt();
        monAt.execute();
    }

    public class MonAt extends AsyncTask {
        List<PlaceBean> result;
        Exception e;

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                result = WSUtils.getCityInformations(editVille.getText().toString(),
                        editCP.getText().toString());
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
                for (PlaceBean datum : result) {
                    s += datum.getPlaceName() + " \n"
                            + datum.getLatitude() + datum.getLongitude() + "\n"
                            + datum.getState() + " " + datum.getStateAbbreviation();
                }
                tv.setText(s);
            }
        }
    }
}
