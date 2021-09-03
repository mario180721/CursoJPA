package banco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "CUENTA_BANCARIA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_CUENTA")


public abstract class CuentaBancaria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	
	@Column(name="NUM_CUENTA")
	private Integer numCuenta;
	
	@Column(name="SALDO")
	private Integer saldo;
	
	@Column(name="TIPO_CUENTA")
	private String tipoCuenta;
	
	@Column(name="INTERES")
	private Integer interes;
	
	@Column(name="CREDITO")
	private Integer credito;

	@Override
	public String toString() {
		return "CuentaBancaria [numCuenta=" + numCuenta + "]";
	}

	public CuentaBancaria() {
		super();
	}

	public CuentaBancaria(Integer numCuenta) {
		super();
		this.numCuenta = numCuenta;
	}

	public CuentaBancaria(Integer numCuenta, Integer saldo, Integer interes) {
		super();
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.interes = interes;
		
	}

	public CuentaBancaria(String numCuenta2, Integer saldo2) {
		// TODO Auto-generated constructor stub
		super();
		this.numCuenta = numCuenta;
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numCuenta == null) ? 0 : numCuenta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		if (numCuenta == null) {
			if (other.numCuenta != null)
				return false;
		} else if (!numCuenta.equals(other.numCuenta))
			return false;
		return true;
	}

	public Integer getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(Integer numCuenta) {
		this.numCuenta = numCuenta;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Integer getInteres() {
		return interes;
	}

	public void setInteres(Integer interes) {
		this.interes = interes;
	}

	public Integer getCredito() {
		return credito;
	}

	public void setCredito(Integer credito) {
		this.credito = credito;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
}
