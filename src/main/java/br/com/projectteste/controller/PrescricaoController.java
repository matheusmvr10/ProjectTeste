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
			return "Erro ao criar prescri��o:" + e.toString();
		}	
		
			return "Prescri��o criada com sucesso";
				
	}
	
	@RequestMapping(value="/deletePrescricao")
	@ResponseBody
	public String deletePaciente(@RequestBody Prescricao prescricao) {
		try {
			
			prescricaoDao.deletarPrescricao(prescricao);
                                 }
		catch (Exception ex) {
			return "Erro ao deletar prescri��o: " + ex.toString();
        }
        	return "Prescri��o deletada com sucesso!";
    }  
       
       
     @RequestMapping("/get-prescricao")
     @ResponseBody
     public Prescricao getId(long id) throws Exception {
    	
    	 try {
        	 Prescricao prescricao = prescricaoDao.getId(id);

        	 if(prescricao == null){
        		 throw new Exception("N�o existe");
        	 }

        	 
        	 return prescricao;
         }
         catch (Exception e) {
        	 throw new Exception("Erro ao consultar prescri��o");
         }
         
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
