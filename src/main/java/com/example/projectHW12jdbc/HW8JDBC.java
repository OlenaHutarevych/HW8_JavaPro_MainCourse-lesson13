package com.example.projectHW12jdbc;
import com.example.projectHW12jdbc.DAO.DAODevices;
import com.example.projectHW12jdbc.DAO.DAOUsers;
import com.example.projectHW12jdbc.DAO.DaoConnection;
import java.sql.*;
import java.util.ArrayList;

// цей файл звичайний клас, не використовує Spring
public class HW8JDBC {
    public static void main(String[] args) throws ClassNotFoundException,SQLException, NoSuchFieldException, IllegalAccessException{

        Connection connection = DaoConnection.connection();

        DAOUsers daoU = new DAOUsers();
        DAODevices daoD = new DAODevices();

//read all users
        ArrayList users = daoU.selectAllUsers(connection);
 //read all devices
        ArrayList devices = daoD.selectAllDevice(connection);
// connecting devices with users
        daoU.devicesAffiliationToUser(users,devices);

// Checking users and their devices
//      for (int i = 0; i< users.size(); i+=1) {
//          System.out.println(users.get(i).toString());
//        }
// Create user
        System.out.println(daoU.createUser(connection)); // result = 8
// Create device
        System.out.println(daoD.createDevice(connection)); // result = 14
// Read user
        System.out.println(daoU.findUser(8, connection));
// Read device
        System.out.println(daoD.findDevice(3,connection));
//Update user
        daoU.updateUser(8, connection,"Jacky Kennedy +3809792356987 female" );
        System.out.println(daoU.findUser(8, connection));// check
//Update device
        System.out.println(daoD.updateDevice(14,connection,"Apple app 255gmgj 7"));
//Delete user
        daoU.deleteUser(8,connection);
        daoD.deleteDevice(14, connection);

        connection.close();
    }
}

