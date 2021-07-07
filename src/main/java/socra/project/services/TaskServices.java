package socra.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socra.project.elements.Task;
import socra.project.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskServices {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServices(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAllByOrderByIdDesc();
    }

    public void addNewTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        if (taskRepository.existsById(taskId)){
            taskRepository.deleteById(taskId);
        }
        else {
            throw new IllegalStateException("Mission with id " + taskId + " does not exist");
        }
    }

    public Task getTaskExport(Long taskId) {
        Task taskInDb = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException(
                        "Task with id " + taskId + " does not exist"
                ));
        //TO DO
        return taskInDb;
    }
}
