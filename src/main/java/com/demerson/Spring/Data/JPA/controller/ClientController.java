package com.demerson.Spring.Data.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demerson.Spring.Data.JPA.entity.Client;
import com.demerson.Spring.Data.JPA.entity.UF;
import com.demerson.Spring.Data.JPA.repository.ClientRepository;

@Controller
@RequestMapping("/clientes")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("cliente/home");
		modelAndView.addObject("clientes", clientRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView detalhes(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cliente/detalhes");
		modelAndView.addObject("cliente", clientRepository.getReferenceById(id));
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView newClient() {
		ModelAndView modelAndView = new ModelAndView("cliente/formulario");
		modelAndView.addObject("cliente", new Client());
		modelAndView.addObject("ufs", UF.values());
		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cliente/formulario");
		modelAndView.addObject("cliente", clientRepository.getReferenceById(id));
		modelAndView.addObject("ufs", UF.values());
		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String saveByEdit(Client client) {
		clientRepository.save(client);
		return "redirect:/clientes";
	}

	@GetMapping("/{id}/excluir")
	public String delete(@PathVariable Long id) {
		clientRepository.deleteById(id);
		return "redirect:/clientes";
	}
}
