
package fel.cvut.cz;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fel.cvut.cz package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ProcessEmail_QNAME = new QName("cz.cvut.fel", "processEmail");
    private final static QName _ProcessEmailResponse_QNAME = new QName("cz.cvut.fel", "processEmailResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fel.cvut.cz
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProcessEmail }
     * 
     */
    public ProcessEmail createProcessEmail() {
        return new ProcessEmail();
    }

    /**
     * Create an instance of {@link ProcessEmailResponse }
     * 
     */
    public ProcessEmailResponse createProcessEmailResponse() {
        return new ProcessEmailResponse();
    }

    /**
     * Create an instance of {@link SendEmailResponse }
     * 
     */
    public SendEmailResponse createSendEmailResponse() {
        return new SendEmailResponse();
    }

    /**
     * Create an instance of {@link Email }
     * 
     */
    public Email createEmail() {
        return new Email();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link SendEmailRequest }
     * 
     */
    public SendEmailRequest createSendEmailRequest() {
        return new SendEmailRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessEmail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "cz.cvut.fel", name = "processEmail")
    public JAXBElement<ProcessEmail> createProcessEmail(ProcessEmail value) {
        return new JAXBElement<ProcessEmail>(_ProcessEmail_QNAME, ProcessEmail.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessEmailResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "cz.cvut.fel", name = "processEmailResponse")
    public JAXBElement<ProcessEmailResponse> createProcessEmailResponse(ProcessEmailResponse value) {
        return new JAXBElement<ProcessEmailResponse>(_ProcessEmailResponse_QNAME, ProcessEmailResponse.class, null, value);
    }

}
