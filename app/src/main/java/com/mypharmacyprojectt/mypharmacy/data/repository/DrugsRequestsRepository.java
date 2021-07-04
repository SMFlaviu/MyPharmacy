package com.mypharmacyprojectt.mypharmacy.data.repository;

import com.mypharmacyprojectt.mypharmacy.data.model.Pharmacies;
import com.mypharmacyprojectt.mypharmacy.ui.models.DrugsRequestsUiModel;

import java.util.ArrayList;
import java.util.List;

public class DrugsRequestsRepository {
    private static volatile DrugsRequestsRepository instance;

    private List<DrugsRequestsUiModel> drugsRequestsUiModels = new ArrayList<>();

    // private constructor : singleton access
    private DrugsRequestsRepository() { }

    public static DrugsRequestsRepository getInstance() {
        if (instance == null) {
            instance = new DrugsRequestsRepository();
        }
        return instance;
    }

    public List<DrugsRequestsUiModel> getDrugsRequestsUiModels() {
        return drugsRequestsUiModels;
    }

    public void addDrugsRequestUiModel(DrugsRequestsUiModel drugsRequestUiModel) {
        this.drugsRequestsUiModels.add(drugsRequestUiModel);
    }
}