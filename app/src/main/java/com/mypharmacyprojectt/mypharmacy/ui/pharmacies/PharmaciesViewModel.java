package com.mypharmacyprojectt.mypharmacy.ui.pharmacies;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PharmaciesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PharmaciesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is pharmacies fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}