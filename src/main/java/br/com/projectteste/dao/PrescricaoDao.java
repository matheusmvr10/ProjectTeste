package br.com.projectteste.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projectteste.entity.Medicamento;
import br.com.projectteste.entity.Prescricao;

@Repository
@Transactional
public class PrescricaoDao {

	public void createPrescricao(Prescricao prescricao){
		entityManager.persist(prescricao);
		return;
	}
	
	
	public void deletarPrescricao(Prescricao prescricao){
		if(entityManager.contains(prescricao)){
			entityManager.remove(prescricao);
								
		}else{
			entityManager.remove(entityManager.merge(prescricao));
		}
		
		return;
		
	}

	 public void update(Prescricao prescricao) {
		 if(!entityManager.contains(prescricao)){
	    	 
			 	Prescricao pre = entityManager.find(prescricao.getClass(), prescricao.getId());
			 	
			 	pre.setNome(prescricao.getNome());
		    	pre.setFrequencia(prescricao.getFrequencia());
		    	pre.setDose(prescricao.getDose());
		    	pre.setdataPrescricaoStr(prescricao.getdataPrescricaoStr());
		    	
		    	prescricao = pre;
		    }
		       entityManager.merge(prescricao);
		    return;
	 }
	
	public Prescricao getId(double id){
		return (Prescricao) entityManager.createQuery(
				"from Prescricao where id = :id")
				.setParameter("id", id)
				.getSingleResult();		
	}
	
	
	 @SuppressWarnings("unchecked")
	 public List getAll() {
	    return entityManager.createQuery("from Prescricao").getResultList();
	  }
	
	 public Prescricao getId(long id) {
		    return entityManager.find(Prescricao.class, id);
	 }	  
	  
	
	 @PersistenceContext
	 private EntityManager entityManager;
	  
	 
}
