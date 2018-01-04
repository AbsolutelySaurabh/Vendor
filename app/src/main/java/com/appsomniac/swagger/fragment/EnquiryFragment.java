package com.appsomniac.swagger.fragment;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.adapter.PopUpAdapterPendingBookings;
import com.appsomniac.swagger.data.model.TodayBookingsHome;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class EnquiryFragment extends Fragment {


    ViewPager viewPager;
    private View enquiryFragment;
    ArrayList<TodayBookingsHome> al_todayBookingsData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        enquiryFragment = inflater.inflate(R.layout.fragment_enquiry, container, false);
        return enquiryFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setFragment();
    }

    public void setFragment(){

        TextView sublit = enquiryFragment.findViewById(R.id.query_submit_button);
        sublit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                final Dialog dialog = new Dialog(getContext());
                //set layout custom
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_pop_up_query);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                TextView ok = dialog.findViewById(R.id.ok_text);
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){

                       dialog.cancel();
                    }
                });

                dialog.show();
            }
        });

    }
}
