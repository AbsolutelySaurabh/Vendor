package com.appsomniac.swagger.config.network.retrofit;

/**
 * Created by absolutelysaurabh on 23/9/17.
 */

import com.appsomniac.swagger.config.network.ApiResponse.BookingsResponse;
import com.appsomniac.swagger.config.network.ApiResponse.GetServiceBookingResponse;
import com.appsomniac.swagger.config.network.ApiResponse.LoginResponse;
import com.appsomniac.swagger.data.model.Bookings.PopUpCompletedBookings;
import com.appsomniac.swagger.data.model.EnquiryData;
import com.appsomniac.swagger.data.model.HomeFragData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("VendorApi/login")
    @FormUrlEncoded
    Call<LoginResponse> getUserDetails(@Field("phone") String phone_number, @Field("password") String pass);
    //login/now_playing?phone= " " & password = " ";

    @POST("VendorApi/home")
    @FormUrlEncoded
    Call<HomeFragData> getHomeData(@Field("today") String today, @Field("store_id") String store_id);
    //login/now_playing?phone= " " & password = " ";

    @POST("VendorApi/send_enquiry")
    @FormUrlEncoded
    Call<EnquiryData> postEnquiry(@Field("title") String title, @Field("desc") String desc, @Field("store_id") String store_id);
    //login/now_playing?phone= " " & password = " ";

    @POST("VendorApi/booking_tab")
    @FormUrlEncoded
    Call<BookingsResponse> getBookingsData(@Field("store_id") String store_id);

    @POST("VendorApi/get_service_booking")
    @FormUrlEncoded
    Call<GetServiceBookingResponse> getPendingServiceBookingPopUpData(@Field("store_id") String store_id, @Field("booking_date") String booking_date, @Field("booking_time") String booking_time);

    @POST("VendorApi/get_user_feedback")
    @FormUrlEncoded
    Call<PopUpCompletedBookings> getCompletedBookingFeedback(@Field("user_id") String user_id ,@Field("store_id") String store_id);

}