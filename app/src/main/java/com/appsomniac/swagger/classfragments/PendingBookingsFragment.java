package com.appsomniac.swagger.classfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.adapter.CompletedBookingsAdapter;
import com.appsomniac.swagger.data.adapter.PendingBookingsAdapter;
import com.appsomniac.swagger.data.model.CompletedBookings;
import com.appsomniac.swagger.data.model.Drawer;
import com.appsomniac.swagger.data.model.PendingBookings;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class PendingBookingsFragment extends Fragment {

    ArrayList<PendingBookings> pendingBookingsList;

    public PendingBookingsFragment(){
        //empty constructor
    };

    View pendingBookingsFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        pendingBookingsFragment = inflater.inflate(R.layout.fragment_pending_bookings, container, false);

        RecyclerView recyclerView=(RecyclerView)pendingBookingsFragment.findViewById(R.id.pending_bookings_recyclerview);

        PendingBookingsAdapter pendingBookingsAdapter=new PendingBookingsAdapter(getContext(), generatePendingBookingsList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(pendingBookingsAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);

        return pendingBookingsFragment;
    }

    private ArrayList<PendingBookings> generatePendingBookingsList(){
        ArrayList<PendingBookings> al_pendingBookings = new ArrayList<PendingBookings>(10);

        PendingBookings drawer_1 = new PendingBookings();
        drawer_1.setGuest_name("Saurabh Singh");
        drawer_1.setAmount_to_collect("300");
        drawer_1.setDate("16th July, 2017");
        drawer_1.setServices("HairCut");
        drawer_1.setTime("7:45AM");
        al_pendingBookings.add(drawer_1);

        PendingBookings drawer_2 = new PendingBookings();
        drawer_2.setGuest_name("Akash Gupta");
        drawer_2.setAmount_to_collect("800");
        drawer_2.setDate("17th July, 2017");
        drawer_2.setServices("HairCut");
        drawer_2.setTime("8:45AM");
        al_pendingBookings.add(drawer_2);

        PendingBookings drawer_3 = new PendingBookings();
        drawer_3.setGuest_name("Rishabh Gupta");
        drawer_3.setAmount_to_collect("600");
        drawer_3.setDate("16th July, 2017");
        drawer_3.setServices("HairCut");
        drawer_3.setTime("9:45AM");
        al_pendingBookings.add(drawer_3);

        PendingBookings drawer_4 = new PendingBookings();
        drawer_4.setGuest_name("Prakhar Gupta");
        drawer_4.setAmount_to_collect("800");
        drawer_4.setDate("19th July, 2017");
        drawer_4.setServices("Spa");
        drawer_4.setTime("9:45AM");
        al_pendingBookings.add(drawer_4);


        return al_pendingBookings;
    }

}
