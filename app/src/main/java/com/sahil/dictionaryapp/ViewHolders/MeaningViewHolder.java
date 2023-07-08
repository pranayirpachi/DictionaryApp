package com.sahil.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sahil.dictionaryapp.R;

public class MeaningViewHolder extends RecyclerView.ViewHolder {
    public TextView partofspeach;
    public RecyclerView recycler_definition;
    public MeaningViewHolder(@NonNull View itemView) {
        super(itemView);
        partofspeach = itemView.findViewById(R.id.partofspeach);
        recycler_definition = itemView.findViewById(R.id.recycler_definition);
    }
}
