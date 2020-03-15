package com.mehmet.merzigoandroidchallaeng;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mehmet.merzigoandroidchallaeng.CategoryCollectionRecyclerView.CategoryCollectionAdapter;
import com.mehmet.merzigoandroidchallaeng.CategoryCollectionRecyclerView.CategoryCollectionModel;
import com.mehmet.merzigoandroidchallaeng.File.FileOperations;
import com.mehmet.merzigoandroidchallaeng.FrameLayouts.BlackWhiteFrameLayout;
import com.mehmet.merzigoandroidchallaeng.FrameLayouts.ColorFrameLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainImageView extends AppCompatActivity
{
    public static ImageView show_imageview;

    ImageButton download_imagebutton;
    ImageButton delete_imagebutton;

    public static Bitmap orgBitmap;

    public static Activity Current;

    public static List<CategoryCollectionModel> categoryCollectionList = new ArrayList<>();
    public static RecyclerView filtertitle_recyclerview;
    public static CategoryCollectionAdapter categoryCollectionAdapter;

    public static Fragment blackwhiteFragment;
    public static Fragment colorFilterFragment;

    public static ProgressBar progress_circular;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainimageview);

        MainImageView.Current = this;

        show_imageview = findViewById(R.id.show_imageview);
        progress_circular = findViewById(R.id.progress_circular);

        File imgFile = new File(Constant.imagePath);

        if(imgFile.exists())
        {
            try
            {
                orgBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                orgBitmap = FileOperations.modifyOrientation(orgBitmap,imgFile.getAbsolutePath());
                show_imageview.setImageBitmap(orgBitmap);
            }
            catch (Exception ex)
            {

            }
        }

        download_imagebutton = findViewById(R.id.download_imagebutton);
        download_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                SaveImageFile(orgBitmap);
            }
        });
        delete_imagebutton = findViewById(R.id.delete_imagebutton);
        delete_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                show_imageview.setImageBitmap(null);
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        finish();
                    }
                }, 1000);
            }
        });
        filtertitle_recyclerview = findViewById(R.id.filterlist_recyclerview);
        filtertitle_recyclerview.addItemDecoration(new DividerItemDecoration(MainImageView.this, LinearLayoutManager.HORIZONTAL));
        categoryCollectionAdapter = new CategoryCollectionAdapter(categoryCollectionList, getApplicationContext());
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainImageView.this, LinearLayoutManager.HORIZONTAL, false);
        filtertitle_recyclerview.setLayoutManager(horizontalLayoutManager);
        filtertitle_recyclerview.setAdapter(categoryCollectionAdapter);
        filtertitle_recyclerview.addItemDecoration(new DividerItemDecoration(MainImageView.this, 0));
        FillTheCategoryCollectionList();

        blackwhiteFragment = new BlackWhiteFrameLayout();
        colorFilterFragment = new ColorFrameLayout();
    }
    private void FillTheCategoryCollectionList()
    {
        CategoryCollectionModel potato = new CategoryCollectionModel("Renkler");
        CategoryCollectionModel onion = new CategoryCollectionModel("Trendler");
        CategoryCollectionModel cabbage = new CategoryCollectionModel("Son Kullanılanlar");
        CategoryCollectionModel cauliflower = new CategoryCollectionModel("Siyah & Beyaz");
        categoryCollectionList.add(potato);
        categoryCollectionList.add(onion);
        categoryCollectionList.add(cabbage);
        categoryCollectionList.add(cauliflower);
        categoryCollectionAdapter.notifyDataSetChanged();
    }

    String ImagePath;
    public void SaveImageFile(Bitmap bitmap)
    {
        try
        {
            ImagePath = MediaStore.Images.Media.insertImage(
                    getContentResolver(),
                    bitmap,
                    "demo_image",
                    "demo_image"
            );

            Toast.makeText(MainImageView.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex)
        {
         Toast.makeText(MainActivity.Current,"" + ex.toString(),Toast.LENGTH_LONG).show();
        }
    }
}
