package com.example.cis183_homework02_rgb_slider_9_23_2023;

public class ColorInfo {

    public String getResultRed() {
        return resultRed;
    }

    public void setResultRed(String r) {
        this.resultRed = r;
    }

    public String getResultGreen() {
        return resultGreen;
    }

    public void setResultGreen(String g) {
        this.resultGreen = g;
    }

    public String getResultBlue() {
        return resultBlue;
    }

    public void setResultBlue(String b) {
        this.resultBlue = b;
    }

    public String getResultHex() {
        return resultHex;
    }

    public void setResultHex(String h) {
        this.resultHex = h;
    }

    private String resultRed;
    private String resultGreen;
    private String resultBlue;
    private String resultHex;

    public ColorInfo()
    {

    }

    public ColorInfo(String r, String g, String b, String h)
    {


    }


}
