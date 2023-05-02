package com.example.lavanda;

import android.graphics.ImageDecoder;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class product_item extends AppCompatActivity {

    ImageButton exit;
    TextView name;
    TextView price;
    AppCompatImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.product);
        Window window = getWindow();
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        exit = (ImageButton) findViewById(R.id.exit_button);
        name = (TextView)findViewById(R.id.name_product);
        price = (TextView)findViewById(R.id.price_product);
        img = (AppCompatImageView) findViewById(R.id.img_product);

        String n = getIntent().getStringExtra("name");
        String p = getIntent().getStringExtra("price");
        String i = getIntent().getStringExtra("img");

        name.setText(n);
        price.setText(p);
        int imgIndex = getResources().getIdentifier(i,"drawable",getPackageName());
        img.setImageResource(imgIndex);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
