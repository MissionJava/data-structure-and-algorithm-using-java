package com.antesh.interview;

import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            for (int i = 0; i < 10; i++) {
                try {
                    int scanLines = Integer.parseInt(sc.nextLine());
                    boolean isDecodingError = false;
                    if (scanLines > 0) {
                        int pixels = 0;

                        for (int j = 0; j < scanLines; j++) {
                            String line = sc.nextLine();
                            String[] runs = line.trim().split("\\s+");
                            int linePixels = decodeLineAndGetLinePixels(runs);
                            if (j == 0) {
                                pixels = linePixels;
                            } else if (pixels != linePixels) {
                                isDecodingError = true;
                            }
                        }
                        if (isDecodingError) {
                            System.out.println("Error decoding image");
                        }
                        System.out.println();
                    } else {
                        sc.close();
                        return;
                    }
                } catch (Exception e) {
                    System.out.println("Exception occurred while decoding image: " + e);
                }
            }
        }
        sc.close();
    }

    public static int decodeLineAndGetLinePixels(String[] runs) {
        String firstPixel = "";
        String secondPixel = "";
        int pixels = 0;
        for (int k = 0; k < runs.length; k++) {
            if (k == 0) {
                if (runs[k].equals("#")) {
                    firstPixel = "#";
                    secondPixel = ".";
                } else if (runs[k].equals(".")) {
                    firstPixel = ".";
                    secondPixel = "#";
                }
            } else if (k % 2 != 0) {
                pixels = decodeAndGetPixels(firstPixel, pixels, runs[k]);
            } else {
                pixels = decodeAndGetPixels(secondPixel, pixels, runs[k]);
            }
        }
        System.out.println();
        return pixels;
    }

    public static int decodeAndGetPixels(String px, int pixels, String run1) {
        int run = Integer.parseInt(run1);
        pixels += run;
        StringBuilder sb = new StringBuilder();
        for (int l = 0; l < run; l++) {
            sb.append(px);
        }
        System.out.print(sb);
        return pixels;
    }
}
