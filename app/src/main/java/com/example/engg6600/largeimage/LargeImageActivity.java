package com.example.engg6600.largeimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class LargeImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_image);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Display display = getWindowManager().getDefaultDisplay();
        int displayWidth = display.getWidth();
        int displayHeight= display.getHeight();

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.largeimage2,options);
        int width = options.outWidth;
        int height = options.outHeight;
        if (width > displayWidth) {
            int widthRatio = Math.round((float) width / (float) displayWidth);
            options.inSampleSize = widthRatio;
        }
        if (height > displayHeight) {
            int widthRatio = Math.round((float) width / (float) displayWidth);
            options.inSampleSize = widthRatio;
        }
        options.inJustDecodeBounds = false;
        Bitmap scaledBitmap =  BitmapFactory.decodeResource(getResources(), R.drawable.largeimage2, options);
        imageView.setImageBitmap(scaledBitmap);
    }
}
