package com.curso.jpa.CursoJPA.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


public class Grupo implements Serializable {
	
	
	@Entity
	@Table(name = "GRUPOS")
	@NamedQueries({
	    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g")
	    , @NamedQuery(name = "Grupo.findById", query = "SELECT g FROM Grupo g WHERE g.id = :id")
	    , @NamedQuery(name = "Grupo.findByColor", query = "SELECT g FROM Grupo g WHERE g.color = :color")
	    , @NamedQuery(name = "Grupo.findByNombre", query = "SELECT g FROM Grupo g WHERE g.nombre = :nombre")})
		
	private static final long serialVersionUID = 1L;
	@Id
	
	@Column(name = "ID")
	private Integer id;
	@Column(name = "COLOR")
	private String color;
	@Column(name = "NOMBRE")
	private String nombre;
	
	
	  @ManyToMany(mappedBy = "grupoCollection", 
              fetch = FetchType.LAZY)
  private Collection<Contacto> contactoCollection;


	  
	  
	  
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Grupo other = (Grupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Grupo() {
		super();
	}


	public Grupo(Integer id) {
		super();
		this.id = id;
	}


	public Grupo(Integer id, String color, String nombre, Collection<Contacto> contactoCollection) {
		super();
		this.id = id;
		this.color = color;
		this.nombre = nombre;
		this.contactoCollection = contactoCollection;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Collection<Contacto> getContactoCollection() {
		return contactoCollection;
	}


	public void setContactoCollection(Collection<Contacto> contactoCollection) {
		this.contactoCollection = contactoCollection;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Grupo [id=" + id + "]";
	}
	
	  
	  
	  

}
