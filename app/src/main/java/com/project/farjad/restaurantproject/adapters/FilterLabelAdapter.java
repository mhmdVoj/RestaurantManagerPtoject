package com.project.farjad.restaurantproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.farjad.restaurantproject.R;

import java.util.List;

public class FilterLabelAdapter extends RecyclerView.Adapter<FilterLabelAdapter.FilterLabelViewHolder> {
    List<String> stringList;

    public FilterLabelAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    @NonNull
    @Override
    public FilterLabelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FilterLabelViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_label_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FilterLabelViewHolder holder, int position) {
        holder.BindItems(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    class FilterLabelViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_label;
        public FilterLabelViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_label = itemView.findViewById(R.id.txt_filter_label);
        }

        public void  BindItems(String str){
            txt_label.setText(str);
        }
    }
}
