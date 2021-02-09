package com.brandonendeavors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brandonendeavors.dao.MachineDAO;
import com.brandonendeavors.model.Machine;

@CrossOrigin
@RestController
public class MachineController {

	@Autowired
	MachineDAO machineDao;
	
	@RequestMapping(path = "/machines", method = RequestMethod.GET)
	public List<Machine> getAllMachines() {

		List<Machine> findAllMachines = machineDao.listAllMachines();
		return findAllMachines;

	}
}
