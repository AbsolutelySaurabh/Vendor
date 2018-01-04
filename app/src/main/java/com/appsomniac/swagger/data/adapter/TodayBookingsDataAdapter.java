package com.appsomniac.swagger.data.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsomniac.swagger.data.model.TodayBookingsHome;
import com.appsomniac.swagger.data.viewHolder.TodayBookingViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class TodayBookingsDataAdapter extends RecyclerView.Adapter<TodayBookingViewHolder> {

    private ArrayList<TodayBookingsHome> todayBookingsList;
    private Context mContext;
    public static String EXTRA_MESSAGE = "";

    public TodayBookingsDataAdapter(Context context, ArrayList<TodayBookingsHome> todayBookingsList) {
        this.todayBookingsList = todayBookingsList;
        this.mContext = context;
    }

    @Override
    public TodayBookingViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        return new TodayBookingViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup, position, todayBookingsList);

    }

    @Override
    public void onBindViewHolder(TodayBookingViewHolder holder, int position) {

        holder.bookingNumber.setText(todayBookingsList.get(position).getNumber());
        holder.bookingTitle.setText(todayBookingsList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return (null != todayBookingsList ? todayBookingsList.size() : 0);
    }
}