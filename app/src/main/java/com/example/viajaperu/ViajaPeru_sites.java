package com.example.viajaperu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class ViajaPeru_sites extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viajap_site1, container, false);

        MaterialButton nextButton_toSites2 = view.findViewById(R.id.next_site_2);
        nextButton_toSites2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Navigation) getActivity()).navigateTo(new ViajaPeru_sites_mp(), true);
            }
        });
        return view;
    }
}
