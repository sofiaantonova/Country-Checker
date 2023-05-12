package com.example.countrychecker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countrychecker.model.Country;
import com.example.countrychecker.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<Country> countries;
    RecyclerAdapter(Context context, List<Country> countries, Listener listener){
        this.countries = countries;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }
    @Override
    public int getItemCount() {
        return countries.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.country_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        Country state = countries.get(position);
        holder.nameView.setText(state.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                listener.onClickMove(state);
            }
        });
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //final ImageView flagView;
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.countryName);
        }
    }
    private final Listener listener;
    public interface Listener{
        public void onClickMove(Country country);
    }
}
