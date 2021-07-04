package com.mypharmacyprojectt.mypharmacy.ui.inventory;

import androidx.annotation.Nullable;

public class InventoryResult {
    private boolean isSuccess;

    @Nullable
    private String error;

    public InventoryResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public InventoryResult(boolean isSuccess, @Nullable String error) {
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