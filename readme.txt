Implement a RESTful service and using an API allow the users to manage these resources:

Destination
Flight
Reservation
The service has to fulfil the following:

Single entry point - access to the / resource returns the list of the available resources. Each resource returns links to other resources.
Only authorised person can manage the list of the flights.
The reservation may be created and canceled, not changed. The access to the reservation is protected by the password, which is generated when the reservation is created. The administrator may access all reservations.
The list of flights may be ordered by departure date, the parameter is handed over using the HTTP header. Both ASC and DESC are supported
The list of the flights may be filtered using from-to, the filter is handed over using a HTTP header.
The list of the flights may be paginated using the HTTP headers.
The list of destinations may be sorted automatically according the name of the destination, supports both ASC and DESC, the parameter is passed using the HTTP header.
Only the unpaid reservation may be deleted. When invoking deleting of the paid reservation the service returns HTTP error 400.
The reservation may be paid (the POST method to the resource /reservation/reservation-id/payment). The payment is invoked by pressing the payment button at the client. The parameter is the number of the card (any number).
The whole airline service supports the content negotiation, either JSON or XML is returned based on the HTTP header used.
The resource / returns the client in XHTML
The client displays the distance of the destinations.
The current number of clients connected to the server is displayed in each client window.
The paid reservation allows the user to print the e-ticket

1) stiahnut http://dev.mysql.com/downloads/installer/
2) vybrat custom instalaciu a nainstalovat:
    a) MySqlServers - najnovsi MySQL Server
    b) Applications - MySQL Workbench
    c) MysQL Connectors - Connector/J

ked mas vytvorene user a schemu tak nic viac netreba cez http://localhost:8080/semestral-project-0.0.1-SNAPSHOT/fill by sa ti mali vsetky tabulky vygenerovat a naplnit....
 
stiahnut najnovsi wildfly (10.1.0.Final) http://wildfly.org/downloads/

- na testovanie REST ja pouzivam v chrome Advanced REST Client

- pokial nechces aby sa pri kazdom restarte serveru vymazala databaza zmen si v application.properties spring.jpa.hibernate.ddl-auto = create na spring.jpa.hibernate.ddl-auto = update

sample data:
cez Advanced REST Client sa cez post daju vytvarat nove instancie napr.

vytvorenie rezervacie na let s ID1
{
"flight": {
"id": 1
},
"seats": 1,
"state": "NEW"
}

obdobne vytvorenie letu...
{
"from": {
"id": 1,
"name": "Rome",
"lat": 45.12,
"lon": 39.12
},
"to": {
"id": 2,
"name": "Prague",
"lat": 40.14,
"lon": 32.47
},
"dateOfDeparture": 1479394963990,
"distance": 459.07,
"price": 999.99,
"seats": 390,
"name": "flight2"
}


REST SECURITY
- 1) nakonfigurovat v jave
- 2) cez Advanced Rest Client treba ist na
http://localhost:8080/semestral-project-0.0.1-SNAPSHOT/login (POST metoda)
treba pridat DATA FORM username a password....
- 3) sme autentifikovany a mozme vyuzivat zabezpecene URLs
- 4) treba mat nainstalovany ARC cookie exchange a zapnute XHR v advanced rest client !!!

KOMUNIKACIA S DALSIMI WEB SERVICES
javafirstws (treba rozbehat napr. na tomcate port 8081) - /reservation/print/1 - vytlaci letenku
wsdlfirstws (tiez bezi na porte 8081) treba k nej zapnut AOSJmsConsumer a ActiveMQ. Do activeMQ sa budu ukladat spravy consumer kazdych 5 sekund prijme spravu (pri vytlaceni letenky posle email)
