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
//creating the adapter
public class ColorSwatchAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ColorInfo> colorInfos;

    //Constructor for what is in the array
    public ColorSwatchAdapter(Context context, ArrayList<ColorInfo> colorInfos)
    {
        this.context = context;
        this.colorInfos = colorInfos;
    }

    @Override
    public int getCount() {
        return colorInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return colorInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_cell, null);
        }
        //populating the custom cell
        TextView redColor = convertView.findViewById(R.id.tv_u_customCell_one);
        TextView greenColor = convertView.findViewById(R.id.tv_u_customCell_two);
        TextView blueColor = convertView.findViewById(R.id.tv_u_customCell_three);
        TextView hexColor = convertView.findViewById(R.id.tv_u_customCell_four);

        ColorInfo colorInfo = colorInfos.get(position);

        int red = colorInfo.getRed();
        int green = colorInfo.getGreen();
        int blue = colorInfo.getBlue();
        String hex = String.format("#%02X%02X%02X", red, green, blue);

        redColor.setText("Red: " + red);
        greenColor.setText("Green: " + green);
        blueColor.setText("Blue: " + blue);
        hexColor.setText("Hex: " + hex);

        //making the listview contain the color that a user selects

        convertView.setBackgroundColor(Color.rgb(red, green, blue));

        return convertView;
    }
}