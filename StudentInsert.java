package com.te.hibernate.assignment1;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentInsert {
public static void main(String[] args) {
	Student student= new Student();
	
	Scanner scanner=new Scanner(System.in);
	
	System.out.println("enter rollno: ");
	int rollno=scanner.nextInt();
	student.setRollno(rollno);
	
	System.out.println("enter name: ");
//	String string=scanner.next();
	String name=scanner.next();
	
	student.setName(name);
	
	System.out.println("enter phno: ");
	long phno=scanner.nextLong();
	student.setPhno(phno);
	System.out.println("enter standard: ");
	int standard=scanner.nextInt();
	student.setStandard(standard);
	EntityManagerFactory factory=null;
	EntityManager manager=null;
	EntityTransaction transaction=null;
	try {
		factory=Persistence.createEntityManagerFactory("emp");
		manager= factory.createEntityManager();
		transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(student);
		transaction.commit();
	} catch (Exception e) {
		if(transaction!=null) {
			transaction.rollback();
		}
		e.printStackTrace();
	} finally {
		try {
			if(factory!=null) {
				factory.close();
			}
			if(manager!=null) {
				manager.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
}

}
