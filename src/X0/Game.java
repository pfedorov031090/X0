package X0;

import java.util.Scanner;

public class Game {
    /*
    |_||_||_|
    |_||_||_|
    |_||_||_|
     */

    private final Symbol[][] gameField = new Symbol[3][3];


    public Game(){
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                gameField[i][j] = Symbol.EMPTY;
            }
        }
    }

    public void startGame(){
        int a = 0;
        int b = 1;
        int step = 0;
        Player player1 = null;
        Player player2 = null;
        Scanner scn = new Scanner(System.in);
        System.out.println("1. Человек vs Человек\n" +
                "2. Человек vs Компьютер\n" +
                "3. Компьютер vs Компьютер\n" + "4. Компьютер vs ComputerKiller");
        int input = scn.nextInt();
        switch (input){
            case 1:{
                player1 = new HumanPlayer(gameField, Symbol.X);
                player2 = new HumanPlayer(gameField, Symbol.O);
                break;
            }
            case 2:{
                player1 = new HumanPlayer(gameField, Symbol.X);
                player2 = new ComputerPlayer(gameField, Symbol.O);
                break;
            }
            case 3:{
                player1 = new ComputerPlayer(gameField, Symbol.X);
                player2 = new ComputerPlayer(gameField, Symbol.O);
                break;
            }
            case 4:
                player1 = new ComputerPlayer(gameField, Symbol.X);
                player2 = new ComputerKiller(gameField, Symbol.O);
        }
        while(!winBoth() && !win()){
            print();
            if(step++ % 2 == 0 ){
                System.out.println("Ход крестиков");
                player1.makeStep();
            }else{
                System.out.println("Ход ноликов");
                player2.makeStep();
            }
        }
    }

    public void print(){
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                System.out.print(gameField[i][j]);
            }
            System.out.println();
        }
    }

    public boolean winBoth() {
        int count = 0;
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField.length; j++) {
                if (gameField[i][j] == Symbol.EMPTY) {
                    count++;
                }
            }
        }
        if (count == 0) {
            print();
            System.out.println("Ничья!");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean win() {
        int countRaw = 0;
        int countCol = 0;
        Symbol row = Symbol.EMPTY;
        for (int i = 0; i < gameField.length; i++) {
            if (!gameField[0][i].equals(Symbol.EMPTY)
                    && (gameField[0][i] == gameField[1][i] && gameField[0][i] == gameField[2][i])) {
                countRaw++;
                row = gameField[0][i];
            }
        }
        for (int i = 0; i < gameField.length; i++) {
            if (!gameField[i][0].equals(Symbol.EMPTY) && (gameField[i][0] == gameField[i][1] && gameField[i][0] == gameField[i][2])) {
                countCol++;
                row = gameField[i][0];
            }
        }
        if (!gameField[0][0].equals(Symbol.EMPTY) && (gameField[0][0] == gameField[1][1] && gameField[0][0] == gameField[2][2])) {
            countCol++;
            row = gameField[0][0];
        }
        if (!gameField[0][2].equals(Symbol.EMPTY) && (gameField[0][2] == gameField[1][1] && gameField[0][0] == gameField[2][0])) {
            countCol++;
            row = gameField[0][2];
        }
        if ((countRaw == 1 || countCol == 1) && row.equals(Symbol.O)) {
            System.out.println("Победили нолики");
            print();
            return true;
        }
        else if ((countRaw == 1 || countCol == 1) && row.equals(Symbol.X)) {
            System.out.println("Победили крестики");
            print();
            return true;
        }
        else {
            return false;
        }
    }



}
