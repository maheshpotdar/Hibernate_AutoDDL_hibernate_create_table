package com.mahesh.Client;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		// 4 ways of AutoDDL
		// 1.create
		// 2.update
		// 3.create-drop
		// 4.validate.

		// create info :-
		// create manaje ata jar table asel tar to drop karato
		// ani atacha navin object first line la save karato.

		// update info:-
		// table madhe 500 record astil tar atachya navin object 501 number la save
		// hoto.

		// create-drop info:-
		// same create

		// validate info:-
		// same update

		Employee employee1 = new Employee();
		employee1.setEname("Mahesh Patel");
		employee1.setAddress("Satara");

		Employee employee2 = new Employee();
		employee2.setEname("Ram Gadkari");
		employee2.setAddress("Mumbai");

		Employee employee3 = new Employee();
		employee3.setEname("Shyam Pawar");
		employee3.setAddress("Kolhapur");

		Employee employee4 = new Employee();
		employee4.setEname("Jignesh Satarkar");
		employee4.setAddress("Aurangabad");

		// 4 object manaje 4 rows
		// 1 row manaje 1 object.

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		org.hibernate.Transaction t = session.beginTransaction();

		session.save(employee1);
		session.save(employee2);
		session.save(employee3);
		session.save(employee4);

		session.getTransaction().commit();

		System.out.println("Inserted successfully.");
		session.evict(employee1);
		session.evict(employee2);
		session.evict(employee3);
		session.evict(employee4);
		// object in detached state
	}
}
