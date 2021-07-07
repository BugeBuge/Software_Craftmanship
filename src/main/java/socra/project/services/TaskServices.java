package socra.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socra.project.elements.Task;
import socra.project.repositories.TaskRepository;

import java.util.ArrayList;
import java.util.Arrays;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskServices {
    private final TaskRepository taskRepository;

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

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

    private int count_substrings(String substring, String str)
    {
        int lastIndex = 0;
        int count = 0;
        while(lastIndex != -1){

            lastIndex = str.indexOf(substring,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += substring.length();
            }
        }
        return count;
    }



    public List<Task> getTaskByKeyword(List<String> keywords) {
        List<Task> tasks = taskRepository.findAllByOrderByIdDesc();
        int size = tasks.size();
        double[] occurences = new double[size];
        for (int i = 0; i < size; i++) {
            int sum_o = 0;
            int sum_m = 0;
            for (String keyword : keywords) {
                int count = count_substrings(keyword, tasks.get(i).getMission());
                sum_o += count;
                if (count > 0) {
                    sum_m++;
                }
            }
            occurences[i] = sum_m * sum_o - 0.5 * sum_o * keywords.size();
        }
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (occurences[j] < occurences[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    var temp = tasks.get(j);
                    tasks.set(j, tasks.get(j + 1));
                    tasks.set(j + 1, temp);
                }
            }
        }
        return tasks;
    }
}
