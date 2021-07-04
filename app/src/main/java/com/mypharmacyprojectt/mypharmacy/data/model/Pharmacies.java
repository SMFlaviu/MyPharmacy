package com.mypharmacyprojectt.mypharmacy.data.model;

import com.google.gson.annotations.SerializedName;

public class Pharmacies {

    @SerializedName("pharmacy-id")
    String pharmacyId;
    String name;
    String location;

    public Pharmacies() { }

    public Pharmacies(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getPharmacyId() {
        return pharmacyId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
