package br.com.projectteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projectteste.dao.PrescricaoDao;
import br.com.projectteste.entity.Prescricao;

@Controller
public class PrescricaoController {
	
	@RequestMapping(value="/createPrescricao")
	@ResponseBody
	public String createPrescricao(@RequestBody Prescricao prescricao){
		
		try {
			
			prescricaoDao.createPrescricao(prescricao);
			
			
		} catch (Exception e) {
			return "Erro ao criar prescrição:" + e.toString();
		}	
		
			return "Prescrição criada com sucesso";
				
	}
	
	@RequestMapping(value="/deletePrescricao")
	@ResponseBody
	public String deletePaciente(@RequestBody Prescricao prescricao) {
		try {
			
			prescricaoDao.deletarPrescricao(prescricao);
                                 }
		catch (Exception ex) {
			return "Erro ao deletar prescrição: " + ex.toString();
        }
        	return "Prescrição deletada com sucesso!";
    }  
       
       
     @RequestMapping("/get-prescricao")
     @ResponseBody
     public String getId(long id) {
    	 String prescricaoId;
         try {
        	 Prescricao prescricao = prescricaoDao.getId(id);
        	 prescricaoId = String.valueOf(prescricao.getId());
         }
         catch (Exception e) {
        	 return "Prescrição não existe: " + e.toString();
         }
         	 return "Prescrição exite: " +prescricaoId;
         }
                                
         
         
         
    @RequestMapping(value="/updatePrescricao")
    @ResponseBody
    public String updateNome(@RequestBody Prescricao prescricao) {
    	 try {
    		 
    		 	prescricaoDao.update(prescricao);
             }
         catch (Exception ex) {
        	return "Error updating the user: " + ex.toString();
         }
            return "User succesfully updated!";
     } 
                 
    @Autowired
	private PrescricaoDao prescricaoDao;
}
