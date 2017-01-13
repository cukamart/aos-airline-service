package fel.cvut.cz;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2017-01-11T16:39:22.363+01:00
 * Generated source version: 3.0.2
 * 
 */
@WebService(targetNamespace = "cz.cvut.fel", name = "PrintingService")
@XmlSeeAlso({ObjectFactory.class})
public interface PrintingService {

    @WebMethod
    @RequestWrapper(localName = "processEmail", targetNamespace = "cz.cvut.fel", className = "fel.cvut.cz.ProcessEmail")
    @ResponseWrapper(localName = "processEmailResponse", targetNamespace = "cz.cvut.fel", className = "fel.cvut.cz.ProcessEmailResponse")
    @WebResult(name = "response", targetNamespace = "")
    public fel.cvut.cz.SendEmailResponse processEmail(
        @WebParam(name = "request", targetNamespace = "")
        fel.cvut.cz.SendEmailRequest request
    );
}
