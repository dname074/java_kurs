import java.util.Objects;

public class StackNode<T> {
    private StackNode<T> next;
    private T value;

    public StackNode(T value, StackNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public StackNode<T> getNext() {
        return next;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StackNode<?> node = (StackNode<?>) o;
        return Objects.equals(next, node.next) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, value);
    }
}
