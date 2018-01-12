package com.appsomniac.swagger.data.model.Bookings;

import com.google.gson.annotations.SerializedName;

/**
 * Created by absolutelysaurabh on 10/1/18.
 */

public class Bookings {

    @SerializedName("book_id")
    private String bookId;
    @SerializedName("booking_id")
    private String bookingId;
    @SerializedName("booking_qr_code")
    private String bookingQrCode;
    @SerializedName("booking_amount")
    private String bookingAmount;
    @SerializedName("booking_time")
    private String bookingTime;
    @SerializedName("booking_date")
    private String bookingDate;
    @SerializedName("booking_address")
    private String bookingAddress;
    @SerializedName("booking_applied_promo_code")
    private String bookingAppliedPromoCode;
    @SerializedName("booking_service")
    private String bookingService;
    @SerializedName("booking_status")
    private String bookingStatus;
    @SerializedName("booking_store_id")
    private String bookingStoreId;
    @SerializedName("booking_user_id")
    private String bookingUserId;
    @SerializedName("platform")
    private String platform;
    @SerializedName("version")
    private String version;
    @SerializedName("user_name")
    private String user_name;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingQrCode() {
        return bookingQrCode;
    }

    public void setBookingQrCode(String bookingQrCode) {
        this.bookingQrCode = bookingQrCode;
    }

    public String getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(String bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingAddress() {
        return bookingAddress;
    }

    public void setBookingAddress(String bookingAddress) {
        this.bookingAddress = bookingAddress;
    }

    public String getBookingAppliedPromoCode() {
        return bookingAppliedPromoCode;
    }

    public void setBookingAppliedPromoCode(String bookingAppliedPromoCode) {
        this.bookingAppliedPromoCode = bookingAppliedPromoCode;
    }

    public String getBookingService() {
        return bookingService;
    }

    public void setBookingService(String bookingService) {
        this.bookingService = bookingService;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getBookingStoreId() {
        return bookingStoreId;
    }

    public void setBookingStoreId(String bookingStoreId) {
        this.bookingStoreId = bookingStoreId;
    }

    public String getBookingUserId() {
        return bookingUserId;
    }

    public void setBookingUserId(String bookingUserId) {
        this.bookingUserId = bookingUserId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUser_name(){
        return user_name;
    }

    public void setUser_name(String user_name){
        this.user_name = user_name;
    }

}
