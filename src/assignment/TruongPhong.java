package assignment;


public class TruongPhong extends NhanVien{
    private double luongTN;

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("  Lương trách nhiệm: " + luongTN);
    }

    @Override
    public double getThuNhap() {
        return super.getThuNhap() + luongTN;
    }

    @Override
    public double getThueThuNhap() {
        double nvSalary = getThuNhap();
        if (nvSalary > 15) {
            return nvSalary * 0.12;
        } else if (nvSalary >= 9) {
            return nvSalary * 0.1;
        } else {
            return 0.0;
        }
    }

    public TruongPhong() {
        super();
    }

    public TruongPhong(int level, String nvID, String nvName, double nvSalary, double luongTN) {
        super(level, nvID, nvName, nvSalary);
        this.luongTN = luongTN;
    }

    public double getLuongTN() {
        return luongTN;
    }

    public void setLuongTN(double luongTN) {
        this.luongTN = luongTN;
    }
    
    
}
