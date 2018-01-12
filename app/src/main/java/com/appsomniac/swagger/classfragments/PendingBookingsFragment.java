package com.appsomniac.swagger.classfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.adapter.PendingBookingsAdapter;
import com.appsomniac.swagger.data.model.Bookings.Bookings;
import com.appsomniac.swagger.fragment.BookingsFragment;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class PendingBookingsFragment extends Fragment {

    ArrayList<Bookings> pendingBookingsList;

    public PendingBookingsFragment(){

    }

    View pendingBookingsFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        pendingBookingsFragment = inflater.inflate(R.layout.fragment_pending_bookings, container, false);

        RecyclerView recyclerView=(RecyclerView)pendingBookingsFragment.findViewById(R.id.pending_bookings_recyclerview);

        PendingBookingsAdapter pendingBookingsAdapter=new PendingBookingsAdapter(getContext(), BookingsFragment.al_pending_bookings);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(pendingBookingsAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);

        return pendingBookingsFragment;
    }
}
