package com.curso.jpa.CursoJPA.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.curso.jpa.CursoJPA.domain.Empleado;

public class EmpleadoDAO {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
	

	public void crearEmpleado(Empleado empleado) {
		
		EntityManager em = factory.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		em.persist(empleado);
		
		
		tx.commit();
		
	}//fin crearEmpleado
	
	public Empleado getEmpleado(Long id) {
		return null;
	}
	
	//borrar
	
	//modificar
	
	
	public static void main(String[] args) {
		
		EmpleadoDAO dao = new EmpleadoDAO();
		
		Empleado e = new Empleado();
		e.setNombre("Luis");
		e.setApellidos("Ramos");
		//e.setComision(n);
		e.setEmail("");
		e.setFechaContratacion(new java.util.Date());
		e.setIdDepartamento(100); //101  fk
		//e.setIdManager(null);
		e.setIdTrabajo("AD_PRES");
		e.setSalario(23000.0);
		dao.crearEmpleado(e);
		
	}
	
	
}
