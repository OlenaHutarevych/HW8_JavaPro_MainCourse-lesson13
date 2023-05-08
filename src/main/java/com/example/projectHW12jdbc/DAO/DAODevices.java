package com.example.projectHW12jdbc.DAO;
import com.example.projectHW12jdbc.objectClasses.Device;
import java.sql.*;
import java.util.ArrayList;

public class DAODevices implements DAODevicesInterface {
    @Override
    public int createDevice(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        String sql;
        sql="SELECT MAX(dev_id) AS max_id FROM devices";
        ResultSet resultSet = statement.executeQuery(sql);
        int newId=-1;
        while (resultSet.next()){
            newId  = resultSet.getInt(1)+1;
        }
        sql = "INSERT INTO devices (dev_id)  values ("+newId+")";
        if (!statement.execute(sql)){
            System.out.println("The new device is created, ID= "+newId);
        }
        else {
            System.out.println("something wrong");
        }
        return newId;
    }
    @Override
    public Device findDevice(int dev_id, Connection connection) throws SQLException{
        Statement statement = connection.createStatement();

        String sql;
        sql= "Select * FROM devices WHERE dev_id="+dev_id;

        ResultSet resultSet = statement.executeQuery(sql);

        Device device = new Device();

        while (resultSet.next()){
            String dev_name = resultSet.getString("dev_name");
            String dev_model = resultSet.getString("dev_model");
            String mac_adress = resultSet.getString("mac_adress");
            int affiliation = resultSet.getInt("affiliation");


            device.setDeviceName(dev_name);
            device.setDeviceId(dev_id);
            device.setDeviceModel(dev_model);
            device.setDeviceModel(mac_adress);
            device.setAffiliationToUser(affiliation);
        }
        return device;
    }
    @Override
    public boolean updateDevice(int dev_id, Connection connection, String deviceNew)throws SQLException {
        Statement statement = connection.createStatement();
        String sql;
        boolean result = false;
        String [] deviceUpdates = deviceNew.split(" ");

        sql = "UPDATE  devices SET " +
                "dev_name ='"+ deviceUpdates[0]+
                "', dev_model ='" +deviceUpdates[1]+
                "', mac_adress = '"+deviceUpdates[2]+
                "', affiliation = '"+Integer.parseInt(deviceUpdates[3])+
                "' WHERE dev_id ="+dev_id;
        if (!statement.execute(sql)){
            result = true;
        }
        return result;
    }
    @Override
    public boolean deleteDevice(int dev_id,Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        String sql;
        boolean result = false;
        sql = "DELETE from devices where dev_id ="+dev_id;
        if (statement.execute(sql)){
            result = true;
        }
        return result;
    }
    @Override
    public ArrayList selectAllDevice(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        String sql;
        sql = "SELECT * FROM devices ORDER BY affiliation";
        ResultSet resultSet1 = statement.executeQuery(sql);

        ArrayList devices= new ArrayList<Device>();


        while (resultSet1.next()) {
            int deviceId = resultSet1.getInt("dev_id");
            int affiliationToUser = resultSet1.getInt("affiliation");

            String deviceName = resultSet1.getString("dev_name");
            String deviceModel = resultSet1.getString("dev_model");
            String macAdress = resultSet1.getString("mac_adress");

            devices.add(new Device(deviceId,affiliationToUser,deviceName,deviceModel,macAdress));
        }
        statement.close();
        return devices;
    }
}
