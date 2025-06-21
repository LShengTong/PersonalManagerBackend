package org.xuzhu.personal_manager.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.xuzhu.personal_manager.pojo.DailySchedule;

import java.time.LocalDate;

@Mapper
public interface DailyScheduleMapper {
    @Select("select * from daily_schedule where date = curdate()")
    DailySchedule[] getTodaySchedules();

    void insertDailySchedules(DailySchedule[] dailySchedules);

    @Select("select date from daily_schedule where regular_schedule_id = #{regularScheduleId} " +
            "order by date desc limit 1")
    LocalDate getLastDateOfRegularScheduleId(int regularScheduleId);

    void updateDailySchedules(DailySchedule[] dailySchedules);

    DailySchedule[] getDailySchedules(int[] ids);

    @Delete("delete from daily_schedule where id = #{id}")
    void deleteDailySchedule(int id);
}
