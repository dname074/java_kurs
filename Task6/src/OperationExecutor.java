public enum OperationExecutor implements MathOperation {
    ADD(addValues(), Operator.PLUS),
    SUBSTRACTION(substractValues(), Operator.MINUS),
    MULTIPLY(multiplyValues(), Operator.MULTIPLY_CHAR),
    DIVIDE(divideValues(), Operator.DIVIDE_CHAR);

    private final MathOperation action;
    private final Operator operator;

    OperationExecutor(MathOperation action, Operator operator) {
        this.action = action;
        this.operator = operator;
    }

    @Override
    public int calculate(int x, int y) {
        return action.calculate(x, y);
    }

    private static MathOperation addValues() {
        return (x,y) -> x + y;
    }

    private static MathOperation substractValues() {
        return (x,y) -> x-y;
    }

    private static MathOperation multiplyValues() {
        return (x,y) -> x*y;
    }

    private static MathOperation divideValues() {
        return (x,y) -> {
            if (y == 0) {
                throw new IllegalArgumentException("Nie mozna dzielic przez 0");
            }
            return x/y;
        };
    }

    public static OperationExecutor fromOperator(char charOperator) {
        Operator operator = Operator.fromChar(charOperator);
        for (OperationExecutor value : OperationExecutor.values()) {
            if (value.operator == operator) {
                return value;
            }
        }
        throw new UnknownOperationException("Nie ma działania dla podanego operatora");
    }
}
