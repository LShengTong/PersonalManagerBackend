package org.xuzhu.personal_manager.pojo;

public class Time {
    private int hour;
    private int minute;

    public Time(){}

    public Time(String timeString) {
        String[] parts = timeString.split(":");
        if (parts.length != 2) return;
        hour = Integer.parseInt(parts[0]);
        minute = Integer.parseInt(parts[1]);
    }

    @Override
    public String toString() {
        return String.format("%d:%02d", hour, minute);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}