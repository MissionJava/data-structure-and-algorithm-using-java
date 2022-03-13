package com.antesh.dsa.string;


import java.util.*;

public class Anagram {

    //If using HashMap for frequency count of each character
    static boolean isAnagram(String a, String b) {

        if ((a == null && b != null) || (a != null && b == null)) {
            return false;
        }

        if (a.length() != b.length()) {
            return false;
        }

        a = a.toLowerCase();
        b = b.toLowerCase();

        Map<Character, Integer> freq1 = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (freq1.containsKey(a.charAt(i))) {
                freq1.put(a.charAt(i), freq1.get(a.charAt(i)) + 1);
            } else {
                freq1.put(a.charAt(i), 1);
            }
        }

        Map<Character, Integer> freq2 = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            if (freq2.containsKey(b.charAt(i))) {
                freq2.put(b.charAt(i), freq2.get(b.charAt(i)) + 1);
            } else {
                freq2.put(b.charAt(i), 1);
            }
        }

        return freq1.equals(freq2);
    }

    static boolean isAnagramUsingSort(String a, String b) {
        if ((a == null && b != null) || (a != null && b == null)) {
            return false;
        }

        if (a.length() != b.length()) {
            return false;
        }

        a = a.toLowerCase();
        b = b.toLowerCase();

        char[] charsA = a.toCharArray();
        charsA = sort(charsA);
        a = new String(charsA);

        char[] charsB = b.toCharArray();
        charsB = sort(charsB);
        b = new String(charsB);

        return a.equals(b);

    }

    //Optimization needed scope: sort in O(log(n))
    static char[] sort(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] < chars[i]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }

        return chars;
    }


    public static void main(String[] args) {
        boolean ret = isAnagram("anagram", "margana");
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");

        ret = isAnagramUsingSort("anagram", "margana");
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
