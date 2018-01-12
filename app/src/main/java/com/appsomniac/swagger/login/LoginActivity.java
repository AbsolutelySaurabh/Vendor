package com.appsomniac.swagger.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appsomniac.swagger.R;
import com.appsomniac.swagger.base.MainActivity;
import com.appsomniac.swagger.config.network.ApiResponse.LoginResponse;
import com.appsomniac.swagger.config.network.retrofit.ApiClient;
import com.appsomniac.swagger.config.network.retrofit.ApiInterface;
import com.appsomniac.swagger.data.model.Vendor;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText inputPhoneNumber, inputPassword;
    public SharedPreferences.Editor prefs_vendor_details;
    public static Vendor vendor_details;
    public static Boolean successOrNot = false;
    public static String phone_number, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView login_button = findViewById(R.id.btn_login);
        inputPhoneNumber = (EditText) findViewById(R.id.phone);
        inputPassword = (EditText) findViewById(R.id.password);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phone_number = inputPhoneNumber.getText().toString();
                password = inputPassword.getText().toString();
                if (phone_number.length()!=0 && password.length()!=0) {

                    getLoginResponse(phone_number, password);

                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getLoginResponse(String phone_number, String password){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Map<String, String> params = new HashMap<String, String>();
        params.put("phone", phone_number);
        params.put("password", password);
        Call<LoginResponse> call = apiService.getUserDetails(phone_number, password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse>call, Response<LoginResponse> response) {

                Vendor vendor_data;
                vendor_data = response.body().getData();
                successOrNot = response.body().getSuccess();

                if(successOrNot) {

                    Toast.makeText(getApplicationContext(), "Successfully Logged In!", Toast.LENGTH_SHORT).show();
                    addDataToSharedPrefs(vendor_data);

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();

                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials!", Toast.LENGTH_SHORT).show();
                }

                Log.e("successORnot : ", String.valueOf(successOrNot));

            }
            @Override
            public void onFailure(Call<LoginResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e("FAILURE: ", t.toString());
            }
        });

    }

    public void addDataToSharedPrefs(Vendor vendor_data){

        prefs_vendor_details = getApplicationContext().getSharedPreferences("VENDOR_DETAILS", MODE_PRIVATE).edit();
        prefs_vendor_details.putString("vendor_id", vendor_data.getVendorId());
        prefs_vendor_details.putString("store_phone", vendor_data.getStorePhone());
        prefs_vendor_details.putString("store_password", vendor_data.getStorePassword());
        prefs_vendor_details.putString("store_address", vendor_data.getStoreAddress());
        prefs_vendor_details.putString("store_address_long", vendor_data.getStoreAddressLong());
        prefs_vendor_details.putString("store_address_lat", vendor_data.getStoreAddressLat());
        prefs_vendor_details.putString("store_name", vendor_data.getStoreName());
        prefs_vendor_details.putString("store_capacity", vendor_data.getStoreCapacity());
        prefs_vendor_details.putString("store_categoty", vendor_data.getStoreCategory());
        prefs_vendor_details.putString("store_services_offered", vendor_data.getServicesOffered());
        prefs_vendor_details.putString("vendor_pics", vendor_data.getVendorPics());
        prefs_vendor_details.putString("store_aminities_ids", vendor_data.getStoreAminitiesIds());
        prefs_vendor_details.putString("store_area", vendor_data.getStoreArea());
        prefs_vendor_details.putString("store_discount", vendor_data.getStoreDiscount());
        prefs_vendor_details.putString("store_commission", vendor_data.getStoreCommission());
        prefs_vendor_details.putString("store_assured", vendor_data.getStoreAssured());
        prefs_vendor_details.putString("person_name", vendor_data.getPersonName());
        prefs_vendor_details.putString("person_photo", vendor_data.getPersonPhoto());
        prefs_vendor_details.putString("person_phone", vendor_data.getPersonPhone());
        prefs_vendor_details.putString("store_average_rating", vendor_data.getStoreAvgRating());
        prefs_vendor_details.putString("store_info", vendor_data.getStoreInfo());
        prefs_vendor_details.putString("store_status", vendor_data.getStoreStatus());
        prefs_vendor_details.putString("DOW", vendor_data.getDOW());
        prefs_vendor_details.putString("timing", vendor_data.getTiming());
        prefs_vendor_details.putString("store_zone", vendor_data.getStoreZone());
        prefs_vendor_details.putString("store_landmark", vendor_data.getStoreLandmark());
        prefs_vendor_details.putBoolean("loggedInorNot", successOrNot);
        prefs_vendor_details.apply();

    }


}
