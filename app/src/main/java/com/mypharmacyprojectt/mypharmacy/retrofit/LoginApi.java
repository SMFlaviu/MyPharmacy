package com.mypharmacyprojectt.mypharmacy.retrofit;

import com.mypharmacyprojectt.mypharmacy.data.model.LoggedInUser;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApi {
    @FormUrlEncoded
    @POST("api/v1/login")
    Observable<LoggedInUser> loginRequest(
            @Field("email") String email,
            @Field("pass") String pass
    );
}
