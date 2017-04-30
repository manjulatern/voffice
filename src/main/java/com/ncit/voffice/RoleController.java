package com.ncit.voffice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncit.api.RoleService;
import com.ncit.entity.Role;
import com.ncit.model.RoleServiceImpl;

@Controller
public class RoleController {
	private static final Logger logger = LoggerFactory
			.getLogger(RoleController.class);
	RoleService roleService = new RoleServiceImpl();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public String listAll(Model model) {
		logger.info("Welcome to Roles module!");

		List<Role> roleList = roleService.getRoles();

		// sends rolelist to list view as roles
		model.addAttribute("roles", roleList);

		return "roles/list";
	}

	@RequestMapping(value = "/roles/add", method = RequestMethod.GET)
	public ModelAndView student() {

		return new ModelAndView("roles/add", "command", new Role());
	}

	@RequestMapping(value = "/roles/insert", method = RequestMethod.POST)
	public ModelAndView insertDepartment(
			@ModelAttribute("SpringWeb") Role role, Model model) {
		// Sends departmentList to view as departments

		boolean isAdded = roleService.addRole(role);
		if (isAdded) {
			List<Role> roleList = roleService.getRoles();
			model.addAttribute("roles", roleList);
			//return new ModelAndView("redirect:");
			//return new ModelAndView(new RedirectView("roles/"));
			return new ModelAndView("redirect:/roles/");
		} else {
			return new ModelAndView("roles/add", "command", new Role());
		}

	}

	@RequestMapping(value = "/roles/delete/{id}", method = RequestMethod.GET)
	public String deleteRole(@PathVariable int id, Model model,
			RedirectAttributes redir) {

		//Role role = roleService.getRoleById(id);
		boolean isDeleted = roleService.deleteRole(id);

		String msg = "";
		if (!isDeleted) {
			msg = "Role with ID: " + id + " could not be deleted";
		} else {
			msg = "Role with ID: " + id + " was deleted succesfully";
		}

		redir.addFlashAttribute("message",msg);

		return "redirect:/roles";
	}
	
	@RequestMapping(value = "/roles/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editRole(@PathVariable int id) {
		
		Role role = roleService.getRoleById(id);
		return new ModelAndView("roles/edit", "command", role);
	}
	
	@RequestMapping(value = "/roles/update", method = RequestMethod.POST)
	public ModelAndView updateRole(
			@ModelAttribute("SpringWeb") Role role, Model model) {
		// Sends departmentList to view as departments

		boolean isUpdated = roleService.updateRole(role);
		if (isUpdated) {
			List<Role> roleList = roleService.getRoles();
			model.addAttribute("roles", roleList);
			return new ModelAndView("redirect:/roles");
		} else {
			return new ModelAndView("roles/edit", "command", role);
		}

	}

 
	

}
