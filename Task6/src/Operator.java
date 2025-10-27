public enum Operator {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY_CHAR('*'),
    DIVIDE_CHAR('/');

    private final char sign;

    Operator (char sign) {
        this.sign = sign;
    }

    public static Operator fromChar(char sign) {
        for (Operator value : Operator.values()) {
            if (value.sign == sign){
                return value;
            }
        }
        throw new WrongOperatorException("Podaj poprawny operator");
    }
}
