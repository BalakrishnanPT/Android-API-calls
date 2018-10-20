package com.example.bala.servicecallsbasics;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageViewingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewing);
        ServiceClass.setImageToImageView(this, "https://assets.nfnlabs.design/wallpapers/inch_4_7/GradientMasks2.png", (ImageView) findViewById(R.id.iva_iv));
        ServiceClass.makeRequest(this, "http://www.google.com", new ServiceClass.CustomParse() {
            @Override
            public void doCustomParsing(String response) {
                Toast.makeText(ImageViewingActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void toNextActivity(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }
}
