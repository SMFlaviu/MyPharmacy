package com.mypharmacyprojectt.mypharmacy.ui.drugsrequests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DrugsRequestsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DrugsRequestsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}