package com.example.admin.nlptry;

import java.nio.file.Path;

public class time
{
    static int min;
    static int sec;
    static int hour;

    void input(int m,int s,int h)
    {
        min = m;
        sec = s;
        hour = h;
    }

    public int getMin() {
        return min;
    }

    public int getSec() {
        return sec;
    }

    public int getHour() {
        return hour;
    }
}
