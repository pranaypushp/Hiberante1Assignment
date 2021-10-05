package com.te.hibernate.assignment1;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity

public class Student {
	@Id
	private int rollno;
	private String name;
	private long phno;
	private int standard;

}
