package banco;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.curso.jpa.CursoJPA.domain.Empleado;
import com.curso.jpa.CursoJPA.jpa.EmpleadoException;

public class Pruebas {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("OracleHRPU");
	
	
	
public void crearCuenta(CuentaAhorro banco) throws EmpleadoException{
		
		EntityManager em = factory.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		try {
				em.persist(banco); 
		}catch(EntityExistsException e) {
		
			throw new EmpleadoException("No se pudo crear. El empleado con id " + banco.getNumCuenta() + " ya existe");
		}

		tx.commit();
		
	}
	
	
	
	
	
}
