package com.mehmet.merzigoandroidchallaeng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.mehmet.merzigoandroidchallaeng.UI.UIHelper;

public class SplashActivity extends AppCompatActivity
{
    ImageView merzigo_imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        merzigo_imageview = findViewById(R.id.merzigo_imageview);

        UIHelper.CenterScaleAnimation(merzigo_imageview,true);
        UIHelper.CenterScaleAnimation(merzigo_imageview,false);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 1500);
    }
}