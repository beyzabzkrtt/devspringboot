package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.IsNewAwareAuditingHandler;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

		@Bean
		public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {

		};
		}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;
		System.out.println("Deleting course id : " + id);
		appDAO.deleteCourseById(id);
	}

	private void updateCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Finding the course : "+ theId);
		Course course = appDAO.findCourseById(theId);

		System.out.println("updating course : "+theId);
		course.setTitle("voleyboll");

		appDAO.update(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding the instructor : "+ theId);
		Instructor instructor = appDAO.findIntructorById(theId);

		System.out.println("updating instructor id : "+theId);
		instructor.setLastName("BOZKURT");

		appDAO.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: "+ theId);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("instructor: "+ instructor);
		System.out.println("associated courses : "+ instructor.getCourses());

	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id =1;
		System.out.println("Findding instructor id: "+id);
		Instructor instructor = appDAO.findIntructorById(id);
		System.out.println("instructor: "+instructor);
		System.out.println("Finding courses for instructor id : "+ id);
		List<Course> courses = appDAO.findCoursesByInstrucorId(id);
		instructor.setCourses(courses);
		System.out.println("The associated courses : " + instructor.getCourses());

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int id =1;
		System.out.println("Findding instructor id: "+id);
		Instructor instructor = appDAO.findIntructorById(id);
		System.out.println("instructor: "+instructor);
		System.out.println("associated courses: "+instructor.getCourses());

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Susan","Patel","susan@luv2code.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://youtube.com","Video Games");

		//associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create some courses
		Course course = new Course("Air Guitar");
		Course course2 = new Course("Pinball");
		//add courses to the instructor
		tempInstructor.add(course);
		tempInstructor.add(course2);

		//save
		System.out.println("Saving instructor:" + tempInstructor);
		System.out.println("Courses:" + tempInstructor.getCourses());
		appDAO.save(tempInstructor);


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
		int theId=1;
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
