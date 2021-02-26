package com.brandonendevs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brandonendevs.dao.MachineDAO;
import com.brandonendevs.dao.UserDAO;
import com.brandonendevs.model.Machine;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class SizingController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	MachineDAO dao;
	
	
	@RequestMapping(path = "/machines-min", method = RequestMethod.GET)
	public List<Machine> getMinMachines(@RequestParam int width, @RequestParam int height, @RequestParam int stack, @RequestParam int shotSize) {
		
		
		List<Machine> minMachines = dao.getMinMachines(width, height, stack, shotSize);
		return minMachines;

	}
	
	}
	


