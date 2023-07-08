package com.sahil.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sahil.dictionaryapp.R;

public class DefinitionViewHolder extends RecyclerView.ViewHolder {
    public TextView textview_definition;
    public  TextView textview_example,textview_synonyms,textview_antonyms;

    public DefinitionViewHolder(@NonNull View itemView) {
        super(itemView);
        textview_definition = itemView.findViewById(R.id.textView_definitions);
        textview_example = itemView.findViewById(R.id.textView_example);
        textview_synonyms = itemView.findViewById(R.id.textView_synonyms);
        textview_antonyms = itemView.findViewById(R.id.textView_antonyms);

    }
}
