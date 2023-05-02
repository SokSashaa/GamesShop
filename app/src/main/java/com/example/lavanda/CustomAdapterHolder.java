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
    private final List<CustomAdapter[]> states;

    public CustomAdapterHolder(Context context, List<CustomAdapter[]> states) {
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

        CustomAdapter[] customAdapters =states.get(position);
        for(int i = 0;i<customAdapters.length;i++)
        {
            holder.names[i].setText(customAdapters[i].getNames());
            holder.price[i].setText(customAdapters[i].getPrice());
            String img_res = customAdapters[i].getImageViews();
            int imgIndex = context.getResources().getIdentifier(img_res,"drawable",context.getPackageName());
            holder.img[i].setImageResource(imgIndex);
            holder.img[i].setTag(position);
        }


      /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = holder.tag;
                Intent intent = new Intent(context,product_item.class);
                //intent.putExtra("name",states.get(position).getName(0));
                //intent.putExtra("price",states.get(position).getPrice(0));
                //intent.putExtra("img",img1);
                context.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class PrViewHolder extends RecyclerView.ViewHolder {
        TextView nameView1, priceView1,nameView2, priceView2,nameView3, priceView3;
        ImageView imageView1,imageView2,imageView3;
        private final TextView[] names;// = new TextView[] {nameView1,nameView2,nameView3};
        private final TextView[] price;// = new TextView[] {priceView1,priceView2,priceView3};

        private final ImageView[] img;
        private  final int [] tags;// = new ImageView[] {imageView1,imageView2,imageView3};

        private final List<CustomAdapter[]> listNotes;

        PrViewHolder(View view, List<CustomAdapter[]> listNotes) {
            super(view);

            nameView1 = (TextView) view.findViewById(R.id.name1);
            nameView2 = (TextView) view.findViewById(R.id.name2);
            nameView3 = (TextView) view.findViewById(R.id.name3);
            names = new TextView[]{nameView1,nameView2,nameView3};
            priceView1 = (TextView) view.findViewById(R.id.price1);
            priceView2 = (TextView) view.findViewById(R.id.price2);
            priceView3 = (TextView) view.findViewById(R.id.price3);
            price = new TextView[] {priceView1,priceView2,priceView3};
            imageView1 = (ImageView)view.findViewById(R.id.image1);
            imageView2 = (ImageView)view.findViewById(R.id.image2);
            imageView3 = (ImageView)view.findViewById(R.id.image3);
            img = new ImageView[] {imageView1,imageView2,imageView3};
            tags = new int[]{-1,-1,-1};

            this.listNotes = listNotes;

        }



    }
}
