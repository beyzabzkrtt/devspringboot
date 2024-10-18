package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

		@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};
		}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=3;
		appDAO.deleteInstructorDetailById(theId);

	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor detail id: " + theId);
		InstructorDetail instructorDetail = appDAO.findIntructorDetailById(theId);
		System.out.println("Instructor Detail: " +instructorDetail);
		System.out.println("associated intructor :" + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=2;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: " + theId);
		Instructor instructor = appDAO.findIntructorById(theId);
		System.out.println("Instructor: " +instructor);
		System.out.println("Related intructor detail:" + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

//		Instructor tempInstructor = new Instructor("Chad","Darby","darby@luv2code.com");
//		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/yputube","Luv 2 code !!");

		Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@luv2code.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/yputube","Guitar");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		// this will aiso save the instructordetail object
		System.out.println("Saving instructor : " + tempInstructor);
		appDAO.save(tempInstructor);
	}
}
