package com.example.laatutestitapaukset;

public class Main {
    public static void main(String[] args) {
        int time = 3600;
        String output = TimeUtils.secToTime(time);
        System.out.println("Time is " + output);
    }
}
