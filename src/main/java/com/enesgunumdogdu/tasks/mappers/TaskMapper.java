package com.enesgunumdogdu.tasks.mappers;

import com.enesgunumdogdu.tasks.domain.dto.TaskDto;
import com.enesgunumdogdu.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
