package com.trainings.ws.soap;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.trainings.ws.soap.dto.PrintingServiceRequest;
import com.trainings.ws.soap.dto.PrintingServiceResponse;

@WebService(name = "PrintingService")
public interface PrintingService {

	public @WebResult(name = "response") PrintingServiceResponse processPayment(
			@WebParam(name = "printingServiceRequest") PrintingServiceRequest printingServiceRequest);
}
