package com.MyProject.SubmissionService.service;

import com.MyProject.SubmissionService.model.TaskDto;
import org.springframework.stereotype.Component;

@Component
public class TaskServiceFallback implements TaskService{
    @Override
    public TaskDto findTaskById(Long id, String jwt) throws Exception {
        return null;
    }

    @Override
    public TaskDto completedTask(Long id) throws Exception {
        return null;
    }
}
