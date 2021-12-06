package com.example.viajaperu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viajaperu.net.AgencyEntry;
import com.example.viajaperu.net.ImageRequest;
import java.util.List;

/* retorna toda la data necesaria */
public class AgencyCardRecyclerView extends RecyclerView.Adapter<AgencyCardViewHolder> {
    private List<AgencyEntry> agencyEntryList;
    private ImageRequest imageRequest;

    AgencyCardRecyclerView(List<AgencyEntry> agencyEntryList){
        this.agencyEntryList = agencyEntryList;
        imageRequest = ImageRequest.getInstance();
    }

    @NonNull
    @Override
    public AgencyCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.agency_card, parent, false);
        return new AgencyCardViewHolder(view);
    }

    /* validamos la existencia de data de file json */
    @Override
    public void onBindViewHolder(@NonNull AgencyCardViewHolder holder, int position) {
        if(agencyEntryList != null && position < agencyEntryList.size()){
            AgencyEntry agencies = agencyEntryList.get(position);
            holder.agencyName.setText(agencies.name_agency);
            imageRequest.setImageFromUrl(holder.agencyImage, agencies.url);
        }
    }

    @Override
    public int getItemCount() {
        return agencyEntryList.size();
    }
}
