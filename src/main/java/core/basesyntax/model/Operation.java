package core.basesyntax.model;

public enum Operation {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public String getCode() { return code; }

    public static Operation fromCode(String code) {
        switch (code) {
            case "b":
                return BALANCE;
            case "s":
                return SUPPLY;
            case "p":
                return PURCHASE;
            case "r":
                return RETURN;
            default:
                throw new RuntimeException("Bad operation type: " + code);
        }
    }
}
