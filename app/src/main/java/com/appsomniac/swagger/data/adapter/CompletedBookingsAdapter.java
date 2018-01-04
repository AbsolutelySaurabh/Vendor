package com.appsomniac.swagger.data.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.CompletedBookings;
import com.appsomniac.swagger.data.model.PendingBookings;
import com.appsomniac.swagger.data.viewHolder.CompletedBookingsViewHolder;
import com.appsomniac.swagger.data.viewHolder.PendingBookingsViewHolder;

import java.util.ArrayList;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class CompletedBookingsAdapter extends RecyclerView.Adapter<CompletedBookingsViewHolder> {

    private ArrayList<CompletedBookings> completedBookingsList;
    private Context mContext;
    public static String EXTRA_MESSAGE = "";

    public CompletedBookingsAdapter(Context context, ArrayList<CompletedBookings> completedBookingsList) {
        this.completedBookingsList = completedBookingsList;
        this.mContext = context;
    }

    @Override
    public CompletedBookingsViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        return new CompletedBookingsViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup, position, completedBookingsList, mContext);

    }

    @Override
    public void onBindViewHolder(CompletedBookingsViewHolder holder, int position) {

        holder.guest_name.setText(completedBookingsList.get(position).getGuest_name());
        holder.date.setText(completedBookingsList.get(position).getDate());
        holder.time.setText(completedBookingsList.get(position).getTime());
        holder.amount.setText(completedBookingsList.get(position).getAmount_collected());

        holder.feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){


                final Dialog dialog = new Dialog(mContext);
                //set layout custom
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_pop_up_completed_bookings);

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

    @Override
    public int getItemCount() {
        return (null != completedBookingsList ? completedBookingsList.size() : 0);
    }
}