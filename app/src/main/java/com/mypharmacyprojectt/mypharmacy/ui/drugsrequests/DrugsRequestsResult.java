package com.mypharmacyprojectt.mypharmacy.ui.drugsrequests;

import androidx.annotation.Nullable;

public class DrugsRequestsResult {
    private boolean isSuccess;

    @Nullable
    private String error;

    public DrugsRequestsResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public DrugsRequestsResult(boolean isSuccess, @Nullable String error) {
        this.isSuccess = isSuccess;
        this.error = error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    @Nullable
    public String getError() {
        return error;
    }
}