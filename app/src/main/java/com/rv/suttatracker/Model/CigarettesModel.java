package com.rv.suttatracker.Model;

public class CigarettesModel {
    int cigerettes_id, brand_id;
    String cigerettes_name, nicotine;

    public int getCigerettes_id() {
        return cigerettes_id;
    }

    public void setCigerettes_id(int cigerettes_id) {
        this.cigerettes_id = cigerettes_id;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getCigerettes_name() {
        return cigerettes_name;
    }

    public void setCigerettes_name(String cigerettes_name) {
        this.cigerettes_name = cigerettes_name;
    }

    public String getNicotine() {
        return nicotine;
    }

    public void setNicotine(String nicotine) {
        this.nicotine = nicotine;
    }
}
