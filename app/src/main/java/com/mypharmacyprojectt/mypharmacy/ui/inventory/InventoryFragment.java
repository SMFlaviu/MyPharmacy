package com.mypharmacyprojectt.mypharmacy.ui.inventory;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mypharmacyprojectt.mypharmacy.R;
import com.mypharmacyprojectt.mypharmacy.databinding.FragmentInventoryBinding;
import com.mypharmacyprojectt.mypharmacy.ui.models.InventoryItemUiModel;

import java.util.ArrayList;

public class InventoryFragment extends Fragment {

    private InventoryViewModel inventoryViewModel;
    private FragmentInventoryBinding binding;
    private InventoryAdapter inventoryAdapter;
    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inventoryViewModel =
                new ViewModelProvider(this).get(InventoryViewModel.class);

        binding = FragmentInventoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        context = root.getContext();

        RecyclerView inventoryList = binding.inventoryRecyclerView;
        inventoryList.setLayoutManager(new LinearLayoutManager(root.getContext()));
        ArrayList<InventoryItemUiModel> inventoryItemUiModels = new ArrayList<>();

        inventoryItemUiModels.add(new InventoryItemUiModel(
                "PARACETAMOL ZENTIVA",
                "1h ago",
                "Administrare orala",
                "PENDING"
        ));
        inventoryAdapter = new InventoryAdapter(root.getContext(), inventoryItemUiModels);
        inventoryList.setAdapter(inventoryAdapter);
        inventoryAdapter.setClickListener(new InventoryAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                inventoryItemUiModels.get(position).setStatus("ACTIVE");
                inventoryAdapter.notifyDataSetChanged();
                buildNotification();
            }
        });
        createNotificationChannel();
        return root;
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "myChannel";
            String description = "myDescription";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void buildNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CHANNEL_ID")
                .setSmallIcon(R.drawable.ic_logo)
                .setContentTitle("Don't forget to take your pills...")
                .setContentText("Take PARACETAMOL ZENTIVA from 8 to 8 hours starting now...")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(10, builder.build());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}