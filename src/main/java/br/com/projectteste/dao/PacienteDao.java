package br.com.projectteste.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projectteste.entity.Paciente;

@Repository
@Transactional
public class PacienteDao{
	
	
	public void createPaciente(Paciente paciente){
		entityManager.persist(paciente);
		return;
	}
	
	
	public void deletePaciente(Paciente paciente){
		if(entityManager.contains(paciente)){
			entityManager.remove(paciente);
								
		}else{
			entityManager.remove(entityManager.merge(paciente));
		}
		
		return;
		
	}
	
	public Paciente getCpf(double cpf){
		return (Paciente) entityManager.createQuery(
				"from Paciente where cpf = :cpf")
				.setParameter("cpf", cpf)
				.getSingleResult();		
	}
	
	 public void update(Paciente paciente) {
		 
		 if(!entityManager.contains(paciente)){
	    	 
			 	Paciente pac = entityManager.find(paciente.getClass(), paciente.getId());

			 	pac.setNome(paciente.getNome());
			 	pac.setCpf(paciente.getCpf());
			 	pac.setDataNascimentoStr(paciente.getDataNascimentoStr());
		    	
			 	paciente = pac;
		    }
		       entityManager.merge(paciente);
		    
		    return;
	 }
	
	 @SuppressWarnings("unchecked")
	public List <Paciente> getAll() {
		 
	    return (List <Paciente>)entityManager.createQuery("from pacientes").getResultList();
	    
	  }
	
	 public Paciente getId(long id) {
		    return entityManager.find(Paciente.class, id);
	 }
	  
	 @PersistenceContext
	 private EntityManager entityManager;
	  
	

}
