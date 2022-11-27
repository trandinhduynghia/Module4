package codegym.vn.bean;

public class SanPham {
    private int id;
    private String tensp;
    private double gia;
    private String mota;
    private String nsx;

    public SanPham() {
    }

    public SanPham(int id, String tensp, double gia, String mota, String nsx) {
        this.id = id;
        this.tensp = tensp;
        this.gia = gia;
        this.mota = mota;
        this.nsx = nsx;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }
}
