package br.com.projectteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projectteste.dao.MedicamentoDao;
import br.com.projectteste.entity.Medicamento;

@Controller
public class MedicamentoController {
	
	@RequestMapping(value="/createMedicamento")
	@ResponseBody
	public String createMedicamento(@RequestBody Medicamento medicamento){
		
		try {
			
			medicamentoDao.createMedicamento(medicamento);
			
			
		} catch (Exception e) {
			return "Erro ao criar medicamento:" + e.toString();
		}	
		
			return "Medicamento criado com sucesso";
				
	}
	
	@RequestMapping(value="/deleteMedicamento")
	@ResponseBody
	public String deleteMedicamento(@RequestBody Medicamento medicamento) {
		try {
			
			medicamentoDao.delete(medicamento);
                                 }
		catch (Exception ex) {
			return "Erro ao deletar paciente: " + ex.toString();
        }
        	return "Paciente deletado com sucesso!";
        }
	
	 @RequestMapping(value="/updateMedicamento")
	 @ResponseBody
	 public String updateNome(@RequestBody Medicamento medicamento) {
	     try {
	        medicamentoDao.update(medicamento);
	     }
	     catch (Exception ex) {
	       	return "Erro ao fazer updating do: " + ex.toString();
	     }
	        return "Meciamento atualizado com sucesso!";
	     } 
	 
	 @RequestMapping("/get-medicamento")
     @ResponseBody
     public Medicamento getId(long id) throws Exception {
    	 
		 try {
        	 Medicamento medicamento = medicamentoDao.getById(id);
        	 
        	 if(medicamento == null){
        		 throw new Exception("Não existe");
        	 }
        	         	 
        	 return medicamento;
         }
         catch (Exception e) {
        	 throw new Exception("Erro ao consultar medicamento");
         }
         
	 }
	 
	 
	@Autowired
    private MedicamentoDao medicamentoDao;
                          

}
