package com.haytech.wsbasicauth.client;

import com.haytech.wsbasicauth.endpoint.Hello;
import org.springframework.beans.factory.annotation.Value;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import java.net.MalformedURLException;

public class HelloConsumer {



    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:9090/services/hello?wsdl");
        QName qname = new QName("http://impl.endpoint.wsbasicauth.haytech.com/",
                "HelloImplService");
        Service service = Service.create(url, qname);
        Hello hello = service.getPort(Hello.class);
        /******************* Username & Password ******************************/
        Map<String, Object> reqContext = ((BindingProvider) hello).getRequestContext();
        reqContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:9090/services/hello?wsdl");
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("username", Collections.singletonList("user"));
        headers.put("password", Collections.singletonList("pass"));
        reqContext.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        /**********************************************************************/
        System.out.println(hello.sayHello("Soumitra"));
    }

}
