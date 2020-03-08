package io.mockility.manager.controller;

import io.mockility.manager.entity.MockedInterface;
import io.mockility.manager.entity.Result;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Don't worry be happy
 * Created by liangwei on 2/14/18
 */

@RestController
@Api("Interface Mock API")
@RequestMapping(value = "/api/mockility/v1")
public class MockedInterfaceController {
    private static final Logger logger = getLogger(MockedInterfaceController.class);

    @RequestMapping(method = {RequestMethod.POST}, value = "/interfaces")
    public Result<MockedInterface> post(@RequestBody MockedInterface mockedInterface) {
        return new Result<>(mockedInterface);
    }
}
