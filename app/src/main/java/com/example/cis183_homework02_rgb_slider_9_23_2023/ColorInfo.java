package com.example.cis183_homework02_rgb_slider_9_23_2023;

public class ColorInfo
{

    private int red;
    private int green;
    private int blue;

    //constructor for class
    public ColorInfo(int red, int green, int blue)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    //getters
    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }
}
