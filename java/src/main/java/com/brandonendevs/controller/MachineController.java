package com.brandonendevs.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;


import com.brandonendevs.dao.MachineDAO;
import com.brandonendevs.dao.UserDAO;
import com.brandonendevs.model.Landmark;
import com.brandonendevs.model.Machine;

import java.security.Principal;
import java.util.List;


@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class MachineController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	MachineDAO dao;
	
	
	@RequestMapping(path = "/machines", method = RequestMethod.GET)
	public List<Machine> getAllMachines() {

		List<Machine> findAllMachines = dao.listAllMachines();
		return findAllMachines;

	}
	
	
}
