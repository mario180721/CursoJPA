package banco;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CA")

public class CuentaAhorro  extends CuentaBancaria{
	
	
	@Column(name = "INTERES")
	 private Integer interes;

	public CuentaAhorro() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	public CuentaAhorro(String numCuenta, Integer saldo, Integer interes) {
		super(numCuenta, saldo);
		this.interes = interes;
	}



	public CuentaAhorro(Integer numCuenta) {
		super(numCuenta);
		// TODO Auto-generated constructor stub
	}

	public Integer getInteres() {
		return interes;
	}

	public void setInteres(Integer interes) {
		this.interes = interes;
	}

	
	
	

}
