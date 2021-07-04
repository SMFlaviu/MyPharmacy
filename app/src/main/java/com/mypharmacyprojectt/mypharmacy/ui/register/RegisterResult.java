package com.mypharmacyprojectt.mypharmacy.ui.register;

import androidx.annotation.Nullable;

public class RegisterResult {
    private boolean isSuccess;

    @Nullable
    private String error;

    public RegisterResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public RegisterResult(boolean isSuccess, @Nullable String error) {
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
