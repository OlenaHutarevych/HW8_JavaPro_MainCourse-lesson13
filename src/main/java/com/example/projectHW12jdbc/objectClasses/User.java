package com.example.projectHW12jdbc.objectClasses;

import java.util.ArrayList;
public class User {
    private int id;
    private String first_name;
    private String second_name;
    private String phone_number;
    private String gender;
    private ArrayList <Device >devices;


    public User(int id, String first_name, String second_name, String phone_number, String gender,ArrayList devices) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.phone_number = phone_number;
        this.gender = gender;
        this.devices = devices;

    }
    public User(){

    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

    public void setDevices(ArrayList<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "User "+ id + "\n"+
                first_name + " "+ second_name + " , "+  gender + "\n" +
                "phone_number = " +" " + phone_number + "\n"  +
                "devices: \n" + "\t"+devices;
    }
}
//    @Override
//    public String toString() {
//        return "User: "+ "id= " + id + "\n"+
//                "first_name= " + first_name + "  "+ "second_name= " + second_name + "gender= " + gender + "\n" +
//                "phone_number= " +" " + phone_number + "\n"  +
//                "devices= \n" + devices;
//    }
