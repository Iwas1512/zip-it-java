package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ZipTest {
    
    @Test
    public void testZipEqualLengthIntegerLists() {
        List<Integer> nums1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> nums2 = Arrays.asList(2, 4, 6, 8);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        
        List<Integer> result = ListUtils.zip(nums1, nums2);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testZipUnequalLengthStringLists() {
        List<String> colors1 = Arrays.asList("Red", "Green", "Blue");
        List<String> colors2 = Arrays.asList("White", "Black", "Orange", "Pink", "Fuschia");
        List<String> expected = Arrays.asList("Red", "White", "Green", "Black", "Blue", "Orange", "Pink", "Fuschia");
        
        List<String> result = ListUtils.zip(colors1, colors2);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testZipWithFirstListLonger() {
        List<Character> chars1 = Arrays.asList('a', 'b', 'c', 'd', 'e');
        List<Character> chars2 = Arrays.asList('1', '2');
        List<Character> expected = Arrays.asList('a', '1', 'b', '2', 'c', 'd', 'e');
        
        List<Character> result = ListUtils.zip(chars1, chars2);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testZipWithEmptyLists() {
        List<Double> list1 = new ArrayList<>();
        List<Double> list2 = Arrays.asList(1.1, 2.2, 3.3);
        List<Double> expected = Arrays.asList(1.1, 2.2, 3.3);
        
        List<Double> result = ListUtils.zip(list1, list2);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testZipWithCustomObjects() {
        class Person {
            private final String name;
            
            public Person(String name) {
                this.name = name;
            }
            
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Person person = (Person) obj;
                return name.equals(person.name);
            }
        }
        
        List<Person> list1 = Arrays.asList(new Person("Alice"), new Person("Bob"));
        List<Person> list2 = Arrays.asList(new Person("Charlie"));
        List<Person> expected = Arrays.asList(
            new Person("Alice"), 
            new Person("Charlie"), 
            new Person("Bob")
        );
        
        List<Person> result = ListUtils.zip(list1, list2);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testZipWithNullThrowsException() {
        List<String> list = Arrays.asList("a", "b", "c");
        
        assertThrows(IllegalArgumentException.class, () -> {
            ListUtils.zip(list, null);
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            ListUtils.zip(null, list);
        });
    }
}