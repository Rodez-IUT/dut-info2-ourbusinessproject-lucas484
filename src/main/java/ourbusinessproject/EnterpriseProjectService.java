package ourbusinessproject;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class EnterpriseProjectService {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Project findProjectById(Long id) {
        return this.entityManager.find(Project.class, id);
    }



    public Enterprise findEnterpriseById(Long id) {
        return this.entityManager.find(Enterprise.class, id);
    }

    public void save(Object objet){
        entityManager.persist(objet);
        entityManager.flush();
    }

}
