package com.example.apicountry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AsiaAdapter extends RecyclerView.Adapter<AsiaAdapter.AsiaViewHolder>{
    List<AsiaDetails> AsiaDetailsList;
    Context context;

    public AsiaAdapter(Context context,List<AsiaDetails> asiaDetailsList ) {
        this.context = context;
        AsiaDetailsList = asiaDetailsList;
    }

    @NonNull
    @Override
    public AsiaViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.countryshow,parent,false);
        return new AsiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsiaAdapter.AsiaViewHolder holder, int position) {
        String temp= "";
        AsiaDetails asiaDetails = AsiaDetailsList.get(position);
        holder.name.setText(asiaDetails.getName());
        holder.capital.setText(asiaDetails.getCapital());
        holder.region.setText(asiaDetails.getRegion());
        holder.subRegion.setText(asiaDetails.getSubregion());
        holder.population.setText(asiaDetails.getPopulation());
        holder.borders.setText(asiaDetails.getBorders().toString());

        for (int i=0;i<asiaDetails.getLanguages().length;i++){
            temp += asiaDetails.getLanguages()[i].getName() + "," ;
        }
        holder.languages.setText(asiaDetails.getFlag());
       // Picasso.with(context).load("https://static.india.com/wp-content/uploads/2019/07/sanjay-dutt-munna-bhai-3-main.jpg").placeholder(R.drawable.ic_launcher_background)
          //      .into(holder.flag);

        Utils.fetchSvg(context, asiaDetails.getFlag(), holder.flag);


    }

    @Override
    public int getItemCount() {
        return AsiaDetailsList.size();
    }

    public class AsiaViewHolder extends RecyclerView.ViewHolder{
        TextView name,capital,region,subRegion,population,borders,languages;
        ImageView flag;
        public AsiaViewHolder(@NonNull  View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            capital = itemView.findViewById(R.id.capital);
            region = itemView.findViewById(R.id.region);
            subRegion = itemView.findViewById(R.id.subRegion);
            population = itemView.findViewById(R.id.population);
            borders = itemView.findViewById(R.id.borders);
            languages = itemView.findViewById(R.id.languages);
            flag = itemView.findViewById(R.id.countryFlag);

        }
    }
}
