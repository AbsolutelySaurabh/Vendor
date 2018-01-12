package com.appsomniac.swagger.data.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.config.network.ApiResponse.GetServiceBookingResponse;
import com.appsomniac.swagger.config.network.retrofit.ApiClient;
import com.appsomniac.swagger.config.network.retrofit.ApiInterface;
import com.appsomniac.swagger.data.model.Bookings.Bookings;
import com.appsomniac.swagger.data.model.Bookings.PopUpPendingBookings;
import com.appsomniac.swagger.data.viewHolder.PendingBookingsViewHolder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class PendingBookingsAdapter extends RecyclerView.Adapter<PendingBookingsViewHolder> {

    private ArrayList<Bookings> todayBookingsList;
    private Context mContext;
    public static String EXTRA_MESSAGE = "";
    public static ArrayList<PopUpPendingBookings> al_pop_up_data;

    public PendingBookingsAdapter(Context context, ArrayList<Bookings> todayBookingsList) {
        this.todayBookingsList = todayBookingsList;
        this.mContext = context;
    }

    @Override
    public PendingBookingsViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        return new PendingBookingsViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup, position, todayBookingsList, mContext);

    }

    @Override
    public void onBindViewHolder(PendingBookingsViewHolder holder, final int position) {

        Bookings singleItem = todayBookingsList.get(position);
        //need to find user_name form user_id by hitting API
        holder.guest_name.setText(todayBookingsList.get(position).getUser_name());
        holder.amount.setText(todayBookingsList.get(position).getBookingAmount());
        holder.date.setText(todayBookingsList.get(position).getBookingDate());
        holder.time.setText(todayBookingsList.get(position).getBookingTime());

        SharedPreferences prefs_vendor_details = mContext.getSharedPreferences("VENDOR_DETAILS", MODE_PRIVATE);
        final String store_id = prefs_vendor_details.getString("vendor_id", "0");

        holder.services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){


                generatePopUpData(store_id, position);

            }
        });
    }

    public void generatePopUpData(String store_id, int position){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<GetServiceBookingResponse> call = apiService.getPendingServiceBookingPopUpData(store_id,todayBookingsList.get(position).getBookingDate(), todayBookingsList.get(position).getBookingTime());

        call.enqueue(new Callback<GetServiceBookingResponse>() {
            @Override
            public void onResponse(Call<GetServiceBookingResponse>call, Response<GetServiceBookingResponse> response) {

                Boolean successOrNot = response.body().getSuccess();
                if(successOrNot) {

                    al_pop_up_data = response.body().getData();
                    showDialog();

                }else{
                    Toast.makeText(mContext, "No Bookings till date!", Toast.LENGTH_SHORT).show();
                }

                Log.e("successORnot : ", String.valueOf(successOrNot));

            }
            @Override
            public void onFailure(Call<GetServiceBookingResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE: ", t.toString());
            }
        });

    }

    public void showDialog(){

        Dialog dialog = new Dialog(mContext);
        //set layout custom
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_pop_up_pending_bookings);
        RecyclerView pop_up_recyclerview = (RecyclerView) dialog.findViewById(R.id.pop_up_pending_bookings_recyclerview);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        PopUpAdapterPendingBookings pop_up_adapter = new PopUpAdapterPendingBookings(mContext,al_pop_up_data);
        pop_up_recyclerview.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        pop_up_recyclerview.setAdapter(pop_up_adapter);
        pop_up_recyclerview.setHasFixedSize(true);
        pop_up_recyclerview.setNestedScrollingEnabled(true);

        dialog.show();
    }

    @Override
    public int getItemCount() {
        return (null != todayBookingsList ? todayBookingsList.size() : 0);
    }
}