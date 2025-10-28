public class Main {
    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>();
        System.out.println("Stack stringow");
        stringStack.push("A");
        stringStack.push("A");
        stringStack.printAll();
        stringStack.removeAll("A");
        stringStack.printAll();

        Stack<Point> pointStack = new Stack<>();
        Point point = new Point(6,2);
        pointStack.push(new Point(5, 3));
        pointStack.push(point);
        pointStack.printAll();
        pointStack.remove(point);
        pointStack.printAll();
    }
}
