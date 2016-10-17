package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;
import com.cisc181.exceptions.PersonException;

public class Staff_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAverageSalary() throws PersonException {
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		staffList.add(new Staff("First", "Middle", "Last", new Date(0), "Smith Hall", "(111)-222-3334",
				"cisc181@udel.edu", "9 to 5", 1,10000, new Date(0), eTitle.MR));
		staffList.add(new Staff("First", "Middle", "Last", new Date(0), "Smith Hall", "(111)-222-3334",
				"cisc181@udel.edu", "9 to 5", 1, 20000, new Date(0), eTitle.MR));
		staffList.add(new Staff("First", "Middle", "Last", new Date(0), "Smith Hall", "(111)-222-3334",
				"cisc181@udel.edu", "9 to 5", 1, 30000, new Date(0), eTitle.MR));
		staffList.add(new Staff("First", "Middle", "Last", new Date(0), "Smith Hall", "(111)-222-3334",
				"cisc181@udel.edu", "9 to 5", 1, 40000, new Date(0), eTitle.MR));
		staffList.add(new Staff("First", "Middle", "Last", new Date(0), "Smith Hall", "(111)-222-3334",
				"cisc181@udel.edu", "9 to 5", 1, 50000, new Date(0), eTitle.MR));

		double averageSalary = (staffList.get(0).getSalary() + staffList.get(1).getSalary()
				+ staffList.get(2).getSalary() + staffList.get(3).getSalary() + staffList.get(4).getSalary()) / 5;
		
		assertTrue(averageSalary == 30000);
	}

	@Test(expected = PersonException.class)
	public void testIncorrectPhoneNumber() throws PersonException {
		Staff testStaff = new Staff("First", "Middle", "Last", new Date(0), "Smith Hall", "(111)-222-3334",
				"cisc181@udel.edu", "9 to 5", 1, 10000, new Date(0), eTitle.MR);
	}

	@Test(expected = PersonException.class)
	public void testIncorrectDOB() throws PersonException {
		Calendar testCalendar = Calendar.getInstance();
		testCalendar.set(Calendar.YEAR, 1925);
		Date DOB = testCalendar.getTime();
		
		Staff testStaff = new Staff("First", "Middle", "Last", DOB, "MyAddress", "(111)-222-3334", "cisc181@udel.edu",
				"9 to 5", 1, 10000, new Date(0), eTitle.MR);
	}
}
