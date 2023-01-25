package com.example.itog;

public class Sotr {
    private String DOLG_IDDOLG;
    private String FIO_SOTR;
    private String LOGIN_SOTR;
    private String PASSWORD_SOTR;
    private String IMAGE_SOTR;


    public Sotr(String DOLG_IDDOLG, String FIO_SOTR, String LOGIN_SOTR, String PASSWORD_SOTR, String IMAGE_SOTR) {
        this.DOLG_IDDOLG = DOLG_IDDOLG;
        this.FIO_SOTR = FIO_SOTR;
        this.LOGIN_SOTR = LOGIN_SOTR;
        this.PASSWORD_SOTR = PASSWORD_SOTR;
        this.IMAGE_SOTR = IMAGE_SOTR;
    }

    public Sotr() {}

    public String getDOLG_IDDOLG() {
        return DOLG_IDDOLG;
    }

    public void setDOLG_IDDOLG(String DOLG_IDDOLG) {
        this.DOLG_IDDOLG = DOLG_IDDOLG;
    }

    public String getFIO_SOTR() {
        return FIO_SOTR;
    }

    public void setFIO_SOTR(String FIO_SOTR) {
        this.FIO_SOTR = FIO_SOTR;
    }

    public String getLOGIN_SOTR() {
        return LOGIN_SOTR;
    }

    public void setLOGIN_SOTR(String LOGIN_SOTR) {
        this.LOGIN_SOTR = LOGIN_SOTR;
    }

    public String getPASSWORD_SOTR() {
        return PASSWORD_SOTR;
    }

    public void setPASSWORD_SOTR(String PASSWORD_SOTR) {
        this.PASSWORD_SOTR = PASSWORD_SOTR;
    }

    public String getIMAGE_SOTR() {
        return IMAGE_SOTR;
    }

    public void setIMAGE_SOTR(String IMAGE_SOTR) {
        this.IMAGE_SOTR = IMAGE_SOTR;
    }
}
