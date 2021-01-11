package com.spring.Api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="lenguaje")
public class Lenguaje implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	
//	@Column(name="date")
//	@JsonFormat(pattern = "YYYY-MM-dd")
//	private Date date;
	
	
	
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date;
	



	@PrePersist
	public void prePersis()
	{
		date=new Date();
	}
	
	
	@ManyToMany
	@JoinTable(name="profesores_lenguajes",
			joinColumns = @JoinColumn(name="lenguaje_id",referencedColumnName = "id"),
			inverseJoinColumns =@JoinColumn (name="profesor_id", referencedColumnName = "id")
			)
	private Set<Profesor> listaProfesores=new HashSet<>();
	
	
	
	
	// METODOS DE ACCESO
	 
	
	
	public Long getId() {
		return id;
	}

 


	public void setId(Long id) {
		this.id = id;
	}

 

	public String getNombre() {
		return nombre;
	}
 

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
 


//	public Date getDate() {
//		return date;
//	}
//
//
// 
//
//	public void setDate(Date date) {
//		this.date = date;
//	}


	public Date getDate() {
		return date;
	}




	public void setDate(Date date) {
		this.date = date;
	}

	
 
	public Set<Profesor> getListaProfesores() {
		return listaProfesores;
	}

 
	public void setListaProfesores(Set<Profesor> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

 

	private static final long serialVersionUID = 1L;

}
