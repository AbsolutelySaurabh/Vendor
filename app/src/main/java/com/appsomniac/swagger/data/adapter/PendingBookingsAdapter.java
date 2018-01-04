package com.appsomniac.swagger.data.adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.data.model.Drawer;
import com.appsomniac.swagger.data.model.PendingBookings;
import com.appsomniac.swagger.data.model.PopUpPendingBookings;
import com.appsomniac.swagger.data.model.TodayBookingsHome;
import com.appsomniac.swagger.data.viewHolder.PendingBookingsViewHolder;
import com.appsomniac.swagger.data.viewHolder.TodayBookingViewHolder;

import java.util.ArrayList;

public class PendingBookingsAdapter extends RecyclerView.Adapter<PendingBookingsViewHolder> {

    private ArrayList<PendingBookings> todayBookingsList;
    private Context mContext;
    public static String EXTRA_MESSAGE = "";

    public PendingBookingsAdapter(Context context, ArrayList<PendingBookings> todayBookingsList) {
        this.todayBookingsList = todayBookingsList;
        this.mContext = context;
    }

    @Override
    public PendingBookingsViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        return new PendingBookingsViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup, position, todayBookingsList, mContext);

    }

    @Override
    public void onBindViewHolder(PendingBookingsViewHolder holder, final int position) {

        PendingBookings singleItem = todayBookingsList.get(position);

        holder.guest_name.setText(todayBookingsList.get(position).getGuest_name());
        holder.amount.setText(todayBookingsList.get(position).getAmount_to_collect());
        holder.date.setText(todayBookingsList.get(position).getDate());
        holder.time.setText(todayBookingsList.get(position).getTime());

        holder.services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                Dialog dialog = new Dialog(mContext);
                //set layout custom
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_pop_up_pending_bookings);
                RecyclerView pop_up_recyclerview = (RecyclerView) dialog.findViewById(R.id.pop_up_pending_bookings_recyclerview);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                PopUpAdapterPendingBookings pop_up_adapter = new PopUpAdapterPendingBookings(mContext,generatePopUpData());
                pop_up_recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

                pop_up_recyclerview.setAdapter(pop_up_adapter);
                pop_up_recyclerview.setHasFixedSize(true);
                pop_up_recyclerview.setNestedScrollingEnabled(true);

                dialog.show();

            }
        });
    }

    public ArrayList<PopUpPendingBookings> generatePopUpData(){

        ArrayList<PopUpPendingBookings> al_pop_urp_pending_bookings = new ArrayList<PopUpPendingBookings>();

        PopUpPendingBookings pop_up_1 = new PopUpPendingBookings();
        pop_up_1.setSetviceName("Hair Cut");
        pop_up_1.setServiceAmount("400");
        PopUpPendingBookings pop_up_2 = new PopUpPendingBookings();
        pop_up_2.setSetviceName("Nakhun Cut");
        pop_up_2.setServiceAmount("800");
        PopUpPendingBookings pop_up_3 = new PopUpPendingBookings();
        pop_up_3.setSetviceName("Spa");
        pop_up_3.setServiceAmount("900");

        PopUpPendingBookings pop_up_4 = new PopUpPendingBookings();
        pop_up_4.setSetviceName("Nakhun Cut");
        pop_up_4.setServiceAmount("800");
        PopUpPendingBookings pop_up_5 = new PopUpPendingBookings();
        pop_up_5.setSetviceName("Spa");
        pop_up_5.setServiceAmount("900");

        al_pop_urp_pending_bookings.add(pop_up_1);
        al_pop_urp_pending_bookings.add(pop_up_2);
        al_pop_urp_pending_bookings.add(pop_up_3);
        al_pop_urp_pending_bookings.add(pop_up_4);
        al_pop_urp_pending_bookings.add(pop_up_5);

        return al_pop_urp_pending_bookings;
    }

    @Override
    public int getItemCount() {
        return (null != todayBookingsList ? todayBookingsList.size() : 0);
    }
}