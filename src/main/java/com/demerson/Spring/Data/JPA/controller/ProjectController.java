package com.demerson.Spring.Data.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demerson.Spring.Data.JPA.entity.Employee;
import com.demerson.Spring.Data.JPA.entity.Project;
import com.demerson.Spring.Data.JPA.repository.ClientRepository;
import com.demerson.Spring.Data.JPA.repository.EmployeeRepository;
import com.demerson.Spring.Data.JPA.repository.ProjectRepository;

@Controller
@RequestMapping("/projetos")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("projeto/home");
		modelAndView.addObject("projetos", projectRepository.findAll());
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("projeto/detalhes");
		modelAndView.addObject("projeto", projectRepository.getReferenceById(id));
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView newClient() {
		ModelAndView modelAndView = new ModelAndView("projeto/formulario");
		
		modelAndView.addObject("projeto", new Project());
		modelAndView.addObject("clientes", clientRepository.findAll());
		modelAndView.addObject("lideres", employeeRepository.buscarPorCargo("Gerente"));
		modelAndView.addObject("funcionarios", employeeRepository.buscarPorCargoExceto("Gerente"));
		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("projeto/formulario");
		
		modelAndView.addObject("projeto", projectRepository.getReferenceById(id));	
		modelAndView.addObject("clientes", clientRepository.findAll());
		modelAndView.addObject("lideres", employeeRepository.buscarPorCargo("Gerente"));
		modelAndView.addObject("funcionarios", employeeRepository.buscarPorCargoExceto("Gerente"));
		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String saveByEdit(Project project) {
		projectRepository.save(project);
		return "redirect:/projetos";
	}

	@GetMapping("/{id}/excluir")
	public String delete(@PathVariable Long id) {
		projectRepository.deleteById(id);
		return "redirect:/projetos";
	}

}
