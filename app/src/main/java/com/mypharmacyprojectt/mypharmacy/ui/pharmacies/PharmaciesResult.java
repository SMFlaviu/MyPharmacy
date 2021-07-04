package com.mypharmacyprojectt.mypharmacy.ui.pharmacies;

import androidx.annotation.Nullable;

public class PharmaciesResult {
    private boolean isSuccess;

    @Nullable
    private String error;

    public PharmaciesResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public PharmaciesResult(boolean isSuccess, @Nullable String error) {
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
