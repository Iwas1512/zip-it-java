package org.example;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {
    
    public static <T> List<T> zip(List<T> list1, List<T> list2) {
        if (list1 == null || list2 == null) {
            throw new IllegalArgumentException("Input lists cannot be null");
        }
        
        List<T> result = new ArrayList<>();
        int i = 0;
        
        while (i < list1.size() && i < list2.size()) {
            result.add(list1.get(i));
            result.add(list2.get(i));
            i++;
        }
        
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }
        
        while (i < list2.size()) {
            result.add(list2.get(i));
            i++;
        }
        
        return result;
    }
}