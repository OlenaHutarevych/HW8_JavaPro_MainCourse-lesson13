package com.example.projectHW12jdbc.DAO;
import com.example.projectHW12jdbc.objectClasses.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public interface DAOUsersInterface {
        int createUser(Connection connection) throws  SQLException;
        User findUser(int id, Connection connection) throws  SQLException;
        boolean updateUser(int id, Connection connection, String str)throws SQLException;
        boolean deleteUser(int id, Connection connection) throws  SQLException;
        ArrayList selectAllUsers(Connection connection)throws  SQLException;
}
