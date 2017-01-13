package com.trainings.ws.soap.dto;

import javax.xml.bind.annotation.XmlType;
import javax.activation.DataHandler;

@XmlType(name = "PrintingServiceResponse")
public class PrintingServiceResponse {

	private boolean result;
	private DataHandler file;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	public DataHandler getFile() {
		return file;
	}

	public void setFile(DataHandler file) {
		this.file = file;
	}
}
