package com.appsomniac.swagger.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.classfragments.CompletedBookingsFragment;
import com.appsomniac.swagger.classfragments.PendingBookingsFragment;
import com.appsomniac.swagger.data.adapter.TodayBookingsDataAdapter;
import com.appsomniac.swagger.data.adapter.TotalBookingsDataAdapter;
import com.appsomniac.swagger.data.model.TodayBookingsHome;
import com.appsomniac.swagger.data.model.TotalBookingsHome;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class BookingsFragment extends Fragment {

    ViewPager viewPager;
    private View bookingsFragment;
    ArrayList<TodayBookingsHome> al_todayBookingsData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        bookingsFragment = inflater.inflate(R.layout.fragment_bookings, container, false);
        return bookingsFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewPager = (ViewPager)bookingsFragment.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) bookingsFragment.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                } else
                if(position == 1) {
                }else
                if(position == 2){
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

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
