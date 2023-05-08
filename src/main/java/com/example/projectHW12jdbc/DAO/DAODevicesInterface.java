package com.example.projectHW12jdbc.DAO;

import com.example.projectHW12jdbc.objectClasses.Device;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAODevicesInterface {
    int createDevice(Connection connection) throws  SQLException;
    Device findDevice(int id,  Connection connection)throws  SQLException;
    boolean updateDevice(int id, Connection connection, String deviceNew)throws  SQLException;
    boolean deleteDevice(int id,Connection connection)throws  SQLException;


    public ArrayList selectAllDevice(Connection connection)throws SQLException;
}
