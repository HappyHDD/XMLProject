package com.company.SendXMLtoDB;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Фабрика для получения пользователей из XML Файла
 */
public class UserFactory {
    /**
     * Получение ArrayList User из XML документа
     */
    public static ArrayList<User> getUserList(Document document){
        ArrayList<User> userList = new ArrayList<>();
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 1; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            userList.add(getUser(node));
        }
        return userList;
    }

    /**
     * Парс Node в объекты User
     */
    private static User getUser(Node node){
        User user = new User();
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node cNode = childNodes.item(i);
            String content = cNode.getLastChild().getTextContent();
            switch (cNode.getNodeName()) {
                case "Id":
                    user.setId(Integer.parseInt(content));
                    break;
                case "FirstName":
                    user.setFirstName(content);
                    break;
                case "LastName":
                    user.setLastName(content);
                    break;
                case "Description":
                    user.setDescription(content);
                    break;
            }

        }
        return user;
    }
}
