package com.mehmet.merzigoandroidchallaeng.CategoryCollectionRecyclerView;

public class CategoryCollectionModel
{
    public String titleName;

    public CategoryCollectionModel(String _titleName)
    {
        this.titleName = _titleName;
    }

    public String GetTitleName()
    {
        return titleName;
    }

    public void SetTitleName(String _titleName)
    {
        this.titleName = _titleName;
    }
}