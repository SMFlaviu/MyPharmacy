package com.mypharmacyprojectt.mypharmacy.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DrugsResponse {

    List<Drugs> Data;
    String Status;

    public List<Drugs> getData() {
        return Data;
    }
}
