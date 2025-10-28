public class Main {
    public static void main(String[] args) {
        char operator = '/';
        char operator2 = '*';
        int x = 5;
        int y = 2;
        int z = 1;

        OperationExecutor divideOperation = OperationExecutor.fromOperator(operator);
        OperationExecutor multiplyOperation = OperationExecutor.fromOperator(operator2);

        System.out.printf("Dzielenie %d i %d: %d\n",x ,z ,divideOperation.calculate(x,z));
        System.out.printf("Mnozenie %d i %d: %d",x ,y ,multiplyOperation.calculate(x,y));
    }
}


