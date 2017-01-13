package com.trainings.ws.soap.dto;

import java.util.Date;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation {

	@XmlElement(name = "id", required = true)
	Long id;
	@XmlElement(name = "flight", required = true)
	Flight flight;
	@XmlElement(name = "created", required = true)
	Date created;
	@XmlElement(name = "password", required = true)
	String password;
	@XmlElement(name = "seats", required = true)
	Integer seats;
	@XmlElement(name = "state", required = true)
	State state = State.NEW;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	
}
