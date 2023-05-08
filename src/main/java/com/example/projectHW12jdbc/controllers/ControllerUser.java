package com.example.projectHW12jdbc.controllers;

import com.example.projectHW12jdbc.DAO.DAODevices;
import com.example.projectHW12jdbc.DAO.DAOUsers;
import com.example.projectHW12jdbc.DAO.DaoConnection;
import com.example.projectHW12jdbc.objectClasses.User;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

//@RestController
public class ControllerUser  {
    private final Connection connection;
    private final DAOUsers daoU = new DAOUsers();
    private final DAODevices daoD = new DAODevices();
    public ControllerUser() {
        try {
            this.connection = DaoConnection.connection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //read all users
    @GetMapping("/users")
    public ArrayList getUsers() throws SQLException{
        ArrayList users = daoU.selectAllUsers(connection);
       //readind all devices
        ArrayList devices = daoD.selectAllDevice(connection);
       // connecting devices with users
        daoU.devicesAffiliationToUser(users,devices);
        return users;
    }
    // create new row in users
    @GetMapping("/usernew")
    public int createUser() throws SQLException{
        return daoU.createUser(connection);
    }
    // create new row in users and update user's info in columns
    @PostMapping("/user/create")
    public int createUser1(@RequestBody String user)throws SQLException{
        int responseToClient = daoU.createUser(connection);
        daoU.updateUser(responseToClient,connection,user);
        return responseToClient;
    }
    //read user by id
    @GetMapping("/user/read/{id}")
    public User findUserById(@PathVariable Integer id) throws SQLException{
        return daoU.findUser(id, connection);
    }
    //update user by id
    @PutMapping("/user/update/{id}")
    public boolean updateUserById(@PathVariable Integer id,@RequestBody String user) throws SQLException {
        return daoU.updateUser(id, connection, user);
    }
    //delete user by id
    @DeleteMapping("/user/delete/{id}")
    public boolean deleteUserById(@PathVariable Integer id)throws SQLException{
        return !daoU.deleteUser(id, connection);
    }
    @GetMapping("/close")
    boolean closeConnection()throws SQLException{
        connection.close();
        return connection.isClosed();
    }
}
