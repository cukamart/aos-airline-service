package cz.cvut.fel.aos.model;


import com.trainings.ws.soap.PrintingServiceRequest;
import com.trainings.ws.soap.PrintingServiceResponse;
import com.trainings.ws.soap.PrintingServiceService;
import cz.cvut.fel.aos.data.entities.Flight;
import cz.cvut.fel.aos.data.entities.Reservation;
import cz.cvut.fel.aos.data.entities.State;
import fel.cvut.cz.Email;
import fel.cvut.cz.SendEmailRequest;
import fel.cvut.cz.SendEmailResponse;
import fel.cvut.cz.User;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Logika rezervacie listka.
 */
@Component
public class ReservationLogic {

    /**
     * Zisti ci sa da kupit listok
     * @param allReservations - vsetky rezervacie
     * @param newReservation - nova rezervacia (zistuje sa ci moze prejst)
     * @return true - let je plny listok sa kupit neda, false let nieje plne obsadeny listok sa kupit da
     */
    public boolean isFlightFull(List<Reservation> allReservations, Reservation newReservation, int maxSeats) {
        maxSeats -= newReservation.getSeats();

        maxSeats -= getReservedSeats(allReservations, newReservation);

        return (maxSeats < 0) ? true : false;
    }

    /**
     * Vypocita pocet obsadenych sedadiel k danemu letu
     * @param allReservations - vsetky rezervacie
     * @param newReservation - rezervacia k danemu letu
     * @return int - vrati pocet obsadenych sedadiel k danemu letu
     */
    public int getReservedSeats(List<Reservation> allReservations, Reservation newReservation) {
        int reserved = 0;

        for (Reservation reservation : allReservations) {
            if (!reservation.getState().equals(State.CANCELED)) { // ak letenka nieje stornovana
                if (newReservation.getFlight().getId().equals(reservation.getFlight().getId())) { // ak je to spravny let
                    reserved += reservation.getSeats();
                }
            }
        }
        return reserved;
    }

    /**
     * Vrati pocet miest na sedenie pre dany let.
     * @param newReservation let na ktory si chceme kupit listok (mame len ID)
     * @param flights vsetky lety
     * @return null - ak let neexistuje inak vrati maximalne pocet sedadiel pre dany let
     */
    public Integer getNumberOfSeats(Reservation newReservation, List<Flight> flights) {
        for (Flight flight : flights) {
            if (flight.getId().equals(newReservation.getFlight().getId())) {
                return flight.getSeats();
            }
        }
        return null;
    }

    /**
     * Vytlaci listok, komunikuje s printing service.
     * @param reservation - rezervacia ktoru chceme vytlacit
     * @return - bytearray reprezentujuci textovy subor
     */
    public byte[] printTicket(Reservation reservation) {
        PrintingServiceRequest request = new PrintingServiceRequest();
        request.setReservation(createRequest(reservation));

        PrintingServiceService printingService = new PrintingServiceService();
        PrintingServiceResponse printTicketResponse = printingService.getPrintingServicePort().processPayment(request);

        return printTicketResponse.getFile();
    }

    private com.trainings.ws.soap.Reservation createRequest (Reservation r) {
        com.trainings.ws.soap.Reservation res = new com.trainings.ws.soap.Reservation();

        res.setCreated(convertDate(r.getCreated()));
        res.setId(r.getId());
        res.setPassword(r.getPassword());
        res.setSeats(r.getSeats());

        com.trainings.ws.soap.Flight flight = new com.trainings.ws.soap.Flight();
        flight.setDateOfDeparture(convertDate(r.getFlight().getDateOfDeparture()));
        flight.setDistance(r.getFlight().getDistance());
        flight.setId(r.getFlight().getId());
        flight.setName(r.getFlight().getName());
        flight.setPrice(r.getFlight().getPrice());
        flight.setSeats(r.getFlight().getSeats());
        flight.setDestinationFrom(mapDestination(r.getFlight().getDestinationFrom()));
        flight.setDestinationTo(mapDestination(r.getFlight().getDestinationTo()));
        res.setFlight(flight);

        return res;
    }


    private com.trainings.ws.soap.Destination mapDestination(cz.cvut.fel.aos.data.entities.Destination d) {
        com.trainings.ws.soap.Destination des = new com.trainings.ws.soap.Destination();

        des.setId(d.getId());
        BigDecimal lat = new BigDecimal(d.getLat());
        BigDecimal lon = new BigDecimal(d.getLon());
        des.setLat(lat.floatValue());
        des.setLon(lon.floatValue());
        des.setName(d.getName());

        return des;
    }

    private XMLGregorianCalendar convertDate(Date date) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {

        }
        return null;
    }

    public void sendEmail(Reservation reservation) {
        User receiver = new User();
        receiver.setId(1);
        receiver.setEmailAddress("cuk@gmail.com");

        User sender = new User();
        sender.setId(2);
        sender.setEmailAddress("marcimat@fel.cvut.cz");

        SendEmailRequest request = new SendEmailRequest();
        request.setEmail(new Email());
        request.getEmail().setId(1);
        request.getEmail().setText(reservation.toString());
        request.getEmail().setSubject("test JMS connection");
        request.getEmail().setReceiver(receiver);
        request.getEmail().setSender(sender);

        fel.cvut.cz.PrintingServiceService emailService = new fel.cvut.cz.PrintingServiceService();
        SendEmailResponse response = emailService.getPrintingServicePort().processEmail(request);
    }
}
