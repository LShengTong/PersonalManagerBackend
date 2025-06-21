package org.xuzhu.personal_manager.pojo;

public class InitState {
    private RegularSchedule[] regularSchedules;
    private DailySchedule[] dailySchedules;
    private Task[] tasks;
    private DailyTask[] dailyTasks;

    public RegularSchedule[] getRegularSchedules() {
        return regularSchedules;
    }

    public void setRegularSchedules(RegularSchedule[] regularSchedules) {
        this.regularSchedules = regularSchedules;
    }

    public DailySchedule[] getDailySchedules() {
        return dailySchedules;
    }

    public void setDailySchedules(DailySchedule[] dailySchedules) {
        this.dailySchedules = dailySchedules;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public DailyTask[] getDailyTasks() {
        return dailyTasks;
    }

    public void setDailyTasks(DailyTask[] dailyTasks) {
        this.dailyTasks = dailyTasks;
    }
}
