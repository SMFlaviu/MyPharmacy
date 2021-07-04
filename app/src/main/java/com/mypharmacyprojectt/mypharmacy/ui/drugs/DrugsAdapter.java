package com.mypharmacyprojectt.mypharmacy.ui.drugs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mypharmacyprojectt.mypharmacy.R;
import com.mypharmacyprojectt.mypharmacy.data.model.Drugs;

import java.util.ArrayList;
import java.util.List;

public class DrugsAdapter extends RecyclerView.Adapter<DrugsAdapter.ViewHolder> {

    private List<Drugs> drugs = new ArrayList<>();
    private ItemClickListener clickListener;

    public DrugsAdapter(Context context, List<Drugs> drugs) {
        this.drugs = drugs;
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public void setDrugs(List<Drugs> drugs) {
        this.drugs.addAll(drugs);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.drugs_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.setViewData(drugs.get(position));
    }

    @Override
    public int getItemCount() {
        return drugs.size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView drugName;
        private final TextView drugForm;
        private final TextView drugConc;
        private final TextView drugAction;
        private final TextView drugPrescription;
        private final TextView drugVolume;
        private final TextView drugValability;
        private final TextView drugAtc;
        private Drugs drugs;

        public ViewHolder(View view) {
            super(view);
            drugName = (TextView) view.findViewById(R.id.drug_name);
            drugForm = (TextView) view.findViewById(R.id.drug_formafarm);
            drugConc = (TextView) view.findViewById(R.id.drug_concentration);
            drugAction = (TextView) view.findViewById(R.id.drug_action);
            drugPrescription = (TextView) view.findViewById(R.id.drug_prescription);
            drugVolume = (TextView) view.findViewById(R.id.drug_volume);
            drugValability = (TextView) view.findViewById(R.id.drug_valability);
            drugAtc = (TextView) view.findViewById(R.id.drug_atc);
        }

        public void setViewData(Drugs drugs) {
            this.drugs = drugs;
            drugName.setText(drugs.getDenCom());
            drugForm.setText(drugs.getFormaFarm());
            drugConc.setText(drugs.getConcentratie());
            drugAction.setText(drugs.getActiuneTerapeutica());
            drugPrescription.setText(drugs.getPrescriptie());
            drugVolume.setText(drugs.getVolumAmbalaj());
            drugValability.setText(drugs.getValabilitateAmbalaj());
            drugAtc.setText(drugs.getCodAtc());
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(v, getBindingAdapterPosition());
            }
        }
    }
}
