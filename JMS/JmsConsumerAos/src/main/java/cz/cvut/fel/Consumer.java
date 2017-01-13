package cz.cvut.fel;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import fel.cvut.cz.Email;

public class Consumer implements ExceptionListener {

	private static String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

	public Message getMessage() {
		try {

			// simulating processing
			Thread.sleep(1500);
			// Create a ConnectionFactory
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
			connectionFactory.setTrustAllPackages(true);

			// Create a Connection
			Connection connection = connectionFactory.createConnection();
			connection.start();
			connection.setExceptionListener(this);

			// Create a Session
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Create the destination (Topic or Queue)
			Destination destination = session.createQueue("TEST");

			// Create a MessageConsumer from the Session to the Topic or Queue
			MessageConsumer consumer = session.createConsumer(destination);

			// Wait for a message
			Message message = consumer.receive(1000);

			if (message instanceof TextMessage) {
				TextMessage textMessage = (TextMessage) message;
				String text = textMessage.getText();
				System.out.println("Received text msg: " + text);

			} else if (message instanceof ObjectMessage) {
				ObjectMessage msg = (ObjectMessage) message;
				System.out.println("Received object msg.");

				Email e = (Email) msg.getObject();
				System.out.println("Email text: " + e.getText());

			} else {
				System.out.println("Nothing to send");
			}

			consumer.close();
			session.close();
			connection.close();

			return message;
			
		} catch (Exception e) {

		}
		
		return null;
	}

	public synchronized void onException(JMSException ex) {
		System.out.println("JMS Exception occured. Shutting down client.");
	}

}
