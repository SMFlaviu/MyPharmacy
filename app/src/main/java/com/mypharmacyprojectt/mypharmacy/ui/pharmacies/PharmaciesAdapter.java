package com.mypharmacyprojectt.mypharmacy.ui.pharmacies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mypharmacyprojectt.mypharmacy.R;
import com.mypharmacyprojectt.mypharmacy.data.model.Pharmacies;
import com.mypharmacyprojectt.mypharmacy.utils.Utils;

import java.util.List;

public class PharmaciesAdapter extends RecyclerView.Adapter<PharmaciesAdapter.ViewHolder> {

    private List<Pharmacies> pharmacies;
    private ItemClickListener clickListener;


    public PharmaciesAdapter(Context context, List<Pharmacies> pharmacies) {
        this.pharmacies = pharmacies;
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public void addPharmacies(List<Pharmacies> pharmacies) {
        this.pharmacies.addAll(pharmacies);
    }

    public void clearPharmacies() {
        this.pharmacies.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pharmacies_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.setViewData(pharmacies.get(position));
    }

    @Override
    public int getItemCount() {
        return pharmacies.size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView pharmacyName;
        private final TextView pharmacyLocation;
        private Pharmacies pharmacy;

        public ViewHolder(View view) {
            super(view);
            pharmacyName = (TextView) view.findViewById(R.id.pharmacy_name);
            pharmacyLocation = (TextView) view.findViewById(R.id.pharmacy_location);
        }

        public void setViewData(Pharmacies pharmacy) {
            this.pharmacy = pharmacy;
            pharmacyName.setText(
                    Utils.ellipsize(this.pharmacy.getName(), 30));
            pharmacyLocation.setText(
                    Utils.ellipsize(this.pharmacy.getLocation(), 100));
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(v, getAbsoluteAdapterPosition());
            }
        }
    }
}