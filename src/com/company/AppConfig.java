package com.company;

public class AppConfig {
    public static final String DATA_BASE_USER = "root";
    public static final String DATA_BASE_PASSWORD = "1234";
    public static final String DATA_BASE_SERVER = "localhost";
    public static final String DATA_BASE_SCHEMA = "user_db";
    public static final String DATA_BASE_CONNECTION = "jdbc:mysql://"+ DATA_BASE_SERVER +"/" + DATA_BASE_SCHEMA;
    public static final String XML_PATH = "xml/UserTable.xml";
}
