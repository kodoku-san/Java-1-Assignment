package assignment;


public class NhanVien {
    private String nvID;
    private String nvName;
    private double nvSalary;
    private int level;
    
    public void xuatThongTin(){
        System.out.println("  Mã nhân viên: " + nvID);
        System.out.println("  Họ và tên : " + nvName);
        System.out.println("  Lương : " + nvSalary);
        System.out.println("  Thuế thu nhập : " +  (double) Math.round(getThueThuNhap() * 100) / 100);
    }
    
    public double getThueThuNhap(){
        if(nvSalary > 15){
            return nvSalary*0.12;
        } else if (nvSalary >= 9) {
            return nvSalary*0.1;
        } else {
            return 0.0;
        }   
    }
    
    public double getThuNhap(){
        return nvSalary;
    }
    
    public NhanVien(){
        
    }
    
    public NhanVien(int level, String nvID, String nvName, double nvSalary){
        this.nvID = nvID;
        this.nvName = nvName;
        this.nvSalary = nvSalary;
        this.level = level;
    }

    public String getNvID() {
        return nvID;
    }

    public void setNvID(String nvID) {
        this.nvID = nvID;
    }

    public String getNvName() {
        return nvName;
    }

    public void setNvName(String nvName) {
        this.nvName = nvName;
    }

    public double getNvSalary() {
        return nvSalary;
    }

    public void setNvSalary(double nvSalary) {
        this.nvSalary = nvSalary;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
}
