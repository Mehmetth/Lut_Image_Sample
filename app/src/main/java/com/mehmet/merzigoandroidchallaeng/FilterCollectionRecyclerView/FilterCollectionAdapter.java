package com.mehmet.merzigoandroidchallaeng.FilterCollectionRecyclerView;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mehmet.merzigoandroidchallaeng.MainImageView;
import com.mehmet.merzigoandroidchallaeng.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class FilterCollectionAdapter  extends RecyclerView.Adapter<FilterCollectionAdapter.FilterCollectionHolder>
{
    private List<FilterCollectionModel> horizontalCategoryCollectionList;
    Context context;

    public FilterCollectionAdapter(List<FilterCollectionModel> horizontalList, Context context)
    {
        this.horizontalCategoryCollectionList= horizontalList;
        this.context = context;
    }

    @Override
    public FilterCollectionHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_collection_list, parent, false);
        FilterCollectionHolder gvh = new FilterCollectionHolder(groceryProductView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(FilterCollectionAdapter.FilterCollectionHolder holder, final int position)
    {
        holder.txtview.setText(horizontalCategoryCollectionList.get(position).GetFilterName());
        holder.imageView.setImageBitmap(horizontalCategoryCollectionList.get(position).GetFilteredImage());
        holder.imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MainImageView.show_imageview.setImageBitmap(horizontalCategoryCollectionList.get(position).GetFilteredImage());
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return horizontalCategoryCollectionList.size();
    }

    public class FilterCollectionHolder extends RecyclerView.ViewHolder
    {
        TextView txtview;
        ImageView imageView;
        public FilterCollectionHolder(View view)
        {
            super(view);
            txtview = view.findViewById(R.id.filtername_textview);
            imageView = view.findViewById(R.id.filtered_imageview);
        }
    }
}