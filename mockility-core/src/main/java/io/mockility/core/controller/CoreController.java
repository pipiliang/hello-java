package io.mockility.core.controller;

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
public class CoreController {

    private static final Logger logger = getLogger(CoreController.class);

    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST,
            RequestMethod.PUT,
            RequestMethod.DELETE},
            value = "/**")
    public String mock() {
        logger.info("some request is coming...");
        return "hello, this is a response from Mockility.";
    }
}
