package com.company.SendXMLtoDB;

import com.company.AppConfig;

import java.sql.*;
import java.util.*;

/**
 * DAO для класса User
 */
public class UserDAO {
    Connection connection;

    public UserDAO (Connection connection){
        this.connection = connection;
    }

    /**
     * Получение списка пользователей
     */
    public ArrayList<User> getAllUser(){
        try{
            String sql = "SELECT * FROM user_table;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            return parseUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }


    /**
     * Вставка одного пользователя
     */
    public void insertUser(User user){
        try {
            String sql = "INSERT into user_table value ('"+user.getId()+"', '"+user.getFirstName()+"', '"+user.getLastName()+"', '"+user.getDescription()+"')";
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            System.out.println("Вставка" + rows + " успешна произведенна");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Вставка коллекции пользователей
     */
    public void insertUser(List<User> userList){
        try {
            StringBuilder sql = new StringBuilder("INSERT into user_table values");
            for (int i = 0; i < userList.size(); i++) {
                sql.append(userSQL(userList.get(i)));
                sql.append(",");
            }
            sql.deleteCharAt(sql.length()-1);
            int rows = connection.createStatement().executeUpdate(sql.toString());
            System.out.println("Вставка" + rows + " успешна произведенна");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для парса в класс пользователей после получения из БД ResultSet
     */
    private ArrayList<User> parseUser(ResultSet resultSet) {
        try {
            ArrayList<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setDescription(resultSet.getString("description"));
                userList.add(user);
            }
            return userList;
        }catch (SQLException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Для преобразования класса User в поля для SQL запросов
     */
    private String userSQL(User user){
        return " ('"+user.getId()+"', '"+user.getFirstName()+"', '"+user.getLastName()+"', '"+user.getDescription()+"') ";
    }

    /**
     * Закрытие подключения к БД
     */
    public void connectionClose(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
