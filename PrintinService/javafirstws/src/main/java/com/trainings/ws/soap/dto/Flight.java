package com.trainings.ws.soap.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Flight")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight {

	@XmlElement(name = "id", required = true)
	Long id;
	@XmlElement(name = "destinationFrom", required = true)
	Destination destinationFrom;
	@XmlElement(name = "destinationTo", required = true)
	Destination destinationTo;
	@XmlElement(name = "dateOfDeparture", required = true)
	Date dateOfDeparture;
	@XmlElement(name = "distance", required = true)
	Double distance;
	@XmlElement(name = "price", required = true)
	Double price;
	@XmlElement(name = "seats", required = true)
	Integer seats;
	@XmlElement(name = "name", required = true)
	String name;

	public Long getId() {
		return id;
	}

	public Destination getDestinationFrom() {
		return destinationFrom;
	}

	public void setDestinationFrom(Destination destinationFrom) {
		this.destinationFrom = destinationFrom;
	}

	public Destination getDestinationTo() {
		return destinationTo;
	}

	public void setDestinationTo(Destination destinationTo) {
		this.destinationTo = destinationTo;
	}

	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
