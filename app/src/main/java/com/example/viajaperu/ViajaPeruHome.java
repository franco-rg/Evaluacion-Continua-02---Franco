package com.example.viajaperu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;

public class ViajaPeruHome extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle bundle) {
            View view = inflater.inflate(R.layout.viajap_home, container, false);

            MaterialButton nextButton_toAgencies = view.findViewById(R.id.next_button_toAgencies);
            nextButton_toAgencies.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Navigation) getActivity()).navigateTo(new AgencyGrid(), true);
                }
            });

            MaterialButton nextButton_toSites = view.findViewById(R.id.next_button_toSites);
            nextButton_toSites.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Navigation) getActivity()).navigateTo(new ViajaPeru_sites(), true);
                }
            });
            return view;
    }
}