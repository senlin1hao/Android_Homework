package com.example.homework3;

public class App
{
    private String name;
    private int imageId;

    public App(String name, int imageId)
    {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getImageId()
    {
        return imageId;
    }

    public void setImageId(int imageId)
    {
        this.imageId = imageId;
    }
}
