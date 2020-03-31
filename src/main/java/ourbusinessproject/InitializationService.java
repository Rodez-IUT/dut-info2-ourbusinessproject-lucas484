package ourbusinessproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class InitializationService {

    @Autowired
    private EnterpriseProjectService enterpriseProjectService;

    private Project project1E1;
    private Project project1E2;
    private Project project2E1;

    private Enterprise enterprise1;
    private Enterprise enterprise2;

    @Transactional
    /*
    * Si il y a une erreur dans une méthode, le fait de faire des transactions va permettre
    * de conserver l'intégrité des données telle qu'elles étaient au début.
     */
    public void initProjects() {

        enterprise1 = new Enterprise();
        enterprise1.setName("Enterprise 1");
        enterprise1.setDescription("Enterprise 1 description");
        enterprise1.setContactName("Enterprise 1 ContactName");
        enterprise1.setContactEmail("enterprise1@email.fr");

        enterprise2 = new Enterprise();
        enterprise2.setName("Enterprise 2");
        enterprise2.setDescription("Enterprise 2 description");
        enterprise2.setContactName("Enterprise 2 ContactName");
        enterprise2.setContactEmail("enterprise2@email.fr");

        project1E1 = new Project("project1E1", "Project1E1 description", enterprise1);
        project1E2 = new Project("project1E2", "Project1E2 description", enterprise2);
        project2E1 = new Project("project2E1", "Project2E1 description", enterprise1);


        enterpriseProjectService.save(project1E1);
        enterpriseProjectService.save(project1E2);
        enterpriseProjectService.save(project2E1);

    }

    public Project getProject1E1() {
        return project1E1;
    }

    public Project getProject1E2() {
        return project1E2;
    }

    public Project getProject2E1() {
        return project2E1;
    }

    public Enterprise getEnterprise1() {
        return enterprise1;
    }

    public Enterprise getEnterprise2() {
        return enterprise2;
    }
}