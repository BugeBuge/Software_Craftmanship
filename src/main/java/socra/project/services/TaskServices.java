package socra.project.services;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socra.project.elements.Task;
import socra.project.repositories.TaskRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("task.pdf"));
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        try {
            document.add(new Paragraph("Id : " + taskId));
            document.add(new Paragraph("Lieu : " + taskInDb.getLieu()));
            document.add(new Paragraph("Durée : " + taskInDb.getDurée()));
            document.add(new Paragraph("Tarif : " + taskInDb.getTarif()));
            document.add(new Paragraph("Télétravail : " + taskInDb.getTélétravail()));
            document.add(new Paragraph("Début : " + taskInDb.getDébut()));
            document.add(new Paragraph("Poste : " + taskInDb.getPoste()));
            document.add(new Paragraph("Contexte : " + taskInDb.getContexte()));
            document.add(new Paragraph("Mission : " + taskInDb.getMission()));
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        document.close();
        return taskInDb;
    }
}
