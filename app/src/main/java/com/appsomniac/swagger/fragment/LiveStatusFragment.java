package com.appsomniac.swagger.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.adapter.LiveStatusStartBookingAdapter;
import com.appsomniac.swagger.data.adapter.LiveStatusVacantOccupiedAdapter;
import com.appsomniac.swagger.data.model.LiveStatus.LiveStatusStartBooking;
import com.appsomniac.swagger.data.model.LiveStatus.LiveStatusVacantOccupied;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class LiveStatusFragment extends Fragment {


    ViewPager viewPager;
    private View liveStatusFragment;
    ArrayList<LiveStatusVacantOccupied> al_live_status_vacant_or_occupied;
    ArrayList<LiveStatusStartBooking> al_live_status_start_booking;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        liveStatusFragment = inflater.inflate(R.layout.fragment_live_status, container, false);
        return liveStatusFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        al_live_status_vacant_or_occupied = new ArrayList<LiveStatusVacantOccupied>();
        al_live_status_start_booking = new ArrayList<LiveStatusStartBooking>();

        setLiveStatusData();

    }

    public void setLiveStatusData(){

        RecyclerView recyclerview_live_status_vacant_or_occupied = liveStatusFragment.findViewById(R.id.recyclerview_live_status_vacant_or_occupied);
        RecyclerView recyclerview_live_status_start_booking = liveStatusFragment.findViewById(R.id.recyclerview_live_status_start_booking);

        LiveStatusVacantOccupiedAdapter today_adapter = new LiveStatusVacantOccupiedAdapter(getContext(), generateLiveStatusVacantOrOccupiedData());
        recyclerview_live_status_vacant_or_occupied.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerview_live_status_vacant_or_occupied.setAdapter(today_adapter);

        LiveStatusStartBookingAdapter total_adapter = new LiveStatusStartBookingAdapter(getContext(), generateLiveStatusStartBooking());
        recyclerview_live_status_start_booking.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerview_live_status_start_booking.setAdapter(total_adapter);

        recyclerview_live_status_vacant_or_occupied.setHasFixedSize(true);
        recyclerview_live_status_vacant_or_occupied.setNestedScrollingEnabled(true);
        recyclerview_live_status_start_booking.setHasFixedSize(true);
        recyclerview_live_status_start_booking.setNestedScrollingEnabled(true);

    }

    public ArrayList<LiveStatusVacantOccupied> generateLiveStatusVacantOrOccupiedData(){

        al_live_status_vacant_or_occupied.add(new LiveStatusVacantOccupied("75", "Vacant"));
        al_live_status_vacant_or_occupied.add(new LiveStatusVacantOccupied("50", "Occupied"));
        al_live_status_vacant_or_occupied.add(new LiveStatusVacantOccupied("55", "Vacant"));
        al_live_status_vacant_or_occupied.add(new LiveStatusVacantOccupied("60", "Vacant"));
        al_live_status_vacant_or_occupied.add(new LiveStatusVacantOccupied("65", "Occupied"));

        return al_live_status_vacant_or_occupied;
    }

    public ArrayList<LiveStatusStartBooking> generateLiveStatusStartBooking(){

        al_live_status_start_booking.add(new LiveStatusStartBooking("Saurabh Singh", "12th July, 1997", "6:45AM", "800"));
        al_live_status_start_booking.add(new LiveStatusStartBooking("Prabh Singh", "13th July, 1997", "8:45AM", "1000"));
        al_live_status_start_booking.add(new LiveStatusStartBooking("Shubham Singh", "12th Dec, 1997", "6:45AM", "900"));
        al_live_status_start_booking.add(new LiveStatusStartBooking("Piyush Singh", "12th July, 1997", "6:45AM", "800"));
        al_live_status_start_booking.add(new LiveStatusStartBooking("Saurabh Singh", "12th July, 1997", "6:45AM", "800"));

        return al_live_status_start_booking;
    }

}
