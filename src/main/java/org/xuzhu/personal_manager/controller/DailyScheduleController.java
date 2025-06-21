package org.xuzhu.personal_manager.controller;

import org.springframework.web.bind.annotation.*;
import org.xuzhu.personal_manager.pojo.DailySchedule;
import org.xuzhu.personal_manager.mapper.DailyScheduleMapper;

import java.time.LocalDate;

@RestController
@CrossOrigin("http://121.40.80.170:3000")
public class DailyScheduleController {
    private final DailyScheduleMapper dailyScheduleMapper;

    DailyScheduleController(DailyScheduleMapper dailyScheduleMapper) {
        this.dailyScheduleMapper = dailyScheduleMapper;
    }

    @PostMapping("/update_daily_schedules")
    public void updateDailySchedules(@RequestBody DailySchedule[] dailySchedules ) {
        dailyScheduleMapper.updateDailySchedules(dailySchedules);
    }

    @PostMapping("/delete_daily_schedule")
    public void deleteDailySchedule(@RequestBody int dailyScheduleId) {
        dailyScheduleMapper.deleteDailySchedule(dailyScheduleId);
    }

    @PostMapping("/add_today_schedule")
    public int addTodaySchedule(@RequestBody DailySchedule dailySchedule) {
        dailySchedule.setDate(LocalDate.now());
        DailySchedule[] dailySchedules = new DailySchedule[1];
        dailySchedules[0] = dailySchedule;
        dailyScheduleMapper.insertDailySchedules(dailySchedules);
        return dailySchedule.getId();
    }
}
