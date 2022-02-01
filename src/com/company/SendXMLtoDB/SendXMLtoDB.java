package com.company.SendXMLtoDB;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.company.AppConfig.*;

public class SendXMLtoDB {
    public static void main(String[] args) {
        try {
            //Получаем документ
            Document document = DocumentBuilderFactory
                                .newInstance()
                                .newDocumentBuilder()
                                .parse(XML_PATH);
            //Создаем объект DAO с подключением к базе данных
            UserDAO userDAO = new UserDAO(DriverManager.getConnection(DATA_BASE_CONNECTION, DATA_BASE_USER, DATA_BASE_PASSWORD));
            //Получаем пользователей из документа
            ArrayList<User> userList = UserFactory.getUserList(document);
            //Отправляем отправляем пользователей в БД
            userDAO.insertUser(userList);
            //Закрываем содинение с БД
            userDAO.connectionClose();
        } catch (SAXException | IOException | ParserConfigurationException | SQLException  e) {
            e.printStackTrace();
        }
    }
}
