package com.mypharmacyprojectt.mypharmacy.ui.drugsrequests;

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

import com.mypharmacyprojectt.mypharmacy.data.repository.DrugsRequestsRepository;
import com.mypharmacyprojectt.mypharmacy.databinding.FragmentDrugsrequestsBinding;
import com.mypharmacyprojectt.mypharmacy.ui.adddrugsrequests.AddDrugsRequests;
import com.mypharmacyprojectt.mypharmacy.ui.models.DrugsRequestsUiModel;

import java.util.ArrayList;

public class DrugsRequestsFragment extends Fragment {

    private DrugsRequestsRepository drugsRequestsRepository;
    private DrugsRequestsViewModel drugsRequestsViewModel;
    private FragmentDrugsrequestsBinding binding;
    private DrugsRequestsAdapter drugsRequestsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        drugsRequestsViewModel =
                new ViewModelProvider(this).get(DrugsRequestsViewModel.class);

        binding = FragmentDrugsrequestsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        drugsRequestsRepository = DrugsRequestsRepository.getInstance();
        RecyclerView drugsRequestsList = binding.drugsRequestsRecyclerView;
        drugsRequestsList.setLayoutManager(new LinearLayoutManager(root.getContext()));
        ArrayList<DrugsRequestsUiModel> drugsRequestsUiModels = new ArrayList<>();
        drugsRequestsUiModels.add(new DrugsRequestsUiModel(
                "PARACETAMOL ZENTIVA",
                "user",
                "Gavril Tudoras nr. 19",
                true,
                false
        ));
        drugsRequestsUiModels.add(new DrugsRequestsUiModel(
                "FLUIMUCIL",
                "user",
                "Gavril Tudoras nr. 19",
                true,
                true
        ));
        drugsRequestsAdapter = new DrugsRequestsAdapter(root.getContext(), drugsRequestsUiModels);
        drugsRequestsList.setAdapter(drugsRequestsAdapter);

        binding.addDrugRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(root.getContext(), AddDrugsRequests.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}