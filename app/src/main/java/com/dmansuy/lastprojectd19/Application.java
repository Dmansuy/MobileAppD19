package com.dmansuy.lastprojectd19;

import com.squareup.otto.Bus;

public class Application extends android.app.Application {

    private static Bus bus;

    public static Bus getBus() {
        return bus;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        bus = new Bus();
    }
}
