package com.example.moumoutsay.smsmessagerwithgeo.ui.listener;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import com.example.moumoutsay.smsmessagerwithgeo.model.GPSInfo;

/**
 * Created by moumoutsay on 4/13/15.
 */
public class ShowGPSOnClickListener implements View.OnClickListener {

    private Activity act;

    public ShowGPSOnClickListener(Activity act) {
        this.act = act;
    }

    @Override
    public void onClick(View v) {
        GPSInfo gpsInfo = new GPSInfo(act);
        if (gpsInfo.canGetLocation()) {
            double log = gpsInfo.getLongitude();
            double lat = gpsInfo.getLatitude();
            Toast.makeText(act.getApplicationContext(),
                    "Location:\n\tLongitude" + log + "\n\tLatitude" + lat,
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(act.getApplicationContext(),
                    "Can not get gpsInfo",
                    Toast.LENGTH_LONG).show();
        }
    }
}
