package com.example.projectHW12jdbc.DAO;
import com.example.projectHW12jdbc.objectClasses.User;
import com.example.projectHW12jdbc.objectClasses.Device;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DAOUsers implements DAOUsersInterface {
    @Override
    public int createUser(Connection connection) throws  SQLException{
        Statement statement = connection.createStatement();

        String sql;
        sql="SELECT MAX(id) AS max_id FROM users";
        ResultSet resultSet = statement.executeQuery(sql);
        int newId=-1;
        while (resultSet.next()){
            newId  = resultSet.getInt(1)+1;
        }
        sql = "INSERT INTO users (id)  values ("+newId+")";
        if (!statement.execute(sql)){
            System.out.println("The new user is created, ID= "+newId);
        }
        else {
            System.out.println("something wrong");
        }
        return newId;
    }
    @Override
    public User findUser(int id, Connection connection) throws SQLException{
        Statement statement = connection.createStatement();

        String sql;
        sql= "Select * FROM users LEFT JOIN  devices d on users.id = d.affiliation WHERE id ="+id;

        ResultSet resultSet = statement.executeQuery(sql);

        User user = new User();
        user.setDevices(new ArrayList<>());

        while (resultSet.next()){
            String first_name = resultSet.getString("first_name");
            String second_name = resultSet.getString("second_name");
            String phone_number = resultSet.getString("phone_number");
            String gender = resultSet.getString("gender");
            user.setId(id);
            user.setFirst_name(first_name);
            user.setSecond_name(second_name);
            user.setGender(gender);
            user.setPhone_number(phone_number);

            user.getDevices().add(new Device(
                    resultSet.getInt("dev_id"),
                    id,resultSet.getString("dev_name"),
                    resultSet.getString("dev_model"),
                    resultSet.getString("mac_adress") ));
        }
        return user;
    }
    @Override
    public boolean updateUser(int id, Connection connection, String str) throws SQLException{
        Statement statement = connection.createStatement();
        String sql;
        boolean result = false;
//        Scanner input = new Scanner(System.in);
//        System.out.println("Please, input the user's values by such order:\n" +
//                "first_name, second_name, phone_number, gender\n"+
//                "if the you have no some value write ' '(scape)");
//        String[] userUpdates = input.nextLine().split(" ");
        String [] userUpdates = str.split(" ");
        sql = "UPDATE  users SET " +
                "first_name ='"+ userUpdates[0]+
                "', second_name ='" +userUpdates[1]+
                "', phone_number = '"+userUpdates[2]+
                "', gender = '"+userUpdates[3]+
                "' WHERE id ="+id;
        if (!statement.execute(sql)){
            result = true;
        }
        return result;
    }
    @Override
    public boolean deleteUser(int id, Connection connection) throws  SQLException {
        Statement statement = connection.createStatement();
        String sql;
        boolean result = false;
        sql = "DELETE from users where id ="+id;
        if (statement.execute(sql)){
            result = true;
        }
        return result;
    }
    @Override
    public  ArrayList<User> selectAllUsers(Connection connection) throws  SQLException{
        Statement statement = connection.createStatement();

        String sqlUsers;
        sqlUsers= "SELECT * FROM users";

        ResultSet resultSet1 = statement.executeQuery(sqlUsers);

        ArrayList users = new ArrayList<User>();


        while (resultSet1.next()){
            int id = resultSet1.getInt("id");
            String first_name = resultSet1.getString("first_name");
            String second_name = resultSet1.getString("second_name");
            String phone_number = resultSet1.getString("phone_number");
            String gender = resultSet1.getString("gender");

            users.add(new User(id,first_name,second_name,phone_number,gender,new ArrayList<>()));
        }
        statement.close();
        return users;
    }
    public  static void devicesAffiliationToUser(ArrayList<User> users,ArrayList<Device> devices) {
        for (User user : users) {
            ArrayList devicesTemp = new ArrayList<Device>();
            for (Device device : devices) {
                if (device.getAffiliationToUser() == user.getId()) {
                    devicesTemp.add(device);
                }
            }
            user.setDevices(devicesTemp);
        }
    }
}
