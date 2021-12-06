package com.example.viajaperu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.viajaperu.net.AgencyEntry;

public class AgencyGrid extends Fragment {

    @Override
    public View onCreateView(
            @NonNull
                    LayoutInflater inflater, ViewGroup container, Bundle bundle) {
            View view = inflater.inflate(R.layout.agency_grid, container, false);
            RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true); /* se ajusta a la pantalla del dispositivo */
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));

            AgencyCardRecyclerView agencyCardRecyclerView =  new AgencyCardRecyclerView(AgencyEntry.agencyDataList(getResources()));
            recyclerView.setAdapter(agencyCardRecyclerView);

            int largePadding = getResources().getDimensionPixelSize(R.dimen.agency_grid_spacing);
            int smallPadding = getResources().getDimensionPixelSize(R.dimen.agency_grid_spacing_small);
            recyclerView.addItemDecoration(new AgencyBackGrid(largePadding, smallPadding));
            return view;
    }
}