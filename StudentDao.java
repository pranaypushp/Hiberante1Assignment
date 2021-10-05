package com.te.hibernate.assignment1;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDao {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	
	boolean flag=true;
	while(flag) {
	
		System.out.println("enter 1 to display all updates: "
				+ "enter 2 to display particular data"
				+ "enter 3 to update any particular data"
				+ "enter 4 to delete data");
		int n=scanner.nextInt();
		switch(n) {
		case 1: StudentCrudOperation.select();
		break;
		
		case 2:StudentCrudOperation.selectOne();
		break;
		case 3:StudentCrudOperation.update();
		break;
		
		case 4: StudentCrudOperation.delete();
		break;
		
		default: System.out.println("you have inserted invalid number");
		break;
		}
		System.out.println("do you want to continue type y else type n");
	    char ch=scanner.next().charAt(0);
	    if(ch=='y'|| ch=='Y') {
	    	flag=true;
	    } else {
			flag=false;
		}
	
	}
	System.out.println("Nice to meet you!!!");
}
}
