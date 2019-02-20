package com.dmansuy.lastprojectd19.model.ws;

import android.util.Log;

import com.dmansuy.lastprojectd19.model.OkHttpUtils;
import com.dmansuy.lastprojectd19.model.beans.city.CityBean;
import com.dmansuy.lastprojectd19.model.beans.city.PlaceBean;
import com.dmansuy.lastprojectd19.model.beans.weather.MainBean;
import com.dmansuy.lastprojectd19.model.beans.weather.ResultBean;
import com.dmansuy.lastprojectd19.model.beans.weather.WeatherBean;
import com.google.gson.Gson;

import java.util.List;

public class WSUtils {

    public static final String API_CP_URL = "http://api.zippopotam.us/";
    public static final String API_WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String APP_ID = "&appid=b80967f0a6bd10d23e44848547b26550";

    public static List<PlaceBean> getCityInformations(String country, String cp) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(API_CP_URL + country + "/" + cp);

        Gson gson = new Gson();
        CityBean result = gson.fromJson(json, CityBean.class);

        return result.getPlaces();
    }

    public static List<WeatherBean> getWeatherCity(String ville) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(API_WEATHER_URL + ville  + APP_ID);

        Gson gson = new Gson();
        ResultBean resultBean = gson.fromJson(json, ResultBean.class);

        return resultBean.getWeather();
    }

    public static MainBean getTemperatureCity(String ville) throws Exception {

        String json = OkHttpUtils.sendGetOkHttpRequest(API_WEATHER_URL + ville  + APP_ID);

        Gson gson = new Gson();
        ResultBean resultBean = gson.fromJson(json, ResultBean.class);

        return resultBean.getMain();
    }
}
