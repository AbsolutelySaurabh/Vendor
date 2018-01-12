package com.appsomniac.swagger.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.base.MainActivity;
import com.appsomniac.swagger.config.network.ApiResponse.LoginResponse;
import com.appsomniac.swagger.config.network.retrofit.ApiClient;
import com.appsomniac.swagger.config.network.retrofit.ApiInterface;
import com.appsomniac.swagger.data.adapter.TodayBookingsDataAdapter;
import com.appsomniac.swagger.data.adapter.TotalBookingsDataAdapter;
import com.appsomniac.swagger.data.model.Bookings.TodayBookingsHome;
import com.appsomniac.swagger.data.model.Bookings.TotalBookingsHome;
import com.appsomniac.swagger.data.model.HomeFragData;
import com.appsomniac.swagger.data.model.Vendor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment{

    ViewPager viewPager;
    private View homeFragment;
    public static ArrayList<TodayBookingsHome> al_todayBookingsData;
    public static ArrayList<TotalBookingsHome> al_totalBookingsData;
    public static DatePickerDialog datePickerDialog_start, datePickerDialog_end;
    public EditText start_date_edit_text, end_date_edit_text;
//    public DatePickerDialog.OnDateSetListener start_dateListener, end_dateListener;

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

        setDateDialog();

        start_date_edit_text = homeFragment.findViewById(R.id.start_date);
        end_date_edit_text = homeFragment.findViewById(R.id.end_date);

        start_date_edit_text.setOnClickListener(onOnClickEvent_start);
        start_date_edit_text.setOnFocusChangeListener(onFocusChangeEvent_start);

        end_date_edit_text.setOnClickListener(onOnClickEvent_end);
        end_date_edit_text.setOnFocusChangeListener(onFocusChangeEvent_end);

        setTodayBookingsData();
    }


    private DatePickerDialog.OnDateSetListener start_dateListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {

            start_date_edit_text.setText(arg3 + "/" + (arg2 + 1) + "/" + arg1);
        }
    };
    private DatePickerDialog.OnDateSetListener end_dateListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            end_date_edit_text.setText(arg3 + "/" + (arg2 + 1) + "/" + arg1);

        }

    };

    private View.OnClickListener onOnClickEvent_start = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            datePickerDialog_start.show();
        }
    };

    private View.OnFocusChangeListener onFocusChangeEvent_start = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus)
                datePickerDialog_start.show();

        }
    };

    private View.OnClickListener onOnClickEvent_end = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            datePickerDialog_end.show();
        }
    };

    private View.OnFocusChangeListener onFocusChangeEvent_end = new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus)
                datePickerDialog_end.show();

        }
    };

    public void setDateDialog(){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        //end_date_edit_text.setText(day + "/" + month+1 + "/" + year);

        datePickerDialog_start = new DatePickerDialog(getActivity(), (start_dateListener), year, month, day);
        datePickerDialog_end = new DatePickerDialog(getActivity(), end_dateListener, year, month, day);

    }

    public void setTodayBookingsData(){

        SharedPreferences prefs_vendor_details = getContext().getSharedPreferences("VENDOR_DETAILS", MODE_PRIVATE);
        String store_id = prefs_vendor_details.getString("vendor_id", "0");

        getTodayTotalBookingsData(getDate(), store_id);

    }

    public void getTodayTotalBookingsData(String date, String store_id){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<HomeFragData> call = apiService.getHomeData(date, store_id);

        call.enqueue(new Callback<HomeFragData>() {
            @Override
            public void onResponse(Call<HomeFragData>call, Response<HomeFragData> response) {

                HomeFragData home_frag_data;
                home_frag_data = response.body();
                Boolean successOrNot = home_frag_data.getSuccess();

                if(successOrNot) {

                    al_todayBookingsData.add(new TodayBookingsHome( home_frag_data.getRecieved_booking_today(), "Bookings Received Today"));
                    al_todayBookingsData.add(new TodayBookingsHome( home_frag_data.getCompleted_booking_today(), "Bookings Completed Today"));
                    al_todayBookingsData.add(new TodayBookingsHome( home_frag_data.getPending_booking_today(), "Bookings Pending Today"));

                    al_totalBookingsData.add(new TotalBookingsHome(home_frag_data.getRecieved_booking(), "Total Bookings Received"));
                    al_totalBookingsData.add(new TotalBookingsHome(home_frag_data.getCompleted_booking(), "Total Bookings Completed"));
                    al_totalBookingsData.add(new TotalBookingsHome(home_frag_data.getPending_booking(), "Total Pending Bookings"));
                    al_totalBookingsData.add(new TotalBookingsHome(home_frag_data.getStore_rating(), "Your Overall Rating"));
                    al_totalBookingsData.add(new TotalBookingsHome(home_frag_data.getReview_num(), "Reviews"));

                    RecyclerView today_recycler_view = homeFragment.findViewById(R.id.recyclerview_today_summary);
                    TodayBookingsDataAdapter today_adapter = new TodayBookingsDataAdapter(getContext(), al_todayBookingsData);
                    today_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    today_recycler_view.setAdapter(today_adapter);
                    today_recycler_view.setHasFixedSize(true);
                    today_recycler_view.setNestedScrollingEnabled(true);

                    RecyclerView total_recycler_view = homeFragment.findViewById(R.id.recyclerview_total_summary);
                    TotalBookingsDataAdapter total_adapter = new TotalBookingsDataAdapter(getContext(), al_totalBookingsData);
                    total_recycler_view.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    total_recycler_view.setAdapter(total_adapter);
                    total_recycler_view.setHasFixedSize(true);
                    total_recycler_view.setNestedScrollingEnabled(true);


                }else{
                    Toast.makeText(getContext(), "Wrong Credentials!", Toast.LENGTH_SHORT).show();
                }

                Log.e("successORnot : ", String.valueOf(successOrNot));

            }
            @Override
            public void onFailure(Call<HomeFragData>call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE: ", t.toString());
            }
        });


    }

    public String getDate(){
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }
}
