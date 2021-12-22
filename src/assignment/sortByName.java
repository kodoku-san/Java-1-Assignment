package assignment;

import java.util.Comparator;


public class sortByName implements Comparator<NhanVien>{

    @Override
    public int compare(NhanVien o1, NhanVien o2) {
        String n1 = o1.getNvName();
        String n2 = o2.getNvName();
        
        return n1.compareTo(n2);
    }
    
}
