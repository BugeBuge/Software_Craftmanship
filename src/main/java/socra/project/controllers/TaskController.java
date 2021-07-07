package socra.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import socra.project.elements.Task;
import socra.project.services.TaskServices;

import java.util.List;

@RestController
@RequestMapping(path = "/tasks")
public class TaskController {
    private final TaskServices taskService;

    @Autowired
    public TaskController(TaskServices taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }
}
