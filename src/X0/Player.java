package X0;

public class Player {
    private final Symbol[][] gameField;
    private final Symbol symbol;

    public Player(Symbol[][] gameField, Symbol symbol) {
        this.gameField = gameField;
        this.symbol = symbol;
    }

    public void makeStep(){
        System.out.println("Нужно переопределить метод makeStep");
    }

    public Symbol[][] getGameField() {
        return gameField;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
