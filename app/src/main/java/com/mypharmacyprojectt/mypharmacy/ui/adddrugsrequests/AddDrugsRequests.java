package com.mypharmacyprojectt.mypharmacy.ui.adddrugsrequests;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.mypharmacyprojectt.mypharmacy.R;
import com.mypharmacyprojectt.mypharmacy.data.repository.DrugsRequestsRepository;
import com.mypharmacyprojectt.mypharmacy.ui.models.DrugsRequestsUiModel;

public class AddDrugsRequests extends AppCompatActivity {

    private DrugsRequestsRepository drugsRequestsRepository;
    private EditText addDrugName;
    private EditText addDrugInfo;
    private CheckBox prescriptionCheckBox;
    private CheckBox compensatedCheckBox;
    private Button createButton;
    private Button discardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drugs_requests);
        setTitle("Create Drugs Request");

        drugsRequestsRepository = DrugsRequestsRepository.getInstance();
        addDrugName = (EditText) findViewById(R.id.add_drug_name);
        addDrugInfo = (EditText) findViewById(R.id.add_drug_info);
        prescriptionCheckBox = (CheckBox) findViewById(R.id.prescription_checkbox);
        compensatedCheckBox = (CheckBox) findViewById(R.id.compensated_checkbox);
        createButton = (Button) findViewById(R.id.create_drug_request);
        discardButton = (Button) findViewById(R.id.discard_drug_request);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drugsRequestsRepository.addDrugsRequestUiModel(
                        new DrugsRequestsUiModel(addDrugName.getText().toString(),
                                "user",
                                "Gavril Tudoras nr. 19",
                                prescriptionCheckBox.isChecked(),
                                compensatedCheckBox.isChecked())
                );
                finish();
            }
        });

        discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}