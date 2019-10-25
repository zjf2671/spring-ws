package com.zy.controller;

import com.zy.ws.GetCountryResponse;
import com.zy.ws.client.WsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Harry
 */
@RestController
public class IndexController {
    @Autowired
    private WsClient wsClient;

    @RequestMapping("callws")
    public Object callWs() {
        GetCountryResponse response = wsClient.getCountry("hello");
        return response.getCountry();
    }
}