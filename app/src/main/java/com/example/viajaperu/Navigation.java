package com.example.viajaperu;
import androidx.fragment.app.Fragment;

public  interface Navigation {
    void navigateTo(Fragment fragment, boolean addToBack);
}