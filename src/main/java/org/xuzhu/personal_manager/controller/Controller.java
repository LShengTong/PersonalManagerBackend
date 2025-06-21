package org.xuzhu.personal_manager.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xuzhu.personal_manager.Service.TodaySchedules;
import org.xuzhu.personal_manager.mapper.DailyTaskMapper;
import org.xuzhu.personal_manager.mapper.RegularScheduleMapper;
import org.xuzhu.personal_manager.mapper.TaskMapper;
import org.xuzhu.personal_manager.pojo.InitState;

@RestController
@CrossOrigin("http://121.40.80.170:3000")
public class Controller {
    private final RegularScheduleMapper regularScheduleMapper;
    private final TodaySchedules todaySchedules;
    private final TaskMapper taskMapper;
    private final DailyTaskMapper dailyTaskMapper;

    Controller(RegularScheduleMapper regularScheduleMapper, TodaySchedules todaySchedules,
               TaskMapper taskMapper, DailyTaskMapper dailyTaskMapper) {
        this.regularScheduleMapper = regularScheduleMapper;
        this.todaySchedules = todaySchedules;
        this.taskMapper = taskMapper;
        this.dailyTaskMapper = dailyTaskMapper;
    }

    @GetMapping("/init")
    public InitState init() {
        InitState initState = new InitState();
        initState.setRegularSchedules(regularScheduleMapper.getRegularSchedules());
        initState.setDailySchedules(todaySchedules.getTodayDailySchedules());
        initState.setDailyTasks(dailyTaskMapper.getTodayTasks());
        initState.setTasks(taskMapper.selectTasks());
        return initState;
    }
}
