package com.appsomniac.swagger.data.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.config.network.retrofit.ApiClient;
import com.appsomniac.swagger.config.network.retrofit.ApiInterface;
import com.appsomniac.swagger.data.model.Bookings.Bookings;
import com.appsomniac.swagger.data.model.Bookings.PopUpCompletedBookings;
import com.appsomniac.swagger.data.viewHolder.CompletedBookingsViewHolder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class CompletedBookingsAdapter extends RecyclerView.Adapter<CompletedBookingsViewHolder> {

    private ArrayList<Bookings> completedBookingsList;
    private Context mContext;
    public static String EXTRA_MESSAGE = "";

    public CompletedBookingsAdapter(Context context, ArrayList<Bookings> completedBookingsList) {
        this.completedBookingsList = completedBookingsList;
        this.mContext = context;
    }

    @Override
    public CompletedBookingsViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {

        return new CompletedBookingsViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup, position, completedBookingsList, mContext);

    }

    @Override
    public void onBindViewHolder(CompletedBookingsViewHolder holder, final int position) {

        //need to find user_name from user_id
        holder.guest_name.setText(completedBookingsList.get(position).getUser_name());
        holder.date.setText(completedBookingsList.get(position).getBookingDate());
        holder.time.setText(completedBookingsList.get(position).getBookingTime());
        holder.amount.setText(completedBookingsList.get(position).getBookingAmount());

        holder.feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){


                SharedPreferences prefs_vendor_details = mContext.getSharedPreferences("VENDOR_DETAILS", MODE_PRIVATE);
                String store_id = prefs_vendor_details.getString("vendor_id", "0");
                String user_id = completedBookingsList.get(position).getBookingUserId();
                getFeedBack(user_id, store_id);

            }
        });
    }

    public void getFeedBack(String user_id, String store_id){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<PopUpCompletedBookings> call = apiService.getCompletedBookingFeedback(user_id, store_id);

        call.enqueue(new Callback<PopUpCompletedBookings>() {
            @Override
            public void onResponse(Call<PopUpCompletedBookings>call, Response<PopUpCompletedBookings> response) {

                Boolean successOrNot = response.body().getSuccess();
                String message = response.body().getMessage();
                if(successOrNot) {

                    final Dialog dialog = new Dialog(mContext);
                    //set layout custom
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.custom_pop_up_completed_bookings);

                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                    TextView feedback_text = dialog.findViewById(R.id.feedback_text);
                    feedback_text.setText(message);

                    TextView ok = dialog.findViewById(R.id.ok_text);
                    ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v){

                            dialog.cancel();
                        }
                    });

                    dialog.show();

                }else{
                    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                }

                Log.e("successORnot : ", String.valueOf(successOrNot));

            }
            @Override
            public void onFailure(Call<PopUpCompletedBookings>call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE: ", t.toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != completedBookingsList ? completedBookingsList.size() : 0);
    }
}