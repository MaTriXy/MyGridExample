package com.elkriefy.apps.android.mygridexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SampleViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView position;

    public SampleViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        position = (TextView) itemView.findViewById(R.id.position);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Position = " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
    }
}