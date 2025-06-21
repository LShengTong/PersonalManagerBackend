package org.xuzhu.personal_manager.pojo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RegularSchedule {
    private int id;
    private String name;
    private Time[] times;
    private int interval;

    public RegularSchedule() {}

    public DailySchedule[] toTodayDailySchedules(){
        DailySchedule[] dailySchedules = new DailySchedule[times.length];
        for(int i = 0; i < times.length; i++){
            dailySchedules[i] = new DailySchedule();
            dailySchedules[i].setRegularScheduleId(id);
            dailySchedules[i].setTime(times[i]);
            dailySchedules[i].setDate(LocalDate.now());
        }
        return dailySchedules;
    }

    public boolean isTodayNeed(LocalDate date){
        return interval > ChronoUnit.DAYS.between(LocalDate.now(), date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time[] getTimes() {
        return times;
    }

    public void setTimes(Time[] time) {
        this.times = time;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
