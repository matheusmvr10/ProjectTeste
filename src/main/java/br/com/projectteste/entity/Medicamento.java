package br.com.projectteste.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medicamento")
public class Medicamento {
	
	@Id
	private long id;
	private String nomeMedicamento;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeMedicamento() {
		return nomeMedicamento;
	}
	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}

	public Medicamento(long id, String nomeMedicamento){
		
		this.nomeMedicamento = nomeMedicamento;
		this.id = id;
	
	}
	
	
	public Medicamento(){}

}
