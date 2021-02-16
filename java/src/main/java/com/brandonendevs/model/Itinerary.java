package com.brandonendevs.model;

import java.time.LocalDate;

public class Itinerary {
	
	private String name;
	private String startPoint;
	private LocalDate date;
	private double latitude;
	private double longitude;
	private int ItineraryId;
	private long userId;
	private long landmarkId;
	
	
	
	public Itinerary(int ItineraryId, int userId, int landmarkId) {
		this.ItineraryId = ItineraryId;
		this.userId = userId;
		this.landmarkId = landmarkId;
	}
	
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getItineraryId() {
		return ItineraryId;
	}

	public void setItineraryId(int itineraryId) {
		ItineraryId = itineraryId;
	}

	

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getLandmarkId() {
		return landmarkId;
	}

	public void setLandmarkId(long landmarkId) {
		this.landmarkId = landmarkId;
	}

	public void setLandmarkId(int landmarkId) {
		this.landmarkId = landmarkId;
	}

	public Itinerary(String name, String startPoint, LocalDate date) {
		this.name = name;
		this.startPoint = startPoint;
		this.date = date;
	}
	
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStartPoint() {
		startPoint = latitude + "," + longitude;
		return startPoint;
	}


	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
