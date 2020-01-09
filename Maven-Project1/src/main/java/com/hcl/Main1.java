package com.hcl;



import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;



public class Main1 {



 public static void main(String[] args) {

 // TODO Auto-generated method stub

 /*Scanner sc = new Scanner(System.in);

 System.out.println("enter date of birth");

 String date = sc.nextLine();

 SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yyyy");

 sd.setLenient(false);

 Date d1=null;

 try{

  d1 = sd.parse(date);

 }

 catch(ParseException e){

  System.out.println(e);

 }
*/


Configuration configuration = new Configuration().configure();

SessionFactory sessionFactory = configuration.buildSessionFactory();

Session session = sessionFactory.openSession();

Transaction transaction = session.beginTransaction();

/*SQLQuery q = session.createSQLQuery("select * from emp1000");

List<Object[]> l = q.list();
for(Object[] l1 : l){
	System.out.println("Id :" +(Integer) l1[0]);
	System.out.println("Name :" +(String) l1[1]);
	System.out.println("Salary :" +(Float) l1[2]);
	System.out.println("Dob :" +(Date) l1[3]);
}*/
SQLQuery q = session.createSQLQuery("select * from emp1000").addEntity(Employee.class);

List l = q.list();
Iterator i = l.iterator();
while(i.hasNext()){
	Employee e = (Employee)i.next();
	System.out.println(e);
}


/*Criteria c = session.createCriteria(Employee.class);
c.add(Restrictions.eq("id", 100));
List<Employee> l = c.list();
for(Employee e : l){
	System.out.println(e);
}*/
	/*Query q=session.createQuery("from Employee");
	q.setFirstResult(1);
	q.setMaxResults(3);
	
	
	List<Employee> l = q.list();
	for(Employee e:l){
		System.out.println(e);
	}*/
/*Query q = session.createQuery("select e from Employee e");
Query q=session.createQuery("select e.name from Employee e");
	Query q = session.createQuery("select e.id,e.salary from Employee e");
Query q = session.createQuery("select e.name from Employee e where id=100");
Query q = session.createQuery("select e.name from Employee e where e.id=:a");
q.setParameter("a",100);
Object l = q.uniqueResult();
System.out.println(1);
Query q = session.createQuery("update Employee e set e.salary=:s,e.name=:n where e.id=:i");
q.setParameter("s", 4000f);
q.setParameter("n", "aaa");
q.setParameter("i", 100);

int i=q.executeUpdate();
*/
/*List<String[]> l = q.list();*/
	/*System.out.printf(String.format("%-10s,%-15s,%-10s,%-15s\n", "Id","Name","Salary","Dob"));*/
	
	

/*Employee e = new Employee();*/

//insert employee
/*e.setId(3);

e.setName("ram");

e.setSalary(60000);

e.setDob(d1);

System.out.println(session.save(e));*/

//update employee
/*Employee e1 = (Employee)session.get(Employee.class,3);
e1.setName("prassu");
e1.setSalary(60000);
session.update(e1);
*/
/*Employee e2 = (Employee)session.load(Employee.class,3);
session.delete(e2);*/
transaction.commit();

session.close();

 }



}