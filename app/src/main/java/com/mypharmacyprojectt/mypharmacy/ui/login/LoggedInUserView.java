package com.mypharmacyprojectt.mypharmacy.ui.login;

import com.mypharmacyprojectt.mypharmacy.data.model.LoggedInUser;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;


    LoggedInUserView(LoggedInUser loggedInUser) {
        this.displayName = loggedInUser.getData().getFname();
    }

    String getDisplayName() {
        return displayName;
    }
}