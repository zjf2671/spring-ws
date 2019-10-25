package com.zy.ws.client;

import com.zy.ws.GetCountryRequest;
import com.zy.ws.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 * @author Harry
 */
public class WsClient extends WebServiceGatewaySupport {

    public GetCountryResponse getCountry(String name) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);
        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
            getDefaultUri(), request);
        return response;
    }

}