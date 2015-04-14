package com.example.moumoutsay.smsmessagerwithgeo.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.moumoutsay.smsmessagerwithgeo.R;
import com.example.moumoutsay.smsmessagerwithgeo.ui.listener.SendSMSWithGPSInfoOnClickListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button buttonSendSMSLocation = (Button) rootView.findViewById(R.id.button_send_location);
        buttonSendSMSLocation.setOnClickListener(new SendSMSWithGPSInfoOnClickListener(getActivity()));
        return rootView;
    }
}
