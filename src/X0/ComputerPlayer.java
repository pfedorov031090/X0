package X0;

public class ComputerPlayer extends Player{
    public ComputerPlayer(Symbol[][] gameField, Symbol symbol) {
        super(gameField, symbol);
    }

    @Override
    public void makeStep() {
        try{
            Thread.sleep(1000);
        }catch (Exception e){}

        int row = (int)(Math.random()*getGameField().length);
        int col = (int)(Math.random()*getGameField().length);
        if (getGameField()[row][col].equals(Symbol.EMPTY)) {
            getGameField()[row][col] = getSymbol();
        }
        else {
            makeStep();
        }
    }
}
