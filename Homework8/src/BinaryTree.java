public class BinaryTree {
    private Node root;

    public BinaryTree() {
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        insertKey(root, key);
    }

    private void insertKey(Node root, int key) {
        if (key == root.getKey()) {
            return;
        }

        if (key > root.getKey()) {
            if (root.hasRightChild()) {
                insertKey(root.getRightChild(), key);
            } else {
                root.setRightChild(new Node(key));
            }
            return;
        }

        if (root.hasLeftChild()) {
            insertKey(root.getLeftChild(), key);
        } else {
            root.setLeftChild(new Node(key));
        }
    }

    public boolean contains(int key) {
        if (root == null) {
            return false;
        }

        return containsKey(root, key);
    }

    private boolean containsKey(Node root, int key) {
        if (key == root.getKey()) {
            return true;
        }

        if (key > root.getKey()) {
            if (root.hasRightChild()) {
                return containsKey(root.getRightChild(), key);
            }
            return false;
        }

        if (root.hasLeftChild()) {
            return containsKey(root.getLeftChild(), key);
        }
        return false;
    }

    public void print() {
        printTree(root);
    }

    private void printTree(Node root) {
        if (root.hasLeftChild()) {
            printTree(root.getLeftChild());
        }
        System.out.println(root.getKey());
        if (root.hasRightChild()) {
            printTree(root.getRightChild());
        }
    }
}
