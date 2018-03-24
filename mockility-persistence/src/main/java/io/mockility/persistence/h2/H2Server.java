package io.mockility.persistence.h2;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

import static org.slf4j.LoggerFactory.getLogger;


/**
 * Don't worry be happy
 * Created by liangwei on 3/17/18
 */
@Service
public class H2Server {

    private static final Logger logger = getLogger(H2Server.class);
    private static final boolean Debug = true;

    private Server server;
    private Server webServer;

    public void start() {
        try {
            logger.info("start h2 server...");
            if (server == null) {
                server = Server.createTcpServer(new String[]{"-tcp", "-tcpAllowOthers", "-tcpPort", "8043"}).start();
                logger.info("start finished: {}", server.getStatus());
            }
            if (Debug) {
                webServer = Server.createWebServer(new String[]{"-web", "-webAllowOthers", "-webPort", "8082"}).start();
                logger.info("start web {}", webServer.getStatus());
            }
        } catch (SQLException e) {
            logger.info("start h2 failed.", e);
            throw new Error("start h2 server failed.", e);
        }
    }

    public void init() {
        TableInitializer.init();
    }

    public void stop() {
        if (server != null) {
            logger.info("stop h2 server...");
            server.stop();
            logger.info("stop h2 successfully.");
        }
    }
}
