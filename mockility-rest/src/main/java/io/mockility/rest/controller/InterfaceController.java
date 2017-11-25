package io.mockility.rest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "get all mocking api", response = String.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = String.class)})
    @RequestMapping(method = RequestMethod.GET, path = "/interface")
    public String get() {
        logger.info("lalala..");
        return "Hello, Spring boot!";
    }
}
