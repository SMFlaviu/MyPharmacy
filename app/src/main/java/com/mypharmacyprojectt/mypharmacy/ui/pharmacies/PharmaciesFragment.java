package com.mypharmacyprojectt.mypharmacy.ui.pharmacies;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mypharmacyprojectt.mypharmacy.data.model.Pharmacies;
import com.mypharmacyprojectt.mypharmacy.data.repository.PharmaciesRepository;
import com.mypharmacyprojectt.mypharmacy.databinding.FragmentPharmaciesBinding;
import com.mypharmacyprojectt.mypharmacy.ui.addpharmacies.AddPharmacies;

import java.util.ArrayList;

public class PharmaciesFragment extends Fragment {

    private PharmaciesViewModel pharmaciesViewModel;
    private FragmentPharmaciesBinding binding;
    private PharmaciesAdapter pharmaciesAdapter;
    private PharmaciesRepository pharmaciesRepository;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pharmaciesViewModel =
                new ViewModelProvider(this).get(PharmaciesViewModel.class);

        binding = FragmentPharmaciesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        pharmaciesRepository = PharmaciesRepository.getInstance();

        RecyclerView pharmaciesList = binding.pharmaciesRecyclerView;
        pharmaciesList.setLayoutManager(new LinearLayoutManager(root.getContext()));
        ArrayList<Pharmacies> pharmaciesArrayList = new ArrayList<>();
        pharmaciesAdapter = new PharmaciesAdapter(root.getContext(), pharmaciesArrayList);
        pharmaciesAdapter.setClickListener(new PharmaciesAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });
        pharmaciesList.setAdapter(pharmaciesAdapter);

        binding.addPharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), AddPharmacies.class);
                startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        pharmaciesAdapter.clearPharmacies();
        pharmaciesAdapter.addPharmacies(pharmaciesRepository.getPharmacies());
        pharmaciesAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}