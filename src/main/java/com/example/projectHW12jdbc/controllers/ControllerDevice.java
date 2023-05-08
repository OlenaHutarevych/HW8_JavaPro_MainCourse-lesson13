package com.example.projectHW12jdbc.controllers;

import com.example.projectHW12jdbc.DAO.DAODevices;
import com.example.projectHW12jdbc.DAO.DaoConnection;
import com.example.projectHW12jdbc.objectClasses.Device;
import org.springframework.web.bind.annotation.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
@RestController
public class ControllerDevice {
    private final Connection connection;
    private final DAODevices daoD = new DAODevices();
    public ControllerDevice() {
        try {
            this.connection = DaoConnection.connection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //read all devices
    @GetMapping("/devices")
    public ArrayList getDevices() throws SQLException{
        return daoD.selectAllDevice(connection);
    }
    // create new row in devices
    @GetMapping("/devicenew")
    public int createDevice() throws SQLException{
        return daoD.createDevice(connection);
    }
    // create new row in devices and update device's info in columns
    @PostMapping("/device/create")
    public int createDevice1(@RequestBody String device)throws SQLException{
        int responseToClient = daoD.createDevice(connection);
        daoD.updateDevice(responseToClient,connection,device);
        return responseToClient;
    }
    //read user by id
    @GetMapping("/device/read/{dev_id}")
    public Device findDeviceById(@PathVariable Integer dev_id) throws SQLException{
        return daoD.findDevice(dev_id, connection);
    }
    //update user by id
    @PutMapping("/device/update/{dev_id}")
    public boolean updateDeviceById(@PathVariable Integer dev_id,@RequestBody String device) throws SQLException {
        return daoD.updateDevice(dev_id, connection, device);
    }
    //delete user by id
    @DeleteMapping("/device/delete/{dev_id}")
    public boolean deleteDeviceById(@PathVariable Integer dev_id)throws SQLException{
        return !daoD.deleteDevice(dev_id, connection);
    }
    @GetMapping("/close")
    boolean closeConnection()throws SQLException{
        connection.close();
        return connection.isClosed();
    }
}
