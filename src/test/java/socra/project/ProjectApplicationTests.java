package socra.project;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.shaded.org.bouncycastle.est.LimitedSource;
import socra.project.controllers.TaskController;
import socra.project.elements.Task;
import socra.project.repositories.TaskRepository;
import socra.project.services.TaskServices;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = ProjectApplication.class)
class ProjectApplicationTests {

	@Autowired
	private TaskServices taskServices;

	@Before
	public void init() {
		Task task = new Task(
				"Issy-les-Moulineau",
				"12 MOIS",
				"Tarif non renseigné",
				"100 %",
				"ASAP, ex 12 mai 2021",
				"développeur ReactJS",
				"intégration au sein de l’équipe Engineeringdu pôle Industrialisation, Cloudand Data, le consultant contribuera aux activitésAPIs et API Management",
				"Participer aux Comités d’Architecturepour garantir la bonne conformité desbonne pratique des APIs.Promouvoir les pratiquesAPI First au sein du groupe.");
		taskServices.addNewTask(task);
		task = new Task(
				"Issy-les-Moulineau",
				"12 MOIS",
				"Tarif non renseigné",
				"100 %",
				"ASAP, ex 12 mai 2021",
				"développeur ReactJS",
				"intégration au sein de l’équipe Engineeringdu pôle Industrialisation, Cloudand Data, le consultant contribuera aux activitésAPIs et API Management",
				"Ceci est un fausse mission ne pas utiliser.");
		taskServices.addNewTask(task);
	}

	@Test
	@Transactional
	public void verifyDbSizeAtStartUp() {
		assertThat(taskServices.getTaskRepository().count() == 1);
	}

	@Test
	@Transactional
	public void verifyDbSizeAtDelete() {
		taskServices.deleteTask(1L);
		assertThat(taskServices.getTaskRepository().count() == 0);
	}

	@Test
	@Transactional
	public void verifyGetTasksNotEmpty() {
		var result = taskServices.getTasks();
		assertThat(result.size() > 0);
	}

	@Test
	@Transactional
	public void verifyGetTasksByKeywordNotEmpty() {
		var result = taskServices.getTaskByKeyword(new ArrayList<>());
		assertThat(result.size() > 0);
	}

	@Test
	@Transactional
	public void verifyGetTasksOrder() {
		List<String> keywords = new ArrayList<>();
		keywords.add("utiliser");
		var result = taskServices.getTaskByKeyword(keywords);
		assertThat(result.get(0).getMission().equals("Ceci est un fausse mission ne pas utiliser."));
		assertThat(result.get(1).getMission().equals("Participer aux Comités d’Architecturepour garantir la bonne conformité desbonne pratique des APIs.Promouvoir les pratiquesAPI First au sein du groupe."));
	}
} 
