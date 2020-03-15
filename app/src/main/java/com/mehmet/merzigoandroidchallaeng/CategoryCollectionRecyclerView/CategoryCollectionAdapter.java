package com.mehmet.merzigoandroidchallaeng.CategoryCollectionRecyclerView;

import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mehmet.merzigoandroidchallaeng.Constant;
import com.mehmet.merzigoandroidchallaeng.MainImageView;
import com.mehmet.merzigoandroidchallaeng.R;

import java.util.List;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import static com.mehmet.merzigoandroidchallaeng.MainImageView.blackwhiteFragment;
import static com.mehmet.merzigoandroidchallaeng.MainImageView.colorFilterFragment;

public class CategoryCollectionAdapter extends RecyclerView.Adapter<CategoryCollectionAdapter.CategoryCollectionHolder>
{
    private List<CategoryCollectionModel> horizontalCategoryCollectionList;
    Context context;

    public CategoryCollectionAdapter(List<CategoryCollectionModel> horizontalList, Context context)
    {
        this.horizontalCategoryCollectionList= horizontalList;
        this.context = context;
    }

    @Override
    public CategoryCollectionHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_collection_list, parent, false);
        CategoryCollectionHolder gvh = new CategoryCollectionHolder(groceryProductView);
        return gvh;
    }

    int index = -1;
    @Override
    public void onBindViewHolder(final CategoryCollectionAdapter.CategoryCollectionHolder holder, final int position)
    {
        holder.txtview.setText(horizontalCategoryCollectionList.get(position).GetTitleName());
        holder.linearLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                index = position;
                notifyDataSetChanged();



                FragmentTransaction ft = MainImageView.Current.getFragmentManager().beginTransaction();
                switch (holder.txtview.getText().toString())
                {
                    case "Siyah & Beyaz":
                        Constant.selectredFilter = "Siyah & Beyaz";
                        ft.add(R.id.filteredimage_fragment, blackwhiteFragment);
                        break;

                    case "Renkler":
                        Constant.selectredFilter = "Renkler";
                        ft.add(R.id.filteredimage_fragment, colorFilterFragment);
                        break;
                }
                ft.commit();
            }
        });
        if(index==position)
        {
            holder.txtview.setTextColor(Color.BLACK);
        }
        else
        {
            holder.txtview.setTextColor(Color.parseColor("#969696"));
        }
    }

    @Override
    public int getItemCount()
    {
        return horizontalCategoryCollectionList.size();
    }

    public class CategoryCollectionHolder extends RecyclerView.ViewHolder
    {
        LinearLayout linearLayout;
        TextView txtview;
        public CategoryCollectionHolder(View view)
        {
            super(view);
            linearLayout = view.findViewById(R.id.linearLayout);
            txtview=view.findViewById(R.id.idProductName);
        }
    }
}