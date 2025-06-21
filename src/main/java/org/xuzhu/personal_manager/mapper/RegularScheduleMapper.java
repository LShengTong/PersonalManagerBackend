package org.xuzhu.personal_manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xuzhu.personal_manager.pojo.RegularSchedule;

@Mapper
public interface RegularScheduleMapper {
    @Select("select * from regular_schedule")
    RegularSchedule[] getRegularSchedules();
}
