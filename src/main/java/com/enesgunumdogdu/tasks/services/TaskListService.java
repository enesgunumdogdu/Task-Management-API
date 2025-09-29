package com.enesgunumdogdu.tasks.services;

import com.enesgunumdogdu.tasks.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
    List<TaskList> listTaskLists();
}
