package com.cisc181.core;

import static org.junit.Assert.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;
import com.cisc181.exceptions.PersonException;

public class Student_Test {
	static ArrayList<Course> courseList;
	static ArrayList<Semester> semesterList;
	static ArrayList<Section> sectionList;
	static ArrayList<Student> studentList;

	@BeforeClass
	public static void setup() throws PersonException {
		courseList = new ArrayList<Course>();
		courseList.add(new Course(UUID.randomUUID(), "CISC181", 4, eMajor.COMPSI));
		courseList.add(new Course(UUID.randomUUID(), "CHEN103", 4, eMajor.CHEM));
		courseList.add(new Course(UUID.randomUUID(), "ECON101", 4, eMajor.BUSINESS));

		semesterList = new ArrayList<Semester>();
		
		semesterList.add(new Semester(UUID.randomUUID(), new Date(0), new Date(1000)));
		semesterList.add(new Semester(UUID.randomUUID(), new Date(2000), new Date(3000)));

		sectionList = new ArrayList<Section>();

		sectionList.add(new Section(courseList.get(0).getCourseID(), semesterList.get(0).getSemesterID(),
				UUID.randomUUID(), 1111));
		sectionList.add(new Section(courseList.get(1).getCourseID(), semesterList.get(0).getSemesterID(),
				UUID.randomUUID(), 222));
		sectionList.add(new Section(courseList.get(2).getCourseID(), semesterList.get(0).getSemesterID(),
				UUID.randomUUID(), 333));

		sectionList.add(new Section(courseList.get(0).getCourseID(), semesterList.get(1).getSemesterID(),
				UUID.randomUUID(), 123));
		sectionList.add(new Section(courseList.get(1).getCourseID(), semesterList.get(1).getSemesterID(),
				UUID.randomUUID(), 234));
		sectionList.add(new Section(courseList.get(2).getCourseID(), semesterList.get(1).getSemesterID(),
				UUID.randomUUID(), 345));

		studentList = new ArrayList<Student>();
		studentList.add(new Student("First", "Middle", "Last", new Date(0), eMajor.BUSINESS, "Trabant",
				"(111)-222-3334", "cisc181@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(1), eMajor.BUSINESS, "Trabant",
				"(111)-222-3334", "cisc181@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(2), eMajor.COMPSI, "Trabant",
				"(111)-222-3334", "cisc181@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(3), eMajor.COMPSI, "Trabant",
				"(111)-222-3334", "cisc181@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(4), eMajor.CHEM, "Trabant", 
				"(111)-222-3334","cisc181@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(5), eMajor.CHEM, "Trabant", 
				"(111)-222-3334","cisc181@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(6), eMajor.PHYSICS, "Trabant",
				"(111)-222-3334", "cisc181@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(7), eMajor.PHYSICS, "Trabant",
				"(111)-222-3334", "cisc181@udel.edu"));
		studentList.add(new Student("First", "Middle", "Last", new Date(8), eMajor.NURSING, "Trabant",
				"(111)-222-3334", "Student8@email.com"));
		studentList.add(new Student("First", "Middle", "Last", new Date(9), eMajor.NURSING, "Trabant",
				"(111)-222-3334", "Student9@email.com"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		courseList = null;
		semesterList = null;
		sectionList = null;
		studentList = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStudentGPA() {
		ArrayList<Enrollment> enrollmentList = new ArrayList<Enrollment>();
		ArrayList<Double> studentGPAList = new ArrayList<Double>();


		for (int counter1 = 0; counter1 < studentList.size(); counter1++) {
			Student student = studentList.get(counter1);

			for (int counter2 = 0; counter2 < sectionList.size(); counter2++) {
				Section section = sectionList.get(counter2);
				Enrollment e = new Enrollment(section.getSectionID(), student.getStudentID());
				e.setGrade((counter1 * 10) + 10);
				enrollmentList.add(e);
			}
		}

		for (int counter1 = 0; counter1 < enrollmentList.size(); counter1 += 6) {
			double GPA = 0;
			for (int counter2 = 0; counter2 < 6; counter2++) {
				int element = counter1 + counter2;
				GPA += enrollmentList.get(element).getGrade();
			}
			GPA = GPA / 6;
			studentGPAList.add(GPA);
		}

		assertTrue(studentGPAList.get(0).doubleValue() == 10);
		assertTrue(studentGPAList.get(1).doubleValue() == 20);
		assertTrue(studentGPAList.get(2).doubleValue() == 30);
		assertTrue(studentGPAList.get(3).doubleValue() == 40);
		assertTrue(studentGPAList.get(4).doubleValue() == 50);
		assertTrue(studentGPAList.get(5).doubleValue() == 60);
		assertTrue(studentGPAList.get(6).doubleValue() == 70);
		assertTrue(studentGPAList.get(7).doubleValue() == 80);
		assertTrue(studentGPAList.get(8).doubleValue() == 90);
		assertTrue(studentGPAList.get(9).doubleValue() == 100);
	}

	@Test
	public void testCourseGPA() {
		ArrayList<Enrollment> enrollmentList = new ArrayList<Enrollment>();
		ArrayList<Double> sectionGPAList = new ArrayList<Double>();
		
		for (int counter1 = 0; counter1 < studentList.size(); counter1++) {
			Student student = studentList.get(counter1);

			for (int counter2 = 0; counter2 < sectionList.size(); counter2++) {
				Section section = sectionList.get(counter2);
				Enrollment e = new Enrollment(section.getSectionID(), student.getStudentID());
				e.setGrade((counter1 * 10) + 10);
				enrollmentList.add(e);
			}
		}
		
		for (int counter1 = 0; counter1 < 6; counter1++) {
			double classGPA = 0;
			for (int counter2 = 0; counter2 < enrollmentList.size(); counter2 += 6) {
				int element = counter1 + counter2;
				classGPA += enrollmentList.get(element).getGrade();
			}
			classGPA = classGPA / 10;
			sectionGPAList.add(classGPA);
		}
		
		assertTrue(sectionGPAList.get(0).doubleValue() == 55);
		assertTrue(sectionGPAList.get(1).doubleValue() == 55);
		assertTrue(sectionGPAList.get(2).doubleValue() == 55);
		assertTrue(sectionGPAList.get(3).doubleValue() == 55);
		assertTrue(sectionGPAList.get(4).doubleValue() == 55);
		assertTrue(sectionGPAList.get(5).doubleValue() == 55);
	}
	
	@Test
	public void testChangeMajor() {
		studentList.get(0).setMajor(eMajor.CHEM);
		assertEquals(studentList.get(0).getMajor(), eMajor.CHEM);
	}
}