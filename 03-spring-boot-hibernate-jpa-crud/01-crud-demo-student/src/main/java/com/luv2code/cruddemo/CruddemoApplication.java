package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);



		};
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Bozkurt");
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findAll();
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO){

		Student tempStudent = new Student("Duffy","Duck","duck@mail.com");
		studentDAO.save(tempStudent);

		int theId= tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);

		System.out.println("Ogrenci getiriliyor. ID: " + theId);
		Student rStudent= studentDAO.findById(theId);
		System.out.println("Ogrenci bulundu: " + rStudent );

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student objects");

		Student[] students = new Student[5];
		for(int i = 1 ; i < 5 ;i ++ ){

			students[i] = new Student("B"+i,"Bozkurt","bb"+i+"@mail.com");
			studentDAO.save(students[i]);
			System.out.println("Student is saved. Generated id : " + students[i].getId());
		}

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Beyza","Bozkurt","bb20@mail.com");

		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
