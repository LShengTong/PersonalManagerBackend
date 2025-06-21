package org.xuzhu.personal_manager.Service;

import org.springframework.stereotype.Service;
import org.xuzhu.personal_manager.mapper.DailyScheduleMapper;
import org.xuzhu.personal_manager.mapper.RegularScheduleMapper;
import org.xuzhu.personal_manager.pojo.DailySchedule;
import org.xuzhu.personal_manager.pojo.RegularSchedule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodaySchedules {
    private final DailyScheduleMapper dailyScheduleMapper;
    private final RegularScheduleMapper regularScheduleMapper;

    TodaySchedules(DailyScheduleMapper dailyScheduleMapper, RegularScheduleMapper regularScheduleMapper) {
        this.dailyScheduleMapper = dailyScheduleMapper;
        this.regularScheduleMapper = regularScheduleMapper;
    }

    DailySchedule[] getNeededDailySchedules() {
        List<DailySchedule> neededDailySchedules = new ArrayList<>();
        RegularSchedule[] regularSchedules = regularScheduleMapper.getRegularSchedules();
        for(RegularSchedule regularSchedule : regularSchedules){
            LocalDate lastDate = dailyScheduleMapper.getLastDateOfRegularScheduleId(regularSchedule.getId());
            if(regularSchedule.isTodayNeed(lastDate)){
                List<DailySchedule> dailySchedules = List.of(regularSchedule.toTodayDailySchedules());
                neededDailySchedules.addAll(dailySchedules);
            }
        }
        return neededDailySchedules.toArray(new DailySchedule[0]);
    }

    public DailySchedule[] getTodayDailySchedules() {
        DailySchedule[] todayDailySchedules = dailyScheduleMapper.getTodaySchedules();
        if(todayDailySchedules.length == 0){
            DailySchedule[] dailySchedules = getNeededDailySchedules();
            dailyScheduleMapper.insertDailySchedules(dailySchedules);
            return dailyScheduleMapper.getTodaySchedules();
        }
        return todayDailySchedules;
    }
}
