package com.appsomniac.swagger.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.adapter.TodayBookingsDataAdapter;
import com.appsomniac.swagger.data.adapter.TotalBookingsDataAdapter;
import com.appsomniac.swagger.data.model.Drawer;
import com.appsomniac.swagger.data.model.TodayBookingsHome;
import com.appsomniac.swagger.data.model.TotalBookingsHome;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ViewPager viewPager;
    private View homeFragment;
    ArrayList<TodayBookingsHome> al_todayBookingsData;
    ArrayList<TotalBookingsHome> al_totalBookingsData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_home,null);

        homeFragment = inflater.inflate(R.layout.fragment_home, container, false);
        return homeFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        al_todayBookingsData = new ArrayList<TodayBookingsHome>();
        al_totalBookingsData = new ArrayList<TotalBookingsHome>();

        setTodayBookingsData();
    }

    public void setTodayBookingsData(){

        RecyclerView today_recycler_view = homeFragment.findViewById(R.id.recyclerview_today_summary);

        RecyclerView total_recycler_view = homeFragment.findViewById(R.id.recyclerview_total_summary);

        al_todayBookingsData.add(new TodayBookingsHome("75", "Today Bookings"));
        al_todayBookingsData.add(new TodayBookingsHome("50", "Completed Bookings"));
        al_todayBookingsData.add(new TodayBookingsHome("55", "Incompleted Bookings"));
        al_todayBookingsData.add(new TodayBookingsHome("60", "Dummy Bookings"));
        al_todayBookingsData.add(new TodayBookingsHome("65", "Next Bookings"));

        TodayBookingsDataAdapter today_adapter = new TodayBookingsDataAdapter(getContext(), al_todayBookingsData);
        today_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        today_recycler_view.setAdapter(today_adapter);

        al_totalBookingsData.add(new TotalBookingsHome("100", "Total Bookings"));
        al_totalBookingsData.add(new TotalBookingsHome("105", "Completed Bookings"));
        al_totalBookingsData.add(new TotalBookingsHome("110", "Incompleted Bookings"));
        al_totalBookingsData.add(new TotalBookingsHome("120", "Dummy Bookings"));
        al_totalBookingsData.add(new TotalBookingsHome("130", "Next Bookings"));

        TotalBookingsDataAdapter total_adapter = new TotalBookingsDataAdapter(getContext(), al_totalBookingsData);
        total_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        total_recycler_view.setAdapter(total_adapter);

        total_recycler_view.setHasFixedSize(true);
        total_recycler_view.setNestedScrollingEnabled(true);
        today_recycler_view.setHasFixedSize(true);
        today_recycler_view.setNestedScrollingEnabled(true);
    }

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }
}
