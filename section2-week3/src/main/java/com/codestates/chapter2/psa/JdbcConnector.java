package com.codestates.chapter2.psa;

import java.sql.Connection;

public interface JdbcConnector {
    Connection getConnection();
}
