package com.mypharmacyprojectt.mypharmacy.retrofit;

import com.mypharmacyprojectt.mypharmacy.data.model.DrugsResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface DrugsApi {
    @FormUrlEncoded
    @POST("api/v1/live_search")
    Observable<DrugsResponse> searchDrugs(
            @Field("cat") String category,
            @Field("kw") String inputField,
            @Field("token") String token
    );
}
