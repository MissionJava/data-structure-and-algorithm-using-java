package com.antesh.dsa.string;
/*  Find all possible substring of given input string
*   Sample 1: AB
*   Output 1: {}, {A}, {B}, {AB}  // i.e. 2^n possible
*
*   Sample 2: ABC
*   Output 2: {}, {A}, {B}, {C}, {AB}, {AC}, {BC}, {ABC}
* */


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AllPossibleSequencesOrSubString {

    public static void subSequence(String input, Set<String> outputs) {
        if (input == null || input.trim().length() == 0) {
            outputs.add("");
            return;
        }

        subSequence(input.substring(1), outputs);

        List<String> cp = outputs.stream().collect(Collectors.toList());
        for (String s : cp) {
            outputs.add(input.substring(0, 1) + s);
        }
    }

    public static void main(String[] args) {
        Set<String> outputs = new HashSet<>();
        subSequence("ABCD",outputs);
        System.out.println(outputs);
        System.out.println(outputs.size());

        outputs = new HashSet<>();
        subSequence("AAAA",outputs);
        System.out.println(outputs);
        System.out.println(outputs.size());
    }
}
