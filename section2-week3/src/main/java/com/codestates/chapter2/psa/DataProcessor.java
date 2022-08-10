package com.codestates.chapter2.psa;

import java.sql.Connection;
import java.sql.SQLOutput;

public class DataProcessor {
    private Connection connection;

    public DataProcessor(JdbcConnector connector) {
        this.connection = connector.getConnection();
    }
    public void insert() {
        System.out.println("inserted data");
    }
}
