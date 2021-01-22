package com.company;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main( String[] args ) {
        String str = "LFWKI MJCLP SISWK HJOGL KMVGU RAGKM KMXMA MJCVX WUYLG GIISW" +
                "ALXAE YCXMF KMKBQ BDCLA EFLFW KIMJC GUZUG SKECZ GBWYM OACFV" +
                "MQKYF WXTWM LAIDO YQBWF GKSDI ULQGV SYHJA VEFWB LAEFL FWKIM" +
                "JCFHS NNGGN WPWDA VMQFA AXWFZ CXBVE LKWML AVGKY EDEMJ XHUXD" +
                "AVYXL";
        str = str.replace(" ", "");
        str = str.toUpperCase();
        kasisci(str);
    }

    public static void kasisci( String str ) {
        String tempString;
        System.out.println(str);
        Map<String, List<Integer>> map = new LinkedHashMap<>();
        int tempInt;
        for (int i = 0; i < str.length() - 2; i++) {
            tempString = str.substring(i, i + 3);
            if (!map.containsKey(tempString)) {
                map.put(tempString, new ArrayList<Integer>());
            }
            map.get(tempString).add(i);
        }
        List<Integer> distances = new ArrayList<>();
        System.out.println(map);
        System.out.println(map.values());
        Collection<List<Integer>> lists = map.values();
        List<Integer> dist = new ArrayList<>();
        lists.forEach(list -> {
            if (list.size() != 1) {
                for (int i = 0; i < list.size()-1; i++) {
                    distances.add(list.get(i+1) - list.get(i));
                }
            }
        });

        Integer prediction = findGCD(distances);
        System.out.println(distances);
        System.out.println(prediction);
    }

    static Integer gcd(Integer a, Integer b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Function to find gcd of array of
    // numbers
    static Integer findGCD(List<Integer> arr) {
        int result = 0;
        for (int element : arr) {
            result = gcd(result, element);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    // gcd каждый со следующем и так далее
}
