package com.example.lavanda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PrAdapterHolder extends RecyclerView.Adapter<PrAdapterHolder.PrViewHolder> {

    private final LayoutInflater inflater;
    private Context context;
    private final List<PrAdapter> states;

    public PrAdapterHolder(LayoutInflater inflater,List<PrAdapter> states) {
        this.inflater = inflater;
        this.states = states;
    }


    @NonNull
    @Override
    public PrAdapterHolder.PrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_menu, parent, false);
        return new PrViewHolder(view, states);
    }

    @Override
    public void onBindViewHolder(@NonNull PrAdapterHolder.PrViewHolder holder, int position) {
        PrAdapter prAdapter = states.get(position);
        holder.nameView1.setText(prAdapter.getName(0));
        holder.nameView3.setText(prAdapter.getName(2));
        holder.nameView2.setText(prAdapter.getName(1));

        holder.priceView1.setText(prAdapter.getPrice(0));
        holder.priceView2.setText(prAdapter.getPrice(1));
        holder.priceView3.setText(prAdapter.getPrice(2));


        String img_res1 = states.get(position).getImageViews(0);
        String img_res2 = states.get(position).getImageViews(0);
        String img_res3 = states.get(position).getImageViews(0);
        int img1 = context.getResources().getIdentifier(img_res1,"drawable",context.getPackageName());
        int img2 = context.getResources().getIdentifier(img_res2,"drawable",context.getPackageName());
        int img3 = context.getResources().getIdentifier(img_res3,"drawable",context.getPackageName());
        holder.imageView1.setImageResource(img1);
        holder.imageView1.setImageResource(img2);
        holder.imageView1.setImageResource(img3);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class PrViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView1, priceView1,nameView2, priceView2,nameView3, priceView3;
        final ImageView imageView1,imageView2,imageView3;
        private final List<PrAdapter> listNotes;

        PrViewHolder(View view, List<PrAdapter> listNotes) {
            super(view);
            nameView1 = (TextView) view.findViewById(R.id.name1);
            nameView2 = (TextView) view.findViewById(R.id.name2);
            nameView3 = (TextView) view.findViewById(R.id.name3);

            priceView1 = (TextView) view.findViewById(R.id.price1);
            priceView2 = (TextView) view.findViewById(R.id.price2);
            priceView3 = (TextView) view.findViewById(R.id.price3);

            imageView1 = (ImageView)view.findViewById(R.id.image1);
            imageView2 = (ImageView)view.findViewById(R.id.image2);
            imageView3 = (ImageView)view.findViewById(R.id.image3);

            this.listNotes = listNotes;

        }


    }
}
