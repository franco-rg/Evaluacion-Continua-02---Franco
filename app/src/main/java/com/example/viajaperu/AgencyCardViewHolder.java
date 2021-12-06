package com.example.viajaperu;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.toolbox.NetworkImageView;

public class AgencyCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView agencyImage;
    public TextView agencyName;

    public AgencyCardViewHolder(@NonNull View itemView) {
        super(itemView);
        this.agencyImage = itemView.findViewById(R.id.agency_image);
        this.agencyName = itemView.findViewById(R.id.agency_name);
    }
}