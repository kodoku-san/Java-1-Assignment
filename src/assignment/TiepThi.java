package assignment;

public class TiepThi extends NhanVien {
    private double doanhSo;
    private double hueHong;

    public TiepThi() {
        super();
    }

    public TiepThi(int level, String nvID, String nvName, double nvSalary, double doanhSo, double hueHong) {
        super(level, nvID, nvName, nvSalary);
        this.doanhSo = doanhSo;
        this.hueHong = hueHong;
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("  Doanh số bán hàng: " + doanhSo);
        System.out.println("  Huê hồng: " + hueHong);
    }

    @Override
    public double getThuNhap() {
        return super.getNvSalary() + doanhSo + hueHong;
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

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHueHong() {
        return hueHong;
    }

    public void setHueHong(double hueHong) {
        this.hueHong = hueHong;
    }

}
