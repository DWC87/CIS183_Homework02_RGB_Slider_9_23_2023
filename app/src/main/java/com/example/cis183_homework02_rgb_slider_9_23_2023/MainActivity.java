package com.example.cis183_homework02_rgb_slider_9_23_2023;
//David Concord
//9/23/2023
//RGB slider

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.cis183_homework02_rgb_slider_9_23_2023.databinding.ActivityMainBinding;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    //variables
    SeekBar red_seek;
    SeekBar green_seek;
    SeekBar blue_seek;
    Button set_color;
    TextView tvRed;
    TextView tvGreen;
    TextView tvBlue;
    TextView showHex;
    ListView listView;
    ArrayList<ColorInfo> colorInfos;
    ColorSwatchAdapter colorAdapter;
    int red = 255;
    int green = 255;
    int blue = 255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        red_seek = findViewById(R.id.red_seek_bar);
        green_seek = findViewById(R.id.green_seek_bar);
        blue_seek = findViewById(R.id.blue_seek_bar);
        set_color = findViewById(R.id.btn_save_color);
        tvRed = findViewById(R.id.tv_red);
        tvGreen = findViewById(R.id.tv_green);
        tvBlue = findViewById(R.id.tv_blue);
        showHex = findViewById(R.id.hex_rep);
        listView = findViewById(R.id.lv_color_list);
        //connecting arraylist and adapter
        colorInfos = new ArrayList<>();
        colorAdapter = new ColorSwatchAdapter(this, colorInfos);
        listView.setAdapter(colorAdapter);

        seekBars();
        colorButton();
        updateUI();
        listListener();

    }

    private void updateUI()
    {
        //setting the background color and the text that displays the rgb value
        tvRed.setText("Red: " + red);
        tvGreen.setText("Green: " + green);
        tvBlue.setText("Blue: " + blue);
        findViewById(R.id.Layout).setBackgroundColor(Color.rgb(red, green, blue));
    }

    public void fillList(int red, int green, int blue)
    {
        colorInfos.add(new ColorInfo(red, green, blue));
        colorAdapter.notifyDataSetChanged();
    }

    public void seekBars()
    {
        //all of my seekbars
        //setting the text color to light/dark depending on the color so it is easily visible
        red_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
            {
                red = progress;
                updateUI();
                updateHexValue();

                if(red<131&&green<131&&blue<131)
                {
                    tvRed.setTextColor(Color.WHITE);
                    tvGreen.setTextColor(Color.WHITE);
                    tvBlue.setTextColor(Color.WHITE);
                    showHex.setTextColor(Color.WHITE);
                }
                else if(red>=132&&green>=132&&blue>=131)
                {
                    tvRed.setTextColor(Color.BLACK);
                    tvGreen.setTextColor(Color.BLACK);
                    tvBlue.setTextColor(Color.BLACK);
                    showHex.setTextColor(Color.BLACK);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        green_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
            {
                green = progress;
                updateUI();
                updateHexValue();

                if(red<131&&green<131&&blue<131)
                {
                    tvRed.setTextColor(Color.WHITE);
                    tvGreen.setTextColor(Color.WHITE);
                    tvBlue.setTextColor(Color.WHITE);
                    showHex.setTextColor(Color.WHITE);
                }
                else if(red>=132&&green>=132&&blue>=131)
                {
                    tvRed.setTextColor(Color.BLACK);
                    tvGreen.setTextColor(Color.BLACK);
                    tvBlue.setTextColor(Color.BLACK);
                    showHex.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        blue_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
            {
                blue = progress;
                updateUI();
                updateHexValue();

                if(red<131&&green<131&&blue<131)
                {
                    tvRed.setTextColor(Color.WHITE);
                    tvGreen.setTextColor(Color.WHITE);
                    tvBlue.setTextColor(Color.WHITE);
                    showHex.setTextColor(Color.WHITE);
                }
                else if(red>=132&&green>=132&&blue>=131)
                {
                    tvRed.setTextColor(Color.BLACK);
                    tvGreen.setTextColor(Color.BLACK);
                    tvBlue.setTextColor(Color.BLACK);
                    showHex.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }


        });


    }

    private void updateHexValue()
    {
        //having the hex value change to represent the seekbar progress with rgb sliders in real time
        String hex = String.format("#%02X%02X%02X", red, green, blue);
        showHex.setText("Hex representation: " + hex);
    }


    public void colorButton()
    {
        //resetting the seekbars and text after pressing the button
        //calling fillList
        set_color.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                fillList(red, green, blue);

                red_seek.setProgress(255);
                green_seek.setProgress(255);
                blue_seek.setProgress(255);
                tvRed.setTextColor(Color.BLACK);
                tvGreen.setTextColor(Color.BLACK);
                tvBlue.setTextColor(Color.BLACK);
                showHex.setTextColor(Color.BLACK);
            }
        });

    }

    public void listListener()
    {
        //onClickListener for listview items to display the color and seekbar progress for each list item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ColorInfo selectedColor = (ColorInfo) colorAdapter.getItem(position);

                // Set the background color to the selected color
                int selectedColorInt = Color.rgb(selectedColor.getRed(), selectedColor.getGreen(), selectedColor.getBlue());
                findViewById(R.id.Layout).setBackgroundColor(selectedColorInt);

                // Set the SeekBars to match the selected color
                red_seek.setProgress(selectedColor.getRed());
                green_seek.setProgress(selectedColor.getGreen());
                blue_seek.setProgress(selectedColor.getBlue());
            }
        });
    }


}
