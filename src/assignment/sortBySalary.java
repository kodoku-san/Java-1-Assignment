package assignment;

import java.util.Comparator;


public class sortBySalary implements Comparator<NhanVien>{

    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        double a = o1.getThuNhap() - o2.getThuNhap();
        if(a > 0){
            return -1;
        } else if (a < 0) {
            return 1;
        }
        return 0;
    }
    
}
