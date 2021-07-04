    package com.mypharmacyprojectt.mypharmacy;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.mypharmacyprojectt.mypharmacy.data.repository.DrugsRequestsRepository;
import com.mypharmacyprojectt.mypharmacy.data.repository.PharmaciesRepository;
import com.mypharmacyprojectt.mypharmacy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public PharmaciesRepository pharmaciesRepository;
    public DrugsRequestsRepository drugsRequestsRepository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_pharmacies,
                R.id.navigation_drugs,
                R.id.navigation_drugsrequests)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        pharmaciesRepository = PharmaciesRepository.getInstance();
        drugsRequestsRepository = DrugsRequestsRepository.getInstance();
    }

}