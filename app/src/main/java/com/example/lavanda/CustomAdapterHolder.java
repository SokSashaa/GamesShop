package com.example.lavanda;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapterHolder extends RecyclerView.Adapter<CustomAdapterHolder.PrViewHolder> {

    private Context context;
    private final List<CustomAdapterForCat> states;

    public CustomAdapterHolder(Context context, List<CustomAdapterForCat> states) {
        this.context = context;
        this.states = states;
    }


    @NonNull
    @Override
    public CustomAdapterHolder.PrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_menu, parent, false);
        return new PrViewHolder(view, states);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterHolder.PrViewHolder holder, int position) {

        CustomAdapterForCat customAdapters =states.get(position);

        String name = customAdapters.getNames();
        holder.nameView1.setText(name);


        String img_res = customAdapters.getImageViews();
        int imgIndex = context.getResources().getIdentifier(img_res,"drawable",context.getPackageName());
        holder.imageView1.setImageResource(imgIndex);
        holder.imageView1.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,podcategories.class).putExtra("index",customAdapters.getIndex()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class PrViewHolder extends RecyclerView.ViewHolder {
       private TextView nameView1;
        private ImageView imageView1;

        private final List<CustomAdapterForCat> listNotes;

        PrViewHolder(View view, List<CustomAdapterForCat> listNotes) {
            super(view);

            nameView1 = (TextView) view.findViewById(R.id.textView7);
            imageView1 = (ImageView)view.findViewById(R.id.imageView);

            this.listNotes = listNotes;

        }



    }
}
