package X0;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(Symbol[][] gameField, Symbol symbol) {
        super(gameField, symbol);
    }

    @Override
    public void makeStep() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter row");
        int row = scn.nextInt();
        System.out.println("Enter col");
        int col = scn.nextInt();
        if (row < getGameField().length && col < getGameField().length && getGameField()[row][col].equals(Symbol.EMPTY)) {
                getGameField()[row][col] = getSymbol();
        }
        else {
            System.out.println("Ошибка! сделайте шаг в другую ячейку");
            makeStep();
        }
    }
}
