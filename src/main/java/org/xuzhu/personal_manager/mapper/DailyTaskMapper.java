package org.xuzhu.personal_manager.mapper;

import org.apache.ibatis.annotations.*;
import org.xuzhu.personal_manager.pojo.DailyTask;

@Mapper
public interface DailyTaskMapper {
    @Select("select * from daily_task where date = curdate()")
    DailyTask[] getTodayTasks();

    @Select("select * from daily_task where id = #{id}")
    DailyTask getDailyTaskById(int id);

    @Update("update daily_task set task_id = #{taskId} where id = #{id}")
    void updateDailyTask(DailyTask dailyTask);

    @Insert("insert into daily_task (task_id, date) values (#{taskId}, curdate())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertDailyTask(DailyTask dailyTask);

    @Delete("delete from daily_task where id = #{id}")
    void deleteDailyTaskById(int id);
}
