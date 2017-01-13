package fel.cvut.cz;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2017-01-11T16:39:22.390+01:00
 * Generated source version: 3.0.2
 * 
 */
@WebServiceClient(name = "PrintingServiceService", 
                  wsdlLocation = "file:/C:/dev/wsdlfirstws/src/main/webapp/WEB-INF/wsdl/TopDownPrintingService.wsdl",
                  targetNamespace = "cz.cvut.fel") 
public class PrintingServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("cz.cvut.fel", "PrintingServiceService");
    public final static QName PrintingServicePort = new QName("cz.cvut.fel", "PrintingServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/dev/wsdlfirstws/src/main/webapp/WEB-INF/wsdl/TopDownPrintingService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(PrintingServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/dev/wsdlfirstws/src/main/webapp/WEB-INF/wsdl/TopDownPrintingService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public PrintingServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public PrintingServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PrintingServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PrintingServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PrintingServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public PrintingServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns PrintingService
     */
    @WebEndpoint(name = "PrintingServicePort")
    public PrintingService getPrintingServicePort() {
        return super.getPort(PrintingServicePort, PrintingService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PrintingService
     */
    @WebEndpoint(name = "PrintingServicePort")
    public PrintingService getPrintingServicePort(WebServiceFeature... features) {
        return super.getPort(PrintingServicePort, PrintingService.class, features);
    }

}
