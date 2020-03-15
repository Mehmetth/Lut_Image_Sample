package com.mehmet.merzigoandroidchallaeng;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mehmet.merzigoandroidchallaeng.File.FileOperations;

import java.net.URISyntaxException;
import java.util.Objects;

import static com.mehmet.merzigoandroidchallaeng.File.FileOperations.getMimeType;

public class MainActivity extends AppCompatActivity
{
    public static Activity Current;
    private static final int PICKIMAGE_RESULT_CODE = 1;

    TextView select_galery_textview;
    TextView selectcamera_textview;
    String imageName = "";
    String imageType = "";
    Integer imageSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.Current = this;

        select_galery_textview = findViewById(R.id.select_galery_textview);
        select_galery_textview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                OpenGallery();
            }
        });
        selectcamera_textview = findViewById(R.id.selectcamera_textview);
        selectcamera_textview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this, MainImageView.class));
            }
        });
    }

    private void OpenGallery()
    {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto ,PICKIMAGE_RESULT_CODE );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICKIMAGE_RESULT_CODE)
        {
            System.out.println("image ::: "+ getMimeType(Objects.requireNonNull(data.getData()).getPath()));

            try
            {
                Constant.imagePath = FileOperations.getPath(MainActivity.Current, data.getData());
                Constant.imageName = FileOperations.GetFileName(MainActivity.Current,data.getData());

                System.out.println("image Path: " + Constant.imagePath);
                System.out.println("image Name: " + Constant.imageName);

                if(Constant.imagePath != null)
                {
                    startActivity(new Intent(MainActivity.this, MainImageView.class));
                }
            }
            catch (URISyntaxException e)
            {
                e.printStackTrace();
            }
        }
    }
}