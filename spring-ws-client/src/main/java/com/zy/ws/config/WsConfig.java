package com.zy.ws.config;

import com.zy.ws.client.WsClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

/**
 * @author Harry
 */
@Configuration
public class WsConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.zy.ws");
        return marshaller;
    }
    @Bean
    public WsClient wsClient(Jaxb2Marshaller marshaller) {
        WsClient client = new WsClient();
        client.setDefaultUri("http://localhost:8080/ws/countries.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setMessageFactory(messageFactory());
        return client;
    }

    @Bean
    public SaajSoapMessageFactory messageFactory(){
        SaajSoapMessageFactory saajSoapMessageFactory = new SaajSoapMessageFactory();
        saajSoapMessageFactory.setSoapVersion(SoapVersion.SOAP_12);
        return saajSoapMessageFactory;
    }
}