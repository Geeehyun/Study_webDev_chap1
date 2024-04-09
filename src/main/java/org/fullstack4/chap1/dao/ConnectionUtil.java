package org.fullstack4.chap1.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public enum ConnectionUtil {
    INSTANCE;

    private HikariDataSource ds;

    ConnectionUtil() {
        HikariConfig config = new HikariConfig();
        // DB 연결하는 부분 JDBC 커넥트 연결할 때와 유사
        config.setDriverClassName("org.mariadb.jdbc.Driver");   // Class.forName 과 동일한 설정 부분
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("user");
        config.setPassword("1234");
        // 히카리 설정
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);

        // 열심히 설정해준거 Connection 연결
        ds = new HikariDataSource(config);
    }

    public Connection getConnection() throws Exception {
        return ds.getConnection();
    }
}
