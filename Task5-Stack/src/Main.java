public class Main {
    public static void main(String[] args) {
        MyStack<String> stringMyStack = new MyStack<>();
        System.out.println("Stack stringow");
        stringMyStack.push("A");
        stringMyStack.push("A");
        stringMyStack.printAll();
        stringMyStack.removeAll("A");
        stringMyStack.printAll();

        MyStack<Point> pointMyStack = new MyStack<>();
        Point point = new Point(6,2);
        pointMyStack.push(new Point(5, 3));
        pointMyStack.push(point);
        pointMyStack.printAll();
        pointMyStack.remove(point);
        pointMyStack.printAll();
    }
}
