package br.com.projectteste.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente {
	
	@Id
	private long id;
	
	
	private String nome;
	
	private double cpf;
	
	private Date dataNascimento;
	private static String dataNascimentoStr;

	public String getDataNascimentoStr() {
		return dataNascimentoStr;
	}

	public void setDataNascimentoStr(String dataNascimentoStr) {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			this.dataNascimento = sdf.parse(dataNascimentoStr);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome= nome;
	}

	public double getCpf() {
		return cpf;
	}

	public void setCpf(double cpf) {
		this.cpf= cpf;
	}


	
	public Paciente(long id, String nome, double cpf, Date dataNascimento){
		
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		
	}	
	
	public Paciente(){ }
	
	
}
