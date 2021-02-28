package X0;

public class ComputerKiller extends Player {
    public ComputerKiller(Symbol[][] gameField, Symbol symbol) {
        super(gameField, symbol);
    }

    public void makeStep() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        int count = (int) (Math.random()*2);

        if (count == 1) {
            for (int i = 0; i < getGameField().length; i++) {
                for (int j = 0; j < getGameField().length; j++) {
                    if (getGameField()[i][j] == Symbol.EMPTY) {

                        getGameField()[i][j] = getSymbol();
                        return;
                    }
                }
            }
        }
        else if (count == 0){
            for (int i = 0; i < getGameField().length; i++) {
                for (int j = 0; j < getGameField().length; j++) {
                    if (getGameField()[i][j] != Symbol.EMPTY && getGameField()[i][j] != getSymbol()) {
                        getGameField()[i][j] = getSymbol();
                        return;
                    }
                }
            }
                int row = (int) (Math.random() * getGameField().length);
                int col = (int) (Math.random() * getGameField().length);
                getGameField()[row][col] = getSymbol();
            }
        }
    }
