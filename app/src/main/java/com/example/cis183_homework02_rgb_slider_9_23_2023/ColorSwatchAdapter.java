package com.example.cis183_homework02_rgb_slider_9_23_2023;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorSwatchAdapter extends BaseAdapter {

    Context context;
    ArrayList<ColorInfo> ColorInfo;
    public ColorSwatchAdapter(Context c, ArrayList<ColorInfo> cI)
    {
        //passed from mainactivity
        context = c;
        ColorInfo = cI;
    }
    @Override
    public int getCount()
    {
        return ColorInfo.size();
    }

    @Override
    public Object getItem(int i)
    {
        return ColorInfo.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_cell, null);
            TextView redColor = convertView.findViewById(R.id.tv_u_customCell_one);
            TextView greenColor = convertView.findViewById(R.id.tv_u_customCell_two);
            TextView blueColor = convertView.findViewById(R.id.tv_u_customCell_three);
            TextView hexColor = convertView.findViewById(R.id.tv_u_customCell_four);

            ColorInfo colorInfo = ColorInfo.get(i);

            redColor.setText(colorInfo.getResultRed());
            greenColor.setText(colorInfo.getResultGreen());
            blueColor.setText(colorInfo.getResultBlue());
            hexColor.setText(colorInfo.getResultHex());
        }
        return null;
    }
}
