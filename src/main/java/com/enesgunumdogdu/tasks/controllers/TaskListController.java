package com.enesgunumdogdu.tasks.controllers;

import com.enesgunumdogdu.tasks.domain.dto.TaskListDto;
import com.enesgunumdogdu.tasks.domain.entities.TaskList;
import com.enesgunumdogdu.tasks.mappers.TaskListMapper;
import com.enesgunumdogdu.tasks.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/task-lists")
public class TaskListController{

    private final TaskListService tasklistService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService tasklistService, TaskListMapper taskListMapper) {
        this.tasklistService = tasklistService;
        this.taskListMapper = taskListMapper;
    }


    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return tasklistService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdTaskList = tasklistService.createTaskList(
                taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(createdTaskList);
    }

    @GetMapping(path = "/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID taskListId) {
        return tasklistService.getTaskList(taskListId).map(taskListMapper::toDto);
    }

    @PutMapping(path = "/{task_list_id}")
    public TaskListDto updateTaskList(@PathVariable("task_list_id") UUID taskListId, @RequestBody TaskListDto taskListDto) {
        TaskList updatedTaskList = tasklistService.updateTaskList(taskListId, taskListMapper.fromDto(taskListDto));
        return taskListMapper.toDto(updatedTaskList);
    }
}
