package br.com.projectteste.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projectteste.entity.Medicamento;
import br.com.projectteste.entity.Paciente;

@Repository
@Transactional
public class MedicamentoDao {
	
	
	public void createMedicamento(Medicamento medicamento){
		entityManager.persist(medicamento);
		return;
	}
	
	
	public void delete(Medicamento medicamento) {
	    if (entityManager.contains(medicamento))
	      entityManager.remove(medicamento);
	    else
	      entityManager.remove(entityManager.merge(medicamento));
	    return;
	  }
	
	
	public void update(Medicamento medicamento) {
		    if(!entityManager.contains(medicamento)){
		    	 
		    	Medicamento med = entityManager.find(medicamento.getClass(), medicamento.getId());
		    	med.setNomeMedicamento(medicamento.getNomeMedicamento());
		    	medicamento = med;
		    }
		       entityManager.merge(medicamento);
		    
		    return;
		  }
	
	 
	
	public Paciente getByNomeMedicamento(String nomeMedicamento){
		return (Paciente) entityManager.createQuery(
				"from Medicamento where nome_medicamento = :nomeMedicamento")
				.setParameter("nomeMedicamento", nomeMedicamento)
				.getSingleResult();		
	}

	public Medicamento getById(long id) {
		return entityManager.find(Medicamento.class, id);
	}

	@SuppressWarnings("unchecked")
	public List <Medicamento> getAll() {
		return entityManager.createQuery("from Medicamento").getResultList();
	}
	  
	@PersistenceContext
	private EntityManager entityManager;

}
