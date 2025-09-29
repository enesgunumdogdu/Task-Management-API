package com.enesgunumdogdu.tasks.mappers;

import com.enesgunumdogdu.tasks.domain.dto.TaskListDto;
import com.enesgunumdogdu.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
