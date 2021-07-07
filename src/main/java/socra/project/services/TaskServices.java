package socra.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socra.project.elements.Task;
import socra.project.repositories.TaskRepository;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Task> getMissionsByKeyword(List<String> keywords) {
        List<Task> missions = taskRepository.findAllByOrderByIdDesc();
        int size = missions.size();
        int[] scores = new int[size];
        Arrays.fill(scores, 0);
        List<Task> missionsFiltered = new ArrayList<>();
        for (Task mission : missions) {
            String description = mission.getMission();
            for (String keyword : keywords) {
                if (description.toLowerCase().contains(keyword.toLowerCase())){
                    int position = missions.indexOf(mission);
                    scores[position]++;
                }
            }
        }
        int nbKeywords = keywords.size();
        while (nbKeywords > 0)
        {
            int pos = 0;
            while (pos < scores.length){
                if (scores[pos] == nbKeywords) {
                    missionsFiltered.add(missions.get(pos));
                }
                pos++;
            }
            nbKeywords--;
        }
        return missionsFiltered;
    }
}
