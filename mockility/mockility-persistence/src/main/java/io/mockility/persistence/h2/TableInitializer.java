package io.mockility.persistence.h2;

import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Don't worry be happy
 * Created by liangwei on 3/24/18
 */

public class TableInitializer {
    private static final Logger logger = getLogger(TableInitializer.class);

    public static void init() {
        try (Connection conn = H2ConnectionPool.getInstance().getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS Test(\n" +
                    " id VARCHAR(128),\n" +
                    " status VARCHAR(64),\n" +
                    " gmt_modify TIMESTAMP(3) DEFAULT CURRENT_TIMESTAMP NOT NULL,\n" +
                    " PRIMARY KEY(id)\n" +
                    ");");
        } catch (SQLException e) {
            logger.info("initialize tables failed.", e);
        }
    }

}
