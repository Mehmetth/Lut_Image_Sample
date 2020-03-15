package com.mehmet.merzigoandroidchallaeng.LUT;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.AsyncTask;

import com.mehmet.merzigoandroidchallaeng.MainImageView;

import hu.don.easylut.EasyLUT;
import hu.don.easylut.filter.Filter;

public class LUTHelper
{
    public static class ApplyFilterAsycTask extends AsyncTask<Void, Void, Bitmap>
    {
        int intValue;
        Bitmap originalImage;

        public ApplyFilterAsycTask(int _lutImage,Bitmap _originalImage)
        {
            this.intValue = _lutImage;
            this.originalImage = _originalImage;
        }

        @Override
        protected Bitmap doInBackground(Void... params)
        {
            Resources resources = MainImageView.Current.getResources();
            Filter filter = EasyLUT.fromResourceId()
                    .withResources(resources)
                    .withLutBitmapId(intValue)
                    .createFilter();
            return filter.apply(originalImage);
        }
    }
}