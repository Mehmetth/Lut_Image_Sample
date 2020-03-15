package com.mehmet.merzigoandroidchallaeng.FilterCollectionRecyclerView;

import android.graphics.Bitmap;
import android.os.AsyncTask;

public class FilterCollectionModel
{
    public String filterName;
    public Bitmap filteredImage;

    public FilterCollectionModel(String _filterName,Bitmap _filteredImage)
    {
        this.filterName = _filterName;
        this.filteredImage = _filteredImage;
    }

    public String GetFilterName()
    {
        return filterName;
    }

    public void SetFiltereName(String _filterName)
    {
        this.filterName = _filterName;
    }

    public Bitmap GetFilteredImage()
    {
        return filteredImage;
    }

    public void SetFilteredImage(Bitmap _filteredImage)
    {
        this.filteredImage = _filteredImage;
    }
}