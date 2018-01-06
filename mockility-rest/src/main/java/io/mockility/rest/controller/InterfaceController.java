package io.mockility.rest.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Don't worry be happy
 * Created by liangwei on 11/24/17
 */

@RestController
@Api("Interface Mock API")
public class InterfaceController {

    private static final Logger logger = getLogger(InterfaceController.class);

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}, value = "/**")
    public String mock() {
        return "Hello, Spring boot!";
    }
}
