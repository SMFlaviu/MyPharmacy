package com.mypharmacyprojectt.mypharmacy.ui.models;

public class InventoryItemUiModel {
    private String drugName;
    private String submittedTime;
    private String prescription;
    private String status;

    public InventoryItemUiModel() { }

    public InventoryItemUiModel(String drugName,
                                String submittedTime,
                                String prescription,
                                String status) {
        this.drugName = drugName;
        this.submittedTime = submittedTime;
        this.prescription = prescription;
        this.status = status;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getSubmittedTime() {
        return submittedTime;
    }

    public void setSubmittedTime(String submittedTime) {
        this.submittedTime = submittedTime;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
