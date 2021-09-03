package banco;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CA")


public class CuentaCredito  extends CuentaAhorro{
	
	
	@Column(name = "TIPO_CUENTA")
	 private String tipoCuenta;


}
