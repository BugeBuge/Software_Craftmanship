package socra.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socra.project.elements.Task;
import socra.project.repositories.TaskRepository;

import javax.transaction.Transactional;
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

    @Transactional
    public void updateTask(Long taskId, Task task) {
        Task taskInDb = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalStateException(
                        "Mission with id " + taskId + " does not exist"
                ));
        taskInDb.setLieu(task.getLieu());
        taskInDb.setDurée(task.getDurée());
        taskInDb.setTarif(task.getTarif());
        taskInDb.setTélétravail(task.getTélétravail());
        taskInDb.setDébut(task.getDébut());
        taskInDb.setPoste(task.getPoste());
        taskInDb.setContexte(task.getContexte());
        taskInDb.setMission(task.getMission());
    }

    public void deleteTask(Long taskId) {
        if (taskRepository.existsById(taskId)){
            taskRepository.deleteById(taskId);
        }
        else {
            throw new IllegalStateException("Mission with id " + taskId + " does not exist");
        }
    }
}
