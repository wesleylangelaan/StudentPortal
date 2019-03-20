package com.example.studentportal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PortalViewHolder extends RecyclerView.ViewHolder {
    public TextView portalItem;
    //public TextView portalLink;
    public View view;


    public PortalViewHolder(@NonNull View itemView) {
        super(itemView);
        portalItem = itemView.findViewById(R.id.portalItem);
        view = itemView;
    }
}
