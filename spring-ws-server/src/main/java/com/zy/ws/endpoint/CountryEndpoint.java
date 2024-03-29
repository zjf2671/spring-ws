package com.zy.ws.endpoint;

import com.zy.ws.Country;
import com.zy.ws.Currency;
import com.zy.ws.GetCountryRequest;
import com.zy.ws.GetCountryResponse;
import com.zy.ws.data.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author Harry
 */
@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://www.zy.com/ws";

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        Country poland = new Country();
        poland.setName("Poland-" + request.getName());
        poland.setCapital("harry");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);
        response.setCountry(poland);
//        response.setCountry(countryRepository.findCountry(request.getName()));
        return response;
    }
}