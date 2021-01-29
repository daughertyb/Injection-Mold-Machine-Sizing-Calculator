package com.brandonendeavors.dao;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.brandonendeavors.model.Machine;

@Component
public class MachineSqlDAO implements MachineDAO {

	private JdbcTemplate jdbcTemplate;

	public MachineSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Machine> listAllMachines() {
		List<Machine> machines = new ArrayList<Machine>();
		String sql = "select * from machine";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Machine machine = mapRowToMachine(results);
			machines.add(machine);
		}

		return machines;
	}


	
	
	
	
	
	
	private Machine mapRowToMachine(SqlRowSet rs) {
		Machine machine = new Machine();
		machine.setMachineId(rs.getInt("machine_id"));
		machine.setUsername(rs.getString("username"));
		machine.setPassword(rs.getString("password_hash"));
		machine.setActivated(true);
		return machine;
	}
}
