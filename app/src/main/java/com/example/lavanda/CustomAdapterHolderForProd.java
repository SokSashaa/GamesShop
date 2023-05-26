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

public class CustomAdapterHolderForProd extends RecyclerView.Adapter<CustomAdapterHolderForProd.PrViewHolder> {

    private Context context;
    private final List<CustomAdapter> states;

    public CustomAdapterHolderForProd(Context context, List<CustomAdapter> states) {
        this.context = context;
        this.states = states;
    }


    @NonNull
    @Override
    public CustomAdapterHolderForProd.PrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.prod_list, parent, false);
        return new PrViewHolder(view, states);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterHolderForProd.PrViewHolder holder, int position) {

        CustomAdapter customAdapters =states.get(position);

        String name = customAdapters.getNames();
        holder.nameView1.setText(name);


        String img_res = customAdapters.getImageViews();
        int imgIndex = context.getResources().getIdentifier(img_res,"drawable",context.getPackageName());
        holder.imageView1.setImageResource(imgIndex);
        holder.imageView1.setTag(position);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,product_item.class);
                intent.putExtra("name",name);
                intent.putExtra("price",customAdapters.getPrice());
                intent.putExtra("img",img_res);
                context.startActivity(intent);
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

        private final List<CustomAdapter> listNotes;

        PrViewHolder(View view, List<CustomAdapter> listNotes) {
            super(view);

            nameView1 = (TextView) view.findViewById(R.id.textView9);
            imageView1 = (ImageView)view.findViewById(R.id.imageView6);

            this.listNotes = listNotes;

        }



    }
}
