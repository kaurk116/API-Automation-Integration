package com.thetestingacademy.modulers;

import com.google.gson.Gson;
import com.thetestingacademy.pojos.*;


public class PayloadManager {

    Gson gson;

    public String createPayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Karam");
        booking.setLastname("Saini");
        booking.setTotalprice(200);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        gson = new Gson();
        return gson.toJson(booking);
    }

    public String UpdatePayloadBookingAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Karamjeet");
        booking.setLastname("Saini");
        booking.setTotalprice(200);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);
    }

    public Responsed bookingResponseJava(String responseString) {
        gson = new Gson();
        Responsed bookingResponsed = gson.fromJson(responseString, Responsed.class);
        return bookingResponsed;
    }

    public static String setPayloadAuth() {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        //serialization
        Gson gson = new Gson();
        //String jsonpayloadString =gson.toJson(auth);
        // System.out.println("Payload Auth " + gson.toJson(auth));
        return gson.toJson(auth);
    }

    public String getTokenFromJSON(String responseString) {
        Gson gson = new Gson();
        TokenResponse tokenResponsed = gson.fromJson(responseString,TokenResponse.class);
        return tokenResponsed.getToken();
    }

    public static Booking getBookingFromJSON(String getresponse) {
        Gson gson = new Gson();
        Booking bookingResponsed1 = gson.fromJson(getresponse, Booking.class);
        return bookingResponsed1;
    }


}

