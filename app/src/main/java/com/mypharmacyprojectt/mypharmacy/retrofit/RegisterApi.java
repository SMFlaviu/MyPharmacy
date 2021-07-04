package com.mypharmacyprojectt.mypharmacy.retrofit;

import com.mypharmacyprojectt.mypharmacy.data.model.LoggedInUser;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterApi {
    @FormUrlEncoded
    @POST("api/v1/register-user")
    Observable<LoggedInUser> registerUserRequest(
            @Field("fname") String fname,
            @Field("lname") String lname,
            @Field("age") int age,
            @Field("address") String address,
            @Field("email") String username,
            @Field("pass") String password,
            @Field("location") String location
    );

    @FormUrlEncoded
    @POST("api/v1/register-pharmacist")
    Observable<LoggedInUser> registerPharmacistRequest(
            @Field("fname") String fname,
            @Field("lname") String lname,
            @Field("email") String username,
            @Field("pass") String pass
    );
}
