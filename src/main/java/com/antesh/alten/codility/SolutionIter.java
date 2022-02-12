package com.antesh.alten.codility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
    Task is to read a file line by line which contains valid, invalid number and text and iterate the line and print the same number
    if it is valid else print 0. Valid example: 10, +15, 2, -28 and invalid numbers for example, ++12, 10e2, #1254, ----1547
    Complete the iterator() method logic to process

    Given code snippet was:

    public class SolutionIter implements Iterable<Integer> {

        public SolutionIter(Reader inp);      // complete the remaining logic as per problem statement

        public Iterator<Integer> iterator();  // complete the remaining logic as per problem statement
    }

    // sample
    for (Integer x : new SolutionIter(reader)) {
        System.out.println(x);
    }
 */

public class SolutionIter implements Iterable<Integer> {
    public BufferedReader reader;

    public SolutionIter(BufferedReader inp) {
        this.reader = inp;
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("C:\\test-input.txt");
        BufferedReader reader = new BufferedReader(fileReader);

        for (Integer x : new SolutionIter(reader)) {
            System.out.println(x);
        }

        reader.close();
        fileReader.close();
    }

    public Iterator<Integer> iterator() {
        List<Integer> numbers = new ArrayList<>();
        populateNumbersFromInputFile(numbers);
        return numbers.iterator();
    }

    private void populateNumbersFromInputFile(List<Integer> numbers) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    numbers.add(Integer.parseInt(line));
                } catch (Exception e) {
                    numbers.add(0);
                }
            }
        } catch (Exception e) {
            numbers.add(0);
        }
    }
}