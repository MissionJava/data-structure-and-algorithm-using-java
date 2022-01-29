package com.antesh.interview;

import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String row_column = sc.nextLine();
            String[] dimensions = row_column.trim().split("\\s+");
            int row = Integer.parseInt(dimensions[0]);
            int column = Integer.parseInt(dimensions[1]);
            if (row >= 3 && column <= 300) {
                int[][] kingdom = new int[row][column];
                populateKingdom(sc, row, kingdom);

                int minimumArmy = getMinimumArmy(sc, row, column, kingdom);
                System.out.println(minimumArmy);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }
        sc.close();
    }

    private static int getMinimumArmy(Scanner sc, int row, int column, int[][] kingdom) {
        String castle_location = sc.nextLine();
        String[] castle_dimensions = castle_location.trim().split("\\s+");
        int castle_row = Integer.parseInt(castle_dimensions[0]);
        int castle_column = Integer.parseInt(castle_dimensions[1]);
        int corners = 4;
        int castle = 1;
        int total_army = row * column;
        total_army = total_army - corners - castle;
        if (castle_row > 0 && castle_row < row - 1 && castle_column > 0 && castle_column < column - 1) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (kingdom[i][j] == 0) {
                        total_army = total_army - 1;
                    }
                }
            }
        }
        return total_army;
    }

    private static void populateKingdom(Scanner sc, int row, int[][] kingdom) {
        for (int i = 0; i < row; i++) {
            String line = sc.nextLine();
            String[] squares = line.trim().split("\\s+");
            for (int j = 0; j < squares.length; j++) {
                kingdom[i][j] = Integer.parseInt(squares[j]);
            }
        }
    }
}
