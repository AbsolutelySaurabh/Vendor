package com.appsomniac.swagger.fragment;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.config.network.retrofit.ApiClient;
import com.appsomniac.swagger.config.network.retrofit.ApiInterface;
import com.appsomniac.swagger.data.adapter.TodayBookingsDataAdapter;
import com.appsomniac.swagger.data.adapter.TotalBookingsDataAdapter;
import com.appsomniac.swagger.data.model.Bookings.TodayBookingsHome;
import com.appsomniac.swagger.data.model.Bookings.TotalBookingsHome;
import com.appsomniac.swagger.data.model.EnquiryData;
import com.appsomniac.swagger.data.model.HomeFragData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by absolutelysaurabh on 22/12/17.
 */

public class EnquiryFragment extends Fragment {

    ViewPager viewPager;
    private View enquiryFragment;
    private static EditText query_editText;
    private EditText query_type_editText;
    public String store_id;
    public String query_type;
    public String query_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        enquiryFragment = inflater.inflate(R.layout.fragment_enquiry, container, false);
        return enquiryFragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //        store_id = getContext().getSharedPreferences("VENDOR_DETAILS", MODE_PRIVATE).getString("vendor_id", "0");
        store_id = "1";
        query_type_editText = enquiryFragment.findViewById(R.id.query_type_text);

        query_editText = enquiryFragment.findViewById(R.id.query_text);
        setFragment();
    }

    public void setFragment(){

        TextView submit = enquiryFragment.findViewById(R.id.query_submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                query_type = query_type_editText.getText().toString();
                query_text = query_editText.getText().toString();
                if (query_text.length()!=0 && query_type.length()!=0) {
                    postQuery(query_type, query_text, store_id);
                   // Log.e("query_type ",query_type );
                }else{
                    Toast.makeText(getContext(), "Enter something !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void postQuery(String query_type, String query_text, String store_id){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<EnquiryData> call = apiService.postEnquiry(query_type, query_text, store_id);
        call.enqueue(new Callback<EnquiryData>() {
            @Override
            public void onResponse(Call<EnquiryData>call, Response<EnquiryData> response) {

                Boolean successOrNot = response.body().getSuccess();

                if(successOrNot) {

                    showDialog();

                }else{
                    Toast.makeText(getContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
                }
                Log.e("successORnot : ", String.valueOf(successOrNot));
            }
            @Override
            public void onFailure(Call<EnquiryData>call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE: ", t.toString());
            }
        });
    }

    public void showDialog(){
        final Dialog dialog = new Dialog(getContext());
        //set layout custom
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_pop_up_query);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView ok = dialog.findViewById(R.id.ok_text);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                dialog.cancel();
            }
        });

        dialog.show();

        query_editText.setText("");
        query_type_editText.setText("");
    }
}
