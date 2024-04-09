package org.fullstack4.chap1.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.fullstack4.chap1.domain.BbsVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

public class ConnectTests {
    @Test
    public void testConnection() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");
        String url = "jdbc:mariadb://localhost:3306/webdb";
        String id = "user";
        String pwd = "1234";
        Connection conn = DriverManager.getConnection(url, id, pwd);

        Assertions.assertNotNull(conn);
        conn.close();
    }
    // 테스트 메서드는 무조건 public void

    @Test
    public void testHikariCP() throws Exception {
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
        HikariDataSource ds = new HikariDataSource(config);
        Connection conn = ds.getConnection();

        System.out.println("Connection : " + conn);

        conn.close();
    }


}
