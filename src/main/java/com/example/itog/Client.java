package com.example.itog;

public class Client {
    private String FIO_CLIENT;
    private String PASSPORT_CLIENT;
    private String DATEBD_CLIENT;
    private String LOGIN_CLIENT;
    private String PASSWORD_CLIENT;

    public Client(String FIO_CLIENT, String PASSPORT_CLIENT, String DATEBD_CLIENT, String LOGIN_CLIENT, String PASSWORD_CLIENT) {
        this.FIO_CLIENT = FIO_CLIENT;
        this.PASSPORT_CLIENT = PASSPORT_CLIENT;
        this.DATEBD_CLIENT = DATEBD_CLIENT;
        this.LOGIN_CLIENT = LOGIN_CLIENT;
        this.PASSWORD_CLIENT = PASSWORD_CLIENT;
    }

    public Client() {}

    public String getFIO_CLIENT() {
        return FIO_CLIENT;
    }

    public void setFIO_CLIENT(String FIO_CLIENT) {
        this.FIO_CLIENT = FIO_CLIENT;
    }

    public String getPASSPORT_CLIENT() {
        return PASSPORT_CLIENT;
    }

    public void setPASSPORT_CLIENT(String PASSPORT_CLIENT) {
        this.PASSPORT_CLIENT = PASSPORT_CLIENT;
    }

    public String getDATEBD_CLIENT() {
        return DATEBD_CLIENT;
    }

    public void setDATEBD_CLIENT(String DATEBD_CLIENT) {
        this.DATEBD_CLIENT = DATEBD_CLIENT;
    }

    public String getLOGIN_CLIENT() {
        return LOGIN_CLIENT;
    }

    public void setLOGIN_CLIENT(String LOGIN_CLIENT) {
        this.LOGIN_CLIENT = LOGIN_CLIENT;
    }

    public String getPASSWORD_CLIENT() {
        return PASSWORD_CLIENT;
    }

    public void setPASSWORD_CLIENT(String PASSWORD_CLIENT) {
        this.PASSWORD_CLIENT = PASSWORD_CLIENT;
    }
}
