package com.company.Problems;

import java.util.ArrayList;
import java.util.List;

public class P119 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        for(int i=1; i<rowIndex; i++) {
            List<Integer> row2 = new ArrayList<Integer>();
            row2.add(1);
            for(int j=1; j<i; j++) {
                row2.add(row1.get(j-1) + row1.get(j));
            }
            row2.add(1);
            row1 = row2;
        }
        return row1;
    }
}
