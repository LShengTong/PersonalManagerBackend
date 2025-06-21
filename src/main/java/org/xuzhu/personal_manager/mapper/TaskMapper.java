package org.xuzhu.personal_manager.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.xuzhu.personal_manager.pojo.Task;

@Mapper
public interface TaskMapper {
    @Select("select * from task")
    public Task[] selectTasks();
}
