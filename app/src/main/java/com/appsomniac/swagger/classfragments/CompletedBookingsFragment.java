package com.appsomniac.swagger.classfragments;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.base.MainActivity;
import com.appsomniac.swagger.data.adapter.CompletedBookingsAdapter;
import com.appsomniac.swagger.data.adapter.DrawerListAdapter;
import com.appsomniac.swagger.data.model.CompletedBookings;
import com.appsomniac.swagger.data.model.PendingBookings;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class CompletedBookingsFragment extends Fragment {

    ArrayList<CompletedBookings> completedBookingsList;

    public CompletedBookingsFragment() {
        //empty constructor
    }

    View completedBookingsFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        completedBookingsFragment = inflater.inflate(R.layout.fragment_completed_bookings, container, false);

        RecyclerView recyclerView=(RecyclerView)completedBookingsFragment.findViewById(R.id.completed_bookings_recyclerview);

        CompletedBookingsAdapter completedBookingsAdapter = new CompletedBookingsAdapter(getContext(), generateCompletedBookingsList());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(completedBookingsAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);

        return completedBookingsFragment;
    }


    private ArrayList<CompletedBookings> generateCompletedBookingsList(){
        ArrayList<CompletedBookings> al_completedBookingsList = new ArrayList<CompletedBookings>(10);

        CompletedBookings drawer_1 = new CompletedBookings();
        drawer_1.setGuest_name("Shubham Singh");
        drawer_1.setAmount_collected("1000");
        drawer_1.setDate("16th July, 2017");
        drawer_1.setUser_feedback("HairCut");
        drawer_1.setTime("7:45AM");
        al_completedBookingsList.add(drawer_1);

        CompletedBookings drawer_2 = new CompletedBookings();
        drawer_2.setGuest_name("Akshdeep Gupta");
        drawer_2.setAmount_collected("800");
        drawer_2.setDate("17th July, 2017");
        drawer_2.setUser_feedback("HairCut");
        drawer_2.setTime("8:45AM");
        al_completedBookingsList.add(drawer_2);

        CompletedBookings drawer_3 = new CompletedBookings();
        drawer_3.setGuest_name("Pratyush Gupta");
        drawer_3.setAmount_collected("600");
        drawer_3.setDate("19th July, 2017");
        drawer_3.setUser_feedback("HairCut");
        drawer_3.setTime("9:45AM");
        al_completedBookingsList.add(drawer_3);

        CompletedBookings drawer_4 = new CompletedBookings();
        drawer_4.setGuest_name("Ajitesh Gupta");
        drawer_4.setAmount_collected("800");
        drawer_4.setDate("19th July, 2017");
        drawer_4.setUser_feedback("Spa");
        drawer_4.setTime("9:45AM");
        al_completedBookingsList.add(drawer_4);


        return al_completedBookingsList;
    }

}
