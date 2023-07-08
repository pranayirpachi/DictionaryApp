package com.sahil.dictionaryapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sahil.dictionaryapp.Models.Meaning;
import com.sahil.dictionaryapp.R;
import com.sahil.dictionaryapp.ViewHolders.MeaningViewHolder;

import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningViewHolder> {
    private Context context;
    protected List<Meaning> meaningList;

    public MeaningAdapter(Context context, List<Meaning> meaningList) {
        this.context = context;
        this.meaningList = meaningList;
    }

    @NonNull
    @Override
    public MeaningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningViewHolder(LayoutInflater.from(context).inflate(R.layout.meaning_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningViewHolder holder, int position) {
        holder.partofspeach.setText("Parts of Speach" + meaningList.get(position).getPartOfSpeech());
        holder.recycler_definition.setHasFixedSize(true);
        holder.recycler_definition.setLayoutManager(new GridLayoutManager(context,1));


        DefinitionAdapter definitionAdapter = new DefinitionAdapter(context,meaningList.get(position).getDefinition());
        holder.recycler_definition.setAdapter(definitionAdapter);


    }

    @Override
    public int getItemCount() {
        return meaningList.size();
    }
}
