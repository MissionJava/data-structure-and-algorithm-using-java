package com.antesh.interview;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.length() > 0) {
                String[] words = line.split("\\s+");
                Set<String> wordSet = new HashSet<>();
                for (String word : words) {
                    if (!wordSet.add(word.toLowerCase())) {
                        System.out.println("no");
                        return;
                    }
                }
                System.out.println("yes");
                return;
            }
            return;
        }
        sc.close();
    }
}
