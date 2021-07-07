package socra.project;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import socra.project.elements.Task;
import socra.project.repositories.TaskRepository;
import javax.transaction.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest (classes = ProjectApplication.class)
class ProjectApplicationTests {

	@Autowired
	private TaskRepository taskRepository;

	@Before
	public void init() {
		Task employee = new Task(
				"Issy-les-Moulineau",
				"12 MOIS",
				"Tarif non renseigné",
				"100 %",
				"ASAP, ex 12 mai 2021",
				"développeur ReactJS",
				"intégration au sein de l’équipe Engineeringdu pôle Industrialisation, Cloudand Data, le consultant contribuera aux activitésAPIs et API Management",
				"Participer aux Comités d’Architecturepour garantir la bonne conformité desbonne pratique des APIs.Promouvoir les pratiquesAPI First au sein du groupe.");
		taskRepository.save(employee);
	}

	@After
	public void clean() {
		taskRepository.deleteAll();
	}

	@Test
	@Transactional
	public void verifyDbSize() {
		assertThat(taskRepository.count() == 1);
	}
}
