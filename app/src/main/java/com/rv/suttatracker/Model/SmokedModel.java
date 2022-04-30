package com.rv.suttatracker.Model;

public class SmokedModel {
    int s_id, cigarette_id;
    String s_price, s_date, s_time, trip, s_place,c_name,nicotine;

    public String getC_name() {
        return c_name;
    }

    public String getNicotine() {
        return nicotine;
    }

    public void setNicotine(String nicotine) {
        this.nicotine = nicotine;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getCigarette_id() {
        return cigarette_id;
    }

    public void setCigarette_id(int cigarette_id) {
        this.cigarette_id = cigarette_id;
    }

    public String getS_price() {
        return s_price;
    }

    public void setS_price(String s_price) {
        this.s_price = s_price;
    }

    public String getS_date() {
        return s_date;
    }

    public void setS_date(String s_date) {
        this.s_date = s_date;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) {
        this.s_time = s_time;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public String getS_place() {
        return s_place;
    }

    public void setS_place(String s_place) {
        this.s_place = s_place;
    }
}
