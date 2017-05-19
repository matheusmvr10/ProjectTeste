package br.com.projectteste.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.projectteste.controller.MedicamentoController;
import br.com.projectteste.controller.PacienteController;
import br.com.projectteste.controller.PrescricaoController;
import br.com.projectteste.dao.MedicamentoDao;
import br.com.projectteste.dao.PacienteDao;
import br.com.projectteste.dao.PrescricaoDao;
import br.com.projectteste.entity.Medicamento;
import br.com.projectteste.entity.Paciente;
import br.com.projectteste.entity.Prescricao;

@Configuration
@EnableAutoConfiguration
//@ComponentScan(basePackageClasses = PacienteController.class)
@ComponentScan(basePackageClasses={PacienteDao.class,PacienteController.class,MedicamentoDao.class,MedicamentoController.class,
		PrescricaoDao.class,PrescricaoController.class})
@Controller
@EntityScan(basePackageClasses={Prescricao.class, Paciente.class, Medicamento.class})
public class MainApplication {
	
	@ResponseBody
	@RequestMapping("/")
	String entry(){
		return "Meu Spring";
	}
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
