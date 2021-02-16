package com.brandonendevs.model;

public class Machine {

	private int machineId;
	private String brand;
	private String model;
	private int tonnage;
	private int tieBarHorizontal;
	private int tieBarVertical;
	private int plattenHorizontal;
	private int plattenVertical;
	private int moldHeightMin;
	private int moldHeightMax;
	private int shotSizePe;
	private int shotSizePs;
	private String dateAdded;
	
	//constructor
	public Machine(int machineId, String brand, String model, int tonnage, int tieBarHorizontal, int tieBarVertical,
			int plattenHorizontal, int plattenVertical, int moldHeightMin, int moldHeightMax, int shotSizePe,
			int shotSizePs) {
		this.machineId = machineId;
		this.brand = brand;
		this.model = model;
		this.tonnage = tonnage;
		this.tieBarHorizontal = tieBarHorizontal;
		this.tieBarVertical = tieBarVertical;
		this.plattenHorizontal = plattenHorizontal;
		this.plattenVertical = plattenVertical;
		this.moldHeightMin = moldHeightMin;
		this.moldHeightMax = moldHeightMax;
		this.shotSizePe = shotSizePe;
		this.shotSizePs = shotSizePs;
		this.dateAdded = "CURRENT_TIMESTAMP";
	}

	public Machine() {
		
	}

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getTonnage() {
		return tonnage;
	}

	public void setTonnage(int tonnage) {
		this.tonnage = tonnage;
	}

	public int getTieBarHorizontal() {
		return tieBarHorizontal;
	}

	public void setTieBarHorizontal(int tieBarHorizontal) {
		this.tieBarHorizontal = tieBarHorizontal;
	}

	public int getTieBarVertical() {
		return tieBarVertical;
	}

	public void setTieBarVertical(int tieBarVertical) {
		this.tieBarVertical = tieBarVertical;
	}

	public int getPlattenHorizontal() {
		return plattenHorizontal;
	}

	public void setPlattenHorizontal(int plattenHorizontal) {
		this.plattenHorizontal = plattenHorizontal;
	}

	public int getPlattenVertical() {
		return plattenVertical;
	}

	public void setPlattenVertical(int plattenVertical) {
		this.plattenVertical = plattenVertical;
	}

	public int getMoldHeightMin() {
		return moldHeightMin;
	}

	public void setMoldHeightMin(int moldHeightMin) {
		this.moldHeightMin = moldHeightMin;
	}

	public int getMoldHeightMax() {
		return moldHeightMax;
	}

	public void setMoldHeightMax(int moldHeightMax) {
		this.moldHeightMax = moldHeightMax;
	}

	public int getShotSizePe() {
		return shotSizePe;
	}

	public void setShotSizePe(int shotSizePe) {
		this.shotSizePe = shotSizePe;
	}

	public int getShotSizePs() {
		return shotSizePs;
	}

	public void setShotSizePs(int shotSizePs) {
		this.shotSizePs = shotSizePs;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
	
	
}
