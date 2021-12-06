package com.example.viajaperu;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class AgencyBackGrid extends RecyclerView.ItemDecoration {
    private int largePadding;
    private int smallPadding;

    public AgencyBackGrid(int largePadding, int smallPadding) {
        this.largePadding = largePadding;
        this.smallPadding = smallPadding;
    }

    @Override
    public void getItemOffsets(Rect rect, View view, RecyclerView parent, RecyclerView.State state){
        rect.left = smallPadding;
        rect.right = smallPadding;

        rect.top = largePadding;
        rect.bottom = largePadding;
    }
}
