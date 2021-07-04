package com.mypharmacyprojectt.mypharmacy.data.model;

import com.google.gson.annotations.SerializedName;

//    {"address":"ceva.ceva blds1ceakl",
//    "age":15,
//    "email":"user@user.user",
//    "fname":"test1",
//    "lname":"test2",
//    "location":"-100, 200",
//    "token":"e733c612b4733ee41b99484d5e725e52406eaff1471b599ad0431297f3340e5721284ea7fa9ad5c545f40698aa6895f8a3f0fec1ba94df94a5fec6f4682ad4a1",
//    "user-uuid":"b6cafe2b-d1cf-4126-a01d-4c50524d9901"}
public class LoggedInUserData {

    String address;
    int age;
    String email;
    String fname;
    String lname;
    String location;
    String token;
    boolean pharmacist;

    @SerializedName("user-uuid")
    String user_uuid;

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getLocation() {
        return location;
    }

    public String getToken() {
        return token;
    }

    public boolean isPharmacist() {
        return pharmacist;
    }

    public String getUser_uuid() {
        return user_uuid;
    }
}
