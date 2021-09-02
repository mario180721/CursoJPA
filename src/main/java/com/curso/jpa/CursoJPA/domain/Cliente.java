package com.curso.jpa.CursoJPA.domain;

import javax.persistence.*;

@Entity
public class Cliente {
	
    @Id
    @Column(name="id")
	private Integer id;
	private String nombre;
	
	@Column(updatable = false, nullable = false, insertable = false)
	private String apellido;
	
	@Transient
	private boolean checked;
	
	
	public Cliente() {
		
	}

	public Cliente(int id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	

	public int getId() {
		return id;
	}
  
	public String getNombre() {
		return nombre;
	}
 
	public String getApellido() {
		return apellido;
	}
	
	
	

}
