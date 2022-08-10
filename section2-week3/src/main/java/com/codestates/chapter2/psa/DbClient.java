package com.codestates.chapter2.psa;

public class DbClient {
    public static void main(String[] args) {
        JdbcConnector connector = new SQLiteJdbcConnector();
        DataProcessor processor = new DataProcessor(connector);
        processor.insert();
    }
}