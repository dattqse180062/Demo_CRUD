package dattq.spring.Demo_CRUD.students;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class StudentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "lastname", length = 45)
    private String lastname;
    @Column(name = "firstname", length = 45)
    private String firstname;
    @Column(name = "email", length = 45)
    private String email;

    public StudentsEntity() {
    }

    public StudentsEntity(String lastname, String firstname, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }

    public StudentsEntity(int id, String lastname, String firstname, String email) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentsEntity{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
