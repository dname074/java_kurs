public class MyStack<T> {
    private StackNode<T> head;

    protected void printAll() {
        if (isStackEmpty()) {
            emptyStackMessage();
            return;
        }
        System.out.print("[" + head.getValue());
        StackNode<T> temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
            System.out.print("," + temp.getValue());
        }
        System.out.println("]");
    }

    protected void push(T newValue) {
        head = new StackNode<>(newValue, head);
    }

    protected T pop() {
        if (isStackEmpty()) {
            emptyStackMessage();
        }
        T removedValue = head.getValue();
        head = head.getNext();
        return removedValue;
    }

    // FIFO implementation
    protected void pushLast(T newValue) {
        if (isStackEmpty()) {
            push(newValue);
            return;
        }
        StackNode<T> temp = head;
        while (temp.getNext()!=null) {
            temp = temp.getNext();
        }
        temp.setNext(new StackNode<>(newValue, null));
    }

    protected void popLast() {
        if (isStackEmpty()) {
            emptyStackMessage();
            return;
        }
        StackNode<T> temp = head;

        while(temp.getNext()!=null) {
            if (temp.getNext().getNext() == null) {
                temp.setNext(null);
            } else {
                temp = temp.getNext();
            }
        }
    }

    protected void removeByIndex(int index) {
        if (isStackEmpty()) {
            emptyStackMessage();
            return;
        }
        StackNode<T> temp = head;
        for (int i=0; i<index-1; i++) {
            if (head.getNext()!=null) {
                temp = temp.getNext();
            }
        }
        temp.setNext(temp.getNext().getNext());
    }

    protected void remove(T value) {
        if (isStackEmpty()) {
            emptyStackMessage();
            return;
        }
        StackNode<T> temp = head;

        while (temp.getNext()!=null) {
            if (temp.getNext().getValue().equals(value)) {
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }

        if (head.getValue().equals(value)) {
            head = temp.getNext();
        }
    }

    protected void clear() {
        head = null;
    }

    protected void removeAll(T value) {
        if (head == null) {
            emptyStackMessage();
            return;
        }
        StackNode<T> temp = head;

        while (temp.getNext() != null) {
            if (temp.getNext().getValue().equals(value)) {
                temp.setNext(temp.getNext().getNext());
                continue;
            }
            temp = temp.getNext();
        }

        if (head.getValue().equals(value)) {
            head = head.getNext();
        }
    }

    private void emptyStackMessage() {
        System.out.println("Stos jest pusty");
    }

    public boolean isStackEmpty() {
        return head == null;
    }
}
