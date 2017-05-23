package br.com.projectteste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projectteste.dao.PacienteDao;
import br.com.projectteste.entity.Paciente;

@Controller
public class PacienteController {
	
	
	@RequestMapping(value="/createPaciente")
	@ResponseBody
	public String createPaciente(@RequestBody Paciente paciente){
		
		try {
			pacienteDao.createPaciente(paciente);
			
			
		} catch (Exception e) {
			return "Erro ao criar paciente:" + e.toString();
		}	
		
			return "Usuário criado com sucesso";
				
	}
	
	@RequestMapping(value="/deletePaciente")
	@ResponseBody
	public String deletePaciente(long id) {
		try {
			Paciente paciente = new Paciente();
			paciente.setId(id);
	        pacienteDao.deletePaciente(paciente);
                                 }
		catch (Exception ex) {
			return "Erro ao deletar paciente: " + ex.toString();
        }
        	return "Paciente deletado com sucesso!";
    }  
       
       
     @RequestMapping("/get-cpf")
     @ResponseBody
     public Paciente getCpf(double cpf) throws Exception {
    	
         try {
        	 Paciente paciente = pacienteDao.getCpf(cpf);
        	 
        	 if(paciente == null){
        		 throw new Exception("Não existe");
        	 }

             return paciente;
             
         }
         catch (Exception e) {
        	 throw new Exception("Erro ao consultar paciente");
         }
         	
     }
                                
         
         
         
    @RequestMapping(value="/updatePaciente")
    @ResponseBody
    public String updateNome(@RequestBody Paciente paciente) {
    	 try {
        		pacienteDao.update(paciente);
             }
         catch (Exception ex) {
        	return "Error updating the user: " + ex.toString();
         }
            return "User succesfully updated!";
     } 
                              
   

         @Autowired
         private PacienteDao pacienteDao;
         
}