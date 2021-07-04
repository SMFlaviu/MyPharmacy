package com.mypharmacyprojectt.mypharmacy.ui.models;

public class DrugsRequestsUiModel {

    private String requestMessage;
    private String userName;
    private String userLocation;
    private boolean prescription = false;
    private boolean compensated = false;

    public DrugsRequestsUiModel() { }

    public DrugsRequestsUiModel(String requestMessage,
                                String userName,
                                String userLocation,
                                boolean prescription,
                                boolean compensated) {

        this.requestMessage = requestMessage;
        this.userName = userName;
        this.userLocation = userLocation;
        this.prescription = prescription;
        this.compensated = compensated;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public boolean isPrescription() {
        return prescription;
    }

    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }

    public boolean isCompensated() {
        return compensated;
    }

    public void setCompensated(boolean compensated) {
        this.compensated = compensated;
    }
}
