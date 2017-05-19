package br.com.projectteste.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import br.com.projectteste.entity.Paciente;
import br.com.projectteste.entity.Medicamento;

@Entity
@Table(name = "prescricao")
public class Prescricao {
	
	@Id
	private long id;
//	private long pacienteId;
//	private long medicamentoId;
	private String nome;
	private String frequencia;
	private String dose;
	private Date dataPrescricao;
	private static String dataPrescricaoStr;
	
	@ManyToOne 
	@JoinColumn(name="paciente_id")
	private Paciente paciente;
	
	@ManyToOne 
	@JoinColumn(name="medicamento_id")
	private Medicamento medicamento;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getdataPrescricaoStr() {
		return dataPrescricaoStr;
	}
	
	public void setdataPrescricaoStr(String dataPrescricaoStr) {
		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			this.dataPrescricao = sdf.parse(dataPrescricaoStr);
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	

	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medicamento getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}


	public Prescricao(long id, long pacienteId,long medicamentoId, String nome, String frequencia, String dose, Date dataPrescricao){
		
		Paciente pa= new Paciente();
		
		pa.setId(pacienteId);
		paciente = pa;
			
		Medicamento med = new Medicamento();
			
		med.setId(medicamentoId);
		medicamento = med;
			
		this.id = id;
		this.nome =  nome;
		this.frequencia = frequencia;
		this.dose = dose;
		this.dataPrescricao = dataPrescricao;
		
	}
	
	public Prescricao(){}
}
