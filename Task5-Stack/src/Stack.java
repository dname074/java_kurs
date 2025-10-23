public class Stack {
    private Node head;

    protected void printAll() {
        if (isStackEmpty()) {
            emptyStackMessage();
        } else {
            System.out.print("[" + head.getValue());
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
                System.out.print("," + temp.getValue());
            }
            System.out.println("]");
        }
    }

    protected void push(int newValue) {
        head = new Node(newValue, head);
    }

    protected int pop() {
        if (isStackEmpty()) {
            emptyStackMessage();
        }
        int removedValue = head.getValue();
        head = head.getNext();
        return removedValue;
    }

    // FIFO implementation
    protected void pushLast(int newValue) {
        if (isStackEmpty()) {
            push(newValue);
        } else {
            Node temp = head;
            while (temp.getNext()!=null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(newValue, null));
        }
    }

    protected Integer popLast() {
        if (isStackEmpty()) {
            emptyStackMessage();
        } else {
            Node temp = head;
            int removedValue;
            while(temp.getNext()!=null) {
                if (temp.getNext().getNext() == null) {
                    removedValue = temp.getNext().getValue();
                    temp.setNext(null);
                    return removedValue;
                } else {
                    temp = temp.getNext();
                }
            }
        }

        return null;
    }

    protected void removeByIndex(int index) {
        if (isStackEmpty()) {
            emptyStackMessage();
        } else {
            Node temp = head;
            for (int i=0; i<index-1; i++) {
                if (head.getNext()!=null) {
                    temp = temp.getNext();
                }
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

    protected void remove(int value) {
        if (isStackEmpty()) {
            emptyStackMessage();
        } else {
            Node temp = head;

            if (temp.getValue() == value) {
                head = temp.getNext();
            } else {
                while (temp.getNext()!=null) {
                    if (temp.getNext().getValue() == value) {
                        temp.setNext(temp.getNext().getNext());
                        break;
                    }
                    temp = temp.getNext();
                }
            }
        }
    }

    private void emptyStackMessage() {
        System.out.println("Stos jest pusty");
    }

    private boolean isStackEmpty() {
        return head == null;
    }
}
