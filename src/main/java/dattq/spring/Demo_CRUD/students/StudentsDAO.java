package dattq.spring.Demo_CRUD.students;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class StudentsDAO implements StudentsInterface {
    private EntityManager entityManager;

    public StudentsDAO() {
    }

    @Autowired
    public StudentsDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(StudentsEntity student) {
        this.entityManager.persist(student);
    }

    @Override
    public StudentsEntity findById(int id) {
        return this.entityManager.find(StudentsEntity.class, id);
    }

    @Override
    public List<StudentsEntity> findAll() {
        String jpql = "SELECT s FROM StudentsEntity s";
        List<StudentsEntity> result = this.entityManager.createQuery(jpql, StudentsEntity.class).getResultList();
        return result;
    }

    @Override
    public List<StudentsEntity> findByName(String name) {
        String jpql = "SELECT s FROM StudentsEntity s " +
                "WHERE s.firstname LIKE :name";
        TypedQuery<StudentsEntity> query = entityManager.createQuery(jpql, StudentsEntity.class);
        query.setParameter("name", "%" + name + "%");
        List<StudentsEntity> result = query.getResultList();
        return result;
    }

    @Override
    public StudentsEntity update(StudentsEntity student) {
        return this.entityManager.merge(student);
    }

    @Override
    public void delete(int id) {
        StudentsEntity student = this.entityManager.find(StudentsEntity.class, id);
        this.entityManager.remove(student);
    }
}
