package com.trainings.ws.soap.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Destination")
@XmlAccessorType(XmlAccessType.FIELD)
public class Destination {

	@XmlElement(name = "id", required = true)
	private Long id;
	@XmlElement(name = "name", required = true)
	private String name;
	@XmlElement(name = "lat", required = true)
	private Float lat;
	@XmlElement(name = "lon", required = true)
	private Float lon;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}
}
