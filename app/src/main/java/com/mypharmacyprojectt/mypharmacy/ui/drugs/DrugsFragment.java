package com.mypharmacyprojectt.mypharmacy.ui.drugs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mypharmacyprojectt.mypharmacy.data.model.Drugs;
import com.mypharmacyprojectt.mypharmacy.databinding.FragmentDrugsBinding;

import java.util.ArrayList;
import java.util.List;

public class DrugsFragment extends Fragment {

    private DrugsViewModel drugsViewModel;
    private FragmentDrugsBinding binding;
    private DrugsAdapter drugsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        drugsViewModel =
                new ViewModelProvider(this).get(DrugsViewModel.class);

        binding = FragmentDrugsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button searchButton = binding.searchButton;
        EditText searchString = binding.searchInput;

        RecyclerView drugsList = binding.drugsRecyclerView;
        drugsList.setLayoutManager(new LinearLayoutManager(root.getContext()));
        ArrayList<Drugs> drugs = new ArrayList<>();

        drugsAdapter = new DrugsAdapter(root.getContext(), new ArrayList<Drugs>());
        drugsList.setAdapter(drugsAdapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchString.getText() != null &&
                        !searchString.getText().toString().isEmpty()) {
                    updateUi(new ArrayList<>());
                    drugsViewModel.searchDrugs(searchString.getText().toString());
                }
            }
        });

        drugsViewModel.getDrugsResult().observe(requireActivity(), new Observer<DrugsResult>() {
            @Override
            public void onChanged(DrugsResult drugsResult) {
                if (drugsResult == null) {
                    return;
                }
                if (drugsResult.isSuccess()) {
                    updateUi(drugsViewModel.getDrugs());
                }
            }
        });
        return root;
    }

    public void updateUi(List<Drugs> drugs) {
        drugsAdapter.setDrugs(drugs);
        drugsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}