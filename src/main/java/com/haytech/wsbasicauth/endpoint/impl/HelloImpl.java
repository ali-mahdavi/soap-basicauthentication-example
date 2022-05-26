package com.haytech.wsbasicauth.endpoint.impl;


import com.haytech.wsbasicauth.endpoint.Hello;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import java.util.List;
import java.util.Map;
import javax.xml.ws.handler.MessageContext;

@Component
@WebService(endpointInterface = "com.haytech.wsbasicauth.endpoint.Hello")
public class HelloImpl implements Hello {


    @Resource
    WebServiceContext context;

    @Override
    public String sayHello(String name) {
        MessageContext messageContext = context.getMessageContext();

        /**
         * get http header information
         */
        Map<?, ?> httpHeaders = (Map<?, ?>) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        List<?> users = (List<?>) httpHeaders.get("username");
        List<?> passwords = (List<?>) httpHeaders.get("password");

        /**
         * retrieve username and password information from http headers
         */
        String username = "";
        String password = "";

        if (users != null && !users.isEmpty()) {
            username = users.get(0).toString();
        }

        if (passwords != null && !passwords.isEmpty()) {
            password = passwords.get(0).toString();
        }

        /**
         * verify the user and return response
         */
        if (username.equalsIgnoreCase("user") && password.equals("pass")) {
            return "Hello, " + name;
        } else {
            return "Authentication faild! Please provide correct credentials";
        }
    }
}
