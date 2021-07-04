package com.mypharmacyprojectt.mypharmacy.ui.drugsrequests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mypharmacyprojectt.mypharmacy.R;
import com.mypharmacyprojectt.mypharmacy.ui.models.DrugsRequestsUiModel;

import java.util.List;

public class DrugsRequestsAdapter extends RecyclerView.Adapter<DrugsRequestsAdapter.ViewHolder> {

    private List<DrugsRequestsUiModel> drugsRequestsUiModels;
    private ItemClickListener clickListener;

    public DrugsRequestsAdapter(Context context, List<DrugsRequestsUiModel> drugsRequestsUiModels) {
        this.drugsRequestsUiModels = drugsRequestsUiModels;
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    void addDrugsRequests(List<DrugsRequestsUiModel> drugsRequestsUiModels) {
        this.drugsRequestsUiModels.addAll(drugsRequestsUiModels);
    }

    void clearDrugsRequests() {
        this.drugsRequestsUiModels.clear();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.druqsrequests_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.setViewData(drugsRequestsUiModels.get(position));
    }

    @Override
    public int getItemCount() {
        return drugsRequestsUiModels.size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView requestMessage;
        private final TextView userName;
        private final TextView userAddress;
        private final TextView prescriptionValue;
        private final TextView compensationValue;
        private final TextView requestStatus;
        private final LinearLayout acceptRejectContainer;
        private final Button acceptRequest;
        private final Button rejectRequest;
        private DrugsRequestsUiModel drugsRequestsUiModel;

        public ViewHolder(View view) {
            super(view);
            requestMessage = (TextView) view.findViewById(R.id.request_message);
            userName = (TextView) view.findViewById(R.id.user_name);
            userAddress = (TextView) view.findViewById(R.id.user_address);
            prescriptionValue = (TextView) view.findViewById(R.id.prescription_value);
            compensationValue = (TextView) view.findViewById(R.id.compensation_value);
            requestStatus = (TextView) view.findViewById(R.id.drugsrequest_status);
            acceptRejectContainer = (LinearLayout) view.findViewById(R.id.accept_reject_container);
            acceptRequest = (Button) view.findViewById(R.id.accept_drug_request);
            rejectRequest = (Button) view.findViewById(R.id.reject_drug_request);
            acceptRequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    requestStatus.setText("ACCEPTED");
                    acceptRejectContainer.setVisibility(View.GONE);
                }
            });
            rejectRequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    requestStatus.setText("REJECTED");
                    requestStatus.setTextColor(v.getResources().getColor(R.color.light_red));
                    acceptRejectContainer.setVisibility(View.GONE);
                }
            });
        }

        public void setViewData(DrugsRequestsUiModel drugsRequestsUiModel) {
            this.drugsRequestsUiModel = drugsRequestsUiModel;
            requestMessage.setText(drugsRequestsUiModel.getRequestMessage());
            userName.setText(drugsRequestsUiModel.getUserName());
            userAddress.setText(drugsRequestsUiModel.getUserLocation());
            prescriptionValue.setText(
                    String.valueOf(drugsRequestsUiModel.isPrescription()));
            compensationValue.setText(
                    String.valueOf(drugsRequestsUiModel.isCompensated()));
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}