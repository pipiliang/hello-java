package io.mockility.manager;


import io.mockility.persistence.h2.H2Server;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Don't worry be happy
 * Created by liangwei on 3/17/18
 */
@Order(1)
public class DatabaseRunner implements CommandLineRunner {
    private static final Logger logger = getLogger(DatabaseRunner.class);

    @Autowired
    private H2Server h2Server;

    @Override
    public void run(String... args) throws Exception {
        h2Server.start();
        h2Server.init();
    }
}
