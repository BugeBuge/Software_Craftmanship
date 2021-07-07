package socra.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public void registerNewTask(@RequestBody Task task) {
        taskService.addNewTask(task);
    }

    @DeleteMapping(path = "{Id}")
    public void deleteTask(@PathVariable("Id") Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/export/{Id}")
    public Task getTaskExport(@PathVariable("Id") Long id) {
        return taskService.getTaskExport(id);
    }
}
