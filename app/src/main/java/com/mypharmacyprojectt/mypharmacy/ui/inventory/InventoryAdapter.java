package com.mypharmacyprojectt.mypharmacy.ui.inventory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mypharmacyprojectt.mypharmacy.R;
import com.mypharmacyprojectt.mypharmacy.ui.models.InventoryItemUiModel;

import java.util.List;

public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {

    private List<InventoryItemUiModel> inventoryItemUiModels;
    private ItemClickListener clickListener;

    public InventoryAdapter(Context context, List<InventoryItemUiModel> inventoryItemUiModel) {
        this.inventoryItemUiModels = inventoryItemUiModel;
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.inventory_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.setViewData(inventoryItemUiModels.get(position));
    }

    @Override
    public int getItemCount() {
        return inventoryItemUiModels.size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView inventoryDrugName;
        private final TextView inventorySubmitTime;
        private final TextView prescriptionText;
        private final TextView inventoryStatus;
        private InventoryItemUiModel inventoryItemUiModel;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            inventoryDrugName = (TextView) view.findViewById(R.id.inventory_drug_name);
            inventorySubmitTime = (TextView) view.findViewById(R.id.inventory_submit_time);
            prescriptionText = (TextView) view.findViewById(R.id.prescription_text);
            inventoryStatus = (TextView) view.findViewById(R.id.inventory_status);
        }

        public void setViewData(InventoryItemUiModel inventoryItemUiModel) {
            this.inventoryItemUiModel = inventoryItemUiModel;
            inventoryDrugName.setText(inventoryItemUiModel.getDrugName());
            inventorySubmitTime.setText(inventoryItemUiModel.getSubmittedTime());
            prescriptionText.setText(inventoryItemUiModel.getPrescription());
            inventoryStatus.setText(inventoryItemUiModel.getStatus());
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(v, getBindingAdapterPosition());
            }
        }
    }
}