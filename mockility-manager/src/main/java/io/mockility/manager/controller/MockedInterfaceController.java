package io.mockility.manager.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Don't worry be happy
 * Created by liangwei on 2/14/18
 */

@RestController
@Api("Interface Mock API")
public class MockedInterfaceController {
    private static final Logger logger = getLogger(MockedInterfaceController.class);

    @RequestMapping(method = {RequestMethod.GET}, value = "/interface")
    public String get() {
        return "";
    }
}
