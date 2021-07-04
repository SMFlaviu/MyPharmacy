package com.mypharmacyprojectt.mypharmacy.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mypharmacyprojectt.mypharmacy.R;
import com.mypharmacyprojectt.mypharmacy.databinding.ActivityRegisterBinding;
import com.mypharmacyprojectt.mypharmacy.ui.login.LoginActivity;
import com.mypharmacyprojectt.mypharmacy.ui.login.LoginViewModelFactory;

public class RegisterActivity extends AppCompatActivity {

    boolean isUser = true;
    private RegisterViewModel registerViewModel;
    private ActivityRegisterBinding binding;
    private EditText firstnameEditText;
    private EditText lastnameEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText ageEditText;
    private EditText addressEditText;
    private Button registerButton;
    private Spinner userTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firstnameEditText = binding.firstName;
        lastnameEditText = binding.lastName;
        usernameEditText = binding.username;
        passwordEditText = binding.password;
        ageEditText = binding.age;
        addressEditText = binding.address;
        registerButton = binding.register;
        userTypeSpinner = binding.userTypeSpinner;
        isUser = true;

        registerViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(RegisterViewModel.class);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userTypeSpinner.setAdapter(adapter);

        registerViewModel.getRegisterResult().observe(this, new Observer<RegisterResult>() {
            @Override
            public void onChanged(RegisterResult registerResult) {
                if (registerResult == null) {
                    return;
                }
                if (registerResult.getError() != null) {
                    showRegisterFailed();
                }
                if (registerResult.isSuccess()) {
                    updateUi();
                }
            }
        });

        userTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    isUser = false;
                    ageEditText.setVisibility(View.GONE);
                    addressEditText.setVisibility(View.GONE);
                } else {
                    isUser = true;
                    ageEditText.setVisibility(View.VISIBLE);
                    addressEditText.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isUser) {
                    if (!firstnameEditText.getText().toString().isEmpty() ||
                            !lastnameEditText.getText().toString().isEmpty() ||
                            !usernameEditText.getText().toString().isEmpty() ||
                            !passwordEditText.getText().toString().isEmpty() ||
                            !ageEditText.getText().toString().isEmpty() ||
                            !addressEditText.getText().toString().isEmpty()) {
                        registerViewModel.registerUser(firstnameEditText.getText().toString(),
                                lastnameEditText.getText().toString(),
                                usernameEditText.getText().toString(),
                                passwordEditText.getText().toString(),
                                Integer.parseInt(ageEditText.getText().toString()),
                                addressEditText.getText().toString());
                    } else {
                        showMissingInfoToast();
                    }
                } else {
                    if (!firstnameEditText.getText().toString().isEmpty() ||
                            !lastnameEditText.getText().toString().isEmpty() ||
                            !usernameEditText.getText().toString().isEmpty() ||
                            !passwordEditText.getText().toString().isEmpty()) {
                        registerViewModel.registerPharmacist(firstnameEditText.getText().toString(),
                                lastnameEditText.getText().toString(),
                                usernameEditText.getText().toString(),
                                passwordEditText.getText().toString());
                    } else {
                        showMissingInfoToast();
                    }
                }
            }
        });
    }

    private void showMissingInfoToast() {
        Toast.makeText(getApplicationContext(),
                getResources().getString(R.string.register_missing_info),
                Toast.LENGTH_SHORT).show();
    }

    private void updateUi() {
        Toast.makeText(getApplicationContext(),
                getResources().getString(R.string.register_success),
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void showRegisterFailed() {
        Toast.makeText(getApplicationContext(),
                getResources().getString(R.string.register_failed),
                Toast.LENGTH_SHORT).show();
    }
}