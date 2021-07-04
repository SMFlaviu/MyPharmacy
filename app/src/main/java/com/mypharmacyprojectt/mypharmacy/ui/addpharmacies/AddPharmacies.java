package com.mypharmacyprojectt.mypharmacy.ui.addpharmacies;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mypharmacyprojectt.mypharmacy.R;
import com.mypharmacyprojectt.mypharmacy.data.model.Pharmacies;
import com.mypharmacyprojectt.mypharmacy.data.repository.PharmaciesRepository;

public class AddPharmacies extends AppCompatActivity {

    public PharmaciesRepository pharmaciesRepository;
    private EditText pharmacyName;
    private EditText pharmacyLocation;
    private Button createPharmacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pharmacies);
        setTitle(R.string.title_activity_create_pharmacy);

        pharmaciesRepository = PharmaciesRepository.getInstance();

        pharmacyName = (EditText) findViewById(R.id.pharmacy_name);
        pharmacyLocation = (EditText) findViewById(R.id.pharmacy_location);
        createPharmacy = (Button) findViewById(R.id.create_pharmacy);

        createPharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pharmaciesRepository.addPharmacy(
                        new Pharmacies(pharmacyName.getText().toString(),
                                pharmacyLocation.getText().toString())
                );
                finish();
            }
        });
    }
}