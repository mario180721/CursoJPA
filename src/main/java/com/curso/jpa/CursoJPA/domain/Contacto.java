package com.curso.jpa.CursoJPA.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "CONTACTOS")
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")
    , @NamedQuery(name = "Contacto.findById", query = "SELECT c FROM Contacto c WHERE c.id = :id")
    , @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Contacto.findByApellidos", query = "SELECT c FROM Contacto c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Contacto.findByEmail", query = "SELECT c FROM Contacto c WHERE c.email = :email")
    , @NamedQuery(name = "Contacto.findByFechaNac", query = "SELECT c FROM Contacto c WHERE c.fechaNac = :fechaNac")})


public class Contacto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="ID")
	private Integer id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="APELLIDOS")
	private String apellidos;
	@Column(name="EMAIL")
	private String email;
	@Column(name="FECHA_NAC")
	private Date fecha_nacimiento;
		
	
	@JoinTable(name = "GRUPOS_CONTACTOS", joinColumns = {
	        @JoinColumn(name = "ID_CONTACTO", referencedColumnName = "ID")}, inverseJoinColumns = {
	        @JoinColumn(name = "ID_GRUPO", referencedColumnName = "ID")})
	    @ManyToMany(fetch = FetchType.LAZY)
	   
	
	private Collection<Grupo> grupoCollection;
	
	
	
	public Contacto() {
		super();
	}



	public Contacto(Integer id, String nombre, String apellidos, String email, Date fecha_nacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
	}



	public Contacto(Integer id) {
		super();
		this.id = id;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}



	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}



	public Collection<Grupo> getGrupoCollection() {
		return grupoCollection;
	}



	public void setGrupoCollection(Collection<Grupo> grupoCollection) {
		this.grupoCollection = grupoCollection;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	   public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }


	@Override
	public String toString() {
		return "Contacto [id=" + id + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto other = (Contacto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
