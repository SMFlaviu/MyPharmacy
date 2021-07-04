package com.mypharmacyprojectt.mypharmacy.ui.drugs;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mypharmacyprojectt.mypharmacy.data.model.Drugs;
import com.mypharmacyprojectt.mypharmacy.data.model.DrugsResponse;
import com.mypharmacyprojectt.mypharmacy.retrofit.DrugsApi;
import com.mypharmacyprojectt.mypharmacy.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DrugsViewModel extends ViewModel {

    private MutableLiveData<DrugsResult> drugsResult = new MutableLiveData<>();

    private List<Drugs> drugs = new ArrayList<>();

    public DrugsViewModel() {
    }

    LiveData<DrugsResult> getDrugsResult() {
        return drugsResult;
    }

    List<Drugs> getDrugs() {
        return drugs;
    }

    public void searchDrugs(String searchInput) {
        DrugsApi drugsApi = RetrofitClient.getClient().create(DrugsApi.class);
        drugsApi.searchDrugs("data-dencom", searchInput, "bff3e9efec7b35ddf9f0ca79099dbc953ba08f20cd00da39828c328b25f8ce04c4a86e43381b3b804c4378ba8d3fe2b7c16279c219356f8fa1fee31021889a88")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DrugsResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull DrugsResponse drugsResponse) {
                        if (drugsResponse.getData() != null) {
                            drugs.addAll(drugsResponse.getData());
                            drugsResult.setValue(new DrugsResult(true));
                        } else {
                            drugsResult.setValue(new DrugsResult(false, "Failed"));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        drugsResult.setValue(new DrugsResult(false, "Failed"));
                        e.printStackTrace();
                        Log.d("TGM", "drugsResponse failed 2222");
                    }

                    @Override
                    public void onComplete() {
                    }
                });

    }

}