package dattq.spring.Demo_CRUD.common;

import dattq.spring.Demo_CRUD.students.StudentsDAO;
import dattq.spring.Demo_CRUD.students.StudentsEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Scanner;

@Configuration
public class MyConfiguration {

    @Bean
    public CommandLineRunner getRunner(StudentsDAO studentsDAO) {
        return runner -> {
            while (true) {
                menu();
                Scanner scanner = new Scanner(System.in);
                int choice = scanner.nextInt();
                if (choice == 1) {
                    save(studentsDAO);
                } else if (choice == 2) {
                    findById(studentsDAO);
                } else if (choice == 3) {
                    viewAll(studentsDAO);
                } else if (choice == 4) {
                    findByName(studentsDAO);
                } else if (choice == 5) {
                    updateStudent(studentsDAO);
                } else if (choice == 6) {
                    deleteStudent(studentsDAO);
                }
            }
        };
    }

    public void menu() {
        System.out.println("Menu: \n" +
                "1. Them sinh vien\n" +
                "2. Tim sinh vien bang ID\n" +
                "3. Hien thi tat ca sinh vien\n" +
                "4. tim sinh vien bang ten\n" +
                "5. Cap nhat thong tin sinh vien\n" +
                "6. Xoa sinh vien\n" +
                "Lua chon: ");
    }

    public void save(StudentsDAO studentsDAO) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lastname: ");
        String lastname = scanner.nextLine();
        System.out.println("Firstname: ");
        String firstname = scanner.nextLine();
        System.out.println("email: ");
        String email = scanner.nextLine();
        StudentsEntity student = new StudentsEntity(lastname, firstname, email);
        studentsDAO.save(student);
    }

    public void findById(StudentsDAO studentsDAO) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("iD: ");
        int id = scanner.nextInt();
        StudentsEntity result = studentsDAO.findById(id);
        if (result != null) {
            System.out.println(result.toString());
        } else {
            System.out.println("No result!");
        }
    }

    public void viewAll(StudentsDAO studentsDAO) {
        List<StudentsEntity> result = studentsDAO.findAll();
        if (result.isEmpty()) {
            System.out.println("No result!");
        } else {
            for (StudentsEntity student : result) {
                System.out.println(student.toString());
            }
        }
    }

    public void findByName(StudentsDAO studentsDAO) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.nextLine();
        List<StudentsEntity> result = studentsDAO.findByName(name);
        if (result.isEmpty()) {
            System.out.println("No result!");
        } else {
            for (StudentsEntity student : result) {
                System.out.println(student.toString());
            }
        }
    }

    public void updateStudent(StudentsDAO studentsDAO) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID: ");
        int id = scanner.nextInt();
        StudentsEntity result = studentsDAO.findById(id);
        if (result != null) {
            System.out.println("Currently: " + result.toString());
            scanner = new Scanner(System.in);
            System.out.println("Lastname: ");
            String lastname = scanner.nextLine();
            System.out.println("Firstname: ");
            String firstname = scanner.nextLine();
            System.out.println("email: ");
            String email = scanner.nextLine();
            result.setLastname(lastname);
            result.setFirstname(firstname);
            result.setEmail(email);
            studentsDAO.update(result);
        } else {
            System.out.println("No result!");
        }
    }

    public void deleteStudent(StudentsDAO studentsDAO) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID: ");
        int id = scanner.nextInt();
        StudentsEntity result = studentsDAO.findById(id);
        if (result != null) {
            studentsDAO.delete(id);
        } else {
            System.out.println("No result!");
        }
    }
}
