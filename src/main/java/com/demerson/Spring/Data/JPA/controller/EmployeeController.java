package com.demerson.Spring.Data.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demerson.Spring.Data.JPA.entity.Employee;
import com.demerson.Spring.Data.JPA.entity.UF;
import com.demerson.Spring.Data.JPA.repository.EmployeeRepository;

@Controller
@RequestMapping("/funcionarios")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("funcionario/home");
		modelAndView.addObject("funcionarios", employeeRepository.findAll());
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("funcionario/detalhes");
		modelAndView.addObject("funcionario", employeeRepository.getReferenceById(id));
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView newClient() {
		ModelAndView modelAndView = new ModelAndView("funcionario/formulario");
		modelAndView.addObject("funcionario", new Employee());
		modelAndView.addObject("ufs", UF.values());
		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("funcionario/formulario");
		modelAndView.addObject("funcionario", employeeRepository.getReferenceById(id));
		modelAndView.addObject("ufs", UF.values());
		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String saveByEdit(Employee employee) {
		employeeRepository.save(employee);
		return "redirect:/funcionarios";
	}

	@GetMapping("/{id}/excluir")
	public String delete(@PathVariable Long id) {
		employeeRepository.deleteById(id);
		return "redirect:/funcionarios";
	}

}
