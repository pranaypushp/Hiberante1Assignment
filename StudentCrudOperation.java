package com.te.hibernate.assignment1;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentCrudOperation {
static Student student;
	// DISPLAY ALL QUERY

	public static void select() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;

		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			String select = "from Student";
			Query query = manager.createQuery(select);
			List<Student> list = query.getResultList();
			for (Student student : list) {
				System.out.println(student);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (manager != null) {
					manager.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// DISPLAY ONE QUERY

	public static void selectOne() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter rollno");
		int rollno = scanner.nextInt();
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Student find = manager.find(Student.class, rollno);
			if (find != null) {
				String selectOne = "from Student where rollno=:rollno";
				Query query = manager.createQuery(selectOne);
				query.setParameter("rollno", rollno);
				Student student = (Student) query.getSingleResult();
				System.out.println(student);
				transaction.commit();
			} else {
				try {
					throw new InvalidRollnumberException("please enter valid rollno");
				} catch (InvalidRollnumberException e) {
					System.out.println(e.getMessage());

				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (manager != null) {
					manager.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	// UPDATE QUERY

	public static void update() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter rollno");
		int rollno = scanner.nextInt();
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Student find = manager.find(Student.class, rollno);
			if (find != null) {
				System.out.println("do you want to update by name then type y else n");
				char ch = scanner.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("enter the name");
					String name = scanner.next();
					String update = "update from Student set name=:name where rollno=:rollno";
					Query query = manager.createQuery(update);
					query.setParameter("rollno", rollno);
					query.setParameter("name", name);
					int result = query.executeUpdate();
					System.out.println(name + " is updated");
					transaction.commit();
				} else {

					System.out.println("do you want to update by phone number then type y else n");
					char ch1 = scanner.next().charAt(0);
					System.out.println();
					if (ch1 == 'y' || ch1 == 'Y') {
						System.out.println("enter the phone number");
						long phno = scanner.nextLong();
						String update = "update from Student set phno=:phno where rollno=:rollno";
						Query query = manager.createQuery(update);
						query.setParameter("rollno", rollno);

						query.setParameter("phno", phno);
						int result = query.executeUpdate();
						System.out.println(phno + " is updated");
						transaction.commit();
					} else {

						System.out.println("do you to update by statndard then type=y else n");
						char ch2 = scanner.next().charAt(0);
						System.out.println();
						if (ch2 == 'y' || ch2 == 'Y') {
							System.out.println("enter the standard");
							int standard = scanner.nextInt();

							String update = "update from Student set standard=:standard where rollno=:rollno";
							Query query = manager.createQuery(update);
							query.setParameter("rollno", rollno);

							query.setParameter("standard", standard);
							int result = query.executeUpdate();
							System.out.println(standard + " is updated");
							transaction.commit();

						}
					}

				}
			} else {
				try {
					throw new InvalidRollnumberException("please enter valid rollno");
				} catch (InvalidRollnumberException e) {
					System.out.println(e.getMessage());

				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (manager != null) {
					manager.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void delete() {
		
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter rollno");
		int rollno = scanner.nextInt();
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Student find = manager.find(Student.class, rollno);
//			System.out.println(find+" find");
//			String findId="select id from Student";
//			Query query2=manager.createQuery(findId);
			if (find!=null) {
				String delete = "delete from Student where rollno=:rollno";
				Query query = manager.createQuery(delete);
				query.setParameter("rollno", rollno);
				int result = query.executeUpdate();
				System.out.println(rollno + " is deleted");
				transaction.commit();
			} else {
				try {
					throw new InvalidRollnumberException("please enter valid rollno");
				} catch (InvalidRollnumberException e) {
					System.out.println(e.getMessage());

				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (factory != null) {
					factory.close();
				}
				if (manager != null) {
					manager.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
