package com.curso.jpa.CursoJPA.jpa;

import java.awt.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.curso.jpa.CursoJPA.domain.Empleado;
import com.curso.jpa.CursoJPA.domain.Trabajo;

public class EmpleadoDAO {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
	
	/**
	 * 
	 * @param empleado
	 */
	public void crearEmpleado(Empleado empleado) throws EmpleadoException{
		
		EntityManager em = factory.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		try {
				em.persist(empleado); 
		}catch(EntityExistsException e) {
		
			throw new EmpleadoException("No se pudo crear. El empleado con id " + empleado.getId() + " ya existe");
		}

		tx.commit();
		
	}//fin crearEmpleado
	
	/**
	 * Método que devuelve una instancia del empleado
	 * por su id . Si no lo encuentra devuelve null
	 * 
	 * @param id
	 * @return  empleado (null si no existe)
	 */
	public Empleado getEmpleado(Long id) {
		EntityManager em = factory.createEntityManager();
		Empleado e = em.find(Empleado.class, id);
		return e;
	}
	
	
	
	
	//borrar
	
	public void borrarEmpleado(Long id) throws EmpleadoException {
		EntityManager em = factory.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Empleado eBorrar = em.find(Empleado.class, id);
		if( eBorrar == null) {
			throw new EmpleadoException("No se pudo borrar. no existe el empleado");
		}
		
		
		em.remove(eBorrar);	
		
		tx.commit();
		
	}
	
	
	//get Trabajo con sus empleados
	public Trabajo getTrabajo(String codigo) {
		
		EntityManager em = factory.createEntityManager();
		Trabajo t = em.find(Trabajo.class, codigo);
		
		System.out.println("Lista trabajadores trabnajo " + t.getTituloTrabajo());
		System.out.println("lista empleados");
		java.util.List<Empleado> l  = t.getColeccionEmpleados();
		for(Empleado e: l) {
			System.out.println(e.getNombre());
		}
		return t;
	
	}//fin getTrabajo
	
	
	
	public void modificarEmpleado(Empleado eModif) {
		EntityManager em = factory.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Empleado eBaseDatos = em.merge(eModif);
		
		tx.commit();
	}
	
	
	
	
	
	public static void main(String[] args) {
//		
		EmpleadoDAO dao = new EmpleadoDAO();
//		
//		Empleado e = new Empleado();
//		e.setNombre("Luis");
//		e.setApellidos("Ramos");
//		//e.setComision(n);
//		e.setEmail("lr");
//		e.setFechaContratacion(new java.util.Date());
//		e.setIdDepartamento(100); //101  fk
//		//e.setIdManager(null);
//		Trabajo t = new Trabajo();
//		t.setId("AD_PRES");
//		e.setTrabajo(t);
//		e.setSalario(23000.0);
//		
//		
//		try {
//			
//			dao.crearEmpleado(e);
//			
//			
//		} catch (EmpleadoException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		//100 int
		//100l o 100L  long
		//1d   double
		//1.0 double
		//1.0f  float
		
		long f = 100;
		Long ff = 100L;
		
		//buscar empleado
		Empleado e = dao.getEmpleado(100L);
		
		System.out.println("Nombre "  + e.getNombre());
		
		System.out.println("Trabajo " + e.getTrabajo().getTituloTrabajo());
		
		
		Trabajo tADPress = dao.getTrabajo("AD_PRES");
		
		
	}
	
	
}
