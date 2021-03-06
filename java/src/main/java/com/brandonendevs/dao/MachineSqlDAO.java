package com.brandonendevs.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.brandonendevs.model.Machine;

@Component
public class MachineSqlDAO implements MachineDAO {

	private JdbcTemplate jdbcTemplate;

	public MachineSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Machine> listAllMachines() {
		List<Machine> machines = new ArrayList<Machine>();
		String sql = "SELECT * FROM machine";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Machine machine = mapRowToMachine(results);
			machines.add(machine);
		}

		return machines;
	}
	
	public List<Machine> getMinMachines(int width, int height, int stack, int shotSize) {
		
		return null;
	}

	private Machine mapRowToMachine(SqlRowSet rs) {
		Machine machine = new Machine();
		machine.setMachineId(rs.getInt("machine_id"));
		machine.setBrand(rs.getString("brand"));
		machine.setModel(rs.getString("model"));
		machine.setTonnage(rs.getInt("tonnage"));
		machine.setTieBarHorizontal(rs.getInt("tie_bar_horizontal"));
		machine.setTieBarVertical(rs.getInt("tie_bar_vertical"));
		machine.setPlattenHorizontal(rs.getInt("platten_horizontal"));
		machine.setPlattenVertical(rs.getInt("platten_vertical"));
		machine.setMoldHeightMin(rs.getInt("mold_height_min"));
		machine.setMoldHeightMax(rs.getInt("mold_height_max"));
		machine.setShotSizePe(rs.getInt("shot_size_pe"));
		machine.setShotSizePs(rs.getInt("shot_size_ps"));
		
		machine.setDateAdded(rs.getString("date_added"));
		
		return machine;
	}

	
}
