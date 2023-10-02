package com.example.cis183_homework02_rgb_slider_9_23_2023;
//David Concord
//9/23/2023
//RGB slider

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.cis183_homework02_rgb_slider_9_23_2023.databinding.ActivityMainBinding;

import java.util.ArrayList;



/** @noinspection rawtypes*/
public class MainActivity extends AppCompatActivity {

    SeekBar red_seek;
    SeekBar green_seek;
    SeekBar blue_seek;
    Button set_color;
    TextView tvRed;
    TextView tvGreen;
    TextView tvBlue;
    TextView showHex;
    ListView listView;
    int redValue;
    int greenValue;
    int blueValue;

    int i;
    ArrayList<String> ColorInfo;
    ArrayAdapter adapter;
    ActivityMainBinding binding;



    int red=255,blue=255,green=255;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        red_seek    = findViewById(R.id.red_seek_bar);
        green_seek  = findViewById(R.id.green_seek_bar);
        blue_seek   = findViewById(R.id.blue_seek_bar);
        set_color   = findViewById(R.id.btn_save_color);
        tvRed       = findViewById(R.id.tv_red);
        tvGreen     = findViewById(R.id.tv_green);
        tvBlue      = findViewById(R.id.tv_blue);
        showHex     = findViewById(R.id.hex_rep);
        listView    = findViewById(R.id.lv_color_list);

        ColorInfo colorInfo = new ColorInfo();


        ColorInfo = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, ColorInfo);







        binding.tvRed.setText("Red:" + red);
        binding.tvGreen.setText("Green:" + green);
        binding.tvBlue.setText("Blue: "+ blue);
        binding.Layout.setBackgroundColor(Color.rgb(red,green,blue));






        seekBars();
        colorButton();

    }
    //list items for listview.
    public void fillList(){
        //rgb to hex representation
        String hex = String.format("#%02X%02X%02X", red, green, blue);
        String resultRed = "Red: "+ "" + redValue;
        String resultGreen = "  Green: "+ "" + greenValue;
        String resultBlue = "  Blue: "+ "" + blueValue;
        String resultHex = "Hex: "+ hex;




        //adding info to array
        ColorInfo.add(resultRed + resultGreen + resultBlue + " " + resultHex);
        listView.setBackgroundColor(Color.parseColor((hex)));
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();







    }
    //setting the color with three seekbars
    public void seekBars(){
        binding.redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                red=progress;
                binding.tvRed.setText("Red: " + red);
                binding.Layout.setBackgroundColor(Color.rgb(red,green,blue));
                String hex = String.format("#%02X%02X%02X", red, green, blue);

                showHex.setText("Hex representation :" + hex.toString());

                redValue = red;
                //conditional statement to change the text to white when color is dark
                if(red<131&&green<131&&blue<131){
                    tvRed.setTextColor(Color.WHITE);
                    tvGreen.setTextColor(Color.WHITE);
                    tvBlue.setTextColor(Color.WHITE);
                    showHex.setTextColor(Color.WHITE);
                }
                else if(red>=132&&green>=132&&blue>=131){
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


        binding.greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                green=progress;
                binding.tvGreen.setText("Green: " + green);
                binding.Layout.setBackgroundColor(Color.rgb(red,green,blue));
                String hex = String.format("#%02X%02X%02X", red, green, blue);

                showHex.setText("Hex representation :" + hex.toString());

                greenValue = green;

                if(red<131&&green<131&&blue<131){
                    tvRed.setTextColor(Color.WHITE);
                    tvGreen.setTextColor(Color.WHITE);
                    tvBlue.setTextColor(Color.WHITE);
                    showHex.setTextColor(Color.WHITE);
                }
                else if(red>=132&&green>=132&&blue>=131){
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

        binding.blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                blue=progress;
                binding.tvBlue.setText("Blue: " + blue);
                binding.Layout.setBackgroundColor(Color.rgb(red,green,blue));
                String hex = String.format("#%02X%02X%02X", red, green, blue);

                showHex.setText("Hex representation :" + hex.toString());

                blueValue = blue;

                if(red<131&&green<131&&blue<131){
                    tvRed.setTextColor(Color.WHITE);
                    tvGreen.setTextColor(Color.WHITE);
                    tvBlue.setTextColor(Color.WHITE);
                    showHex.setTextColor(Color.WHITE);
                }
                else if(red>=132&&green>=132&&blue>=131){
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



    }    //making button fill the listview on click and reset the seekbars on click
    public void colorButton(){

        set_color.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                fillList();

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



}
