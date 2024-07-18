package com.thetestingacademy.pojos;

public class Responsed {
        public Integer bookingid;

        public Booking getBooking() {
            return booking;
        }

        public void setBooking(Booking booking) {
            this.booking = booking;
        }

        public Integer getBookingid() {
            return bookingid;
        }

        public void setBookingid(Integer bookingid) {
            this.bookingid = bookingid;
        }

        private Booking booking;

    }
