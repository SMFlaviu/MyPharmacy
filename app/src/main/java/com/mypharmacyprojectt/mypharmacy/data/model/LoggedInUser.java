package com.mypharmacyprojectt.mypharmacy.data.model;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

public class LoggedInUser {
    String Status;
    LoggedInUserData Data;

    public String getStatus() {
        return Status;
    }

    public LoggedInUserData getData() {
        return Data;
    }

    @NonNull
    @NotNull
    @Override
    public String toString() {
        return Status;
    }
}
