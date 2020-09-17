package tictactoe;

import java.util.Scanner;


public class Main {


    public static void main(String[] args)  {

        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[3][3];
        int i = 0;
        int it = 0;

        System.out.println("---------");
        for (; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = " ";
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

       // int coordinate1 = 0;
        //int coordinate2 = 0;

        boolean result = false;
        String moves = null;

        while (it < 9)  {
            System.out.println("Enter the coordinates");

            if (it % 2 != 0) {
                moves = "O";
            }
            if (it % 2 == 0) {

                moves = "X";
            }

            while (true) {
                if (scanner.hasNextInt()) {
                    int coordinate1 = scanner.nextInt();
                    int coordinate2 = scanner.nextInt();

                    if (coordinate1 < 1 || coordinate1 > 3 || coordinate2 < 1 || coordinate2 > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        break;

                    } else if (coordinate1 == 1) {
                        if (coordinate2 == 1 && !matrix[2][0].equals("X") && !matrix[2][0].equals("O")) {
                            matrix[2][0] = moves;
                            result = true;
                        } else if (coordinate2 == 2 && !matrix[1][0].equals("X") && !matrix[1][0].equals("O")) {
                            matrix[1][0] = moves;
                            result = true;
                        } else if (coordinate2 == 3 && !matrix[0][0].equals("X") && !matrix[0][0].equals("O")) {
                            matrix[0][0] = moves;
                            result = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            break;
                        }

                    } else if (coordinate1 == 2) {
                        if (coordinate2 == 1 && !matrix[2][1].equals("X") && !matrix[2][1].equals("O")) {
                            matrix[2][1] = moves;
                            result = true;
                        } else if (coordinate2 == 2 && !matrix[1][1].equals("X") && !matrix[1][1].equals("O")) {
                            matrix[1][1] = moves;
                            result = true;
                        } else if (coordinate2 == 3 && !matrix[0][1].equals("X") && !matrix[0][1].equals("O")) {
                            matrix[0][1] = moves;
                            result = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            break;
                        }

                    } else if (coordinate1 == 3) {
                        if (coordinate2 == 1 && !matrix[2][2].equals("X") && !matrix[2][2].equals("O")) {
                            matrix[2][2] = moves;
                            result = true;
                        } else if (coordinate2 == 2 && !matrix[1][2].equals("X") && !matrix[1][2].equals("O")) {
                            matrix[1][2] = moves;
                            result = true;
                        } else if (coordinate2 == 3 && !matrix[0][2].equals("X") && !matrix[0][2].equals("O")) {
                            matrix[0][2] = moves;
                            result = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            break;
                        }
                    }
                } else if (!scanner.hasNextInt()) {
                    String string = scanner.nextLine();
                    System.out.println("You should enter numbers!");
                    break;

                }
                it++;
                if (result) {
                    System.out.println("---------");
                    for (i = 0; i < 3; i++) {
                        System.out.print("| ");
                        for (int j = 0; j < 3; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println("|");
                    }
                    System.out.println("---------");
                    break;
                }
           }

            int countIfX = 0;
            int countIfO = 0;
            int empty = 0;
            boolean winX = false;
            boolean winO = false;


            for (i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matrix[i][j].equals("X")) {
                        countIfX++;
                    } else if (matrix[i][j].equals("O")) {
                        countIfO++;
                    } else {
                        empty++;
                    }
                }
            }

            if (countIfX + countIfO == 9 || countIfX + countIfO + empty == 9) {
                for (i = 0; i < 3; i++) {
                    if (matrix[i][0].equals("X") && matrix[i][0].equals(matrix[i][1]) && matrix[i][0].equals(matrix[i][2])) {
                        winX = true;
                    } else if (matrix[i][0].equals("O") && matrix[i][0].equals(matrix[i][1]) && matrix[i][0].equals(matrix[i][2])) {
                        winO = true;

                    } else if (matrix[0][i].equals("X") && matrix[0][i].equals(matrix[1][i]) && matrix[0][i].equals(matrix[2][i])) {
                        winX = true;
                    } else if (matrix[0][i].equals("O") && matrix[0][i].equals(matrix[1][i]) && matrix[0][i].equals(matrix[2][i])) {
                        winO = true;
                    }

                }
                if (matrix[1][1].equals("X")) {
                    if (matrix[1][1].equals(matrix[0][0]) && matrix[1][1].equals(matrix[2][2])) {
                        winX = true;
                    } else if (matrix[1][1].equals(matrix[0][2]) && matrix[1][1].equals(matrix[2][0])) {
                        winX = true;
                    }
                }
                if (matrix[1][1].equals("O")) {
                    if (matrix[1][1].equals(matrix[0][0]) && matrix[1][1].equals(matrix[2][2])) {
                        winO = true;
                    } else if (matrix[1][1].equals(matrix[0][2]) && matrix[1][1].equals(matrix[2][0])) {
                        winO = true;
                    }
                }
            }
            if (winX) {
                System.out.print("X wins");
                break;
            } else if (winO) {
                System.out.print("O wins");
                break;
            } else if (countIfX + countIfO == 9 && !winO && !winX){
                System.out.print("Draw");
                break;
            }

        }


    }
}
