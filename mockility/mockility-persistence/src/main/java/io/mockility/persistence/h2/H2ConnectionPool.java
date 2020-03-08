package io.mockility.persistence.h2;

import org.h2.jdbcx.JdbcConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Don't worry be happy
 * Created by liangwei on 3/24/18
 */

public class H2ConnectionPool {

    private static H2ConnectionPool instance;
    private JdbcConnectionPool cp;

    private H2ConnectionPool() {
        String dataBasePath = "./db/mockility";
        if (cp == null) {
            cp = JdbcConnectionPool.create("jdbc:h2:" + dataBasePath, "sa", "");
            cp.setMaxConnections(50);
        }
    }

    public static H2ConnectionPool getInstance() {
        if (instance == null) {
            instance = new H2ConnectionPool();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return cp.getConnection();
    }
}
