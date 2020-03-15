package com.mehmet.merzigoandroidchallaeng.FrameLayouts;

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

import android.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.mehmet.merzigoandroidchallaeng.MainImageView.orgBitmap;
import static com.mehmet.merzigoandroidchallaeng.MainImageView.progress_circular;

public class BlackWhiteFrameLayout extends Fragment
{

    List<FilterCollectionModel> filterCollectionList = new ArrayList<>();
    RecyclerView blackwhite_recyclerview;
    FilterCollectionAdapter filterCollectionAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_blackwhite, container, false);

        blackwhite_recyclerview = view.findViewById(R.id.blackwhite_recyclerview);
        blackwhite_recyclerview.addItemDecoration(new DividerItemDecoration(MainImageView.Current, LinearLayoutManager.HORIZONTAL));
        filterCollectionAdapter = new FilterCollectionAdapter(filterCollectionList, MainImageView.Current);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainImageView.Current, LinearLayoutManager.HORIZONTAL, false);
        blackwhite_recyclerview.setLayoutManager(horizontalLayoutManager);
        blackwhite_recyclerview.setAdapter(filterCollectionAdapter);
        blackwhite_recyclerview.addItemDecoration(new DividerItemDecoration(MainImageView.Current, 0));

        BlackWhiteFilterLoader blackWhiteFilterLoader = new BlackWhiteFilterLoader();
        blackWhiteFilterLoader.execute();
        return view;
    }

    public class BlackWhiteFilterLoader extends AsyncTask<Void, Void, Void>
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
                        filterCollectionList.add(new FilterCollectionModel("Mono 01", new LUTHelper.ApplyFilterAsycTask(R.drawable.mono_01,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Mono 02", new LUTHelper.ApplyFilterAsycTask(R.drawable.mono_02,orgBitmap).execute().get()));
                        filterCollectionList.add(new FilterCollectionModel("Mono 03", new LUTHelper.ApplyFilterAsycTask(R.drawable.mono_03,orgBitmap).execute().get()));
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