package com.example.moumoutsay.smsmessagerwithgeo.ui.listener;

import android.app.Activity;
import android.content.Context;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moumoutsay.smsmessagerwithgeo.R;
import com.example.moumoutsay.smsmessagerwithgeo.model.GPSInfo;

/**
 * Created by moumoutsay on 4/13/15.
 */
public class SendSMSWithGPSInfoOnClickListener implements View.OnClickListener {

    private static final String LOG_TAG = SendSMSWithGPSInfoOnClickListener.class.getSimpleName();

    private Activity act;

    public SendSMSWithGPSInfoOnClickListener(Activity act) {
        this.act = act;
    }

    @Override
    public void onClick(View v) {
        GPSInfo gpsInfo = new GPSInfo(act);
        if (gpsInfo.canGetLocation()) {
            double log = gpsInfo.getLongitude();
            double lat = gpsInfo.getLatitude();

            // update text view here
            TextView tv = (TextView) act.findViewById(R.id.text_show_location);
            tv.setText("Location:\n\t\tLongitude: " + log + "\n\t\tLatitude: " + lat);

            // send SMS here
            try {
                TelephonyManager tMgr = (TelephonyManager) act.getSystemService(Context.TELEPHONY_SERVICE);
                String mPhoneNumber = tMgr.getLine1Number();

                //act.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"
                //        + mPhoneNumber)));
                sendSMS(mPhoneNumber, "Location:\n\t\tLongitude: " + log + "\n\t\tLatitude: " + lat);

                Toast.makeText(act.getApplicationContext(),
                        "SMS with GPS info is sent !!",
                        Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(act.getApplicationContext(),
                        "Send SMS failed, please try again",
                        Toast.LENGTH_LONG).show();
                Log.d (LOG_TAG, "Send SMS failed" + e);
            }
        } else {
            Toast.makeText(act.getApplicationContext(),
                    "Can not get gpsInfo",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void sendSMS(String phoneNumber, String message)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }

}
