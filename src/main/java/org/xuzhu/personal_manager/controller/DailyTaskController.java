package org.xuzhu.personal_manager.controller;

import org.springframework.web.bind.annotation.*;
import org.xuzhu.personal_manager.mapper.DailyTaskMapper;
import org.xuzhu.personal_manager.pojo.DailyTask;

@RestController
@CrossOrigin("http://121.40.80.170:3000")
public class DailyTaskController {

    private final DailyTaskMapper dailyTaskMapper;

    DailyTaskController(DailyTaskMapper dailyTaskMapper) {
        this.dailyTaskMapper = dailyTaskMapper;
    }

    @GetMapping("/today_tasks")
    public DailyTask[] todayTasks(){
        return dailyTaskMapper.getTodayTasks();
    }

    @PostMapping("/update_daily_task")
    public void updateDailyTask(@RequestBody DailyTask dailyTask){
        dailyTaskMapper.updateDailyTask(dailyTask);
    }

    @PostMapping("/add_today_task")
    public int addDailyTask(@RequestBody int taskId){
        DailyTask dailyTask = new DailyTask();
        dailyTask.setTaskId(taskId);
        dailyTaskMapper.insertDailyTask(dailyTask);
        return dailyTask.getId();
    }

    @PostMapping("/delete_daily_task")
    public void deleteDailyTask(@RequestBody int dailyTaskId){
        dailyTaskMapper.deleteDailyTaskById(dailyTaskId);
    }
}
