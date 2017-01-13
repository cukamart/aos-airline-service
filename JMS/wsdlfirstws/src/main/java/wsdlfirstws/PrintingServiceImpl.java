package wsdlfirstws;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import fel.cvut.cz.Email;
import fel.cvut.cz.PrintingService;
import fel.cvut.cz.SendEmailRequest;
import fel.cvut.cz.SendEmailResponse;

public class PrintingServiceImpl implements PrintingService {

	@Override
	public SendEmailResponse processEmail(SendEmailRequest request) {
		SendEmailResponse response = new SendEmailResponse();

		if (request.getEmail() != null) {
			response.setResult(true);
			sendToQueue(request.getEmail());
		} else {
			response.setResult(false);
		}

		return response;
	}

	private void sendToQueue(Email email) {
		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					ActiveMQConnection.DEFAULT_BROKER_URL);
			Connection connection = connectionFactory.createConnection();
			connection.start();

			Session qSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = qSession.createQueue("TEST");

			MessageProducer producer = qSession.createProducer(destination);

			ObjectMessage message = qSession.createObjectMessage();
			message.setObject(email);

			producer.send(message);

			qSession.close();
			connection.close();
		} catch (Exception e) {

		}
	}
}
