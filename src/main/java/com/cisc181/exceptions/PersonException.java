package com.cisc181.exceptions;

import com.cisc181.core.Person;

public class PersonException extends Exception {
	Person p;

	public PersonException(Person p) {
		super();
		this.p = p;
	}
}
