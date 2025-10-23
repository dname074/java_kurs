public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("LIFO testy");
        stack.push(5);
        stack.push(3);
        stack.push(8);
        stack.push(2);
        System.out.println(stack.pop());
        stack.printAll();

        System.out.println("FIFO testy");
        stack.pushLast(10);
        stack.pushLast(3);
        stack.printAll();
        System.out.println(stack.popLast());
        stack.printAll();
        stack.removeByIndex(2); // 5 pop
        stack.printAll();
        stack.pushLast(15);
        stack.printAll();
        stack.remove(10);
        stack.printAll();
    }
}
