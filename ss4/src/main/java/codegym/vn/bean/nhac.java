package codegym.vn.bean;

public class nhac {
    private int id;

    private String tenbaihat;

    private String nghesithehien;

    private String theloai;

    private String duongdan;

    public nhac() {
    }

    public nhac(int id, String tenbaihat, String nghesithehien, String theloai, String duongdan) {
        this.id = id;
        this.tenbaihat = tenbaihat;
        this.nghesithehien = nghesithehien;
        this.theloai = theloai;
        this.duongdan = duongdan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenbaihat() {
        return tenbaihat;
    }

    public void setTenbaihat(String tenbaihat) {
        this.tenbaihat = tenbaihat;
    }

    public String getNghesithehien() {
        return nghesithehien;
    }

    public void setNghesithehien(String nghesithehien) {
        this.nghesithehien = nghesithehien;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getDuongdan() {
        return duongdan;
    }

    public void setDuongdan(String duongdan) {
        this.duongdan = duongdan;
    }
}
