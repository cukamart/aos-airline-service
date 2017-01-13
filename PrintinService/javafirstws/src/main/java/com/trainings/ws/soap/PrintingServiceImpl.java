package com.trainings.ws.soap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import com.trainings.ws.soap.dto.PrintingServiceRequest;
import com.trainings.ws.soap.dto.PrintingServiceResponse;

public class PrintingServiceImpl implements PrintingService {

	@Override
	public PrintingServiceResponse processPayment(PrintingServiceRequest printingServiceRequest) {

		File file = new File("./ticket.txt");

		try {
			file.createNewFile();
			// Write Content
			FileWriter writer = new FileWriter(file);
			writer.write("Reservation ID: " + printingServiceRequest.getReservation().getId());
			writer.write("\n===========================================\n");
			writer.write("FLIGHT INFO\n");
			writer.write("\n\t Flight name: " + printingServiceRequest.getReservation().getFlight().getName());
			writer.write("\n\t From: " + printingServiceRequest.getReservation().getFlight().getDestinationFrom().getName());
			writer.write("\n\t To: " + printingServiceRequest.getReservation().getFlight().getDestinationTo().getName());
			writer.write("\n\t Seats: " + printingServiceRequest.getReservation().getFlight().getSeats());
			writer.write("\n\t State: " + printingServiceRequest.getReservation().getState());
			writer.write("\n===========================================\n");
			writer.write("Price: " + printingServiceRequest.getReservation().getFlight().getPrice());
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		FileDataSource dataSource = new FileDataSource(file);
		DataHandler fileDataHandler = new DataHandler(dataSource);

		PrintingServiceResponse response = new PrintingServiceResponse();
		response.setResult(true);
		response.setFile(fileDataHandler);
		
		return response;
	}

}
