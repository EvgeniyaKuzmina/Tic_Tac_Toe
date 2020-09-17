package tictactoe;

import java.util.Scanner;


public class Main {


    public static void main(String[] args)  {
        //System.out.println("     ");
        //System.out.println("     ");
        //System.out.println("     ");
        // write your code here
        Scanner scanner = new Scanner(System.in);




        char[] array = new char[9];

        String symbol = scanner.next();

        String[][] matrix = new String[3][3];

        array = symbol.toCharArray();
        int i = 0;

        System.out.println("---------");

        System.out.print("| ");

        while (i < 3) {
            System.out.print(array[i] + " ");
            matrix[0][i] = String.valueOf(array[i]);
            i++;
        }
        System.out.println("| ");
        System.out.print("| ");

        while (i < 6) {
            System.out.print(array[i] + " ");

            matrix[1][i - 3] = String.valueOf(array[i]);
            i++;
        }
        System.out.println("| ");

        System.out.print("| ");

        while (i < 9) {
            System.out.print(array[i] + " ");
            matrix[2][i - 6] = String.valueOf(array[i]);
            i++;
        }
        System.out.println("| ");
        System.out.println("---------");

        System.out.println("Enter the coordinates");

        int coordinate1 = 0;
        int coordinate2 = 0;

       // String input = scanner.nextLine();
        boolean result = false;
        String answer = null;


            //coordinate1 = scanner.nextInt();
            //coordinate2 = scanner.nextInt();



            while (true) {
                String string = scanner.nextLine();

                 if (scanner.hasNextInt()) {
                    coordinate1 = scanner.nextInt();
                    coordinate2 = scanner.nextInt();

                    if (coordinate1 < 1 || coordinate1 > 3 || coordinate2 < 1 || coordinate2 > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        System.out.println("Enter the coordinates");
                    } else if (coordinate1 == 1) {

                        if (coordinate2 == 1 && !matrix[2][0].equals("X") && !matrix[2][0].equals("O")) {
                            matrix[2][0] = "X";
                            result = true;

                        } else if (coordinate2 == 2 && !matrix[1][0].equals("X") && !matrix[1][0].equals("O")) {
                            matrix[1][0] = "X";
                            result = true;

                        } else if (coordinate2 == 3 && !matrix[0][0].equals("X") && !matrix[0][0].equals("O")) {
                            matrix[0][0] = "X";
                            result = true;

                        } else {
                            System.out.println("This cell is occupied! Choose another one! \nEnter the coordinates");
                        }

                    } else if (coordinate1 == 2) {

                        if (coordinate2 == 1 && !matrix[2][1].equals("X") && !matrix[2][1].equals("O")) {
                            matrix[2][1] = "X";
                            result = true;
                        } else if (coordinate2 == 2 && !matrix[1][1].equals("X") && !matrix[1][1].equals("O")) {
                            matrix[1][1] = "X";
                            result = true;
                        } else if (coordinate2 == 3 && !matrix[0][1].equals("X") && !matrix[0][1].equals("O")) {
                            matrix[0][1] = "X";
                            result = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one! \nEnter the coordinates");
                        }

                    } else if (coordinate1 == 3) {
                        if (coordinate2 == 1 && !matrix[2][2].equals("X") && !matrix[2][2].equals("O")) {
                            matrix[2][2] = "X";
                            result = true;
                        } else if (coordinate2 == 2 && !matrix[1][2].equals("X") && !matrix[1][2].equals("O")) {
                            matrix[1][2] = "X";
                            result = true;
                        } else if (coordinate2 == 3 && !matrix[0][2].equals("X") && !matrix[0][2].equals("O")) {
                            matrix[0][2] = "X";
                            result = true;
                        } else {
                            System.out.println("This cell is occupied! Choose another one! \nEnter the coordinates");
                        }
                    }
                 } else if (!scanner.hasNextInt()){

                     System.out.println("You should enter numbers!");
                     System.out.println("Enter the coordinates");
                }

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
            boolean impossible = false;
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

            if (Math.abs(countIfX - countIfO) > 1) {
                impossible = true;
            } else if (countIfX + countIfO == 9 || countIfX + countIfO + empty == 9) {
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
                    impossible = winX && winO;
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
            if (impossible) {
                System.out.print("Impossible");
            } else if (winX) {
                System.out.print("X wins");

            } else if (winO) {
                System.out.print("O wins");
            } else if (empty > 0) {
                System.out.print("Game not finished");
            } else {
                System.out.print("Draw");
            }


        }
    }
