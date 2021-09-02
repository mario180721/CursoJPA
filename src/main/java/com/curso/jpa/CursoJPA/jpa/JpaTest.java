package com.curso.jpa.CursoJPA.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.curso.jpa.CursoJPA.domain.Employee;
import com.curso.jpa.CursoJPA.domain.Department;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//POR CÓDIGO 
		//1.  Creo unafactoria de EM   en el create...(nombre de la unidad de persistencia)
		//     que esta en persistence.xml
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("MiUnidad");
		
		EntityManager em = factory.createEntityManager();
		JpaTest test = new JpaTest(em);

		EntityTransaction tx = em.getTransaction();
		tx.begin();  //INICIA TRANSACCION
		
		   //CRUD
		   // em.persist  -> INSERT
		   //Department dp = new Department();
		  // dp.setName("DESARROLLO");
		   
		  // em.persist(dp);  
		
		   //  em.find  -->  BUSCAR POR ID
		  System.out.println("....  BUSCO DEPT POR ID 1");
		
		    long id = 1; //pk
		    Department d1  	 = em.find(Department.class, id);
		
		    d1.setName("NNNN");
		    System.out.println("el dpto 1 " + d1.getName());
		    
		    System.out.println(".... vuelvo a buscar por id 1 ");
		    Department d2 =  em.find(Department.class, 1l);  //  no hace selecT CONTRA BD proque ya lo tiene
		    
		    System.out.println("el dpto 1 " + d1.getName());
		    
		    //d1 y d2 apuntan al mismo objeto
		    
		   //  MODIFICAR
		    d1.setName("OTROwwwwww2");
		    
            //BORRAR
		    em.remove(d1);

		    tx.commit();
		    System.out.println("........commit");
		    
		    
		
//		try {
//			test.createEmployees();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//tx.commit();  //CONFIRMA  van a bd
		
		
		//tx.rollback(); // DESHACE  las instrucciones dentro trans  (no va a bd)

		//test.listEmployees();

		System.out.println(".. done");
	}




	private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();
		if (numOfEmployees == 0) {
			
			Department department = new Department("java");
			manager.persist(department); // insert into DEPARTMENS VALUES (1,"JAVA")

			manager.persist(new Employee("Jakab Gipsz",department));
			manager.persist(new Employee("Captain Nemo",department));

		}
	}


	private void listEmployees() {
		List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee next : resultList) {
			System.out.println("next employee: " + next);
		}
	}


}
