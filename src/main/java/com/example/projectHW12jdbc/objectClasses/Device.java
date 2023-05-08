package com.example.projectHW12jdbc.objectClasses;

public class Device {
    private int deviceId;
    private int affiliationToUser;
    private String deviceName;
    private String deviceModel;
    private String macAdress;

    public Device() {}

    public Device(int deviceId, int affiliationToUser, String deviceName, String deviceModel, String macAdress) {
        this.deviceId = deviceId;
        this.affiliationToUser = affiliationToUser;
        this.deviceName = deviceName;
        this.deviceModel = deviceModel;
        this.macAdress = macAdress;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getAffiliationToUser() {
        return affiliationToUser;
    }

    public void setAffiliationToUser(int affiliationToUser) {
        this.affiliationToUser = affiliationToUser;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }


    @Override
    public String toString() {
        return   deviceName + " "+ deviceModel + " " + macAdress + "\n";
    }
}
