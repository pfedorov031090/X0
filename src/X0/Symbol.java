package X0;

public enum Symbol {
    X("|X|"), O("|O|"), EMPTY("|_|");

    private String psevdonim;

    Symbol(String psevdonim) {
        this.psevdonim = psevdonim;
    }

    @Override
    public String toString() {
        return psevdonim;
    }
}
