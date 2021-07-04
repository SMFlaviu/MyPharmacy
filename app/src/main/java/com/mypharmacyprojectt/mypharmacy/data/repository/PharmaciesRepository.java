package com.mypharmacyprojectt.mypharmacy.data.repository;

import com.mypharmacyprojectt.mypharmacy.data.model.Pharmacies;

import java.util.ArrayList;
import java.util.List;

public class PharmaciesRepository {
    private static volatile PharmaciesRepository instance;

    private List<Pharmacies> pharmacies = new ArrayList<>();

    // private constructor : singleton access
    private PharmaciesRepository() { }

    public static PharmaciesRepository getInstance() {
        if (instance == null) {
            instance = new PharmaciesRepository();
        }
        return instance;
    }

    public List<Pharmacies> getPharmacies() {
        return pharmacies;
    }

    public void addPharmacy(Pharmacies pharmacy) {
        this.pharmacies.add(pharmacy);
    }
}
