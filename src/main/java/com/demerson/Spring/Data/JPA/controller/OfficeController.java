package com.demerson.Spring.Data.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demerson.Spring.Data.JPA.entity.Client;
import com.demerson.Spring.Data.JPA.entity.Office;
import com.demerson.Spring.Data.JPA.entity.UF;
import com.demerson.Spring.Data.JPA.repository.OfficeRepository;

@Controller
@RequestMapping("/cargos")
public class OfficeController {

	@Autowired
	private OfficeRepository officeRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("cargo/home");
		modelAndView.addObject("cargos", officeRepository.findAll());
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView newClient() {
		ModelAndView modelAndView = new ModelAndView("cargo/formulario");
		modelAndView.addObject("cargo", new Client());
		modelAndView.addObject("ufs", UF.values());
		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cargo/formulario");
		modelAndView.addObject("cargo", officeRepository.getReferenceById(id));
		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String saveByEdit(Office office) {
		officeRepository.save(office);
		return "redirect:/cargos";
	}

	@GetMapping("/{id}/excluir")
	public String delete(@PathVariable Long id) {
		officeRepository.deleteById(id);
		return "redirect:/cargos";
	}

}
