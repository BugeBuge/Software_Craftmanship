package socra.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import socra.project.elements.Task;
import socra.project.repositories.TaskRepository;

import java.util.List;

@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
        return args -> {
            Task one = new Task(
                    "Issy-les-Moulineau",
                    "12 MOIS",
                    "Tarif non renseigné",
                    "100 %",
                    "ASAP, ex 12 mai 2021",
                    "développeur ReactJS",
                    "intégration au sein de l’équipe Engineeringdu pôle Industrialisation, Cloudand Data, le consultant contribuera aux activitésAPIs et API Management",
                    "Participer aux Comités d’Architecturepour garantir la bonne conformité desbonne pratique des APIs.Promouvoir les pratiquesAPI First au sein du groupe."
            );
            taskRepository.saveAll(List.of(one));
            Task two = new Task(
                    "Paris 1er - 75",
                    "12 MOIS",
                    "Tarif non renseigné",
                    "50 %",
                    "ASAP",
                    "Ingénieur Supervision Run N3 H/F",
                    "Place de l'emploi public recherche pour INSERM un Ingénieur Informatique gestion des données de la recherche H/F INSERM",
                    "Le/la chef-fe de projet rejoindra le DSI pour travailler à la réalisation d'un métamodèle standard"
            );
            taskRepository.saveAll(List.of(two));
            Task three = new Task(
                    "Issy-les-Moulineau",
                    "CDI",
                    "Tarif non renseigné",
                    "0 %",
                    "ASAP",
                    "Ingénieur Informatique Gestion des Données de la Recherche H/F",
                    "Place de l'emploi public recherche pour INSERM un Ingénieur Informatique gestion des données de la recherche H/F INSERM",
                    "Sa mission sera de traduire la partie de la norme ISO consacrée au modèle commun de la Provenance (lui-même basé sur le standard W3C PROV) et développée par le partenaire BBMRI en un méta modèle UML instanciable et implémentable."
            );
            taskRepository.saveAll(List.of(three));
            Task four = new Task(
                    "Paris 15e - 75 ",
                    "CDI",
                    "55 000 EUR par an",
                    "30 %",
                    "ASAP",
                    "Ingénieur en Développeur Sénior Angular - Js H/F",
                    "La division Robotique de Progressive recrute pour un de ses clients parisiens !",
                    "Au sein de l'équipe R&D, vous prenez une part très importante pour soutenir le développement d'une plateforme de votre futur employeur qui est dans une démarche d'automatisation."
            );
            taskRepository.saveAll(List.of(four));
            Task five = new Task(
                    "Paris 1er - 75",
                    "CDI",
                    "42 000 EUR par an ",
                    "0 %",
                    "ASAP",
                    "Consultant Expert en Informatique Décisionnelle H/F",
                    "La Data Intelligence Agency regroupant le Cabinet BIAL-X et le Centre de service BIAL-R a pour mission d'accompagner les entreprises et les administrations à extraire la valeur de leurs données pour accroitre leurs performances.",
                    "Vous occuperez le poste de Consultant Expert en informatique décisionnelle H/F sur des projets à fortes valeurs ajoutées. Vous intervenez également au sein du cabinet, pour jouer un rôle actif dans le développement d'offres innovantes."
            );
            taskRepository.saveAll(List.of(five));
            Task six = new Task(
                    "Paris 17e - 75",
                    " CDI ",
                    "Tarif non renseigné",
                    "50 %",
                    "ASAP",
                    "Expert Vtom Automatisation H/F",
                    "Quel que soit votre secteur d'activité, ISS propose une offre globale de services autour de 6 lignes métiers : le facility management, la propreté, la sécurité, les services aux occupants, les services au bâtiment et la restauration.",
                    "Assurer et optimiser l'industrialisation de la production sur VTOM"
            );
            taskRepository.saveAll(List.of(six));
            Task seven = new Task(
                    "Paris 1er - 75",
                    "CDI",
                    "35 000 EUR par an ",
                    "100 %",
                    "ASAP",
                    "Ingenieur Developpeur Full Stack H/F",
                    "Vous participerez à la conception et au développement d'applications portail Web d'un de nos projets dans le secteur de l'énergie.",
                    "Développement applicatif Web HTML5/JS/CSS3."
            );
            taskRepository.saveAll(List.of(seven));
            Task eight = new Task(
                    "Paris - 75 ",
                    " Alternance ",
                    "Tarif non renseigné",
                    "0 %",
                    "ASAP",
                    "Ingénieur IT Solvabilité 2 H/F",
                    "Votre mission? Assister les équipes sur les aspects techniques et fonctionnels du progiciel Risk Integrity dans le cadre du programme Solvabilité 2.",
                    "Mettre en place une base documentaire collaborative qui regroupe tous les liens vers les documents utiles aux experts ainsi que la création de pages décrivant les modes opératoires et les process d'analyse"
            );
            taskRepository.saveAll(List.of(eight));
            Task nine = new Task(
                    "Paris 15e - 75 ",
                    " CDI ",
                    "Tarif non renseigné",
                    "50 %",
                    "ASAP",
                    "Ingenieur Informatique Poste de Travail",
                    "Cette mission se déroulera au sein de la Direction des Systèmes d'Information d'un grand groupe international de services et sera basée à Paris.",
                    "L'ingénieur poste de travail contribuera à l'évolution de la souche logicielle du poste de travail de notre client, et interviendra aussi bien sur des projets (migrations de systèmes, plateforme de gestion/configuration des postes)"
            );
            taskRepository.saveAll(List.of(nine));
            Task ten = new Task(
                    "Paris 1er - 75 ",
                    "CDI",
                    "40 000 EUR par an",
                    "100 %",
                    "ASAP",
                    "Ingénieur IT Solution Laboratoire H/F",
                    "Vous ferez partie d'un duo pour couvrir le secteur France Vous serez responsable du SIL (system d'information de laboratoire)",
                    "Notre client propose une large gamme de services et de prestations médicotechniques au domicile du patient dans plusieurs domaines d'intervention. Aujourd'hui, ils sont en pleine expansion, notamment grâce à un développement"
            );
            taskRepository.saveAll(List.of(ten));
        };
    }
}
