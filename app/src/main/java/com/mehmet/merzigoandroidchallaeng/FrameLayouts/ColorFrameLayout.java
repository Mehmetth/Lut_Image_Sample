package com.mehmet.merzigoandroidchallaeng.FrameLayouts;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mehmet.merzigoandroidchallaeng.FilterCollectionRecyclerView.FilterCollectionAdapter;
import com.mehmet.merzigoandroidchallaeng.FilterCollectionRecyclerView.FilterCollectionModel;
import com.mehmet.merzigoandroidchallaeng.LUT.LUTHelper;
import com.mehmet.merzigoandroidchallaeng.MainImageView;
import com.mehmet.merzigoandroidchallaeng.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.mehmet.merzigoandroidchallaeng.MainImageView.orgBitmap;
import static com.mehmet.merzigoandroidchallaeng.MainImageView.progress_circular;

public class ColorFrameLayout  extends Fragment
{
    List<FilterCollectionModel> filterCollectionList = new ArrayList<>();
    RecyclerView colorfilter_recyclerview;
    FilterCollectionAdapter filterCollectionAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View controlView = inflater.inflate(R.layout.fragment_colorfilter, container, false);
        colorfilter_recyclerview = controlView.findViewById(R.id.colorfilter_recyclerview);
        colorfilter_recyclerview.addItemDecoration(new DividerItemDecoration(MainImageView.Current, LinearLayoutManager.HORIZONTAL));
        filterCollectionAdapter = new FilterCollectionAdapter(filterCollectionList, MainImageView.Current);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainImageView.Current, LinearLayoutManager.HORIZONTAL, false);
        colorfilter_recyclerview.setLayoutManager(horizontalLayoutManager);
        colorfilter_recyclerview.setAdapter(filterCollectionAdapter);
        colorfilter_recyclerview.addItemDecoration(new DividerItemDecoration(MainImageView.Current, 0));

        ColorFrameLayout.ColorFilterLoader colorFilterLoader = new ColorFrameLayout.ColorFilterLoader();
        colorFilterLoader.execute();
        return controlView;
    }
    public class ColorFilterLoader extends AsyncTask<Void, Void, Void>
    {

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progress_circular.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            MainImageView.Current.runOnUiThread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        filterCollectionList.clear();
                        filterCollectionAdapter.notifyDataSetChanged();
                        filterCollectionList.add(new FilterCollectionModel("Filmic 01", new LUTHelper.ApplyFilterAsycTask(R.drawable.filmic_01,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Filmic 02",new LUTHelper.ApplyFilterAsycTask(R.drawable.filmic_02,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Filmic 03",new LUTHelper.ApplyFilterAsycTask(R.drawable.filmic_03,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Filmic 04",new LUTHelper.ApplyFilterAsycTask(R.drawable.filmic_04,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Filmic 05",new LUTHelper.ApplyFilterAsycTask(R.drawable.filmic_05,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Filmic 06",new LUTHelper.ApplyFilterAsycTask(R.drawable.filmic_06,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Filmic 07",new LUTHelper.ApplyFilterAsycTask(R.drawable.filmic_07,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Filmic 08",new LUTHelper.ApplyFilterAsycTask(R.drawable.filmic_08,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Filmic 09",new LUTHelper.ApplyFilterAsycTask(R.drawable.filmic_09,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Filmic 10",new LUTHelper.ApplyFilterAsycTask(R.drawable.filmic_10,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Mono Green 01",new LUTHelper.ApplyFilterAsycTask(R.drawable.mono_green_01,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Mono Green 02",new LUTHelper.ApplyFilterAsycTask(R.drawable.mono_green_02,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Mono Green 03",new LUTHelper.ApplyFilterAsycTask(R.drawable.mono_green_03,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Orange Blue 01",new LUTHelper.ApplyFilterAsycTask(R.drawable.orange_blue_01,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Orange Blue 02",new LUTHelper.ApplyFilterAsycTask(R.drawable.orange_blue_02,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Orange Blue 03",new LUTHelper.ApplyFilterAsycTask(R.drawable.orange_blue_03,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Orange Blue Neo 01",new LUTHelper.ApplyFilterAsycTask(R.drawable.orange_blue_neo_01,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Orange Blue Neo 02",new LUTHelper.ApplyFilterAsycTask(R.drawable.orange_blue_neo_02,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Orange Blue Neo 03",new LUTHelper.ApplyFilterAsycTask(R.drawable.orange_blue_neo_03,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Simple 01",new LUTHelper.ApplyFilterAsycTask(R.drawable.simple_01,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Simple 02",new LUTHelper.ApplyFilterAsycTask(R.drawable.simple_02,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Simple 03",new LUTHelper.ApplyFilterAsycTask(R.drawable.simple_03,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Spectrum 01",new LUTHelper.ApplyFilterAsycTask(R.drawable.spectrum_01,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Spectrum 02",new LUTHelper.ApplyFilterAsycTask(R.drawable.spectrum_02,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Spectrum 03",new LUTHelper.ApplyFilterAsycTask(R.drawable.spectrum_03,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Virtual 01",new LUTHelper.ApplyFilterAsycTask(R.drawable.virtual_01,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Virtual 02",new LUTHelper.ApplyFilterAsycTask(R.drawable.virtual_02,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Virtual 03",new LUTHelper.ApplyFilterAsycTask(R.drawable.virtual_03,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Web 02",new LUTHelper.ApplyFilterAsycTask(R.drawable.web_01,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Web 02",new LUTHelper.ApplyFilterAsycTask(R.drawable.web_01,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Web 03",new LUTHelper.ApplyFilterAsycTask(R.drawable.web_01,orgBitmap).execute().get()));
                        filterCollectionAdapter.notifyDataSetChanged();
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Exception ex: " + ex.getMessage());
                    }
                }
            });

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            progress_circular.setVisibility(View.GONE);
        }
    }
}