package com.mypharmacyprojectt.mypharmacy.ui.drugs;

import androidx.annotation.Nullable;

public class DrugsResult {
    private boolean isSuccess;

    @Nullable
    private String error;

    public DrugsResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public DrugsResult(boolean isSuccess, @Nullable String error) {
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
