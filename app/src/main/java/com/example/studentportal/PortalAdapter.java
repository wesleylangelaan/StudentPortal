package com.example.studentportal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PortalAdapter extends RecyclerView.Adapter<PortalViewHolder> {

    private Context context;
    public List<Portals> listObjects;

    public PortalAdapter(Context context, List<Portals> listObjects) {
        this.context = context;
        this.listObjects = listObjects;
    }

    @NonNull
    @Override
    public PortalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new PortalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortalViewHolder portalViewHolder, int i) {
        final Portals Objects = listObjects.get(i);
        //PortalViewHolder.image.setImageResource(Objects.getmGeoImageName());
        portalViewHolder.portalItem.setText(Objects.getName());
    }

    @Override
    public int getItemCount() {
        // note voor volgende keer. Vergeet dit niet:
        return listObjects.size();
    }
}
