package org.xuzhu.personal_manager.pojo;

import java.time.LocalDate;

public class DailySchedule {
    private int id;
    private int regularScheduleId;
    private Time time;
    private LocalDate date;

    public DailySchedule(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRegularScheduleId() {
        return regularScheduleId;
    }

    public void setRegularScheduleId(int regularScheduleId) {
        this.regularScheduleId = regularScheduleId;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
