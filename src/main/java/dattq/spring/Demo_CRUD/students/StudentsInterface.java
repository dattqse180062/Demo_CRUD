package dattq.spring.Demo_CRUD.students;

import java.util.List;

public interface StudentsInterface {
    public void save(StudentsEntity student);
    public StudentsEntity findById(int id);
    public List<StudentsEntity> findAll();
    public List<StudentsEntity> findByName(String name);
    public StudentsEntity update(StudentsEntity student);
    public void delete(int id);
}
