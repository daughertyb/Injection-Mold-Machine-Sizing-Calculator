package com.brandonendevs.dao;

import java.util.List;

import com.brandonendevs.model.Machine;

public interface MachineDAO {

	List<Machine> listAllMachines();

	List<Machine> getMinMachines(int width, int height, int stack, int shotSize);

}
