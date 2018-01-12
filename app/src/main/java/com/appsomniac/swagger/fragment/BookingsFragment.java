package com.appsomniac.swagger.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.classfragments.CompletedBookingsFragment;
import com.appsomniac.swagger.classfragments.PendingBookingsFragment;
import com.appsomniac.swagger.config.network.ApiResponse.BookingsResponse;
import com.appsomniac.swagger.config.network.retrofit.ApiClient;
import com.appsomniac.swagger.config.network.retrofit.ApiInterface;
import com.appsomniac.swagger.data.model.Bookings.Bookings;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class BookingsFragment extends Fragment {

    ViewPager viewPager;
    private View bookingsFragment;
    public static ArrayList<Bookings> al_pending_bookings;
    public static ArrayList<Bookings> al_completed_bookings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bookingsFragment = inflater.inflate(R.layout.fragment_bookings, container, false);

        return bookingsFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        al_completed_bookings = new ArrayList<>();
        al_pending_bookings = new ArrayList<>();

        SharedPreferences prefs_vendor_details = getContext().getSharedPreferences("VENDOR_DETAILS", MODE_PRIVATE);
        String store_id = prefs_vendor_details.getString("vendor_id", "0");

        getBookingsData(store_id);

    }

    public void getBookingsData(String store_id){


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<BookingsResponse> call = apiService.getBookingsData(store_id);

        call.enqueue(new Callback<BookingsResponse>() {
            @Override
            public void onResponse(Call<BookingsResponse>call, Response<BookingsResponse> response) {

                ArrayList<Bookings> al_bookings;
                al_bookings = response.body().getData();
                Boolean successOrNot = response.body().getSuccess();

                if(successOrNot) {
                    //add the pending and completed bookings data in separate arrayLists
                    for(int i=0;i<al_bookings.size();i++){
                        if(al_bookings.get(i).getBookingStatus().equals("completed")){
                            al_completed_bookings.add(al_bookings.get(i));
                        }else
                        {
                            al_pending_bookings.add(al_bookings.get(i));
                        }
                    }

                }else{
                    Toast.makeText(getContext(), "No Bookings till date!", Toast.LENGTH_SHORT).show();
                }

                viewPager = (ViewPager)bookingsFragment.findViewById(R.id.viewpager);
                setupViewPager(viewPager);

                // Set Tabs inside Toolbar
                TabLayout tabs = (TabLayout) bookingsFragment.findViewById(R.id.tabs);
                tabs.setupWithViewPager(viewPager);

                Log.e("successORnot : ", String.valueOf(successOrNot));

            }
            @Override
            public void onFailure(Call<BookingsResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE: ", t.toString());
            }
        });


    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {

        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new PendingBookingsFragment(), "Pending Bookings");
        adapter.addFragment(new CompletedBookingsFragment(), "Completed Bookings");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
//            return 2;
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
